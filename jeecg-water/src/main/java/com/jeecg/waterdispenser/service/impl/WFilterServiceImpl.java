package com.jeecg.waterdispenser.service.impl;
import com.jeecg.waterdispenser.service.WFilterServiceI;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

import com.jeecg.waterdispenser.entity.WFilterEntity;

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

@Service("wFilterService")
@Transactional
public class WFilterServiceImpl extends CommonServiceImpl implements WFilterServiceI {

	
 	public void delete(WFilterEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(WFilterEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(WFilterEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	public List<Map<String, Object>> selectFilterByFilterId(List<String> filterId) throws Exception {
 		StringBuffer sb = new StringBuffer();
 		sb.append("select * from w_filter where filter_id in ( ");
 		for( int i=0;i<filterId.size();i++ ) {
 			if( oConvertUtils.isNotEmpty(filterId.get(i)) ) {
 				sb.append( " '" + filterId.get(i) + "' ,");
 			}
 		}
 		sb.deleteCharAt(sb.length() - 1);
 		sb.append(" ) ");
 		List<Map<String, Object>> list = commonDao.findForJdbcList(sb.toString());
 		return list;
 	}
 	
 	public Boolean selectTheTrue(String filterCode) throws Exception {
 		Boolean fals = false;
 		StringBuffer sb = new StringBuffer();
 		sb.append("select * from w_filter where filter_code = ? ");
 		Map<String, Object> map = commonDao.findOneForJdbc(sb.toString(), filterCode);
 		if ( map != null ) {
			fals = true;
		}
 		return fals;
 	}
 	
 	public Long selectByFilterIdCount(String filterId) throws Exception {
 		StringBuffer sb = new StringBuffer();
 		sb.append("select count(*) from w_filter where filter_id = '" + filterId + "' ");
 		Long str = commonDao.getCountForJdbc(sb.toString());
 		return str;
 	}
 	
 	public int updateFilterById(String[] str) throws Exception{
 		int num = 0;
 		for (String string : str) {
 			StringBuffer sb = new StringBuffer();
			sb.append("update w_filter set filter_state = 1 where filter_id = " + string + " ");
			num += commonDao.executeSql(sb.toString());
		}
 		return num;
 	}
 	
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(WFilterEntity t) throws Exception{
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
	private void doUpdateBus(WFilterEntity t) throws Exception{
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
	private void doDelBus(WFilterEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(WFilterEntity t){
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
		map.put("filter_id", t.getFilterId());
		map.put("filter_name", t.getFilterName());
		map.put("filter_model", t.getFilterModel());
		map.put("filter_time", t.getFilterTime());
		map.put("filter_importtime", t.getFilterImporttime());
		map.put("filter_code", t.getFilterCode());
		map.put("filter_installedwater", t.getFilterInstalledwater());
		map.put("filter_totalwater", t.getFilterTotalwater());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,WFilterEntity t){
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
 		sql  = sql.replace("#{filter_id}",String.valueOf(t.getFilterId()));
 		sql  = sql.replace("#{filter_name}",String.valueOf(t.getFilterName()));
 		sql  = sql.replace("#{filter_model}",String.valueOf(t.getFilterModel()));
 		sql  = sql.replace("#{filter_time}",String.valueOf(t.getFilterTime()));
 		sql  = sql.replace("#{filter_importtime}",String.valueOf(t.getFilterImporttime()));
 		sql  = sql.replace("#{filter_code}",String.valueOf(t.getFilterCode()));
 		sql  = sql.replace("#{filter_installedwater}",String.valueOf(t.getFilterInstalledwater()));
 		sql  = sql.replace("#{filter_totalwater}",String.valueOf(t.getFilterTotalwater()));
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
					javaInter.execute("w_filter",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}