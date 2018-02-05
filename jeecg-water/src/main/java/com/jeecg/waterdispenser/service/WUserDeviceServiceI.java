package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WUserDeviceEntity;

import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface WUserDeviceServiceI extends CommonService{
	
 	public void delete(WUserDeviceEntity entity) throws Exception;
 	
 	public Serializable save(WUserDeviceEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WUserDeviceEntity entity) throws Exception;
 	
 	public List<Map<String, Object>> selectUserDeviceByMemberPhone(String memberPhone) throws Exception;
 	
 	public WUserDeviceEntity saveUserDeviceByPhoneAndWaterId(String memberPhone,String waterId) throws Exception;
 	
 	public Map<String, Object> saveUserDeviceByMemberId(String memberId) throws Exception;
 	
}
