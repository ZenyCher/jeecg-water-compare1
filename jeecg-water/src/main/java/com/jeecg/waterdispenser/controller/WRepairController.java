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
import org.hibernate.criterion.Criterion;
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
import org.jeecgframework.web.system.pojo.base.TSRole;
import org.jeecgframework.web.system.pojo.base.TSRoleUser;
import org.jeecgframework.web.system.pojo.base.TSUser;
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

import com.jayway.jsonpath.Criteria;
import com.jeecg.waterdispenser.entity.WDeviceEntity;
import com.jeecg.waterdispenser.entity.WErectorEntity;
import com.jeecg.waterdispenser.entity.WFilterEntity;
import com.jeecg.waterdispenser.entity.WRepairEntity;
import com.jeecg.waterdispenser.entity.WUserDeviceEntity;
import com.jeecg.waterdispenser.service.WDeviceServiceI;
import com.jeecg.waterdispenser.service.WErectorServiceI;
import com.jeecg.waterdispenser.service.WFilterServiceI;
import com.jeecg.waterdispenser.service.WRepairServiceI;
import com.jeecg.waterdispenser.service.WUserDeviceServiceI;
import com.jeecg.waterdispenser.service.WUserRegisterServiceI;

/**   
 * @Title: Controller  
 * @Description: 维护保养管理
 * @author onlineGenerator
 * @date 2017-07-23 18:19:28
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wrepairController")
public class WRepairController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WRepairController.class);

	@Autowired
	private WRepairServiceI wRepairService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private WUserRegisterServiceI wUserRegisterService;
	@Autowired
	private WFilterServiceI wFilterServiceI;
	@Autowired
	private WDeviceServiceI wDeviceServiceI; 
	@Autowired
	private WErectorServiceI wErectorServiceI;
	@Autowired
	private WUserDeviceServiceI wUserDeviceServiceI;
	


	/**
	 * 维护保养管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("jeecg/wrepair/wrepairList");
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
	public void datagrid(WRepairEntity wRepair,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WRepairEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wRepair, request.getParameterMap());
		try{
			//自定义追加查询条件
			CriterionList criterionList = new CriterionList();
			//判断当前用户是否是安装工用户，如果是则显示自己相应的维护单。
			TSUser user = ResourceUtil.getSessionUserName();
			List<TSRoleUser> rUsers = systemService.findByProperty(TSRoleUser.class, "TSUser.id", user.getId());
			TSRole role = new TSRole();
			TSUser user2 = new TSUser();
			for (TSRoleUser ru : rUsers) {
				role = ru.getTSRole();
				user2 = ru.getTSUser();
			}
			String rolecode = role.getRoleCode();
			if ( rolecode.equals("fix_worker") ) {
				//如果是安装工用户则在注册用户中得到该代理公司的所有安装工，然后查询该代理公司所有的安装工人的维修单
//				String mobilePhone = user.getMobilePhone();
//				List<Map<String, Object>> registerList = wUserRegisterService.selectUserAndErectorByPhone(mobilePhone);
//				if( !registerList.isEmpty() || registerList != null || registerList.size() > 0 ) {
//					List<String> strList = new ArrayList<>();
//					for(int i=0;i<registerList.size();i++) {
//						String str = oConvertUtils.getString(registerList.get(i).get("id"));
//						if( oConvertUtils.isNotEmpty(str) ){
//							strList.add(str);
//						}
//					}
//					criterionList.addPara(0,Restrictions.in("registerId", strList));
//				}
//				criterionList.addPara(0,Restrictions.eq("erectorAdmin", user2.getUserName()));
				//得到安装公司的id然后去维护记录表中查询
				List<WErectorEntity> list = wErectorServiceI.findByProperty(WErectorEntity.class, "erectorAdmin", user2.getUserName());
				List<String> strList = new ArrayList<>();
				for (int i = 0; i < list.size(); i++) {
					String str = oConvertUtils.getString(list.get(i).getId());
					strList.add(str);
				}
				criterionList.addPara(0,Restrictions.in("registerId", strList));
			}
			cq.setCriterionList(criterionList);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.wRepairService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除维护保养管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WRepairEntity wRepair, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wRepair = systemService.getEntity(WRepairEntity.class, wRepair.getId());
		message = "维护保养管理删除成功";
		try{
			wRepairService.delete(wRepair);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "维护保养管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除维护保养管理
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "维护保养管理删除成功";
		try{
			for(String id:ids.split(",")){
				WRepairEntity wRepair = systemService.getEntity(WRepairEntity.class, 
				id
				);
				wRepairService.delete(wRepair);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "维护保养管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加维护保养管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WRepairEntity wRepair, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "维护保养管理添加成功";
		try{
			wRepairService.save(wRepair);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "维护保养管理添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新维护保养管理
	 * 
	 * @param ids
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WRepairEntity wRepair, HttpServletRequest request) throws Exception {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "维护保养管理更新成功";
		String type = wRepair.getMaintainType();
		if( "故障".equals(type) ){
			wRepair.setMaintainType("0");
		}else if( "滤芯更换".equals(type) ){
			wRepair.setMaintainType("1");
		}else if( "其他".equals(type) ){
			wRepair.setMaintainType("2");
		}
		
		List<String> list = new ArrayList<String>();
		list.add(wRepair.getOneFilterId());
		list.add(wRepair.getTwoFilterId());
		list.add(wRepair.getThreeFilterId());
		list.add(wRepair.getFourFilterId());
		List<String> list1 = new ArrayList<String>();
		list1.add(wRepair.getOneFilterId());
		list1.add(wRepair.getTwoFilterId());
		list1.add(wRepair.getThreeFilterId());
		list1.add(wRepair.getFourFilterId());
		for (int i = 0; i < list.size(); i++) {
			for (int k = 0; k < list1.size(); k++) {
				if( oConvertUtils.isNotEmpty(list1.get(k)) ){
					if( i != k ){
						if( list.get(i).equals(list1.get(k)) ){
							j.setMsg("滤芯重复,请重新输入!");
							j.setSuccess(false);
							return j;
						}
					}
				}
			}
		}
		
		WUserDeviceEntity wUserDeviceEntity = wUserDeviceServiceI.findUniqueByProperty(WUserDeviceEntity.class, "deviceId", wRepair.getDeviceId());
		if( oConvertUtils.isNotEmpty(wRepair.getOneFilterId()) ){
			WFilterEntity filter = wFilterServiceI.findUniqueByProperty(WFilterEntity.class, "filterId", wRepair.getOneFilterId());
			if( filter == null ){
				j.setMsg("滤芯一id不存在，请重新输入！");
				j.setSuccess(false);
				return j;
			}
			filter.setFilterState(1);
			wFilterServiceI.saveOrUpdate(filter);
			wUserDeviceEntity.setOneFilterId(wRepair.getOneFilterId());
			wUserDeviceEntity.setOneFilterName(wUserDeviceEntity.getOneFilterName() + Integer.valueOf(wRepair.getOneFilterName()));
		}
		if ( oConvertUtils.isNotEmpty(wRepair.getTwoFilterId()) ) {
			WFilterEntity filter = wFilterServiceI.findUniqueByProperty(WFilterEntity.class, "filterId", wRepair.getTwoFilterId());
			if( filter == null ){
				j.setMsg("滤芯二id不存在，请重新输入！");
				j.setSuccess(false);
				return j;
			}
			filter.setFilterState(1);
			wFilterServiceI.saveOrUpdate(filter);
			wUserDeviceEntity.setOneFilterId(wRepair.getTwoFilterId());
			wUserDeviceEntity.setOneFilterName(wUserDeviceEntity.getTwoFilterName() + Integer.valueOf(wRepair.getTwoFilterName()));
		}
		if ( oConvertUtils.isNotEmpty(wRepair.getThreeFilterId()) ) {
			WFilterEntity filter = wFilterServiceI.findUniqueByProperty(WFilterEntity.class, "filterId", wRepair.getThreeFilterId());
			if( filter == null ){
				j.setMsg("滤芯三id不存在，请重新输入！");
				j.setSuccess(false);
				return j;
			}
			filter.setFilterState(1);
			wFilterServiceI.saveOrUpdate(filter);
			wUserDeviceEntity.setOneFilterId(wRepair.getThreeFilterId());
			wUserDeviceEntity.setOneFilterName(wUserDeviceEntity.getThreeFilterName() + Integer.valueOf(wRepair.getThreeFilterName()));
		}
		if( oConvertUtils.isNotEmpty(wRepair.getFiveFilterId()) ){
			WFilterEntity filter = wFilterServiceI.findUniqueByProperty(WFilterEntity.class, "filterId", wRepair.getFiveFilterId());
			if( filter == null ){
				j.setMsg("滤芯五id不存在，请重新输入！");
				j.setSuccess(false);
				return j;
			}
			filter.setFilterState(1);
			wFilterServiceI.saveOrUpdate(filter);
			wUserDeviceEntity.setOneFilterId(wRepair.getFiveFilterName());
			wUserDeviceEntity.setOneFilterName(wUserDeviceEntity.getFiveFilterName() + Integer.valueOf(wRepair.getFiveFilterName()));
		}
		if( oConvertUtils.isNotEmpty(wRepair.getSixFilterId()) ){
			WFilterEntity filter = wFilterServiceI.findUniqueByProperty(WFilterEntity.class, "filterId", wRepair.getSixFilterId());
			if( filter == null ){
				j.setMsg("滤芯六id不存在，请重新输入！");
				j.setSuccess(false);
				return j;
			}
			filter.setFilterState(1);
			wFilterServiceI.saveOrUpdate(filter);
			wUserDeviceEntity.setOneFilterId(wRepair.getSixFilterName());
			wUserDeviceEntity.setOneFilterName(wUserDeviceEntity.getSixFilterName() + Integer.valueOf(wRepair.getSixFilterName()));
		}
		if( oConvertUtils.isNotEmpty(wRepair.getFourFilterId()) ){
			WFilterEntity filter = wFilterServiceI.findUniqueByProperty(WFilterEntity.class, "filterId", wRepair.getFourFilterId());
			if( filter == null ){
				j.setMsg("滤芯四id不存在，请重新输入！");
				j.setSuccess(false);
				return j;
			}
			filter.setFilterState(1);
			wFilterServiceI.saveOrUpdate(filter);
			wUserDeviceEntity.setOneFilterId(wRepair.getFourFilterName());
			wUserDeviceEntity.setOneFilterName(wUserDeviceEntity.getFourFilterName() + Integer.valueOf(wRepair.getFourFilterName()));
		}
		WRepairEntity t = wRepairService.get(WRepairEntity.class, wRepair.getId());
		try {
			wRepair.setMaintainErectorId(request.getParameter("registerId") == null ? "" : request.getParameter("registerId"));
			wRepair.setMaintainErectorName(request.getParameter("registerName") == null ? "" : request.getParameter("registerName"));
			MyBeanUtils.copyBeanNotNull2Bean(wRepair, t);
			wRepairService.saveOrUpdate(t);
			wUserDeviceServiceI.saveOrUpdate(wUserDeviceEntity);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "维护保养管理更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 查询所有设备列表选择
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "assignDevice")
	public ModelAndView assignDevice(HttpServletRequest request) {
		//--author：zhoujf-----start----date:20150531--------for: 编辑用户，选择角色,弹出的角色列表页面，默认没选中
		ModelAndView mv = new ModelAndView("jeecg/uiFolder/deviceRepair");
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
	public void datagridDevice(WDeviceEntity wDevice, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WDeviceEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wDevice, request.getParameterMap());
		try{
			//自定义追加查询条件
			CriterionList criterionList = new CriterionList();
			criterionList.addPara(0,Restrictions.eq("isUse", 1));
			cq.setCriterionList(criterionList);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.wDeviceServiceI.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	

	/**
	 * 维护保养管理新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WRepairEntity wRepair, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wRepair.getId())) {
			wRepair = wRepairService.getEntity(WRepairEntity.class, wRepair.getId());
			req.setAttribute("wRepairPage", wRepair);
		}
		return new ModelAndView("jeecg/wrepair/wrepair-add");
	}
	/**
	 * 维护保养管理编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WRepairEntity wRepair, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wRepair.getId())) {
			wRepair = wRepairService.getEntity(WRepairEntity.class, wRepair.getId());
			WDeviceEntity wDeviceEntity = wDeviceServiceI.findUniqueByProperty(WDeviceEntity.class, "deviceId", wRepair.getDeviceId());
			if(wDeviceEntity != null){
				req.setAttribute("wDevicePage", wDeviceEntity);
			}
			req.setAttribute("wRepairPage", wRepair);
		}
		return new ModelAndView("jeecg/wrepair/wrepair-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wRepairController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WRepairEntity wRepair,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WRepairEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wRepair, request.getParameterMap());
		List<WRepairEntity> wRepairs = this.wRepairService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"维护保养管理");
		modelMap.put(NormalExcelConstants.CLASS,WRepairEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("维护保养管理列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wRepairs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WRepairEntity wRepair,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"维护保养管理");
    	modelMap.put(NormalExcelConstants.CLASS,WRepairEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("维护保养管理列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<WRepairEntity> listWRepairEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WRepairEntity.class,params);
				for (WRepairEntity wRepair : listWRepairEntitys) {
					wRepairService.save(wRepair);
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
	public List<WRepairEntity> list() {
		List<WRepairEntity> listWRepairs=wRepairService.getList(WRepairEntity.class);
		return listWRepairs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		WRepairEntity task = wRepairService.get(WRepairEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody WRepairEntity wRepair, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WRepairEntity>> failures = validator.validate(wRepair);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			wRepairService.save(wRepair);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = wRepair.getId();
		URI uri = uriBuilder.path("/rest/wRepairController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody WRepairEntity wRepair) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WRepairEntity>> failures = validator.validate(wRepair);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			wRepairService.saveOrUpdate(wRepair);
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
		wRepairService.deleteEntityById(WRepairEntity.class, id);
	}
}
