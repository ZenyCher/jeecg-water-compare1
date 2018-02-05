package com.jeecg.waterdispenser.dao;

import java.util.List;
import java.util.Map;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Sql;

@MiniDao
public interface WMaintainDao {

	
	@Arguments({"deviceId", "memberPhone"})
 	@Sql("select * from w_maintain where device_id=:deviceId and member_phone=:memberPhone ") 
	List<Map<String,Object>> getMaintainByDeviceAndMemberPhone(String deviceId,String memberPhone);
	
}
