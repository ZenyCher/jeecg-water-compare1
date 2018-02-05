package com.jeecg.waterdispenser.service.impl;
import com.jeecg.waterdispenser.service.WUserDeviceServiceI;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

import com.jeecg.waterdispenser.dao.WUserDeviceDao;
import com.jeecg.waterdispenser.entity.WUserDeviceEntity;

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

@Service("wUserDeviceService")
@Transactional
public class WUserDeviceServiceImpl extends CommonServiceImpl implements WUserDeviceServiceI {

	@Autowired
	private WUserDeviceDao wUserDeviceDao;
	
 	public void delete(WUserDeviceEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(WUserDeviceEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(WUserDeviceEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	public List<Map<String, Object>> selectUserDeviceByMemberPhone(String memberPhone) throws Exception {
 		StringBuffer sb = new StringBuffer();
 		sb.append("select * from w_user_device where member_phone = ").append("'"+memberPhone+"'");
 		List<Map<String, Object>> map = commonDao.findForJdbcList(sb.toString());
 		return map;
 	}
 	
 	public WUserDeviceEntity saveUserDeviceByPhoneAndWaterId(String memberPhone,String waterId) throws Exception{
 		WUserDeviceEntity wUserDeviceEntity = wUserDeviceDao.saveUserDeviceByPhoneAndWaterId(memberPhone, waterId);
 		return wUserDeviceEntity;
 	}
 	
 	public Map<String, Object> saveUserDeviceByMemberId(String memberId) throws Exception {
 		StringBuffer sb = new StringBuffer();
 		sb.append("select * from w_user_device where member_id = ? ");
 		Map<String, Object> map = commonDao.findOneForJdbc(sb.toString(), memberId);
 		return map;
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(WUserDeviceEntity t) throws Exception{
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
	private void doUpdateBus(WUserDeviceEntity t) throws Exception{
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
	private void doDelBus(WUserDeviceEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(WUserDeviceEntity t){
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
		map.put("member_phone", t.getMemberPhone());
		map.put("member_name", t.getMemberName());
		map.put("device_id", t.getDeviceId());
		map.put("device_name", t.getDeviceName());
		map.put("watermeter_id", t.getWatermeterId());
		map.put("device_type_id", t.getDeviceTypeId());
		map.put("device_type_name", t.getDeviceTypeName());
		map.put("one_filter_id", t.getOneFilterId());
		map.put("one_filter_name", t.getOneFilterName());
		map.put("two_filter_id", t.getTwoFilterId());
		map.put("two_filter_name", t.getTwoFilterName());
		map.put("three_filter_id", t.getThreeFilterId());
		map.put("three_filter_name", t.getThreeFilterName());
		map.put("four_filter_id", t.getFourFilterId());
		map.put("four_filter_name", t.getFourFilterName());
		map.put("five_filter_id", t.getFiveFilterId());
		map.put("five_filter_name", t.getFiveFilterName());
		map.put("six_filter_id", t.getSixFilterId());
		map.put("six_filter_name", t.getSixFilterName());
		map.put("install_erector_id", t.getInstallErectorId());
		map.put("install_erector_name", t.getInstallErectorName());
		map.put("member_id", t.getMemberId());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,WUserDeviceEntity t){
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
 		sql  = sql.replace("#{member_phone}",String.valueOf(t.getMemberPhone()));
 		sql  = sql.replace("#{member_name}",String.valueOf(t.getMemberName()));
 		sql  = sql.replace("#{device_id}",String.valueOf(t.getDeviceId()));
 		sql  = sql.replace("#{device_name}",String.valueOf(t.getDeviceName()));
 		sql  = sql.replace("#{watermeter_id}",String.valueOf(t.getWatermeterId()));
 		sql  = sql.replace("#{device_type_id}",String.valueOf(t.getDeviceTypeId()));
 		sql  = sql.replace("#{device_type_name}",String.valueOf(t.getDeviceTypeName()));
 		sql  = sql.replace("#{one_filter_id}",String.valueOf(t.getOneFilterId()));
 		sql  = sql.replace("#{one_filter_name}",String.valueOf(t.getOneFilterName()));
 		sql  = sql.replace("#{two_filter_id}",String.valueOf(t.getTwoFilterId()));
 		sql  = sql.replace("#{two_filter_name}",String.valueOf(t.getTwoFilterName()));
 		sql  = sql.replace("#{three_filter_id}",String.valueOf(t.getThreeFilterId()));
 		sql  = sql.replace("#{three_filter_name}",String.valueOf(t.getThreeFilterName()));
 		sql  = sql.replace("#{four_filter_id}",String.valueOf(t.getFourFilterId()));
 		sql  = sql.replace("#{four_filter_name}",String.valueOf(t.getFourFilterName()));
 		sql  = sql.replace("#{five_filter_id}",String.valueOf(t.getFiveFilterId()));
 		sql  = sql.replace("#{five_filter_name}",String.valueOf(t.getFiveFilterName()));
 		sql  = sql.replace("#{six_filter_id}",String.valueOf(t.getSixFilterId()));
 		sql  = sql.replace("#{six_filter_name}",String.valueOf(t.getSixFilterName()));
 		sql  = sql.replace("#{install_erector_id}",String.valueOf(t.getInstallErectorId()));
 		sql  = sql.replace("#{install_erector_name}",String.valueOf(t.getInstallErectorName()));
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
					javaInter.execute("w_user_device",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}