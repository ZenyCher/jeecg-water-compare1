package com.jeecg.waterdispenser.dao;

import java.util.List;
import java.util.Map;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;

import com.jeecg.waterdispenser.entity.WUserRegisterEntity;

@MiniDao
public interface WUserRegisterDao {

 	@Sql("select * from w_user_register where register_phone=:phone ") 
	Map<String, Object> saveRegisterPhone(String phone);
 	
 	@ResultType(WUserRegisterEntity.class)
 	@Sql("select * from w_user_register where register_type = 2")
 	List<WUserRegisterEntity> selectEntity();
 	
 	@Arguments("registerPhone")
 	@Sql("select * from w_user_register where register_state = 1 and register_phone=:registerPhone ") 
	Map<String, Object> saveOneForJdbcByPhone(String registerPhone);
}
