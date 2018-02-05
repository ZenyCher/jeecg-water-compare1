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
import org.jeecgframework.core.beanvalidator.BeanValidators;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
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

import com.jeecg.waterdispenser.api.wdeviceRestController;
import com.jeecg.waterdispenser.entity.WDeviceTypeEntity;
import com.jeecg.waterdispenser.service.WDeviceTypeServiceI;

/**   
 * @Title: Controller  
 * @Description: 净水器类型
 * @author onlineGenerator
 * @date 2017-08-03 20:04:47
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wDeviceTypeController")
public class WDeviceTypeController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WDeviceTypeController.class);

	@Autowired
	private WDeviceTypeServiceI wDeviceTypeService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 净水器类型列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("jeecg/wdevicetype/wDeviceTypeList");
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
	public void datagrid(WDeviceTypeEntity wDeviceType,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WDeviceTypeEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wDeviceType, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.wDeviceTypeService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除净水器类型
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WDeviceTypeEntity wDeviceType, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wDeviceType = systemService.getEntity(WDeviceTypeEntity.class, wDeviceType.getId());
		message = "净水器类型删除成功";
		try{
			wDeviceTypeService.delete(wDeviceType);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "净水器类型删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除净水器类型
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "净水器类型删除成功";
		try{
			for(String id:ids.split(",")){
				WDeviceTypeEntity wDeviceType = systemService.getEntity(WDeviceTypeEntity.class, 
				id
				);
				wDeviceTypeService.delete(wDeviceType);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "净水器类型删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加净水器类型
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WDeviceTypeEntity wDeviceType, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "净水器类型添加成功";
		try{
			wDeviceTypeService.save(wDeviceType);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
//			j.setMsg("净水器类型重复或系统错误，请联系管理员!");
//			j.setSuccess(false);
//			return j;
//			e.printStackTrace();
//			message = "净水器类型添加失败";
			throw new BusinessException("净水器类型重复或系统错误，请联系管理员!");
		}
		j.setMsg(message);
		return j;
	}
	
	/**判断滤芯更换是否为空*/
	public AjaxJson verificationFilter(WDeviceTypeEntity wDeviceTypeEntity){
		AjaxJson j = new AjaxJson();
		if( wDeviceTypeEntity != null ){
			if( oConvertUtils.isEmpty(wDeviceTypeEntity.getFilterNumOne()) ){
				j.setMsg("滤芯1更换不能为空！");
				j.setSuccess(false);
			}else if( oConvertUtils.isEmpty(wDeviceTypeEntity.getFilterNumTwo()) ){
				j.setMsg("滤芯2更换不能为空！");
				j.setSuccess(false);
			}else if( oConvertUtils.isEmpty(wDeviceTypeEntity.getFilterNumThree()) ){
				j.setMsg("滤芯3更换不能为空！");
				j.setSuccess(false);
			}
			Integer type = wDeviceTypeEntity.getDeviceFilterNum();
			if( type == 6 ){
				if( oConvertUtils.isEmpty(wDeviceTypeEntity.getFilterNumSix()) ){
					j.setMsg("滤芯6更换不能为空！");
					j.setSuccess(false);
				}else if( oConvertUtils.isEmpty(wDeviceTypeEntity.getFilterNumFive()) ){
					j.setMsg("滤芯5更换不能为空！");
					j.setSuccess(false);
				}else if( oConvertUtils.isEmpty(wDeviceTypeEntity.getFilterNumFour()) ){
					j.setMsg("滤芯4更换不能为空！");
					j.setSuccess(false);
				}
			}else if( type == 5 ){
				if( oConvertUtils.isEmpty(wDeviceTypeEntity.getFilterNumFive()) ){
					j.setMsg("滤芯5更换不能为空！");
					j.setSuccess(false);
				}else if( oConvertUtils.isEmpty(wDeviceTypeEntity.getFilterNumFour()) ){
					j.setMsg("滤芯4更换不能为空！");
					j.setSuccess(false);
				}
			}else if( type == 4 ){
				if( oConvertUtils.isEmpty(wDeviceTypeEntity.getFilterNumFour()) ){
					j.setMsg("滤芯4更换不能为空！");
					j.setSuccess(false);
				}
			}
		}
		return j;
	}
	
	/**
	 * 更新净水器类型
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WDeviceTypeEntity wDeviceType, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "净水器类型更新成功";
//		j = verificationFilter(wDeviceType);
//		Boolean success = j.isSuccess();
//		if( !success ){
//			return j;
//		}
		WDeviceTypeEntity t = wDeviceTypeService.get(WDeviceTypeEntity.class, wDeviceType.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wDeviceType, t);
			wDeviceTypeService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "净水器类型更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 净水器类型新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WDeviceTypeEntity wDeviceType, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wDeviceType.getId())) {
			wDeviceType = wDeviceTypeService.getEntity(WDeviceTypeEntity.class, wDeviceType.getId());
			req.setAttribute("wDeviceTypePage", wDeviceType);
		}
		return new ModelAndView("jeecg/wdevicetype/wDeviceType-add");
	}
	/**
	 * 净水器类型编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WDeviceTypeEntity wDeviceType, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wDeviceType.getId())) {
			wDeviceType = wDeviceTypeService.getEntity(WDeviceTypeEntity.class, wDeviceType.getId());
			req.setAttribute("wDeviceTypePage", wDeviceType);
		}
		return new ModelAndView("jeecg/wdevicetype/wDeviceType-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wDeviceTypeController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WDeviceTypeEntity wDeviceType,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WDeviceTypeEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wDeviceType, request.getParameterMap());
		List<WDeviceTypeEntity> wDeviceTypes = this.wDeviceTypeService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"净水器类型");
		modelMap.put(NormalExcelConstants.CLASS,WDeviceTypeEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("净水器类型列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wDeviceTypes);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WDeviceTypeEntity wDeviceType,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"净水器类型");
    	modelMap.put(NormalExcelConstants.CLASS,WDeviceTypeEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("净水器类型列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<WDeviceTypeEntity> listWDeviceTypeEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WDeviceTypeEntity.class,params);
				for (WDeviceTypeEntity wDeviceType : listWDeviceTypeEntitys) {
					wDeviceTypeService.save(wDeviceType);
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
	public List<WDeviceTypeEntity> list() {
		List<WDeviceTypeEntity> listWDeviceTypes=wDeviceTypeService.getList(WDeviceTypeEntity.class);
		return listWDeviceTypes;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		WDeviceTypeEntity task = wDeviceTypeService.get(WDeviceTypeEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody WDeviceTypeEntity wDeviceType, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WDeviceTypeEntity>> failures = validator.validate(wDeviceType);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			wDeviceTypeService.save(wDeviceType);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = wDeviceType.getId();
		URI uri = uriBuilder.path("/rest/wDeviceTypeController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody WDeviceTypeEntity wDeviceType) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WDeviceTypeEntity>> failures = validator.validate(wDeviceType);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			wDeviceTypeService.saveOrUpdate(wDeviceType);
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
		wDeviceTypeService.deleteEntityById(WDeviceTypeEntity.class, id);
	}
}
