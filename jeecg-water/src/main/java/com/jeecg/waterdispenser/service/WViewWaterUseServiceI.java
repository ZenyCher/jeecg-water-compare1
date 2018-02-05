package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WViewWaterUseEntity;

import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface WViewWaterUseServiceI extends CommonService{
	
 	public void delete(WViewWaterUseEntity entity) throws Exception;
 	
 	public Serializable save(WViewWaterUseEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WViewWaterUseEntity entity) throws Exception;
 	
 	public List<Map<String, Object>> listViewWaterUse() throws Exception;
 	
}
