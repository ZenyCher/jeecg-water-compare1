package com.jeecg.api.sdk;

import org.jeecgframework.core.util.PropertiesUtil;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;

public class AliPaySDK {

	public static void main(String[] args) {
		System.out.println(doOrder("1","12312312","123131","1231231313"));
	}

	public static String doOrder(String totalAmount, String body, String subject, String orderId) {
		PropertiesUtil util = new PropertiesUtil("wechat.properties");
		AlipayClient alipayClient = new DefaultAlipayClient(util.readProperty("ALIPAY_ORDER_URL"), util.readProperty("ALIPAY_APPID"),
				util.readProperty("APP_PRIVATE_KEY"), "json", "UTF-8", util.readProperty("ALIPAY_PUBLIC_KEY"), "RSA2");

		// 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
		AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
		// SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		model.setBody(body);// 描述信息
		model.setSubject(subject);// 商品的标题/交易标题/订单标题/订单关键字等
		model.setOutTradeNo(orderId);
		model.setTimeoutExpress("30m");
		model.setTotalAmount(totalAmount);
		model.setProductCode("QUICK_MSECURITY_PAY");// 固定值
		request.setBizModel(model);
		request.setNotifyUrl(util.readProperty("ALIPAY_CALLBACK_URL"));
		try {
			// 这里和普通的接口调用不同，使用的是sdkExecute
			AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
//			System.out.println(response.getBody());// 就是orderString
													// 可以直接给客户端请求，无需再做处理。
			if(response.isSuccess()){
				return response.getBody();
			}
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void testDoOrder() {
		String TESTURL = "https://openapi.alipaydev.com/gateway.do";
		String URL = "https://openapi.alipay.com/gateway.do";
		PropertiesUtil util = new PropertiesUtil("wechat.properties");
		String APP_ID = util.readProperty("ALIPAY_APPID");
		String APP_PRIVATE_KEY =  util.readProperty("APP_PRIVATE_KEY");
		String ALIPAY_PUBLIC_KEY =  util.readProperty("ALIPAY_PUBLIC_KEY");
		AlipayClient alipayClient = new DefaultAlipayClient(TESTURL, APP_ID,
				APP_PRIVATE_KEY, "json", "UTF-8", ALIPAY_PUBLIC_KEY, "RSA2");

		// 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
		AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
		// SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		model.setBody("我是测试数据");
		model.setSubject("App支付测试Java");
		model.setOutTradeNo(WechatSdk.genRondomString());
		model.setTimeoutExpress("30m");
		model.setTotalAmount("0.01");
		model.setProductCode("QUICK_MSECURITY_PAY");// 固定值
		request.setBizModel(model);
		request.setNotifyUrl("商户外网可以访问的异步地址");
		try {
			// 这里和普通的接口调用不同，使用的是sdkExecute
			AlipayTradeAppPayResponse response = alipayClient
					.sdkExecute(request);
			System.out.println(response.getBody());// 就是orderString
													// 可以直接给客户端请求，无需再做处理。
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}

	}
}
