package org.jeecgframework.web.system.controller.core;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JSpinner.DateEditor;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.enums.SysThemesEnum;
import org.jeecgframework.core.util.ContextHolderUtils;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.IpUtil;
import org.jeecgframework.core.util.ListtoMenu;
import org.jeecgframework.core.util.LogUtil;
import org.jeecgframework.core.util.NumberComparator;
import org.jeecgframework.core.util.PasswordUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.SysThemesUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.web.system.manager.ClientManager;
import org.jeecgframework.web.system.pojo.base.Client;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSFunction;
import org.jeecgframework.web.system.pojo.base.TSRole;
import org.jeecgframework.web.system.pojo.base.TSRoleFunction;
import org.jeecgframework.web.system.pojo.base.TSRoleUser;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.MutiLangServiceI;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.system.service.UserService;
import org.jeecgframework.web.system.sms.util.JavaSmsAPIDemo_Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * 登陆初始化控制器
 * @author 张代浩
 * 
 */
//@Scope("prototype")
@Controller
@RequestMapping("/loginController")
public class LoginController extends BaseController{
	private Logger log = Logger.getLogger(LoginController.class);
	private SystemService systemService;
	private UserService userService;

	@Autowired
	private MutiLangServiceI mutiLangService;
	
	@Autowired
	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	@Autowired
	public void setUserService(UserService userService) {

		this.userService = userService;
	}

	@RequestMapping(params = "goPwdInit")
	public String goPwdInit() {
		return "login/pwd_init";
	}


	/**
	 * 检查用户名称
	 * 
	 * @param user
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "checkuser")
	@ResponseBody
	public AjaxJson checkuser(TSUser user, HttpServletRequest req) {
		HttpSession session = req.getSession();
		AjaxJson j = new AjaxJson();
		//语言选择
		if (req.getParameter("langCode")!=null) {
			req.getSession().setAttribute("lang", req.getParameter("langCode"));
		}
		//验证码
		String randCode = req.getParameter("randCode");
		if (StringUtils.isEmpty(randCode)) {
			j.setMsg(mutiLangService.getLang("common.enter.verifycode"));
			j.setSuccess(false);
		} else if (!randCode.equalsIgnoreCase(String.valueOf(session.getAttribute("randCode")))) {
			j.setMsg(mutiLangService.getLang("common.verifycode.error"));
			j.setSuccess(false);
		} else {
			//用户登录验证逻辑
			TSUser u = userService.checkUserExits(user);
			if (u == null) {
				j.setMsg(mutiLangService.getLang("common.username.or.password.error"));
				j.setSuccess(false);
				return j;
			}
			if (u != null && u.getStatus() != 0) {
				// 处理用户有多个组织机构的情况，以弹出框的形式让用户选择
				Map<String, Object> attrMap = new HashMap<String, Object>();
				j.setAttributes(attrMap);

				String orgId = req.getParameter("orgId");
				if (oConvertUtils.isEmpty(orgId)) {
					// 没有传组织机构参数，则获取当前用户的组织机构
					Long orgNum = systemService.getCountForJdbc("select count(1) from t_s_user_org where user_id = '" + u.getId() + "'");
					if (orgNum > 1) {
						attrMap.put("orgNum", orgNum);
						attrMap.put("user", u);
					} else {
						Map<String, Object> userOrgMap = systemService.findOneForJdbc("select org_id as orgId from t_s_user_org where user_id=?", u.getId());
						saveLoginSuccessInfo(req, u, (String) userOrgMap.get("orgId"));
					}
				} else {
					attrMap.put("orgNum", 1);
					saveLoginSuccessInfo(req, u, orgId);
				}
			} else {

				j.setMsg(mutiLangService.getLang("common.lock.user"));

				j.setSuccess(false);
			}
		}
		return j;
	}
	
	
	/**
	 * 变更在线用户组织
	 * 
	 * @param user
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "changeDefaultOrg")
	@ResponseBody
	public AjaxJson changeDefaultOrg(TSUser user, HttpServletRequest req) {
		AjaxJson j = new AjaxJson();
		Map<String, Object> attrMap = new HashMap<String, Object>();
		String orgId = req.getParameter("orgId");
		TSUser u = userService.checkUserExits(user);
		if (oConvertUtils.isNotEmpty(orgId)) {
			attrMap.put("orgNum", 1);
			saveLoginSuccessInfo(req, u, orgId);
		}
		return j;
	}
	
	/**
	 * 手机发送验证码
	 * @param phone
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "modifyPassword")
	@ResponseBody
	public AjaxJson modifyPassword(String phone,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
//		判断手机号码是否为空
		if(StringUtil.isNotEmpty(phone)){
//			如果不为空则查询后台用户是否存在该用户
//			TSUser user = (TSUser) userService.findByQueryString("from TSUser t where 1=1 and t.mobilePhone = " + phone);
			List<TSUser> user = userService.findListbySql("select * from t_s_user t where 1=1 and t.mobilePhone = " + phone);
//			用户为空则当前手机号码不存在
			if(user == null){
				j.setMsg("当前用户不存在！");
				j.setSuccess(false);
			}
			if(user != null && user.size() != 0){
				// 6位验证码
				int mobile_code = (int) ((Math.random() * 9 + 1) * 100000);
				HttpSession session = ContextHolderUtils.getSession();
				session.setAttribute("VALIDATE_PHONE", phone);
				session.setAttribute("VALIDATE_PHONE_CODE", String.valueOf(mobile_code));
				session.setAttribute("SEND_CODE_TIME", new Date().getTime());
				String content = new String("验证码：" + mobile_code + "，打死都不要告诉别人哦！");
				//验证码：{z1-10}，打死都不要告诉别人哦！ 换这个试试 
				System.out.println("手机号：" + phone + ", " + content);
				try {
//					SendMsg_webchinese.sendMessage(phone, content).equals("1")
//						(CMPPSenderUtil.sendMsg(phone, content).equals("1")
					if(JavaSmsAPIDemo_Json.singleSend(phone, content).equals("0")){	
						j.setMsg("手机验证码发送成功!");
						j.setSuccess(true);
					}
				} catch (Exception e) {
					e.printStackTrace();
					throw new BusinessException("手机验证码发送失败，请重新操作");
				}
			}
		}
		return j;
	}
	
	/**
	 * 提交修改密码的信息
	 * @param modelMap
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(params = "newPassword")
	@ResponseBody
	@SuppressWarnings("unchecked")
	public AjaxJson newPassword(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response){
		AjaxJson j = new AjaxJson();
		String phone = request.getParameter("userName");
		String code = request.getParameter("randCode");
		String password = request.getParameter("new_password");
		if(StringUtil.isNotEmpty(code)){
			HttpSession session = ContextHolderUtils.getSession();
			if (code.equals(session.getAttribute("VALIDATE_PHONE_CODE").toString())) {
				if(StringUtil.isNotEmpty(phone) && StringUtil.isNotEmpty(password)){
					List<String> list = this.systemService.findListbySql("select id from t_s_user t where 1=1 and t.mobilePhone = " + phone);
					if (list != null) {
						for (String str: list) {
							TSUser u =  systemService.get(TSUser.class, str);
							String newPassword = PasswordUtil.encrypt(u.getUserName(), password, PasswordUtil.getStaticSalt());
							String strSql = "update t_s_base_user set password = '" + newPassword + "' where id = " + "'"+str+"'";
							int i = userService.updateBySqlString(strSql);
							if(i > 0){
								j.setSuccess(true);
								j.setMsg("更新密码成功");
							}else{
								j.setMsg("修改密码失败，请联系管理员");
								j.setSuccess(false);
							}
						}
					}else{
						j.setMsg("该用户不存在，请咨询管理员");
						j.setSuccess(false);
					}
				}
			}else{
				j.setMsg("验证码不正确，请重新输入");
				j.setSuccess(false);
			}
		}else{
			j.setSuccess(false);
			j.setMsg("请输入验证码");
		}
		return j;
	}

    /**
     * 保存用户登录的信息，并将当前登录用户的组织机构赋值到用户实体中；
     * @param req request
     * @param user 当前登录用户
     * @param orgId 组织主键
     */
    private void saveLoginSuccessInfo(HttpServletRequest req, TSUser user, String orgId) {
    	String message = null;
        TSDepart currentDepart = systemService.get(TSDepart.class, orgId);
        user.setCurrentDepart(currentDepart);

        HttpSession session = ContextHolderUtils.getSession();

        session.setAttribute(ResourceUtil.LOCAL_CLINET_USER, user);
        message = mutiLangService.getLang("common.user") + ": " + user.getUserName() + "["+ currentDepart.getDepartname() + "]" + mutiLangService.getLang("common.login.success");

        //当前session为空 或者 当前session的用户信息与刚输入的用户信息一致时，则更新Client信息
        Client clientOld = ClientManager.getInstance().getClient(session.getId());
		if(clientOld == null || clientOld.getUser() ==null ||user.getUserName().equals(clientOld.getUser().getUserName())){
			Client client = new Client();
	        client.setIp(IpUtil.getIpAddr(req));
	        client.setLogindatetime(new Date());
	        client.setUser(user);
	        ClientManager.getInstance().addClinet(session.getId(), client);
		} else {//如果不一致，则注销session并通过session=req.getSession(true)初始化session
			ClientManager.getInstance().removeClinet(session.getId());
			session.invalidate();
			session = req.getSession(true);//session初始化
			session.setAttribute(ResourceUtil.LOCAL_CLINET_USER, user);
			session.setAttribute("randCode",req.getParameter("randCode"));//保存验证码
			checkuser(user,req);
		}

        
        
        // 添加登陆日志
        systemService.addLog(message, Globals.Log_Type_LOGIN, Globals.Log_Leavel_INFO);
    }


    /**
	 * 用户登录
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "login")
	public String login(String phone,ModelMap modelMap,HttpServletRequest request,HttpServletResponse response) {
		TSUser user = ResourceUtil.getSessionUserName();
		String roles = "";
			if (user != null) {
				List<TSRoleUser> rUsers = systemService.findByProperty(TSRoleUser.class, "TSUser.id", user.getId());
				for (TSRoleUser ru : rUsers) {
					TSRole role = ru.getTSRole();
					roles += role.getRoleName() + ",";
				}
				if (roles.length() > 0) {
					roles = roles.substring(0, roles.length() - 1);
				}
				
	            modelMap.put("roleName", roles.length()>3?roles.substring(0,3)+"...":roles);
	            modelMap.put("userName", user.getUserName().length()>5?user.getUserName().substring(0, 5)+"...":user.getUserName());

	            modelMap.put("currentOrgName", ClientManager.getInstance().getClient().getUser().getCurrentDepart().getDepartname());

				
				SysThemesEnum sysTheme = SysThemesUtil.getSysTheme(request);
				if("ace".equals(sysTheme.getStyle())||"diy".equals(sysTheme.getStyle())||"acele".equals(sysTheme.getStyle())||"hplus".equals(sysTheme.getStyle()) || "shortcut".equals(sysTheme.getStyle())){
					request.setAttribute("menuMap", getFunctionMap(user));
				}

				Cookie cookie = new Cookie("JEECGINDEXSTYLE", sysTheme.getStyle());
				//设置cookie有效期为一个月
				cookie.setMaxAge(3600*24*30);
				response.addCookie(cookie);

				Cookie zIndexCookie = new Cookie("ZINDEXNUMBER", "1990");
				zIndexCookie.setMaxAge(3600*24);//一天
				response.addCookie(zIndexCookie);

				return sysTheme.getIndexPath();
			} else {
				return "login/login";
			}

	}
	
	/**
	 * 退出系统
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "logout")
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session = ContextHolderUtils.getSession();
		TSUser user = ResourceUtil.getSessionUserName();

		try {
			systemService.addLog("用户" + user!=null?user.getUserName():"" + "已退出",Globals.Log_Type_EXIT, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			LogUtil.error(e.toString());
		}

		ClientManager.getInstance().removeClinet(session.getId());
		session.invalidate();
		ModelAndView modelAndView = new ModelAndView(new RedirectView("loginController.do?login"));
		return modelAndView;
	}

	/**
	 * 菜单跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "left")
	public ModelAndView left(HttpServletRequest request) {
		TSUser user = ResourceUtil.getSessionUserName();
		HttpSession session = ContextHolderUtils.getSession();
        ModelAndView modelAndView = new ModelAndView();
		// 登陆者的权限
		if (user.getId() == null) {
			session.removeAttribute(Globals.USER_SESSION);
            modelAndView.setView(new RedirectView("loginController.do?login"));
		}else{
            modelAndView.setViewName("main/left");
            request.setAttribute("menuMap", getFunctionMap(user));
        }
		return modelAndView;
	}

	/**
	 * 获取权限的map
	 * 
	 * @param user
	 * @return
	 */
	private Map<Integer, List<TSFunction>> getFunctionMap(TSUser user) {
		HttpSession session = ContextHolderUtils.getSession();
		Client client = ClientManager.getInstance().getClient(session.getId());
		if (client.getFunctionMap() == null || client.getFunctionMap().size() == 0) {
			Map<Integer, List<TSFunction>> functionMap = new HashMap<Integer, List<TSFunction>>();
			Map<String, TSFunction> loginActionlist = getUserFunction(user);
			if (loginActionlist.size() > 0) {
				Collection<TSFunction> allFunctions = loginActionlist.values();
				for (TSFunction function : allFunctions) {
		            if(function.getFunctionType().intValue()==Globals.Function_TYPE_FROM.intValue()){
						//如果为表单或者弹出 不显示在系统菜单里面
						continue;
					}
					if (!functionMap.containsKey(function.getFunctionLevel() + 0)) {
						functionMap.put(function.getFunctionLevel() + 0,
								new ArrayList<TSFunction>());
					}
					functionMap.get(function.getFunctionLevel() + 0).add(function);
				}
				// 菜单栏排序
				Collection<List<TSFunction>> c = functionMap.values();
				for (List<TSFunction> list : c) {
					Collections.sort(list, new NumberComparator());
				}
			}
			client.setFunctionMap(functionMap);

			//清空变量，降低内存使用
			loginActionlist.clear();

			return functionMap;
		}else{
			return client.getFunctionMap();
		}
	}

	/**
	 * 获取用户菜单列表
	 * 
	 * @param user
	 * @return
	 */
	private Map<String, TSFunction> getUserFunction(TSUser user) {
		HttpSession session = ContextHolderUtils.getSession();
		Client client = ClientManager.getInstance().getClient(session.getId());

		if (client.getFunctions() == null || client.getFunctions().size() == 0) {

			Map<String, TSFunction> loginActionlist = new HashMap<String, TSFunction>();

			 /*String hql="from TSFunction t where t.id in  (select d.TSFunction.id from TSRoleFunction d where d.TSRole.id in(select t.TSRole.id from TSRoleUser t where t.TSUser.id ='"+
	           user.getId()+"' ))";
	           String hql2="from TSFunction t where t.id in  ( select b.tsRole.id from TSRoleOrg b where b.tsDepart.id in(select a.tsDepart.id from TSUserOrg a where a.tsUser.id='"+
	           user.getId()+"'))";
	           List<TSFunction> list = systemService.findHql(hql);
	           log.info("role functions:  "+list.size());
	           for(TSFunction function:list){
	              loginActionlist.put(function.getId(),function);
	           }
	           List<TSFunction> list2 = systemService.findHql(hql2);
	           log.info("org functions: "+list2.size());
	           for(TSFunction function:list2){
	              loginActionlist.put(function.getId(),function);
	           }*/

	           StringBuilder hqlsb1=new StringBuilder("select distinct f from TSFunction f,TSRoleFunction rf,TSRoleUser ru  ").append("where ru.TSRole.id=rf.TSRole.id and rf.TSFunction.id=f.id and ru.TSUser.id=? ");

	           StringBuilder hqlsb2=new StringBuilder("select distinct c from TSFunction c,TSRoleFunction rf,TSRoleOrg b,TSUserOrg a ")
	           							.append("where a.tsDepart.id=b.tsDepart.id and b.tsRole.id=rf.TSRole.id and rf.TSFunction.id=c.id and a.tsUser.id=?");
	           List<TSFunction> list1 = systemService.findHql(hqlsb1.toString(),user.getId());
	           List<TSFunction> list2 = systemService.findHql(hqlsb2.toString(),user.getId());
	           for(TSFunction function:list1){
		              loginActionlist.put(function.getId(),function);
		       }
	           for(TSFunction function:list2){
		              loginActionlist.put(function.getId(),function);
		       }
            client.setFunctions(loginActionlist);

            //清空变量，降低内存使用
            list2.clear();
            list1.clear();

		}
		return client.getFunctions();
	}

    /**
     * 根据 角色实体 组装 用户权限列表
     * @param loginActionlist 登录用户的权限列表
     * @param role 角色实体
     * @deprecated
     */
    private void assembleFunctionsByRole(Map<String, TSFunction> loginActionlist, TSRole role) {
        List<TSRoleFunction> roleFunctionList = systemService.findByProperty(TSRoleFunction.class, "TSRole.id", role.getId());
        for (TSRoleFunction roleFunction : roleFunctionList) {
            TSFunction function = roleFunction.getTSFunction();
            if(function.getFunctionType().intValue()==Globals.Function_TYPE_FROM.intValue()){
				//如果为表单或者弹出 不显示在系统菜单里面
				continue;
			}
            loginActionlist.put(function.getId(), function);
        }
    }


    /**
	 * 首页跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "home")
	public ModelAndView home(HttpServletRequest request) {

		SysThemesEnum sysTheme = SysThemesUtil.getSysTheme(request);
		//ACE ACE2 DIY时需要在home.jsp头部引入依赖的js及css文件
		if("ace".equals(sysTheme.getStyle())||"diy".equals(sysTheme.getStyle())||"acele".equals(sysTheme.getStyle())){
			request.setAttribute("show", "1");
		} else {//default及shortcut不需要引入依赖文件，所有需要屏蔽
			request.setAttribute("show", "0");
		}

		return new ModelAndView("main/home");
	}
	
	  /**
	 * ACE首页跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "acehome")
	public ModelAndView acehome(HttpServletRequest request) {

		SysThemesEnum sysTheme = SysThemesUtil.getSysTheme(request);
		//ACE ACE2 DIY时需要在home.jsp头部引入依赖的js及css文件
		if("ace".equals(sysTheme.getStyle())||"diy".equals(sysTheme.getStyle())||"acele".equals(sysTheme.getStyle())){
			request.setAttribute("show", "1");
		} else {//default及shortcut不需要引入依赖文件，所有需要屏蔽
			request.setAttribute("show", "0");
		}

		return new ModelAndView("main/acehome");
	}
	/**
	 * HPLUS首页跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "hplushome")
	public ModelAndView hplushome(HttpServletRequest request) {
		SysThemesEnum sysTheme = SysThemesUtil.getSysTheme(request);
		if("ace".equals(sysTheme.getStyle())||"diy".equals(sysTheme.getStyle())||"acele".equals(sysTheme.getStyle())){
			request.setAttribute("show", "1");
		} else {//default及shortcut不需要引入依赖文件，所有需要屏蔽
			request.setAttribute("show", "0");
		}
		TSUser user = ResourceUtil.getSessionUserName();
		String roles = "";
		String name = "管理员";
		if (user != null) {
			List<TSRoleUser> rUsers = systemService.findByProperty(TSRoleUser.class, "TSUser.id", user.getId());
			for (TSRoleUser ru : rUsers) {
				TSRole role = ru.getTSRole();
				roles += role.getRoleName() + ",";
			}
			String[] roleName = roles.split(",");
			List<String> list = Arrays.asList(roleName);
			Map<String, Object> map = new HashMap<String, Object>();
			List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
			String refresh = DateUtils.getDateFormatter();
			map.put("refresh", refresh);
			if(list.contains(name)){
//				如果是管理员用户则将所有需要的记录查询传入前台
//				待安装数量
				Long orgNum = systemService.getCountForJdbc("select count(1) from w_install where install_progress = '0' ");
				map.put("orgNum", orgNum);
//				request.setAttribute("orgNum", orgNum);
//				待维修数量
				Long wxNum = systemService.getCountForJdbc("select count(1) from w_maintain where maintain_state = '0' ");
				map.put("wxNum", wxNum);
//				request.setAttribute("wxNum", wxNum);
//				礼品兑换总数
				Long giftNum = systemService.getCountForJdbc("select count(1) from w_gift_exchange where giftexchange_state = '1' ");
				map.put("giftNum", giftNum);
//				request.setAttribute("giftNum", giftNum);
//				待回复信息数量0为待处理，1为已处理
				Long msgNum = systemService.getCountForJdbc("select count(1) from w_complaint where complaint_state = '0' ");
				map.put("msgNum", msgNum);
//				告警数量
				Long warLong = systemService.getCountForJdbc("select count(1) from w_water_warning ");
				map.put("warLong", warLong);
//				新增会员数,获取本月开始时间及结束时间，在这当中的新增会员都算新增的。注册用户一样。两种实现，一种是获取当前月份开始及结束日期去对比。另一种使用sql直接获取本月数据。
				Long DateNum = systemService.getCountForJdbc("select count(*) from w_user_member where date_format(create_date,'%Y-%m')=date_format(CURDATE(),'%Y-%m')");
				map.put("DateNum", DateNum);	
				//				request.setAttribute("DateNum", DateNum);
//				新增注册数
				Long DateNum1 = systemService.getCountForJdbc("select count(*) from w_user_register where date_format(create_date,'%Y-%m')=date_format(CURDATE(),'%Y-%m')");
				map.put("DateNum1", DateNum1);
//				request.setAttribute("DateNum1", DateNum1);
//				充值金额
				Long moneyNum = systemService.getCountForJdbc("select sum(recharge_sum) from w_recharge where date_format(create_date,'%Y-%m')=date_format(CURDATE(),'%Y-%m')");
				if(moneyNum == null)
					moneyNum = Long.valueOf("0");
				map.put("moneyNum", moneyNum);
//				今日用水总量
				Long warteNum = systemService.getCountForJdbc("select sum(water_statistics) from w_water_statistics where date_format(create_date,'%D')=date_format(now(),'%D')");
				if(warteNum == null)
					warteNum = Long.valueOf("0");
				map.put("warteNum", warteNum);
			}else{
//				待安装数量
				Long orgNum = systemService.getCountForJdbc("select count(1) from w_install where install_progress = '0' ");
				map.put("orgNum", orgNum);
//				request.setAttribute("orgNum", orgNum);
//				待维修数量
				Long wxNum = systemService.getCountForJdbc("select count(1) from w_maintain where maintain_state = '0' ");
				map.put("wxNum", wxNum);
				map.put("roleName", 2);
			}
			list1.add(map);
			request.setAttribute("longMap", list1);
		}
		//ACE ACE2 DIY时需要在home.jsp头部引入依赖的js及css文件
		/*if("ace".equals(sysTheme.getStyle())||"diy".equals(sysTheme.getStyle())||"acele".equals(sysTheme.getStyle())){
			request.setAttribute("show", "1");
		} else {//default及shortcut不需要引入依赖文件，所有需要屏蔽
			request.setAttribute("show", "0");
		}*/

//		return new ModelAndView("main/hplushome");//跳转原有jeecg页面
		//跳转饮水机页面
		return new ModelAndView("main/waterhome");
	}
	/**
	 * 无权限页面提示跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "noAuth")
	public ModelAndView noAuth(HttpServletRequest request) {
		return new ModelAndView("common/noAuth");
	}
	/**
	 * @Title: top
	 * @Description: bootstrap头部菜单请求
	 * @param request
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping(params = "top")
	public ModelAndView top(HttpServletRequest request) {
		TSUser user = ResourceUtil.getSessionUserName();
		HttpSession session = ContextHolderUtils.getSession();
		// 登陆者的权限
		if (user.getId() == null) {
			session.removeAttribute(Globals.USER_SESSION);
			return new ModelAndView(
					new RedirectView("loginController.do?login"));
		}
		request.setAttribute("menuMap", getFunctionMap(user));
		return new ModelAndView("main/bootstrap_top");
	}
	/**
	 * @Title: top
	 * @author gaofeng
	 * @Description: shortcut头部菜单请求
	 * @param request
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping(params = "shortcut_top")
	public ModelAndView shortcut_top(HttpServletRequest request) {
		TSUser user = ResourceUtil.getSessionUserName();
		HttpSession session = ContextHolderUtils.getSession();
		// 登陆者的权限
		if (user.getId() == null) {
			session.removeAttribute(Globals.USER_SESSION);
			return new ModelAndView(
					new RedirectView("loginController.do?login"));
		}
		request.setAttribute("menuMap", getFunctionMap(user));
		return new ModelAndView("main/shortcut_top");
	}
	
	/**
	 * @Title: top
	 * @author:gaofeng
	 * @Description: shortcut头部菜单一级菜单列表，并将其用ajax传到页面，实现动态控制一级菜单列表
	 * @return AjaxJson
	 * @throws
	 */
    @RequestMapping(params = "primaryMenu")
    @ResponseBody
	public String getPrimaryMenu() {
		List<TSFunction> primaryMenu = getFunctionMap(ResourceUtil.getSessionUserName()).get(0);
        String floor = "";

        if (primaryMenu == null) {
            return floor;
        }

        for (TSFunction function : primaryMenu) {
            if(function.getFunctionLevel() == 0) {
            	String lang_key = function.getFunctionName();
            	String lang_context = mutiLangService.getLang(lang_key);
            	lang_context=lang_context.trim();

            	if("业务申请".equals(lang_context)){

                	String ss = "<div style='width:67px;position: absolute;top:39px;text-align:center;color:#909090;font-size:13px;'><span style='letter-spacing:-1px;'>"+ lang_context +"</span></div>";
                    floor += " <li style='position: relative;'>"+ss+"<img class='imag1' src='plug-in/login/images/ywsq.png' /> "
                            + " <img class='imag2' src='plug-in/login/images/ywsq-up.png' style='display: none;' /></li> ";
                }else if("个人办公".equals(lang_context)){

                	String ss = "<div style='width:67px;position: absolute;top:39px;text-align:center;color:#909090;font-size:13px;'><span style='letter-spacing:-1px;'>"+ lang_context +"</span></div>";
                    floor += " <li style='position: relative;'>"+ss+"<img class='imag1' src='plug-in/login/images/grbg.png' /> "
                            + " <img class='imag2' src='plug-in/login/images/grbg-up.png' style='display: none;' /></li> ";
                }else if("流程管理".equals(lang_context)){

                	String ss = "<div style='width:67px;position: absolute;top:39px;text-align:center;color:#909090;font-size:13px;'><span style='letter-spacing:-1px;'>"+ lang_context +"</span></div>";
                    floor += " <li style='position: relative;'>"+ss+"<img class='imag1' src='plug-in/login/images/lcsj.png' /> "
                            + " <img class='imag2' src='plug-in/login/images/lcsj-up.png' style='display: none;' /></li> ";
                }else if("Online 开发".equals(lang_context)){

                    floor += " <li><img class='imag1' src='plug-in/login/images/online.png' /> "
                            + " <img class='imag2' src='plug-in/login/images/online_up.png' style='display: none;' />" + " </li> ";
                }else if("自定义表单".equals(lang_context)){

                	String ss = "<div style='width:67px;position: absolute;top:39px;text-align:center;color:#909090;font-size:13px;'><span style='letter-spacing:-1px;'>"+ lang_context +"</span></div>";
                    floor += " <li style='position: relative;'>"+ss+"<img class='imag1' src='plug-in/login/images/zdybd.png' /> "
                            + " <img class='imag2' src='plug-in/login/images/zdybd-up.png' style='display: none;' /></li> ";
                }else if("系统监控".equals(lang_context)){

                    floor += " <li><img class='imag1' src='plug-in/login/images/xtjk.png' /> "
                            + " <img class='imag2' src='plug-in/login/images/xtjk_up.png' style='display: none;' />" + " </li> ";
                }else if("统计报表".equals(lang_context)){

                    floor += " <li><img class='imag1' src='plug-in/login/images/tjbb.png' /> "
                            + " <img class='imag2' src='plug-in/login/images/tjbb_up.png' style='display: none;' />" + " </li> ";
                }else if("消息中间件".equals(lang_context)){
                	String ss = "<div style='width:67px;position: absolute;top:39px;text-align:center;color:#909090;font-size:13px;'><span style='letter-spacing:-1px;'>"+ lang_context +"</span></div>";
                    floor += " <li style='position: relative;'>"+ss+"<img class='imag1' src='plug-in/login/images/msg.png' /> "
                            + " <img class='imag2' src='plug-in/login/images/msg_up.png' style='display: none;' /></li> ";
                }else if("系统管理".equals(lang_context)){

                    floor += " <li><img class='imag1' src='plug-in/login/images/xtgl.png' /> "
                            + " <img class='imag2' src='plug-in/login/images/xtgl_up.png' style='display: none;' />" + " </li> ";
                }else if("常用示例".equals(lang_context)){

                    floor += " <li><img class='imag1' src='plug-in/login/images/cysl.png' /> "
                            + " <img class='imag2' src='plug-in/login/images/cysl_up.png' style='display: none;' />" + " </li> ";
                }else if(lang_context.contains("消息推送")){
                	
                	String s = "<div style='width:67px;position: absolute;top:39px;text-align:center;color:#909090;font-size:13px;'>消息推送</div>";
                    floor += " <li style='position: relative;'>"+s+"<img class='imag1' src='plug-in/login/images/msg.png' /> "
                            + " <img class='imag2' src='plug-in/login/images/msg_up.png' style='display: none;' /></li> ";
                }else{
                    //其他的为默认通用的图片模式
                	String s="";
                    if(lang_context.length()>=5 && lang_context.length()<7){
                        s = "<div style='width:67px;position: absolute;top:39px;text-align:center;color:#909090;font-size:13px;'><span style='letter-spacing:-1px;'>"+ lang_context +"</span></div>";
                    }else if(lang_context.length()<5){
                        s = "<div style='width:67px;position: absolute;top:39px;text-align:center;color:#909090;font-size:13px;'>"+ lang_context +"</div>";
                    }else if(lang_context.length()>=7){
                        s = "<div style='width:67px;position: absolute;top:39px;text-align:center;color:#909090;font-size:13px;'><span style='letter-spacing:-1px;'>"+ lang_context.substring(0, 6) +"</span></div>";
                    }
                    floor += " <li style='position: relative;'>"+s+"<img class='imag1' src='plug-in/login/images/default.png' /> "
                            + " <img class='imag2' src='plug-in/login/images/default_up.png' style='display: none;' />"
                            +"</li> ";
                }

            }
        }

		return floor;
	}

	/**
	 * @Title: top
	 * @author:wangkun
	 * @Description: shortcut头部菜单二级菜单列表，并将其用ajax传到页面，实现动态控制二级菜单列表
	 * @return AjaxJson
	 * @throws
	 */
	@RequestMapping(params = "primaryMenuDiy")
	@ResponseBody
	public String getPrimaryMenuDiy() {
		//取二级菜单
		List<TSFunction> primaryMenu = getFunctionMap(ResourceUtil.getSessionUserName()).get(1);
		String floor = "";
		if (primaryMenu == null) {
			return floor;
		}
		String menuString = "user.manage role.manage department.manage menu.manage";
		for (TSFunction function : primaryMenu) {
			if(menuString.contains(function.getFunctionName())){
				if(function.getFunctionLevel() == 1) {

					String lang_key = function.getFunctionName();
					String lang_context = mutiLangService.getLang(lang_key);
					if("申请".equals(lang_key)){
						lang_context = "申请";
						String s = "";
						s = "<div style='width:67px;position: absolute;top:47px;text-align:center;color:#000000;font-size:12px;'>"+ lang_context +"</div>";
						floor += " <li><img class='imag1' src='plug-in/login/images/head_icon1.png' /> "
								+ " <img class='imag2' src='plug-in/login/images/head_icon1.png' style='display: none;' />" + s + " </li> ";
					} else if("Online 开发".equals(lang_context)){

						floor += " <li><img class='imag1' src='plug-in/login/images/online.png' /> "
								+ " <img class='imag2' src='plug-in/login/images/online_up.png' style='display: none;' />" + " </li> ";
					}else if("统计查询".equals(lang_context)){

						floor += " <li><img class='imag1' src='plug-in/login/images/guanli.png' /> "
								+ " <img class='imag2' src='plug-in/login/images/guanli_up.png' style='display: none;' />" + " </li> ";
					}else if("系统管理".equals(lang_context)){

						floor += " <li><img class='imag1' src='plug-in/login/images/xtgl.png' /> "
								+ " <img class='imag2' src='plug-in/login/images/xtgl_up.png' style='display: none;' />" + " </li> ";
					}else if("常用示例".equals(lang_context)){

						floor += " <li><img class='imag1' src='plug-in/login/images/cysl.png' /> "
								+ " <img class='imag2' src='plug-in/login/images/cysl_up.png' style='display: none;' />" + " </li> ";
					}else if("系统监控".equals(lang_context)){

						floor += " <li><img class='imag1' src='plug-in/login/images/xtjk.png' /> "
								+ " <img class='imag2' src='plug-in/login/images/xtjk_up.png' style='display: none;' />" + " </li> ";
					}else if(lang_context.contains("消息推送")){
						String s = "<div style='width:67px;position: absolute;top:40px;text-align:center;color:#909090;font-size:12px;'>消息推送</div>";
						floor += " <li style='position: relative;'><img class='imag1' src='plug-in/login/images/msg.png' /> "
								+ " <img class='imag2' src='plug-in/login/images/msg_up.png' style='display: none;' />"
								+ s +"</li> ";
					}else{
						//其他的为默认通用的图片模式
						String s = "";
						if(lang_context.length()>=5 && lang_context.length()<7){
							s = "<div style='width:67px;position: absolute;top:40px;text-align:center;color:#000000;font-size:12px;'><span style='letter-spacing:-1px;'>"+ lang_context +"</span></div>";
						}else if(lang_context.length()<5){
							s = "<div style='width:67px;position: absolute;top:40px;text-align:center;color:#000000;font-size:12px;'>"+ lang_context +"</div>";
						}else if(lang_context.length()>=7){
							s = "<div style='width:67px;position: absolute;top:40px;text-align:center;color:#000000;font-size:12px;'><span style='letter-spacing:-1px;'>"+ lang_context.substring(0, 6) +"</span></div>";
						}
						floor += " <li style='position: relative;'><img class='imag1' src='plug-in/login/images/head_icon2.png' /> "
								+ " <img class='imag2' src='plug-in/login/images/default_up.png' style='display: none;' />"
								+ s +"</li> ";
					}
				}
			}
		}

		return floor;
	}
	/**
	 * 云桌面返回：用户权限菜单
	 */
	@RequestMapping(params = "getPrimaryMenuForWebos")
	@ResponseBody
	public AjaxJson getPrimaryMenuForWebos() {
		AjaxJson j = new AjaxJson();
		//将菜单加载到Session，用户只在登录的时候加载一次
		Object getPrimaryMenuForWebos =  ContextHolderUtils.getSession().getAttribute("getPrimaryMenuForWebos");
		if(oConvertUtils.isNotEmpty(getPrimaryMenuForWebos)){
			j.setMsg(getPrimaryMenuForWebos.toString());
		}else{
			String PMenu = ListtoMenu.getWebosMenu(getFunctionMap(ResourceUtil.getSessionUserName()));
			ContextHolderUtils.getSession().setAttribute("getPrimaryMenuForWebos", PMenu);
			j.setMsg(PMenu);
		}
		return j;
	}

    /**
     * 另一套登录界面
     * @return
     */
    @RequestMapping(params = "login2")
    public String login2(){
        return "login/login2";
    }
	/**
	 * ACE登录界面
	 * @return
	 */
	@RequestMapping(params = "login3")
	public String login3(){
		return "login/login3";
	}
}