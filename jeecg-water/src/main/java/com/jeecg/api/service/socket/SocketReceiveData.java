package com.jeecg.api.service.socket;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.util.TextUtils;
import org.apache.log4j.Logger;

/**
 * Created by foreveross_tangyouhua on 2017/6/1.
 * 描述：socket
 */

public class SocketReceiveData {
	
	private static final Logger logger = Logger.getLogger(SocketReceiveData.class);
	
    /**
     * 响应数据包包头
     */
    public final static String HEADER_DATA = "SSSSB"; //0x53 53 53 53 42H
    /**
     * 响应数据包包尾
     */
    public final static String END_DATA = "E"; //0x45H
    /**
     * 表名
     */
    private String meterNo;
    /**
     * 指令
     */
    private String command;
    /**
     * 有效数据
     */
    private String validData;
    /**
     * 校验数
     */
    private String crcData;
    /**
     * 表类型
     */
    private String meterType;
    /**
     * 表状态
     */
    private String meterStatus;
    /**
     * 表当前累计用水量 (整数)
     */
    private String waterConsumeSumByHexStr;
    /**
     * 表当前累计用水量，整数
     */
    private int waterConsumeSum;
    /**
     * 本次用水量
     */
    private String currentConsumeByHexStr;
    /**
     * 本次用水量 整数
     */
    private int currentConsume;

    /**
     * 本次用水开始时间 十六进制字符串
     */
    private String currentStartTimeByHexStr;
    /**
     * 本次用水开始时间
     */
    private Date currentStartTime;
    
    /**
     * 剩余水量
     */
    private String remainConsumeByHexStr;
    
    /**
     * 剩余水量，整数
     */
    private Integer remainConsume;
    
    

    /**
     * 告警
     *
     */
    private String warn;

    /**
     * 水表编号反序
     * @return
     */
    public String getMeterNo() {
        return meterNo;
    }

    public void setMeterNo(String meterNo) {
//        this.meterNo = DataUtils.reverseStr(meterNo);
    	this.meterNo = meterNo;
    }

    public void setValidData(String validData) {
        this.validData = validData;
    }

    public void setCrcData(String crcData) {
        this.crcData = crcData;
    }


    public String getValidData() {
        return validData;
    }

    public String getCrcData() {
        return crcData;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getMeterType() {
        return meterType;
    }

    public String getMeterStatus() {
        return meterStatus;
    }

    public String getWaterConsumeSumByHexStr() {
        return waterConsumeSumByHexStr;
    }
    
    public Integer getRemainConsume() {
    	remainConsume = Integer.parseInt(DataUtils.reverseStr(remainConsumeByHexStr));
    	return remainConsume;
    }
    
    public String getRemainConsumeByHexStr() {
    	return remainConsumeByHexStr;
    }

    public String getCurrentConsumeByHexStr() {
        return currentConsumeByHexStr;
    }



    public String getWarn() {
        return warn;
    }

    public void setMeterType(String meterType) {
        this.meterType = meterType;
    }

    public void setMeterStatus(String meterStatus) {
        this.meterStatus = meterStatus;
    }

    public void setWaterConsumeSumByHexStr(String waterConsumeSumByHexStr) {
        this.waterConsumeSumByHexStr = DataUtils.reverseStr(waterConsumeSumByHexStr);
    }

    public void setCurrentConsumeByHexStr(String currentConsumeByHexStr) {
        this.currentConsumeByHexStr = currentConsumeByHexStr;
    }

	public void setRemainConsume(Integer remainConsume) {
		this.remainConsume = remainConsume;
	}
	
	public void setRemainConsumeByHexStr(String remainConsumeByHexStr) {
		this.remainConsumeByHexStr = remainConsumeByHexStr;
	}

	
    public void setWarn(String warn) {
        this.warn = warn;
    }

    public int getWaterConsumeSum() {
        waterConsumeSum = Integer.parseInt(DataUtils.reverseStr(waterConsumeSumByHexStr));
        return waterConsumeSum;
    }

    public int getCurrentConsume() {
        currentConsume = Integer.parseInt(DataUtils.reverseStr(currentConsumeByHexStr));
        return currentConsume;
    }


    public String getCurrentStartTimeByHexStr() {
        return currentStartTimeByHexStr;
    }

    public Date getCurrentStartTime() {
        String date = DataUtils.reverseStr(currentStartTimeByHexStr);
        if(!TextUtils.isEmpty(date)){
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            try {
               return currentStartTime = format.parse(date);
            } catch (ParseException e) {
                logger.debug("getCurrentStartTime:"+e.toString());
            }
        }
        return currentStartTime;
    }

    public void setCurrentStartTimeByHexStr(String currentStartTimeByHexStr) {
        this.currentStartTimeByHexStr = currentStartTimeByHexStr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("表编号;").append(meterNo).append("  表指令:").append(command).append("  表类型:").append(meterType)
        .append("  表状态:").append(meterStatus).append("  表当前累计用水量:").append(getWaterConsumeSum()).append("   本次用水量:").append(getCurrentConsume())
        .append("剩余用水量").append(getRemainConsume()).append("  本次用水开始时间").append(currentStartTime).append(" 告警:").append(warn);
        return sb.toString();
    }
}
