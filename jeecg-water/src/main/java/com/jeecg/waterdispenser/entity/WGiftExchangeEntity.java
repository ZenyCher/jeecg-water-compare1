package com.jeecg.waterdispenser.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 礼品兑换表
 * @author onlineGenerator
 * @date 2017-06-29 20:46:13
 * @version V1.0   
 *
 */
@Entity
@Table(name = "w_gift_exchange", schema = "")
@SuppressWarnings("serial")
public class WGiftExchangeEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**更新日期*/
	private java.util.Date updateDate;
	/**所属部门*/
	private java.lang.String sysOrgCode;
	/**所属公司*/
	private java.lang.String sysCompanyCode;
	/**流程状态*/
	private java.lang.String bpmStatus;
	/**礼品id*/
	private java.lang.String giftId;
	/**单号*/
	@Excel(name="单号")
	private java.lang.String giftexchangeOrder;
	/**处理状态*/
	@Excel(name="处理状态")
	private java.lang.String giftexchangeState;
	/**处理人*/
	@Excel(name="处理人")
	private java.lang.String giftexchangeHandle;
	/**礼品名称*/
	@Excel(name="礼品名称")
	private java.lang.String giftName;
	/**礼品数量*/
	@Excel(name="礼品数量")
	private java.lang.String giftexchangeNumber;
	/**兑换时间*/
	@Excel(name="兑换时间",format = "yyyy-MM-dd")
	private java.util.Date giftexchangeTime;
	/**收货人*/
	@Excel(name="收货人")
	private java.lang.String giftexchangeConsignee;
	/**联系方式*/
	@Excel(name="联系方式")
	private java.lang.String giftexchangePhone;
	/**收货地址*/
	@Excel(name="收货地址")
	private java.lang.String giftexchangeAddress;
	/**快递公司*/
	@Excel(name="快递公司")
	private java.lang.String giftexchangeExpress;
	/**快递单号*/
	@Excel(name="快递单号")
	private java.lang.String giftexchangeCouriernumber;
	/**经办人*/
	@Excel(name="经办人")
	private java.lang.String giftexchangeOperator;
	/**快递费*/
	@Excel(name="快递费")
	private java.lang.String giftexchangeCost;
	/**寄出时间*/
	@Excel(name="寄出时间",format = "yyyy-MM-dd")
	private java.util.Date giftexchangeMailtime;
	/**兑换积分*/
	@Excel(name="兑换积分")
	private java.lang.String giftexchangeIntegral;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */
	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */
	@Column(name ="CREATE_BY",nullable=true,length=50)
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */
	@Column(name ="CREATE_DATE",nullable=true,length=20)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */
	@Column(name ="UPDATE_NAME",nullable=true,length=50)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */
	@Column(name ="UPDATE_BY",nullable=true,length=50)
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
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
	 *@return: java.lang.String  所属部门
	 */
	@Column(name ="SYS_ORG_CODE",nullable=true,length=50)
	public java.lang.String getSysOrgCode(){
		return this.sysOrgCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属部门
	 */
	public void setSysOrgCode(java.lang.String sysOrgCode){
		this.sysOrgCode = sysOrgCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属公司
	 */
	@Column(name ="SYS_COMPANY_CODE",nullable=true,length=50)
	public java.lang.String getSysCompanyCode(){
		return this.sysCompanyCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属公司
	 */
	public void setSysCompanyCode(java.lang.String sysCompanyCode){
		this.sysCompanyCode = sysCompanyCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程状态
	 */
	@Column(name ="BPM_STATUS",nullable=true,length=32)
	public java.lang.String getBpmStatus(){
		return this.bpmStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程状态
	 */
	public void setBpmStatus(java.lang.String bpmStatus){
		this.bpmStatus = bpmStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  礼品id
	 */
	@Column(name ="GIFT_ID",nullable=true,length=36)
	public java.lang.String getGiftId(){
		return this.giftId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  礼品id
	 */
	public void setGiftId(java.lang.String giftId){
		this.giftId = giftId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单号
	 */
	@Column(name ="GIFTEXCHANGE_ORDER",nullable=true,length=50)
	public java.lang.String getGiftexchangeOrder(){
		return this.giftexchangeOrder;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单号
	 */
	public void setGiftexchangeOrder(java.lang.String giftexchangeOrder){
		this.giftexchangeOrder = giftexchangeOrder;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  处理状态
	 */
	@Column(name ="GIFTEXCHANGE_STATE",nullable=true,length=32)
	public java.lang.String getGiftexchangeState(){
		return this.giftexchangeState;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  处理状态
	 */
	public void setGiftexchangeState(java.lang.String giftexchangeState){
		this.giftexchangeState = giftexchangeState;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  处理人
	 */
	@Column(name ="GIFTEXCHANGE_HANDLE",nullable=true,length=32)
	public java.lang.String getGiftexchangeHandle(){
		return this.giftexchangeHandle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  处理人
	 */
	public void setGiftexchangeHandle(java.lang.String giftexchangeHandle){
		this.giftexchangeHandle = giftexchangeHandle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  礼品名称
	 */
	@Column(name ="GIFT_NAME",nullable=true,length=32)
	public java.lang.String getGiftName(){
		return this.giftName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  礼品名称
	 */
	public void setGiftName(java.lang.String giftName){
		this.giftName = giftName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  礼品数量
	 */
	@Column(name ="GIFTEXCHANGE_NUMBER",nullable=true,length=32)
	public java.lang.String getGiftexchangeNumber(){
		return this.giftexchangeNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  礼品数量
	 */
	public void setGiftexchangeNumber(java.lang.String giftexchangeNumber){
		this.giftexchangeNumber = giftexchangeNumber;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  兑换时间
	 */
	@Column(name ="GIFTEXCHANGE_TIME",nullable=true,length=32)
	public java.util.Date getGiftexchangeTime(){
		return this.giftexchangeTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  兑换时间
	 */
	public void setGiftexchangeTime(java.util.Date giftexchangeTime){
		this.giftexchangeTime = giftexchangeTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收货人
	 */
	@Column(name ="GIFTEXCHANGE_CONSIGNEE",nullable=true,length=32)
	public java.lang.String getGiftexchangeConsignee(){
		return this.giftexchangeConsignee;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收货人
	 */
	public void setGiftexchangeConsignee(java.lang.String giftexchangeConsignee){
		this.giftexchangeConsignee = giftexchangeConsignee;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系方式
	 */
	@Column(name ="GIFTEXCHANGE_PHONE",nullable=true,length=32)
	public java.lang.String getGiftexchangePhone(){
		return this.giftexchangePhone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系方式
	 */
	public void setGiftexchangePhone(java.lang.String giftexchangePhone){
		this.giftexchangePhone = giftexchangePhone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收货地址
	 */
	@Column(name ="GIFTEXCHANGE_ADDRESS",nullable=true,length=32)
	public java.lang.String getGiftexchangeAddress(){
		return this.giftexchangeAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收货地址
	 */
	public void setGiftexchangeAddress(java.lang.String giftexchangeAddress){
		this.giftexchangeAddress = giftexchangeAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  快递公司
	 */
	@Column(name ="GIFTEXCHANGE_EXPRESS",nullable=true,length=32)
	public java.lang.String getGiftexchangeExpress(){
		return this.giftexchangeExpress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  快递公司
	 */
	public void setGiftexchangeExpress(java.lang.String giftexchangeExpress){
		this.giftexchangeExpress = giftexchangeExpress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  快递单号
	 */
	@Column(name ="GIFTEXCHANGE_COURIERNUMBER",nullable=true,length=50)
	public java.lang.String getGiftexchangeCouriernumber(){
		return this.giftexchangeCouriernumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  快递单号
	 */
	public void setGiftexchangeCouriernumber(java.lang.String giftexchangeCouriernumber){
		this.giftexchangeCouriernumber = giftexchangeCouriernumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  经办人
	 */
	@Column(name ="GIFTEXCHANGE_OPERATOR",nullable=true,length=32)
	public java.lang.String getGiftexchangeOperator(){
		return this.giftexchangeOperator;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  经办人
	 */
	public void setGiftexchangeOperator(java.lang.String giftexchangeOperator){
		this.giftexchangeOperator = giftexchangeOperator;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  快递费
	 */
	@Column(name ="GIFTEXCHANGE_COST",nullable=true,length=32)
	public java.lang.String getGiftexchangeCost(){
		return this.giftexchangeCost;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  快递费
	 */
	public void setGiftexchangeCost(java.lang.String giftexchangeCost){
		this.giftexchangeCost = giftexchangeCost;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  寄出时间
	 */
	@Column(name ="GIFTEXCHANGE_MAILTIME",nullable=true,length=32)
	public java.util.Date getGiftexchangeMailtime(){
		return this.giftexchangeMailtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  寄出时间
	 */
	public void setGiftexchangeMailtime(java.util.Date giftexchangeMailtime){
		this.giftexchangeMailtime = giftexchangeMailtime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  兑换积分
	 */
	@Column(name ="GIFTEXCHANGE_INTEGRAL",nullable=true,length=32)
	public java.lang.String getGiftexchangeIntegral(){
		return this.giftexchangeIntegral;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  兑换积分
	 */
	public void setGiftexchangeIntegral(java.lang.String giftexchangeIntegral){
		this.giftexchangeIntegral = giftexchangeIntegral;
	}
}
