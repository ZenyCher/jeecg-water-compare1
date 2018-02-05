package com.jeecg.waterdispenser.controller;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.SysexMessage;
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

import com.jeecg.waterdispenser.entity.WFilterEntity;
import com.jeecg.waterdispenser.service.WFilterServiceI;

/**   
 * @Title: Controller  
 * @Description: 滤芯设备
 * @author onlineGenerator
 * @date 2017-07-06 11:44:24
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wFilterController")
public class WFilterController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WFilterController.class);

	@Autowired
	private WFilterServiceI wFilterService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 滤芯设备列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("jeecg/wfilter/wFilterList");
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
	public void datagrid(WFilterEntity wFilter,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WFilterEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wFilter, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.wFilterService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除滤芯设备
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WFilterEntity wFilter, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wFilter = systemService.getEntity(WFilterEntity.class, wFilter.getId());
		message = "滤芯设备删除成功";
		try{
			wFilterService.delete(wFilter);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "滤芯设备删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除滤芯设备
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "滤芯设备删除成功";
		try{
			for(String id:ids.split(",")){
				WFilterEntity wFilter = systemService.getEntity(WFilterEntity.class, 
				id
				);
				wFilterService.delete(wFilter);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "滤芯设备删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加滤芯设备
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WFilterEntity wFilter, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "滤芯设备添加成功";
		try{
			String filterId = wFilter.getFilterId();
			Long str = wFilterService.selectByFilterIdCount(filterId);
			if(str > 0){
				j.setMsg("滤芯重复，请重新输入");
				j.setSuccess(false);
				return j;
			}
			wFilter.setFilterState(0);
			wFilterService.save(wFilter);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "滤芯设备添加失败";
			throw new BusinessException("滤芯设备添加失败");
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新滤芯设备
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WFilterEntity wFilter, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "滤芯设备更新成功";
		WFilterEntity t = wFilterService.get(WFilterEntity.class, wFilter.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wFilter, t);
			wFilterService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "滤芯设备更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 滤芯设备新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WFilterEntity wFilter, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wFilter.getId())) {
			wFilter = wFilterService.getEntity(WFilterEntity.class, wFilter.getId());
			req.setAttribute("wFilterPage", wFilter);
		}
		return new ModelAndView("jeecg/wfilter/wFilter-add");
	}
	/**
	 * 滤芯设备编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WFilterEntity wFilter, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wFilter.getId())) {
			wFilter = wFilterService.getEntity(WFilterEntity.class, wFilter.getId());
			req.setAttribute("wFilterPage", wFilter);
		}
		return new ModelAndView("jeecg/wfilter/wFilter-update");
	}
	
	/**
	 * 跳转验真页面
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "theTrue")
	public ModelAndView theTrue(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("jeecg/wfilter/filterTheTrue");
		return mv;
	}
	
	/**
	 * 滤芯验真
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "saveTheTrue")
	@ResponseBody
	public AjaxJson saveTheTrue(HttpServletRequest request,HttpServletResponse response) {
		String message = null;
		AjaxJson j = new AjaxJson();
		try {
			String filterCode = request.getParameter("filterCode");
			Boolean fals = wFilterService.selectTheTrue(filterCode);
			if( fals ){
				j.setSuccess(fals);
				message = "该防伪码正确，该滤芯是正品。";
			}else {
				j.setSuccess(fals);
				message = "该防伪码错误，该滤芯不是正品。";
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "该防伪码错误，该滤芯不是正品。";
			throw new BusinessException("该防伪码错误，该滤芯不是正品。");
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wFilterController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WFilterEntity wFilter,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WFilterEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wFilter, request.getParameterMap());
		List<WFilterEntity> wFilters = this.wFilterService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"滤芯设备");
		modelMap.put(NormalExcelConstants.CLASS,WFilterEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("滤芯设备列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wFilters);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WFilterEntity wFilter,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"滤芯设备");
    	modelMap.put(NormalExcelConstants.CLASS,WFilterEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("滤芯设备列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<WFilterEntity> listWFilterEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WFilterEntity.class,params);
				for (WFilterEntity wFilter : listWFilterEntitys) {
					wFilterService.save(wFilter);
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
	public List<WFilterEntity> list() {
		List<WFilterEntity> listWFilters=wFilterService.getList(WFilterEntity.class);
		return listWFilters;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		WFilterEntity task = wFilterService.get(WFilterEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody WFilterEntity wFilter, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WFilterEntity>> failures = validator.validate(wFilter);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			wFilterService.save(wFilter);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = wFilter.getId();
		URI uri = uriBuilder.path("/rest/wFilterController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody WFilterEntity wFilter) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WFilterEntity>> failures = validator.validate(wFilter);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			wFilterService.saveOrUpdate(wFilter);
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
		wFilterService.deleteEntityById(WFilterEntity.class, id);
	}
}
