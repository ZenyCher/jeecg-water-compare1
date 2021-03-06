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
 * @Description: 滤芯设备
 * @author onlineGenerator
 * @date 2017-07-06 11:44:24
 * @version V1.0   
 *
 */
@Entity
@Table(name = "w_filter", schema = "")
@SuppressWarnings("serial")
public class WFilterEntity implements java.io.Serializable {
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
	/**滤芯id*/
	@Excel(name="滤芯id")
	private java.lang.String filterId;
	/**滤芯名称*/
	@Excel(name="滤芯名称")
	private java.lang.String filterName;
	/**滤芯型号*/
	@Excel(name="滤芯型号")
	private java.lang.String filterModel;
	/**生产日期*/
	@Excel(name="生产日期",format = "yyyy-MM-dd")
	private java.util.Date filterTime;
	/**导入时间*/
	@Excel(name="导入时间",format = "yyyy-MM-dd")
	private java.util.Date filterImporttime;
	/**防伪码*/
	@Excel(name="防伪码")
	private java.lang.String filterCode;
	/**安装时水量*/
	@Excel(name="安装时水量")
	private java.lang.String filterInstalledwater;
	/**滤芯总水量*/
	@Excel(name="滤芯总水量")
	private java.lang.String filterTotalwater;
	/**是否被使用0未使用，1已使用*/
	@Excel(name="是否被使用")
	private java.lang.Integer filterState;
	
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  滤芯名称
	 */
	@Column(name ="FILTER_NAME",nullable=true,length=32)
	public java.lang.String getFilterName(){
		return this.filterName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  滤芯名称
	 */
	public void setFilterName(java.lang.String filterName){
		this.filterName = filterName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  滤芯型号
	 */
	@Column(name ="FILTER_MODEL",nullable=true,length=32)
	public java.lang.String getFilterModel(){
		return this.filterModel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  滤芯型号
	 */
	public void setFilterModel(java.lang.String filterModel){
		this.filterModel = filterModel;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  生产日期
	 */
	@Column(name ="FILTER_TIME",nullable=true,length=32)
	public java.util.Date getFilterTime(){
		return this.filterTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  生产日期
	 */
	public void setFilterTime(java.util.Date filterTime){
		this.filterTime = filterTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  导入时间
	 */
	@Column(name ="FILTER_IMPORTTIME",nullable=true,length=32)
	public java.util.Date getFilterImporttime(){
		return this.filterImporttime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  导入时间
	 */
	public void setFilterImporttime(java.util.Date filterImporttime){
		this.filterImporttime = filterImporttime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  防伪码
	 */
	@Column(name ="FILTER_CODE",nullable=true,length=32)
	public java.lang.String getFilterCode(){
		return this.filterCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  防伪码
	 */
	public void setFilterCode(java.lang.String filterCode){
		this.filterCode = filterCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  安装时水量
	 */
	@Column(name ="FILTER_INSTALLEDWATER",nullable=true,length=32)
	public java.lang.String getFilterInstalledwater(){
		return this.filterInstalledwater;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  安装时水量
	 */
	public void setFilterInstalledwater(java.lang.String filterInstalledwater){
		this.filterInstalledwater = filterInstalledwater;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  滤芯总水量
	 */
	@Column(name ="FILTER_TOTALWATER",nullable=true,length=32)
	public java.lang.String getFilterTotalwater(){
		return this.filterTotalwater;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  滤芯总水量
	 */
	public void setFilterTotalwater(java.lang.String filterTotalwater){
		this.filterTotalwater = filterTotalwater;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  滤芯是否被使用
	 */
	@Column(name="FILTER_STATE",nullable=true,length=1)
	public java.lang.Integer getFilterState() {
		return filterState;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  滤芯是否被使用
	 */
	public void setFilterState(java.lang.Integer filterState) {
		this.filterState = filterState;
	}
	
	
}
