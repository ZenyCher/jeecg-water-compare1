package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WViewDevicePurchaseEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface WViewDevicePurchaseServiceI extends CommonService{
	
 	public void delete(WViewDevicePurchaseEntity entity) throws Exception;
 	
 	public Serializable save(WViewDevicePurchaseEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WViewDevicePurchaseEntity entity) throws Exception;
 	
 	public List<Map<String, Object>> listViewDeviceUser() throws Exception;
 	
}
