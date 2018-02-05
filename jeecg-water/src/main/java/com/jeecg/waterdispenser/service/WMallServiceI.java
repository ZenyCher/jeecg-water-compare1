package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WMallEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WMallServiceI extends CommonService{
	
 	public void delete(WMallEntity entity) throws Exception;
 	
 	public Serializable save(WMallEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WMallEntity entity) throws Exception;
 	
 	
}
