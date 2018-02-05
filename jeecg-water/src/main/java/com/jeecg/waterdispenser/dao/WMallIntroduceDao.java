package com.jeecg.waterdispenser.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Sql;

import com.jeecg.waterdispenser.entity.WMallIntroduceEntity;


@MiniDao
public interface WMallIntroduceDao {
	
	@Arguments("mall_id")
 	@Sql("select * from w_mall_introduce where mall_id=:mall_id ") 
	WMallIntroduceEntity getSeeWmllIntroduce(String mall_id);
}
