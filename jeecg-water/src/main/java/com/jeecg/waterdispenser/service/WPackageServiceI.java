package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WPackageEntity;

import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface WPackageServiceI extends CommonService{
	
 	public void delete(WPackageEntity entity) throws Exception;
 	
 	public Serializable save(WPackageEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WPackageEntity entity) throws Exception;
 	
 	public List<Map<String, Object>> selectWpackage()throws Exception;
 	
 	/**
	 * 自定义按钮-[启用]业务处理
	 * @param id
	 * @return
	 */
	 public void doEnableBus(WPackageEntity t) throws Exception;
 	/**
	 * 自定义按钮-[停用]业务处理
	 * @param id
	 * @return
	 */
	 public void doDisableBus(WPackageEntity t) throws Exception;
	 
	 public Map<String, Object> savePackageIdByPachageTye(int type) throws Exception;
	 
	 public Map<String, Object> getPackageById(String id) throws Exception;
	 
 	
}
