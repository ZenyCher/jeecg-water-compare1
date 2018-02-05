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
 * @Description: 净水器类型
 * @author onlineGenerator
 * @date 2017-08-03 20:04:47
 * @version V1.0   
 *
 */
@Entity
@Table(name = "w_device_type", schema = "")
@SuppressWarnings("serial")
public class WDeviceTypeEntity implements java.io.Serializable {
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
	/**型号*/
	@Excel(name="型号")
	private java.lang.String deviceType;
	/**名称*/
	@Excel(name="名称")
	private java.lang.String deviceName;
	/**滤芯数量*/
	@Excel(name="滤芯数量")
	private java.lang.Integer deviceFilterNum;
	/**滤芯1更换水量*/
	@Excel(name="滤芯1更换水量")
	private java.lang.Integer filterNumOne;
	/**滤芯2更换水量*/
	@Excel(name="滤芯2更换水量")
	private java.lang.Integer filterNumTwo;
	/**滤芯3更换水量*/
	@Excel(name="滤芯3更换水量")
	private java.lang.Integer filterNumThree;
	/**滤芯4更换水量*/
	@Excel(name="滤芯4更换水量")
	private java.lang.Integer filterNumFour;
	/**滤芯5更换水量*/
	@Excel(name="滤芯5更换水量")
	private java.lang.Integer filterNumFive;
	/**滤芯6更换水量*/
	@Excel(name="滤芯6更换水量")
	private java.lang.Integer filterNumSix;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String remarks;
	
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
	 *@return: java.lang.String  型号
	 */
	@Column(name ="DEVICE_TYPE",nullable=true,length=50)
	public java.lang.String getDeviceType(){
		return this.deviceType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  型号
	 */
	public void setDeviceType(java.lang.String deviceType){
		this.deviceType = deviceType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  名称
	 */
	@Column(name ="DEVICE_NAME",nullable=true,length=50)
	public java.lang.String getDeviceName(){
		return this.deviceName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  名称
	 */
	public void setDeviceName(java.lang.String deviceName){
		this.deviceName = deviceName;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  滤芯数量
	 */
	@Column(name ="DEVICE_FILTER_NUM",nullable=true,length=1)
	public java.lang.Integer getDeviceFilterNum(){
		return this.deviceFilterNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  滤芯数量
	 */
	public void setDeviceFilterNum(java.lang.Integer deviceFilterNum){
		this.deviceFilterNum = deviceFilterNum;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  滤芯1更换水量
	 */
	@Column(name ="FILTER_NUM_ONE",nullable=true,length=11)
	public java.lang.Integer getFilterNumOne(){
		return this.filterNumOne;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  滤芯1更换水量
	 */
	public void setFilterNumOne(java.lang.Integer filterNumOne){
		this.filterNumOne = filterNumOne;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  滤芯2更换水量
	 */
	@Column(name ="FILTER_NUM_TWO",nullable=true,length=11)
	public java.lang.Integer getFilterNumTwo(){
		return this.filterNumTwo;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  滤芯2更换水量
	 */
	public void setFilterNumTwo(java.lang.Integer filterNumTwo){
		this.filterNumTwo = filterNumTwo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  滤芯3更换水量
	 */
	@Column(name ="FILTER_NUM_THREE",nullable=true,length=11)
	public java.lang.Integer getFilterNumThree(){
		return this.filterNumThree;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  滤芯3更换水量
	 */
	public void setFilterNumThree(java.lang.Integer filterNumThree){
		this.filterNumThree = filterNumThree;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  滤芯4更换水量
	 */
	@Column(name ="FILTER_NUM_FOUR",nullable=true,length=11)
	public java.lang.Integer getFilterNumFour(){
		return this.filterNumFour;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  滤芯4更换水量
	 */
	public void setFilterNumFour(java.lang.Integer filterNumFour){
		this.filterNumFour = filterNumFour;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  滤芯5更换水量
	 */
	@Column(name ="FILTER_NUM_FIVE",nullable=true,length=11)
	public java.lang.Integer getFilterNumFive(){
		return this.filterNumFive;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  滤芯5更换水量
	 */
	public void setFilterNumFive(java.lang.Integer filterNumFive){
		this.filterNumFive = filterNumFive;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  滤芯6更换水量
	 */
	@Column(name ="FILTER_NUM_SIX",nullable=true,length=11)
	public java.lang.Integer getFilterNumSix(){
		return this.filterNumSix;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  滤芯6更换水量
	 */
	public void setFilterNumSix(java.lang.Integer filterNumSix){
		this.filterNumSix = filterNumSix;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARKS",nullable=true,length=200)
	public java.lang.String getRemarks(){
		return this.remarks;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemarks(java.lang.String remarks){
		this.remarks = remarks;
	}
}
