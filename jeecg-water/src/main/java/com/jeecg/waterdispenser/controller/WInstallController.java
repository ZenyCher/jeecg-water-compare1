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

import com.jeecg.waterdispenser.entity.WDeviceEntity;
import com.jeecg.waterdispenser.entity.WDeviceTypeEntity;
import com.jeecg.waterdispenser.entity.WErectorEntity;
import com.jeecg.waterdispenser.entity.WInstallEntity;
import com.jeecg.waterdispenser.entity.WMaintainEntity;
import com.jeecg.waterdispenser.entity.WRechargeEntity;
import com.jeecg.waterdispenser.entity.WRepairEntity;
import com.jeecg.waterdispenser.entity.WUserDeviceEntity;
import com.jeecg.waterdispenser.entity.WUserMemberEntity;
import com.jeecg.waterdispenser.entity.WUserRegisterEntity;
import com.jeecg.waterdispenser.entity.WWaterMeterEntity;
import com.jeecg.waterdispenser.service.WDeviceServiceI;
import com.jeecg.waterdispenser.service.WDeviceTypeServiceI;
import com.jeecg.waterdispenser.service.WErectorServiceI;
import com.jeecg.waterdispenser.service.WInstallServiceI;
import com.jeecg.waterdispenser.service.WMallServiceI;
import com.jeecg.waterdispenser.service.WPackageServiceI;
import com.jeecg.waterdispenser.service.WRechargeServiceI;
import com.jeecg.waterdispenser.service.WUserDeviceServiceI;
import com.jeecg.waterdispenser.service.WUserMemberServiceI;
import com.jeecg.waterdispenser.service.WUserRegisterServiceI;
import com.jeecg.waterdispenser.service.WWaterMeterServiceI;

/**   
 * @Title: Controller  
 * @Description: 安装管理表
 * @author onlineGenerator
 * @date 2017-07-06 14:27:49
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wInstallController")
public class WInstallController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WInstallController.class);

	@Autowired
	private WInstallServiceI wInstallService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private WErectorServiceI wErectorServiceI;
	@Autowired
	private WUserMemberServiceI wUserMemberServiceI; 
	@Autowired
	private WDeviceTypeServiceI wDeviceTypeServiceI;
	@Autowired
	private WPackageServiceI wPackageServiceI;
	@Autowired
	private WMallServiceI wMallServiceI;
	@Autowired
	private WWaterMeterServiceI wWaterMeterServiceI;
	@Autowired
	private WUserDeviceServiceI wUserDeviceServiceI;
	@Autowired
	private WRechargeServiceI wRechargeServiceI;
	@Autowired
	private WDeviceServiceI wDeviceServiceI;
	@Autowired
	private WUserRegisterServiceI wUserRegisterServiceI;
	


	/**
	 * 安装管理表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("jeecg/winstall/wInstallList");
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
	public void datagrid(WInstallEntity wInstall,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WInstallEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wInstall, request.getParameterMap());
		try{
		//自定义追加查询条件
			CriterionList criterionList = new CriterionList();
			//查看当前用户真实名字，得到安装公司id进行查询该公司下的指派单
			TSUser user = ResourceUtil.getSessionUserName();
			List<TSRoleUser> rUsers = systemService.findByProperty(TSRoleUser.class, "TSUser.id", user.getId());
			TSRole role = new TSRole();
			for (TSRoleUser ru : rUsers) {
				role = ru.getTSRole();
			}
			String rolecode = role.getRoleCode();
			if( rolecode.equals("fix_worker") ){
				String userName = user.getUserName();//当前登录用户的真实姓名
				List<WErectorEntity> werector = wErectorServiceI.findByProperty(WErectorEntity.class, "erectorAdmin", userName);
				String werectorId = "";
				for (int i = 0; i < werector.size(); i++) {
					werectorId = werector.get(i).getId();
				}
				criterionList.addPara(0,Restrictions.eq("installWorkerId", werectorId));
				cq.setCriterionList(criterionList);
			}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.wInstallService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除安装管理表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WInstallEntity wInstall, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wInstall = systemService.getEntity(WInstallEntity.class, wInstall.getId());
		message = "安装管理表删除成功";
		try{
			wInstallService.delete(wInstall);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "安装管理表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除安装管理表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "安装管理表删除成功";
		try{
			for(String id:ids.split(",")){
				WInstallEntity wInstall = systemService.getEntity(WInstallEntity.class, 
				id
				);
				wInstallService.delete(wInstall);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "安装管理表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加安装管理表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WInstallEntity wInstall, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "安装管理表添加成功";
		try{
			wInstallService.save(wInstall);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "安装管理表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新安装管理表
	 * 
	 * @param ids
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WInstallEntity wInstall, HttpServletRequest request) throws Exception {
		String message = null;
		AjaxJson j = new AjaxJson();
		//水表初始读数
		String installCertificates = wInstall.getInstallCertificates();
		String installContract = wInstall.getInstallContract();
		if( oConvertUtils.isNotEmpty(installCertificates) ){
			if( installCertificates.contains(",") ){
				installCertificates = installCertificates.replace(",", "");
				wInstall.setInstallCertificates(installCertificates);
			}
		}
		if( oConvertUtils.isNotEmpty(installContract) ){
			if( installContract.contains(",") ){
				installContract = installContract.replace(",", "");
				wInstall.setInstallContract(installContract);
			}
		}
		//根据水表id判断水表是否存在
		if( oConvertUtils.isNotEmpty(wInstall.getDeviceId()) ){
			WWaterMeterEntity wMeterEntity = wWaterMeterServiceI.findUniqueByProperty(WWaterMeterEntity.class, "memberId", wInstall.getMemberId());
			if( wMeterEntity == null ){
				wMeterEntity = new WWaterMeterEntity();
				wMeterEntity.setWaterId(wInstall.getDeviceId());
				wMeterEntity.setWaterNum(wInstall.getInstallWater());
				wMeterEntity.setMemberName(wInstall.getInstallMembername());
				wMeterEntity.setMemberPhone(wInstall.getInstalPhont());
				wMeterEntity.setMemberId(wInstall.getMemberId());
				wMeterEntity.setWaterCurrent(wInstall.getInstallWater());
				wMeterEntity.setWaterSurplus(0);
				wMeterEntity.setWaterState(1);
				wMeterEntity.setWaterValue(1);
				wMeterEntity.setWaterRecharge(0);
				wWaterMeterServiceI.save(wMeterEntity);
			}else {
				wMeterEntity.setWaterId(wInstall.getDeviceId());
				wWaterMeterServiceI.saveOrUpdate(wMeterEntity);
			}
		}
		//根据用户id查找用户中间设备表
		WUserDeviceEntity userDevice = wUserDeviceServiceI.findUniqueByProperty(WUserDeviceEntity.class, "memberId", wInstall.getMemberId());
		try {
			if( oConvertUtils.isNotEmpty(wInstall.getDeviceId()) ){
				//用户设备中间表
				userDevice.setDeviceId(wInstall.getDeviceId());//设备id
				userDevice.setWatermeterId(wInstall.getDeviceId());//水表id
				wUserDeviceServiceI.saveOrUpdate(userDevice);
				//用户设备记录保存成功之后将设备状态改为已使用
				WDeviceEntity wDeviceEntity = wDeviceServiceI.findUniqueByProperty(WDeviceEntity.class, "deviceId", wInstall.getDeviceId());
				if( wDeviceEntity != null ){
					wDeviceEntity.setIsUse(1);
					wDeviceServiceI.saveOrUpdate(wDeviceEntity);
				}
				//根据用户id查找用户记录，然后将设备id填入记录保存
				WUserMemberEntity wUserMemberEntity = wUserMemberServiceI.findUniqueByProperty(WUserMemberEntity.class, "id", wInstall.getMemberId());
				wUserMemberEntity.setDeviceId(wInstall.getDeviceId());
				wUserMemberServiceI.saveOrUpdate(wUserMemberEntity);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		wInstall.setInstallErectorId(request.getParameter("registerId"));
		wInstall.setInstallErectorName(request.getParameter("registerName"));
		WInstallEntity t = wInstallService.get(WInstallEntity.class, wInstall.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wInstall, t);
			wInstallService.saveOrUpdate(t);
			message = "安装管理表更新成功!";
		} catch (Exception e) {
			e.printStackTrace();
			message = "安装管理表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 安装管理表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WInstallEntity wInstall, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wInstall.getId())) {
			wInstall = wInstallService.getEntity(WInstallEntity.class, wInstall.getId());
			req.setAttribute("wInstallPage", wInstall);
		}
		return new ModelAndView("jeecg/winstall/wInstall-add");
	}
	/**
	 * 安装管理表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WInstallEntity wInstall, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wInstall.getId())) {
			wInstall = wInstallService.getEntity(WInstallEntity.class, wInstall.getId());
			String memberId = wInstall.getMemberId();
			WUserMemberEntity wUserMemberEntity = wUserMemberServiceI.findUniqueByProperty(WUserMemberEntity.class, "id", memberId);
			if( wUserMemberEntity != null ){
				req.setAttribute("wUserMemberPage", wUserMemberEntity);
				WDeviceTypeEntity wDeviceTypeEntity = wDeviceTypeServiceI.findUniqueByProperty(WDeviceTypeEntity.class, "id", wUserMemberEntity.getMemberDeviceId());
				if( wDeviceTypeEntity != null ){
					req.setAttribute("wDeviceTypePage", wDeviceTypeEntity);
				}
			}
			req.setAttribute("wInstallPage", wInstall);
		}
		return new ModelAndView("jeecg/winstall/wInstall-update");
	}
	
	/**
	 * 查询套餐
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "assign")
	public ModelAndView assign(HttpServletRequest request) {
		//--author：zhoujf-----start----date:20150531--------for: 编辑用户，选择角色,弹出的角色列表页面，默认没选中
		ModelAndView mv = new ModelAndView("jeecg/uiFolder/installErector");
		String ids = oConvertUtils.getString(request.getParameter("ids"));
		mv.addObject("ids", ids);
		return mv;
	}
	
	/**
	 * 查询所有设备列表选择
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "assignDevice")
	public ModelAndView assignDevice(HttpServletRequest request) {
		//--author：zhoujf-----start----date:20150531--------for: 编辑用户，选择角色,弹出的角色列表页面，默认没选中
		ModelAndView mv = new ModelAndView("jeecg/uiFolder/deviceInstall");
		String ids = oConvertUtils.getString(request.getParameter("ids"));
		String str = "更换原水表的剩余水量将被转移到新水表中，原水表将不可再使用，该操作不可逆，请确定是否更新水表";
		mv.addObject("ids", ids);
		mv.addObject("str",str);
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
			criterionList.addPara(0,Restrictions.eq("isUse", 0));
			cq.setCriterionList(criterionList);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.wDeviceServiceI.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 安装工人显示列表
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "installDatagrid")
	public void datagrid(WUserRegisterEntity wuserRegister, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WUserRegisterEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuserRegister);
		try{
			//自定义追加查询条件
			CriterionList criterionList = new CriterionList();
			criterionList.addPara(0,Restrictions.eq("registerType", "2"));
			//获取当前用户的角色及号码查询
			TSUser user = ResourceUtil.getSessionUserName();
			TSRole role = new TSRole();
			TSUser tsUser = new TSUser();
			if (user != null) {
				List<TSRoleUser> rUsers = systemService.findByProperty(TSRoleUser.class, "TSUser.id", user.getId());
				for (TSRoleUser ru : rUsers) {
					role = ru.getTSRole();
					tsUser = ru.getTSUser();
				}
				if( "fix_worker".equals(role.getRoleCode()) ){
					criterionList.addPara(1,Restrictions.eq("memberPhone", tsUser.getMobilePhone()));
				}
			}
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
		req.setAttribute("controller_name","wInstallController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WInstallEntity wInstall,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WInstallEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wInstall, request.getParameterMap());
		List<WInstallEntity> wInstalls = this.wInstallService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"安装管理表");
		modelMap.put(NormalExcelConstants.CLASS,WInstallEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("安装管理表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wInstalls);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WInstallEntity wInstall,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"安装管理表");
    	modelMap.put(NormalExcelConstants.CLASS,WInstallEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("安装管理表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<WInstallEntity> listWInstallEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WInstallEntity.class,params);
				for (WInstallEntity wInstall : listWInstallEntitys) {
					wInstallService.save(wInstall);
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
	public List<WInstallEntity> list() {
		List<WInstallEntity> listWInstalls=wInstallService.getList(WInstallEntity.class);
		return listWInstalls;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		WInstallEntity task = wInstallService.get(WInstallEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody WInstallEntity wInstall, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WInstallEntity>> failures = validator.validate(wInstall);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			wInstallService.save(wInstall);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = wInstall.getId();
		URI uri = uriBuilder.path("/rest/wInstallController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody WInstallEntity wInstall) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WInstallEntity>> failures = validator.validate(wInstall);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			wInstallService.saveOrUpdate(wInstall);
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
		wInstallService.deleteEntityById(WInstallEntity.class, id);
	}
}
