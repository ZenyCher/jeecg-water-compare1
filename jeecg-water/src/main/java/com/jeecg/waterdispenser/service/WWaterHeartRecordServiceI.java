package com.jeecg.waterdispenser.service;

import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.service.CommonService;

public interface WWaterHeartRecordServiceI extends CommonService{
	
	public List<Map<String, Object>> getWWaterHeartByWaterId(String waterId) throws Exception;

}
