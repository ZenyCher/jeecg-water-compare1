package com.jeecg.waterdispenser.service.impl;
import com.jeecg.waterdispenser.service.WMaintainServiceI;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

import com.jeecg.waterdispenser.dao.WMaintainDao;
import com.jeecg.waterdispenser.dao.WUserRegisterDao;
import com.jeecg.waterdispenser.entity.WMaintainEntity;

import org.springframework.beans.factory.annotation.Autowired;
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

@Service("wMaintainService")
@Transactional
public class WMaintainServiceImpl extends CommonServiceImpl implements WMaintainServiceI {

	@Autowired
	private WMaintainDao wMaintainDao;
	
 	public void delete(WMaintainEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(WMaintainEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(WMaintainEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(WMaintainEntity t) throws Exception{
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
	private void doUpdateBus(WMaintainEntity t) throws Exception{
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
	private void doDelBus(WMaintainEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
	
	public List<Map<String, Object>> getMaintainByDeviceAndMemberPhone(String deviceId,String memberPhone) throws Exception{
		List<Map<String, Object>> map = new ArrayList<Map<String,Object>>();
		map = wMaintainDao.getMaintainByDeviceAndMemberPhone(deviceId, memberPhone);
		return map;
	}
	
	public List<Map<String, Object>> getMaintainByRegisterId(String registerId) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from w_maintain where maintain_erector_id = '"+ registerId +"'");
		return commonDao.findForJdbcList(sb.toString());
	}
 	
 	@SuppressWarnings("unused")
	private Map<String,Object> populationMap(WMaintainEntity t){
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
		map.put("maintain_state", t.getMaintainState());
		map.put("device_id", t.getDeviceId());
		map.put("register_id", t.getRegisterId());
		map.put("register_name", t.getRegisterName());
		map.put("maintain_type", t.getMaintainType());
		map.put("member_name", t.getMemberName());
		map.put("member_phone", t.getMemberPhone());
		map.put("member_address", t.getMemberAddress());
		map.put("maintain_service", t.getMaintainService());
		map.put("maintain_time", t.getMaintainTime());
		map.put("maintain_record", t.getMaintainRecord());
		map.put("maintain_remarks", t.getMaintainRemarks());
		map.put("maintain_sign", t.getMaintainSign());
		map.put("maintain_subphoto", t.getMaintainSubphoto());
		map.put("maintain_endtime", t.getMaintainEndtime());
		map.put("register_id", t.getRegisterId());
		map.put("maintain_filter", t.getMaintainFilter());
		map.put("maintain_water", t.getMaintainWater());
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
		map.put("maintain_erector_id", t.getMaintainErectorId());
		map.put("maintain_erector_name", t.getMaintainErectorName());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,WMaintainEntity t){
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
 		sql  = sql.replace("#{maintain_state}",String.valueOf(t.getMaintainState()));
 		sql  = sql.replace("#{device_id}",String.valueOf(t.getDeviceId()));
 		sql  = sql.replace("#{register_id}",String.valueOf(t.getRegisterId()));
 		sql  = sql.replace("#{register_name}",String.valueOf(t.getRegisterName()));
 		sql  = sql.replace("#{maintain_type}",String.valueOf(t.getMaintainType()));
 		sql  = sql.replace("#{member_name}",String.valueOf(t.getMemberName()));
 		sql  = sql.replace("#{member_phone}",String.valueOf(t.getMemberPhone()));
 		sql  = sql.replace("#{member_address}",String.valueOf(t.getMemberAddress()));
 		sql  = sql.replace("#{maintain_service}",String.valueOf(t.getMaintainService()));
 		sql  = sql.replace("#{maintain_time}",String.valueOf(t.getMaintainTime()));
 		sql  = sql.replace("#{maintain_record}",String.valueOf(t.getMaintainRecord()));
 		sql  = sql.replace("#{maintain_remarks}",String.valueOf(t.getMaintainRemarks()));
 		sql  = sql.replace("#{maintain_sign}",String.valueOf(t.getMaintainSign()));
 		sql  = sql.replace("#{maintain_subphoto}",String.valueOf(t.getMaintainSubphoto()));
 		sql  = sql.replace("#{maintain_endtime}",String.valueOf(t.getMaintainEndtime()));
 		sql  = sql.replace("#{register_id}",String.valueOf(t.getRegisterId()));
 		sql  = sql.replace("#{maintain_filter}",String.valueOf(t.getMaintainFilter()));
 		sql  = sql.replace("#{maintain_water}",String.valueOf(t.getMaintainWater()));
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
 		sql  = sql.replace("#{maintain_erector_id}",String.valueOf(t.getMaintainErectorId()));
 		sql  = sql.replace("#{maintain_erector_name}",String.valueOf(t.getMaintainErectorName()));
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
					javaInter.execute("w_maintain",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}