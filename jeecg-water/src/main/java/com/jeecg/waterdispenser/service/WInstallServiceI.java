package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WInstallEntity;

import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface WInstallServiceI extends CommonService{
	
 	public void delete(WInstallEntity entity) throws Exception;
 	
 	public Serializable save(WInstallEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WInstallEntity entity) throws Exception;
 	
 	public Map<String, Object> selectInstallBydeviceId(String deviceId) throws Exception;
 	
 	public Map<String, String> getInstallByDeviceAndMemberPhone(String deviceId,String memberPhone) throws Exception;
 	
 	public List<Map<String, Object>> getInstallNameByRegisterId(String registerId) throws Exception;
 	
 	public List<Map<String, Object>> getInstallByMemberId(String memberId) throws Exception;
}
