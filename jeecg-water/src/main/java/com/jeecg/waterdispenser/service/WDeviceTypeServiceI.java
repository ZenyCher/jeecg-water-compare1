package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WDeviceTypeEntity;

import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface WDeviceTypeServiceI extends CommonService{
	
 	public void delete(WDeviceTypeEntity entity) throws Exception;
 	
 	public Serializable save(WDeviceTypeEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WDeviceTypeEntity entity) throws Exception;
 	
 	public Map<String, Object> getDeviceTypeById(String id) throws Exception;
 	
 	public List<String> saveDeviceTypeString() throws Exception;
 	
}
