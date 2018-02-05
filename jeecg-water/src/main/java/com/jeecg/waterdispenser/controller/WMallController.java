package com.jeecg.waterdispenser.controller;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

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
import org.jeecgframework.p3.core.util.oConvertUtils;
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

import com.jeecg.waterdispenser.entity.WMallEntity;
import com.jeecg.waterdispenser.entity.WMallIntroduceEntity;
import com.jeecg.waterdispenser.service.WMallIntroduceServiceI;
import com.jeecg.waterdispenser.service.WMallServiceI;
/**   
 * @Title: Controller  
 * @Description: 净水器商城
 * @author onlineGenerator
 * @date 2017-06-02 21:29:31
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wmallController")
public class WMallController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WMallController.class);

	@Autowired
	private WMallServiceI wmallService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private CgFormFieldServiceI cgFormFieldService;
	@Autowired
	private WMallIntroduceServiceI wmallIntroduceServiceI;
	


	/**
	 * 净水器商城列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("jeecg/wmall/wmallList");
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
	public void datagrid(WMallEntity wmall,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WMallEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wmall, request.getParameterMap());
		try{
		//自定义追加查询条件
		String query_mallDeposit_begin = request.getParameter("mallDeposit_begin");
		String query_mallDeposit_end = request.getParameter("mallDeposit_end");
		if(StringUtil.isNotEmpty(query_mallDeposit_begin)){
			cq.ge("mallDeposit", Integer.parseInt(query_mallDeposit_begin));
		}
		if(StringUtil.isNotEmpty(query_mallDeposit_end)){
			cq.le("mallDeposit", Integer.parseInt(query_mallDeposit_end));
		}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.wmallService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除净水器商城
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WMallEntity wmall, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wmall = systemService.getEntity(WMallEntity.class, wmall.getId());
		message = "净水器商城删除成功";
		try{
			wmallService.delete(wmall);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "净水器商城删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除净水器商城
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "净水器商城删除成功";
		try{
			for(String id:ids.split(",")){
				WMallEntity wmall = systemService.getEntity(WMallEntity.class, 
				id
				);
				wmallService.delete(wmall);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "净水器商城删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加净水器商城
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WMallEntity wmall, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "净水器商城添加成功";
		try{
			//查询设备类型id
			List<Map<String, Object>> resultMap = wmallService.findForJdbc("select * from w_device_type where device_type=? and device_name=? and device_filter_num=?", wmall.getMallDeviceType(),wmall.getmallDeviceName(),
					wmall.getMallFilterNum());
			if(null != resultMap && resultMap.size() > 0) {
				wmall.setMallDeviceTypeId((String)resultMap.get(0).get("id"));
			}
			//判断deviceId 是否已经添加在商城里面
			 List<WMallEntity>  list = wmallService.findByProperty(WMallEntity.class, "mallDeviceTypeId", wmall.getMallDeviceTypeId());
			 if(null !=list && list.size() >0) {
				 j.setMsg("设备重复添加，请重新选择设备型号");
				 j.setSuccess(true);
				 return j;
			 }
			wmallService.save(wmall);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "净水器商城添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		j.setObj(wmall);
		return j;
	}
	
	/**
	 * 更新净水器商城
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WMallEntity wmall, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "净水器商城更新成功";
		//去除附件字段多余逗号
		String mallOperation = wmall.getMallOperation();
		String mallImage = wmall.getMallImage();
		if( oConvertUtils.isNotEmpty(mallOperation) && oConvertUtils.isNotEmpty(mallImage) ){
			if( mallOperation.contains(",") || mallImage.contains(",") ){
				mallOperation = mallOperation.replace(",", "");
				mallImage = mallImage.replace(",", "");
			}
		}
		wmall.setMallImage(mallImage);
		wmall.setMallOperation(mallOperation);
		WMallEntity t = wmallService.get(WMallEntity.class, wmall.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wmall, t);
			wmallService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "净水器商城更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 净水器商城新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WMallEntity wmall, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wmall.getId())) {
			wmall = wmallService.getEntity(WMallEntity.class, wmall.getId());
			req.setAttribute("wmallPage", wmall);
		}
		return new ModelAndView("jeecg/wmall/wmall-add");
	}
	
	/**
	 * 查看商城产品详情页面
	 * @param id
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "saveMallIntroduce")
	public ModelAndView test(String id,HttpServletRequest req) throws Exception{
		WMallEntity wmall = new WMallEntity();
		wmall = wmallService.getEntity(WMallEntity.class, id);
		WMallIntroduceEntity wmallIntroduce = wmallIntroduceServiceI.seeWMallIntroduce(id);
		if( wmallIntroduce != null){
			req.setAttribute("wMallIntroducePage", wmallIntroduce);
			return new ModelAndView("jeecg/wmall/wmallIntroduceUpdate");
		}else {
			WMallIntroduceEntity wMallIntroduceEntity = new WMallIntroduceEntity();
			wMallIntroduceEntity.setMallId(id);
			wMallIntroduceEntity.setTitle(wmall.getMallName());
			wMallIntroduceEntity.setDeposit(wmall.getMallDeposit());
			wMallIntroduceEntity.setIntroduce(wmall.getMallExplain());
			wMallIntroduceEntity.setModel(wmall.getMallDeviceType());
			req.setAttribute("wMallIntroducePage", wMallIntroduceEntity);
			return new ModelAndView("jeecg/wmall/wmallIntroduce");
		}
	}
	

	/**
	 * 净水器商城编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WMallEntity wmall, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wmall.getId())) {
			wmall = wmallService.getEntity(WMallEntity.class, wmall.getId());
			req.setAttribute("wmallPage", wmall);
		}
		return new ModelAndView("jeecg/wmall/wmall-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wmallController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WMallEntity wmall,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WMallEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wmall, request.getParameterMap());
		List<WMallEntity> wmalls = this.wmallService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"净水器商城");
		modelMap.put(NormalExcelConstants.CLASS,WMallEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("净水器商城列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wmalls);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WMallEntity wmall,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"净水器商城");
    	modelMap.put(NormalExcelConstants.CLASS,WMallEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("净水器商城列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<WMallEntity> listwmallEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WMallEntity.class,params);
				for (WMallEntity wmall : listwmallEntitys) {
					wmallService.save(wmall);
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
	 * @param id wmall主键id
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
	public List<WMallEntity> list() {
		List<WMallEntity> listwmalls=wmallService.getList(WMallEntity.class);
		return listwmalls;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		WMallEntity task = wmallService.get(WMallEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody WMallEntity wmall, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WMallEntity>> failures = validator.validate(wmall);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			wmallService.save(wmall);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = wmall.getId();
		URI uri = uriBuilder.path("/rest/wmallController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody WMallEntity wmall) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WMallEntity>> failures = validator.validate(wmall);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			wmallService.saveOrUpdate(wmall);
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
		wmallService.deleteEntityById(WMallEntity.class, id);
	}
}
