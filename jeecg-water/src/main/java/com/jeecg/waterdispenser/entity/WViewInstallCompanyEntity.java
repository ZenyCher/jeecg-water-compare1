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
 * @Description: 安装公司结算
 * @author onlineGenerator
 * @date 2017-10-16 11:23:22
 * @version V1.0   
 *
 */
@Entity
@Table(name = "w_view_install_company", schema = "")
@SuppressWarnings("serial")
public class WViewInstallCompanyEntity implements java.io.Serializable {
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
	/**安装公司*/
	@Excel(name="安装公司")
	private java.lang.String installWorker;
	/**会员姓名*/
	@Excel(name="会员姓名")
	private java.lang.String memberName;
	/**会员联系方式*/
	@Excel(name="会员联系方式")
	private java.lang.String memberPhone;
	/**会员联系地址*/
	@Excel(name="会员联系地址")
	private java.lang.String memberAddress;
	/**下单时间*/
	@Excel(name="下单时间",format = "yyyy-MM-dd")
	private java.util.Date orderDate;
	/**水表di*/
	@Excel(name="水表di")
	private java.lang.String deviceId;
	/**型号*/
	@Excel(name="型号")
	private java.lang.String memberDeviceType;
	/**安装状态*/
	@Excel(name="安装状态")
	private java.lang.String installProgress;
	/**安装完成时间*/
	@Excel(name="安装完成时间",format = "yyyy-MM-dd")
	private java.util.Date installEndtime;
	
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
	 *@return: java.lang.String  安装公司
	 */
	@Column(name ="INSTALL_WORKER",nullable=true,length=32)
	public java.lang.String getInstallWorker(){
		return this.installWorker;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  安装公司
	 */
	public void setInstallWorker(java.lang.String installWorker){
		this.installWorker = installWorker;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  会员姓名
	 */
	@Column(name ="MEMBER_NAME",nullable=true,length=32)
	public java.lang.String getMemberName(){
		return this.memberName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  会员姓名
	 */
	public void setMemberName(java.lang.String memberName){
		this.memberName = memberName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  会员联系方式
	 */
	@Column(name ="MEMBER_PHONE",nullable=true,length=32)
	public java.lang.String getMemberPhone(){
		return this.memberPhone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  会员联系方式
	 */
	public void setMemberPhone(java.lang.String memberPhone){
		this.memberPhone = memberPhone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  会员联系地址
	 */
	@Column(name ="MEMBER_ADDRESS",nullable=true,length=32)
	public java.lang.String getMemberAddress(){
		return this.memberAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  会员联系地址
	 */
	public void setMemberAddress(java.lang.String memberAddress){
		this.memberAddress = memberAddress;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  下单时间
	 */
	@Column(name ="ORDER_DATE",nullable=true,length=32)
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
	 *@return: java.lang.String  水表di
	 */
	@Column(name ="DEVICE_ID",nullable=true,length=36)
	public java.lang.String getDeviceId(){
		return this.deviceId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  水表di
	 */
	public void setDeviceId(java.lang.String deviceId){
		this.deviceId = deviceId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  型号
	 */
	@Column(name ="MEMBER_DEVICE_TYPE",nullable=true,length=32)
	public java.lang.String getMemberDeviceType(){
		return this.memberDeviceType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  型号
	 */
	public void setMemberDeviceType(java.lang.String memberDeviceType){
		this.memberDeviceType = memberDeviceType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  安装状态
	 */
	@Column(name ="INSTALL_PROGRESS",nullable=true,length=32)
	public java.lang.String getInstallProgress(){
		return this.installProgress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  安装状态
	 */
	public void setInstallProgress(java.lang.String installProgress){
		this.installProgress = installProgress;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  安装完成时间
	 */
	@Column(name ="INSTALL_ENDTIME",nullable=true,length=32)
	public java.util.Date getInstallEndtime(){
		return this.installEndtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  安装完成时间
	 */
	public void setInstallEndtime(java.util.Date installEndtime){
		this.installEndtime = installEndtime;
	}
}
