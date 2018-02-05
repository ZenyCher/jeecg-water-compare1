package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WOrderEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface WOrderServiceI extends CommonService{
	
 	public void delete(WOrderEntity entity) throws Exception;
 	
 	public Serializable save(WOrderEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WOrderEntity entity) throws Exception;
 	
 	public List<Map<String, Object>> getOrderByMemberPhone(String phone,String type) throws Exception;
 	
}
