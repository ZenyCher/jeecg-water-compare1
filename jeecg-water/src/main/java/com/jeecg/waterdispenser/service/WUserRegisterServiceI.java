package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WUserRegisterEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface WUserRegisterServiceI extends CommonService{
	
 	public void delete(WUserRegisterEntity entity) throws Exception;
 	
 	public Serializable save(WUserRegisterEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WUserRegisterEntity entity) throws Exception;
 	
 	/**
 	 * 根据注册用户手机号码查询该用户的信息
 	 * @param registerPhone
 	 * @throws Exception
 	 */
 	public Map<String, Object> selectUserRegisterByRegisterPhone(String registerPhone) throws Exception;
 	
 	/**
	 * 自定义按钮-[激活]业务处理
	 * @param id
	 * @return
	 */
	 public void doActivationBus(WUserRegisterEntity t) throws Exception;
 	/**
	 * 自定义按钮-[禁用]业务处理
	 * @param id
	 * @return
	 */
	 public void doDisableBus(WUserRegisterEntity t) throws Exception;
	 
	 public List<Map<String, Object>> getRegisterBymemberId(String memberId) throws Exception;
	 
	 public List<WUserRegisterEntity> selectEntity() throws Exception;
	 
	 public List<Map<String, Object>> selectUserAndErectorByPhone(String phone)throws Exception;
	 
}
