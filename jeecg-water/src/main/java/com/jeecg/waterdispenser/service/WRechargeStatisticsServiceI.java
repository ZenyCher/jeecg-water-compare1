package com.jeecg.waterdispenser.service;
import java.io.Serializable;
import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import com.jeecg.waterdispenser.entity.WRechargeStatisticsEntity;

public interface WRechargeStatisticsServiceI extends CommonService{
	
 	public void delete(WRechargeStatisticsEntity entity) throws Exception;
 	
 	public Serializable save(WRechargeStatisticsEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WRechargeStatisticsEntity entity) throws Exception;
 	
 	public List<WRechargeStatisticsEntity> saveStatistics() throws Exception;
 	
 	public String saveString(String member_phone,String sumType) throws Exception;
 	
 	public List<WRechargeStatisticsEntity> saveMemberName(String member_name) throws Exception;
 	
 	public List<WRechargeStatisticsEntity> dayStatistics() throws Exception;
 	
 	public List<WRechargeStatisticsEntity> monthStatistics() throws Exception;
 	
 	public List<WRechargeStatisticsEntity> yaerStatistics() throws Exception;
}
