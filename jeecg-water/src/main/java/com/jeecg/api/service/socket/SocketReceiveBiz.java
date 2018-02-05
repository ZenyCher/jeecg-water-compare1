package com.jeecg.api.service.socket;

import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jeecg.api.util.SpringContextUtils;
import com.jeecg.waterdispenser.entity.WUserDeviceEntity;
import com.jeecg.waterdispenser.entity.WWaterHeartRecord;
import com.jeecg.waterdispenser.entity.WWaterMeterEntity;
import com.jeecg.waterdispenser.service.WUserDeviceServiceI;
import com.jeecg.waterdispenser.service.WWaterHeartRecordServiceI;
import com.jeecg.waterdispenser.service.WWaterMeterServiceI;

/**
 * Created by foreveross_tangyouhua on 2017/6/23.
 * 描述：处理接收数据业务类
 */

public class SocketReceiveBiz {
	
	private static final Logger logger = Logger.getLogger(SocketReceiveBiz.class);
	
    /**
     *读取完整的读表数据
     */
    public void handleReadMeterData(SocketReceiveData receiveData){
        if(receiveData != null){
            if(receiveData.getCommand().equalsIgnoreCase(SocketSendComand.READ)){//处理读表结果
                //读取表类型
                int meterTypeStartIndex = (receiveData.getMeterNo()+receiveData.getCommand()).length();
                receiveData.setMeterType(receiveData.getValidData().substring(meterTypeStartIndex,meterTypeStartIndex+2));
                //读取表状态
                int meterStatusStartIndex = meterTypeStartIndex + 2 ;
                receiveData.setMeterStatus(receiveData.getValidData().substring(meterStatusStartIndex,meterStatusStartIndex+2));
                //读取表累计用水量
                int waterConsumeSumStartIndex = meterStatusStartIndex + 2;
                receiveData.setWaterConsumeSumByHexStr(receiveData.getValidData().substring(waterConsumeSumStartIndex,waterConsumeSumStartIndex+8));
                //读取本次用水量
                int currentConsumeStartIndex = waterConsumeSumStartIndex + 8;
                receiveData.setCurrentConsumeByHexStr(receiveData.getValidData().substring(currentConsumeStartIndex,currentConsumeStartIndex+8));
                //读取剩余水量
                int remainConsumeStartIndex = currentConsumeStartIndex + 8;
                receiveData.setRemainConsumeByHexStr(receiveData.getValidData().substring(remainConsumeStartIndex,remainConsumeStartIndex + 8));
                //读取本次用水开始时间
                int currentStartTimeStartIndex = remainConsumeStartIndex + 8;
                receiveData.setCurrentStartTimeByHexStr(receiveData.getValidData().substring(currentStartTimeStartIndex,currentStartTimeStartIndex+14));
                //读取警告信息
                int warmStartIndex = currentStartTimeStartIndex + 14;
                receiveData.setWarn(receiveData.getValidData().substring(warmStartIndex,warmStartIndex+2));
                WWaterMeterServiceI  service = SpringContextUtils.getWwaterMeterService();
                WWaterMeterEntity entity = service.findUniqueByProperty(WWaterMeterEntity.class, "waterId", DataUtils.reverseStr(receiveData.getMeterNo()));
                //剩余水量
                int lessWaterNum = receiveData.getRemainConsume();
                entity.setWaterSurplus(lessWaterNum);
                entity.setWaterCurrent(receiveData.getCurrentConsume());
				service.updateEntitie(entity);
				
				//读水记录表新增记录
				WWaterHeartRecordServiceI  heartService = SpringContextUtils.getWaterHeartRecordServiceI();
				WWaterHeartRecord heartRecord = new WWaterHeartRecord();
				heartRecord.setMeterNo(DataUtils.reverseStr(receiveData.getMeterNo()));
				heartRecord.setLessWater(entity.getWaterSurplus());
				heartRecord.setSumWater(Integer.parseInt(receiveData.getWaterConsumeSumByHexStr()));
				heartRecord.setCurrentWater(entity.getWaterCurrent());
				heartRecord.setUpdateTime(new Date());
				heartRecord.setWaterStatus(receiveData.getMeterStatus());
				heartService.save(heartRecord);
				logger.info("保存剩余水量：" + heartService);
				
				//将最新的开关状态更新到userDevice表中
				WWaterMeterServiceI  waterMeterService = SpringContextUtils.getWwaterMeterService();
				WWaterMeterEntity waterMeterEntity = waterMeterService.findUniqueByProperty(WWaterMeterEntity.class, "waterId", DataUtils.reverseStr(receiveData.getMeterNo()));
				waterMeterEntity.setWaterValue("00".equals(receiveData.getMeterStatus())? 0:1);
				try {
					waterMeterService.updateEntitie(waterMeterEntity);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				//检查是否有告警
				Map<String , Object> map = heartService.findOneForJdbc("select * from w_water_heartrecord where updateTime>=DATE_SUB(NOW(),INTERVAL 5 MINUTE) ORDER BY updateTime DESC limit 1;", null);
				if(null != map) {
					//5分钟内 最开始的一条记录
					String lessSum = (Integer)map.get("lessWater") + "";
					try {
						if(Integer.parseInt(lessSum) - (heartRecord.getLessWater()) >20){
							//告警
			            	if(null != waterMeterEntity) {
			            		//设置告警
			            		waterMeterEntity.setWaterValue(1);
			            	}
			            	waterMeterService.save(waterMeterEntity);
			            	logger.info("触发告警.....");
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
                logger.debug("SocketReceiveBiz:"+receiveData.toString());
            }
        }
    }
}
