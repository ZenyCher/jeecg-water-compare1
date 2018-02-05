package com.jeecg.waterdispenser.service.impl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecg.waterdispenser.dao.WRechargeStatisticsDao;
import com.jeecg.waterdispenser.dao.WUserRegisterDao;
import com.jeecg.waterdispenser.entity.WUserRegisterEntity;
import com.jeecg.waterdispenser.service.WUserRegisterServiceI;

@Service("wuserRegisterService")
@Transactional
public class WUserRegisterServiceImpl extends CommonServiceImpl implements WUserRegisterServiceI {

	@Autowired
	private WUserRegisterDao wUserRegisterDao;
	
 	public void delete(WUserRegisterEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(WUserRegisterEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(WUserRegisterEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	public Map<String, Object> selectUserRegisterByRegisterPhone(String registerPhone) throws Exception {
 		StringBuffer sb = new StringBuffer();
 		sb.append("select * from w_user_register where register_state = 1 and register_phone = ? ");
 		Map<String, Object> map = commonDao.findOneForJdbc(sb.toString(), registerPhone);
 		return map;
 	}
 	
 	/**
	 * 自定义按钮-[激活]业务处理
	 * @param id
	 * @return
	 */
	 public void doActivationBus(WUserRegisterEntity t) throws Exception{
	 	//-----------------sql增强 start----------------------------
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update w_user_register set register_state = 1 where id = '#{id}'";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
	 }
 	/**
	 * 自定义按钮-[禁用]业务处理
	 * @param id
	 * @return
	 */
	 public void doDisableBus(WUserRegisterEntity t) throws Exception{
	 	//-----------------sql增强 start----------------------------
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update w_user_register set register_state = 2 where id = '#{id}'";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
	 }
	 
	 public List<WUserRegisterEntity> selectEntity() throws Exception {
		 List<WUserRegisterEntity> list = new ArrayList<WUserRegisterEntity>();
		 list = wUserRegisterDao.selectEntity();
		return list;
	 }
	 
	 public List<Map<String, Object>> selectUserAndErectorByPhone(String phone)throws Exception {
		 StringBuffer sb = new StringBuffer();
		 sb.append("select * from w_user_register where member_phone = '"+phone+"'");
		 List<Map<String, Object>> list = commonDao.findForJdbcList(sb.toString());
		 return list;
	 }
	 
	 public List<Map<String, Object>> getRegisterBymemberId(String memberId) throws Exception{
		 StringBuffer sb = new StringBuffer();
		 sb.append("select * from w_user_register where register_member_id = '" +memberId+"'" );
		 return commonDao.findForJdbcList(sb.toString());
	 }
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(WUserRegisterEntity t) throws Exception{
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
	private void doUpdateBus(WUserRegisterEntity t) throws Exception{
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
	private void doDelBus(WUserRegisterEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(WUserRegisterEntity t){
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
		map.put("register_name", t.getRegisterName());
		map.put("register_phone", t.getRegisterPhone());
		map.put("register_relation", t.getRegisterRelation());
		map.put("register_relatives", t.getRegisterRelatives());
		map.put("pass_word", t.getPassWord());
		map.put("register_type", t.getRegisterType());
		map.put("register_state", t.getRegisterState());
		map.put("register_head", t.getRegisterHead());
		map.put("register_member_id", t.getRegisterMemberId());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,WUserRegisterEntity t){
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
 		sql  = sql.replace("#{register_name}",String.valueOf(t.getRegisterName()));
 		sql  = sql.replace("#{register_phone}",String.valueOf(t.getRegisterPhone()));
 		sql  = sql.replace("#{register_relation}",String.valueOf(t.getRegisterRelation()));
 		sql  = sql.replace("#{pass_word}",String.valueOf(t.getPassWord()));
 		sql  = sql.replace("#{register_relatives}",String.valueOf(t.getRegisterRelatives()));
 		sql  = sql.replace("#{register_type}",String.valueOf(t.getRegisterType()));
 		sql  = sql.replace("#{register_state}",String.valueOf(t.getRegisterState()));
 		sql  = sql.replace("#{register_head}",String.valueOf(t.getRegisterHead()));
 		sql  = sql.replace("#{register_member_id}",String.valueOf(t.getRegisterMemberId()));
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
					javaInter.execute("w_user_register",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}