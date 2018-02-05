package com.jeecg.orderpay.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 订单表
 * @author onlineGenerator
 * @date 2017-07-23 14:29:11
 * @version V1.0   
 *
 */
@Entity
@Table(name = "w_order_pay", schema = "")
@SuppressWarnings("serial")
public class WOrderPayEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**商品id*/
	private java.lang.String goodsId;
	/**商品信息*/
	private java.lang.String goodsInfo;
	/**商品数量*/
	private java.lang.Integer goodsNumber;
	/**内部订单号*/
	private java.lang.String outTradeNo;
	/**微信订单号*/
	private java.lang.String transactionId;
	/**支付方式*/
	private java.lang.String payType;
	/**下单时间*/
	private java.util.Date orderDate;
	/**返回状态码*/
	private java.lang.String returnCode;
	/**返回信息*/
	private java.lang.String returnMsg;
	/**订单金额*/
	private java.lang.Integer settlementTotalFee;
	/**更新日期*/
	private java.util.Date updateDate;
	/**预支付编号*/
	private java.lang.String prepayId;
	/**水表编号*/
	private java.lang.String waterId;
	/**会员联系方式*/
	private java.lang.String member_phone;
	/**交易类型**/
	private java.lang.String transactionType;
	/**收货地址**/
	private java.lang.String address;
	/**收件人**/
	private java.lang.String receiver;
	/**收件人联系方式**/
	private java.lang.String receiverMobile;
	/**会员id**/
	private java.lang.String memberId;
	/**支付宝账户id**/
	private java.lang.String sellerId;
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品Id
	 */
	@Column(name ="GOODS_ID",nullable=true,length=36)
	public java.lang.String getGoodsId() {
		return goodsId;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品Id
	 */
	public void setGoodsId(java.lang.String goodsId) {
		this.goodsId = goodsId;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品信息
	 */
	@Column(name ="GOODS_INFO",nullable=true,length=100)
	public java.lang.String getGoodsInfo(){
		return this.goodsInfo;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品信息
	 */
	public void setGoodsInfo(java.lang.String goodsInfo){
		this.goodsInfo = goodsInfo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  商品数量
	 */
	@Column(name ="GOODS_NUMBER",nullable=true,length=5)
	public java.lang.Integer getGoodsNumber() {
		return goodsNumber;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  商品数量
	 */
	public void setGoodsNumber(java.lang.Integer goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  内部订单号
	 */
	@Column(name ="OUT_TRADE_NO",nullable=true,length=32)
	public java.lang.String getOutTradeNo(){
		return this.outTradeNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  内部订单号
	 */
	public void setOutTradeNo(java.lang.String outTradeNo){
		this.outTradeNo = outTradeNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  微信订单号
	 */
	@Column(name ="TRANSACTION_ID",nullable=true,length=32)
	public java.lang.String getTransactionId(){
		return this.transactionId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  微信订单号
	 */
	public void setTransactionId(java.lang.String transactionId){
		this.transactionId = transactionId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  支付方式
	 */
	@Column(name ="PAY_TYPE",nullable=true,length=32)
	public java.lang.String getPayType(){
		return this.payType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  支付方式
	 */
	public void setPayType(java.lang.String payType){
		this.payType = payType;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  下单时间
	 */
	@Column(name ="ORDER_DATE",nullable=true,length=20)
	public java.util.Date getOrderDate(){
		return this.orderDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  下单时间
	 */
	public void setOrderDate(java.util.Date orderDate){
		this.orderDate = orderDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  返回状态码
	 */
	@Column(name ="RETURN_CODE",nullable=true,length=50)
	public java.lang.String getReturnCode(){
		return this.returnCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  返回状态码
	 */
	public void setReturnCode(java.lang.String returnCode){
		this.returnCode = returnCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  返回信息
	 */
	@Column(name ="RETURN_MSG",nullable=true,length=50)
	public java.lang.String getReturnMsg(){
		return this.returnMsg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  返回信息
	 */
	public void setReturnMsg(java.lang.String returnMsg){
		this.returnMsg = returnMsg;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  订单金额
	 */
	@Column(name ="SETTLEMENT_TOTAL_FEE",nullable=true,length=20)
	public java.lang.Integer getSettlementTotalFee(){
		return this.settlementTotalFee;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  订单金额
	 */
	public void setSettlementTotalFee(java.lang.Integer settlementTotalFee){
		this.settlementTotalFee = settlementTotalFee;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */
	@Column(name ="UPDATE_DATE",nullable=true,length=20)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  预支付编号
	 */
	@Column(name ="PREPAY_ID",nullable=true,length=32)
	public java.lang.String getPrepayId(){
		return this.prepayId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  预支付编号
	 */
	public void setPrepayId(java.lang.String prepayId){
		this.prepayId = prepayId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  预支付编号
	 */
	@Column(name ="waterId",nullable=true,length=36)
	public java.lang.String getWaterId(){
		return this.waterId;
	}
	@Column(name="address",nullable=true,length=500)
	public java.lang.String getAddress(){
		return this.address;
	}
	
	public void setAddress(java.lang.String address){
		this.address = address;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  预支付编号
	 */
	public void setWaterId(java.lang.String waterId){
		this.waterId = waterId;
	}

	@Column(name ="member_phone",nullable=true,length=11)
	public java.lang.String getMember_phone() {
		return this.member_phone;
	}

	public void setMember_phone(java.lang.String member_phone) {
		this.member_phone = member_phone;
	}

	@Column(name = "transaction_type",nullable=true,length=36)
	public java.lang.String getTransaction_type() {
		return transactionType;
	}

	public void setTransaction_type(java.lang.String transactionType) {
		this.transactionType = transactionType;
	}
	@Column(name="receiverMobile",nullable=true,length=50)
	public java.lang.String getReceiverMobile() {
		return receiverMobile;
	}

	public void setReceiverMobile(java.lang.String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}
	@Column(name="receiver",nullable=true,length=200)
	public java.lang.String getReceiver() {
		return receiver;
	}

	public void setReceiver(java.lang.String receiver) {
		this.receiver = receiver;
	}
	@Column(name="memberId",nullable=true,length=36)
	public java.lang.String getMemberId() {
		return memberId;
	}
	
	public void setmemberId(java.lang.String memberId) {
		this.memberId = memberId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  支付宝用户id
	 */
	@Column(name ="sellerId",nullable=true,length=50)
	public java.lang.String getSellerId() {
		return sellerId;
	}

	public void setSellerId(java.lang.String sellerId) {
		this.sellerId = sellerId;
	}

	@Override
	public String toString() {
		return "WOrderPayEntity [id=" + id + ", goodsId=" + goodsId + ", goodsInfo=" + goodsInfo + ", goodsNumber="
				+ goodsNumber + ", outTradeNo=" + outTradeNo + ", transactionId=" + transactionId + ", payType="
				+ payType + ", orderDate=" + orderDate + ", returnCode=" + returnCode + ", returnMsg=" + returnMsg
				+ ", settlementTotalFee=" + settlementTotalFee + ", updateDate=" + updateDate + ", prepayId=" + prepayId
				+ ", waterId=" + waterId + ", member_phone=" + member_phone + ", transactionType=" + transactionType
				+ ", address=" + address + ", receiver=" + receiver + ", receiverMobile=" + receiverMobile
				+ ", memberId=" + memberId + "]";
	}
	
}
