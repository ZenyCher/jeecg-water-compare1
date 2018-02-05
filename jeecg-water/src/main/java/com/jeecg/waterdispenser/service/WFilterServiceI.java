package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WFilterEntity;

import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface WFilterServiceI extends CommonService{
	
 	public void delete(WFilterEntity entity) throws Exception;
 	
 	public Serializable save(WFilterEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WFilterEntity entity) throws Exception;
 	
 	public List<Map<String, Object>> selectFilterByFilterId(List<String> filterId) throws Exception;
 	
 	public Boolean selectTheTrue(String filterCode) throws Exception;
 	
 	public Long selectByFilterIdCount(String filterId) throws Exception;
 	
 	public int updateFilterById(String[] str) throws Exception;
 	
}
