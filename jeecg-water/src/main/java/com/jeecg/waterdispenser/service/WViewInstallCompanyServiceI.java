package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WViewInstallCompanyEntity;

import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface WViewInstallCompanyServiceI extends CommonService{
	
 	public void delete(WViewInstallCompanyEntity entity) throws Exception;
 	
 	public Serializable save(WViewInstallCompanyEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WViewInstallCompanyEntity entity) throws Exception;
 	
 	public List<Map<String, Object>> listViewInstallCompany() throws Exception;
 	
}
