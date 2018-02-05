package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WRechargeEntity;

import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface WRechargeServiceI extends CommonService{
	
 	public void delete(WRechargeEntity entity) throws Exception;
 	
 	public Serializable save(WRechargeEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WRechargeEntity entity) throws Exception;
 	
 	/**
 	 * 根据id查询当前水表是否需要写水
 	 * @param meterNo
 	 * @return
 	 */
 	public WRechargeEntity getWriteWaterInfoById(String meterNo);
 	
 	/**
 	 * 根据联系方式查询未写入水表的累计充值水量
 	 * @param memberPhone
 	 * @return
 	 */
 	public List<WRechargeEntity> listWaterCountByPhone(String memberPhone);
 	
 	/**
 	 * 根据设备id查询充值金额合计和充值水量合计
 	 * @param deviceId
 	 * @return
 	 */
 	public Map<String, Object> getSumWaterByDeviceId(String deviceId);
 	
}
