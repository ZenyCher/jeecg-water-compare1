package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WWaterStatisticsEntity;

import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface WWaterStatisticsServiceI extends CommonService{
	
 	public void delete(WWaterStatisticsEntity entity) throws Exception;
 	
 	public Serializable save(WWaterStatisticsEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WWaterStatisticsEntity entity) throws Exception;
 	
 	public List<Map<String, Object>> selectWaterByMemberPhone(String phone) throws Exception;
 	
}
