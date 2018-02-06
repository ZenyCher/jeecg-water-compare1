package com.jeecg.api.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.ehcache.CacheManager;

import org.apache.commons.collections.functors.IfClosure;
import org.apache.commons.lang.xwork.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.util.ContextHolderUtils;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.JSONHelper;
import org.jeecgframework.core.util.PropertiesUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.web.cgform.service.build.DataBaseService;
import org.jeecgframework.web.cgform.util.TableJson;
import org.jeecgframework.web.system.controller.core.LoginController;
import org.jeecgframework.web.system.service.MutiLangServiceI;
import org.jeecgframework.web.system.sms.util.JavaSmsAPIDemo_Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jeecg.api.Pay.AliPayAdaptor;
import com.jeecg.api.Pay.WechatPayAdaptor;
import com.jeecg.api.bizEnum.AllEnum;
import com.jeecg.api.bizEnum.BizResultEnum;
import com.jeecg.api.entity.AliPayMetaData;
import com.jeecg.api.entity.AliPayResult;
import com.jeecg.api.entity.ThirdPartyPaymentResult;
import com.jeecg.api.entity.WechatMetaData;
import com.jeecg.api.sdk.AliPaySDK;
import com.jeecg.api.sdk.WechatConstants;
import com.jeecg.api.sdk.WechatSdk;
import com.jeecg.orderpay.entity.WOrderPayEntity;
import com.jeecg.orderpay.service.WOrderPayServiceI;
import com.jeecg.waterdispenser.entity.WDevicePurchaseEntity;
import com.jeecg.waterdispenser.entity.WUserMemberEntity;
import com.jeecg.waterdispenser.entity.WUserRegisterEntity;
import com.jeecg.waterdispenser.service.WDevicePurchaseServiceI;
import com.jeecg.waterdispenser.service.WUserMemberServiceI;
import com.jeecg.waterdispenser.service.WUserRegisterServiceI;
import com.jeecg.waterdispenser.util.SecurityUtil;

/**
 * APP登陆初始化控制器
 * @author 张代浩
 * 
 */
//@Scope("prototype")
@Controller
@RequestMapping("/api/appLoginController")
public class Applogincontroller {

	@Autowired
	private WOrderPayServiceI payService;
	@Autowired
	private WDevicePurchaseServiceI purchaseService;
	
	private static final Logger logger = Logger.getLogger(Applogincontroller.class);
	
	/**
	 * 签名密钥key
	 */
	private static final String SIGN_KEY = "26F72780372E84B6CFAED6F7B19139CC47B1912B6CAED753";
	
	public static CacheManager manager = CacheManager.create();
	
	
	private Logger log = Logger.getLogger(LoginController.class);

	@Autowired
	private MutiLangServiceI mutiLangService;
	@Autowired
	private WUserRegisterServiceI wuserRegisterService;
	@Autowired
	private WUserMemberServiceI wUserMemberServiceI;
	@Autowired
	private DataBaseService dataBaseService;
	
	/**
	 * 注册验证验证码
	 * @param body
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(params = "verificationMobileCode")
	@ResponseBody
	public TableJson verificationMobileCode(String body,HttpServletRequest request,HttpServletResponse response){
		Map map = JSONHelper.json2Map(body);
		TableJson j = new TableJson();
		HttpSession session = ContextHolderUtils.getSession();
		String phone = oConvertUtils.getString(map.get("phone"));
		String mobile_code = oConvertUtils.getString(map.get("mobile_code"));
		String code = session.getAttribute(phone+"MOBILE_CODE").toString();
		if( !code.equals(mobile_code) ){
			j.setMsg("验证码输入错误");
			j.setSuccess(false);
			return j;
		}
		j.setMsg("验证成功!");
		return j;
	}
	
	/**
	 * APP用户注册
	 * @param body
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(params = "registerUser")
	@ResponseBody
	public TableJson registerUser(String body,HttpServletRequest request,HttpServletResponse response){
		Map map = JSONHelper.json2Map(body);
		TableJson j = new TableJson();
		WUserMemberEntity wUserMemberEntity = new WUserMemberEntity();
		WUserRegisterEntity wUserRegisterEntity = new WUserRegisterEntity();
		String phone = oConvertUtils.getString(map.get("member_phone"));
		String address = oConvertUtils.getString(map.get("member_address"));
		String name = oConvertUtils.getString(map.get("member_name"));
		String registerName = oConvertUtils.getString(map.get("register_name"));
		if( StringUtil.isNotEmpty(phone)){
			wUserMemberEntity.setMemberPhone(phone);//会员联系方式改成会员id
			wUserMemberEntity.setMemberAddress(address);
			wUserMemberEntity.setMemberName(name);
			wUserMemberEntity.setMemberUser(registerName);
			wUserMemberEntity.setMemberType(phone);//会员联系方式
			wUserMemberEntity.setMemberState(AllEnum.STATE_1.getValue());
			wUserMemberEntity.setMemberSource(AllEnum.STATE_1.getValue());
			try {
				wUserMemberServiceI.save(wUserMemberEntity);
				wUserRegisterEntity.setMemberPhone(phone);
				wUserRegisterEntity.setRegisterName(registerName);
				wUserRegisterEntity.setRegisterPhone(phone);
				wUserRegisterEntity.setRegisterState(oConvertUtils.getInt((AllEnum.STATE_1.getValue()), 1));
				wUserRegisterEntity.setRegisterType(oConvertUtils.getString(AllEnum.STATE_0.getValue()));
				wUserRegisterEntity.setRegisterRelation(name);
				wuserRegisterService.save(wUserRegisterEntity);
				j.setMsg("注册成功，请重新登录。");
			} catch (Exception e) {
				j.setSuccess(false);
				j.setMsg("注册会员失败，请稍后再试!");
			}
		}else{
			j.setSuccess(false);
			j.setMsg("参数错误!");
		}
		return j;
	}
	
	
    /**
	 * app用户获取验证码
	 * 
	 * @param request
	 * @return
     * @throws Exception 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(params = "login")
	@ResponseBody
	public TableJson login(String body, HttpServletRequest request,HttpServletResponse response) throws Exception {
		Map map = JSONHelper.json2Map(body);
		TableJson j = new TableJson();
		if (StringUtil.isNotEmpty(map.get("member_phone")) && StringUtil.isNotEmpty(map.get("type"))) {
			String phone = oConvertUtils.getString(map.get("member_phone"));
			int mobile_code = (int) ((Math.random() * 9 + 1) * 100000);//验证码
//			int mobile_code = 999444;//验证码
			String content = new String("验证码：" + mobile_code + "，打死都不要告诉别人哦！");//短信内容
			try {
				if(JavaSmsAPIDemo_Json.singleSend(phone, content).equals("0")){
//				if(mobile_code == 999444){
					System.out.println("短信发送成功：手机号：" + phone + ", " + content);
//					发送验证码之后根据手机号码及时间戳和验证码生成token
					long dateL = System.currentTimeMillis();
					String str = phone + String.valueOf(mobile_code) + String.valueOf(dateL);
//					将验证码放入session，验证之后清除
					HttpSession session = ContextHolderUtils.getSession();
					session.setAttribute(phone+"MOBILE_CODE", String.valueOf(mobile_code));
					session.setAttribute("3805_code", "3805");
					if( "0".equals(oConvertUtils.getString(map.get("type"))) ){
						j.setMsg("发送验证码成功！");
						return j;
					}
					String token = com.jeecg.waterdispenser.util.MD5Util.md5(str);
					if( !SecurityUtil.updateVerElementValue(phone, token) ){
						throw new BusinessException("token获取错误");
					}
//					将token放入map返回
					Map<String, Object> maoToken = new HashMap<String, Object>();
					maoToken.put("token", token);
					maoToken.put("code", mobile_code);
					j.setTableData(maoToken);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new BusinessException("手机验证码发送失败，请重新操作");
			}

		} else {
			j.setMsg("手机号码为空");
			j.setSuccess(false);
		}
		return j;
	}
	
	
	/**
	 * APP移动端上传实体及图片
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(params = "appUploadImage")
	@ResponseBody
	public TableJson AppUploadTableImage(HttpServletRequest request,HttpServletResponse response){
		TableJson j = new TableJson();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, Object> entityMap = new HashMap<String, Object>();
		String fileName = null;
		//获取保存实体所需参数
		String id = multipartRequest.getParameter("id");
		String tableName = multipartRequest.getParameter("tableName");
		String tableField = multipartRequest.getParameter("tableField");
		//图片上传
		String ctxPath=ResourceUtil.getConfigByName("serverWebUploadpath");
 		File file = new File(ctxPath+File.separator);
 		if (!file.exists()) {
			file.mkdir();
		}
        MultipartFile mf=multipartRequest.getFile("file");// 获取上传文件对象
		fileName = mf.getOriginalFilename();// 获取文件名
		String savePath = file.getPath() + File.separator + fileName;
		File savefile = new File(savePath);
		try {
			FileCopyUtils.copy(mf.getBytes(), savefile);
		} catch (Exception e) {
			j.setMsg("上传文件失败，请稍后再试");
			j.setSuccess(false);
		}
		StringBuffer tableFieldValue = new StringBuffer();
		tableFieldValue.append(ctxPath.substring(4, ctxPath.length())).append("/" + fileName);
		String str = multipartRequest.getParameter("body");
//		Map<String,Object> map = JSONHelper.json2Map(multipartRequest.getParameter("body"));
		Map<String,Object> map = JSONHelper.json2Map(str);
		//根据表名和id查询该条记录是否为空,为空则新建，不为空则更新
		entityMap.put("id", id);
		List<Map<String, Object>> list = dataBaseService.findTableKeyAndValue(tableName, entityMap);
		try {
			if( list.isEmpty() && list.size() == 0 ) {
				map.put("id", id);
				map.put(tableField, tableFieldValue.toString());
				dataBaseService.insertTable(tableName, map);
			}else {
				StringBuffer valueSb = new StringBuffer();
				//判断图片字段是否已有数值，有则加逗号继续添加
				for (Map<String, Object> map2 : list) {
					String value = (String) map2.get(tableField);
					if( oConvertUtils.isNotEmpty(value) ){
						String ctxPath1=ResourceUtil.getConfigByName("uploadFiles");
						File file2 = new File(ctxPath1+value);
						file2.delete();
					}
					valueSb.append(tableFieldValue.toString());
				}
				map.put(tableField, valueSb.toString());
				dataBaseService.updateTable(tableName, id, map);
			}
			List<Map<String, Object>> list2 = dataBaseService.findTableKeyAndValue(tableName, entityMap);
			j.setTableData(list2);
			j.setMsg("更新成功");
		} catch (Exception e) {
			j.setMsg("表数据更新失败，请稍后再试");
			j.setSuccess(false);
		}
		return j;
	}
	
    /**
	 * app用户登陆验证
	 * 
	 * @param request
	 * @return
     * @throws Exception 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(params = "loginValidate")
	@ResponseBody
	public TableJson loginValidate(String body,HttpServletRequest request,HttpServletResponse response) throws Exception {
		Map map = JSONHelper.json2Map(body);
		TableJson j = new TableJson();
		String phone = oConvertUtils.getString(map.get("member_phone"));
		String mobile_code = oConvertUtils.getString(map.get("code"));
		if(oConvertUtils.isEmpty(mobile_code)) {
			j.setMsg("验证码不能为空");
			j.setSuccess(false);
			return j;
		}
		HttpSession session = ContextHolderUtils.getSession();
		System.out.println("code========" + session.getAttribute(phone+"MOBILE_CODE"));
		System.out.println("code1=======" + session.getAttribute("3805_code"));
		String code = (String)session.getAttribute(phone+"MOBILE_CODE");
		String code1 = (String)session.getAttribute("3805_code");
		if( !code.equals(mobile_code) && !code1.equals(mobile_code)){
			j.setMsg("验证码输入错误");
			j.setSuccess(false);
			return j;
		}
		System.out.println("code========获取验证码");
		System.out.println("code1=======获取验证码");
//		清除该用户的session验证码
//		session.removeAttribute(oConvertUtils.getString(phone+"MOBILE_CODE"));
//		session.removeAttribute(oConvertUtils.getString("3805_code"));
//		验证token是否正确
		if(!SecurityUtil.saveVerificationToken(oConvertUtils.getString(map.get("member_phone")),oConvertUtils.getString(map.get("token")))){
			j.setTokenValid(false);
			j.setSuccess(false);
			return j;
		}
//		根据手机号码判定用户是否存在
		List<Map<String, Object>> list = wuserRegisterService.selectUserRegisterByRegisterPhone(phone);
		if( !list.isEmpty() ) {
			j.setTableData(list);
		}else{
			j.setSuccess(true);
			//隐式注册新用户
			WUserRegisterEntity entity = new WUserRegisterEntity();
			entity.setMemberPhone(phone);
			entity.setRegisterPhone(phone);
			entity.setRegisterState(oConvertUtils.getInt((AllEnum.STATE_1.getValue()), 1));
			entity.setRegisterType(oConvertUtils.getString(AllEnum.STATE_0.getValue()));
			wuserRegisterService.save(entity);
			long dateL = System.currentTimeMillis();
			String str = phone + String.valueOf(mobile_code) + String.valueOf(dateL);
			String token = com.jeecg.waterdispenser.util.MD5Util.md5(str);
			session.removeAttribute(oConvertUtils.getString(phone+"MOBILE_CODE"));
//			将token放入map返回
			Map<String, Object> maoToken = new HashMap<String, Object>();
			maoToken.put("token", token);
			maoToken.put("code", mobile_code);
			maoToken.put("register_id", entity.getId());
			maoToken.put("register_phone", entity.getRegisterPhone());
			maoToken.put("register_type", entity.getRegisterType());
			j.setTableData(maoToken);
			
		}
		return j;
	}
	
	/**
	 * 微信调用接口，根据前台的参数在此生成订单，将订单发往微信统一下单地址，得到需要的信息返回给前台进行操作。
	 * @param request
	 * @param response
	 * @return
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(params = "pay")
	@ResponseBody
	public TableJson wechatPay(String body,HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		Map map = JSONHelper.json2Map(body);
		TableJson j = new TableJson();
		
		logger.info("订单开始==============================================body="+body);
		
		String payFee = oConvertUtils.getString(map.get("payFee"));//支付金额
		String waterId = oConvertUtils.getString(map.get("waterId"));//要充值的水表编号
		String goodsId = oConvertUtils.getString(map.get("goodsId"));//商品id
		String goodsNumber = oConvertUtils.getString(map.get("goodsNumber"));//商品数量
		String payType = oConvertUtils.getString(map.get("pay_type"));//支付方式
		String goodsInfo = oConvertUtils.getString(map.get("goodsInfo"));//商品信息
		String address = oConvertUtils.getString(map.get("address"));//收货地址
		String receiver = oConvertUtils.getString(map.get("receiver"));//收件人
		String receiverMobile = oConvertUtils.getString(map.get("receiverMobile"));
		String memberId = oConvertUtils.getString(map.get("memberId"));//会员ID
		if(StringUtils.isNotBlank(oConvertUtils.getString(map.get("type")))) {
			goodsInfo = new String(goodsInfo.getBytes("ISO-8859-1"),"UTF-8");
			address = new String(address.getBytes("ISO-8859-1"),"UTF-8");
			receiver = new String(receiver.getBytes("ISO-8859-1"),"UTF-8");
		}
		String phone = oConvertUtils.getString(map.get("member_phone"));//会员号码

		
		String transactionType = oConvertUtils.getString(map.get("transactionType"));
		//参数校验
		if(StringUtil.isEmpty(goodsId)){
			j.setMsg("商品编号不能为空！");
			j.setSuccess(false);
			return j;
		}
	/*	if(StringUtil.isEmpty(waterId)){
			j.setMsg("水表编号不能为空");
			j.setSuccess(false);
			return j;
		}*/
		if(StringUtil.isEmpty(payFee)){
			j.setMsg("请输入订单金额");
			j.setSuccess(false);
			return j;
		}
		if(StringUtil.isEmpty(goodsInfo)){
			j.setMsg("商品信息不能为空!");
			j.setSuccess(false);
			return j;
		}
//		if(!(Long.parseLong(payFee)%100==0)){
//			j.setMsg("订单金额有误！");
//			j.setSuccess(false);
//			return j;
//		}
		//如果支付类型为空，则默认选择微信
		payType = StringUtil.isEmpty(payType, WechatConstants.wx_pay);
		transactionType = StringUtil.isEmpty(transactionType, WechatConstants.RECHARGE);
		
		//验证token，如果该token已存在，则放行，如不存在则通知前段调用发送手机验证码接口重新登录
//		if( !SecurityUtil.saveVerificationToken(oConvertUtils.getString(map.get("member_phone")),oConvertUtils.getString(map.get("token"))) ){
//			j.setTokenValid(false);
//			j.setSuccess(false);
//			j.setMsg("token校验失败");
//			return j;
//		}
		WechatPayAdaptor wechatPayAdaptor = new WechatPayAdaptor();
		WechatMetaData wechatMetaData = new WechatMetaData();
		ThirdPartyPaymentResult result = new ThirdPartyPaymentResult();
		PropertiesUtil util = new PropertiesUtil("wechat.properties");
		wechatMetaData.setAppid(util.readProperty("wechat.app.id"));
		wechatMetaData.setMch_id(util.readProperty("wechat.receiver.merchant.id"));
		wechatMetaData.setNonce_str(WechatSdk.genRondomString());
		wechatMetaData.setOut_trade_no(WechatSdk.genRondomString());
		BigDecimal big = new BigDecimal(payFee);
		wechatMetaData.setTotal_fee(big.multiply(new BigDecimal(100)).toBigInteger());
		wechatMetaData.setBody(goodsInfo);//商品信息
		wechatMetaData.setSpbill_create_ip(util.readProperty("wechat.server.ip"));
		wechatMetaData.setNotify_url(util.readProperty("wechat.callback.url"));
		wechatMetaData.setTrade_type(WechatConstants.TRADE_TYPE_APP);
		wechatMetaData.setSign(WechatSdk.signByMD5(wechatMetaData,util.readProperty("wechat.merchant.secretkey")));
		try {
			if(payType.equals(WechatConstants.wx_pay)){
				//微信支付
				WOrderPayEntity entity = new WOrderPayEntity();
				entity.setGoodsId(goodsId);
				entity.setGoodsNumber(Integer.valueOf(goodsNumber));
				entity.setWaterId(waterId);
				entity.setGoodsInfo(wechatMetaData.getBody());
				entity.setOrderDate(new Date());
				entity.setOutTradeNo(wechatMetaData.getOut_trade_no());
				entity.setPayType(payType);
				entity.setSettlementTotalFee(big.multiply(new BigDecimal(100)).toBigInteger().intValue());
				entity.setMember_phone(phone);
				entity.setTransaction_type(transactionType);
				payService.save(entity);
				
				//以上实体可直接从前台传回实体
				String string = WechatSdk.toXml(wechatMetaData);
				result = wechatPayAdaptor.pay(string);
				wechatMetaData = WechatSdk.parseXml(result.getRetDatagram().getBytes());
				entity.setReturnCode(wechatMetaData.getReturn_code());
				entity.setReturnMsg(wechatMetaData.getReturn_msg());
				entity.setTransactionId(wechatMetaData.getTransaction_id());
				entity.setPrepayId(wechatMetaData.getPrepay_id());
				entity.setAddress(address);
				entity.setReceiver(receiver);
				entity.setReceiverMobile(receiverMobile);
				if(StringUtils.isNotBlank(memberId)) {
					entity.setmemberId(memberId);
				}
				payService.updateEntitie(entity);
				j.setTableData(wechatMetaData);
				if(WechatConstants.TRADE_STATE_SUCCESS.equals(wechatMetaData.getReturn_code())){
					if(WechatConstants.BUYPURCHASE.equalsIgnoreCase(transactionType)){
						//购买的为设备
						//将订单信息保存到设备购买明细表中
						WDevicePurchaseEntity devicePurchaseEntity = new WDevicePurchaseEntity();
						devicePurchaseEntity.setDeviceId(goodsId);
						devicePurchaseEntity.setPurchaseNumber(goodsNumber);//数量
						devicePurchaseEntity.setPurchaseOrder(entity.getOutTradeNo());//订单号
						devicePurchaseEntity.setPurchasePhone(phone);
						devicePurchaseEntity.setPurchaseName(goodsInfo);
						devicePurchaseEntity.setPurchasePay(0);//未支付
						devicePurchaseEntity.setPurchaseTime(DateUtils.getDate("yyyy-MM-dd"));
						devicePurchaseEntity.setPurchaseCost(payFee);
						devicePurchaseEntity.setPurchaseGoods(0);
						purchaseService.save(devicePurchaseEntity);
					}
				}
				logger.info("订单信息:" + entity);
			}else if(payType.equals(WechatConstants.alipay)){
				//支付宝支付
				WOrderPayEntity entity = new WOrderPayEntity();
				entity.setGoodsId(goodsId);
				entity.setGoodsNumber(Integer.valueOf(goodsNumber));
				entity.setWaterId(waterId);
				entity.setGoodsInfo(wechatMetaData.getBody());
				entity.setOrderDate(new Date());
				entity.setOutTradeNo(wechatMetaData.getOut_trade_no());
				entity.setPayType(payType);
				//数据库中保存金额单位（分）
				entity.setSettlementTotalFee(big.multiply(new BigDecimal(100)).toBigInteger().intValue());
				entity.setMember_phone(phone);
				entity.setTransaction_type(transactionType);
				payService.save(entity);
				//以上实体可直接从前台传回实体
//				String string = WechatSdk.toXml(wechatMetaData);
//				result = wechatPayAdaptor.pay(string);
//				wechatMetaData = WechatSdk.parseXml(result.getRetDatagram().getBytes());
//				entity.setReturnCode(wechatMetaData.getReturn_code());
//				entity.setReturnMsg(wechatMetaData.getReturn_msg());
//				entity.setTransactionId(wechatMetaData.getTransaction_id());
//				entity.setPrepayId(wechatMetaData.getPrepay_id());
				entity.setAddress(address);
				entity.setReceiver(receiver);
				entity.setReceiverMobile(receiverMobile);
				if(StringUtils.isNotBlank(memberId)) {
					entity.setmemberId(memberId);
				}
				payService.updateEntitie(entity);
				
				String returnStr = AliPaySDK.doOrder(big.toString(), goodsInfo, goodsInfo, wechatMetaData.getOut_trade_no());
				wechatMetaData.setAlipayReturn(returnStr);
				
				j.setTableData(wechatMetaData);
				if (WechatConstants.BUYPURCHASE
						.equalsIgnoreCase(transactionType)) {
					// 购买的为设备
					// 将订单信息保存到设备购买明细表中
					WDevicePurchaseEntity devicePurchaseEntity = new WDevicePurchaseEntity();
					devicePurchaseEntity.setDeviceId(goodsId);
					devicePurchaseEntity.setPurchaseNumber(goodsNumber);// 数量
					devicePurchaseEntity.setPurchaseOrder(entity.getOutTradeNo());// 订单号
					devicePurchaseEntity.setPurchasePhone(phone);
					devicePurchaseEntity.setPurchaseName(goodsInfo);
					devicePurchaseEntity.setPurchasePay(0);// 未支付
					devicePurchaseEntity.setPurchaseTime(DateUtils.getDate("yyyy-MM-dd"));
					devicePurchaseEntity.setPurchaseCost(payFee);
					devicePurchaseEntity.setPurchaseGoods(0);
					purchaseService.save(devicePurchaseEntity);
				}
			}
		} catch (Exception e) {
			logger.error(ExceptionUtil.getExceptionMessage(e));
		}
		return j;
	}


	/**
	 * 微信查询支付（notify_url微信返回参数中有个链接，此链接返回的参数为支付结果，需对此链接中的结果进行业务逻辑处理，确定返回的结果是正常的，异步请求。）
	 * @param request
	 * @param response
	 * @return
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(params = "queryPay")
//	@RequestMapping(value = "/{queryPay}", method = RequestMethod.POST)
	@ResponseBody
	public ThirdPartyPaymentResult queryPay(WechatMetaData wechatMetaData,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		PropertiesUtil util = new PropertiesUtil("wechat.properties");
		wechatMetaData.setAppid(util.readProperty("wechat.app.id"));
		ThirdPartyPaymentResult result = new ThirdPartyPaymentResult();
		
		wechatMetaData.setMch_id(util.readProperty("wechat.receiver.merchant.id"));
//		 && StringUtil.isEmpty(wechatMetaData.getTransaction_id()
		if(StringUtil.isEmpty(wechatMetaData.getOut_trade_no())){
			result.setBizResult(BizResultEnum.FAILURE);
			result.setMessage("订单号不能为空");
			return result;
		}
		List<WOrderPayEntity> orderPay = payService.findByProperty(WOrderPayEntity.class, "outTradeNo", wechatMetaData.getOut_trade_no());
		if(orderPay.size() == 0){
			result.setBizResult(BizResultEnum.FAILURE);
			result.setMessage("订单不存在！");
			return result;
		}
		WOrderPayEntity orderPayEntity = orderPay.get(0);
		//微信订单号
		wechatMetaData.setOut_trade_no(wechatMetaData.getOut_trade_no());
		//随机字符串==随机字符串，不长于32位
		wechatMetaData.setNonce_str(WechatSdk.genRondomString());
		wechatMetaData.setBody(null);
		//签名==官方给的签名算法 sign后面加密签名算法应该加一个密钥Key
		wechatMetaData.setSign(WechatSdk.signByMD5(wechatMetaData,util.readProperty("wechat.merchant.secretkey")));
		try {
			String str = WechatSdk.toXml(wechatMetaData);
			result = WechatPayAdaptor.query(str);
		} catch (Exception e) {
			result.setBizResult(BizResultEnum.FAILURE);
			result.setMessage("订单不存在！");
			orderPayEntity.setReturnCode(BizResultEnum.FAILURE + "");
			orderPayEntity.setReturnMsg("订单不存在！");
			logger.error(ExceptionUtil.getExceptionMessage(e));
			return result;
		}
		if(BizResultEnum.SUCCESS.equals(result.getAckCheckedStatus())){
			orderPayEntity.setReturnCode("FINISH_OK");
			//订单支付成功之后，判断如果为设备购买，则更新设备购买表的购买状态
			//根据订单号查询
			List<WDevicePurchaseEntity> list = purchaseService.findByProperty(WDevicePurchaseEntity.class, "purchaseOrder", wechatMetaData.getOut_trade_no());
			if(list.size()>0){
				WDevicePurchaseEntity devicePurchaseEntity = list.get(0);
				devicePurchaseEntity.setPurchasePay(1);
				purchaseService.updateEntitie(devicePurchaseEntity);
			}
		}else{
			orderPayEntity.setReturnCode(result.getRetCode());
		}
		orderPayEntity.setReturnMsg(result.getRetMemo());
		orderPayEntity.setUpdateDate(new Date());
		payService.updateEntitie(orderPayEntity);
		return result;
	}
	
	
	/**
	 * 支付宝支付，流程同微信
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(params = "alipay")
	@ResponseBody
	public AliPayResult AliPay(HttpServletRequest request,HttpServletResponse response){
		AliPayResult result = new AliPayResult();
		AliPayMetaData aliPayMetaData = new AliPayMetaData();
		//以下需set的参数都为必填项
		//APPid
		aliPayMetaData.setApp_id("");
		//接口名称,最大长度为128,此处的是appLoginController.alipay
		aliPayMetaData.setMethod("");
		//请求使用的编码
		aliPayMetaData.setCharset("utf-8");
		//商户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2
		aliPayMetaData.setSign_type("");
		//请求的参数签名字符串
		aliPayMetaData.setSign("");
		//请求发送时间
		aliPayMetaData.setTimestamp(DateUtils.getDateDay());
		//调用的接口版本，固定为下面的参数
		aliPayMetaData.setVersion("1.0");
		//map为请求的参数集合，除去以上公共参数外，所有的请求参数需放在下面的集合中
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String,Object>();
		//商户订单号
		map.put("out_trade_no", UUID.randomUUID().toString());
		map.put("scene", "");//支付场景条码支付，取值：bar_code 声波支付，取值：wave_code
		map.put("auth_code", "");//支付授权码,不确定是客户提供还是支付宝返回
		map.put("subject", "");//订单标题如：设备名称+型号
		list.add(map);
		aliPayMetaData.setBiz_content(list);
		String string;
		try {
			string = WechatSdk.toXmlAliPay(aliPayMetaData);
			result = AliPayAdaptor.aliPay(string);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 微信支付
	 * @param request
	 * @param payFee
	 * @return
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws UnsupportedEncodingException 
	 */
	private WechatMetaData assembleWeChat(HttpServletRequest request ,String payFee) throws Exception{
		
		
		WechatMetaData wechatMetaData = new WechatMetaData();
		PropertiesUtil util = new PropertiesUtil("wechat.properties");
		String commodityMsg = oConvertUtils.getString(request.getParameter("commodity_message"));//商品信息
		wechatMetaData.setAppid(util.readProperty("wechat.app.id"));
		wechatMetaData.setMch_id(util.readProperty("wechat.receiver.merchant.id"));
		wechatMetaData.setNonce_str(WechatSdk.genRondomString());
		wechatMetaData.setBody(commodityMsg);
		wechatMetaData.setOut_trade_no(WechatSdk.genRondomString());
		BigDecimal big = new BigDecimal(payFee);
		wechatMetaData.setTotal_fee(big.multiply(new BigDecimal(100)).toBigInteger());
		wechatMetaData.setSpbill_create_ip(util.readProperty("wechat.server.ip"));
		wechatMetaData.setNotify_url(util.readProperty("wechat.callback.url"));
		wechatMetaData.setTrade_type(WechatConstants.TRADE_TYPE_APP);
		wechatMetaData.setSign(WechatSdk.signByMD5(wechatMetaData,util.readProperty("wechat.merchant.secretkey")));
		
		return wechatMetaData;
	}
	
	/**
	 * 更新支付宝支付的其他字段
	 * @param body
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "updateAlipayOrder")
	@ResponseBody
	public void updateAlipayOrder(String body,HttpServletRequest request, HttpServletResponse response){
		Map map = JSONHelper.json2Map(body);
//		String result = oConvertUtils.getString(map.get("result"));
//		result = "{resultStatus=9000, result={'alipay_trade_app_pay_response':{'code':'10000','msg':'Success','app_id':'2016080500171203','auth_app_id':'2016080500171203','charset':'UTF-8','timestamp':'2017-11-27 18:44:45','total_amount':'0.01','trade_no':'2017112721001004560200323131','seller_id':'2088102170026535','out_trade_no':'e2de81eda6454b5c93bc5d00b7ae9ac9'},'sign':'liULQZL6tNWvH6QsL5nq6253XzoX546BkV2UiQPJ2XLAAeVqkjDMM45ZwCN8wM7jhSwmNsxTNl8yc7tdElWKI27xmYnX37CLQLy63YbOqeXopiXYewXZnWo0Hdd9ZckpNlHmJ3xJh5bCgm27LeyVONCXbmcNsn2y1vxrLvnGy/H+zAuSuIrag+0vZ90gwYZE1R//odoCFUulgkCpS5OEJnDSl7l/MxMV5UjURGI83xtQK7duQlfHOTxNP/a1Ee0tK9QI5q+KtErdD8PM/1+45Omugif87RlP9glvJIKNt+H7oh3d0s2YOXjGPCq6LXngkj5ZEQcU1W5Ixyr6O0GvZQ==','sign_type':'RSA2'}, memo=处理成功}";
//		//解析Jason
//		JSONHelper.json2Map(result);
		String orderId = oConvertUtils.getString(map.get("out_trade_no"));
		String alipayId = oConvertUtils.getString(map.get("trade_no"));
		String sellerId = oConvertUtils.getString(map.get("seller_id"));
		String msg = oConvertUtils.getString(map.get("msg"));
		
		List<WOrderPayEntity> listOrder = payService.findByProperty(WOrderPayEntity.class, "out_trade_no", orderId);
		if(org.apache.commons.collections.CollectionUtils.isNotEmpty(listOrder)){
			WOrderPayEntity orderPayEntity = listOrder.get(0);
			orderPayEntity.setPrepayId(alipayId);
			orderPayEntity.setSellerId(sellerId);
			orderPayEntity.setReturnCode(msg);
			payService.updateEntitie(orderPayEntity);
		}
		
	}
	
	public static void main(String[] args) {
		String result = "{resultStatus=9000, result={'alipay_trade_app_pay_response':{'code':'10000','msg':'Success','app_id':'2016080500171203','auth_app_id':'2016080500171203','charset':'UTF-8','timestamp':'2017-11-27 18:44:45','total_amount':'0.01','trade_no':'2017112721001004560200323131','seller_id':'2088102170026535','out_trade_no':'e2de81eda6454b5c93bc5d00b7ae9ac9'},'sign':'liULQZL6tNWvH6QsL5nq6253XzoX546BkV2UiQPJ2XLAAeVqkjDMM45ZwCN8wM7jhSwmNsxTNl8yc7tdElWKI27xmYnX37CLQLy63YbOqeXopiXYewXZnWo0Hdd9ZckpNlHmJ3xJh5bCgm27LeyVONCXbmcNsn2y1vxrLvnGy/H+zAuSuIrag+0vZ90gwYZE1R//odoCFUulgkCpS5OEJnDSl7l/MxMV5UjURGI83xtQK7duQlfHOTxNP/a1Ee0tK9QI5q+KtErdD8PM/1+45Omugif87RlP9glvJIKNt+H7oh3d0s2YOXjGPCq6LXngkj5ZEQcU1W5Ixyr6O0GvZQ==','sign_type':'RSA2'}, memo=处理成功}";
		//解析Jason
		Map<String,Object> map = JSONHelper.json2Map(result);
		System.out.println(map.get("seller_id"));
		System.out.println();
	}
	

}
