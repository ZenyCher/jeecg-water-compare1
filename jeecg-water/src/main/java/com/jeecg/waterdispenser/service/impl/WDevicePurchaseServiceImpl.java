package com.jeecg.waterdispenser.service.impl;
import com.jeecg.waterdispenser.service.WDevicePurchaseServiceI;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

import com.jeecg.waterdispenser.entity.WDevicePurchaseEntity;

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
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("wDevicePurchaseService")
@Transactional
public class WDevicePurchaseServiceImpl extends CommonServiceImpl implements WDevicePurchaseServiceI {

	
 	public void delete(WDevicePurchaseEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(WDevicePurchaseEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(WDevicePurchaseEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	public List<Map<String, Object>> getDevicePurchaseByListId(List<String> list) throws Exception {
 		StringBuffer sb = new StringBuffer();
 		sb.append("select * from w_device_purchase where purchase_order in ( ");
 		for( int i=0;i<list.size();i++ ) {
 			if( oConvertUtils.isNotEmpty(list.get(i)) ) {
 				sb.append( " '" + list.get(i) + "' ,");
 			}
 		}
 		sb.deleteCharAt(sb.length() - 1);
 		sb.append(" ) ");
 		List<Map<String, Object>> list2 = commonDao.findForJdbcList(sb.toString());
 		return list2;
 	}
 	
 	public List<Map<String, Object>> resultTableFieldAndValue(String tableField,String value) throws Exception{
 		StringBuffer sb = new StringBuffer();
 		sb.append("select * from w_device_purchase where ").append(tableField).append("=");
 		sb.append(value);
 		List<Map<String, Object>> list = commonDao.findForJdbcList(sb.toString());
 		return list;
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(WDevicePurchaseEntity t) throws Exception{
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
	private void doUpdateBus(WDevicePurchaseEntity t) throws Exception{
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
	private void doDelBus(WDevicePurchaseEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
	@SuppressWarnings("unused")
 	private Map<String,Object> populationMap(WDevicePurchaseEntity t){
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
		map.put("purchase_order", t.getPurchaseOrder());
		map.put("purchase_state", t.getPurchaseState());
		map.put("purchase_handle", t.getPurchaseHandle());
		map.put("purchase_name", t.getPurchaseName());
		map.put("purchase_number", t.getPurchaseNumber());
		map.put("purchase_time", t.getPurchaseTime());
		map.put("purchase_people", t.getPurchasePeople());
		map.put("purchase_phone", t.getPurchasePhone());
		map.put("purchase_express", t.getPurchaseExpress());
		map.put("purchase_couriernumber", t.getPurchaseCouriernumber());
		map.put("purchase_operator", t.getPurchaseOperator());
		map.put("purchase_cost", t.getPurchaseCost());
		map.put("purchase_mailtime", t.getPurchaseMailtime());
		map.put("purchase_pay", t.getPurchasePay());
		map.put("purchase_goods", t.getPurchaseGoods());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,WDevicePurchaseEntity t){
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
 		sql  = sql.replace("#{purchase_order}",String.valueOf(t.getPurchaseOrder()));
 		sql  = sql.replace("#{purchase_state}",String.valueOf(t.getPurchaseState()));
 		sql  = sql.replace("#{purchase_handle}",String.valueOf(t.getPurchaseHandle()));
 		sql  = sql.replace("#{purchase_name}",String.valueOf(t.getPurchaseName()));
 		sql  = sql.replace("#{purchase_number}",String.valueOf(t.getPurchaseNumber()));
 		sql  = sql.replace("#{purchase_time}",String.valueOf(t.getPurchaseTime()));
 		sql  = sql.replace("#{purchase_people}",String.valueOf(t.getPurchasePeople()));
 		sql  = sql.replace("#{purchase_phone}",String.valueOf(t.getPurchasePhone()));
 		sql  = sql.replace("#{purchase_express}",String.valueOf(t.getPurchaseExpress()));
 		sql  = sql.replace("#{purchase_couriernumber}",String.valueOf(t.getPurchaseCouriernumber()));
 		sql  = sql.replace("#{purchase_operator}",String.valueOf(t.getPurchaseOperator()));
 		sql  = sql.replace("#{purchase_cost}",String.valueOf(t.getPurchaseCost()));
 		sql  = sql.replace("#{purchase_mailtime}",String.valueOf(t.getPurchaseMailtime()));
 		sql  = sql.replace("#{purchase_pay}",String.valueOf(t.getPurchasePay()));
 		sql  = sql.replace("#{purchase_goods}",String.valueOf(t.getPurchaseGoods()));
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
					javaInter.execute("w_device_purchase",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}