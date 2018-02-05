package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WErectorEntity;

import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface WErectorServiceI extends CommonService{
	
 	public void delete(WErectorEntity entity) throws Exception;
 	
 	public Serializable save(WErectorEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WErectorEntity entity) throws Exception;
 	
 	/**
	 * 自定义按钮-[有效]业务处理
	 * @param id
	 * @return
	 */
	 public void doEffectiveBus(WErectorEntity t) throws Exception;
 	/**
	 * 自定义按钮-[无效]业务处理
	 * @param id
	 * @return
	 */
	 public void doInvalidBus(WErectorEntity t) throws Exception;
	 
}
