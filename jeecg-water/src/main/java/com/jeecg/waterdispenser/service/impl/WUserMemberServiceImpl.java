package com.jeecg.waterdispenser.service.impl;
import com.jeecg.waterdispenser.service.WUserMemberServiceI;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

import com.jeecg.waterdispenser.entity.WUserMemberEntity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;

import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("wuserMemberService")
@Transactional
public class WUserMemberServiceImpl extends CommonServiceImpl implements WUserMemberServiceI {

	
 	public void delete(WUserMemberEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(WUserMemberEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(WUserMemberEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	public int updateMemberState(String id) throws Exception {
 		int i = 0;
 		StringBuffer sb = new StringBuffer();
 		sb.append("update w_user_member set member_state = 1 where id = '" + id + "'");
 		i = commonDao.updateBySqlString(sb.toString());
 		return i;
 	}

 	public int updateMemberStateIsInvalid(String id) throws Exception {
 		int i = 0;
 		StringBuffer sb = new StringBuffer();
 		sb.append("update w_user_member set member_state = 0 where id = '" + id + "'");
 		i = commonDao.updateBySqlString(sb.toString());
 		return i;
 	}
 	
 	public List<Map<String, Object>> getUserMenberByPhone(String memberPhone) {
 		StringBuffer sb = new StringBuffer();
 		sb.append("select * from w_user_member where member_phone = " + memberPhone);
 		List<Map<String, Object>> map = new ArrayList<Map<String,Object>>();
 		map = commonDao.findForJdbc(sb.toString());
 		return map;
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(WUserMemberEntity t) throws Exception{
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
	private void doUpdateBus(WUserMemberEntity t) throws Exception{
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
	private void doDelBus(WUserMemberEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(WUserMemberEntity t){
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
		map.put("member_address", t.getMemberAddress());
		map.put("member_id", t.getMemberId());
		map.put("water_surplus", t.getWaterSurplus());
		map.put("member_type", t.getMemberType());
		map.put("member_user", t.getMemberUser());
		map.put("menber_contract", t.getMenberContract());
		map.put("menber_certificates", t.getMenberCertificates());
		map.put("member_initial_water", t.getMemberInitialWater());
		map.put("member_package_id", t.getMemberPackageId());
		map.put("member_package_msg", t.getMemberPackageMsg());
		map.put("member_normal_package_id", t.getMemberNormalPackageId());
		map.put("member_normal_package_msg", t.getMemberNormalPackageMsg());
		map.put("member_remarks", t.getMemberRemarks());
		map.put("member_state", t.getMemberState());
		map.put("member_package_type", t.getMemberPackageType());
		map.put("member_source", t.getMemberSource());
		map.put("member_assign_install", t.getMemberAssignInstall());
		map.put("device_id", t.getDeviceId());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,WUserMemberEntity t){
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
 		sql  = sql.replace("#{member_address}",String.valueOf(t.getMemberAddress()));
 		sql  = sql.replace("#{member_id}",String.valueOf(t.getMemberId()));
 		sql  = sql.replace("#{water_surplus}",String.valueOf(t.getWaterSurplus()));
 		sql  = sql.replace("#{member_type}",String.valueOf(t.getMemberType()));
 		sql  = sql.replace("#{member_user}",String.valueOf(t.getMemberUser()));
 		sql  = sql.replace("#{menber_contract}",String.valueOf(t.getMenberContract()));
 		sql  = sql.replace("#{menber_certificates}",String.valueOf(t.getMenberCertificates()));
 		sql  = sql.replace("#{member_initial_water}",String.valueOf(t.getMemberInitialWater()));
 		sql  = sql.replace("#{member_deposit}",String.valueOf(t.getMemberDeposit()));
 		sql  = sql.replace("#{member_remarks}",String.valueOf(t.getMemberRemarks()));
 		sql  = sql.replace("#{member_package_id}",String.valueOf(t.getMemberPackageId()));
 		sql  = sql.replace("#{member_package_msg}",String.valueOf(t.getMemberPackageMsg()));
 		sql  = sql.replace("#{member_normal_package_id}",String.valueOf(t.getMemberNormalPackageId()));
 		sql  = sql.replace("#{member_normal_package_msg}",String.valueOf(t.getMemberNormalPackageMsg()));
 		sql  = sql.replace("#{member_state}",String.valueOf(t.getMemberState()));
 		sql  = sql.replace("#{member_package_type}",String.valueOf(t.getMemberPackageType()));
 		sql  = sql.replace("#{member_source}",String.valueOf(t.getMemberSource()));
 		sql  = sql.replace("#{member_assign_install}",String.valueOf(t.getMemberAssignInstall()));
 		sql  = sql.replace("#{device_id}",String.valueOf(t.getDeviceId()));
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
					javaInter.execute("w_user_member",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}