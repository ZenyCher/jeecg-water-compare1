package com.jeecg.waterdispenser.controller;

import com.jeecg.waterdispenser.entity.WErectorEntity;
import com.jeecg.waterdispenser.entity.WUserRegisterEntity;
import com.jeecg.waterdispenser.service.WErectorServiceI;
import com.jeecg.waterdispenser.service.WUserRegisterServiceI;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.UserTokenHandler;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.hibernate.qbc.CriterionList;
import org.jeecgframework.core.common.model.common.TreeChildCount;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSRole;
import org.jeecgframework.web.system.pojo.base.TSRoleUser;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;

import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.jeecgframework.core.util.ResourceUtil;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Iterator;

import org.jeecgframework.core.util.ExceptionUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/wPersonnel")
public class WPersonnel  extends BaseController {

	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WPersonnel.class);

	@Autowired
	private WUserRegisterServiceI wUserRegisterService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private WUserRegisterServiceI wuserRegisterService;
	@Autowired
	private WErectorServiceI wErectorServiceI;
	
	
	/**
	 * 用户注册表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("jeecg/wpersonnel/wPersonnelList");
	}
	
	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 * @throws Exception 
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(WUserRegisterEntity wUserRegister,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) throws Exception {
		CriteriaQuery cq = new CriteriaQuery(WUserRegisterEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wUserRegister, request.getParameterMap());
		try{
			//自定义追加查询条件
			CriterionList criterionList = new CriterionList();
			//判断当前用户是否在在注册用户表下有关联用户，如果有则是代理公司后台账户，则显示该公司的安装工人,并将该用户的手机号码并作查询条件
			TSUser user = ResourceUtil.getSessionUserName();
			List<TSRoleUser> rUsers = systemService.findByProperty(TSRoleUser.class, "TSUser.id", user.getId());
			TSRole role = new TSRole();
			for (TSRoleUser ru : rUsers) {
				role = ru.getTSRole();
			}
			String rolecode = role.getRoleCode();
			if ( rolecode.equals("fix_worker") ) {
				criterionList.addPara(0,Restrictions.eq("memberPhone", user.getMobilePhone()));
				criterionList.addPara(1,Restrictions.eq("registerType", "2"));
			}else{
				criterionList.addPara(0,Restrictions.eq("registerType", "2"));
			}
			cq.setCriterionList(criterionList);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.wUserRegisterService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除用户注册表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WUserRegisterEntity wUserRegister, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wUserRegister = systemService.getEntity(WUserRegisterEntity.class, wUserRegister.getId());
		message = "用户注册表删除成功";
		try{
			wUserRegisterService.delete(wUserRegister);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "用户注册表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除用户注册表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "用户注册表删除成功";
		try{
			for(String id:ids.split(",")){
				WUserRegisterEntity wUserRegister = systemService.getEntity(WUserRegisterEntity.class, 
				id
				);
				wUserRegisterService.delete(wUserRegister);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "用户注册表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
 	/**
	 * 自定义按钮-[激活]业务
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doActivation")
	@ResponseBody
	public AjaxJson doActivation(WUserRegisterEntity wuserRegister, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "激活成功";
		WUserRegisterEntity t = wuserRegisterService.get(WUserRegisterEntity.class, wuserRegister.getId());
		try{
			wuserRegisterService.doActivationBus(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "激活失败";
		}
		j.setMsg(message);
		return j;
	}
 	/**
	 * 自定义按钮-[禁用]业务
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doDisable")
	@ResponseBody
	public AjaxJson doDisable(WUserRegisterEntity wuserRegister, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "禁用成功";
		WUserRegisterEntity t = wuserRegisterService.get(WUserRegisterEntity.class, wuserRegister.getId());
		try{
			wuserRegisterService.doDisableBus(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "禁用失败";
		}
		j.setMsg(message);
		return j;
	}
	 
	
	/**
	 * 添加用户注册表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WUserRegisterEntity wUserRegister, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "用户注册表添加成功";
		try{
			//获取当前用户的登陆的实体进行关联
			TSUser user = ResourceUtil.getSessionUserName();
			if ( user == null ) {
				j.setMsg("新增注册用户失败，请稍后再试！");
			}
			wUserRegister.setMemberPhone(user.getMobilePhone());
			wUserRegister.setRegisterMemberId(user.getId());
			//根据id获取安装公司表中是否存在记录，在安装公司绑定就需确定该后台账号已被绑定安装公司。
			WErectorEntity erectorList = wErectorServiceI.findUniqueByProperty(WErectorEntity.class, "erectorAdminId", user.getId());
			if( erectorList != null ){
				wUserRegister.setRegisterRelation(erectorList.getErectorCompany());
			}else {
				wUserRegister.setRegisterRelation(user.getRealName());
			}
			//默认用户类型为安装工人
			wUserRegister.setRegisterType("2");
			wUserRegisterService.save(wUserRegister);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "用户注册表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新用户注册表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WUserRegisterEntity wUserRegister, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "用户注册表更新成功";
		WUserRegisterEntity t = wUserRegisterService.get(WUserRegisterEntity.class, wUserRegister.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wUserRegister, t);
			wUserRegisterService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "用户注册表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 用户注册表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WUserRegisterEntity wUserRegister, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wUserRegister.getId())) {
			wUserRegister = wUserRegisterService.getEntity(WUserRegisterEntity.class, wUserRegister.getId());
			req.setAttribute("wUserRegisterPage", wUserRegister);
		}
		return new ModelAndView("jeecg/wpersonnel/wPersonnel-add");
	}
	/**
	 * 用户注册表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WUserRegisterEntity wUserRegister, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wUserRegister.getId())) {
			wUserRegister = wUserRegisterService.getEntity(WUserRegisterEntity.class, wUserRegister.getId());
			req.setAttribute("wUserRegisterPage", wUserRegister);
		}
		return new ModelAndView("jeecg/wpersonnel/wPersonnel-update");
	}
}
