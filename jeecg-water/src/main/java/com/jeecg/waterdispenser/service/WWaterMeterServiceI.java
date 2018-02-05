package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WWaterMeterEntity;

import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.Map;

public interface WWaterMeterServiceI extends CommonService{
	
 	public void delete(WWaterMeterEntity entity) throws Exception;
 	
 	public Serializable save(WWaterMeterEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WWaterMeterEntity entity) throws Exception;
 	
 	public Map<String, Object> getWaterMeterByWaterId(String waterId) throws Exception;
 	
 	public WWaterMeterEntity findWaterMeterByWaterId(String waterId);
 	
}
