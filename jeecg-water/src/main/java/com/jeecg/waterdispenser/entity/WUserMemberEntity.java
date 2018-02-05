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
 * @Description: 会员表
 * @author onlineGenerator
 * @date 2017-07-18 20:21:52
 * @version V1.0   
 *
 */
@Entity
@Table(name = "w_user_member", schema = "")
@SuppressWarnings("serial")
public class WUserMemberEntity implements java.io.Serializable {
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
	private java.lang.String memberName;
	/**联系方式*/
	@Excel(name="会员ID")
	private java.lang.String memberPhone;
	/**居住地址*/
	@Excel(name="居住地址")
	private java.lang.String memberAddress;
	/**水表id*/
	private java.lang.String memberId;
	/**当前剩余水量L*/
	private java.lang.String waterSurplus;
	/**会员类型*/
	@Excel(name="会员联系方式")
	private java.lang.String memberType;
	/**关联用户*/
	private java.lang.String memberUser;
	/**附件合同*/
	@Excel(name="附件合同")
	private java.lang.String menberContract;
	/**附件证件*/
	@Excel(name="附件证件")
	private java.lang.String menberCertificates;
	/**来源*/
	@Excel(name="初始水量")
	private java.lang.String memberInitialWater;
	/**押金*/
	@Excel(name="押金")
	private java.lang.Integer memberDeposit;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String memberRemarks;
	/**是否有效*/
	private java.lang.Integer memberState;
	/**套餐类型*/
	@Excel(name="套餐类型")
	private java.lang.String memberPackageType;
	/**套餐类型id*/
	@Excel(name="初装套餐类型id")
	private java.lang.String memberPackageId;
	/**套餐类型描述*/
	@Excel(name="初装套餐类型描述")
	private java.lang.String memberPackageMsg;
	/**净水器型号*/
	@Excel(name="净水器型号")
	private java.lang.String memberDeviceType;
	/**净水器型号id*/
	@Excel(name="净水器型号id")
	private java.lang.String memberDeviceId;
	/**套餐类型id*/
	@Excel(name="正常套餐类型id")
	private java.lang.String memberNormalPackageId;
	/**套餐类型描述*/
	@Excel(name="正常套餐类型描述")
	private java.lang.String memberNormalPackageMsg;
	/**来源*/
	@Excel(name="来源")
	private java.lang.Integer memberSource;
	/**指派安装公司*/
	@Excel(name="指派安装公司")
	private java.lang.String memberAssignInstall;
	/**设备id*/
	@Excel(name="设备id")
	private java.lang.String deviceId;
	
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
	 *@return: java.lang.String  联系方式
	 */
	@Column(name ="MEMBER_PHONE",nullable=true,length=32)
	public java.lang.String getMemberPhone(){
		return this.memberPhone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系方式
	 */
	public void setMemberPhone(java.lang.String memberPhone){
		this.memberPhone = memberPhone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  居住地址
	 */
	@Column(name ="MEMBER_ADDRESS",nullable=true,length=32)
	public java.lang.String getMemberAddress(){
		return this.memberAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  居住地址
	 */
	public void setMemberAddress(java.lang.String memberAddress){
		this.memberAddress = memberAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  水表id
	 */
	@Column(name ="MEMBER_ID",nullable=true,length=32)
	public java.lang.String getMemberId(){
		return this.memberId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  水表id
	 */
	public void setMemberId(java.lang.String memberId){
		this.memberId = memberId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  当前剩余水量L
	 */
	@Column(name ="WATER_SURPLUS",nullable=true,length=32)
	public java.lang.String getWaterSurplus(){
		return this.waterSurplus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  当前剩余水量L
	 */
	public void setWaterSurplus(java.lang.String waterSurplus){
		this.waterSurplus = waterSurplus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  会员联系方式
	 */
	@Column(name ="MEMBER_TYPE",nullable=true,length=32)
	public java.lang.String getMemberType(){
		return this.memberType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  会员联系方式
	 */
	public void setMemberType(java.lang.String memberType){
		this.memberType = memberType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  关联用户
	 */
	@Column(name ="MEMBER_USER",nullable=true,length=32)
	public java.lang.String getMemberUser(){
		return this.memberUser;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  关联用户
	 */
	public void setMemberUser(java.lang.String memberUser){
		this.memberUser = memberUser;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  附件合同
	 */
	@Column(name ="MENBER_CONTRACT",nullable=true,length=100)
	public java.lang.String getMenberContract(){
		return this.menberContract;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附件合同
	 */
	public void setMenberContract(java.lang.String menberContract){
		this.menberContract = menberContract;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  附件证件
	 */
	@Column(name ="MENBER_CERTIFICATES",nullable=true,length=100)
	public java.lang.String getMenberCertificates(){
		return this.menberCertificates;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附件证件
	 */
	public void setMenberCertificates(java.lang.String menberCertificates){
		this.menberCertificates = menberCertificates;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  初始水量
	 */
	@Column(name ="MEMBER_INITIAL_WATER",nullable=true,length=32)
	public java.lang.String getMemberInitialWater(){
		return this.memberInitialWater;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  初始水量
	 */
	public void setMemberInitialWater(java.lang.String memberInitialWater){
		this.memberInitialWater = memberInitialWater;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  押金
	 */
	@Column(name ="MEMBER_DEPOSIT",nullable=true,length=32)
	public java.lang.Integer getMemberDeposit(){
		return this.memberDeposit;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  押金
	 */
	public void setMemberDeposit(java.lang.Integer memberDeposit){
		this.memberDeposit = memberDeposit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="MEMBER_REMARKS",nullable=true,length=100)
	public java.lang.String getMemberRemarks(){
		return this.memberRemarks;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setMemberRemarks(java.lang.String memberRemarks){
		this.memberRemarks = memberRemarks;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否有效
	 */
	@Column(name ="MEMBER_STATE",nullable=true,length=1)
	public java.lang.Integer getMemberState(){
		return this.memberState;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否有效
	 */
	public void setMemberState(java.lang.Integer memberState){
		this.memberState = memberState;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  套餐类型
	 */
	@Column(name ="MEMBER_PACKAGE_TYPE",nullable=true,length=32)
	public java.lang.String getMemberPackageType(){
		return this.memberPackageType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  套餐类型
	 */
	public void setMemberPackageType(java.lang.String memberPackageType){
		this.memberPackageType = memberPackageType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  净水器型号
	 */
	@Column(name ="MEMBER_DEVICE_TYPE",nullable=true,length=32)
	public java.lang.String getMemberDeviceType(){
		return this.memberDeviceType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  净水器型号
	 */
	public void setMemberDeviceType(java.lang.String memberDeviceType){
		this.memberDeviceType = memberDeviceType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  净水器型号id
	 */
	@Column(name ="MEMBER_DEVICE_Id",nullable=true,length=32)
	public java.lang.String getMemberDeviceId(){
		return this.memberDeviceId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  净水器型id
	 */
	public void setMemberDeviceId(java.lang.String memberDeviceId){
		this.memberDeviceId = memberDeviceId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  初装套餐类型id
	 */
	@Column(name ="MEMBER_PACKAGE_Id",nullable=true,length=32)
	public java.lang.String getMemberPackageId(){
		return this.memberPackageId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String 初装套餐类型id
	 */
	public void setMemberPackageId(java.lang.String memberPackageId){
		this.memberPackageId = memberPackageId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  初装套餐类型描述
	 */
	@Column(name ="MEMBER_PACKAGE_MSG",nullable=true,length=200)
	public java.lang.String getMemberPackageMsg(){
		return this.memberPackageMsg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  初装套餐类型描述
	 */
	public void setMemberPackageMsg(java.lang.String memberPackageMsg){
		this.memberPackageMsg = memberPackageMsg;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  平常套餐类型id
	 */
	@Column(name ="MEMBER_NORMAL_PACKAGE_Id",nullable=true,length=36)
	public java.lang.String getMemberNormalPackageId(){
		return this.memberNormalPackageId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  平常套餐类型id
	 */
	public void setMemberNormalPackageId(java.lang.String memberNormalPackageId){
		this.memberNormalPackageId = memberNormalPackageId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  平常套餐类型描述
	 */
	@Column(name ="MEMBER_NORMAL_PACKAGE_MSG",nullable=true,length=200)
	public java.lang.String getMemberNormalPackageMsg(){
		return this.memberNormalPackageMsg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  平常套餐类型描述
	 */
	public void setMemberNormalPackageMsg(java.lang.String memberNormalPackageMsg){
		this.memberNormalPackageMsg = memberNormalPackageMsg;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  来源
	 */
	@Column(name ="MEMBER_SOURCE",nullable=true,length=500)
	public java.lang.Integer getMemberSource() {
		return memberSource;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  来源
	 */
	public void setMemberSource(java.lang.Integer memberSource) {
		this.memberSource = memberSource;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  指派安装公司
	 */
	@Column(name ="MEMBER_ASSIGN_INSTALL",nullable=true,length=200)
	public java.lang.String getMemberAssignInstall(){
		return this.memberAssignInstall;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  指派安装公司
	 */
	public void setMemberAssignInstall(java.lang.String memberAssignInstall){
		this.memberAssignInstall = memberAssignInstall;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  设备id
	 */
	@Column(name ="DEVICE_ID",nullable=true,length=36)
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
}
