package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WViewRechargeEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface WViewRechargeServiceI extends CommonService{
	
 	public void delete(WViewRechargeEntity entity) throws Exception;
 	
 	public Serializable save(WViewRechargeEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WViewRechargeEntity entity) throws Exception;
 	
 	public List<Map<String, Object>> listViewRechargee() throws Exception;
 	
}
