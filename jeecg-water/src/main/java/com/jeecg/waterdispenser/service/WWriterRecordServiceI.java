package com.jeecg.waterdispenser.service;
import org.jeecgframework.core.common.service.CommonService;

import com.jeecg.waterdispenser.entity.WWriterRecordEntity;

import java.io.Serializable;

public interface WWriterRecordServiceI extends CommonService{
	
 	public void delete(WWriterRecordEntity entity) throws Exception;
 	
 	public Serializable save(WWriterRecordEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WWriterRecordEntity entity) throws Exception;
 	
}
