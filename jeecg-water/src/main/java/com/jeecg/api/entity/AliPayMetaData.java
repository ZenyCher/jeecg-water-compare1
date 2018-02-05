package com.jeecg.api.entity;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.mail.imap.protocol.BODY;
/**
 * 支付宝xml信息
 * @author wangxufu
 *
 */
@XmlRootElement(name = "xml")
public class AliPayMetaData {

	/**公众账号ID*/
	private String app_id;
	/**接口名称*/
	private String method;
	/**仅支持json*/
	private String format;
	/**编码*/
	private String charset;
	/**商户生成签名字符串所用的签名算法类型，仅支持RSA2和RSA*/
	private String sign_type;
	/**商户请求参数的签名*/
	private String sign;
	/**发送请求事件*/
	private String timestamp;
	/**条用的接口版本，固定为1.0*/
	private String version;
	/**支付宝服务器主动通知商户服务器黎制定的页面路径，http/https*/
	private String notify_url;
	/**授权*/
	private String app_auth_token;
	/**请求参数的集合*/
	private List<Map<String, Object>> biz_content;
	
	/**以上是公共请求参数*/
	/**下面是请求参数*/
	/**商户订单号*/
	private String out_trade_no;
	/**支付场景 如条码支付等*/
	private String scene;
	/**支付授权码*/
	private String auth_code;
	/**销售产品码*/
	private String product_code;
	/**订单标题*/
	private String subject;
	/**买家的支付宝用户id，如果为空，会重传入了码值的信息中获取买家id*/
	private String buyer_id;
	/**可为空，默认商户签约账号对应的支付宝用户id*/
	private String seller_id;
	/**订单总金额*/
	private BigInteger total_amount;
	/**参与优惠计算金额*/
	private BigInteger discountable_amount;
	/**不参与优惠计算的金额*/
	private BigInteger undiscountable_amount;
	/**订单描述,在次订单描述中详细内容并没有填写，但是在实际情况中可json传入传出*/
	private String body;
	
	
	public String getApp_id() {
		return app_id;
	}
	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getCharset() {
		return charset;
	}
	public void setCharset(String charset) {
		this.charset = charset;
	}
	public String getSign_type() {
		return sign_type;
	}
	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String string) {
		this.timestamp = string;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getNotify_url() {
		return notify_url;
	}
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
	public String getApp_auth_token() {
		return app_auth_token;
	}
	public void setApp_auth_token(String app_auth_token) {
		this.app_auth_token = app_auth_token;
	}
	
	public List<Map<String, Object>> getBiz_content() {
		return biz_content;
	}
	public void setBiz_content(List<Map<String, Object>> biz_content) {
		this.biz_content = biz_content;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getScene() {
		return scene;
	}
	public void setScene(String scene) {
		this.scene = scene;
	}
	public String getAuth_code() {
		return auth_code;
	}
	public void setAuth_code(String auth_code) {
		this.auth_code = auth_code;
	}
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}
	public String getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}
	public BigInteger getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(BigInteger total_amount) {
		this.total_amount = total_amount;
	}
	public BigInteger getDiscountable_amount() {
		return discountable_amount;
	}
	public void setDiscountable_amount(BigInteger discountable_amount) {
		this.discountable_amount = discountable_amount;
	}
	public BigInteger getUndiscountable_amount() {
		return undiscountable_amount;
	}
	public void setUndiscountable_amount(BigInteger undiscountable_amount) {
		this.undiscountable_amount = undiscountable_amount;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getOperator_id() {
		return operator_id;
	}
	public void setOperator_id(String operator_id) {
		this.operator_id = operator_id;
	}
	public String getStore_id() {
		return store_id;
	}
	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}
	public String getTerminal_id() {
		return terminal_id;
	}
	public void setTerminal_id(String terminal_id) {
		this.terminal_id = terminal_id;
	}
	public String getAlipay_store_id() {
		return alipay_store_id;
	}
	public void setAlipay_store_id(String alipay_store_id) {
		this.alipay_store_id = alipay_store_id;
	}
	public String getTimeout_express() {
		return timeout_express;
	}
	public void setTimeout_express(String timeout_express) {
		this.timeout_express = timeout_express;
	}
	public String getRoyalty_info() {
		return royalty_info;
	}
	public void setRoyalty_info(String royalty_info) {
		this.royalty_info = royalty_info;
	}
	public String getSub_merchant() {
		return sub_merchant;
	}
	public void setSub_merchant(String sub_merchant) {
		this.sub_merchant = sub_merchant;
	}
	public String getFee_type() {
		return fee_type;
	}
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}
	public BigInteger getRefund_fee() {
		return refund_fee;
	}
	public void setRefund_fee(BigInteger refund_fee) {
		this.refund_fee = refund_fee;
	}
	public String getTime_start() {
		return time_start;
	}
	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}
	public String getTime_expire() {
		return time_expire;
	}
	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}
	public String getLimit_pay() {
		return limit_pay;
	}
	public void setLimit_pay(String limit_pay) {
		this.limit_pay = limit_pay;
	}
	public String getErr_code() {
		return err_code;
	}
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
	public String getErr_code_des() {
		return err_code_des;
	}
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}
	/**商户操作员编号*/
	private String operator_id;
	/**商户门店编号*/
	private String store_id;
	/**商户机终端编号*/
	private String terminal_id;
	/**支付宝的店铺编号*/
	private String alipay_store_id;
	/**该笔订单允许的最晚付款时间，预期将关闭交易，不接受小数点*/
	private String timeout_express;
	/**描述分账信息*/
	private String royalty_info;
	/**间连受理商户信息体，针对特殊银行*/
	private String sub_merchant;
	
	/**货币类型*/
	private String fee_type;
	/**退款金额*/
	private BigInteger refund_fee ;
	/**交易起始时间*/
	private String time_start;
	/**交易结束时间*/
	private String time_expire;
	/**指定支付方式*/
	private String limit_pay;
	/**错误代码*/
	private String err_code;
	/**错误代码描述*/
	private String err_code_des;
	
}
