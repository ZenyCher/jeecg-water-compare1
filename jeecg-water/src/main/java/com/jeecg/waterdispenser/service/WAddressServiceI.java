package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WAddressEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WAddressServiceI extends CommonService{
	
 	public void delete(WAddressEntity entity) throws Exception;
 	
 	public Serializable save(WAddressEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WAddressEntity entity) throws Exception;
 	
}
