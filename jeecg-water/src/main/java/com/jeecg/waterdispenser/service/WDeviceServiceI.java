package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WDeviceEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface WDeviceServiceI extends CommonService{
	
 	public void delete(WDeviceEntity entity) throws Exception;
 	
 	public Serializable save(WDeviceEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WDeviceEntity entity) throws Exception;
 	
 	public Map<String, Object> selectDeviceByDeviceId(String deviceId) throws Exception;
 	
 	public Boolean selectTheTrue(String deviceCode) throws Exception;
 	
 	public List<Map<String, Object>> selectDeviceByListId(List<String> deviceId) throws Exception;
 	
 	public Long selectByDeviceIdCount(String deviceId) throws Exception; 
 	
}
