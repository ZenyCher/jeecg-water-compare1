package com.jeecg.api.sdk;

import org.jeecgframework.core.util.PropertiesUtil;

public interface WechatString {
	
	PropertiesUtil util = new PropertiesUtil("wechat.properties");
	
	public static final String PAYMENT_ADDRESS = util.readProperty("wechat.pre.payment.address");
	
	public static final String TRANSACTION_PASSWORD = util.readProperty("wechat.transaction.password");
	
	public static final String MERCHANT_SECREKEY = util.readProperty("wechat.merchant.secretkey");
	
	public static final String QUERY_ADDRESS = util.readProperty("wechat.query.address");
}
