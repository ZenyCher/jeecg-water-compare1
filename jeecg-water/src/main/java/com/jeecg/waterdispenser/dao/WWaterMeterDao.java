package com.jeecg.waterdispenser.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Sql;

import com.jeecg.waterdispenser.entity.WWaterMeterEntity;
@MiniDao
public interface WWaterMeterDao {

	@Arguments({"waterId"})
 	@Sql("select * from w_water_meter where water_id=:waterId ") 
	public WWaterMeterEntity getWaterMeterByWaterId(String waterId);
}
