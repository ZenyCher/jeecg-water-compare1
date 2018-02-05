package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WDeviceWaterEntity;

import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.Map;

public interface WDeviceWaterServiceI extends CommonService{
	
 	public void delete(WDeviceWaterEntity entity) throws Exception;
 	
 	public Serializable save(WDeviceWaterEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WDeviceWaterEntity entity) throws Exception;
 	
 	public Map<String, Object> selectDeviceWaterById(String deviceId) throws Exception;
 	
}
