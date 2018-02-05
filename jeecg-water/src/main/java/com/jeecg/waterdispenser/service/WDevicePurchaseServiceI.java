package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WDevicePurchaseEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface WDevicePurchaseServiceI extends CommonService{
	
 	public void delete(WDevicePurchaseEntity entity) throws Exception;
 	
 	public Serializable save(WDevicePurchaseEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WDevicePurchaseEntity entity) throws Exception;
 	
 	public List<Map<String, Object>> getDevicePurchaseByListId(List<String> list) throws Exception;
 	
 	public List<Map<String, Object>> resultTableFieldAndValue(String tableField,String value) throws Exception;
}
