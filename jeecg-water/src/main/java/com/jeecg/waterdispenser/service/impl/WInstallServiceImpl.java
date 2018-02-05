package com.jeecg.waterdispenser.service.impl;
import com.jeecg.waterdispenser.service.WInstallServiceI;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

import com.jeecg.waterdispenser.dao.WInstallDao;
import com.jeecg.waterdispenser.dao.WMaintainDao;
import com.jeecg.waterdispenser.entity.WInstallEntity;

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

@Service("wInstallService")
@Transactional
public class WInstallServiceImpl extends CommonServiceImpl implements WInstallServiceI {

	@Autowired
	private WInstallDao wInstallDao;
	
 	public void delete(WInstallEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(WInstallEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(WInstallEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	public Map<String, Object> selectInstallBydeviceId(String deviceId) throws Exception {
 		StringBuffer sb = new StringBuffer();
 		sb.append("select * from w_install where device_id = ? ");
 		Map<String, Object> map = commonDao.findOneForJdbc(sb.toString(), deviceId);
 		return map;
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(WInstallEntity t) throws Exception{
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
	private void doUpdateBus(WInstallEntity t) throws Exception{
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
	private void doDelBus(WInstallEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
	
	public Map<String, String> getInstallByDeviceAndMemberPhone(String deviceId,String memberPhone) throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		map = wInstallDao.getInstallByDeviceAndMemberPhone(deviceId, memberPhone);
		return map;
	}
	
	public List<Map<String, Object>> getInstallNameByRegisterId(String registerId) throws Exception{
		StringBuffer sb = new StringBuffer();
		sb.append("select * from w_install where install_erector_id = ? ");
		return commonDao.findForJdbc(sb.toString(), registerId);
	}
	
	public List<Map<String, Object>> getInstallByMemberId(String memberId) throws Exception{
		StringBuffer sb = new StringBuffer();
		sb.append("select * from w_install where member_id = ? ");
		return commonDao.findForJdbc(sb.toString(), memberId);
	}
 	
 	private Map<String,Object> populationMap(WInstallEntity t){
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
		map.put("install_progress", t.getInstallProgress());
		map.put("install_membername", t.getInstallMembername());
		map.put("instal_phont", t.getInstalPhont());
		map.put("install_address", t.getInstallAddress());
		map.put("install_number", t.getInstallNumber());
		map.put("install_source", t.getInstallSource());
		map.put("install_worker", t.getInstallWorker());
		map.put("install_time", t.getInstallTime());
		map.put("install_message", t.getInstallMessage());
		map.put("install_sign", t.getInstallSign());
		map.put("install_subphoto", t.getInstallSubphoto());
		map.put("member_id", t.getMemberId());
		map.put("installErectorId", t.getInstallErectorId());
		map.put("installErectorName", t.getInstallErectorName());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,WInstallEntity t){
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
 		sql  = sql.replace("#{install_progress}",String.valueOf(t.getInstallProgress()));
 		sql  = sql.replace("#{install_membername}",String.valueOf(t.getInstallMembername()));
 		sql  = sql.replace("#{instal_phont}",String.valueOf(t.getInstalPhont()));
 		sql  = sql.replace("#{install_address}",String.valueOf(t.getInstallAddress()));
 		sql  = sql.replace("#{install_number}",String.valueOf(t.getInstallNumber()));
 		sql  = sql.replace("#{install_source}",String.valueOf(t.getInstallSource()));
 		sql  = sql.replace("#{install_worker}",String.valueOf(t.getInstallWorker()));
 		sql  = sql.replace("#{install_time}",String.valueOf(t.getInstallTime()));
 		sql  = sql.replace("#{install_message}",String.valueOf(t.getInstallMessage()));
 		sql  = sql.replace("#{install_sign}",String.valueOf(t.getInstallSign()));
 		sql  = sql.replace("#{install_subphoto}",String.valueOf(t.getInstallSubphoto()));
 		sql  = sql.replace("#{member_id}",String.valueOf(t.getMemberId()));
 		sql  = sql.replace("#{installErectorId}",String.valueOf(t.getInstallErectorId()));
 		sql  = sql.replace("#{installErectorName}",String.valueOf(t.getInstallErectorName()));
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
					javaInter.execute("w_install",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}