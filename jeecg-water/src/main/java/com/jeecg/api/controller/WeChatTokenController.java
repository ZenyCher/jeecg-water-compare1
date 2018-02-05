package com.jeecg.api.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.util.PropertiesUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.p3.core.utils.common.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeecg.api.entity.WechatMetaData;
import com.jeecg.api.sdk.AliPaySDK;
import com.jeecg.api.sdk.WechatConstants;
import com.jeecg.api.sdk.WechatSdk;
import com.jeecg.api.util.PayResult;
import com.jeecg.orderpay.entity.WOrderPayEntity;
import com.jeecg.orderpay.service.WOrderPayServiceI;
import com.jeecg.waterdispenser.entity.WDevicePurchaseEntity;
import com.jeecg.waterdispenser.entity.WDeviceTypeEntity;
import com.jeecg.waterdispenser.entity.WUserDeviceEntity;
import com.jeecg.waterdispenser.entity.WUserMemberEntity;
import com.jeecg.waterdispenser.service.WDeviceServiceI;
import com.jeecg.waterdispenser.service.WDeviceTypeServiceI;
import com.jeecg.waterdispenser.service.WUserDeviceServiceI;
import com.jeecg.waterdispenser.service.WUserMemberServiceI;
import com.jeecg.waterdispenser.service.WechatServiceI;

@Controller  
@RequestMapping("/weChatTokenController")
public class WeChatTokenController {
	
	@Autowired
	private WOrderPayServiceI payService;
	
	@Autowired
	private WDeviceServiceI deviceService;
	@Autowired
	private WechatServiceI wechatService;
	
	@Autowired
	private WUserDeviceServiceI wUserDeviceService;
	@Autowired
	private WDeviceServiceI wDeviceServiceI;
	@Autowired
	private WDeviceTypeServiceI wDeviceTypeServiceI;
	@Autowired
	private WUserMemberServiceI wUserMemberServiceI;
	
	public static final String TOKEN = "wang123";  
	
	private static final Logger logger = Logger.getLogger(WeChatTokenController.class);

    
    /** 
     * 微信Token验证 
     * @param signature 微信加密签名 
     * @param timestamp 时间戳 
     * @param nonce     随机数 
     * @param echostr   随机字符串 
     * @param response 
     * @return 
     * @return 
     * @throws NoSuchAlgorithmException  
     * @throws IOException  
     */  
    @RequestMapping("/callback")
    @ResponseBody
    public WechatMetaData getToken(HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException, IOException{  
        /*String signature = request.getParameter("signature");// 微信加密签名（token、timestamp、nonce。）  
        String timestamp = request.getParameter("timestamp");// 时间戳  
        String nonce = request.getParameter("nonce");// 随机数  
        String echostr = request.getParameter("echostr");// 随机字符串  
        // 将token、timestamp、nonce三个参数进行字典序排序   
        String[] params = new String[] { TOKEN, timestamp, nonce };  
        Arrays.sort(params);  
        // 将三个参数字符串拼接成一个字符串进行sha1加密  
        String clearText = params[0] + params[1] + params[2];  
        String algorithm = "SHA-1";  
        String sign = new String(    
                org.apache.commons.codec.binary.Hex.encodeHex(MessageDigest.getInstance(algorithm).digest((clearText).getBytes()), true));
        // 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信    
        if (signature.equals(sign)) {    
            response.getWriter().print(echostr);    
        }    */
    	
    	logger.info("wchat Callback  start.....");
    	WechatMetaData metaData = new WechatMetaData();
    	PropertiesUtil util = new PropertiesUtil("wechat.properties");
    	BufferedReader br = null;
		String str = "";
		InputStreamReader inputStreamReader = null;
		request.setCharacterEncoding("UTF-8");
		inputStreamReader = new InputStreamReader((ServletInputStream) request.getInputStream(), "UTF-8");
		br = new BufferedReader(inputStreamReader);
		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		// 接收到的流
		str = sb.toString();
		logger.info("回调内容....." + str);
		if (StringUtil.isEmpty(str)) {
			metaData.setReturn_code("FAIL");
			metaData.setReturn_msg("回调失败");
			return metaData;
		}
        //解析回调内容
		try {
			metaData = WechatSdk.parseXml(str.getBytes());
			/*String sign = WechatSdk.signByMD5(metaData,util.readProperty("wechat.merchant.secretkey"));
			if(sign.equals(metaData.getSign())){
				
			}*/
			 WOrderPayEntity entity = payService.findUniqueByProperty(WOrderPayEntity.class, "outTradeNo", metaData.getOut_trade_no());
			 if( "FINISH_OK".equals(entity.getReturnCode()) ){
				 logger.info("回调成功");
				 return null;
			 }
			 if( null != entity ){
				 //金额校验
				 if(entity.getSettlementTotalFee() != metaData.getTotal_fee().intValue()){
					metaData.setReturn_code("FAIL");
					metaData.setReturn_msg("订单金额校验失败！");
					return metaData;
				 }
				 
				 //更新数据
				 if("SUCCESS".equals(metaData.getResult_code())){
					 entity.setReturnCode("FINISH_OK");
					//订单支付成功之后，判断如果为设备购买，则更新设备购买表的购买状态
						//根据订单号查询
					 //根据净水器类型查找净水器类型表得到初始净水器设备过滤水量等
					 String memberId= "";
						WDevicePurchaseEntity ordeDevice = deviceService.findUniqueByProperty(WDevicePurchaseEntity.class, "purchaseOrder",entity.getOutTradeNo());
						if( ordeDevice != null ){
							WDeviceTypeEntity wDeviceTypeEntity = wDeviceTypeServiceI.findUniqueByProperty(WDeviceTypeEntity.class, "id", ordeDevice.getDeviceId());
							ordeDevice.setPurchasePay(1);
							ordeDevice.setPurchaseGoods(1);
							if(StringUtils.isBlank(entity.getMemberId())) {
								//当订单表中不存在会员的ID时，新增一条会员记录
								/**
								 * 在会员表中新增一条记录(修改，当订单表中，获取不到会员ID时，才会新增一条会员记录)
								 */
								WDeviceTypeEntity wDeviceTypeEntity2 = wDeviceTypeServiceI.findUniqueByProperty(WDeviceTypeEntity.class, "id", wDeviceTypeEntity.getId());
								WUserMemberEntity memberEntity = new WUserMemberEntity();
								memberEntity.setCreateDate(new Date());
								memberEntity.setCreateBy(entity.getMember_phone());
								memberEntity.setMemberName(entity.getReceiver());
								memberEntity.setMemberAddress(entity.getAddress());
								memberEntity.setMemberType(entity.getReceiverMobile());
								memberEntity.setMemberState(1);
								BigDecimal fee = new BigDecimal(entity.getSettlementTotalFee());
								memberEntity.setMemberDeposit(fee.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP).intValue());
								memberEntity.setMemberDeviceType(wDeviceTypeEntity2.getDeviceType());
								memberEntity.setMemberDeviceId(wDeviceTypeEntity.getId());
								memberEntity.setMemberPhone(entity.getMember_phone());
								memberEntity.setMemberSource(1);//商城下单
								wUserMemberServiceI.save(memberEntity);
								memberId = memberEntity.getId();
								logger.info("会员列表信息增加成功:" + "会员ID:" + memberId +  memberEntity.getMemberName() + "地址：" +memberEntity.getMemberAddress() +"deviceType:" + memberEntity.getMemberDeviceType() + " deviceID: " +memberEntity.getMemberDeviceId());

							}
							deviceService.updateEntitie(ordeDevice);
							
							//更新用户设备绑定表
							WUserDeviceEntity wUserDeviceEntity = new WUserDeviceEntity();
							wUserDeviceEntity.setDeviceTypeId(wDeviceTypeEntity.getId());
							wUserDeviceEntity.setMemberPhone(entity.getMember_phone());
							wUserDeviceEntity.setOneFilterName(wDeviceTypeEntity.getFilterNumOne() == null ? 0 : wDeviceTypeEntity.getFilterNumOne());
							wUserDeviceEntity.setTwoFilterName(wDeviceTypeEntity.getFilterNumTwo() == null ? 0 : wDeviceTypeEntity.getFilterNumTwo());
							wUserDeviceEntity.setThreeFilterName(wDeviceTypeEntity.getFilterNumThree() == null ? 0 : wDeviceTypeEntity.getFilterNumThree());
							wUserDeviceEntity.setFourFilterName(wDeviceTypeEntity.getFilterNumFour() == null ? 0 : wDeviceTypeEntity.getFilterNumFour());
							wUserDeviceEntity.setFiveFilterName(wDeviceTypeEntity.getFilterNumFive() == null ? 0 : wDeviceTypeEntity.getFilterNumFive());
							wUserDeviceEntity.setSixFilterName(wDeviceTypeEntity.getFilterNumSix() == null ? 0 : wDeviceTypeEntity.getFilterNumSix());
							wUserDeviceEntity.setMemberId(memberId);
							wUserDeviceService.save(wUserDeviceEntity);
//							List<WUserMemberEntity> wUserMemberEntity = wUserMemberServiceI.findByProperty(WUserMemberEntity.class, "memberType",entity.getMember_phone());
							
														
							/*for (WUserMemberEntity wUserMemberEntity2 : wUserMemberEntity) {
								wDeviceTypeEntity2 = wDeviceTypeServiceI.findUniqueByProperty(WDeviceTypeEntity.class, "id", wDeviceTypeEntity.getId());
								wUserMemberEntity2.setMemberDeviceType(wDeviceTypeEntity2.getDeviceType());
								wUserMemberEntity2.setMemberDeviceId(wDeviceTypeEntity.getId());
								 BigDecimal fee = new BigDecimal(entity.getSettlementTotalFee());
								 wUserMemberEntity2.setMemberType(entity.getMember_phone());
								wUserMemberEntity2.setMemberDeposit(fee.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP).intValue());
								wUserMemberServiceI.saveOrUpdate(wUserMemberEntity2);
								logger.info("会员列表信息增加成功" + wUserMemberEntity2);
							}*/
						}
						//如果是充值水量 调用充值水量处理送水或送积分
						if(WechatConstants.RECHARGE.equals(entity.getTransaction_type())) {
							wechatService.saveUserIntegral(entity.getMember_phone(), metaData.getTotal_fee().intValue() + "", entity.getWaterId());
						}
				 }else{
					 entity.setReturnCode(metaData.getErr_code());
				 }
				 entity.setUpdateDate(new Date());
				 payService.updateEntitie(entity);
			 }
		} catch (Exception e) {
			metaData.setReturn_code("FAIL");
			metaData.setReturn_msg("回调失败");
			e.printStackTrace();
		}
		return metaData;
    } 

//    @RequestMapping("/alipayCallback")
//    public void alipayCallBack(HttpServletRequest request, HttpServletResponse response){
//    	BufferedReader br = null;
//		String str = "";
//		InputStreamReader inputStreamReader = null;
//		try {
//			request.setCharacterEncoding("UTF-8");
//			inputStreamReader = new InputStreamReader((ServletInputStream) request.getInputStream(), "UTF-8");
//			br = new BufferedReader(inputStreamReader);
//			String line = null;
//			StringBuilder sb = new StringBuilder();
//			// 接收到的流
//			str = sb.toString();
//			logger.info("支付宝回调内容....." + str);
//			while ((line = br.readLine()) != null) {
//				sb.append(line);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		
//    }
    /**
     * 支付宝回调接口
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/alipayCallback")
    @ResponseBody
    public String alipayCallback(HttpServletRequest request, HttpServletResponse response) {  
		
    	Map<String, String[]> map = request.getParameterMap();
		Iterator<Entry<String, String[]>> it = map.entrySet().iterator();
		String out_trade_no = "";//商户订单号
		String seller_id = "";//用户支付宝id
		String trade_no = "";//支付宝订单号
		String trade_status = "";//支付宝订单号
		String total_amount = "";//支付宝订单号
		
		while (it.hasNext()) {
			Entry<String, String[]> entry = it.next();
			System.out.println("key:" + entry.getKey() + " value:" +entry.getValue()[0]);
			if("out_trade_no".equals( entry.getKey())){
				out_trade_no = entry.getValue()[0];
			}
			if("seller_id".equals( entry.getKey())){
				seller_id = entry.getValue()[0];
			}
			if("trade_no".equals( entry.getKey())){
				trade_no = entry.getValue()[0];
			}
			if("trade_status".equals( entry.getKey())){
				trade_status = entry.getValue()[0];
			}
			if("total_amount".equals( entry.getKey())){
				total_amount = entry.getValue()[0];
			}
    }
		//查询订单
		 WOrderPayEntity entity = payService.findUniqueByProperty(WOrderPayEntity.class, "outTradeNo", out_trade_no);
		 System.out.println(out_trade_no);
		 System.out.println(entity);
		 
		 if("FINISH_OK".equals(entity.getReturnCode())){
			 return "SUCCESS";
		 }
			 
		//更新数据
		 if("TRADE_SUCCESS".equals(trade_status)){
			 entity.setReturnCode("FINISH_OK");
			//订单支付成功之后，判断如果为设备购买，则更新设备购买表的购买状态
				//根据订单号查询
			 //根据净水器类型查找净水器类型表得到初始净水器设备过滤水量等
			 String memberId= "";
				WDevicePurchaseEntity ordeDevice = deviceService.findUniqueByProperty(WDevicePurchaseEntity.class, "purchaseOrder",entity.getOutTradeNo());
				if( ordeDevice != null ){
					WDeviceTypeEntity wDeviceTypeEntity = wDeviceTypeServiceI.findUniqueByProperty(WDeviceTypeEntity.class, "id", ordeDevice.getDeviceId());
					ordeDevice.setPurchasePay(1);
					ordeDevice.setPurchaseGoods(1);
					if(StringUtils.isBlank(entity.getMemberId())) {
						//当订单表中不存在会员的ID时，新增一条会员记录
						/**
						 * 在会员表中新增一条记录(修改，当订单表中，获取不到会员ID时，才会新增一条会员记录)
						 */
						WDeviceTypeEntity wDeviceTypeEntity2 = wDeviceTypeServiceI.findUniqueByProperty(WDeviceTypeEntity.class, "id", wDeviceTypeEntity.getId());
						WUserMemberEntity memberEntity = new WUserMemberEntity();
						memberEntity.setCreateDate(new Date());
						memberEntity.setCreateBy(entity.getMember_phone());
						memberEntity.setMemberName(entity.getReceiver());
						memberEntity.setMemberAddress(entity.getAddress());
						memberEntity.setMemberType(entity.getReceiverMobile());
						memberEntity.setMemberState(1);
						BigDecimal fee = new BigDecimal(entity.getSettlementTotalFee());
						memberEntity.setMemberDeposit(fee.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP).intValue());
						memberEntity.setMemberDeviceType(wDeviceTypeEntity2.getDeviceType());
						memberEntity.setMemberDeviceId(wDeviceTypeEntity.getId());
						memberEntity.setMemberPhone(entity.getMember_phone());
						memberEntity.setMemberSource(1);//商城下单
						try {
							wUserMemberServiceI.save(memberEntity);
						} catch (Exception e) {
							e.printStackTrace();
						}
						memberId = memberEntity.getId();
						logger.info("会员列表信息增加成功:" + "会员ID:" + memberId +  memberEntity.getMemberName() + "地址：" +memberEntity.getMemberAddress() +"deviceType:" + memberEntity.getMemberDeviceType() + " deviceID: " +memberEntity.getMemberDeviceId());

					}
					deviceService.updateEntitie(ordeDevice);
					
					//更新用户设备绑定表
					WUserDeviceEntity wUserDeviceEntity = new WUserDeviceEntity();
					wUserDeviceEntity.setDeviceTypeId(wDeviceTypeEntity.getId());
					wUserDeviceEntity.setMemberPhone(entity.getMember_phone());
					wUserDeviceEntity.setOneFilterName(wDeviceTypeEntity.getFilterNumOne() == null ? 0 : wDeviceTypeEntity.getFilterNumOne());
					wUserDeviceEntity.setTwoFilterName(wDeviceTypeEntity.getFilterNumTwo() == null ? 0 : wDeviceTypeEntity.getFilterNumTwo());
					wUserDeviceEntity.setThreeFilterName(wDeviceTypeEntity.getFilterNumThree() == null ? 0 : wDeviceTypeEntity.getFilterNumThree());
					wUserDeviceEntity.setFourFilterName(wDeviceTypeEntity.getFilterNumFour() == null ? 0 : wDeviceTypeEntity.getFilterNumFour());
					wUserDeviceEntity.setFiveFilterName(wDeviceTypeEntity.getFilterNumFive() == null ? 0 : wDeviceTypeEntity.getFilterNumFive());
					wUserDeviceEntity.setSixFilterName(wDeviceTypeEntity.getFilterNumSix() == null ? 0 : wDeviceTypeEntity.getFilterNumSix());
					wUserDeviceEntity.setMemberId(memberId);
					try {
						wUserDeviceService.save(wUserDeviceEntity);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//					List<WUserMemberEntity> wUserMemberEntity = wUserMemberServiceI.findByProperty(WUserMemberEntity.class, "memberType",entity.getMember_phone());
					
												
					/*for (WUserMemberEntity wUserMemberEntity2 : wUserMemberEntity) {
						wDeviceTypeEntity2 = wDeviceTypeServiceI.findUniqueByProperty(WDeviceTypeEntity.class, "id", wDeviceTypeEntity.getId());
						wUserMemberEntity2.setMemberDeviceType(wDeviceTypeEntity2.getDeviceType());
						wUserMemberEntity2.setMemberDeviceId(wDeviceTypeEntity.getId());
						 BigDecimal fee = new BigDecimal(entity.getSettlementTotalFee());
						 wUserMemberEntity2.setMemberType(entity.getMember_phone());
						wUserMemberEntity2.setMemberDeposit(fee.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP).intValue());
						wUserMemberServiceI.saveOrUpdate(wUserMemberEntity2);
						logger.info("会员列表信息增加成功" + wUserMemberEntity2);
					}*/
				}
				//如果是充值水量 调用充值水量处理送水或送积分
				if(WechatConstants.RECHARGE.equals(entity.getTransaction_type())) {
					try {
						wechatService.saveUserIntegral(entity.getMember_phone(), total_amount, entity.getWaterId());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
		 }else{
			 entity.setReturnCode(trade_status);
		 }
		 entity.setUpdateDate(new Date());
		 payService.updateEntitie(entity);
	
//			key= seller_email and value= 416912174@qq.com
//			key= subject and value= 000000005faf3b49015faf681c72003c
//			key= sign and value= exds0bstNjYNv8SpKQekjtOCGJDnDOHr58yY5BmVspMnOusnsoj3mSfT8XvCfVLDJCRL3yfkuzow79BWUXghKReP90vYI/8cbhqsIRTn2FEUd1g45wc/CNw1K5DajaKNcX+IQZxUssJDlf/wCA16FQ3RbRF+9qXt96l1c8gJFsIt2K6LHuFS7v+00GRLgApoIr/8EqIGX2+U2WT5+0CJUzgaBM7g9DGaeqasG2CTK8kA7Zr6bUEAtZYoH+Y/hzFW2jo3+f6aW9HAPyUHPWBBFP3L7+aNdr6ngwYqBF5mJtUiUFpoUllY6upGDgWEkF7IYTC8Fc/6QLlZhGfHB/Dlyw==
//			key= body and value= 康之源净水器kzy001
//			key= buyer_id and value= 2088202870337219
//			key= invoice_amount and value= 0.01
//			key= notify_id and value= 3ba6d810e374de2d6d2b356312f3b5dhmh
//			key= fund_bill_list and value= [{"amount":"0.01","fundChannel":"ALIPAYACCOUNT"}]
//			key= notify_type and value= trade_status_sync
//			key= trade_status and value= TRADE_SUCCESS
//			key= receipt_amount and value= 0.01
//			key= app_id and value= 2017062807592838
//			key= buyer_pay_amount and value= 0.01
//			key= sign_type and value= RSA2
//			key= seller_id and value= 2088721151323067
//			key= gmt_payment and value= 2017-11-30 20:19:39
//			key= notify_time and value= 2017-11-30 20:33:13
//			key= version and value= 1.0
//			key= out_trade_no and value= e3e9ab3662b94140b59aa7178b3895e0
//			key= total_amount and value= 0.01
//			key= trade_no and value= 2017113021001004210542297145
//			key= auth_app_id and value= 2017062807592838
//			key= buyer_logon_id and value= 281***@qq.com
//			key= point_amount and value= 0.00


	return "SUCCESS";
	
}
		
}
