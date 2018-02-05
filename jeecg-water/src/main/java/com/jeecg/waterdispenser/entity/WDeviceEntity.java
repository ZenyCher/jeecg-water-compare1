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
 * @Description: 净水器设备表
 * @author onlineGenerator
 * @date 2017-05-28 15:03:36
 * @version V1.0   
 *
 */
@Entity
@Table(name = "w_device", schema = "")
@SuppressWarnings("serial")
public class WDeviceEntity implements java.io.Serializable {
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
	/**设备名称*/
	@Excel(name="设备名称")
	private java.lang.String deviceName;
	/**设备型号*/
	@Excel(name="设备型号")
	private java.lang.String deviceModel;
	/**滤芯数量*/
	@Excel(name="滤芯数量")
	private java.lang.String filterNember;
	/**滤芯id*/
	@Excel(name="滤芯id")
	private java.lang.String filterId;
	/**生产日期*/
	@Excel(name="生产日期",format = "yyyy-MM-dd")
	private java.util.Date deviceTime;
	/**防伪码*/
	@Excel(name="防伪码")
	private java.lang.String deviceCode;
	/**商城产品id*/
	@Excel(name="商城产品id")
	private java.lang.String mallIntroduceId;
	/**商城产品名称*/
	@Excel(name="商城产品名称")
	private java.lang.String mallIntroduceName;
	/**净水器类型id*/
	@Excel(name="净水器类型id")
	private java.lang.String deviceTypeId;
	/**是否被使用*/
	@Excel(name="是否被使用")
	private java.lang.Integer isUse;
	
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
	@Column(name ="DEVICE_ID",nullable=false,length=36)
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
	 *@return: java.lang.String  设备名称
	 */
	@Column(name ="DEVICE_NAME",nullable=true,length=32)
	public java.lang.String getDeviceName(){
		return this.deviceName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  设备名称
	 */
	public void setDeviceName(java.lang.String deviceName){
		this.deviceName = deviceName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  设备型号
	 */
	@Column(name ="DEVICE_MODEL",nullable=true,length=32)
	public java.lang.String getDeviceModel(){
		return this.deviceModel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  设备型号
	 */
	public void setDeviceModel(java.lang.String deviceModel){
		this.deviceModel = deviceModel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  滤芯数量
	 */
	@Column(name ="FILTER_NEMBER",nullable=true,length=32)
	public java.lang.String getFilterNember(){
		return this.filterNember;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  滤芯数量
	 */
	public void setFilterNember(java.lang.String filterNember){
		this.filterNember = filterNember;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  滤芯id
	 */
	@Column(name ="FILTER_ID",nullable=true,length=36)
	public java.lang.String getFilterId(){
		return this.filterId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  滤芯id
	 */
	public void setFilterId(java.lang.String filterId){
		this.filterId = filterId;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  生产日期
	 */
	@Column(name ="DEVICE_TIME",nullable=true,length=32)
	public java.util.Date getDeviceTime(){
		return this.deviceTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  生产日期
	 */
	public void setDeviceTime(java.util.Date deviceTime){
		this.deviceTime = deviceTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  防伪码
	 */
	@Column(name ="DEVICE_CODE",nullable=true,length=32)
	public java.lang.String getDeviceCode(){
		return this.deviceCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  防伪码
	 */
	public void setDeviceCode(java.lang.String deviceCode){
		this.deviceCode = deviceCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商城产品id
	 */
	@Column(name ="MALL_INTRODUCE_ID",nullable=true,length=36)
	public java.lang.String getMallIntroduceId(){
		return this.mallIntroduceId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商城 产品id
	 */
	public void setMallIntroduceId(java.lang.String mallIntroduceId){
		this.mallIntroduceId = mallIntroduceId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商城产品名称
	 */
	@Column(name ="MALL_INTRODUCE_NAME",nullable=true,length=50)
	public java.lang.String getMallIntroduceName(){
		return this.mallIntroduceName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商城 产品名称
	 */
	public void setMallIntroduceName(java.lang.String mallIntroduceName){
		this.mallIntroduceName = mallIntroduceName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  设备类型id
	 */
	@Column(name ="DEVICE_TYPE_ID",nullable=true,length=36)
	public java.lang.String getDeviceTypeId(){
		return this.deviceTypeId;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  设备类型id
	 */
	public void setDeviceTypeId(java.lang.String deviceTypeId){
		this.deviceTypeId = deviceTypeId;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  设备是否被使用
	 */
	@Column(name ="IS_USE",nullable=true,length=1)
	public java.lang.Integer getIsUse(){
		return this.isUse;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  设备是否被使用
	 */
	public void setIsUse(java.lang.Integer isUse){
		this.isUse = isUse;
	}
}
