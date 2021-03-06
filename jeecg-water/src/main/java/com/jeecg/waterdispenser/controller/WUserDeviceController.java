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

import com.jeecg.waterdispenser.entity.WDeviceEntity;
import com.jeecg.waterdispenser.entity.WDeviceTypeEntity;
import com.jeecg.waterdispenser.entity.WUserDeviceEntity;
import com.jeecg.waterdispenser.service.WDeviceServiceI;
import com.jeecg.waterdispenser.service.WDeviceTypeServiceI;
import com.jeecg.waterdispenser.service.WUserDeviceServiceI;

/**   
 * @Title: Controller  
 * @Description: 用户关联设备表
 * @author onlineGenerator
 * @date 2017-08-20 16:55:18
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wUserDeviceController")
public class WUserDeviceController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WUserDeviceController.class);

	@Autowired
	private WUserDeviceServiceI wUserDeviceService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private WDeviceServiceI wDeviceServiceI;
	@Autowired
	private WDeviceTypeServiceI wDeviceTypeServiceI;
	


	/**
	 * 用户关联设备表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("jeecg/wuserdevice/wUserDeviceList");
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
	public void datagrid(WUserDeviceEntity wUserDevice,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WUserDeviceEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wUserDevice, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.wUserDeviceService.getDataGridReturn(cq, true);
//		List<WUserDeviceEntity> list = dataGrid.getResults();
//		Map<String,Map<String,Object>> extMap = new HashMap<String, Map<String,Object>>();
//		for (WUserDeviceEntity wUserDeviceEntity : list) {
//			String deviceName = "";
//			String deviceTypeName = "";
//			if( oConvertUtils.isNotEmpty(wUserDeviceEntity.getDeviceId()) ){
//				WDeviceEntity wdevice = wDeviceServiceI.findUniqueByProperty(WDeviceEntity.class, "deviceId", wUserDeviceEntity.getDeviceId());
//				deviceName = wdevice.getDeviceName();
//			}
//			if( oConvertUtils.isNotEmpty(wUserDeviceEntity.getDeviceTypeId()) ){
//				WDeviceTypeEntity wdeviceType = wDeviceTypeServiceI.findUniqueByProperty(WDeviceTypeEntity.class, "id", wUserDeviceEntity.getDeviceTypeId());
//				deviceTypeName = wdeviceType.getDeviceName();
//			}
//		}
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除用户关联设备表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WUserDeviceEntity wUserDevice, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wUserDevice = systemService.getEntity(WUserDeviceEntity.class, wUserDevice.getId());
		message = "用户关联设备表删除成功";
		try{
			wUserDeviceService.delete(wUserDevice);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "用户关联设备表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除用户关联设备表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "用户关联设备表删除成功";
		try{
			for(String id:ids.split(",")){
				WUserDeviceEntity wUserDevice = systemService.getEntity(WUserDeviceEntity.class, 
				id
				);
				wUserDeviceService.delete(wUserDevice);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "用户关联设备表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加用户关联设备表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WUserDeviceEntity wUserDevice, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "用户关联设备表添加成功";
		try{
			wUserDeviceService.save(wUserDevice);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "用户关联设备表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新用户关联设备表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WUserDeviceEntity wUserDevice, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "用户关联设备表更新成功";
		WUserDeviceEntity t = wUserDeviceService.get(WUserDeviceEntity.class, wUserDevice.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wUserDevice, t);
			wUserDeviceService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "用户关联设备表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 用户关联设备表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WUserDeviceEntity wUserDevice, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wUserDevice.getId())) {
			wUserDevice = wUserDeviceService.getEntity(WUserDeviceEntity.class, wUserDevice.getId());
			req.setAttribute("wUserDevicePage", wUserDevice);
		}
		return new ModelAndView("jeecg/wuserdevice/wUserDevice-add");
	}
	/**
	 * 用户关联设备表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WUserDeviceEntity wUserDevice, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wUserDevice.getId())) {
			wUserDevice = wUserDeviceService.getEntity(WUserDeviceEntity.class, wUserDevice.getId());
			req.setAttribute("wUserDevicePage", wUserDevice);
		}
		return new ModelAndView("jeecg/wuserdevice/wUserDevice-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wUserDeviceController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WUserDeviceEntity wUserDevice,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WUserDeviceEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wUserDevice, request.getParameterMap());
		List<WUserDeviceEntity> wUserDevices = this.wUserDeviceService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"用户关联设备表");
		modelMap.put(NormalExcelConstants.CLASS,WUserDeviceEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("用户关联设备表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wUserDevices);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WUserDeviceEntity wUserDevice,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"用户关联设备表");
    	modelMap.put(NormalExcelConstants.CLASS,WUserDeviceEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("用户关联设备表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<WUserDeviceEntity> listWUserDeviceEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WUserDeviceEntity.class,params);
				for (WUserDeviceEntity wUserDevice : listWUserDeviceEntitys) {
					wUserDeviceService.save(wUserDevice);
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
	public List<WUserDeviceEntity> list() {
		List<WUserDeviceEntity> listWUserDevices=wUserDeviceService.getList(WUserDeviceEntity.class);
		return listWUserDevices;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		WUserDeviceEntity task = wUserDeviceService.get(WUserDeviceEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody WUserDeviceEntity wUserDevice, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WUserDeviceEntity>> failures = validator.validate(wUserDevice);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			wUserDeviceService.save(wUserDevice);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = wUserDevice.getId();
		URI uri = uriBuilder.path("/rest/wUserDeviceController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody WUserDeviceEntity wUserDevice) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WUserDeviceEntity>> failures = validator.validate(wUserDevice);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			wUserDeviceService.saveOrUpdate(wUserDevice);
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
		wUserDeviceService.deleteEntityById(WUserDeviceEntity.class, id);
	}
}
