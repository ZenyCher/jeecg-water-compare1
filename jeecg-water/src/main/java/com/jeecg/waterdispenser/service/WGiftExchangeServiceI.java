package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WGiftExchangeEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface WGiftExchangeServiceI extends CommonService{
	
 	public void delete(WGiftExchangeEntity entity) throws Exception;
 	
 	public Serializable save(WGiftExchangeEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WGiftExchangeEntity entity) throws Exception;
 	
 	public List<Map<String, Object>> getGiftExchangeByListId(List<String> list) throws Exception;
 	
 	public List<Map<String, Object>> resultTableFieldAndValue(String tableField,String value) throws Exception;
 	
}
