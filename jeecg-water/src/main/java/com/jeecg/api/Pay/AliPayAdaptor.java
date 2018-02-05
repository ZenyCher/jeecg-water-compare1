package com.jeecg.api.Pay;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.jeecgframework.core.util.PropertiesUtil;

import com.alibaba.druid.support.json.JSONUtils;
import com.jeecg.api.bizEnum.BizResultEnum;
import com.jeecg.api.bizEnum.JumpTypeEnum;
import com.jeecg.api.entity.AliPayResult;
import com.jeecg.api.entity.WechatMetaData;
import com.jeecg.api.sdk.WechatConstants;
import com.jeecg.api.sdk.WechatSdk;
import com.jeecg.api.util.HttpClientUtil;

import net.sf.json.JSONObject;

public class AliPayAdaptor {

	
	protected final static BigDecimal BigDecimal_100 = new BigDecimal(100) ;
	
	private static final Logger logger = Logger.getLogger(AliPayAdaptor.class);
	
	
	public static AliPayResult aliPay(String reqDatagram) throws Exception {
		
		AliPayResult result = new AliPayResult() ;
		PropertiesUtil util = new PropertiesUtil("wechat.properties");
		//commonPayResult.setRequestTraceData(datagram);
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
				result.setCode(metaData.getReturn_code());
				result.setMsg(metaData.getReturn_msg());
			} else {
				result.setCode(metaData.getErr_code());
				result.setMsg(metaData.getErr_code_des());
			}
		}
		return result ;
	}
	
}
