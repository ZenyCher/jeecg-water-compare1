package com.jeecg.waterdispenser.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;

import com.jeecg.waterdispenser.entity.WRechargeStatisticsEntity;


@MiniDao
public interface WRechargeStatisticsDao {
	
 	@Sql("select id,member_phone,member_name,sum(recharge_statistics) from w_recharge_statistics GROUP BY  member_phone, member_name ") 
	List<WRechargeStatisticsEntity> saveStatistics();
 	
 	@Arguments({"member_phone", "sumType"})
 	@ResultType(String.class)
 	String saveString(String member_phone,String sumType);
 	
 	@Arguments("member_name")
 	@ResultType(WRechargeStatisticsEntity.class)
 	@Sql("select id,member_phone,member_name,sum(recharge_statistics) from w_recharge_statistics where member_name = :member_name GROUP BY  member_phone, member_name ")
 	List<WRechargeStatisticsEntity> saveMemberName(String member_name);
 	
 	@Sql("select id,member_phone,member_name,sum(recharge_statistics) from w_recharge_statistics where date_format(create_date,'%D')=date_format(now(),'%D') GROUP BY  member_phone, member_name")
 	List<WRechargeStatisticsEntity> dayStatistics();
 	
 	@Sql("select id,member_phone,member_name,sum(recharge_statistics) from w_recharge_statistics where date_format(create_date,'%Y-%m')=date_format(CURDATE(),'%Y-%m') GROUP BY  member_phone, member_name ")
 	List<WRechargeStatisticsEntity> monthStatistics();
 	
 	@Sql("select id,member_phone,member_name,sum(recharge_statistics) from w_recharge_statistics where date_format(create_date,'%Y')=date_format(CURDATE(),'%Y') GROUP BY  member_phone, member_name")
 	List<WRechargeStatisticsEntity> yaerStatistics();
 	
 	
}
