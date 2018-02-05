package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WWaterOpenEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WWaterOpenServiceI extends CommonService{
	
 	public void delete(WWaterOpenEntity entity) throws Exception;
 	
 	public Serializable save(WWaterOpenEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WWaterOpenEntity entity) throws Exception;
 	
}
