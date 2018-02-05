package com.jeecg.waterdispenser.controller;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
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
import com.jeecg.waterdispenser.entity.WUserRegisterEntity;
import com.jeecg.waterdispenser.service.WErectorServiceI;
import com.jeecg.waterdispenser.service.WUserRegisterServiceI;

/**   
 * @Title: Controller  
 * @Description: 安装工
 * @author onlineGenerator
 * @date 2017-07-20 21:01:04
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/werectorController")
public class WErectorController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WErectorController.class);

	@Autowired
	private WErectorServiceI wErectorService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private WUserRegisterServiceI wUserRegisterServiceI;
	


	/**
	 * 安装工列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("jeecg/werector/werectorList");
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
	public void datagrid(WErectorEntity wErector,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WErectorEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wErector, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.wErectorService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除安装工
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WErectorEntity wErector, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wErector = systemService.getEntity(WErectorEntity.class, wErector.getId());
		message = "安装工删除成功";
		try{
			int state = wErector.getErectorState();
			if( state == 1){
				j.setMsg("删除失败，有效账号不能删除!");
				j.setSuccess(false);
				return j;
			}
			wErectorService.delete(wErector);
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
	 * 批量删除安装工
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
				WErectorEntity wErector = systemService.getEntity(WErectorEntity.class, 
				id
				);
				wErectorService.delete(wErector);
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
	public AjaxJson doAdd(WErectorEntity wErector, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "安装公司添加成功";
		try{
			String erectorAdminId = wErector.getErectorAdminId();
			if( oConvertUtils.isNotEmpty(erectorAdminId) ){
				List<WErectorEntity> werector = wErectorService.findByProperty(WErectorEntity.class, "erectorAdminId", erectorAdminId);
				if( werector != null && !werector.isEmpty() ){
					j.setSuccess(false);
					j.setMsg("该后台用户已被绑定，请重新选择!");
					return j;
				}
			}
			wErectorService.save(wErector);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
//			e.printStackTrace();
//			message = "安装工添加失败";
			throw new BusinessException("安装公司重复或系统错误，请联系管理员!");
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
	public AjaxJson doUpdate(WErectorEntity wErector, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "安装工更新成功";
		WErectorEntity t = wErectorService.get(WErectorEntity.class, wErector.getId());
		try {
			String erectorAdmin = wErector.getErectorAdmin();
			if( oConvertUtils.isNotEmpty(erectorAdmin) ){
				List<WErectorEntity> werector = wErectorService.findByProperty(WErectorEntity.class, "erectorAdmin", erectorAdmin);
				if( werector != null && !werector.isEmpty() && werector.size() > 1){
					j.setSuccess(false);
					j.setMsg("改后台用户已被绑定，请重新选择!");
					return j;
				}
			}
			//更新之前判断联系方式是否更改，如果更改则需更改所有安装工人的关联关系
			WErectorEntity erector = wErectorService.findUniqueByProperty(WErectorEntity.class, "id", wErector.getId());
			if( erector != null ){
				String erectorPhone = erector.getErectorPhone();
				if( !erectorPhone.equals(wErector.getErectorPhone()) ){
					List<WUserRegisterEntity> userRegister = wUserRegisterServiceI.findByProperty(WUserRegisterEntity.class, "memberPhone", erectorPhone);
					for (WUserRegisterEntity strUserRegister : userRegister) {
						strUserRegister.setMemberPhone(wErector.getErectorPhone());
						wUserRegisterServiceI.saveOrUpdate(strUserRegister);
					}
				}
			}
			MyBeanUtils.copyBeanNotNull2Bean(wErector, t);
			wErectorService.saveOrUpdate(t);
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
	 * 自定义按钮-[有效]业务
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doEffective")
	@ResponseBody
	public AjaxJson doEffective(WErectorEntity wErector, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "有效成功";
		WErectorEntity t = wErectorService.get(WErectorEntity.class, wErector.getId());
		try{
			wErectorService.doEffectiveBus(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "有效失败";
		}
		j.setMsg(message);
		return j;
	}
 	/**
	 * 自定义按钮-[无效]业务
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doInvalid")
	@ResponseBody
	public AjaxJson doInvalid(WErectorEntity wErector, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "无效成功";
		WErectorEntity t = wErectorService.get(WErectorEntity.class, wErector.getId());
		try{
			wErectorService.doInvalidBus(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "无效失败";
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
	public ModelAndView goAdd(WErectorEntity wErector, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wErector.getId())) {
			wErector = wErectorService.getEntity(WErectorEntity.class, wErector.getId());
			req.setAttribute("wErectorPage", wErector);
		}
		return new ModelAndView("jeecg/werector/werector-add");
	}
	/**
	 * 安装工编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WErectorEntity wErector, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wErector.getId())) {
			wErector = wErectorService.getEntity(WErectorEntity.class, wErector.getId());
			req.setAttribute("wErectorPage", wErector);
		}
		return new ModelAndView("jeecg/werector/werector-update");
	}
	
	/**
	 * 查询所有安装工人表选择
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "assign")
	public ModelAndView relationship(HttpServletRequest request) {
		//--author：zhoujf-----start----date:20150531--------for: 编辑用户，选择角色,弹出的角色列表页面，默认没选中
		ModelAndView mv = new ModelAndView("jeecg/uiFolder/erector");
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
	public void relationshipList(WUserRegisterEntity wuserRegister, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WUserRegisterEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuserRegister);
		try{
		//自定义追加查询条件
			CriterionList criterionList = new CriterionList();
			criterionList.addPara(0,Restrictions.eq("registerType", "2"));
			cq.setCriterionList(criterionList);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.systemService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wErectorController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WErectorEntity wErector,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WErectorEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wErector, request.getParameterMap());
		List<WErectorEntity> wErectors = this.wErectorService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"安装工");
		modelMap.put(NormalExcelConstants.CLASS,WErectorEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("安装工列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wErectors);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WErectorEntity wErector,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"安装工");
    	modelMap.put(NormalExcelConstants.CLASS,WErectorEntity.class);
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
				List<WErectorEntity> listWErectorEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WErectorEntity.class,params);
				for (WErectorEntity wErector : listWErectorEntitys) {
					wErectorService.save(wErector);
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
	public List<WErectorEntity> list() {
		List<WErectorEntity> listWErectors=wErectorService.getList(WErectorEntity.class);
		return listWErectors;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		WErectorEntity task = wErectorService.get(WErectorEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody WErectorEntity wErector, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WErectorEntity>> failures = validator.validate(wErector);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			wErectorService.save(wErector);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = wErector.getId();
		URI uri = uriBuilder.path("/rest/wErectorController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody WErectorEntity wErector) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WErectorEntity>> failures = validator.validate(wErector);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			wErectorService.saveOrUpdate(wErector);
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
		wErectorService.deleteEntityById(WErectorEntity.class, id);
	}
}
