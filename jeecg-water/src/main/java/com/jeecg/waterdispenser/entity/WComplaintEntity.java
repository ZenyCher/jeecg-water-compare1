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
 * @Description: 投诉与建议
 * @author onlineGenerator
 * @date 2017-07-20 20:10:01
 * @version V1.0   
 *
 */
@Entity
@Table(name = "w_complaint", schema = "")
@SuppressWarnings("serial")
public class WComplaintEntity implements java.io.Serializable {
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
	/**会员姓名*/
	@Excel(name="会员姓名")
	private java.lang.String complaintMembername;
	/**联系方式*/
	@Excel(name="联系方式")
	private java.lang.String complaintPhone;
	/**反馈内容*/
	@Excel(name="反馈内容")
	private java.lang.String complaintContent;
	/**问题类型*/
	@Excel(name="问题类型")
	private java.lang.String complaintType;
	/**处理状态*/
	@Excel(name="处理状态")
	private java.lang.Integer complaintState;
	/**提交时间*/
	@Excel(name="提交时间")
	private java.util.Date complaintTime;
	/**投诉图片*/
	private java.lang.String complaintImage;
	/**处理完成时间*/
	@Excel(name="处理完成时间",format = "yyyy-MM-dd")
	private java.util.Date complaintEndtime;
	/**投诉与建议回复*/
	@Excel(name="投诉与建议回复")
	private java.lang.String complaintMsg;
	
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
	 *@return: java.lang.String  会员姓名
	 */
	@Column(name ="COMPLAINT_MEMBERNAME",nullable=true,length=32)
	public java.lang.String getComplaintMembername(){
		return this.complaintMembername;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  会员姓名
	 */
	public void setComplaintMembername(java.lang.String complaintMembername){
		this.complaintMembername = complaintMembername;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系方式
	 */
	@Column(name ="COMPLAINT_PHONE",nullable=true,length=32)
	public java.lang.String getComplaintPhone(){
		return this.complaintPhone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系方式
	 */
	public void setComplaintPhone(java.lang.String complaintPhone){
		this.complaintPhone = complaintPhone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  反馈内容
	 */
	@Column(name ="COMPLAINT_CONTENT",nullable=true,length=32)
	public java.lang.String getComplaintContent(){
		return this.complaintContent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  反馈内容
	 */
	public void setComplaintContent(java.lang.String complaintContent){
		this.complaintContent = complaintContent;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  问题类型
	 */
	@Column(name ="COMPLAINT_TYPE",nullable=true,length=32)
	public java.lang.String getComplaintType(){
		return this.complaintType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  问题类型
	 */
	public void setComplaintType(java.lang.String complaintType){
		this.complaintType = complaintType;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  处理状态
	 */
	@Column(name ="COMPLAINT_STATE",nullable=true,length=1)
	public java.lang.Integer getComplaintState(){
		return this.complaintState;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  处理状态
	 */
	public void setComplaintState(java.lang.Integer complaintState){
		this.complaintState = complaintState;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  提交时间
	 */
	@Column(name ="COMPLAINT_TIME",nullable=true,length=32)
	public java.util.Date getComplaintTime(){
		return this.complaintTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  提交时间
	 */
	public void setComplaintTime(java.util.Date complaintTime){
		this.complaintTime = complaintTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  投诉图片
	 */
	@Column(name ="COMPLAINT_IMAGE",nullable=true,length=500)
	public java.lang.String getComplaintImage(){
		return this.complaintImage;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  投诉图片
	 */
	public void setComplaintImage(java.lang.String complaintImage){
		this.complaintImage = complaintImage;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  处理完成时间
	 */
	@Column(name ="COMPLAINT_ENDTIME",nullable=true,length=32)
	public java.util.Date getComplaintEndtime(){
		return this.complaintEndtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  处理完成时间
	 */
	public void setComplaintEndtime(java.util.Date complaintEndtime){
		this.complaintEndtime = complaintEndtime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  投诉与建议回复
	 */
	@Column(name ="COMPLAINT_MSG",nullable=true,length=500)
	public java.lang.String getComplaintMsg(){
		return this.complaintMsg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  投诉与建议回复
	 */
	public void setComplaintMsg(java.lang.String complaintMsg){
		this.complaintMsg = complaintMsg;
	}
}
