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
 * @Description: 水表
 * @author onlineGenerator
 * @date 2017-08-05 01:17:17
 * @version V1.0   
 *
 */
@Entity
@Table(name = "w_water_meter", schema = "")
@SuppressWarnings("serial")
public class WWaterMeterEntity implements java.io.Serializable {
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
	/**水表id*/
	@Excel(name="水表id")
	private java.lang.String waterId;
	/**水表初始水量*/
	@Excel(name="水表初始水量")
	private java.lang.Integer waterNum;
	/**水表安装时间*/
	@Excel(name="水表安装时间")
	private java.lang.String waterStartTime;
	/**会员联系方式*/
	@Excel(name="会员联系方式")
	private java.lang.String memberPhone;
	/**会员姓名*/
	@Excel(name="会员姓名")
	private java.lang.String memberName;
	/**水表使用情况*/
	@Excel(name="水表使用情况")
	private java.lang.String waterUse;
	/**水表当前水量*/
	@Excel(name="水表当前水量")
	private java.lang.Integer waterCurrent;
	/**水表剩余水量*/
	@Excel(name="水表剩余水量")
	private java.lang.Integer waterSurplus;
	/**水表状态*/
	@Excel(name="水表状态")
	private java.lang.Integer waterState;
	/**水表开关阀*/
	@Excel(name="开关阀")
	private java.lang.Integer waterValue;
	/**已充水量*/
	@Excel(name="已充水量")
	private java.lang.Integer waterRecharge;
	/**会员id*/
	@Excel(name="会员id")
	private java.lang.String memberId;
	
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
	 *@return: java.lang.String  水表id
	 */
	@Column(name ="WATER_ID",nullable=true,length=32)
	public java.lang.String getWaterId(){
		return this.waterId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  水表id
	 */
	public void setWaterId(java.lang.String waterId){
		this.waterId = waterId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  水表初始水量
	 */
	@Column(name ="WATER_NUM",nullable=true,length=11)
	public java.lang.Integer getWaterNum(){
		return this.waterNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  水表初始水量
	 */
	public void setWaterNum(java.lang.Integer waterNum){
		this.waterNum = waterNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  水表安装时间
	 */
	@Column(name ="WATER_START_TIME",nullable=true,length=32)
	public java.lang.String getWaterStartTime(){
		return this.waterStartTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  水表安装时间
	 */
	public void setWaterStartTime(java.lang.String waterStartTime){
		this.waterStartTime = waterStartTime;
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
	 *@return: java.lang.String  水表使用情况
	 */
	@Column(name ="WATER_USE",nullable=true,length=32)
	public java.lang.String getWaterUse(){
		return this.waterUse;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  水表使用情况
	 */
	public void setWaterUse(java.lang.String waterUse){
		this.waterUse = waterUse;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  水表当前水量
	 */
	@Column(name ="WATER_CURRENT",nullable=true,length=11)
	public java.lang.Integer getWaterCurrent(){
		return this.waterCurrent;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  水表当前水量
	 */
	public void setWaterCurrent(java.lang.Integer waterCurrent){
		this.waterCurrent = waterCurrent;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  水表剩余水量
	 */
	@Column(name ="WATER_SURPLUS",nullable=true,length=11)
	public java.lang.Integer getWaterSurplus(){
		return this.waterSurplus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  水表剩余水量
	 */
	public void setWaterSurplus(java.lang.Integer waterSurplus){
		this.waterSurplus = waterSurplus;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  水表状态
	 */
	@Column(name ="WATER_STATE",nullable=true,length=1)
	public java.lang.Integer getWaterState(){
		return this.waterState;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  水表状态
	 */
	public void setWaterState(java.lang.Integer waterState){
		this.waterState = waterState;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  水表开关阀
	 */
	@Column(name ="WATER_VALUE",nullable=true,length=1)
	public java.lang.Integer getWaterValue(){
		return this.waterValue;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  水表开关阀
	 */
	public void setWaterValue(java.lang.Integer waterValue){
		this.waterValue = waterValue;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  已充水量
	 */
	@Column(name ="WATER_RECHARGE",nullable=true,length=1)
	public java.lang.Integer getWaterRecharge(){
		return this.waterRecharge;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  已充水量
	 */
	public void setWaterRecharge(java.lang.Integer waterRecharge){
		this.waterRecharge = waterRecharge;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  会员姓名
	 */
	@Column(name ="MEMBER_ID",nullable=true,length=36)
	public java.lang.String getMemberId(){
		return this.memberId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  会员姓名
	 */
	public void setMemberId(java.lang.String memberId){
		this.memberId = memberId;
	}
}
