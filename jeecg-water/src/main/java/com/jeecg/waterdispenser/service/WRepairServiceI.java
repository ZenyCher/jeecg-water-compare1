package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WRepairEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WRepairServiceI extends CommonService{
	
 	public void delete(WRepairEntity entity) throws Exception;
 	
 	public Serializable save(WRepairEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WRepairEntity entity) throws Exception;
 	
}
