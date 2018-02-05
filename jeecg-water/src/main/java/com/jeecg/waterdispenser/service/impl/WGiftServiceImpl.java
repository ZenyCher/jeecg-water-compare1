package com.jeecg.waterdispenser.service.impl;
import com.jeecg.waterdispenser.service.WGiftServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.waterdispenser.entity.WGiftEntity;
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

@Service("wGiftService")
@Transactional
public class WGiftServiceImpl extends CommonServiceImpl implements WGiftServiceI {

	
 	public void delete(WGiftEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(WGiftEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(WGiftEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	/**
	 * 自定义按钮-[上架]业务处理
	 * @param id
	 * @return
	 */
	 public void doShelvesBus(WGiftEntity t) throws Exception{
	 	//-----------------sql增强 start----------------------------
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update w_gift set gift_type = 1 where id = '#{id}'";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
	 }
 	/**
	 * 自定义按钮-[下架]业务处理
	 * @param id
	 * @return
	 */
	 public void doTheShelfBus(WGiftEntity t) throws Exception{
	 	//-----------------sql增强 start----------------------------
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update w_gift set gift_type = 0 where id = '#{id}'";
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
	private void doAddBus(WGiftEntity t) throws Exception{
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
	private void doUpdateBus(WGiftEntity t) throws Exception{
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
	private void doDelBus(WGiftEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(WGiftEntity t){
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
		map.put("gift_name", t.getGiftName());
		map.put("gift_describe", t.getGiftDescribe());
		map.put("gift_change", t.getGiftChange());
		map.put("gift_sum", t.getGiftSum());
		map.put("gift_surplus", t.getGiftSurplus());
		map.put("gift_image", t.getGiftImage());
		map.put("gift_yesonno", t.getGiftYesonno());
		map.put("gift_type", t.getGiftType());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,WGiftEntity t){
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
 		sql  = sql.replace("#{gift_name}",String.valueOf(t.getGiftName()));
 		sql  = sql.replace("#{gift_describe}",String.valueOf(t.getGiftDescribe()));
 		sql  = sql.replace("#{gift_change}",String.valueOf(t.getGiftChange()));
 		sql  = sql.replace("#{gift_sum}",String.valueOf(t.getGiftSum()));
 		sql  = sql.replace("#{gift_surplus}",String.valueOf(t.getGiftSurplus()));
 		sql  = sql.replace("#{gift_image}",String.valueOf(t.getGiftImage()));
 		sql  = sql.replace("#{gift_yesonno}",String.valueOf(t.getGiftYesonno()));
 		sql  = sql.replace("#{gift_type}",String.valueOf(t.getGiftType()));
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
					javaInter.execute("w_gift",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}