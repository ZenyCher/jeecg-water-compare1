package com.jeecg.waterdispenser.controller;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.jeecg.waterdispenser.entity.WFilterEntity;
import com.jeecg.waterdispenser.entity.WInstallEntity;
import com.jeecg.waterdispenser.entity.WMallIntroduceEntity;
import com.jeecg.waterdispenser.service.WDeviceServiceI;
import com.jeecg.waterdispenser.service.WFilterServiceI;
import com.jeecg.waterdispenser.service.WInstallServiceI;
import com.jeecg.waterdispenser.service.WMallIntroduceServiceI;
import com.jeecg.waterdispenser.service.WUserDeviceServiceI;

/**   
 * @Title: Controller  
 * @Description: 净水器设备表
 * @author onlineGenerator
 * @date 2017-05-28 15:03:36
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wdeviceController")
public class WDeviceController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WDeviceController.class);

	@Autowired
	private WDeviceServiceI wdeviceService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private WFilterServiceI wFilterService;
	@Autowired
	private WUserDeviceServiceI wUserDeviceService;
	@Autowired
	private WMallIntroduceServiceI wMallIntroduceServiceI;
	@Autowired
	private WInstallServiceI wInstallServiceI;
	


	/**
	 * 净水器设备表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("jeecg/wdevice/wdeviceList");
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
	public void datagrid(WDeviceEntity wdevice,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WDeviceEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wdevice, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.wdeviceService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除净水器设备表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WDeviceEntity wdevice, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wdevice = systemService.getEntity(WDeviceEntity.class, wdevice.getId());
		message = "净水器设备表删除成功";
		try{
			wdeviceService.delete(wdevice);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "净水器设备表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除净水器设备表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "净水器设备表删除成功";
		try{
			for(String id:ids.split(",")){
				WDeviceEntity wdevice = systemService.getEntity(WDeviceEntity.class, 
				id
				);
				wdeviceService.delete(wdevice);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "净水器设备表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加净水器设备表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WDeviceEntity wdevice, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "净水器设备表添加成功";
		try{
			String deviceId = wdevice.getDeviceId();
			Long str = wdeviceService.selectByDeviceIdCount(deviceId);
			if(str > 0){
				j.setMsg("设备重复，请重新输入");
				j.setSuccess(false);
				return j;
			}
			String mallIntroduceName = request.getParameter("title");
			wdevice.setMallIntroduceName(mallIntroduceName);
			wdeviceService.save(wdevice);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "净水器设备表添加失败";
			throw new BusinessException("净水器设备表添加失败");
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新净水器设备表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WDeviceEntity wdevice, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "净水器设备表更新成功";
		String mallIntroduceName = request.getParameter("title");
		wdevice.setMallIntroduceName(mallIntroduceName);
		WDeviceEntity t = wdeviceService.get(WDeviceEntity.class, wdevice.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wdevice, t);
			wdeviceService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "设备id不能相同或其他参数错误！";
			throw new BusinessException("设备id不能相同或其他参数错误！");
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 净水器设备表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WDeviceEntity wdevice, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wdevice.getId())) {
			wdevice = wdeviceService.getEntity(WDeviceEntity.class, wdevice.getId());
			req.setAttribute("wdevicePage", wdevice);
		}
		return new ModelAndView("jeecg/wdevice/wdevice-add");
	}
	/**
	 * 净水器设备表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WDeviceEntity wdevice, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wdevice.getId())) {
			wdevice = wdeviceService.getEntity(WDeviceEntity.class, wdevice.getId());
			req.setAttribute("wdevicePage", wdevice);
		}
		return new ModelAndView("jeecg/wdevice/wdevice-update");
	}
	
	/**
	 * 查询所有设备列表选择
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "assign")
	public ModelAndView assign(HttpServletRequest request) {
		//--author：zhoujf-----start----date:20150531--------for: 编辑用户，选择角色,弹出的角色列表页面，默认没选中
		ModelAndView mv = new ModelAndView("jeecg/uiFolder/device");
		String ids = oConvertUtils.getString(request.getParameter("ids"));
		mv.addObject("ids", ids);
		return mv;
	}
	
	/**
	 * 设备显示列表
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "datagridDevice")
	public void datagridErector(WDeviceEntity wdevice, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WDeviceEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wdevice, request.getParameterMap());
		try{
			HttpSession session = ContextHolderUtils.getSession();
			String memberPhone = oConvertUtils.getString(session.getAttribute("SELECT_USER_DEVICE_PHONE"));
			List<Map<String, Object>> list = wUserDeviceService.selectUserDeviceByMemberPhone(memberPhone);
			String[] str = new String[list.size()];
			if ( list != null && list.size() > 0 ) {
				for (int i = 0; i < list.size(); i++) {
					String deviceId = oConvertUtils.getString(list.get(i).get("device_type_id"));
					Map<String, String> map = wInstallServiceI.getInstallByDeviceAndMemberPhone(deviceId,memberPhone);
					//不为空则代表该设备已安装过。则不需显示
					if( map == null ){
						str[i] = oConvertUtils.getString(list.get(i).get("device_type_id"));
					}
				}
			}
			//自定义追加查询条件
			CriterionList criterionList = new CriterionList();
			criterionList.addPara(0,Restrictions.in("deviceTypeId", str));
			cq.setCriterionList(criterionList);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.wdeviceService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 查询所有滤芯选择
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "assignFilter")
	public ModelAndView relationship(HttpServletRequest request) {
		//--author：zhoujf-----start----date:20150531--------for: 编辑用户，选择角色,弹出的角色列表页面，默认没选中
		ModelAndView mv = new ModelAndView("jeecg/uiFolder/filter");
		String ids = oConvertUtils.getString(request.getParameter("ids"));
		mv.addObject("ids", ids);
		return mv;
	}
	
	/**
	 * 设备显示列表
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "datagridFilter")
	public void datagridErector(WFilterEntity wFilter, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WFilterEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wFilter, request.getParameterMap());
		try{
			//自定义追加查询条件
			CriterionList criterionList = new CriterionList();
			criterionList.addPara(0,Restrictions.eq("filterState", 0));
			cq.setCriterionList(criterionList);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.wFilterService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 查询所有产品列表选择
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "mallIntroduceAssign")
	public ModelAndView mallIntroduceAssign(HttpServletRequest request) {
		//--author：zhoujf-----start----date:20150531--------for: 编辑用户，选择角色,弹出的角色列表页面，默认没选中
		ModelAndView mv = new ModelAndView("jeecg/uiFolder/mallIntroduce");
		String ids = oConvertUtils.getString(request.getParameter("ids"));
		mv.addObject("ids", ids);
		return mv;
	}
	
	/**
	 * 产品显示列表
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "datagridMallIntroduce")
	public void datagridMallIntroduce(WMallIntroduceEntity wMallIntroduceEntity, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WMallIntroduceEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wMallIntroduceEntity, request.getParameterMap());
		try{
			//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.wMallIntroduceServiceI.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
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
		ModelAndView mv = new ModelAndView("jeecg/wdevice/theTrue");
		return mv;
	}
	
	/**
	 * 设备验真
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
			String deviceCode = request.getParameter("deviceCode");
			Boolean fals = wdeviceService.selectTheTrue(deviceCode);
			if( fals ){
				j.setSuccess(fals);
				message = "该防伪码正确，该设备是正品。";
			}else {
				j.setSuccess(fals);
				message = "该防伪码错误，该设备不是正品。";
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "该防伪码错误，该设备不是正品。";
			throw new BusinessException("该防伪码错误，该设备不是正品。");
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
		req.setAttribute("controller_name","wdeviceController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WDeviceEntity wdevice,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WDeviceEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wdevice, request.getParameterMap());
		List<WDeviceEntity> wdevices = this.wdeviceService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"净水器设备表");
		modelMap.put(NormalExcelConstants.CLASS,WDeviceEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("净水器设备表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wdevices);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WDeviceEntity wdevice,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"净水器设备表");
    	modelMap.put(NormalExcelConstants.CLASS,WDeviceEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("净水器设备表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<WDeviceEntity> listwdeviceEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WDeviceEntity.class,params);
				for (WDeviceEntity wdevice : listwdeviceEntitys) {
					wdeviceService.save(wdevice);
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
	public List<WDeviceEntity> list() {
		List<WDeviceEntity> listwdevices=wdeviceService.getList(WDeviceEntity.class);
		return listwdevices;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		WDeviceEntity task = wdeviceService.get(WDeviceEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody WDeviceEntity wdevice, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WDeviceEntity>> failures = validator.validate(wdevice);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			wdeviceService.save(wdevice);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = wdevice.getId();
		URI uri = uriBuilder.path("/rest/wdeviceController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody WDeviceEntity wdevice) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WDeviceEntity>> failures = validator.validate(wdevice);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			wdeviceService.saveOrUpdate(wdevice);
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
		wdeviceService.deleteEntityById(WDeviceEntity.class, id);
	}
}
