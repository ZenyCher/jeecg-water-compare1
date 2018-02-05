package com.jeecg.waterdispenser.service.impl;
import com.jeecg.waterdispenser.service.WWaterMeterServiceI;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

import com.jeecg.waterdispenser.dao.WWaterMeterDao;
import com.jeecg.waterdispenser.entity.WWaterMeterEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;

import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("wWaterMeterService")
@Transactional
public class WWaterMeterServiceImpl extends CommonServiceImpl implements WWaterMeterServiceI {

	@Autowired
	private WWaterMeterDao waterMeterDao;
	
 	public void delete(WWaterMeterEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(WWaterMeterEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(WWaterMeterEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	public Map<String, Object> getWaterMeterByWaterId(String waterId) throws Exception {
 		StringBuffer sb = new StringBuffer();
 		sb.append("select * from w_water_meter where water_id = ? ");
 		Map<String, Object> map = commonDao.findOneForJdbc(sb.toString(), waterId);
 		return map;
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(WWaterMeterEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(WWaterMeterEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(WWaterMeterEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(WWaterMeterEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("create_name", t.getCreateName());
		map.put("create_by", t.getCreateBy());
		map.put("create_date", t.getCreateDate());
		map.put("update_name", t.getUpdateName());
		map.put("update_by", t.getUpdateBy());
		map.put("update_date", t.getUpdateDate());
		map.put("sys_org_code", t.getSysOrgCode());
		map.put("sys_company_code", t.getSysCompanyCode());
		map.put("bpm_status", t.getBpmStatus());
		map.put("water_id", t.getWaterId());
		map.put("water_num", t.getWaterNum());
		map.put("water_start_time", t.getWaterStartTime());
		map.put("member_phone", t.getMemberPhone());
		map.put("member_name", t.getMemberName());
		map.put("water_use", t.getWaterUse());
		map.put("water_current", t.getWaterCurrent());
		map.put("water_surplus", t.getWaterSurplus());
		map.put("water_state", t.getWaterState());
		map.put("water_value", t.getWaterValue());
		map.put("water_recharge", t.getWaterRecharge());
		map.put("member_id", t.getMemberId());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,WWaterMeterEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{bpm_status}",String.valueOf(t.getBpmStatus()));
 		sql  = sql.replace("#{water_id}",String.valueOf(t.getWaterId()));
 		sql  = sql.replace("#{water_num}",String.valueOf(t.getWaterNum()));
 		sql  = sql.replace("#{water_start_time}",String.valueOf(t.getWaterStartTime()));
 		sql  = sql.replace("#{member_phone}",String.valueOf(t.getMemberPhone()));
 		sql  = sql.replace("#{member_name}",String.valueOf(t.getMemberName()));
 		sql  = sql.replace("#{water_use}",String.valueOf(t.getWaterUse()));
 		sql  = sql.replace("#{water_current}",String.valueOf(t.getWaterCurrent()));
 		sql  = sql.replace("#{water_surplus}",String.valueOf(t.getWaterSurplus()));
 		sql  = sql.replace("#{water_state}",String.valueOf(t.getWaterState()));
 		sql  = sql.replace("#{water_value}",String.valueOf(t.getWaterValue()));
 		sql  = sql.replace("#{water_recharge}",String.valueOf(t.getWaterRecharge()));
 		sql  = sql.replace("#{member_id}",String.valueOf(t.getMemberId()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
 	
 	/**
	 * 执行JAVA增强
	 */
 	private void executeJavaExtend(String cgJavaType,String cgJavaValue,Map<String,Object> data) throws Exception {
 		if(StringUtil.isNotEmpty(cgJavaValue)){
			Object obj = null;
			try {
				if("class".equals(cgJavaType)){
					//因新增时已经校验了实例化是否可以成功，所以这块就不需要再做一次判断
					obj = MyClassLoader.getClassByScn(cgJavaValue).newInstance();
				}else if("spring".equals(cgJavaType)){
					obj = ApplicationContextUtil.getContext().getBean(cgJavaValue);
				}
				if(obj instanceof CgformEnhanceJavaInter){
					CgformEnhanceJavaInter javaInter = (CgformEnhanceJavaInter) obj;
					javaInter.execute("w_water_meter",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}

	@Override
	public WWaterMeterEntity findWaterMeterByWaterId(String waterId) {
		return waterMeterDao.getWaterMeterByWaterId(waterId);
	}
}