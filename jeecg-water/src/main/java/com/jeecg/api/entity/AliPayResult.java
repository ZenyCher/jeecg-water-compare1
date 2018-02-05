package com.jeecg.api.entity;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.jeecg.api.bizEnum.BizResultEnum;
import com.jeecg.api.bizEnum.JumpTypeEnum;



public class AliPayResult {
	
	/**以下是公共响应参数*/
	/**返回状态码*/
	private String code;
	/**返回信息,网关返回码描述*/
	private String msg;
	/** 请求报文 */
	private String reqDatagram;
	private String retDatagram;
	/** 前台跳转類型 */
	private JumpTypeEnum jumpType;
	/** 前台跳转字符串 */
	private String jumpString;
	private String message ;
	/**业务结果*/
	private BizResultEnum bizResult;
	
	public BizResultEnum getBizResult() {
		return bizResult;
	}
	public void setBizResult(BizResultEnum bizResult) {
		this.bizResult = bizResult;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getJumpString() {
		return jumpString;
	}
	public void setJumpString(String jumpString) {
		this.jumpString = jumpString;
	}
	public JumpTypeEnum getJumpType() {
		return jumpType;
	}
	public void setJumpType(JumpTypeEnum jumpType) {
		this.jumpType = jumpType;
	}
	public String getReqDatagram() {
		return reqDatagram;
	}
	public void setReqDatagram(String reqDatagram) {
		this.reqDatagram = reqDatagram;
	}
	public String getRetDatagram() {
		return retDatagram;
	}
	public void setRetDatagram(String retDatagram) {
		this.retDatagram = retDatagram;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getSub_code() {
		return sub_code;
	}
	public void setSub_code(String sub_code) {
		this.sub_code = sub_code;
	}
	public String getSub_msg() {
		return sub_msg;
	}
	public void setSub_msg(String sub_msg) {
		this.sub_msg = sub_msg;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getTrade_no() {
		return trade_no;
	}
	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getBuyer_login_id() {
		return buyer_login_id;
	}
	public void setBuyer_login_id(String buyer_login_id) {
		this.buyer_login_id = buyer_login_id;
	}
	public String getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}
	public String getReceipt_amount() {
		return receipt_amount;
	}
	public void setReceipt_amount(String receipt_amount) {
		this.receipt_amount = receipt_amount;
	}
	public BigInteger getBuyer_pay_amount() {
		return buyer_pay_amount;
	}
	public void setBuyer_pay_amount(BigInteger buyer_pay_amount) {
		this.buyer_pay_amount = buyer_pay_amount;
	}
	public BigInteger getPoint_amount() {
		return point_amount;
	}
	public void setPoint_amount(BigInteger point_amount) {
		this.point_amount = point_amount;
	}
	public BigInteger getInvoice_amount() {
		return invoice_amount;
	}
	public void setInvoice_amount(BigInteger invoice_amount) {
		this.invoice_amount = invoice_amount;
	}
	public Date getGmt_payment() {
		return gmt_payment;
	}
	public void setGmt_payment(Date gmt_payment) {
		this.gmt_payment = gmt_payment;
	}
	public BigInteger getCard_balance() {
		return card_balance;
	}
	public void setCard_balance(BigInteger card_balance) {
		this.card_balance = card_balance;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public String getBuyer_user_id() {
		return buyer_user_id;
	}
	public void setBuyer_user_id(String buyer_user_id) {
		this.buyer_user_id = buyer_user_id;
	}
	public String getDiscount_goods_detail() {
		return discount_goods_detail;
	}
	public void setDiscount_goods_detail(String discount_goods_detail) {
		this.discount_goods_detail = discount_goods_detail;
	}

	public List<Map<String, Object>> getFund_bil_list() {
		return fund_bil_list;
	}
	public void setFund_bil_list(List<Map<String, Object>> fund_bil_list) {
		this.fund_bil_list = fund_bil_list;
	}
	public List<Map<String, Object>> getVoucher_detail_list() {
		return voucher_detail_list;
	}
	public void setVoucher_detail_list(List<Map<String, Object>> voucher_detail_list) {
		this.voucher_detail_list = voucher_detail_list;
	}

	/**业务返回码*/
	private String sub_code;
	/**业务返回码描述*/
	private String sub_msg;
	/**签名*/
	private String sign;
	
	/**以下是响应参数*/
	/**支付宝交易号*/
	private String trade_no;
	/**商户订单号*/
	private String out_trade_no;
	/**买家支付宝账号*/
	private String buyer_login_id;
	/**交易金额*/
	private String total_amount;
	/**实收金额*/
	private String  receipt_amount;
	/**买家付款的金额*/
	private BigInteger buyer_pay_amount;
	/**使用积分宝付款的金额*/
	private BigInteger point_amount;
	/**交易中可给用户开具发票的金额*/
	private BigInteger invoice_amount;
	/**交易支付时间*/
	private Date gmt_payment;
	/**交易支付使用的资金聚到*/
	private List<Map<String, Object>> fund_bil_list;
	/**支付宝卡余额*/
	private BigInteger card_balance;
	/**发生支付交易的商户门店名称*/
	private String store_name;
	/**买家在支付宝的用户id*/
	private String buyer_user_id;
	/**本次交易支付所使用的单品卷优惠的商品优惠信息*/
	private String discount_goods_detail;
	/**本交易支付时使用的所有优惠券信息*/
	private List<Map<String, Object>> voucher_detail_list;

}
