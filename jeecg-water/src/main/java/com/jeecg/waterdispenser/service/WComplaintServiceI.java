package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WComplaintEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WComplaintServiceI extends CommonService{
	
 	public void delete(WComplaintEntity entity) throws Exception;
 	
 	public Serializable save(WComplaintEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WComplaintEntity entity) throws Exception;
 	
 	/**
	 * 自定义按钮-[问题处理]业务处理
	 * @param id
	 * @return
	 */
	 public void doHandleBus(WComplaintEntity t) throws Exception;
}
