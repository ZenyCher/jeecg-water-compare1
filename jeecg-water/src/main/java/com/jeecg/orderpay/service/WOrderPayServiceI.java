package com.jeecg.orderpay.service;
import com.jeecg.orderpay.entity.WOrderPayEntity;

import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.Map;

public interface WOrderPayServiceI extends CommonService{
	
 	public void delete(WOrderPayEntity entity) throws Exception;
 	
 	public Serializable save(WOrderPayEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WOrderPayEntity entity) throws Exception;
 	
 	public Map<String, Object> findEntityByOutTradeNo(String outTradeNo) throws Exception;
 	
}
