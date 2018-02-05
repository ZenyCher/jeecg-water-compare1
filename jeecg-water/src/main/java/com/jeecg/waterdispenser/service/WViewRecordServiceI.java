package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WViewRecordEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WViewRecordServiceI extends CommonService{
	
 	public void delete(WViewRecordEntity entity) throws Exception;
 	
 	public Serializable save(WViewRecordEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WViewRecordEntity entity) throws Exception;
 	
}
