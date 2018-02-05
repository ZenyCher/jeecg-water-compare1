package com.jeecg.api.sdk;

public class WechatConstants {
	


	/**交易类型:原生扫码支付*/
	public final static String TRADE_TYPE_NATIVE = "NATIVE";
	/**交易类型:公众号支付*/
	public final static String TRADE_TYPE_JSAPI = "JSAPI";
	/**交易类型:app支付*/
	public final static String TRADE_TYPE_APP = "APP";
	/**交易类型:刷卡支付*/
	public final static String TRADE_TYPE_MICROPAY = "MICROPAY";

	/**设备信息:PC网页或公众号内支付*/
	public final static String DEVICE_INFO_WEB = "WEB";

	/**指定支付方式:不允许使用信用卡*/
	public final static String LIMIT_PAY_NO_CREDIT = "no_credit";

	/**支付成功*/
	public final static String TRADE_STATE_SUCCESS = "SUCCESS";
	/**转入退款*/
	public final static String TRADE_STATE_REFUND = "REFUND";
	/**未支付*/
	public final static String TRADE_STATE_NOTPAY = "NOTPAY";
	/**已关闭*/
	public final static String TRADE_STATE_CLOSED = "CLOSED";
	/**已撤销（刷卡支付）*/
	public final static String TRADE_STATE_REVOKED = "REVOKED";
	/**用户支付中*/
	public final static String TRADE_STATE_USERPAYING = "USERPAYING";
	/**支付失败(其他原因，如银行返回失败)*/
	public final static String TRADE_STATE_PAYERROR = "PAYERROR";
	
	
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	public static String partner = "";
	
	// 收款支付宝账号，一般情况下收款账号就是签约账号
	public static String seller_email = "";
	// 商户的私钥
	public static String key = "";

	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
	
	// 签名方式 不需修改
	public static String sign_type = "MD5";
	
	//微信支付
	public final static String wx_pay = "WECHAT";
	//支付宝支付
	public final static String alipay = "ALIPAY";
	//交易类型 押金缴纳
	public final static String DEPOSIT = "deposit";
	//交易类型 水表充值
	public final static String RECHARGE = "recharge";
	//交易类型 设备购买
	public final static String BUYPURCHASE = "buyPurchase"; 


}
