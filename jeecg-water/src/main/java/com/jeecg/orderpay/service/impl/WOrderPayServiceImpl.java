package com.jeecg.orderpay.service.impl;

import com.jeecg.orderpay.service.WOrderPayServiceI;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

import com.jeecg.orderpay.entity.WOrderPayEntity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;

import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("wOrderPayService")
@Transactional
public class WOrderPayServiceImpl extends CommonServiceImpl implements WOrderPayServiceI {

	
 	public void delete(WOrderPayEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(WOrderPayEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(WOrderPayEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	public Map<String, Object> findEntityByOutTradeNo(String outTradeNo) throws Exception{
		StringBuffer sb = new StringBuffer();
		sb.append("select * from w_order_pay where out_trade_no = ? ");
		Map<String, Object> map = commonDao.findOneForJdbc(sb.toString(), outTradeNo);
 		return map;
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(WOrderPayEntity t) throws Exception{
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
	private void doUpdateBus(WOrderPayEntity t) throws Exception{
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
	private void doDelBus(WOrderPayEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(WOrderPayEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("goods_info", t.getGoodsInfo());
		map.put("out_trade_no", t.getOutTradeNo());
		map.put("transaction_id", t.getTransactionId());
		map.put("pay_type", t.getPayType());
		map.put("order_date", t.getOrderDate());
		map.put("return_code", t.getReturnCode());
		map.put("return_msg", t.getReturnMsg());
		map.put("settlement_total_fee", t.getSettlementTotalFee());
		map.put("update_date", t.getUpdateDate());
		map.put("prepay_id", t.getPrepayId());
		map.put("address", t.getAddress());
		map.put("receiver", t.getReceiver());
		map.put("receiverMobile", t.getReceiverMobile());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,WOrderPayEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{goods_info}",String.valueOf(t.getGoodsInfo()));
 		sql  = sql.replace("#{out_trade_no}",String.valueOf(t.getOutTradeNo()));
 		sql  = sql.replace("#{transaction_id}",String.valueOf(t.getTransactionId()));
 		sql  = sql.replace("#{pay_type}",String.valueOf(t.getPayType()));
 		sql  = sql.replace("#{order_date}",String.valueOf(t.getOrderDate()));
 		sql  = sql.replace("#{return_code}",String.valueOf(t.getReturnCode()));
 		sql  = sql.replace("#{return_msg}",String.valueOf(t.getReturnMsg()));
 		sql  = sql.replace("#{settlement_total_fee}",String.valueOf(t.getSettlementTotalFee()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{prepay_id}",String.valueOf(t.getPrepayId()));
 		sql  = sql.replace("#{address}",String.valueOf(t.getAddress()));
 		sql  = sql.replace("#{receiver}",String.valueOf(t.getReceiver()));
 		sql  = sql.replace("#{receiverMobile}",String.valueOf(t.getReceiverMobile()));
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
					javaInter.execute("w_order_pay",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}