package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WViewWaterSurplusEntity;

import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface WViewWaterSurplusServiceI extends CommonService{
	
 	public void delete(WViewWaterSurplusEntity entity) throws Exception;
 	
 	public Serializable save(WViewWaterSurplusEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WViewWaterSurplusEntity entity) throws Exception;
 	
 	public List<Map<String, Object>> listViewWaterSurplus() throws Exception;
 	
}
