package com.jeecg.waterdispenser.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Sql;

import com.jeecg.waterdispenser.entity.WUserDeviceEntity;

@MiniDao
public interface WUserDeviceDao {
	
	@Arguments({"memberPhone", "waterId"})
 	@Sql("select * from w_user_device where member_phone=:memberPhone and waterMeter_id=:waterId ") 
	WUserDeviceEntity saveUserDeviceByPhoneAndWaterId(String memberPhone,String waterId);

}
