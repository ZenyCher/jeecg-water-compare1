package com.jeecg.waterdispenser.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Sql;

@MiniDao
public interface WDeviceTypeDao {
	
 	@Sql("select device_type from w_device_type ") 
	List<String> saveDeviceTypeString();
}
