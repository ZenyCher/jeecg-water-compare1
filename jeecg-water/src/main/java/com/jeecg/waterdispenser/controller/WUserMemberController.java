package com.jeecg.waterdispenser.controller;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.hibernate.qbc.CriterionList;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ContextHolderUtils;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.cgform.entity.upload.CgUploadEntity;
import org.jeecgframework.web.cgform.service.config.CgFormFieldServiceI;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.jeecg.waterdispenser.entity.WDeviceEntity;
import com.jeecg.waterdispenser.entity.WInstallEntity;
import com.jeecg.waterdispenser.entity.WMallIntroduceEntity;
import com.jeecg.waterdispenser.entity.WPackageEntity;
import com.jeecg.waterdispenser.entity.WUserDeviceEntity;
import com.jeecg.waterdispenser.entity.WUserMemberEntity;
import com.jeecg.waterdispenser.entity.WUserRegisterEntity;
import com.jeecg.waterdispenser.service.WDeviceServiceI;
import com.jeecg.waterdispenser.service.WInstallServiceI;
import com.jeecg.waterdispenser.service.WMallIntroduceServiceI;
import com.jeecg.waterdispenser.service.WPackageServiceI;
import com.jeecg.waterdispenser.service.WUserDeviceServiceI;
import com.jeecg.waterdispenser.service.WUserMemberServiceI;
import com.jeecg.waterdispenser.service.WUserRegisterServiceI;
/**   
 * @Title: Controller  
 * @Description: 会员表
 * @author onlineGenerator
 * @date 2017-07-18 20:21:52
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wuserMemberController")
public class WUserMemberController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WUserMemberController.class);

	@Autowired
	private WUserMemberServiceI wUserMemberService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private CgFormFieldServiceI cgFormFieldService;
	@Autowired
	private WUserRegisterServiceI wuserRegisterService;
	@Autowired
	private WInstallServiceI wInstallServiceI;
	@Autowired
	private WDeviceServiceI wdeviceService;
	@Autowired
	private WUserDeviceServiceI wUserDeviceService;
	@Autowired
	private WMallIntroduceServiceI wMallIntroduceServiceI;
	@Autowired
	private WPackageServiceI wPackageServiceI;
	


	/**
	 * 会员表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("jeecg/wusermember/wuserMemberList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(WUserMemberEntity wUserMember,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WUserMemberEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wUserMember, request.getParameterMap());
		try{
		//自定义追加查询条件
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("createDate", "desc");
			cq.setOrder(map1);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.wUserMemberService.getDataGridReturn(cq, true);
//		List<WUserMemberEntity> list = dataGrid.getResults();
//		Map<String,Map<String,Object>> extMap = new HashMap<String, Map<String,Object>>();
//		for (WUserMemberEntity wUserMemberEntity : list) {
//			String memberPhone = wUserMember.getMemberPhone();
//			if( oConvertUtils.isNotEmpty(memberPhone) ){
//				WInstallEntity wInstallEntity = wInstallServiceI.
//			}
//		}
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除会员表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WUserMemberEntity wUserMember, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wUserMember = systemService.getEntity(WUserMemberEntity.class, wUserMember.getId());
		message = "会员表删除成功";
		try{
//			int state = wUserMember.getMemberState();
			if( oConvertUtils.isEmpty(wUserMember.getMemberState()) ){
				j.setMsg("请先设置会员无效状态再进行删除!");
				j.setSuccess(false);
				return j;
			}else if( wUserMember.getMemberState() == 1 ){
				j.setMsg("该会员是有效会员，不能删除");
				j.setSuccess(false);
				return j;
			}

			wUserMemberService.delete(wUserMember);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "会员表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 会员用户有效操作 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "effective")
	@ResponseBody
	public AjaxJson effective(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String message = null;
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if( oConvertUtils.isNotEmpty(id) ){
			int i = wUserMemberService.updateMemberState(id);
			if ( i == 1 ) {
				message = "设置有效成功!";
			}else {
				j.setSuccess(false);
				message = "设置有效失败，请稍后再试";
			}
		}else {
			j.setSuccess(false);
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 会员无效操作
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "invalid")
	@ResponseBody
	public AjaxJson invalid(HttpServletRequest request,HttpServletResponse response) throws Exception {
		AjaxJson j = new AjaxJson();
		String message = null;
		String id = request.getParameter("id");
		if ( oConvertUtils.isNotEmpty(id) ) {
			int i = wUserMemberService.updateMemberStateIsInvalid(id);
			if( i == 1 ) {
				message = "设置会员无效成功!";
			}else {
				j.setSuccess(false);
				message = "设置无效失败，请稍后再试!";
			}
		}else {
			j.setSuccess(false);
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除会员表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "会员表删除成功";
		try{
			for(String id:ids.split(",")){
				WUserMemberEntity wUserMember = systemService.getEntity(WUserMemberEntity.class, 
				id
				);
				wUserMemberService.delete(wUserMember);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "会员表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加会员表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WUserMemberEntity wuserMember, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "会员表添加成功";
		try{
			String memberPackageMsg = request.getParameter("pakcageName");//首冲套餐规则描述
			String memberNormalPackageMsg = request.getParameter("packageMode");//正常套餐名称
			wuserMember.setMemberPackageMsg(memberPackageMsg);//首冲套餐规则描述
			wuserMember.setMemberNormalPackageMsg(memberNormalPackageMsg);//正常套餐名称
			String menberContract = request.getParameter("menberContract");
			String menberCertificates = request.getParameter("menberCertificates");
			wuserMember.setMenberContract(menberContract);
			wuserMember.setMenberCertificates(menberCertificates);
			wuserMember.setMemberState(1);//新增会员用户默认为有效状态
			String phone = wuserMember.getMemberType();
			if(StringUtil.isNotEmpty(phone)){
				wuserMember.setMemberPhone(phone);//新增会员
				wuserMember.setMemberType(phone);//新增会员联系方式
				wUserMemberService.save(wuserMember);
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				//添加注册会员之前判断该注册会员是否已存在，如存在则更新，不存在则新建
				WUserRegisterEntity wuserRegisterEntity = wuserRegisterService.findUniqueByProperty(WUserRegisterEntity.class, "id", wuserMember.getId());
				if( wuserRegisterEntity == null ){
					wuserRegisterEntity = new WUserRegisterEntity();
					wuserRegisterEntity.setId(wuserMember.getId());
				}
				wuserRegisterEntity.setMemberPhone(phone);//会员联系方式
				wuserRegisterEntity.setRegisterName(wuserMember.getMemberUser());//用户名
				wuserRegisterEntity.setRegisterPhone(phone);//联系方式
				wuserRegisterEntity.setPassWord("123456");//初始密码
				wuserRegisterEntity.setRegisterRelation(phone);//关联会员
				wuserRegisterEntity.setRegisterType("0");//账号属性,初始为0是会员用户，1为亲属用户，2为安装工用户
				wuserRegisterEntity.setRegisterState(0);//账号状态，初始为0，0为待激活，1为激活，2为禁用
				wuserRegisterService.saveOrUpdate(wuserRegisterEntity);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "会员表添加失败";
//			throw new BusinessException(e.getMessage());
			throw new BusinessException("不能添加重复的会员联系方式或会员添加失败!");
		}
		j.setMsg(message);
		j.setObj(wuserMember);
		return j;
	}
	
	/**
	 * 更新会员表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WUserMemberEntity wUserMember, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "会员表更新成功";
		String memberPackageMsg = request.getParameter("pakcageName");//首冲套餐规则描述
		String memberNormalPackageMsg = request.getParameter("packageMode");//正常套餐名称
		wUserMember.setMemberPackageMsg(memberPackageMsg);//首冲套餐规则描述
		wUserMember.setMemberNormalPackageMsg(memberNormalPackageMsg);//正常套餐名称
		//去除合同证件字段多余逗号
		String menberContract = wUserMember.getMenberContract();
		String menberCertificates = wUserMember.getMenberCertificates();
		if( oConvertUtils.isNotEmpty(menberCertificates) || oConvertUtils.isNotEmpty(menberCertificates) ){
			if( menberContract.contains(",") || menberCertificates.contains(",") ){
				menberContract = menberContract.replace(",", "");
				menberCertificates = menberCertificates.replace(",", "");
				wUserMember.setMenberContract(menberContract);
				wUserMember.setMenberCertificates(menberCertificates);
			}
		}
		WUserMemberEntity t = wUserMemberService.get(WUserMemberEntity.class, wUserMember.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wUserMember, t);
			wUserMemberService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "会员表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 会员表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WUserMemberEntity wUserMember, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wUserMember.getId())) {
			wUserMember = wUserMemberService.getEntity(WUserMemberEntity.class, wUserMember.getId());
			req.setAttribute("wUserMemberPage", wUserMember);
		}
		return new ModelAndView("jeecg/wusermember/wuserMember-add");
	}
	/**
	 * 会员表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WUserMemberEntity wUserMember, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wUserMember.getId())) {
			wUserMember = wUserMemberService.getEntity(WUserMemberEntity.class, wUserMember.getId());
			req.setAttribute("wUserMemberPage", wUserMember);
		}
		return new ModelAndView("jeecg/wusermember/wuserMember-update");
	}
	
	/**
	 * 指派安装工页面跳转
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "assignErector")
	public ModelAndView assignErector(HttpServletRequest request) {
		WUserMemberEntity wUserMemberEntity = new WUserMemberEntity();
		String memberId = request.getParameter("id");
		if( oConvertUtils.isNotEmpty(memberId) ) {
			wUserMemberEntity = wUserMemberService.getEntity(WUserMemberEntity.class, memberId);
			if( wUserMemberEntity != null){
				HttpSession session = ContextHolderUtils.getSession();
				session.setAttribute("SELECT_USER_DEVICE_PHONE", wUserMemberEntity.getMemberPhone());
//				List<WUserDeviceEntity> list = wUserDeviceService.findByProperty(WUserDeviceEntity.class, "memberPhone", wUserMemberEntity.getMemberPhone());
//				List<WDeviceEntity> listDevice = new ArrayList<WDeviceEntity>();
//				if ( list != null && list.size() > 0 ) {
//					for (int i = 0; i < list.size(); i++) {
//						WDeviceEntity wDeviceEntity = new WDeviceEntity();
//						wDeviceEntity = wdeviceService.findUniqueByProperty(WDeviceEntity.class, "deviceId", list.get(i).getDeviceId());
//						listDevice.add(wDeviceEntity);
//					}
//				}
//				request.setAttribute("wdevicePage", listDevice);
				request.setAttribute("wuserMemberPage", wUserMemberEntity);				
			}
		}
		return new ModelAndView("jeecg/wusermember/assignErector");
	}
	
	/**
	 * 指派安装工保存
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(params = "assign")
	@ResponseBody
	public AjaxJson assign(HttpServletRequest request,HttpServletResponse response) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "指派安装工成功";
		try {
			String installTime = request.getParameter("installTime");//安装时间
			String installAddress = request.getParameter("installAddress");//安装地址
			String memberPhone = request.getParameter("memberType");//会员联系方式
			String memberName = request.getParameter("memberName");//会员姓名
			String registerName = request.getParameter("erectorCompany");//安装公司
			String memberId = request.getParameter("memberId");//会员id
			//在保存该用户安装信息前先查询在安装表中是否有该用户安装记录，如果存在则不预增加安装记录
			
			WInstallEntity wInstallEntity = wInstallServiceI.findUniqueByProperty(WInstallEntity.class, "memberId", memberId);
			if( wInstallEntity == null ){
				wInstallEntity = new WInstallEntity();
			}
			if( oConvertUtils.isNotEmpty(registerName) ){
				if( registerName.contains(",") ){
					j.setMsg("只能选取一家安装公司！");
					j.setSuccess(false);
					return j;
				}
			}
			String registerId = request.getParameter("registerId");//安装公司id
			String installCertificates = request.getParameter("installCertificates");//证件
			String installContract = request.getParameter("installContract");//合同
			if( oConvertUtils.isNotEmpty(installCertificates) ){
				if( installCertificates.contains(",") ){
					installCertificates = installCertificates.replace(",", "");
				}
			}
			if( oConvertUtils.isNotEmpty(installContract) ){
				if( installContract.contains(",") ){
					installContract = installContract.replace(",", "");
				}
			}
			wInstallEntity.setInstallProgress("0");
			wInstallEntity.setInstallMembername(memberName);
			wInstallEntity.setInstalPhont(memberPhone);
			wInstallEntity.setInstallAddress(installAddress);
			wInstallEntity.setInstallWorker(registerName);
			wInstallEntity.setInstallWorkerId(registerId);
			if( oConvertUtils.isNotEmpty(installTime) ){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = sdf.parse(installTime);
				wInstallEntity.setInstallTime(date);
			}
			wInstallEntity.setInstallCertificates(installCertificates);
			wInstallEntity.setInstallContract(installContract);
			wInstallEntity.setMemberId(memberId);
			if( oConvertUtils.isNotEmpty(memberId) ){
				WUserMemberEntity wUserMemberEntity = wUserMemberService.findUniqueByProperty(WUserMemberEntity.class, "id", memberId);
				if( oConvertUtils.isEmpty(wUserMemberEntity.getMemberPackageMsg()) && oConvertUtils.isEmpty(wUserMemberEntity.getMemberNormalPackageMsg()) ){
					message = "该用户没有设置套餐信息，不能指派!";
					j.setMsg(message);
					j.setSuccess(false);
					return j;
				}
				wUserMemberEntity.setMemberAssignInstall(registerName);
				wUserMemberService.saveOrUpdate(wUserMemberEntity);
			}
			wInstallServiceI.save(wInstallEntity);
		} catch (Exception e) {
			e.printStackTrace();
			message = "指派安装工失败，请稍后再试";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	@RequestMapping(params = "savePackage")
	@ResponseBody
	public AjaxJson savePackage(String type,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		List<WPackageEntity> wpackage = new ArrayList<WPackageEntity>();
		if( oConvertUtils.isNotEmpty(type) ){
			if( "0".equals(type) ){
				wpackage = wPackageServiceI.findByProperty(WPackageEntity.class, "packageType", 1);
			}else if( "1".equals(type) ){
				wpackage = wPackageServiceI.findByPropertyNot(WPackageEntity.class, "packageType", 1);
			}
		}
		j.setObj(wpackage);
		return j;
	}
	
	/**
	 * 查询套餐
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "packageAssign")
	public ModelAndView packageAssign(HttpServletRequest request) {
		//--author：zhoujf-----start----date:20150531--------for: 编辑用户，选择角色,弹出的角色列表页面，默认没选中
		ModelAndView mv = new ModelAndView("jeecg/uiFolder/package");
		String ids = oConvertUtils.getString(request.getParameter("ids"));
		mv.addObject("ids", ids);
		return mv;
	}	
	/**
	 * 套餐显示列表
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "datagridPackage")
	public void datagridErector(WUserMemberEntity wUserMemberEntity, WPackageEntity wPackageEntity, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WPackageEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wPackageEntity, request.getParameterMap());
		try{
			//自定义追加查询条件
			CriterionList criterionList = new CriterionList();
			criterionList.addPara(0, Restrictions.eq("packageType", 1));
			cq.setCriterionList(criterionList);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.wPackageServiceI.getDataGridReturn(cq, true);
		List<WPackageEntity> list = dataGrid.getResults();
		Map<String,Map<String,Object>> extMap = new HashMap<String, Map<String,Object>>();
		for (WPackageEntity wpackage : list) {
			String packageName = wpackage.getPackageMode();
			if( oConvertUtils.isNotEmpty(packageName) ){
				 Map m = new HashMap();
			     m.put("pakcageName",packageName);
			     extMap.put(wpackage.getId(), m);
			}
		}
		TagUtil.datagrid(response, dataGrid,extMap);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 正常套餐查询
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "normalAssign")
	public ModelAndView normalAssign(HttpServletRequest request) {
		//--author：zhoujf-----start----date:20150531--------for: 编辑用户，选择角色,弹出的角色列表页面，默认没选中
		ModelAndView mv = new ModelAndView("jeecg/uiFolder/normalPackage");
		String ids = oConvertUtils.getString(request.getParameter("ids"));
		mv.addObject("ids", ids);
		return mv;
	}	
	/**
	 * 正常套餐显示列表
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "normalPackage")
	public void normalPackage(WUserMemberEntity wUserMemberEntity, WPackageEntity wPackageEntity, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WPackageEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wPackageEntity, request.getParameterMap());
		try{
			//自定义追加查询条件
			CriterionList criterionList = new CriterionList();
			criterionList.addPara(0, Restrictions.ne("packageType", 1));
			cq.setCriterionList(criterionList);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.wPackageServiceI.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 亲属关系页面跳转
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "relationship")
	public ModelAndView relationship(HttpServletRequest request) {
		WUserMemberEntity wUserMemberEntity = new WUserMemberEntity();
		String memberId = request.getParameter("id");
		if( oConvertUtils.isNotEmpty(memberId) ) {
			wUserMemberEntity = wUserMemberService.getEntity(WUserMemberEntity.class, memberId);
			if( wUserMemberEntity != null)
				request.setAttribute("wuserMemberPage", wUserMemberEntity);
		}
		return new ModelAndView("jeecg/wusermember/relationship");
	}
	
	/**
	 * 亲属关系保存
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(params = "relationshipList")
	@ResponseBody
	public AjaxJson relationshipList(HttpServletRequest request,HttpServletResponse response) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "亲属关系保存成功";
		try {
			String memberPhone = request.getParameter("memberId");
//			String registerId = request.getParameter("registerId");
			String registerName = request.getParameter("registerName");
			String registerRelatives = request.getParameter("registerRelatives");
//			WUserRegisterEntity wUserRegisterEntity = new WUserRegisterEntity();
//			if( oConvertUtils.isNotEmpty(registerId) ){
//				wUserRegisterEntity = wuserRegisterService.findUniqueByProperty(WUserRegisterEntity.class, "id", registerId);
//			}
//			if( wUserRegisterEntity != null ){
//				WUserMemberEntity wUserMemberEntity = wUserDeviceService.findUniqueByProperty(WUserMemberEntity.class, "id", memberId);
//				if( wUserMemberEntity != null ){
//					wUserRegisterEntity.setRegisterRelation(wUserMemberEntity.getMemberName());
//				}
//				if(oConvertUtils.isNotEmpty(registerName) && oConvertUtils.isNotEmpty(registerRelatives)){
//					wUserRegisterEntity.setRegisterRelatives(registerRelatives);
//					wuserRegisterService.updateEntitie(wUserRegisterEntity);
//				}
//			}
			WUserMemberEntity wUserMemberEntity = wUserMemberService.findUniqueByProperty(WUserMemberEntity.class, "memberPhone", memberPhone);
			if( wUserMemberEntity != null ){
				WUserRegisterEntity wUserRegisterEntity = wuserRegisterService.findUniqueByProperty(WUserRegisterEntity.class, "registerPhone", registerName);
				if( wUserRegisterEntity != null ){
					wUserRegisterEntity.setRegisterRelation(memberPhone);
					wUserRegisterEntity.setRegisterRelatives(registerRelatives);
					wuserRegisterService.saveOrUpdate(wUserRegisterEntity);
				}else {
					j.setSuccess(false);
					j.setMsg("注册用户不存在，请确认联系方式是否错误!");
				}
			}else {
				j.setSuccess(false);
				j.setMsg("会员数据错误，请联系管理员!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "保存亲属关系失败，请稍后再试";
			throw new BusinessException(e.getMessage());
		}
		return j;
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wUserMemberController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WUserMemberEntity wUserMember,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WUserMemberEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wUserMember, request.getParameterMap());
		List<WUserMemberEntity> wUserMembers = this.wUserMemberService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"会员表");
		modelMap.put(NormalExcelConstants.CLASS,WUserMemberEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("会员表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wUserMembers);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WUserMemberEntity wUserMember,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"会员表");
    	modelMap.put(NormalExcelConstants.CLASS,WUserMemberEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("会员表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<WUserMemberEntity> listWUserMemberEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WUserMemberEntity.class,params);
				for (WUserMemberEntity wUserMember : listWUserMemberEntitys) {
					wUserMemberService.save(wUserMember);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
	
	/**
	 * 获取文件附件信息
	 * 
	 * @param id wUserMember主键id
	 */
	@RequestMapping(params = "getFiles")
	@ResponseBody
	public AjaxJson getFiles(String id){
		List<CgUploadEntity> uploadBeans = cgFormFieldService.findByProperty(CgUploadEntity.class, "cgformId", id);
		List<Map<String,Object>> files = new ArrayList<Map<String,Object>>(0);
		for(CgUploadEntity b:uploadBeans){
			String title = b.getAttachmenttitle();//附件名
			String fileKey = b.getId();//附件主键
			String path = b.getRealpath();//附件路径
			String field = b.getCgformField();//表单中作为附件控件的字段
			Map<String, Object> file = new HashMap<String, Object>();
			file.put("title", title);
			file.put("fileKey", fileKey);
			file.put("path", path);
			file.put("field", field==null?"":field);
			files.add(file);
		}
		AjaxJson j = new AjaxJson();
		j.setObj(files);
		return j;
	}
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<WUserMemberEntity> list() {
		List<WUserMemberEntity> listWUserMembers=wUserMemberService.getList(WUserMemberEntity.class);
		return listWUserMembers;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		WUserMemberEntity task = wUserMemberService.get(WUserMemberEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody WUserMemberEntity wUserMember, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WUserMemberEntity>> failures = validator.validate(wUserMember);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			wUserMemberService.save(wUserMember);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = wUserMember.getId();
		URI uri = uriBuilder.path("/rest/wUserMemberController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody WUserMemberEntity wUserMember) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WUserMemberEntity>> failures = validator.validate(wUserMember);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			wUserMemberService.saveOrUpdate(wUserMember);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		wUserMemberService.deleteEntityById(WUserMemberEntity.class, id);
	}
}
