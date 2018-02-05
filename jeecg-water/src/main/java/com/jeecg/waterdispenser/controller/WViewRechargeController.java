package com.jeecg.waterdispenser.controller;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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

import com.jeecg.waterdispenser.entity.WViewRechargeEntity;
import com.jeecg.waterdispenser.entity.WViewRecordEntity;
import com.jeecg.waterdispenser.service.WViewRechargeServiceI;
import com.jeecg.waterdispenser.service.WViewRecordServiceI;

/**   
 * @Title: Controller  
 * @Description: 充值报表
 * @author onlineGenerator
 * @date 2017-10-15 00:39:43
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wViewRechargeController")
public class WViewRechargeController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WViewRechargeController.class);

	@Autowired
	private WViewRechargeServiceI wViewRechargeService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private WViewRecordServiceI wViewRecordServiceI;
	


	/**
	 * 充值报表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("jeecg/wviewrecharge/wViewRechargeList");
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
	public void datagrid(WViewRechargeEntity wViewRecharge,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WViewRechargeEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wViewRecharge, request.getParameterMap());
		try{
			String saveName = request.getParameter("saveName");
			if( oConvertUtils.isNotEmpty(saveName) && "saveDate".equals(saveName) ){
				//条件查询
				String operatetime_begin = request.getParameter("operatetime_begin");
				String operatetime_end = request.getParameter("operatetime_end");
		        if(oConvertUtils.isNotEmpty(operatetime_begin)){
		        	try {
						cq.ge("rechargeDate", DateUtils.parseDate(operatetime_begin, "yyyy-MM-dd hh:mm:ss"));
					} catch (ParseException e) {
						logger.error(e);
					}
		        	cq.add();
		        }
		        if(oConvertUtils.isNotEmpty(operatetime_end)){
		        	try {
						cq.le("rechargeDate", DateUtils.parseDate(operatetime_end, "yyyy-MM-dd hh:mm:ss"));
					} catch (ParseException e) {
						logger.error(e);
					}
		        	cq.add();
		        }
			}else {
				//将试图数据查除之后插入表格进行查询
				List<Map<String, Object>> list = wViewRechargeService.listViewRechargee();
				if( !list.isEmpty() && list.size() > 0 ){
					for (Map<String, Object> map : list) {
						mapAndWViewRechargeEntity(map);
					}
					WViewRecordEntity wViewRecordEntity = wViewRecordServiceI.findUniqueByProperty(WViewRecordEntity.class, "name", "w_view_recharge");
					if( wViewRecordEntity == null ){
						wViewRecordEntity = new WViewRecordEntity();
						wViewRecordEntity.setName("w_view_recharge");
					}
					Integer str = wViewRecordEntity.getCount();
					wViewRecordEntity.setCount(str == null ? 1 : str+1);
					wViewRecordServiceI.saveOrUpdate(wViewRecordEntity);
				}
			}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.wViewRechargeService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	public WViewRechargeEntity mapAndWViewRechargeEntity(Map<String, Object> map) throws Exception{
		WViewRechargeEntity wView = new WViewRechargeEntity();
		try {
			Field[] field = wView.getClass().getDeclaredFields();
	        Iterator<String> iter = map.keySet().iterator(); 
	        while(iter.hasNext()){ 
	            String key=iter.next();
	    		for (Field str : field) {
	    			String name = str.getName();
	    			if( key.equals(name) ){
	    				name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
	    				String type = str.getGenericType().toString(); // 获取属性的类型
	                    if (type.equals("class java.lang.String")) { // 如果type是类类型，则前面包含"class "，后面跟类名
	                        Method m = wView.getClass().getMethod("get" + name);
	                        String value = (String) m.invoke(wView); // 调用getter方法获取属性值
	                        if (value == null) {
	                            m = wView.getClass().getMethod("set"+name,String.class);
	                            m.invoke(wView, oConvertUtils.getString(map.get(key)));
	                        }
	                    }
	                    if (type.equals("class java.lang.Integer")) {
	                        Method m = wView.getClass().getMethod("get" + name);
	                        Integer value = (Integer) m.invoke(wView);
	                        if (value == null) {
	                            m = wView.getClass().getMethod("set"+name,Integer.class);
	                            String string = oConvertUtils.getString(map.get(key));
	                            if( oConvertUtils.isNotEmpty(string) )
	                            	m.invoke(wView, Integer.valueOf(string));
	                            else
	                            	m.invoke(wView, 0);
	                        }
	                    }
	                    if (type.equals("class java.util.Date")) {
	                        Method m = wView.getClass().getMethod("get" + name);
	                        Date value = (Date) m.invoke(wView);
	                        if (value == null) {
	                            m = wView.getClass().getMethod("set"+name,Date.class);
	                            String strDate = oConvertUtils.getString(map.get(key));
	                            SimpleDateFormat df = null;
	                            if( strDate.length() == 10 )
	                            	df = new SimpleDateFormat("yyyy-MM-dd");
	                            else 
	                            	df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								
		                 		java.util.Date date = df.parse(oConvertUtils.getString(map.get(key)));
		                        m.invoke(wView, date);
	                        }
	                    }
	                    
	    			}
	    		}
	        }
	        wViewRechargeService.saveOrUpdate(wView);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
        return wView;
	}
	
	/**
	 * 删除充值报表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WViewRechargeEntity wViewRecharge, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wViewRecharge = systemService.getEntity(WViewRechargeEntity.class, wViewRecharge.getId());
		message = "充值报表删除成功";
		try{
			wViewRechargeService.delete(wViewRecharge);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "充值报表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除充值报表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "充值报表删除成功";
		try{
			for(String id:ids.split(",")){
				WViewRechargeEntity wViewRecharge = systemService.getEntity(WViewRechargeEntity.class, 
				id
				);
				wViewRechargeService.delete(wViewRecharge);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "充值报表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加充值报表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WViewRechargeEntity wViewRecharge, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "充值报表添加成功";
		try{
			wViewRechargeService.save(wViewRecharge);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "充值报表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新充值报表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WViewRechargeEntity wViewRecharge, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "充值报表更新成功";
		WViewRechargeEntity t = wViewRechargeService.get(WViewRechargeEntity.class, wViewRecharge.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wViewRecharge, t);
			wViewRechargeService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "充值报表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 充值报表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WViewRechargeEntity wViewRecharge, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wViewRecharge.getId())) {
			wViewRecharge = wViewRechargeService.getEntity(WViewRechargeEntity.class, wViewRecharge.getId());
			req.setAttribute("wViewRechargePage", wViewRecharge);
		}
		return new ModelAndView("jeecg/wviewrecharge/wViewRecharge-add");
	}
	/**
	 * 充值报表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WViewRechargeEntity wViewRecharge, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wViewRecharge.getId())) {
			wViewRecharge = wViewRechargeService.getEntity(WViewRechargeEntity.class, wViewRecharge.getId());
			req.setAttribute("wViewRechargePage", wViewRecharge);
		}
		return new ModelAndView("jeecg/wviewrecharge/wViewRecharge-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wViewRechargeController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WViewRechargeEntity wViewRecharge,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WViewRechargeEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wViewRecharge, request.getParameterMap());
		List<WViewRechargeEntity> wViewRecharges = this.wViewRechargeService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"充值报表");
		modelMap.put(NormalExcelConstants.CLASS,WViewRechargeEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("充值报表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wViewRecharges);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WViewRechargeEntity wViewRecharge,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"充值报表");
    	modelMap.put(NormalExcelConstants.CLASS,WViewRechargeEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("充值报表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
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
				List<WViewRechargeEntity> listWViewRechargeEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WViewRechargeEntity.class,params);
				for (WViewRechargeEntity wViewRecharge : listWViewRechargeEntitys) {
					wViewRechargeService.save(wViewRecharge);
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
	public List<WViewRechargeEntity> list() {
		List<WViewRechargeEntity> listWViewRecharges=wViewRechargeService.getList(WViewRechargeEntity.class);
		return listWViewRecharges;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		WViewRechargeEntity task = wViewRechargeService.get(WViewRechargeEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody WViewRechargeEntity wViewRecharge, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WViewRechargeEntity>> failures = validator.validate(wViewRecharge);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			wViewRechargeService.save(wViewRecharge);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = wViewRecharge.getId();
		URI uri = uriBuilder.path("/rest/wViewRechargeController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody WViewRechargeEntity wViewRecharge) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WViewRechargeEntity>> failures = validator.validate(wViewRecharge);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			wViewRechargeService.saveOrUpdate(wViewRecharge);
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
		wViewRechargeService.deleteEntityById(WViewRechargeEntity.class, id);
	}
}
