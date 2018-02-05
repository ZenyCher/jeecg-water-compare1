package com.jeecg.waterdispenser.service.impl;
import com.jeecg.waterdispenser.service.WPackageServiceI;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

import com.jeecg.waterdispenser.entity.WPackageEntity;

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

@Service("wPackageService")
@Transactional
public class WPackageServiceImpl extends CommonServiceImpl implements WPackageServiceI {

	
 	public void delete(WPackageEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(WPackageEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(WPackageEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	public List<Map<String, Object>> selectWpackage() throws Exception {
 		StringBuffer sb = new StringBuffer();
 		sb.append("select * from w_package where package_state = 1");
 		List<Map<String, Object>> list = commonDao.findForJdbcList(sb.toString());
 		return list;
 	}
 	
	 public Map<String, Object> savePackageIdByPachageTye(int type) throws Exception {
		 StringBuffer sb = new StringBuffer();
		 sb.append("select id from w_package where package_type = ? ");
		 Map<String, Object> map = commonDao.findOneForJdbc(sb.toString(), type);
		 return map;
	 }
	 
	 public Map<String, Object> getPackageById(String id) {
		 StringBuffer sb = new StringBuffer();
		 sb.append("select * from w_package where id = ? ");
		 Map<String, Object> map = commonDao.findOneForJdbc(sb.toString(), id);
		 return map;
	 }
 	
 	/**
	 * 自定义按钮-[启用]业务处理
	 * @param id
	 * @return
	 */
	 public void doEnableBus(WPackageEntity t) throws Exception{
	 	//-----------------sql增强 start----------------------------
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update w_package set package_state = 1 where id = '#{id}'";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
	 }
 	/**
	 * 自定义按钮-[停用]业务处理
	 * @param id
	 * @return
	 */
	 public void doDisableBus(WPackageEntity t) throws Exception{
	 	//-----------------sql增强 start----------------------------
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update w_package set package_state = 0 where id = '#{id}'";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
	 }
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(WPackageEntity t) throws Exception{
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
	private void doUpdateBus(WPackageEntity t) throws Exception{
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
	private void doDelBus(WPackageEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(WPackageEntity t){
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
		map.put("package_mode", t.getPackageMode());
		map.put("package_type", t.getPackageType());
		map.put("package_describe", t.getPackageDescribe());
		map.put("package_value", t.getPackageValue());
		map.put("package_state", t.getPackageState());
		map.put("package_father", t.getPackageFather());
		map.put("package_max", t.getPackageMax());
		map.put("package_conver", t.getPackageConver());
		map.put("package_class", t.getPackageClass());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,WPackageEntity t){
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
 		sql  = sql.replace("#{package_mode}",String.valueOf(t.getPackageMode()));
 		sql  = sql.replace("#{package_type}",String.valueOf(t.getPackageType()));
 		sql  = sql.replace("#{package_describe}",String.valueOf(t.getPackageDescribe()));
 		sql  = sql.replace("#{package_value}",String.valueOf(t.getPackageValue()));
 		sql  = sql.replace("#{package_state}",String.valueOf(t.getPackageState()));
 		sql  = sql.replace("#{package_father}",String.valueOf(t.getPackageFather()));
 		sql  = sql.replace("#{package_max}",String.valueOf(t.getPackageMax()));
 		sql  = sql.replace("#{package_conver}",String.valueOf(t.getPackageConver()));
 		sql  = sql.replace("#{package_class}",String.valueOf(t.getPackageClass()));
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
					javaInter.execute("w_package",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}