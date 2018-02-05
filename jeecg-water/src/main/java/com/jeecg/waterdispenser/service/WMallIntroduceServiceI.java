package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WMallIntroduceEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WMallIntroduceServiceI extends CommonService{
	
 	public void delete(WMallIntroduceEntity entity) throws Exception;
 	
 	public Serializable save(WMallIntroduceEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WMallIntroduceEntity entity) throws Exception;
 	
 	public WMallIntroduceEntity seeWMallIntroduce(String mall_id) throws Exception;
 	
}
