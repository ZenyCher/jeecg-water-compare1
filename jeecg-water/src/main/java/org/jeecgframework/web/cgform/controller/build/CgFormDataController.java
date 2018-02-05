package org.jeecgframework.web.cgform.controller.build;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javassist.expr.NewArray;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.JSONHelper;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.web.cgform.entity.config.CgFormHeadEntity;
import org.jeecgframework.web.cgform.service.autolist.CgTableServiceI;
import org.jeecgframework.web.cgform.service.build.DataBaseService;
import org.jeecgframework.web.cgform.service.config.CgFormFieldServiceI;
import org.jeecgframework.web.cgform.service.upload.CgUploadServiceI;
import org.jeecgframework.web.cgform.util.TableJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeecg.api.sdk.WechatSdk;
import com.jeecg.api.service.socket.DataUtils;
import com.jeecg.api.service.socket.SocketSendBiz;
import com.jeecg.api.util.SpringContextUtils;
import com.jeecg.orderpay.service.WOrderPayServiceI;
import com.jeecg.waterdispenser.entity.WAddressEntity;
import com.jeecg.waterdispenser.entity.WDeviceEntity;
import com.jeecg.waterdispenser.entity.WDeviceTypeEntity;
import com.jeecg.waterdispenser.entity.WFilterEntity;
import com.jeecg.waterdispenser.entity.WGiftEntity;
import com.jeecg.waterdispenser.entity.WGiftExchangeEntity;
import com.jeecg.waterdispenser.entity.WInstallEntity;
import com.jeecg.waterdispenser.entity.WIntegralEntity;
import com.jeecg.waterdispenser.entity.WMallEntity;
import com.jeecg.waterdispenser.entity.WPackageEntity;
import com.jeecg.waterdispenser.entity.WRechargeEntity;
import com.jeecg.waterdispenser.entity.WRechargeStatisticsEntity;
import com.jeecg.waterdispenser.entity.WUserMemberEntity;
import com.jeecg.waterdispenser.entity.WUserRegisterEntity;
import com.jeecg.waterdispenser.entity.WWaterMeterEntity;
import com.jeecg.waterdispenser.entity.WWaterOpenEntity;
import com.jeecg.waterdispenser.entity.resultDevice;
import com.jeecg.waterdispenser.entity.resultGift;
import com.jeecg.waterdispenser.resultEntity.UserDeviceResult;
import com.jeecg.waterdispenser.service.WAddressServiceI;
import com.jeecg.waterdispenser.service.WDevicePurchaseServiceI;
import com.jeecg.waterdispenser.service.WDeviceServiceI;
import com.jeecg.waterdispenser.service.WDeviceTypeServiceI;
import com.jeecg.waterdispenser.service.WDeviceWaterServiceI;
import com.jeecg.waterdispenser.service.WFilterServiceI;
import com.jeecg.waterdispenser.service.WGiftExchangeServiceI;
import com.jeecg.waterdispenser.service.WGiftServiceI;
import com.jeecg.waterdispenser.service.WInstallServiceI;
import com.jeecg.waterdispenser.service.WIntegralServiceI;
import com.jeecg.waterdispenser.service.WMaintainServiceI;
import com.jeecg.waterdispenser.service.WMallServiceI;
import com.jeecg.waterdispenser.service.WOrderServiceI;
import com.jeecg.waterdispenser.service.WPackageServiceI;
import com.jeecg.waterdispenser.service.WRechargeServiceI;
import com.jeecg.waterdispenser.service.WRechargeStatisticsServiceI;
import com.jeecg.waterdispenser.service.WUserDeviceServiceI;
import com.jeecg.waterdispenser.service.WUserMemberServiceI;
import com.jeecg.waterdispenser.service.WUserRegisterServiceI;
import com.jeecg.waterdispenser.service.WWaterHeartRecordServiceI;
import com.jeecg.waterdispenser.service.WWaterMeterServiceI;
import com.jeecg.waterdispenser.service.WWaterOpenServiceI;
import com.jeecg.waterdispenser.service.WWaterStatisticsServiceI;
import com.jeecg.waterdispenser.service.WechatServiceI;
import com.jeecg.waterdispenser.util.SecurityUtil;
import com.jeecg.waterdispenser.util.waterUtil;

@Controller
@RequestMapping("/api/cgFormDataController")

public class CgFormDataController {
	
	private static final Logger logger = Logger.getLogger(CgFormDataController.class);
	
	@Autowired
	private WUserRegisterServiceI wuserRegisterService;
	
	@Autowired
	private DataBaseService dataBaseService;
	@Autowired
	private CgTableServiceI cgTableService;
	@Autowired
	private CgFormFieldServiceI cgFormFieldService;
	@Autowired
	private WRechargeStatisticsServiceI wRechargeStatisticsService;
	@Autowired
	private WOrderServiceI wOrderServiceI;
	@Autowired
	private WGiftExchangeServiceI wGiftExchangeServiceI;
	@Autowired
	private WDevicePurchaseServiceI wDevicePurchaseServiceI;
	@Autowired
	private WPackageServiceI wPackageServiceI;
	@Autowired
	private WUserRegisterServiceI wUserRegisterServiceI;
	@Autowired
	private WUserDeviceServiceI wUserDeviceServiceI;
	@Autowired
	private WDeviceServiceI wDeviceServiceI;
	@Autowired
	private WInstallServiceI wInstallServiceI;
	@Autowired
	private WFilterServiceI wFilterServiceI;
	@Autowired
	private WWaterStatisticsServiceI wWaterStatisticsServiceI;
	@Autowired
	private WDeviceWaterServiceI wDeviceWaterServiceI; 
	@Autowired
	private CgUploadServiceI cgUploadService;
	@Autowired
	private WUserMemberServiceI wUserMemberServiceI;
	@Autowired
	private WDeviceTypeServiceI wDeviceTypeServiceI;
	@Autowired
	private WWaterMeterServiceI wWaterMeterServiceI; 
	@Autowired
	private WMaintainServiceI wMaintainServiceI;
	@Autowired
	private WRechargeServiceI wRechargeServiceI;
	@Autowired
	private WIntegralServiceI wIntegralServiceI;
	@Autowired
	private WGiftServiceI wGiftServiceI;
	@Autowired
	private WAddressServiceI wAddressServiceI;
	@Autowired
	private WechatServiceI wechatServiceI;
	@Autowired
	private WOrderPayServiceI wOrderPayServiceI;
	@Autowired
	private WMallServiceI mallService;
	@Autowired
	private WWaterHeartRecordServiceI wWaterHeartRecordServiceI;
	
	/**
	 * 签名密钥key
	 */
	@SuppressWarnings("unused")
	private static final String SIGN_KEY = "26F72780372E84B6CFAED6F7B19139CC47B1912B6CAED753";
	
	/**
	 * 根据水表id查询水表图表
	 * @param body
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(params = "getWaterImage")
	@ResponseBody
	@SuppressWarnings({ "rawtypes" })
	public TableJson getWaterImage(String body,HttpServletRequest request,HttpServletResponse response){
		Map map = JSONHelper.json2Map(body);
		TableJson j = new TableJson();
		//验证token，如果该token已存在，则放行，如不存在则通知前段调用发送手机验证码接口重新登录
		if( !SecurityUtil.saveVerificationToken(oConvertUtils.getString(map.get("member_phone")),oConvertUtils.getString(map.get("token"))) ){
			j.setTokenValid(false);
			j.setSuccess(false);
			return j;
		}
		j.setMsg("操作失败.请联系管理员!");
		Map<String, Object> connectMap = new HashMap<String, Object>();
		String waterId = oConvertUtils.getString(map.get("waterId"));
		Long is_time = Long.valueOf(180000);
		if( oConvertUtils.isNotEmpty(waterId) ){
			try {
				List<Map<String, Object>> wWaterHeartRecord = wWaterHeartRecordServiceI.getWWaterHeartByWaterId(waterId);
				if( !wWaterHeartRecord.isEmpty() && wWaterHeartRecord.size() > 0 ){
					for (int i = 0; i < wWaterHeartRecord.size(); i++) {
						if( oConvertUtils.isNotEmpty(wWaterHeartRecord.get(i).get("updateTime")) ){
							String updateTime = DateUtils.dateformat(oConvertUtils.getString(wWaterHeartRecord.get(i).get("updateTime")), "yyyy-MM-dd HH:mm:ss");
							Date date = DateUtils.parseDate(updateTime,"yyyy-MM-dd HH:mm:ss");
							Long serverTime = System.currentTimeMillis() - date.getTime();
							//大于三分钟返回true，小于返回false(判定水表连接)
							if( serverTime > is_time ){
								connectMap.put("connect_state", "true");
								j.setMsg("操作成功!");
							}
						}
					}
					j.setTableData(connectMap);
				}else{
					j.setMsg("该水表无记录!");
					j.setSuccess(false);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			j.setMsg("水表id为空!");
			j.setSuccess(false);
		}
		return j;
	}
	
	/**
	 * 开关阀水表指令
	 * @param body
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(params = "saveOperationWater")
	@ResponseBody
	public TableJson saveOperationWater(String body, HttpServletRequest request, HttpServletResponse response){
		Map map = JSONHelper.json2Map(body);
		TableJson j = new TableJson();
		//验证token，如果该token已存在，则放行，如不存在则通知前段调用发送手机验证码接口重新登录
		if( !SecurityUtil.saveVerificationToken(oConvertUtils.getString(map.get("member_phone")),oConvertUtils.getString(map.get("token"))) ){
			j.setTokenValid(false);
			j.setSuccess(false);
			return j;
		}
		j.setMsg("水表操作成功!");
		String waterId = oConvertUtils.getString(map.get("waterId"));
		String type = oConvertUtils.getString(map.get("type"));
		boolean flag = true;
		Long startTime = new Date().getTime();
		boolean fals;
		try {
			Socket socket = SecurityUtil.getSocketValue(DataUtils.reverseStr(waterId));
			fals = wechatServiceI.operationWater(waterId, type);
			if(socket.isConnected()) {
				WWaterMeterEntity wWaterMeterEntity = wWaterMeterServiceI.findUniqueByProperty(WWaterMeterEntity.class, "waterId", waterId);
				if( wWaterMeterEntity != null ){
					wWaterMeterEntity.setWaterState(Integer.valueOf(type));
					wWaterMeterServiceI.saveOrUpdate(wWaterMeterEntity);
				}
				checkOpenOrClose(waterId);
				j.setSuccess(fals);
			}else {
				while(flag) {
					if(startTime - (new Date().getTime()) < 35) {
						if(socket.isConnected()) {
							flag = false;
						}
						Thread.sleep(1000);
					}else {
						j.setMsg("后台正在尝试连接水表，请稍后再试");
						j.setSuccess(false);
						return j;
					}
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("水表操作失败，请稍后再试!");
		}
		return j;
	}
	
	/**
	 * 验证设备和滤芯的防伪码
	 * @param body
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(params = "verification")
	@ResponseBody
	public TableJson verification(String body, HttpServletRequest request, HttpServletResponse response){
		Map map = JSONHelper.json2Map(body);
		TableJson j = new TableJson();
		//验证token，如果该token已存在，则放行，如不存在则通知前段调用发送手机验证码接口重新登录
		if( !SecurityUtil.saveVerificationToken(oConvertUtils.getString(map.get("member_phone")),oConvertUtils.getString(map.get("token"))) ){
			j.setTokenValid(false);
			j.setSuccess(false);
			return j;
		}
		String type = oConvertUtils.getString(map.get("type"));
		String code = oConvertUtils.getString(map.get("code"));
		j.setMsg("验证码匹配成功!");
		//0为设备验证
		if ( "0".equals(type) ) {
			String deviceId = oConvertUtils.getString(map.get("deviceId"));
			WDeviceEntity wDeviceEntity = wDeviceServiceI.findUniqueByProperty(WDeviceEntity.class, "deviceId", deviceId);
			if( wDeviceEntity == null ){
				j.setMsg("该设备不存在！");
				j.setSuccess(false);
				return j;
			}
			if( !code.equals(wDeviceEntity.getDeviceCode()) ){
				j.setMsg("该设备验证码不匹配!");
				j.setSuccess(false);
				return j;
			}
		}
		//1为滤芯验证
		if( "1".equals(type) ){
			String filterId = oConvertUtils.getString(map.get("filterId"));
			WFilterEntity wfilter = wFilterServiceI.findUniqueByProperty(WFilterEntity.class, "filterId", filterId);
			if( wfilter == null ){
				j.setMsg("该滤芯不存在!");
				j.setSuccess(false);
				return j;
			}
			if( !code.equals(wfilter.getFilterCode()) ){
				j.setMsg("该滤芯验证码不匹配!");
				j.setSuccess(false);
				return j;
			}
		}
		return j;
	}
	
	
	/**
	 * 查看用户积分
	 * @param body 入参参数
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(params = "saveUserIntegral")
	@ResponseBody
	public TableJson saveUserIntegral(String body, HttpServletRequest request, HttpServletResponse response){
		Map map = JSONHelper.json2Map(body);
		TableJson j = new TableJson();
		//验证token，如果该token已存在，则放行，如不存在则通知前段调用发送手机验证码接口重新登录
		if( !SecurityUtil.saveVerificationToken(oConvertUtils.getString(map.get("member_phone")),oConvertUtils.getString(map.get("token"))) ){
			j.setTokenValid(false);
			j.setSuccess(false);
			return j;
		}
		String memberPhone = oConvertUtils.getString(map.get("member_phone"));
		Integer sumIntegral = new Integer(0);//所有入账收入
		Integer outInteger = new Integer(0);//所有出账记录
		Integer surplusNum = new Integer(0);//剩余积分
		try {
			//根据联系方式得到改会员有多少入账积分
			List<WIntegralEntity> wIntegral = wIntegralServiceI.listWIntegralByMemberPhoneSum(memberPhone);
			for (int i = 0; i < wIntegral.size(); i++) {
				String str = oConvertUtils.getString(wIntegral.get(i).getIntegralNumber());
				int thisNum = Integer.valueOf(str);
				sumIntegral = sumIntegral + thisNum;
			}
			//根据联系方式得到改会员有出账积分
			List<WIntegralEntity> wIntegralOut = wIntegralServiceI.listWIntegralByMemberPhoneOut(memberPhone);
			for (int i = 0; i < wIntegralOut.size(); i++) {
				String str = oConvertUtils.getString(wIntegralOut.get(i).getIntegralNumber());
				int thisNum = Integer.valueOf(str);
				outInteger = outInteger + thisNum;
			}
			surplusNum = sumIntegral - outInteger;
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> userMap = new HashMap<String, Object>();
		if( surplusNum > 0 || surplusNum == 0){
			userMap.put("user_integral", surplusNum);
			j.setTableData(userMap);
		}else{
			j.setMsg("该用户暂无积分！");
			j.setSuccess(false);
		}
		return j;
	}
	
	/**
	 * 积分兑换
	 * @param body 入参参数
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(params = "exchange")
	@ResponseBody
	public TableJson exchange(String body, HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map map = JSONHelper.json2Map(body);
		TableJson j = new TableJson();
		//验证token，如果该token已存在，则放行，如不存在则通知前段调用发送手机验证码接口重新登录
		if( !SecurityUtil.saveVerificationToken(oConvertUtils.getString(map.get("member_phone")),oConvertUtils.getString(map.get("token"))) ){
			j.setTokenValid(false);
			j.setSuccess(false);
			return j;
		}
		String memberPhone = oConvertUtils.getString(map.get("member_phone"));//会员联系方式
		String giftId = oConvertUtils.getString(map.get("gift_id"));//礼品Id
		String giftNum = oConvertUtils.getString(map.get("gift_num"));//礼品数量
		String addressId = oConvertUtils.getString(map.get("address_id"));//地址id
		Integer sumIntegral = new Integer(0);//所有入账收入
		Integer outInteger = new Integer(0);//所有出账记录
		Integer surplusNum = new Integer(0);//剩余积分
		try {
			//根据联系方式得到改会员有多少入账积分
			List<WIntegralEntity> wIntegral = wIntegralServiceI.listWIntegralByMemberPhoneSum(memberPhone);
			for (int i = 0; i < wIntegral.size(); i++) {
				String str = oConvertUtils.getString(wIntegral.get(i).getIntegralNumber());
				int thisNum = Integer.valueOf(str);
				sumIntegral = sumIntegral + thisNum;
			}
			//根据联系方式得到改会员有出账积分
			List<WIntegralEntity> wIntegralOut = wIntegralServiceI.listWIntegralByMemberPhoneOut(memberPhone);
			for (int i = 0; i < wIntegralOut.size(); i++) {
				String str = oConvertUtils.getString(wIntegralOut.get(i).getIntegralNumber());
				int thisNum = Integer.valueOf(str);
				outInteger = outInteger + thisNum;
			}
			surplusNum = sumIntegral - outInteger;
		} catch (Exception e) {
			e.printStackTrace();
		}
		//查找该礼品
		WGiftEntity wGift = wGiftServiceI.findUniqueByProperty(WGiftEntity.class, "id", giftId);
		//判断礼品剩余数量是否足够支持此次支付
		Integer wGiftNum = Integer.valueOf(oConvertUtils.getString(wGift.getGiftSurplus()));
		if( wGiftNum <  Integer.valueOf(giftNum) ){
			j.setMsg("礼品剩余数量不足,无法兑换！");
			j.setSuccess(false);
			return j;
		}
		Integer giftChange = Integer.valueOf(oConvertUtils.getString(wGift.getGiftChange()));//得到礼品兑换积分
		//剩以礼品数量得到需要多少积分
		Integer sumGiftChange = giftChange*Integer.valueOf(giftNum);
		if ( surplusNum > sumGiftChange || surplusNum == sumGiftChange) {
//			Integer thisIntegral = sumIntegral - sumGiftChange;
			WAddressEntity wAddress = wAddressServiceI.findUniqueByProperty(WAddressEntity.class, "id", addressId);
			//兑换成功之后将改礼品数量减去兑换数量
			Integer wGiftNumber = Integer.valueOf(oConvertUtils.getString(wGift.getGiftSum()));
			Integer giftNumOut = wGiftNumber - Integer.valueOf(giftNum);
			wGift.setGiftSurplus(String.valueOf(giftNumOut));;
			wGiftServiceI.updateEntitie(wGift);
			//兑换成功之后用户积分表增加出账记录
			WIntegralEntity wIntegral = new WIntegralEntity();
			wIntegral.setMemberPhone(memberPhone);
			wIntegral.setIntegralSource("积分兑换礼品");
			wIntegral.setIntegralNumber(String.valueOf(sumGiftChange));
			wIntegral.setIntegralType(1);
			wInstallServiceI.save(wIntegral);
			//兑换成功之后生成礼品兑换表
			WGiftExchangeEntity wGiftExchange = new WGiftExchangeEntity();
			wGiftExchange.setGiftexchangeOrder(WechatSdk.genRondomString());
			wGiftExchange.setGiftexchangeState("0");
			wGiftExchange.setGiftId(giftId);
			wGiftExchange.setGiftName(wGift.getGiftName());
			wGiftExchange.setGiftexchangeNumber(giftNum);
			wGiftExchange.setGiftexchangeTime(DateUtils.getDate());
			wGiftExchange.setGiftexchangeConsignee(wAddress.getAddressName());
			wGiftExchange.setGiftexchangePhone(memberPhone);
			wGiftExchange.setGiftexchangeAddress(wAddress.getAddressRegion() + wAddress.getAddressStreet());
			wGiftExchange.setGiftexchangeIntegral(String.valueOf(sumGiftChange));
			wGiftExchangeServiceI.save(wGiftExchange);
			j.setMsg("兑换成功!");
		}else {
			j.setMsg("积分不足!");
			j.setSuccess(false);
		}
		return j;
	}
	
	/**
	 * 计算用户套餐规则
	 * @param body
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(params = "rusultPackageNum")
	@ResponseBody
	public TableJson rusultPackageNum(String body, HttpServletRequest request, HttpServletResponse response){
//	public TableJson rusultPackageNum( HttpServletRequest request, HttpServletResponse response){
//		String body = "{'member_phone':'18502076509','package_money':'445'}";
		Map map = JSONHelper.json2Map(body);
		TableJson j = new TableJson();
		//验证token，如果该token已存在，则放行，如不存在则通知前段调用发送手机验证码接口重新登录
		if( !SecurityUtil.saveVerificationToken(oConvertUtils.getString(map.get("member_phone")),oConvertUtils.getString(map.get("token"))) ){
			j.setTokenValid(false);
			j.setSuccess(false);
			j.setMsg("token验证错误!");
			return j;
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String packageMoney = oConvertUtils.getString(map.get("package_money"));
		String deviceId = oConvertUtils.getString(map.get("device_id"));
		BigDecimal bigDecimal = new BigDecimal(packageMoney);//充值金额
		//查看该用户是否为首冲(查询充值记录表)
		List<WRechargeEntity> wRecharge = wRechargeServiceI.findByProperty(WRechargeEntity.class, "waterId", deviceId);
		WUserMemberEntity wUserMember = wUserMemberServiceI.findUniqueByProperty(WUserMemberEntity.class, "deviceId", deviceId);
		if( wUserMember != null ){
			//如果充值记录不为空则代表是正常套餐，如果是为空则为首冲套餐
			WPackageEntity wPackage = new WPackageEntity();
			if( wRecharge != null && !wRecharge.isEmpty() ){
				wPackage = wPackageServiceI.findUniqueByProperty(WPackageEntity.class, "id", oConvertUtils.getString(wUserMember.getMemberNormalPackageId()));
				if( wPackage == null ){
					j.setMsg("该套餐不存在，请联系管理员!");
					j.setSuccess(false);
					return j;
				}
				resultMap = waterUtil.resultDonatedWaterPackage(wPackage, bigDecimal);
			}else {
				wPackage = wPackageServiceI.findUniqueByProperty(WPackageEntity.class, "id", oConvertUtils.getString(wUserMember.getMemberPackageId()));
				if( wPackage == null ){
					j.setMsg("该套餐不存在，请联系管理员!");
					j.setSuccess(false);
					return j;
				}
				resultMap = waterUtil.resultDonatedWaterPackage(wPackage, bigDecimal);
			}
		}else {
			j.setMsg("该用户不存在！");
			j.setSuccess(false);
			return j;
		}
		j.setTableData(resultMap);
		return j;
	}
	
	/**
	 * 验证登陆之后进入首页获取参数
	 * @param body
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(params = "loginInfo")
	@ResponseBody
//	public TableJson loginInfo(String body, HttpServletRequest request, HttpServletResponse response) throws Exception {
	public TableJson loginInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String body = "{'member_phone':'13751772066'}";
		Map map = JSONHelper.json2Map(body);
		TableJson j = new TableJson();
		//验证token，如果该token已存在，则放行，如不存在则通知前段调用发送手机验证码接口重新登录
//		if( !SecurityUtil.saveVerificationToken(oConvertUtils.getString(map.get("member_phone")),oConvertUtils.getString(map.get("token"))) ){
//			j.setTokenValid(false);
//			j.setSuccess(false);
//			j.setMsg("token验证错误!");
//			return j;
//		}
		String phone = oConvertUtils.getString(map.get("member_phone"));
		//根据登录的联系方式查找该注册用户的会员信息
		Map<String, Object> userMap = wUserRegisterServiceI.selectUserRegisterByRegisterPhone(phone);
		List<Map<String, Object>> deviceTypeList = new ArrayList<Map<String,Object>>();//返回用户设备类型表
		List<Map<String, Object>> wWaterMeterEntities = new ArrayList<Map<String,Object>>();//返回水表
		List<Map<String, Object>> maintainList = new ArrayList<Map<String,Object>>();//会员维护表信息
		List<Map<String, Object>> userDeviceList = new ArrayList<Map<String,Object>>();//获取用户的设备
		List<Map<String, Object>> wUserDeviceEntities = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> installMap = new ArrayList<Map<String,Object>>();
		List<UserDeviceResult> userDeviceResults = new ArrayList<UserDeviceResult>();//result实体
		List<Map<String, Object>> wPackageEntities = new ArrayList<Map<String,Object>>();//返回该用户套餐类型
		if(userMap != null){
			String userType = oConvertUtils.getString(userMap.get("register_type"));
			//返回该用户的安装信息
			if( "2".equals(userType) ){
				installMap = wInstallServiceI.getInstallNameByRegisterId(oConvertUtils.getString(userMap.get("id")));
				maintainList = wMaintainServiceI.getMaintainByRegisterId(oConvertUtils.getString(userMap.get("id")));
				j.setMaintainTable(maintainList);
				j.setInstallTable(installMap);
				return j;
			}
			String memberPhone = oConvertUtils.getString(userMap.get("member_phone"));
			//查找会员用户
			List<Map<String, Object>> wUserMember = wUserMemberServiceI.getUserMenberByPhone(memberPhone);
			List<Object> userMember = new ArrayList<Object>();
			for (Map<String, Object> wUserMemberEntity : wUserMember) {
				if( wUserMemberEntity != null ){
					userMember.add(wUserMemberEntity);
				}
				List<String> list = new ArrayList<String>();
				list.add(oConvertUtils.getString(wUserMemberEntity.get("member_package_id")));
				list.add(oConvertUtils.getString(wUserMemberEntity.get("member_normal_package_id")));
				for (int i = 0; i < list.size(); i++) {
					Map<String, Object> wPackage = wPackageServiceI.getPackageById(oConvertUtils.getString(list.get(i)));
					if( wPackage != null ){
						wPackageEntities.add(wPackage);
					}
				}
				//根据当前用户id查询当前用户的所有亲属
				List<Map<String, Object>> wUserRegister = wuserRegisterService.getRegisterBymemberId(oConvertUtils.getString(wUserMemberEntity.get("id")));
				if( !wUserRegister.isEmpty() ){
					j.setUserRegister(wUserRegister);
					for (Map<String, Object> wUserRegisterEntity : wUserRegister) {
						//返回该亲属用户的设备中间表
						Map<String, Object> wUserDeviceEntity = wUserDeviceServiceI.saveUserDeviceByMemberId(oConvertUtils.getString(wUserRegisterEntity.get("id")));
						if( wUserDeviceEntity != null ){
							UserDeviceResult userDeviceResult = new UserDeviceResult();
							userDeviceResult.setMember_name(oConvertUtils.getString(userMap.get("member_name")));
							userDeviceResult.setMember_phone(oConvertUtils.getString(userMap.get("member_phone")));
							userDeviceResult.setOne_filter_name(Integer.valueOf(oConvertUtils.getString(wUserDeviceEntity.get("one_filter_name") == "0" ? 0 : wUserDeviceEntity.get("one_filter_name"))));
							userDeviceResult.setTwo_filter_name(Integer.valueOf(oConvertUtils.getString(wUserDeviceEntity.get("two_filter_name") == "0" ? 0 : wUserDeviceEntity.get("two_filter_name"))));
							userDeviceResult.setThree_filter_name(Integer.valueOf(oConvertUtils.getString(wUserDeviceEntity.get("three_filter_name") == "0" ? 0 : wUserDeviceEntity.get("three_filter_name"))));
							userDeviceResult.setFour_filter_name(Integer.valueOf(oConvertUtils.getString(wUserDeviceEntity.get("four_filter_name") == "0" ? 0 : wUserDeviceEntity.get("four_filter_name"))));
							userDeviceResult.setFive_filter_name(Integer.valueOf(oConvertUtils.getString(wUserDeviceEntity.get("five_filter_name") == "0" ? 0 : wUserDeviceEntity.get("five_filter_name"))));
							userDeviceResult.setSix_filter_name(Integer.valueOf(oConvertUtils.getString(wUserDeviceEntity.get("six_filter_name") == "0" ? 0 : wUserDeviceEntity.get("six_filter_name"))));
							//返回水表
							Map<String, Object> wWater = wWaterMeterServiceI.getWaterMeterByWaterId(oConvertUtils.getString(wUserDeviceEntity.get("waterMeter_id")));
							if( wWater != null ){
								userDeviceResult.setWater_id(oConvertUtils.getString(wWater.get("water_id")));
								userDeviceResult.setWater_current(Integer.valueOf(oConvertUtils.getString(wWater.get("water_current") == null ? 0 : wWater.get("water_current"))));
								userDeviceResult.setWater_surplus(Integer.valueOf(oConvertUtils.getString(wWater.get("water_surplus"))));
								userDeviceResult.setWater_value(Integer.valueOf(oConvertUtils.getString(wWater.get("water_value"))));
								wWaterMeterEntities.add(wWater);
							}
							wUserDeviceEntities.add(wUserDeviceEntity);
							userDeviceResults.add(userDeviceResult);
						}
					}
				}
				//返回该用户设备中间表
				Map<String, Object> wUserDeviceEntity = wUserDeviceServiceI.saveUserDeviceByMemberId(oConvertUtils.getString(wUserMemberEntity.get("id")));
				if( wUserDeviceEntity != null ){
					UserDeviceResult userDeviceResult = new UserDeviceResult();
					userDeviceResult.setMember_name(oConvertUtils.getString(userMap.get("member_name")));
					userDeviceResult.setMember_phone(oConvertUtils.getString(userMap.get("member_phone")));
					userDeviceResult.setOne_filter_name(Integer.valueOf(oConvertUtils.getString(wUserDeviceEntity.get("one_filter_name") == "0" ? 0 : wUserDeviceEntity.get("one_filter_name"))));
					userDeviceResult.setTwo_filter_name(Integer.valueOf(oConvertUtils.getString(wUserDeviceEntity.get("two_filter_name") == "0" ? 0 : wUserDeviceEntity.get("two_filter_name"))));
					userDeviceResult.setThree_filter_name(Integer.valueOf(oConvertUtils.getString(wUserDeviceEntity.get("three_filter_name") == "0" ? 0 : wUserDeviceEntity.get("three_filter_name"))));
					userDeviceResult.setFour_filter_name(Integer.valueOf(oConvertUtils.getString(wUserDeviceEntity.get("four_filter_name") == "0" ? 0 : wUserDeviceEntity.get("four_filter_name"))));
					userDeviceResult.setFive_filter_name(Integer.valueOf(oConvertUtils.getString(wUserDeviceEntity.get("five_filter_name") == "0" ? 0 : wUserDeviceEntity.get("five_filter_name"))));
					userDeviceResult.setSix_filter_name(Integer.valueOf(oConvertUtils.getString(wUserDeviceEntity.get("six_filter_name") == "0" ? 0 : wUserDeviceEntity.get("six_filter_name"))));
					//返回水表
					Map<String, Object> wWater = wWaterMeterServiceI.getWaterMeterByWaterId(oConvertUtils.getString(wUserDeviceEntity.get("waterMeter_id")));
					if( wWater != null ){
						userDeviceResult.setWater_id(oConvertUtils.getString(wWater.get("water_id")));
						userDeviceResult.setWater_current(Integer.valueOf(oConvertUtils.getString(wWater.get("water_current") == null ? 0 : wWater.get("water_current"))));
						userDeviceResult.setWater_surplus(Integer.valueOf(oConvertUtils.getString(wWater.get("water_surplus"))));
						userDeviceResult.setWater_value(Integer.valueOf(oConvertUtils.getString(wWater.get("water_value"))));
						wWaterMeterEntities.add(wWater);
					}
					//返回该用户的设备
					Map<String, Object> wDeviceEntity = wDeviceServiceI.selectDeviceByDeviceId(oConvertUtils.getString(wUserDeviceEntity.get("device_id")));
					if( wDeviceEntity != null ){
						userDeviceResult.setDevice_id(oConvertUtils.getString(wDeviceEntity.get("device_id")));
						userDeviceList.add(wDeviceEntity);
					}
					//返回该用户的安装信息
					if( "2".equals(userType) ){
						installMap = wInstallServiceI.getInstallNameByRegisterId(oConvertUtils.getString(userMap.get("id")));
					}else {
						installMap = wInstallServiceI.getInstallByMemberId(oConvertUtils.getString(wUserMemberEntity.get("id")));
					}
					if( installMap != null ){
						for (Map<String, Object> map2 : installMap) {
							userDeviceResult.setInstall_address(oConvertUtils.getString(map2.get("install_address")));
						}
						j.setInstallTable(installMap);
					}
					//返回该用户的维护信息
					maintainList = wMaintainServiceI.getMaintainByDeviceAndMemberPhone(oConvertUtils.getString(wUserDeviceEntity.get("device_id")), memberPhone);
					if( !maintainList.isEmpty() ){
						j.setMaintainTable(maintainList);//维护表
					}
					wUserDeviceEntities.add(wUserDeviceEntity);
					userDeviceResults.add(userDeviceResult);
				}
			}
			j.setPackageTable(wPackageEntities);
			j.setUserMember(userMember);
			j.setUserDeviceTable(wUserDeviceEntities);//用户设备水表信息关联表
			j.setDeviceTypeTable(deviceTypeList);//设备类型表
			j.setWaterMeterTable(wWaterMeterEntities);//水表
			j.setDeviceTable(userDeviceList);//用户设备关联表
			j.setTableData(userDeviceResults);//返回实体信息
		}else{
			j.setMsg("该用户不存在或没激活!");
			j.setSuccess(false);
		}
		return j;
	}
	
	/**
	 * online表单对外接口：getUserAndOrder根据用户信息获取该用户的订单信息及设备购买情况
	 * @param body
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(params = "getUserAndOrder")
	@ResponseBody
	public TableJson getUserAndOrder(String body, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map map = JSONHelper.json2Map(body);
		TableJson j = new TableJson();
		//验证token，如果该token已存在，则放行，如不存在则通知前段调用发送手机验证码接口重新登录
		if(!SecurityUtil.saveVerificationToken(oConvertUtils.getString(map.get("member_phone")),oConvertUtils.getString(map.get("token")))){
			j.setTokenValid(false);
			j.setSuccess(false);
			return j;
		}
		if(oConvertUtils.isEmpty(map.get("type"))) {
			j.setMsg("查询参数不能为空!");
			j.setSuccess(false);
			return j;
		}
		String memberPhone = oConvertUtils.getString(map.get("member_phone"));
		//如果为0则是设备购买，如果为1则是礼品兑换
		if( "0".equals(oConvertUtils.getString(map.get("type"))) ) {
			List<resultDevice> listResultDevices = new ArrayList<resultDevice>();
			List<Map<String, Object>> devicePu = wDevicePurchaseServiceI.resultTableFieldAndValue("purchase_phone", memberPhone);
			if( devicePu != null && !devicePu.isEmpty() ){
				for (int i = 0; i < devicePu.size(); i++) {
					String deviceId = oConvertUtils.getString(devicePu.get(i).get("device_id"));
					System.out.println(deviceId);
					if( oConvertUtils.isNotEmpty(deviceId) ){
						WDeviceTypeEntity wdeviceType = wDeviceTypeServiceI.findUniqueByProperty(WDeviceTypeEntity.class, "id", deviceId);
						WMallEntity wMall = mallService.findUniqueByProperty(WMallEntity.class, "mallDeviceTypeId", deviceId);
						if( wdeviceType != null ){
							resultDevice reDevice = new resultDevice();
							
							String orderId = oConvertUtils.getString(devicePu.get(i).get("purchase_order"));
							Map<String, Object> woreEntity = wOrderPayServiceI.findEntityByOutTradeNo(orderId);
							if( woreEntity != null ){
								reDevice.setAddress(oConvertUtils.getString(woreEntity.get("address")));
								reDevice.setReceiver(oConvertUtils.getString(woreEntity.get("receiver")));
								reDevice.setReceiverMobile(oConvertUtils.getString(woreEntity.get("receiverMobile")));
								reDevice.setPurchase_time(oConvertUtils.getString(woreEntity.get("order_date")));
							}
							reDevice.setDevice_type(wdeviceType.getDeviceType());
							reDevice.setDevice_name(wdeviceType.getDeviceName());
							reDevice.setDevice_filter_num(wdeviceType.getDeviceFilterNum());
							reDevice.setPurchase_order(oConvertUtils.getString(devicePu.get(i).get("purchase_order")));
							reDevice.setDevice_type_id(oConvertUtils.getString(devicePu.get(i).get("device_id")));
							reDevice.setPurchase_state(oConvertUtils.getString(devicePu.get(i).get("purchase_state")));
							reDevice.setPurchase_handle(oConvertUtils.getString(devicePu.get(i).get("purchase_handle")));
							reDevice.setPurchase_number(oConvertUtils.getString(devicePu.get(i).get("purchase_number")));
							reDevice.setPurchase_time(oConvertUtils.getString(devicePu.get(i).get("purchase_time")));
							reDevice.setPurchase_people(oConvertUtils.getString(devicePu.get(i).get("purchase_people")));
							reDevice.setPurchase_phone(oConvertUtils.getString(devicePu.get(i).get("purchase_phone")));
							reDevice.setPurchase_express(oConvertUtils.getString(devicePu.get(i).get("purchase_express")));
							reDevice.setPurchase_couriernumber(oConvertUtils.getString(devicePu.get(i).get("purchase_couriernumber")));
							reDevice.setPurchase_operator(oConvertUtils.getString(devicePu.get(i).get("purchase_operator")));
							reDevice.setPurchase_cost(oConvertUtils.getString(devicePu.get(i).get("purchase_cost")));
							reDevice.setPurchase_mailtime(oConvertUtils.getString(devicePu.get(i).get("purchase_mailtime")));
							reDevice.setPurchase_pay(Integer.valueOf(oConvertUtils.getString(devicePu.get(i).get("purchase_pay"))));
							reDevice.setPurchase_goods(Integer.valueOf(oConvertUtils.getString(devicePu.get(i).get("purchase_goods"))));
							reDevice.setMall_deposit(wMall.getMallDeposit());
							reDevice.setMall_image(wMall.getMallImage());
							listResultDevices.add(reDevice);
						}
					}
				}
				j.setTableData(listResultDevices);
			}else {
				j.setMsg("该用户无设备订单信息");
				j.setSuccess(false);
			}
		}else if( "1".equals(oConvertUtils.getString(map.get("type"))) ) {
			List<resultGift> listResultGifts = new ArrayList<resultGift>();
			List<Map<String, Object>> wGiftEx = wGiftExchangeServiceI.resultTableFieldAndValue("giftexchange_phone", memberPhone);
			if( wGiftEx != null && !wGiftEx.isEmpty() ){
				for (int i = 0; i < wGiftEx.size(); i++) {
					String giftId = oConvertUtils.getString(wGiftEx.get(i).get("gift_id"));
					if( oConvertUtils.isNotEmpty(giftId) ){
						WGiftEntity wGiftEntity = wGiftServiceI.findUniqueByProperty(WGiftEntity.class, "id", giftId);
						if( wGiftEntity != null ){
							resultGift reGift = new resultGift();
							reGift.setGift_describe(wGiftEntity.getGiftDescribe());
							reGift.setGift_change(wGiftEntity.getGiftChange());
							reGift.setGift_image(wGiftEntity.getGiftImage());
							reGift.setGiftexchange_order(oConvertUtils.getString(wGiftEx.get(i).get("giftexchange_order")));
							reGift.setGiftexchange_state(oConvertUtils.getString(wGiftEx.get(i).get("giftexchange_state")));
							reGift.setGiftexchange_handle(oConvertUtils.getString(wGiftEx.get(i).get("giftexchange_handle")));
							reGift.setGift_name(oConvertUtils.getString(wGiftEx.get(i).get("gift_name")));
							reGift.setGiftexchange_number(oConvertUtils.getString(wGiftEx.get(i).get("giftexchange_number")));
							reGift.setGiftexchange_time(oConvertUtils.getString(wGiftEx.get(i).get("giftexchange_time")));
							reGift.setGiftexchange_consignee(oConvertUtils.getString(wGiftEx.get(i).get("giftexchange_consignee")));
							reGift.setGiftexchange_phone(oConvertUtils.getString(wGiftEx.get(i).get("giftexchange_phone")));
							reGift.setGiftexchange_address(oConvertUtils.getString(wGiftEx.get(i).get("giftexchange_address")));
							reGift.setGiftexchange_express(oConvertUtils.getString(wGiftEx.get(i).get("giftexchange_express")));
							reGift.setGiftexchange_couriernumber(oConvertUtils.getString(wGiftEx.get(i).get("giftexchange_couriernumber")));
							reGift.setGiftexchange_operator(oConvertUtils.getString(wGiftEx.get(i).get("giftexchange_operator")));
							reGift.setGiftexchange_cost(oConvertUtils.getString(wGiftEx.get(i).get("giftexchange_cost")));
							reGift.setGiftexchange_mailtime(oConvertUtils.getString(wGiftEx.get(i).get("giftexchange_mailtime")));
							reGift.setGiftexchange_integral(oConvertUtils.getString(wGiftEx.get(i).get("giftexchange_integral")));
							listResultGifts.add(reGift);
						}
					}
				}
				j.setTableData(listResultGifts);
			}else {
				j.setMsg("该用户无礼品订单信息");
				j.setSuccess(false);
			}
		}
		return j;
	}
	
	/**
	 * online表单对外接口：getForm 获取表单数据 
	 * 获取表的所有数据
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(params = "getForm")
	@ResponseBody
	public TableJson getForm(String body, HttpServletRequest request, HttpServletResponse response) {
		Map map = JSONHelper.json2Map(body);
		TableJson j = new TableJson();
		try {
			//验证token，如果该token已存在，则放行，如不存在则通知前段调用发送手机验证码接口重新登录
			if(!SecurityUtil.saveVerificationToken(oConvertUtils.getString(map.get("member_phone")),oConvertUtils.getString(map.get("token")))){
				j.setTokenValid(false);
				j.setSuccess(false);
				return j;
			}
			// 参数校验
			if (oConvertUtils.isEmpty(map.get("tableName"))) {
				j.setMsg("tableName不能为空");
				j.setSuccess(false);
				return j;
			}
			// 校验该表是否是online表单
			String tableName = oConvertUtils.getString(map.get("tableName"));
			CgFormHeadEntity head = cgFormFieldService.getCgFormHeadByTableName(tableName);
			if (head == null) {
				j.setMsg("该表单不是online表单,请检查是否有这张表");
				j.setSuccess(false);
				return j;
			}
			if (head.getJformType() == 1) {
				// 单表
				j.setTableType(head.getJformType());
				//根据表名查询所有数据
				List<Map<String, Object>> dataForm = dataBaseService.findOneFor(tableName);
				j.setTableData(dataForm);
			}
		} catch (BusinessException e) {
			j.setSuccess(false);
			j.setMsg(e.getMessage());
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("系统异常");
		}
		return j;
	}
	
	/**
	 * app处理告警之后，调用该接口，将告警信息取消 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(params = "headleWarn")
	@ResponseBody
	public TableJson headleWarn(String body, HttpServletRequest request, HttpServletResponse response) {
		Map map = JSONHelper.json2Map(body);
		TableJson j = new TableJson();
		try {
			//验证token，如果该token已存在，则放行，如不存在则通知前段调用发送手机验证码接口重新登录
			if(!SecurityUtil.saveVerificationToken(oConvertUtils.getString(map.get("member_phone")),oConvertUtils.getString(map.get("token")))){
				j.setTokenValid(false);
				j.setSuccess(false);
				return j;
			}
			String waterIdStr = oConvertUtils.getString(map.get("waterArray"));
			if(StringUtils.isNotBlank(waterIdStr)){
				String[]  array = waterIdStr.split(",");
				WWaterMeterServiceI  waterMeterService = SpringContextUtils.getWwaterMeterService();
				for(String s : array) {
	            	WWaterMeterEntity waterMeterEntity = waterMeterService.findUniqueByProperty(WWaterMeterEntity.class, "waterId", s);
	            	if(null != waterMeterEntity) {
	            		//关阀之后将本次告警记录取消
	            		waterMeterEntity.setWaterValue(0);
	            		waterMeterService.save(waterMeterEntity);
	            		logger.info("取消告警。。。。。" + s);
	            	}
				}
				j.setSuccess(true);
				j.setMsg("取消告警成功！");
				
			}
		} catch (BusinessException e) {
			j.setSuccess(false);
			j.setMsg(e.getMessage());
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("系统异常");
		}
		return j;
	}
	
	/**
	 * online表单对外接口：getForKeyAndValue 根据表名及字段和字段值查询
	 * @param body
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(params = "getForKeyAndValue")
	@ResponseBody
	public TableJson getForKeyAndValue(String body, HttpServletRequest request, HttpServletResponse response) {
		Map map = JSONHelper.json2Map(body);
		TableJson j = new TableJson();
		try {
			//验证token，如果该token已存在，则放行，如不存在则通知前段调用发送手机验证码接口重新登录
			if(!SecurityUtil.saveVerificationToken(oConvertUtils.getString(map.get("member_phone")),oConvertUtils.getString(map.get("token")))){
				j.setTokenValid(false);
				j.setSuccess(false);
				return j;
			}
			// 参数校验
			if (oConvertUtils.isEmpty(map.get("tableName"))) {
				j.setMsg("tableName不能为空");
				j.setSuccess(false);
				return j;
			}
			if (map.get("data")==null) {
				j.setMsg("参数Data不能为空");
				j.setSuccess(false);
				return j;
			}
			Map dataMap = (Map) map.get("data");
			String data = JSONHelper.map2json(dataMap);
			// 校验该表是否是online表单
			String tableName = oConvertUtils.getString(map.get("tableName"));
			CgFormHeadEntity head = cgFormFieldService.getCgFormHeadByTableName(tableName);
			if (head == null) {
				j.setMsg("该表单不是online表单,请检查是否有这张表");
				j.setSuccess(false);
				return j;
			}
			Map<String, Object> formData = new HashMap<String, Object>();
			formData = JSONHelper.json2Map(data);
			if (head.getJformType() == 1) {
				// 单表
				j.setTableType(head.getJformType());
				//根据表名及字段和字段值查询数据
				List<Map<String, Object>> dataForm = dataBaseService.findTableKeyAndValue(tableName,formData);
				j.setTableData(dataForm);
			}
		} catch (BusinessException e) {
			j.setSuccess(false);
			j.setMsg(e.getMessage());
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("系统异常");
		}
		return j;
	}
	
	/**
	 * online表单对外接口：getFormPhone 根据用户电话号码获取数据
	 * @param body
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(params = "getFromPhone")
	@ResponseBody
	public TableJson getFormPhone(String body,HttpServletRequest request,HttpServletResponse response) {
		Map map = JSONHelper.json2Map(body);
		TableJson j = new TableJson();
		try {
			//验证token，如果该token已存在，则放行，如不存在则通知前段调用发送手机验证码接口重新登录
			if(!SecurityUtil.saveVerificationToken(oConvertUtils.getString(map.get("member_phone")),oConvertUtils.getString(map.get("token")))){
				j.setTokenValid(false);
				j.setSuccess(false);
				return j;
			}
			// 参数校验
			if (oConvertUtils.isEmpty(map.get("tableName"))) {
				j.setMsg("tableName不能为空");
				j.setSuccess(false);
				return j;
			}
			// 校验该表是否是online表单
			String tableName = oConvertUtils.getString(map.get("tableName"));
			String phone = oConvertUtils.getString(map.get("member_phone"));
			CgFormHeadEntity head = cgFormFieldService.getCgFormHeadByTableName(tableName);
			if (head == null) {
				j.setMsg("该表单不是online表单,请检查是否有这张表");
				j.setSuccess(false);
				return j;
			}

			if (head.getJformType() == 1) {
				// 单表
				j.setTableType(head.getJformType());
				Map<String, Object> dataForm = dataBaseService.findOneForPhone(tableName, phone);
				j.setTableData(dataForm);
			} else {
				j.setMsg("该表不存在");
				j.setSuccess(false);
				return j;
			}
		} catch (BusinessException e) {
			j.setSuccess(false);
			j.setMsg(e.getMessage());
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("系统异常");
		}
		return j;
	}

	/**
	 * online表单对外接口：getFormInfo 获取表单数据 
	 * 根据id获取表单数据
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(params = "getFormInfo")
	@ResponseBody
	public TableJson getFormInfo(String body, HttpServletRequest request, HttpServletResponse response) {
		Map map = JSONHelper.json2Map(body);
		TableJson j = new TableJson();
		try {
			//验证token，如果该token已存在，则放行，如不存在则通知前段调用发送手机验证码接口重新登录
			if(!SecurityUtil.saveVerificationToken(oConvertUtils.getString(map.get("member_phone")),oConvertUtils.getString(map.get("token")))){
				j.setTokenValid(false);
				j.setSuccess(false);
				return j;
			}
			// 参数校验
			if (oConvertUtils.isEmpty(map.get("tableName"))) {
				j.setMsg("tableName不能为空");
				j.setSuccess(false);
				return j;
			}
			if (oConvertUtils.isEmpty(map.get("id"))) {
				j.setMsg("id不能为空");
				j.setSuccess(false);
				return j;
			}
			// 校验该表是否是online表单
			String tableName = oConvertUtils.getString(map.get("tableName"));
			String id = oConvertUtils.getString(map.get("id"));
			CgFormHeadEntity head = cgFormFieldService.getCgFormHeadByTableName(tableName);
			if (head == null) {
				j.setMsg("该表单不是online表单,请检查是否有这张表");
				j.setSuccess(false);
				return j;
			}

			if (head.getJformType() == 1) {
				// 单表
				j.setTableType(head.getJformType());
				Map<String, Object> dataForm = dataBaseService.findOneForJdbc(tableName, id);
				j.setTableData(dataForm);
			} else if (head.getJformType() == 2) {
				// 主表
				j.setTableType(head.getJformType());
				Map<String, Object> mainForm = dataBaseService.findOneForJdbc(tableName, id);
				j.setTableData(mainForm);
				Map<String, Object> tableData = new HashMap<String, Object>();
				String subTableStr = head.getSubTableStr();
				if (StringUtils.isNotEmpty(subTableStr)) {
					String[] subTables = subTableStr.split(",");
					List<Map<String, Object>> subTableData = new ArrayList<Map<String, Object>>();
					for (String subTable : subTables) {
						subTableData = cgFormFieldService.getSubTableData(tableName, subTable, id);
						tableData.put(subTable, subTableData);
					}
				}
				j.setSubTableDate(tableData);
			} else {
				throw new BusinessException("不支持该类型的表单的操作");
			}
		} catch (BusinessException e) {
			j.setSuccess(false);
			j.setMsg(e.getMessage());
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("系统异常");
		}
		return j;
	}

	/**
	 * online表单对外接口：deleteFormInfo 删除表单数据 注意：
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(params = "deleteFormInfo")
	@ResponseBody
	public TableJson deleteFormInfo(String body, HttpServletRequest request, HttpServletResponse response) {
		Map map = JSONHelper.json2Map(body);
		TableJson j = new TableJson();
		try {
			//验证token，如果该token已存在，则放行，如不存在则通知前段调用发送手机验证码接口重新登录
			if(!SecurityUtil.saveVerificationToken(oConvertUtils.getString(map.get("member_phone")),oConvertUtils.getString(map.get("token")))){
				j.setTokenValid(false);
				j.setSuccess(false);
				return j;
			}
			// 参数校验
			if (oConvertUtils.isEmpty(map.get("tableName"))) {
				j.setMsg("tableName不能为空");
				j.setSuccess(false);
				return j;
			}
			if (oConvertUtils.isEmpty(map.get("id"))) {
				j.setMsg("id不能为空");
				j.setSuccess(false);
				return j;
			}
			String tableName = oConvertUtils.getString(map.get("tableName"));
			String id = oConvertUtils.getString(map.get("id"));
			// 校验该表是否是online表单
			CgFormHeadEntity head = cgFormFieldService.getCgFormHeadByTableName(tableName);
			if (head == null) {
				j.setMsg("该表单不是online表单,请检查是否有这张表");
				j.setSuccess(false);
				return j;
			}
			if (head.getJformType() != 1 && head.getJformType() != 2) {
				throw new BusinessException("不支持该类型的表单的操作");
			}
			cgTableService.delete(tableName, id);
			j.setMsg("删除成功");
		} catch (BusinessException e) {
			j.setSuccess(false);
			j.setMsg(e.getMessage());
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("系统异常");
		}
		return j;
	}

	/**
	 * online表单对外接口：addFormInfo 新增表单数据 注意：
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(params = "addFormInfo")
	@ResponseBody
	public TableJson addFormInfo(String body, HttpServletRequest request, HttpServletResponse response) {
		Map map = JSONHelper.json2Map(body);
		if(null != map.get("type")){
			try {
				body = new String(body.getBytes("ISO-8859-1"),"UTF-8");
				map = JSONHelper.json2Map(body);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		TableJson j = new TableJson();
		try {
			//验证token，如果该token已存在，则放行，如不存在则通知前段调用发送手机验证码接口重新登录
			if(!SecurityUtil.saveVerificationToken(oConvertUtils.getString(map.get("member_phone")),oConvertUtils.getString(map.get("token")))){
				j.setTokenValid(false);
				j.setSuccess(false);
				return j;
			}
			// 参数校验
			if (oConvertUtils.isEmpty(map.get("tableName"))) {
				j.setMsg("tableName不能为空");
				j.setSuccess(false);
				return j;
			}
			if (oConvertUtils.isEmpty(map.get("id"))) {
				j.setMsg("id不能为空");
				j.setSuccess(false);
				return j;
			}
			if (map.get("data")==null) {
				j.setMsg("参数Data不能为空");
				j.setSuccess(false);
				return j;
			}
			// 校验该表是否是online表单
			String tableName = oConvertUtils.getString(map.get("tableName"));
			String id = oConvertUtils.getString(map.get("id"));
			Map dataMap = (Map) map.get("data");
			String data = JSONHelper.map2json(dataMap);
			CgFormHeadEntity head = cgFormFieldService.getCgFormHeadByTableName(tableName);
			if (head == null) {
				j.setMsg("该表单不是online表单,请检查是否有这张表");
				j.setSuccess(false);
				return j;
			}
			if (head.getJformType() != 1 && head.getJformType() != 2) {
				throw new BusinessException("不支持该类型的表单的操作");
			}
			Map<String, Object> dataForm = dataBaseService.findOneForJdbc(tableName, id);
			if (dataForm != null) {
				throw new BusinessException("表单数据已存在");
			}
			if (head.getJformType() == 1) {
				Map<String, Object> formData;
				try {
					formData = new HashMap<String, Object>();
					formData = JSONHelper.json2Map(data);
				} catch (Exception e) {
					throw new BusinessException("json解析异常");
				}
				formData.put("id", id);
				formData.put("create_date", DateUtils.getDateFormatter());
				if( "w_user_register".equals(map.get("tableName")) ){
					formData.put("register_member_id", map.get("member_id"));
				}
				dataBaseService.insertTable(tableName, formData);
//				判断增加的表单数据是否为充值记录表单，如果为充值记录表单则在表单统计中增加一行数据
				if("w_recharge".equals(map.get("tableName"))){
					WRechargeStatisticsEntity wRechargeStatisticsEntity = new WRechargeStatisticsEntity();
					wRechargeStatisticsEntity.setMemberName(formData.get("member_name").toString());
					wRechargeStatisticsEntity.setRechargeStatistics((BigDecimal) formData.get("recharge_sum"));
					wRechargeStatisticsEntity.setMemberPhone(formData.get("member_phone").toString());
					wRechargeStatisticsService.save(wRechargeStatisticsEntity);
				}
			} else if (head.getJformType() == 2) {
				Map<String, List<Map<String, Object>>> formData;
				try {
					formData = new HashMap<String, List<Map<String, Object>>>();
					formData = JSONHelper.json2MapList(data);
					List<Map<String, Object>> list = formData.get(tableName);
					if (list == null || list.size() <= 0) {
						throw new BusinessException("主表数据异常");
					}
					Map<String, Object> mainMap = list.get(0);
					if (mainMap.get("id") == null || "".equals((String) mainMap.get("id"))) {
						throw new BusinessException("主表数据缺少id");
					}
					if (!id.equals((String) mainMap.get("id"))) {
						throw new BusinessException("id与主表id不一致");
					}
				} catch (Exception e) {
					throw new BusinessException("json解析异常");
				}
				dataBaseService.insertTableMore(formData, tableName);
			}
			j.setMsg("新增表单数据成功");
		} catch (BusinessException e) {
			j.setSuccess(false);
			j.setMsg(e.getMessage());
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("系统异常");
		}

		return j;
	}

	/**
	 * online表单对外接口：updateFormInfo 更新表单数据 注意：
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(params = "updateFormInfo")
	@ResponseBody
	public TableJson updateFormInfo(String body, HttpServletRequest request, HttpServletResponse response) {
		Map map = JSONHelper.json2Map(body);
		TableJson j = new TableJson();
		try {
			//验证token，如果该token已存在，则放行，如不存在则通知前段调用发送手机验证码接口重新登录
			if(!SecurityUtil.saveVerificationToken(oConvertUtils.getString(map.get("member_phone")),oConvertUtils.getString(map.get("token")))){
				j.setTokenValid(false);
				j.setSuccess(false);
				return j;
			}
			// 参数校验
			if (oConvertUtils.isEmpty(map.get("tableName"))||map.get("tableName")=="") {
				j.setMsg("tableName不能为空");
				j.setSuccess(false);
				return j;
			}
			if (oConvertUtils.isEmpty(map.get("id"))) {
				j.setMsg("id不能为空");
				j.setSuccess(false);
				return j;
			}
			if (map.get("data")==null) {
				j.setMsg("参数Data不能为空");
				j.setSuccess(false);
				return j;
			}
			// 校验该表是否是online表单
			String tableName = oConvertUtils.getString(map.get("tableName"));
			String id = oConvertUtils.getString(map.get("id"));
			Map dataMap = (Map) map.get("data");
			String data = JSONHelper.map2json(dataMap);
			CgFormHeadEntity head = cgFormFieldService.getCgFormHeadByTableName(tableName);
			if (head == null) {
				j.setMsg("该表单不是online表单,请检查是否有这张表");
				j.setSuccess(false);
				return j;
			}
			if (head.getJformType() != 1 && head.getJformType() != 2) {
				throw new BusinessException("不支持该类型的表单的操作");
			}
			Map<String, Object> dataForm = dataBaseService.findOneForJdbc(tableName, id);
			if (dataForm == null) {
				throw new BusinessException("表单数据不存在");
			}
			if (head.getJformType() == 1) {
				Map<String, Object> formData;
				try {
					formData = new HashMap<String, Object>();
					formData = JSONHelper.json2Map(data);
				} catch (Exception e) {
					throw new BusinessException("json解析异常");
				}
				dataBaseService.updateTable(tableName, id, formData);
			} else if (head.getJformType() == 2) {
				Map<String, List<Map<String, Object>>> formData;
				try {
					formData = new HashMap<String, List<Map<String, Object>>>();
					formData = JSONHelper.json2MapList(data);
					List<Map<String, Object>> list = formData.get(tableName);
					if (list == null || list.size() <= 0) {
						throw new BusinessException("主表数据异常");
					}
					Map<String, Object> mainMap = list.get(0);
					if (mainMap.get("id") == null || "".equals((String) mainMap.get("id"))) {
						throw new BusinessException("主表数据缺少id");
					}
					if (!id.equals((String) mainMap.get("id"))) {
						throw new BusinessException("id与主表id不一致");
					}
				} catch (Exception e) {
					throw new BusinessException("json解析异常");
				}
				dataBaseService.updateTableMore(formData, tableName);
			}
			j.setMsg("更新表单数据成功");
		} catch (BusinessException e) {
			j.setSuccess(false);
			j.setMsg(e.getMessage());
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("系统异常");
		}
		return j;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(params = "addRelations")
	@ResponseBody
	public TableJson addFriendsRelation(String body, HttpServletRequest request, HttpServletResponse response) {
		Map map = JSONHelper.json2Map(body);
		Map dataMap = (Map) map.get("data");
		String data = JSONHelper.map2json(dataMap);
		Map<String, Object> formData = new HashMap<String, Object>();
		formData = JSONHelper.json2Map(data);
		TableJson j = new TableJson();
		//验证token，如果该token已存在，则放行，如不存在则通知前段调用发送手机验证码接口重新登录
		if(!SecurityUtil.saveVerificationToken(oConvertUtils.getString(map.get("member_phone")),oConvertUtils.getString(map.get("token")))){
			j.setTokenValid(false);
			j.setSuccess(false);
			return j;
		}
		// 参数校验
		if (oConvertUtils.isEmpty(map.get("tableName"))) {
			j.setMsg("tableName不能为空");
			j.setSuccess(false);
			return j;
		}
		if (oConvertUtils.isEmpty(map.get("id"))) {
			j.setMsg("id不能为空");
			j.setSuccess(false);
			return j;
		}
		if (map.get("data")==null) {
			j.setMsg("参数Data不能为空");
			j.setSuccess(false);
			return j;
		}
		WUserRegisterEntity entity = new WUserRegisterEntity();
		entity.setRegisterPhone(oConvertUtils.getString(formData.get("register_phone")));
		entity.setRegisterState(oConvertUtils.getInt(formData.get("register_State"),1));
		entity.setRegisterRelatives(oConvertUtils.getString(formData.get("register_relatives")));
		entity.setUpdateDate(new Date());
		entity.setMemberPhone(oConvertUtils.getString(map.get("member_Phone")));
		try {
			wuserRegisterService.save(entity);
			j.setMsg("添加亲属关系成功");
			j.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			j.setMsg("添加亲属关系失败");
			j.setSuccess(false);
		}
		return j;
	}
	
	/**
     * 处理开阀或者关阀
     * @param meterNo
     */
    private void checkOpenOrClose(String meterNo) {
    	WWaterOpenServiceI  waterOpenService = SpringContextUtils.getWaterOpenService();
    	WWaterOpenEntity entity = waterOpenService.findUniqueByProperty(WWaterOpenEntity.class, "waterId", meterNo);
    	if(null == entity) {
    		logger.info("无开关阀操作....,水表编号：" + meterNo);
    		return ;
    	}else {
    		if(entity.getWaterOpenType() == 0) {
    			//开阀
    			SocketSendBiz.sendOpen(DataUtils.reverseStr(meterNo), false);
    			logger.info("开阀,水表编号:" + meterNo);
    		}else {
    			//关阀
    			SocketSendBiz.sendClose(DataUtils.reverseStr(meterNo), false);
    			logger.info("关阀,水表编号:" + DataUtils.reverseStr(meterNo));
    			WWaterMeterServiceI  waterMeterService = SpringContextUtils.getWwaterMeterService();
            	WWaterMeterEntity waterMeterEntity = waterMeterService.findUniqueByProperty(WWaterMeterEntity.class, "waterId", meterNo);
            	if(null != waterMeterEntity) {
            		//关阀之后将本次告警记录取消
            		waterMeterEntity.setWaterValue(0);
            	}
            	try {
					waterMeterService.saveOrUpdate(waterMeterEntity);
				} catch (Exception e) {
					logger.info("关阀之后，清除告警记录失败:" +e.getMessage());
					e.printStackTrace();
				}
    		}
			try {
				waterOpenService.delete(entity);
			} catch (Exception e) {
				logger.info("删除水表操作记录失败:" + e.getMessage());
				e.printStackTrace();
			}
    	}
    }
    
    public static void main(String[] args) {
		System.out.println(DataUtils.reverseStr("02207101"));
	}
}
