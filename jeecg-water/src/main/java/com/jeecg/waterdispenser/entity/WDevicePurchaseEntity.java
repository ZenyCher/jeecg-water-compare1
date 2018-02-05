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
 * @Description: 设备购买明细表
 * @author onlineGenerator
 * @date 2017-06-26 23:22:21
 * @version V1.0   
 *
 */
@Entity
@Table(name = "w_device_purchase", schema = "")
@SuppressWarnings("serial")
public class WDevicePurchaseEntity implements java.io.Serializable {
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
	/**设备id*/
	@Excel(name="设备id")
	private java.lang.String deviceId;
	/**购买单号*/
	@Excel(name="购买单号")
	private java.lang.String purchaseOrder;
	/**购买状态*/
	@Excel(name="购买状态")
	private java.lang.String purchaseState;
	/**处理人*/
	@Excel(name="处理人")
	private java.lang.String purchaseHandle;
	/**设备名称*/
	@Excel(name="设备名称")
	private java.lang.String purchaseName;
	/**购买数量*/
	@Excel(name="购买数量")
	private java.lang.String purchaseNumber;
	/**购买时间*/
	@Excel(name="购买时间")
	private java.lang.String purchaseTime;
	/**购买人*/
	@Excel(name="购买人")
	private java.lang.String purchasePeople;
	/**购买人联系方式*/
	@Excel(name="购买人联系方式")
	private java.lang.String purchasePhone;
	/**快递公司*/
	@Excel(name="快递公司")
	private java.lang.String purchaseExpress;
	/**快递单号*/
	@Excel(name="快递单号")
	private java.lang.String purchaseCouriernumber;
	/**经办人*/
	@Excel(name="经办人")
	private java.lang.String purchaseOperator;
	/**快递费*/
	@Excel(name="快递费")
	private java.lang.String purchaseCost;
	/**寄出时间*/
	@Excel(name="寄出时间",format = "yyyy-MM-dd")
	private java.util.Date purchaseMailtime;
	/**待支付*/
	@Excel(name="待支付")
	private java.lang.Integer purchasePay;
	/**货物状态*/
	@Excel(name="货物状态")
	private java.lang.Integer purchaseGoods;
	
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
	 *@return: java.lang.String  设备id
	 */
	@Column(name ="DEVICE_ID",nullable=true,length=36)
	public java.lang.String getDeviceId(){
		return this.deviceId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  设备id
	 */
	public void setDeviceId(java.lang.String deviceId){
		this.deviceId = deviceId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  购买单号
	 */
	@Column(name ="PURCHASE_ORDER",nullable=true,length=32)
	public java.lang.String getPurchaseOrder(){
		return this.purchaseOrder;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  购买单号
	 */
	public void setPurchaseOrder(java.lang.String purchaseOrder){
		this.purchaseOrder = purchaseOrder;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  购买状态
	 */
	@Column(name ="PURCHASE_STATE",nullable=true,length=32)
	public java.lang.String getPurchaseState(){
		return this.purchaseState;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  购买状态
	 */
	public void setPurchaseState(java.lang.String purchaseState){
		this.purchaseState = purchaseState;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  处理人
	 */
	@Column(name ="PURCHASE_HANDLE",nullable=true,length=32)
	public java.lang.String getPurchaseHandle(){
		return this.purchaseHandle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  处理人
	 */
	public void setPurchaseHandle(java.lang.String purchaseHandle){
		this.purchaseHandle = purchaseHandle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  设备名称
	 */
	@Column(name ="PURCHASE_NAME",nullable=true,length=32)
	public java.lang.String getPurchaseName(){
		return this.purchaseName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  设备名称
	 */
	public void setPurchaseName(java.lang.String purchaseName){
		this.purchaseName = purchaseName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  购买数量
	 */
	@Column(name ="PURCHASE_NUMBER",nullable=true,length=32)
	public java.lang.String getPurchaseNumber(){
		return this.purchaseNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  购买数量
	 */
	public void setPurchaseNumber(java.lang.String purchaseNumber){
		this.purchaseNumber = purchaseNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  购买时间
	 */
	@Column(name ="PURCHASE_TIME",nullable=true,length=32)
	public java.lang.String getPurchaseTime(){
		return this.purchaseTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  购买时间
	 */
	public void setPurchaseTime(java.lang.String purchaseTime){
		this.purchaseTime = purchaseTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  购买人
	 */
	@Column(name ="PURCHASE_PEOPLE",nullable=true,length=32)
	public java.lang.String getPurchasePeople(){
		return this.purchasePeople;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  购买人
	 */
	public void setPurchasePeople(java.lang.String purchasePeople){
		this.purchasePeople = purchasePeople;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  购买人联系方式
	 */
	@Column(name ="PURCHASE_PHONE",nullable=true,length=32)
	public java.lang.String getPurchasePhone(){
		return this.purchasePhone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  购买人联系方式
	 */
	public void setPurchasePhone(java.lang.String purchasePhone){
		this.purchasePhone = purchasePhone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  快递公司
	 */
	@Column(name ="PURCHASE_EXPRESS",nullable=true,length=32)
	public java.lang.String getPurchaseExpress(){
		return this.purchaseExpress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  快递公司
	 */
	public void setPurchaseExpress(java.lang.String purchaseExpress){
		this.purchaseExpress = purchaseExpress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  快递单号
	 */
	@Column(name ="PURCHASE_COURIERNUMBER",nullable=true,length=32)
	public java.lang.String getPurchaseCouriernumber(){
		return this.purchaseCouriernumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  快递单号
	 */
	public void setPurchaseCouriernumber(java.lang.String purchaseCouriernumber){
		this.purchaseCouriernumber = purchaseCouriernumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  经办人
	 */
	@Column(name ="PURCHASE_OPERATOR",nullable=true,length=32)
	public java.lang.String getPurchaseOperator(){
		return this.purchaseOperator;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  经办人
	 */
	public void setPurchaseOperator(java.lang.String purchaseOperator){
		this.purchaseOperator = purchaseOperator;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  快递费
	 */
	@Column(name ="PURCHASE_COST",nullable=true,length=32)
	public java.lang.String getPurchaseCost(){
		return this.purchaseCost;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  快递费
	 */
	public void setPurchaseCost(java.lang.String purchaseCost){
		this.purchaseCost = purchaseCost;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  寄出时间
	 */
	@Column(name ="PURCHASE_MAILTIME",nullable=true,length=32)
	public java.util.Date getPurchaseMailtime(){
		return this.purchaseMailtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  寄出时间
	 */
	public void setPurchaseMailtime(java.util.Date purchaseMailtime){
		this.purchaseMailtime = purchaseMailtime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  待支付
	 */
	@Column(name ="PURCHASE_PAY",nullable=true,length=32)
	public java.lang.Integer getPurchasePay(){
		return this.purchasePay;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  待支付
	 */
	public void setPurchasePay(java.lang.Integer purchasePay){
		this.purchasePay = purchasePay;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  货物状态
	 */
	@Column(name ="PURCHASE_GOODS",nullable=true,length=32)
	public java.lang.Integer getPurchaseGoods(){
		return this.purchaseGoods;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  货物状态
	 */
	public void setPurchaseGoods(java.lang.Integer purchaseGoods){
		this.purchaseGoods = purchaseGoods;
	}
}
