package com.jeecg.api.entity;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

import com.jeecg.api.bizEnum.BizResultEnum;
import com.jeecg.api.bizEnum.JumpTypeEnum;

@XmlRootElement(name = "xml")
public class ThirdPartyPaymentResult {
	


	/**业务结果*/
	private BizResultEnum bizResult;
	
	private String message ;

	/** 由于一个业务，可能涉及多个tran detail使用同一个tran no */
	private String paymentType ;
	
	/**交易流水*/
	private String tranNo;

	private String tranRetQryid;

	private String retBankCode;

	private String retBankcardNo;
	
	private String ackReqTranNo ;
	
	/**响应码*/
	private String retCode;
	/**响应描述*/
	private String retMemo;
	
	/** 前台跳转類型 */
	private JumpTypeEnum jumpType;
	/** 前台跳转字符串 */
	private String jumpString;
	
	/** 请求报文 */
	private String reqDatagram;
	private String retDatagram;

	/**
	 * 立减券金额
	 */
	private BigDecimal couponAmt;

	
	/** 用于结果接收后的应答，由adaptor决定应答的类型及具体报文 */
	private Object ack ;
	
	public BizResultEnum getAckCheckedStatus() {
		return bizResult;
	}
	public void setBizResult(BizResultEnum bizResult) {
		this.bizResult = bizResult;
	}
	public String getRetCode() {
		return retCode;
	}
	public void setRetCode(String respCode) {
		this.retCode = respCode;
	}
	public String getRetMemo() {
		return retMemo;
	}
	public void setRetMemo(String respMsg) {
		this.retMemo = respMsg;
	}
	public JumpTypeEnum getJumpType() {
		return jumpType;
	}
	public void setJumpType(JumpTypeEnum jumpType) {
		this.jumpType = jumpType;
	}
	public String getJumpString() {
		return jumpString;
	}
	public void setJumpString(String jumpString) {
		this.jumpString = jumpString;
	}

	public Object getAck() {
		return ack;
	}
	public void setAck(Object ack) {
		this.ack = ack;
	}
	public String getTranNo() {
		return tranNo;
	}
	public void setTranNo(String tranNo) {
		this.tranNo = tranNo;
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
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getTranRetQryid() {
		return tranRetQryid;
	}
	
	public void setTranRetQryid(String tranRetQryid) {
		this.tranRetQryid = tranRetQryid;
	}
	
	public String getRetBankcardNo() {
		return retBankcardNo;
	}
	
	public void setRetBankcardNo(String retBankcardNo) {
		this.retBankcardNo = retBankcardNo;
	}
	
	public String getRetBankCode() {
		return retBankCode;
	}
	
	public void setRetBankCode(String retBankCode) {
		this.retBankCode = retBankCode;
	}
	
	public String getAckReqTranNo() {
		return ackReqTranNo;
	}
	
	public void setAckReqTranNo(String ackReqTranNo) {
		this.ackReqTranNo = ackReqTranNo;
	}

	public BigDecimal getCouponAmt() {
		return couponAmt;
	}

	public void setCouponAmt(BigDecimal couponAmt) {
		this.couponAmt = couponAmt;
	}


}
