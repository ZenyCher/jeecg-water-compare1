package com.jeecg.waterdispenser.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;

import com.jeecg.waterdispenser.entity.WWaterWarningEntity;

@MiniDao
public interface WWaterWarningDao {
	
	static final Logger logger = Logger.getLogger(WWaterWarningDao.class);
	
 	@Sql("select * from w_water_warning where water_number between '1' and '200' ")
 	List<WWaterWarningEntity> waterNumber();
 	
 	@Arguments("member_name")
 	@ResultType(WWaterWarningEntity.class)
 	@Sql("select * from w_water_warning where member_name = :member_name ")
 	List<WWaterWarningEntity> saveMemberName(String member_name);
}
