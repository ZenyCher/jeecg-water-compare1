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
import org.jeecgframework.core.util.DateUtils;
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

import com.jeecg.waterdispenser.entity.WRechargeStatisticsEntity;
import com.jeecg.waterdispenser.service.WRechargeStatisticsServiceI;

import antlr.StringUtils;

/**   
 * @Title: Controller  
 * @Description: 会员充值统计
 * @author onlineGenerator
 * @date 2017-06-15 11:19:02
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wRechargeStatisticsController")
public class WRechargeStatisticsController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WRechargeStatisticsController.class);

	@Autowired
	private WRechargeStatisticsServiceI wRechargeStatisticsService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 会员充值统计列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("jeecg/wrechargestatistics/wRechargeStatisticsList");
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
	public void datagrid(WRechargeStatisticsEntity wRechargeStatistics,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) throws Exception {
		CriteriaQuery cq = new CriteriaQuery(WRechargeStatisticsEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wRechargeStatistics, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.wRechargeStatisticsService.getDataGridReturn(cq, true);
		List<WRechargeStatisticsEntity> list1 = new ArrayList<WRechargeStatisticsEntity>();
		//获取前台传过来的type参数。判定是那种统计方式 0为日统计， 1为月统计，2为年统计
		String type = wRechargeStatistics.getSysCompanyCode();
		if(StringUtil.isNotEmpty(wRechargeStatistics.getMemberName())){
			list1 = wRechargeStatisticsService.saveMemberName(wRechargeStatistics.getMemberName());
		}else if(StringUtil.isNotEmpty(type)){
			if("0".equals(type))
				list1 = wRechargeStatisticsService.dayStatistics();
			if("1".equals(type))
				list1 = wRechargeStatisticsService.monthStatistics();
			if("2".equals(type))
				list1 = wRechargeStatisticsService.yaerStatistics();
		}else {
			list1 = wRechargeStatisticsService.saveStatistics();
		}
		/*
		 * 说明：格式为 字段名:值(可选，不写该值时为分页数据的合计) 多个合计 以 , 分割
		 */
		//dataGrid.setFooter("salary:"+(total_salary.equalsIgnoreCase("null")?"0.0":total_salary)+",age,email:合计");
		dataGrid.setResults(list1);
		List<WRechargeStatisticsEntity> list= dataGrid.getResults();
		Map<String,Map<String,Object>> extMap = new HashMap<String, Map<String,Object>>();
		for(WRechargeStatisticsEntity temp : list){
			String str = wRechargeStatisticsService.saveString(temp.getMemberPhone(),type);
	        //此为针对原来的行数据，拓展的新字段
	        Map m = new HashMap();
	        m.put("rechargeStatistics1",str);
	        extMap.put(temp.getId(), m);
		}
		//dataGrid.setFooter("extField,salary,age,name:合计");
		TagUtil.datagrid(response, dataGrid,extMap);
//		dataGrid.setFooter("salary,age,name:合计");
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除会员充值统计
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WRechargeStatisticsEntity wRechargeStatistics, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wRechargeStatistics = systemService.getEntity(WRechargeStatisticsEntity.class, wRechargeStatistics.getId());
		message = "会员充值统计删除成功";
		try{
			wRechargeStatisticsService.delete(wRechargeStatistics);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "会员充值统计删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除会员充值统计
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "会员充值统计删除成功";
		try{
			for(String id:ids.split(",")){
				WRechargeStatisticsEntity wRechargeStatistics = systemService.getEntity(WRechargeStatisticsEntity.class, 
				id
				);
				wRechargeStatisticsService.delete(wRechargeStatistics);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "会员充值统计删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加会员充值统计
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WRechargeStatisticsEntity wRechargeStatistics, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "会员充值统计添加成功";
		try{
			wRechargeStatisticsService.save(wRechargeStatistics);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "会员充值统计添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新会员充值统计
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WRechargeStatisticsEntity wRechargeStatistics, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "会员充值统计更新成功";
		WRechargeStatisticsEntity t = wRechargeStatisticsService.get(WRechargeStatisticsEntity.class, wRechargeStatistics.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wRechargeStatistics, t);
			wRechargeStatisticsService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "会员充值统计更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 会员充值统计新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WRechargeStatisticsEntity wRechargeStatistics, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wRechargeStatistics.getId())) {
			wRechargeStatistics = wRechargeStatisticsService.getEntity(WRechargeStatisticsEntity.class, wRechargeStatistics.getId());
			req.setAttribute("wRechargeStatisticsPage", wRechargeStatistics);
		}
		return new ModelAndView("com/jeecg/wrechargeStatistics/wRechargeStatistics-add");
	}
	/**
	 * 会员充值统计编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WRechargeStatisticsEntity wRechargeStatistics, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wRechargeStatistics.getId())) {
			wRechargeStatistics = wRechargeStatisticsService.getEntity(WRechargeStatisticsEntity.class, wRechargeStatistics.getId());
			req.setAttribute("wRechargeStatisticsPage", wRechargeStatistics);
		}
		return new ModelAndView("com/jeecg/wrechargeStatistics/wRechargeStatistics-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wRechargeStatisticsController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WRechargeStatisticsEntity wRechargeStatistics,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WRechargeStatisticsEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wRechargeStatistics, request.getParameterMap());
		List<WRechargeStatisticsEntity> wRechargeStatisticss = this.wRechargeStatisticsService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"会员充值统计");
		modelMap.put(NormalExcelConstants.CLASS,WRechargeStatisticsEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("会员充值统计列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wRechargeStatisticss);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WRechargeStatisticsEntity wRechargeStatistics,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"会员充值统计");
    	modelMap.put(NormalExcelConstants.CLASS,WRechargeStatisticsEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("会员充值统计列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<WRechargeStatisticsEntity> listWRechargeStatisticsEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WRechargeStatisticsEntity.class,params);
				for (WRechargeStatisticsEntity wRechargeStatistics : listWRechargeStatisticsEntitys) {
					wRechargeStatisticsService.save(wRechargeStatistics);
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
	public List<WRechargeStatisticsEntity> list() {
		List<WRechargeStatisticsEntity> listWRechargeStatisticss=wRechargeStatisticsService.getList(WRechargeStatisticsEntity.class);
		return listWRechargeStatisticss;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		WRechargeStatisticsEntity task = wRechargeStatisticsService.get(WRechargeStatisticsEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody WRechargeStatisticsEntity wRechargeStatistics, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WRechargeStatisticsEntity>> failures = validator.validate(wRechargeStatistics);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			wRechargeStatisticsService.save(wRechargeStatistics);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = wRechargeStatistics.getId();
		URI uri = uriBuilder.path("/rest/wRechargeStatisticsController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody WRechargeStatisticsEntity wRechargeStatistics) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WRechargeStatisticsEntity>> failures = validator.validate(wRechargeStatistics);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			wRechargeStatisticsService.saveOrUpdate(wRechargeStatistics);
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
		wRechargeStatisticsService.deleteEntityById(WRechargeStatisticsEntity.class, id);
	}
}
