package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WGiftEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WGiftServiceI extends CommonService{
	
 	public void delete(WGiftEntity entity) throws Exception;
 	
 	public Serializable save(WGiftEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WGiftEntity entity) throws Exception;
 	
 	/**
	 * 自定义按钮-[上架]业务处理
	 * @param id
	 * @return
	 */
	 public void doShelvesBus(WGiftEntity t) throws Exception;
 	/**
	 * 自定义按钮-[下架]业务处理
	 * @param id
	 * @return
	 */
	 public void doTheShelfBus(WGiftEntity t) throws Exception;
}
