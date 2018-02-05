package com.jeecg.waterdispenser.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Sql;

import com.jeecg.waterdispenser.entity.WRechargeEntity;

@MiniDao
public interface WRechargeDao {
	@Arguments({"waterId"})
 	@Sql("select * from w_recharge where water_id=:waterId and is_water = 0 ORDER BY recharge_time ASC  limit 1 ") 
	WRechargeEntity getNeedWriteWater(String waterId);
	
	@Arguments({"memberPhone"})
 	@Sql("select * from w_recharge where member_phone = :memberPhone and is_water = 0 ") 
	List<WRechargeEntity> listWaterCountByPhone(String memberPhone);
}
