package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WWaterWarningEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;

public interface WWaterWarningServiceI extends CommonService{
	
 	public void delete(WWaterWarningEntity entity) throws Exception;
 	
 	public Serializable save(WWaterWarningEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WWaterWarningEntity entity) throws Exception;
 	
 	public List<WWaterWarningEntity> saveMemberName(String member_name) throws Exception;
 	
 	public List<WWaterWarningEntity> waterNumber() throws Exception;
 	
 	
}
