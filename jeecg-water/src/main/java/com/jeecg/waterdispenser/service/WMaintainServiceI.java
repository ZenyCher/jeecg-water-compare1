package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WMaintainEntity;

import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface WMaintainServiceI extends CommonService{
	
 	public void delete(WMaintainEntity entity) throws Exception;
 	
 	public Serializable save(WMaintainEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WMaintainEntity entity) throws Exception;
 	
 	public List<Map<String, Object>> getMaintainByDeviceAndMemberPhone(String deviceId,String memberPhone) throws Exception;
 	
 	public List<Map<String, Object>> getMaintainByRegisterId(String registerId) throws Exception;
 	
}
