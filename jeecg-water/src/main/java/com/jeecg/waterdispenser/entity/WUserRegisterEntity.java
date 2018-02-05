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
 * @Description: 用户注册表
 * @author onlineGenerator
 * @date 2017-05-29 23:10:15
 * @version V1.0   
 *
 */
@Entity
@Table(name = "w_user_register", schema = "")
@SuppressWarnings("serial")
public class WUserRegisterEntity implements java.io.Serializable {
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
	/**会员联系方式*/
	private java.lang.String memberPhone;
	/**用户名*/
	@Excel(name="用户名")
	private java.lang.String registerName;
	/**手机号码*/
	@Excel(name="手机号码")
	private java.lang.String registerPhone;
	/**关联会员*/
	@Excel(name="关联会员")
	private java.lang.String registerRelation;
	/**密码*/
	private java.lang.String passWord;
	/**用户类型*/
	@Excel(name="用户类型")
	private java.lang.String registerType;
	/**账号状态*/
	@Excel(name="账号状态")
	private java.lang.Integer registerState;
	/**头像*/
	private java.lang.String registerHead;
	/**亲属关系*/
	private java.lang.String registerRelatives;
	/**关联会员id*/
	private java.lang.String registerMemberId;
	
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
	 *@return: java.lang.String  用户名
	 */
	@Column(name ="REGISTER_NAME",nullable=true,length=32)
	public java.lang.String getRegisterName(){
		return this.registerName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户名
	 */
	public void setRegisterName(java.lang.String registerName){
		this.registerName = registerName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  手机号码
	 */
	@Column(name ="REGISTER_PHONE",nullable=true,length=32)
	public java.lang.String getRegisterPhone(){
		return this.registerPhone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  手机号码
	 */
	public void setRegisterPhone(java.lang.String registerPhone){
		this.registerPhone = registerPhone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  关联会员
	 */
	@Column(name ="REGISTER_RELATION",nullable=true,length=32)
	public java.lang.String getRegisterRelation(){
		return this.registerRelation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  关联会员
	 */
	public void setRegisterRelation(java.lang.String registerRelation){
		this.registerRelation = registerRelation;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  密码
	 */
	@Column(name ="PASS_WORD",nullable=true,length=32)
	public java.lang.String getPassWord(){
		return this.passWord;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  密码
	 */
	public void setPassWord(java.lang.String passWord){
		this.passWord = passWord;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户类型
	 */
	@Column(name ="REGISTER_TYPE",nullable=true,length=32)
	public java.lang.String getRegisterType(){
		return this.registerType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户类型
	 */
	public void setRegisterType(java.lang.String registerType){
		this.registerType = registerType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  账号状态
	 */
	@Column(name ="REGISTER_STATE",nullable=true,length=32)
	public java.lang.Integer getRegisterState(){
		return this.registerState;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  账号状态
	 */
	public void setRegisterState(java.lang.Integer registerState){
		this.registerState = registerState;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  头像
	 */
	@Column(name ="REGISTER_HEAD",nullable=true,length=32)
	public java.lang.String getRegisterHead(){
		return this.registerHead;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  头像
	 */
	public void setRegisterHead(java.lang.String registerHead){
		this.registerHead = registerHead;
	}
	
	@Column(name ="REGISTER_RELATIVES",nullable=true,length=32)
	public java.lang.String getRegisterRelatives() {
		return registerRelatives;
	}

	public void setRegisterRelatives(java.lang.String registerRelatives) {
		this.registerRelatives = registerRelatives;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  关联会员id
	 */
	@Column(name ="REGISTER_MEMBER_ID",nullable=true,length=32)
	public java.lang.String getRegisterMemberId(){
		return this.registerMemberId;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  关联会员id
	 */
	public void setRegisterMemberId(java.lang.String registerMemberId){
		this.registerMemberId = registerMemberId;
	}
}
