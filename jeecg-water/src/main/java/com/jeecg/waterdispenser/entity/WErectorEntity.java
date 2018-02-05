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
 * @Description: 安装工
 * @author onlineGenerator
 * @date 2017-07-20 21:01:04
 * @version V1.0   
 *
 */
@Entity
@Table(name = "w_erector", schema = "")
@SuppressWarnings("serial")
public class WErectorEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
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
	private java.lang.String erectorCompany;
	/**安装负责人*/
	@Excel(name="安装负责人")
	private java.lang.String erectorPerson;
	/**联系方式*/
	@Excel(name="联系方式")
	private java.lang.String erectorPhone;
	/**服务区域*/
	@Excel(name="服务区域")
	private java.lang.String erectorRegion;
	/**对应后台账号*/
	@Excel(name="对应后台账号")
	private java.lang.String erectorAdmin;
	/**对应后台用户id*/
	@Excel(name="对应后台账号id")
	private java.lang.String erectorAdminId;
	/**创建日期*/
	@Excel(name="创建日期",format = "yyyy-MM-dd")
	private java.util.Date createDate;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String erectorRemarks;
	/**是否有效*/
	@Excel(name="是否有效")
	private java.lang.Integer erectorState;
	/**固定电话*/
	@Excel(name="固定电话")
	private java.lang.String erectorFixedline;
	
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
	@Column(name ="ERECTOR_COMPANY",nullable=true,length=32)
	public java.lang.String getErectorCompany(){
		return this.erectorCompany;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  安装公司
	 */
	public void setErectorCompany(java.lang.String erectorCompany){
		this.erectorCompany = erectorCompany;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  安装负责人
	 */
	@Column(name ="ERECTOR_PERSON",nullable=true,length=32)
	public java.lang.String getErectorPerson(){
		return this.erectorPerson;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  安装负责人
	 */
	public void setErectorPerson(java.lang.String erectorPerson){
		this.erectorPerson = erectorPerson;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系方式
	 */
	@Column(name ="ERECTOR_PHONE",nullable=true,length=32)
	public java.lang.String getErectorPhone(){
		return this.erectorPhone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系方式
	 */
	public void setErectorPhone(java.lang.String erectorPhone){
		this.erectorPhone = erectorPhone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  服务区域
	 */
	@Column(name ="ERECTOR_REGION",nullable=true,length=32)
	public java.lang.String getErectorRegion(){
		return this.erectorRegion;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  服务区域
	 */
	public void setErectorRegion(java.lang.String erectorRegion){
		this.erectorRegion = erectorRegion;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  对应后台账号
	 */
	@Column(name ="ERECTOR_ADMIN",nullable=true,length=32)
	public java.lang.String getErectorAdmin(){
		return this.erectorAdmin;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  对应后台账号
	 */
	public void setErectorAdmin(java.lang.String erectorAdmin){
		this.erectorAdmin = erectorAdmin;
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
	 *@return: java.lang.String  备注
	 */
	@Column(name ="ERECTOR_REMARKS",nullable=true,length=32)
	public java.lang.String getErectorRemarks(){
		return this.erectorRemarks;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setErectorRemarks(java.lang.String erectorRemarks){
		this.erectorRemarks = erectorRemarks;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否有效
	 */
	@Column(name ="ERECTOR_STATE",nullable=true,length=1)
	public java.lang.Integer getErectorState(){
		return this.erectorState;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否有效
	 */
	public void setErectorState(java.lang.Integer erectorState){
		this.erectorState = erectorState;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="ERECTOR_FIXEDLINE",nullable=true,length=32)
	public java.lang.String getErectorFixedline(){
		return this.erectorFixedline;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setErectorFixedline(java.lang.String erectorFixedline){
		this.erectorFixedline = erectorFixedline;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  对应后台账号id
	 */
	@Column(name ="ERECTOR_ADMIN_ID",nullable=true,length=32)
	public java.lang.String getErectorAdminId(){
		return this.erectorAdminId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  对应后台账号id
	 */
	public void setErectorAdminId(java.lang.String erectorAdminId){
		this.erectorAdminId = erectorAdminId;
	}
	
}
