package com.jeecg.waterdispenser.service.impl;
import com.jeecg.waterdispenser.service.WDeviceServiceI;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

import com.jeecg.waterdispenser.entity.WDeviceEntity;

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
import org.jeecgframework.p3.core.util.oConvertUtils;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("wdeviceService")
@Transactional
public class WDeviceServiceImpl extends CommonServiceImpl implements WDeviceServiceI {

	
 	public void delete(WDeviceEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(WDeviceEntity entity) throws Exception{
 		entity.setIsUse(0);
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(WDeviceEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	public Map<String, Object> selectDeviceByDeviceId(String deviceId) throws Exception {
 		StringBuffer sb = new StringBuffer();
 		sb.append("select * from w_device where device_id = ? ");
 		Map<String, Object> map = commonDao.findOneForJdbc(sb.toString(), deviceId);
 		return map;
 	}
 	
 	public Boolean selectTheTrue(String deviceCode) throws Exception {
 		Boolean fals = false;
 		StringBuffer sb = new StringBuffer();
 		sb.append("select * from w_device where device_code = ? ");
 		Map<String, Object> map = commonDao.findOneForJdbc(sb.toString(), deviceCode);
 		if( map != null ){
 			fals = true;
 		}
 		return fals;
 	}
 	
 	public List<Map<String, Object>> selectDeviceByListId(List<String> deviceId) throws Exception {
 		StringBuffer sb = new StringBuffer();
 		sb.append("select * from w_device where device_id in ( ");
 		for(int i=0;i<deviceId.size();i++) {
 			if( oConvertUtils.isNotEmpty(deviceId.get(i)) ) {
 				sb.append( " '" + deviceId.get(i) + "' ,");
 			}
 		}
 		sb.deleteCharAt(sb.length() - 1);
 		sb.append(" ) ");
 		List<Map<String, Object>> list = commonDao.findForJdbcList(sb.toString());
 		return list;
 	}
 	
 	public Long selectByDeviceIdCount(String deviceId) throws Exception{
 		StringBuffer sb = new StringBuffer();
 		sb.append("select Count(*) from w_device where device_id = '" + deviceId + "'");
 		Long str = commonDao.getCountForJdbc(sb.toString());
 		return str;
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(WDeviceEntity t) throws Exception{
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
	private void doUpdateBus(WDeviceEntity t) throws Exception{
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
	private void doDelBus(WDeviceEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(WDeviceEntity t){
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
		map.put("device_id", t.getDeviceId());
		map.put("device_name", t.getDeviceName());
		map.put("device_model", t.getDeviceModel());
		map.put("filter_nember", t.getFilterNember());
		map.put("filter_id", t.getFilterId());
		map.put("device_time", t.getDeviceTime());
		map.put("device_code", t.getDeviceCode());
		map.put("device_type_id", t.getDeviceTypeId());
		map.put("is_use", t.getIsUse());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,WDeviceEntity t){
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
 		sql  = sql.replace("#{device_id}",String.valueOf(t.getDeviceId()));
 		sql  = sql.replace("#{device_name}",String.valueOf(t.getDeviceName()));
 		sql  = sql.replace("#{device_model}",String.valueOf(t.getDeviceModel()));
 		sql  = sql.replace("#{filter_nember}",String.valueOf(t.getFilterNember()));
 		sql  = sql.replace("#{filter_id}",String.valueOf(t.getFilterId()));
 		sql  = sql.replace("#{device_time}",String.valueOf(t.getDeviceTime()));
 		sql  = sql.replace("#{device_code}",String.valueOf(t.getDeviceCode()));
 		sql  = sql.replace("#{device_type_id}",String.valueOf(t.getDeviceTypeId()));
 		sql  = sql.replace("#{is_use}",String.valueOf(t.getIsUse()));
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
					javaInter.execute("w_device",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}