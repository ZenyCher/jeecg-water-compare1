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
 * @Description: 用户关联设备表
 * @author onlineGenerator
 * @date 2017-08-20 16:55:18
 * @version V1.0   
 *
 */
@Entity
@Table(name = "w_user_device", schema = "")
@SuppressWarnings("serial")
public class WUserDeviceEntity implements java.io.Serializable {
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
	@Excel(name="会员联系方式")
	private java.lang.String memberPhone;
	/**会员姓名*/
	@Excel(name="会员姓名")
	private java.lang.String memberName;
	/**设备id*/
	private java.lang.String deviceId;
	/**设备名称*/
	@Excel(name="设备名称")
	private java.lang.String deviceName;
	/**水表id*/
	private java.lang.String watermeterId;
	/**净水器类型*/
	@Excel(name="净水器类型")
	private java.lang.String deviceTypeId;
	/**净水器类型名称*/
	@Excel(name="净水器类型名称")
	private java.lang.String deviceTypeName;
	/**滤芯id_1*/
	private java.lang.String oneFilterId;
	/**滤芯更换读数_1*/
	private java.lang.Integer oneFilterName;
	/**滤芯id_2*/
	private java.lang.String twoFilterId;
	/**滤芯更换读数_2*/
	private java.lang.Integer twoFilterName;
	/**滤芯id_3*/
	private java.lang.String threeFilterId;
	/**滤芯更换读数_3*/
	private java.lang.Integer threeFilterName;
	/**滤芯id_4*/
	private java.lang.String fourFilterId;
	/**滤芯更换读数_4*/
	private java.lang.Integer fourFilterName;
	/**滤芯id_5*/
	private java.lang.String fiveFilterId;
	/**滤芯更换读数_5*/
	private java.lang.Integer fiveFilterName;
	/**滤芯id_6*/
	private java.lang.String sixFilterId;
	/**滤芯更换读数_6*/
	private java.lang.Integer sixFilterName;
	/**安装公司id*/
	private java.lang.String installErectorId;
	/**安装公司名称*/
	@Excel(name="安装公司名称")
	private java.lang.String installErectorName;
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
	 *@return: java.lang.String  会员联系方式
	 */
	@Column(name ="MEMBER_PHONE",nullable=true,length=15)
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
	 *@return: java.lang.String  水表id
	 */
	@Column(name ="WATERMETER_ID",nullable=true,length=36)
	public java.lang.String getWatermeterId(){
		return this.watermeterId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  水表id
	 */
	public void setWatermeterId(java.lang.String watermeterId){
		this.watermeterId = watermeterId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  净水器类型
	 */
	@Column(name ="DEVICE_TYPE_ID",nullable=true,length=32)
	public java.lang.String getDeviceTypeId(){
		return this.deviceTypeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  净水器类型
	 */
	public void setDeviceTypeId(java.lang.String deviceTypeId){
		this.deviceTypeId = deviceTypeId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  净水器类型名称
	 */
	@Column(name ="DEVICE_TYPE_NAME",nullable=true,length=32)
	public java.lang.String getDeviceTypeName(){
		return this.deviceTypeName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  净水器类型名称
	 */
	public void setDeviceTypeName(java.lang.String deviceTypeName){
		this.deviceTypeName = deviceTypeName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  滤芯id_1
	 */
	@Column(name ="ONE_FILTER_ID",nullable=true,length=32)
	public java.lang.String getOneFilterId(){
		return this.oneFilterId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  滤芯id_1
	 */
	public void setOneFilterId(java.lang.String oneFilterId){
		this.oneFilterId = oneFilterId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  滤芯更换读数_1
	 */
	@Column(name ="ONE_FILTER_NAME",nullable=true,length=32)
	public java.lang.Integer getOneFilterName(){
		return this.oneFilterName;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  滤芯更换读数_1
	 */
	public void setOneFilterName(java.lang.Integer oneFilterName){
		this.oneFilterName = oneFilterName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  滤芯id_2
	 */
	@Column(name ="TWO_FILTER_ID",nullable=true,length=32)
	public java.lang.String getTwoFilterId(){
		return this.twoFilterId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  滤芯id_2
	 */
	public void setTwoFilterId(java.lang.String twoFilterId){
		this.twoFilterId = twoFilterId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  滤芯更换读数_2
	 */
	@Column(name ="TWO_FILTER_NAME",nullable=true,length=32)
	public java.lang.Integer getTwoFilterName(){
		return this.twoFilterName;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  滤芯更换读数_2
	 */
	public void setTwoFilterName(java.lang.Integer twoFilterName){
		this.twoFilterName = twoFilterName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  滤芯id_3
	 */
	@Column(name ="THREE_FILTER_ID",nullable=true,length=32)
	public java.lang.String getThreeFilterId(){
		return this.threeFilterId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  滤芯id_3
	 */
	public void setThreeFilterId(java.lang.String threeFilterId){
		this.threeFilterId = threeFilterId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  滤芯更换读数_3
	 */
	@Column(name ="THREE_FILTER_NAME",nullable=true,length=32)
	public java.lang.Integer getThreeFilterName(){
		return this.threeFilterName;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  滤芯更换读数_3
	 */
	public void setThreeFilterName(java.lang.Integer threeFilterName){
		this.threeFilterName = threeFilterName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  滤芯id_4
	 */
	@Column(name ="FOUR_FILTER_ID",nullable=true,length=32)
	public java.lang.String getFourFilterId(){
		return this.fourFilterId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  滤芯id_4
	 */
	public void setFourFilterId(java.lang.String fourFilterId){
		this.fourFilterId = fourFilterId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  滤芯更换读数_4
	 */
	@Column(name ="FOUR_FILTER_NAME",nullable=true,length=32)
	public java.lang.Integer getFourFilterName(){
		return this.fourFilterName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  滤芯更换读数_4
	 */
	public void setFourFilterName(java.lang.Integer fourFilterName){
		this.fourFilterName = fourFilterName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  滤芯id_5
	 */
	@Column(name ="FIVE_FILTER_ID",nullable=true,length=32)
	public java.lang.String getFiveFilterId(){
		return this.fiveFilterId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  滤芯id_5
	 */
	public void setFiveFilterId(java.lang.String fiveFilterId){
		this.fiveFilterId = fiveFilterId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  滤芯更换读数_5
	 */
	@Column(name ="FIVE_FILTER_NAME",nullable=true,length=32)
	public java.lang.Integer getFiveFilterName(){
		return this.fiveFilterName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  滤芯更换读数_5
	 */
	public void setFiveFilterName(java.lang.Integer fiveFilterName){
		this.fiveFilterName = fiveFilterName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  滤芯id_6
	 */
	@Column(name ="SIX_FILTER_ID",nullable=true,length=32)
	public java.lang.String getSixFilterId(){
		return this.sixFilterId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  滤芯id_6
	 */
	public void setSixFilterId(java.lang.String sixFilterId){
		this.sixFilterId = sixFilterId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  滤芯更换读数_6
	 */
	@Column(name ="SIX_FILTER_NAME",nullable=true,length=32)
	public java.lang.Integer getSixFilterName(){
		return this.sixFilterName;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  滤芯更换读数_6
	 */
	public void setSixFilterName(java.lang.Integer sixFilterName){
		this.sixFilterName = sixFilterName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  安装公司id
	 */
	@Column(name ="INSTALL_ERECTOR_ID",nullable=true,length=32)
	public java.lang.String getInstallErectorId(){
		return this.installErectorId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  安装公司id
	 */
	public void setInstallErectorId(java.lang.String installErectorId){
		this.installErectorId = installErectorId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  安装公司名称
	 */
	@Column(name ="INSTALL_ERECTOR_NAME",nullable=true,length=32)
	public java.lang.String getInstallErectorName(){
		return this.installErectorName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  安装公司名称
	 */
	public void setInstallErectorName(java.lang.String installErectorName){
		this.installErectorName = installErectorName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  安装公司名称
	 */
	@Column(name ="MEMBER_ID",nullable=true,length=36)
	public java.lang.String getMemberId(){
		return this.memberId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  安装公司名称
	 */
	public void setMemberId(java.lang.String memberId){
		this.memberId = memberId;
	}
}
