package com.jeecg.api.Pay;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.ibatis.cache.decorators.LoggingCache;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.PropertiesUtil;

import com.alibaba.druid.support.json.JSONUtils;
import com.jeecg.api.bizEnum.BizResultEnum;
import com.jeecg.api.bizEnum.JumpTypeEnum;
import com.jeecg.api.bizEnum.TraceTypeEnum;
import com.jeecg.api.entity.Authentication;
import com.jeecg.api.entity.ThirdPartyPaymentResult;
import com.jeecg.api.entity.WechatMetaData;
import com.jeecg.api.sdk.WechatConstants;
import com.jeecg.api.sdk.WechatSdk;
import com.jeecg.api.util.HttpClientUtil;

import net.sf.json.JSONObject;

public class WechatPayAdaptor {
	
	protected final static BigDecimal BigDecimal_100 = new BigDecimal(100) ;
	
	private static final Logger logger = Logger.getLogger(WechatPayAdaptor.class);
	
	private WechatMetaData getBaseWechatMetaData() {

		PropertiesUtil util = new PropertiesUtil("wechat.properties");

		WechatMetaData metaData = new WechatMetaData();

		metaData.setAppid(util.readProperty("wechat.app.id")); //appId
		metaData.setMch_id(util.readProperty("wechat.receiver.merchant.id")); //商户号
		metaData.setOut_trade_no(UUID.randomUUID().toString()); //订单号-可以理解位本系统自己的订单号
		
		metaData.setNonce_str(WechatSdk.genRondomString());//生成32位随机数
		
		return metaData ;
	}
	
	
	public ThirdPartyPaymentResult pay(String reqDatagram) throws Exception {
		ThirdPartyPaymentResult result = new ThirdPartyPaymentResult() ;
		PropertiesUtil util = new PropertiesUtil("wechat.properties");
		//预支付地址
		byte[] responseData = HttpClientUtil.httpsPost(util.readProperty("wechat.pre.payment.address"), reqDatagram);
		result.setRetDatagram(new String(responseData));
		WechatMetaData metaData = WechatSdk.parseXml(responseData);
		if ("SUCCESS".equals(metaData.getReturn_code()) && "SUCCESS".equals(metaData.getResult_code())) {
			if (WechatConstants.TRADE_TYPE_APP.equals(metaData.getTrade_type())) {
				result.setJumpType(JumpTypeEnum.JSON);
				JSONObject chooseWXPayJsonObject = new JSONObject();
				String timeStamp = WechatSdk.genTimeStamp();
				chooseWXPayJsonObject.put("appid", metaData.getAppid());
				chooseWXPayJsonObject.put("partnerid", metaData.getMch_id());
				chooseWXPayJsonObject.put("prepayid", metaData.getPrepay_id());
				chooseWXPayJsonObject.put("noncestr", WechatSdk.genRondomString());
				chooseWXPayJsonObject.put("timestamp", timeStamp);
				chooseWXPayJsonObject.put("package", "Sign=WXPay");
				chooseWXPayJsonObject.put("sign",
						WechatSdk.signByMD5(chooseWXPayJsonObject, util.readProperty("wechat.transaction.password")));//源码
				logger.info("chooseWXPayJsonObject: " + chooseWXPayJsonObject.toString());
				result.setJumpString(chooseWXPayJsonObject.toString());
				result.setMessage("wechat app 统一下单成功");
			} else {
				logger.warn("No QR-Code Generate, meta data ret is:\n" + JSONUtils.toJSONString(metaData));
			}
			result.setBizResult(BizResultEnum.UNKNOW);
		} else {
			result.setBizResult(BizResultEnum.FAILURE);
			result.setMessage("统一下单请求错误");
			if (metaData.getErr_code() == null) {
				result.setRetCode(metaData.getReturn_code());
				result.setRetMemo(metaData.getReturn_msg());
			} else {
				result.setRetCode(metaData.getErr_code());
				result.setRetMemo(metaData.getErr_code_des());
			}
		}
		return result ;
	}
	
	
	public ThirdPartyPaymentResult parsePayResult(String data) throws Exception {
		ThirdPartyPaymentResult result = new ThirdPartyPaymentResult() ;
		PropertiesUtil util = new PropertiesUtil("wechat.properties");
		byte[] responseData = data.getBytes("UTF-8");

		WechatMetaData metaData = WechatSdk.parseXml(responseData);
		
		String merchantId = metaData.getMch_id() ;
//		WechatSdk.validateByMD5(metaData, this.getAuthentication(merchantId).getKey());
		//商户密钥
		WechatSdk.validateByMD5(metaData, util.readProperty("wechat.merchant.secretkey"));
		
		//result.setMerId(metaData.getMch_id());
		result.setTranNo(metaData.getOut_trade_no());
		result.setTranRetQryid(metaData.getTransaction_id());

		if ("SUCCESS".equals(metaData.getReturn_code())
				&& "SUCCESS".equals(metaData.getResult_code())) {
			BigInteger settlementTotalFee = metaData.getSettlement_total_fee();
			if (settlementTotalFee != null) {
				BigInteger couponAmt = metaData.getTotal_fee().subtract(settlementTotalFee) ;
				result.setCouponAmt(new BigDecimal(couponAmt).divide(new BigDecimal(100)).setScale(2, RoundingMode.HALF_UP));
			}
			result.setBizResult(BizResultEnum.SUCCESS);
			result.setMessage("支付成功");

		} else {
			result.setBizResult(BizResultEnum.FAILURE);
			result.setMessage("支付失败");
		}
		result.setRetCode(metaData.getReturn_code());
		result.setRetMemo(metaData.getReturn_msg());

		//commonPayResult.setAmt(metaData.getTotal_fee());
		//commonPayResult.setReqReserved(metaData.getAttach());
		result.setAck("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>");
		//commonPayResult.setExecResult(ExecResultEnum.OK);

		return result;
	}
	
	
	
	public static ThirdPartyPaymentResult query(String reqDatagram) throws Exception {
		
		ThirdPartyPaymentResult result = new ThirdPartyPaymentResult() ;
		PropertiesUtil util = new PropertiesUtil("wechat.properties");
//		byte[] responseData = HttpClientUtil.httpsPost(this.getProperty("wechatPay.standard.orderQueryUrl"), reqDatagram);
		//查询订单
		byte[] responseData = HttpClientUtil.httpsPost(util.readProperty("wechat.query.address"), reqDatagram);
		result.setRetDatagram(new String(responseData));
		
		WechatMetaData metaData = WechatSdk.parseXml(responseData);
		result.setTranRetQryid(metaData.getTransaction_id());

		if ("SUCCESS".equals(metaData.getReturn_code())) {
			if ("SUCCESS".equals(metaData.getResult_code())) {
				String trade_state = metaData.getTrade_state();
				if (WechatConstants.TRADE_STATE_SUCCESS.equals(trade_state)
						|| WechatConstants.TRADE_STATE_REFUND.equals(trade_state)) {
					BigInteger settlementTotalFee = metaData.getSettlement_total_fee();
					if (settlementTotalFee != null) {
						BigInteger couponAmt = metaData.getTotal_fee().subtract(settlementTotalFee) ;
						result.setCouponAmt(new BigDecimal(couponAmt).divide(new BigDecimal(100)));
					}
					result.setBizResult(BizResultEnum.SUCCESS);
					result.setMessage("支付成功");
				} else if (WechatConstants.TRADE_STATE_CLOSED.equals(trade_state)
						|| WechatConstants.TRADE_STATE_PAYERROR.equals(trade_state)
						|| WechatConstants.TRADE_STATE_REVOKED.equals(trade_state)) {// 曾亮亮的原代码 无 TRADE_STATE_REVOKED状态
					result.setBizResult(BizResultEnum.FAILURE);
					result.setMessage("支付失败");
				} else if (WechatConstants.TRADE_STATE_USERPAYING.equals(trade_state)
						|| WechatConstants.TRADE_STATE_NOTPAY.equals(trade_state)) {
					result.setBizResult(BizResultEnum.UNKNOW);
					result.setMessage("支付未明");
				}
				result.setRetCode(trade_state);
				result.setRetMemo(metaData.getTrade_state_desc());
			} else {
				result.setBizResult(BizResultEnum.UNKNOW);
				result.setMessage("支付失败");
				result.setRetCode(metaData.getErr_code());
				result.setRetMemo(metaData.getErr_code_des());
			}
		} else {
			result.setBizResult(BizResultEnum.UNKNOW);
			result.setMessage("支付未明");
			result.setRetCode(metaData.getReturn_code());
			result.setRetMemo(metaData.getReturn_msg());
		}
		return result ;
	}
	
	public static ThirdPartyPaymentResult refund(String reqDatagram) throws Exception{
		ThirdPartyPaymentResult result = new ThirdPartyPaymentResult();
		PropertiesUtil util = new PropertiesUtil("wechat.properties");
		//查询订单
		byte[] responseData = HttpClientUtil.httpsPost(util.readProperty("wechat.query.address"), reqDatagram);
		result.setRetDatagram(new String(responseData));
		
		WechatMetaData metaData = WechatSdk.parseXml(responseData);
		result.setTranRetQryid(metaData.getTransaction_id());
		if("SUCCESS".equals(metaData.getReturn_code())){
			
		}
		
		return result;
	}
	
	protected KeyStore getPublicKeyStore() throws KeyStoreException, NoSuchAlgorithmException,
		CertificateException, IOException {
		Authentication authentication = new Authentication();
		KeyStore keyStore = KeyStore.getInstance("JKS");
		keyStore.load(null);
		keyStore.setCertificateEntry("tenpay", authentication.getCertificate());
		return keyStore;
	}

}
