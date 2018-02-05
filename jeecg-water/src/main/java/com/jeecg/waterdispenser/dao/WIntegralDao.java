package com.jeecg.waterdispenser.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Sql;

import com.jeecg.waterdispenser.entity.WIntegralEntity;

@MiniDao
public interface WIntegralDao {
	
	@Arguments("memberPhone")
 	@Sql("select * from w_integral where member_phone=:memberPhone and integral_type = 0 ") 
	List<WIntegralEntity> listWIntegralByMemberPhoneSum(String memberPhone);
	
	@Arguments("memberPhone")
 	@Sql("select * from w_integral where member_phone=:memberPhone and integral_type = 1 ") 
	List<WIntegralEntity> listWIntegralByMemberPhoneOut(String memberPhone);

}
