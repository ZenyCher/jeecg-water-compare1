package com.jeecg.waterdispenser.controller;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.jeecgframework.tag.vo.datatable.SortDirection;
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

import com.jeecg.waterdispenser.entity.WErectorEntity;
import com.jeecg.waterdispenser.entity.WMaintainEntity;
import com.jeecg.waterdispenser.entity.WRepairEntity;
import com.jeecg.waterdispenser.entity.WUserDeviceEntity;
import com.jeecg.waterdispenser.entity.WUserRegisterEntity;
import com.jeecg.waterdispenser.service.WDeviceServiceI;
import com.jeecg.waterdispenser.service.WMaintainServiceI;
import com.jeecg.waterdispenser.service.WRepairServiceI;
import com.jeecg.waterdispenser.service.WUserDeviceServiceI;
import com.sun.star.lib.uno.environments.java.java_environment;

/**   
 * @Title: Controller  
 * @Description: 售后管理-维修保养管理
 * @author onlineGenerator
 * @date 2017-07-23 13:58:37
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wmaintainController")
public class WMaintainController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WMaintainController.class);

	@Autowired
	private WMaintainServiceI wMaintainService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private WUserDeviceServiceI wUserDeviceService;
	@Autowired
	private WDeviceServiceI WDeviceService;
	@Autowired
	private WRepairServiceI wRepairServiceI;
	
	


	/**
	 * w_maintain列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("jeecg/wmaintain/wmaintainList");
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
	public void datagrid(WMaintainEntity wMaintain,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WMaintainEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wMaintain, request.getParameterMap());
		try{
		//自定义追加查询条件
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("maintainState", "asc");
			cq.setOrder(map);
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("createDate","desc");
			cq.setOrder(map1);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.wMaintainService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除w_maintain
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WMaintainEntity wMaintain, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wMaintain = systemService.getEntity(WMaintainEntity.class, wMaintain.getId());
		message = "安装工删除成功";
		try{
			wMaintainService.delete(wMaintain);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "安装工删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除w_maintain
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "安装工删除成功";
		try{
			for(String id:ids.split(",")){
				WMaintainEntity wMaintain = systemService.getEntity(WMaintainEntity.class, 
				id
				);
				wMaintainService.delete(wMaintain);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "安装工删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加安装工
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WMaintainEntity wMaintain, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "安装工添加成功";
		try{
			String registerName = request.getParameter("erectorCompany");
			if( registerName.isEmpty() ){
				j.setMsg("安装公司不能为空，请重新输入！");
				j.setSuccess(false);
				return j;
			}
			String[] str = wMaintain.getRegisterId().split(",");
			if( str.length > 1 ){
				j.setMsg("安装公司不能选择两个！");
				j.setSuccess(false);
				return j;
			}
			String registerId = str[0].toString();
			wMaintain.setMaintainState(0);
			wMaintain.setRegisterName(registerName);
			wMaintain.setRegisterId(registerId);
			wMaintainService.save(wMaintain);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			//将安装管理信息下发到维护保养管理表
//			WRepairEntity wRepair = new WRepairEntity();
//			wRepair.setMaintainState(0);//维护状态
//			wRepair.setDeviceId(wMaintain.getDeviceId());//设备id deviceId
//			wRepair.setRegisterId(request.getParameter("erectorCompany"));//维护负责人id registerId
//			wRepair.setRegisterName(request.getParameter("registerId"));//维护负责人 registerName
//			wRepair.setMemberName(wMaintain.getMemberName());//会员姓名 memberName
//			wRepair.setMemberPhone(wMaintain.getMemberPhone());//联系方式 memberPhone
//			wRepair.setMemberAddress(wMaintain.getMemberAddress());//维护地址 memberAddress
//			wRepair.setMaintainTime(wMaintain.getMaintainTime());//维护时间 maintainTime
//			wRepair.setMaintainType(wMaintain.getMaintainType());
//			wRepair.setOneFilterName(request.getParameter("filterNumOne"));
//			wRepair.setTwoFilterName(request.getParameter("filterNumTwo"));
//			wRepair.setThreeFilterName(request.getParameter("filterNumThree"));
//			wRepair.setFourFilterName(request.getParameter("filterNumFour"));
//			wRepair.setFiveFilterName(request.getParameter("filterNumFive"));
//			wRepair.setSixFilterName(request.getParameter("filterNumSix"));
//			wRepairServiceI.saveOrUpdate(wRepair);
		}catch(Exception e){
			e.printStackTrace();
			message = "安装工添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新安装工
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WMaintainEntity wMaintain, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "安装工更新成功";
		String registerName = request.getParameter("erectorCompany");
		if( registerName.isEmpty() ){
			j.setMsg("安装公司不能为空，请重新输入！");
			j.setSuccess(false);
			return j;
		}
		wMaintain.setRegisterName(registerName);
		WMaintainEntity t = wMaintainService.get(WMaintainEntity.class, wMaintain.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wMaintain, t);
			wMaintainService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "安装工更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 安装工新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WMaintainEntity wMaintain, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wMaintain.getId())) {
			wMaintain = wMaintainService.getEntity(WMaintainEntity.class, wMaintain.getId());
			req.setAttribute("wMaintainPage", wMaintain);
		}
		return new ModelAndView("jeecg/wmaintain/wmaintain-add");
	}
	/**
	 * 安装工编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WMaintainEntity wMaintain, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wMaintain.getId())) {
			wMaintain = wMaintainService.getEntity(WMaintainEntity.class, wMaintain.getId());
			req.setAttribute("wMaintainPage", wMaintain);
		}
		return new ModelAndView("jeecg/wmaintain/wmaintain-update");
	}
	
	/**
	 * 查询所有安装公司表选择
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "assign")
	public ModelAndView relationship(HttpServletRequest request) {
		//--author：zhoujf-----start----date:20150531--------for: 编辑用户，选择角色,弹出的角色列表页面，默认没选中
		ModelAndView mv = new ModelAndView("jeecg/uiFolder/erectorCompany");
		String ids = oConvertUtils.getString(request.getParameter("ids"));
		mv.addObject("ids", ids);
		return mv;
	}
	
	/**
	 * 注册用户显示列表
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "datagridErector")
	public void relationshipList(WErectorEntity werector, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WErectorEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, werector);
		try{
		//自定义追加查询条件
			CriterionList criterionList = new CriterionList();
			criterionList.addPara(0,Restrictions.eq("erectorState", 1));
			cq.setCriterionList(criterionList);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.systemService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 根据会员联系方式得到会员的设备
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "saveUserDevice")
	@ResponseBody
	public AjaxJson saveUserDevice(HttpServletRequest request,HttpServletResponse response) throws Exception {
		AjaxJson j = new AjaxJson();
		String memberPhone = request.getParameter("memberPhone");
		List<Map<String, Object>> userDevice = wUserDeviceService.selectUserDeviceByMemberPhone(memberPhone);
		if( userDevice == null || userDevice.size() == 0 || userDevice.isEmpty()){
			j.setMsg("该会员暂无设备");
			j.setSuccess(false);
			return j;
		}
		List<String> listDeviceId = new ArrayList<>();
		for(int i=0;i<userDevice.size();i++){
			String userDeviceId = oConvertUtils.getString(userDevice.get(i).get("device_id"));
			if( oConvertUtils.isNotEmpty(userDeviceId) ){
				listDeviceId.add(userDeviceId);
			}
		}
		List<Map<String, Object>> userDeviceList = WDeviceService.selectDeviceByListId(listDeviceId);
		if( userDeviceList.isEmpty() && userDeviceList.size() == 0 ) {
			j.setMsg("查询为空，数据错误或请联系管理员！");
			j.setSuccess(false);
			return j;
		}
		j.setObj(userDeviceList);
		j.setSuccess(true);
		return j;
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wMaintainController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WMaintainEntity wMaintain,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WMaintainEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wMaintain, request.getParameterMap());
		List<WMaintainEntity> wMaintains = this.wMaintainService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"w_maintain");
		modelMap.put(NormalExcelConstants.CLASS,WMaintainEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("安装工列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wMaintains);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WMaintainEntity wMaintain,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"w_maintain");
    	modelMap.put(NormalExcelConstants.CLASS,WMaintainEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("安装工列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<WMaintainEntity> listWMaintainEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WMaintainEntity.class,params);
				for (WMaintainEntity wMaintain : listWMaintainEntitys) {
					wMaintainService.save(wMaintain);
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
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<WMaintainEntity> list() {
		List<WMaintainEntity> listWMaintains=wMaintainService.getList(WMaintainEntity.class);
		return listWMaintains;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		WMaintainEntity task = wMaintainService.get(WMaintainEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody WMaintainEntity wMaintain, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WMaintainEntity>> failures = validator.validate(wMaintain);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			wMaintainService.save(wMaintain);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = wMaintain.getId();
		URI uri = uriBuilder.path("/rest/wMaintainController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody WMaintainEntity wMaintain) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WMaintainEntity>> failures = validator.validate(wMaintain);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			wMaintainService.saveOrUpdate(wMaintain);
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
		wMaintainService.deleteEntityById(WMaintainEntity.class, id);
	}
}
