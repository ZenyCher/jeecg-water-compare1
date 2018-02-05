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
 * @Description: 用户地址表
 * @author onlineGenerator
 * @date 2017-08-08 19:10:15
 * @version V1.0   
 *
 */
@Entity
@Table(name = "w_address", schema = "")
@SuppressWarnings("serial")
public class WAddressEntity implements java.io.Serializable {
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
	/**注册用户id*/
	@Excel(name="注册用户id")
	private java.lang.String registerId;
	/**所在地区*/
	@Excel(name="所在地区")
	private java.lang.String addressRegion;
	/**收货人电话*/
	@Excel(name="收货人电话")
	private java.lang.String addressPhone;
	/**街道地址*/
	@Excel(name="街道地址")
	private java.lang.String addressStreet;
	/**收货人*/
	@Excel(name="收货人")
	private java.lang.String addressName;
	/**会员联系方式*/
	@Excel(name="会员联系方式")
	private java.lang.String memberPhone;
	
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
	 *@return: java.lang.String  注册用户id
	 */
	@Column(name ="REGISTER_ID",nullable=true,length=36)
	public java.lang.String getRegisterId(){
		return this.registerId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  注册用户id
	 */
	public void setRegisterId(java.lang.String registerId){
		this.registerId = registerId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所在地区
	 */
	@Column(name ="ADDRESS_REGION",nullable=true,length=32)
	public java.lang.String getAddressRegion(){
		return this.addressRegion;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所在地区
	 */
	public void setAddressRegion(java.lang.String addressRegion){
		this.addressRegion = addressRegion;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收货人电话
	 */
	@Column(name ="ADDRESS_PHONE",nullable=true,length=32)
	public java.lang.String getAddressPhone(){
		return this.addressPhone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收货人电话
	 */
	public void setAddressPhone(java.lang.String addressPhone){
		this.addressPhone = addressPhone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  街道地址
	 */
	@Column(name ="ADDRESS_STREET",nullable=true,length=32)
	public java.lang.String getAddressStreet(){
		return this.addressStreet;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  街道地址
	 */
	public void setAddressStreet(java.lang.String addressStreet){
		this.addressStreet = addressStreet;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收货人
	 */
	@Column(name ="ADDRESS_NAME",nullable=true,length=32)
	public java.lang.String getAddressName(){
		return this.addressName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收货人
	 */
	public void setAddressName(java.lang.String addressName){
		this.addressName = addressName;
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
}
