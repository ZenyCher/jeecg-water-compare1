package com.jeecg.waterdispenser.service.impl;
import com.jeecg.waterdispenser.service.WGiftExchangeServiceI;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

import com.jeecg.waterdispenser.entity.WGiftExchangeEntity;

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

@Service("wGiftExchangeService")
@Transactional
public class WGiftExchangeServiceImpl extends CommonServiceImpl implements WGiftExchangeServiceI {

	
 	public void delete(WGiftExchangeEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(WGiftExchangeEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(WGiftExchangeEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	public List<Map<String, Object>> getGiftExchangeByListId(List<String> list) throws Exception {
 		StringBuffer sb = new StringBuffer();
 		sb.append("select * from w_gift_exchange where giftexchange_order in ( ");
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
 		sb.append("select * from w_gift_exchange where ").append(tableField).append("=");
 		sb.append(value);
 		List<Map<String, Object>> list = commonDao.findForJdbcList(sb.toString());
 		return list;
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(WGiftExchangeEntity t) throws Exception{
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
	private void doUpdateBus(WGiftExchangeEntity t) throws Exception{
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
	private void doDelBus(WGiftExchangeEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(WGiftExchangeEntity t){
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
		map.put("gift_id", t.getGiftId());
		map.put("giftexchange_order", t.getGiftexchangeOrder());
		map.put("giftexchange_state", t.getGiftexchangeState());
		map.put("giftexchange_handle", t.getGiftexchangeHandle());
		map.put("gift_name", t.getGiftName());
		map.put("giftexchange_number", t.getGiftexchangeNumber());
		map.put("giftexchange_time", t.getGiftexchangeTime());
		map.put("giftexchange_consignee", t.getGiftexchangeConsignee());
		map.put("giftexchange_phone", t.getGiftexchangePhone());
		map.put("giftexchange_address", t.getGiftexchangeAddress());
		map.put("giftexchange_express", t.getGiftexchangeExpress());
		map.put("giftexchange_couriernumber", t.getGiftexchangeCouriernumber());
		map.put("giftexchange_operator", t.getGiftexchangeOperator());
		map.put("giftexchange_cost", t.getGiftexchangeCost());
		map.put("giftexchange_mailtime", t.getGiftexchangeMailtime());
		map.put("giftexchange_integral", t.getGiftexchangeIntegral());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,WGiftExchangeEntity t){
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
 		sql  = sql.replace("#{gift_id}",String.valueOf(t.getGiftId()));
 		sql  = sql.replace("#{giftexchange_order}",String.valueOf(t.getGiftexchangeOrder()));
 		sql  = sql.replace("#{giftexchange_state}",String.valueOf(t.getGiftexchangeState()));
 		sql  = sql.replace("#{giftexchange_handle}",String.valueOf(t.getGiftexchangeHandle()));
 		sql  = sql.replace("#{gift_name}",String.valueOf(t.getGiftName()));
 		sql  = sql.replace("#{giftexchange_number}",String.valueOf(t.getGiftexchangeNumber()));
 		sql  = sql.replace("#{giftexchange_time}",String.valueOf(t.getGiftexchangeTime()));
 		sql  = sql.replace("#{giftexchange_consignee}",String.valueOf(t.getGiftexchangeConsignee()));
 		sql  = sql.replace("#{giftexchange_phone}",String.valueOf(t.getGiftexchangePhone()));
 		sql  = sql.replace("#{giftexchange_address}",String.valueOf(t.getGiftexchangeAddress()));
 		sql  = sql.replace("#{giftexchange_express}",String.valueOf(t.getGiftexchangeExpress()));
 		sql  = sql.replace("#{giftexchange_couriernumber}",String.valueOf(t.getGiftexchangeCouriernumber()));
 		sql  = sql.replace("#{giftexchange_operator}",String.valueOf(t.getGiftexchangeOperator()));
 		sql  = sql.replace("#{giftexchange_cost}",String.valueOf(t.getGiftexchangeCost()));
 		sql  = sql.replace("#{giftexchange_mailtime}",String.valueOf(t.getGiftexchangeMailtime()));
 		sql  = sql.replace("#{giftexchange_integral}",String.valueOf(t.getGiftexchangeIntegral()));
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
					javaInter.execute("w_gift_exchange",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}