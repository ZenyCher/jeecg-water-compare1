package com.jeecg.waterdispenser.service.impl;
import com.jeecg.waterdispenser.service.WViewInstallCompanyServiceI;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

import com.jeecg.waterdispenser.entity.WViewInstallCompanyEntity;
import com.jeecg.waterdispenser.entity.WViewRecordEntity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;

import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("wViewInstallCompanyService")
@Transactional
public class WViewInstallCompanyServiceImpl extends CommonServiceImpl implements WViewInstallCompanyServiceI {

	
 	public void delete(WViewInstallCompanyEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(WViewInstallCompanyEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(WViewInstallCompanyEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	public List<Map<String, Object>> listViewInstallCompany() throws Exception{
 		WViewRecordEntity wView = commonDao.findUniqueByProperty(WViewRecordEntity.class, "name", "w_view_install_company");
 		StringBuffer sb = new StringBuffer();
 		SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 		String date = "";
 		if( wView == null ){
 			sb.append("select * from view_install_device");
 		}else {
 	 		date = datetimeFormat.format(wView.getUpdateDate());
 	 		sb.append("select * from view_install_device where orderDate > '"+date+"'");
		}
 		List<Map<String, Object>> list = commonDao.findForJdbcList(sb.toString());
 		return list;
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(WViewInstallCompanyEntity t) throws Exception{
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
	private void doUpdateBus(WViewInstallCompanyEntity t) throws Exception{
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
	private void doDelBus(WViewInstallCompanyEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	@SuppressWarnings("unused")
	private Map<String,Object> populationMap(WViewInstallCompanyEntity t){
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
		map.put("install_worker", t.getInstallWorker());
		map.put("member_name", t.getMemberName());
		map.put("member_phone", t.getMemberPhone());
		map.put("member_address", t.getMemberAddress());
		map.put("order_date", t.getOrderDate());
		map.put("device_id", t.getDeviceId());
		map.put("member_device_type", t.getMemberDeviceType());
		map.put("install_progress", t.getInstallProgress());
		map.put("install_endtime", t.getInstallEndtime());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,WViewInstallCompanyEntity t){
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
 		sql  = sql.replace("#{install_worker}",String.valueOf(t.getInstallWorker()));
 		sql  = sql.replace("#{member_name}",String.valueOf(t.getMemberName()));
 		sql  = sql.replace("#{member_phone}",String.valueOf(t.getMemberPhone()));
 		sql  = sql.replace("#{member_address}",String.valueOf(t.getMemberAddress()));
 		sql  = sql.replace("#{order_date}",String.valueOf(t.getOrderDate()));
 		sql  = sql.replace("#{device_id}",String.valueOf(t.getDeviceId()));
 		sql  = sql.replace("#{member_device_type}",String.valueOf(t.getMemberDeviceType()));
 		sql  = sql.replace("#{install_progress}",String.valueOf(t.getInstallProgress()));
 		sql  = sql.replace("#{install_endtime}",String.valueOf(t.getInstallEndtime()));
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
					javaInter.execute("w_view_install_company",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}