package com.jeecg.waterdispenser.service.impl;
import com.jeecg.waterdispenser.service.WRechargeServiceI;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

import com.jeecg.waterdispenser.dao.WRechargeDao;
import com.jeecg.waterdispenser.entity.WRechargeEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;

import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("wrechargeService")
@Transactional
public class WRechargeServiceImpl extends CommonServiceImpl implements WRechargeServiceI {

	@Autowired
	private WRechargeDao rechargeDao;
	
 	public void delete(WRechargeEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(WRechargeEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(WRechargeEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(WRechargeEntity t) throws Exception{
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
	private void doUpdateBus(WRechargeEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
	
	public List<WRechargeEntity> listWaterCountByPhone(String memberPhone){
//		StringBuffer sb = new StringBuffer();
//		sb.append("select * from w_recharge where is_water = 0 and member_phone = " + memberPhone);
		return rechargeDao.listWaterCountByPhone(memberPhone);
	}
	
	public Map<String, Object> getSumWaterByDeviceId(String deviceId){
		StringBuffer sb = new StringBuffer();
		sb.append("select sum(recharge_sum) as recharge_sum,sum(recharge_count_water) from w_recharge where device_id = ?");
		return commonDao.findOneForJdbc(sb.toString(), deviceId);
	}
	
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(WRechargeEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	@SuppressWarnings("unused")
	private Map<String,Object> populationMap(WRechargeEntity t){
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
		map.put("member_name", t.getMemberName());
		map.put("member_phone", t.getMemberPhone());
		map.put("device_id", t.getDeviceId());
		map.put("device_name", t.getDeviceName());
		map.put("member_address", t.getMemberAddress());
		map.put("recharge_sum", t.getRechargeSum());
		map.put("recharge_time", t.getRechargeTime());
		map.put("recharge_water_count", t.getRechargeWaterCount());
		map.put("is_water", t.getIsWater());
		map.put("recharge_receive_water", t.getRechargeReceiveWater());
		map.put("recharge_count_water", t.getRechargeCountWater());
		map.put("recharge_count_integral", t.getRechargeCountIntegral());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,WRechargeEntity t){
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
 		sql  = sql.replace("#{member_name}",String.valueOf(t.getMemberName()));
 		sql  = sql.replace("#{member_phone}",String.valueOf(t.getMemberPhone()));
 		sql  = sql.replace("#{device_id}",String.valueOf(t.getDeviceId()));
 		sql  = sql.replace("#{device_name}",String.valueOf(t.getDeviceName()));
 		sql  = sql.replace("#{member_address}",String.valueOf(t.getMemberAddress()));
 		sql  = sql.replace("#{recharge_sum}",String.valueOf(t.getRechargeSum()));
 		sql  = sql.replace("#{recharge_time}",String.valueOf(t.getRechargeTime()));
 		sql  = sql.replace("#{recharge_water_count}",String.valueOf(t.getRechargeWaterCount()));
 		sql  = sql.replace("#{is_water}",String.valueOf(t.getIsWater()));
 		sql  = sql.replace("#{recharge_receive_water}",String.valueOf(t.getRechargeReceiveWater()));
 		sql  = sql.replace("#{recharge_count_water}",String.valueOf(t.getRechargeCountWater()));
 		sql  = sql.replace("#{recharge_count_integral}",String.valueOf(t.getRechargeCountIntegral()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
 	
 	/**
	 * 执行JAVA增强
	 */
 	@SuppressWarnings("unused")
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
					javaInter.execute("w_recharge",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}

	@Override
	public WRechargeEntity getWriteWaterInfoById(String meterNo) {
		return rechargeDao.getNeedWriteWater(meterNo);
		
	}
}