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
 * @Description: 套餐管理
 * @author onlineGenerator
 * @date 2017-07-29 16:21:00
 * @version V1.0   
 *
 */
@Entity
@Table(name = "w_package", schema = "")
@SuppressWarnings("serial")
public class WPackageEntity implements java.io.Serializable {
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
	/**套餐名称*/
	@Excel(name="套餐名称")
	private java.lang.String packageMode;
	/**套餐类型*/
	@Excel(name="套餐类型")
	private java.lang.Integer packageType;
	/**优惠规则描述*/
	@Excel(name="优惠规则描述")
	private java.lang.String packageDescribe;
	/**变量值*/
	@Excel(name="变量值")
	private java.lang.String packageValue;
	/**状态*/
	@Excel(name="状态")
	private java.lang.Integer packageState;
	/**package_father*/
	@Excel(name="父及id")
	private java.lang.String packageFather;
	/**标准*/
	@Excel(name="标准")
	private java.lang.Integer packageMax;
	/**换算比例*/
	@Excel(name="换算比例")
	private java.lang.Float packageConver;
	/**充值类型*/
	@Excel(name="充值类型")
	private java.lang.Integer packageClass;
	
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
	 *@return: java.lang.String  套餐名称
	 */
	@Column(name ="PACKAGE_MODE",nullable=true,length=32)
	public java.lang.String getPackageMode(){
		return this.packageMode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  套餐名称
	 */
	public void setPackageMode(java.lang.String packageMode){
		this.packageMode = packageMode;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  套餐类型
	 */
	@Column(name ="PACKAGE_TYPE",nullable=true,length=1)
	public java.lang.Integer getPackageType(){
		return this.packageType;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  套餐类型
	 */
	public void setPackageType(java.lang.Integer packageType){
		this.packageType = packageType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  优惠规则描述
	 */
	@Column(name ="PACKAGE_DESCRIBE",nullable=true,length=32)
	public java.lang.String getPackageDescribe(){
		return this.packageDescribe;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  优惠规则描述
	 */
	public void setPackageDescribe(java.lang.String packageDescribe){
		this.packageDescribe = packageDescribe;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  变量值
	 */
	@Column(name ="PACKAGE_VALUE",nullable=true,length=32)
	public java.lang.String getPackageValue(){
		return this.packageValue;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  变量值
	 */
	public void setPackageValue(java.lang.String packageValue){
		this.packageValue = packageValue;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  状态
	 */
	@Column(name ="PACKAGE_STATE",nullable=true,length=1)
	public java.lang.Integer getPackageState(){
		return this.packageState;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  状态
	 */
	public void setPackageState(java.lang.Integer packageState){
		this.packageState = packageState;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  package_father
	 */
	@Column(name ="PACKAGE_FATHER",nullable=true,length=32)
	public java.lang.String getPackageFather(){
		return this.packageFather;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  package_father
	 */
	public void setPackageFather(java.lang.String packageFather){
		this.packageFather = packageFather;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  标准
	 */
	@Column(name ="PACKAGE_MAX",nullable=true,length=10)
	public java.lang.Integer getPackageMax(){
		return this.packageMax;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  标准
	 */
	public void setPackageMax(java.lang.Integer packageMax){
		this.packageMax = packageMax;
	}
	
	/**
	 *方法: 取得java.lang.Float
	 *@return: java.lang.Float  换算比例
	 */
	@Column(name ="PACKAGE_CONVER",nullable=true,length=10)
	public java.lang.Float getPackageConver(){
		return this.packageConver;
	}

	/**
	 *方法: 设置java.lang.Float
	 *@param: java.lang.Float  换算比例
	 */
	public void setPackageConver(java.lang.Float packageConver){
		this.packageConver = packageConver;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  充值类型
	 */
	@Column(name ="PACKAGE_CLASS",nullable=true,length=1)
	public java.lang.Integer getPackageClass(){
		return this.packageClass;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  充值类型
	 */
	public void setPackageClass(java.lang.Integer packageClass){
		this.packageClass = packageClass;
	}
}
