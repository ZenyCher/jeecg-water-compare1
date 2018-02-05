package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WIntegralEntity;

import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;

public interface WIntegralServiceI extends CommonService{
	
 	public void delete(WIntegralEntity entity) throws Exception;
 	
 	public Serializable save(WIntegralEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WIntegralEntity entity) throws Exception;
 	
 	public List<WIntegralEntity> listWIntegralByMemberPhoneSum(String memberPhone) throws Exception;
 	
 	public List<WIntegralEntity> listWIntegralByMemberPhoneOut(String memberPhone) throws Exception;
 	
}
