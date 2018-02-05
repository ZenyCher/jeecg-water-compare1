package com.jeecg.waterdispenser.dao;

import java.util.Map;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Sql;

@MiniDao
public interface WInstallDao {
	
	@Arguments({"deviceId", "memberPhone"})
 	@Sql("select * from w_install where device_id=:deviceId and instal_phont=:memberPhone ") 
	Map<String,String> getInstallByDeviceAndMemberPhone(String deviceId,String memberPhone);
}
