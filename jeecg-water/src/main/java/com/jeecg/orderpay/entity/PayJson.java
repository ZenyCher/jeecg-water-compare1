package com.jeecg.orderpay.entity;

/**
 * 支付返回json
 * @author 15283
 *
 */
public class PayJson {
	
	private String orderId;
	private Boolean success = true;
	private String msg;
	private String payId;
	private String appId;
	private String mch_id;//商户号
	
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getPayId() {
		return payId;
	}
	public void setPayId(String payId) {
		this.payId = payId;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	@Override
	public String toString() {
		return "[orderId=" + orderId + ", success=" + success + ", msg="
				+ msg + ", payId=" + payId + ", appId=" + appId + ", mch_id="
				+ mch_id + "]";
	}
	
}
