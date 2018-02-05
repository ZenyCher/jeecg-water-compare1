package com.jeecg.waterdispenser.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.tools.ant.taskdefs.Java;
import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: w_maintain
 * @author onlineGenerator
 * @date 2017-07-23 13:58:37
 * @version V1.0   
 *
 */
@Entity
@Table(name = "w_maintain", schema = "")
@SuppressWarnings("serial")
public class WMaintainEntity implements java.io.Serializable {
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
	/**维护状态*/
	@Excel(name="维护状态")
	private java.lang.Integer maintainState;
	/**设备id*/
	private java.lang.String deviceId;
	/**维护负责人id*/
	private java.lang.String registerId;
	/**维护负责人*/
	@Excel(name="维护负责人")
	private java.lang.String registerName;
	/**维护类型*/
	@Excel(name="维护类型")
	private java.lang.String maintainType;
	/**会员姓名*/
	@Excel(name="会员姓名")
	private java.lang.String memberName;
	/**联系方式*/
	@Excel(name="联系方式")
	private java.lang.String memberPhone;
	/**维护地址*/
	@Excel(name="维护地址")
	private java.lang.String memberAddress;
	/**需服务内容*/
	@Excel(name="需服务内容")
	private java.lang.String maintainService;
	/**维护时间*/
	@Excel(name="维护时间",format = "yyyy-MM-dd")
	private java.util.Date maintainTime;
	/**维护记录*/
	@Excel(name="维护记录")
	private java.lang.String maintainRecord;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String maintainRemarks;
	/**位置签到*/
	@Excel(name="位置签到")
	private java.lang.String maintainSign;
	/**提交照片*/
	@Excel(name="提交照片")
	private java.lang.String maintainSubphoto;
	/**维护完成时间*/
	@Excel(name="维护完成时间")
	private java.util.Date maintainEndtime;
	/**维护滤芯*/
	@Excel(name="维护滤芯")
	private java.lang.String maintainFilter;
	/**维护时滤芯水量*/
	@Excel(name="维护滤芯水量")
	private java.lang.Integer maintainWater;
	
	/**滤芯id_1*/
	@Excel(name="维护滤芯水量")
	private java.lang.String oneFilterId;
	/**滤芯更换读数_1*/
	@Excel(name="维护滤芯水量")
	private java.lang.String oneFilterName;
	/**滤芯id_2*/
	@Excel(name="维护滤芯水量")
	private java.lang.String twoFilterId;
	/**滤芯更换读数_2*/
	@Excel(name="维护滤芯水量")
	private java.lang.String twoFilterName;
	/**滤芯id_3*/
	@Excel(name="维护滤芯水量")
	private java.lang.String threeFilterId;
	/**滤芯更换读数_3*/
	@Excel(name="维护滤芯水量")
	private java.lang.String threeFilterName;
	/**滤芯id_4*/
	@Excel(name="维护滤芯水量")
	private java.lang.String fourFilterId;
	/**滤芯更换读数_4*/
	@Excel(name="维护滤芯水量")
	private java.lang.String fourFilterName;
	/**滤芯id_5*/
	@Excel(name="维护滤芯水量")
	private java.lang.String fiveFilterId;
	/**滤芯更换读数_5*/
	@Excel(name="维护滤芯水量")
	private java.lang.String fiveFilterName;
	/**滤芯id_6*/
	@Excel(name="维护滤芯水量")
	private java.lang.String sixFilterId;
	/**滤芯更换读数_6*/
	@Excel(name="维护滤芯水量")
	private java.lang.String sixFilterName;
	/**维护工人id*/
	@Excel(name="维护工人id")
	private java.lang.String maintainErectorId;
	/**维护工人名称*/
	@Excel(name="维护工人名称")
	private java.lang.String maintainErectorName;
	
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
	@Column(name ="CREATE_DATE",nullable=true)
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
	@Column(name ="UPDATE_DATE",nullable=true)
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  维护状态
	 */
	@Column(name ="MAINTAIN_STATE",nullable=true,length=1)
	public java.lang.Integer getMaintainState(){
		return this.maintainState;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  维护状态
	 */
	public void setMaintainState(java.lang.Integer maintainState){
		this.maintainState = maintainState;
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
	 *@return: java.lang.String  维护负责人id
	 */
	@Column(name ="REGISTER_ID",nullable=true,length=36)
	public java.lang.String getRegisterId(){
		return this.registerId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  维护负责人id
	 */
	public void setRegisterId(java.lang.String registerId){
		this.registerId = registerId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  维护负责人
	 */
	@Column(name ="REGISTER_NAME",nullable=true,length=32)
	public java.lang.String getRegisterName(){
		return this.registerName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  维护负责人
	 */
	public void setRegisterName(java.lang.String registerName){
		this.registerName = registerName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  维护类型
	 */
	@Column(name ="MAINTAIN_TYPE",nullable=true,length=32)
	public java.lang.String getMaintainType(){
		return this.maintainType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  维护类型
	 */
	public void setMaintainType(java.lang.String maintainType){
		this.maintainType = maintainType;
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
	 *@return: java.lang.String  维护地址
	 */
	@Column(name ="MEMBER_ADDRESS",nullable=true,length=32)
	public java.lang.String getMemberAddress(){
		return this.memberAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  维护地址
	 */
	public void setMemberAddress(java.lang.String memberAddress){
		this.memberAddress = memberAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  需服务内容
	 */
	@Column(name ="MAINTAIN_SERVICE",nullable=true,length=300)
	public java.lang.String getMaintainService(){
		return this.maintainService;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  需服务内容
	 */
	public void setMaintainService(java.lang.String maintainService){
		this.maintainService = maintainService;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  维护时间
	 */
	@Column(name ="MAINTAIN_TIME",nullable=true)
	public java.util.Date getMaintainTime(){
		return this.maintainTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  维护时间
	 */
	public void setMaintainTime(java.util.Date maintainTime){
		this.maintainTime = maintainTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  维护记录
	 */
	@Column(name ="MAINTAIN_RECORD",nullable=true,length=100)
	public java.lang.String getMaintainRecord(){
		return this.maintainRecord;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  维护记录
	 */
	public void setMaintainRecord(java.lang.String maintainRecord){
		this.maintainRecord = maintainRecord;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="MAINTAIN_REMARKS",nullable=true,length=100)
	public java.lang.String getMaintainRemarks(){
		return this.maintainRemarks;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setMaintainRemarks(java.lang.String maintainRemarks){
		this.maintainRemarks = maintainRemarks;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  位置签到
	 */
	@Column(name ="MAINTAIN_SIGN",nullable=true,length=32)
	public java.lang.String getMaintainSign(){
		return this.maintainSign;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  位置签到
	 */
	public void setMaintainSign(java.lang.String maintainSign){
		this.maintainSign = maintainSign;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  提交照片
	 */
	@Column(name ="MAINTAIN_SUBPHOTO",nullable=true,length=100)
	public java.lang.String getMaintainSubphoto(){
		return this.maintainSubphoto;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  提交照片
	 */
	public void setMaintainSubphoto(java.lang.String maintainSubphoto){
		this.maintainSubphoto = maintainSubphoto;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  维护完成时间
	 */
	@Column(name ="MAINTAIN_ENDTIME",nullable=true,length=32)
	public java.util.Date getMaintainEndtime(){
		return this.maintainEndtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  维护完成时间
	 */
	public void setMaintainEndtime(java.util.Date maintainEndtime){
		this.maintainEndtime = maintainEndtime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  维护滤芯
	 */
	@Column(name ="MAINTAIN_FILTER",nullable=true,length=50)
	public java.lang.String getMaintainFilter() {
		return maintainFilter;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  维护滤芯
	 */
	public void setMaintainFilter(java.lang.String maintainFilter) {
		this.maintainFilter = maintainFilter;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  维护滤芯时水量
	 */
	@Column(name ="MAINTAIN_WATER",nullable=true,length=11)
	public java.lang.Integer getMaintainWater() {
		return maintainWater;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  维护滤芯滤芯时水量
	 */
	public void setMaintainWater(java.lang.Integer maintainWater) {
		this.maintainWater = maintainWater;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  滤芯id_1
	 */
	@Column(name ="ONE_FILTER_ID",nullable=true,length=36)
	public java.lang.String getOneFilterId() {
		return oneFilterId;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  滤芯id_1
	 */
	public void setOneFilterId(java.lang.String oneFilterId) {
		this.oneFilterId = oneFilterId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  滤芯更换读数_1
	 */
	@Column(name ="ONE_FILTER_NAME",nullable=true,length=500)
	public java.lang.String getOneFilterName() {
		return oneFilterName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  滤芯更换读数_1
	 */
	public void setOneFilterName(java.lang.String oneFilterName) {
		this.oneFilterName = oneFilterName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  滤芯id_2
	 */
	@Column(name ="TWO_FILTER_ID",nullable=true,length=36)
	public java.lang.String getTwoFilterId() {
		return twoFilterId;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  滤芯id_2
	 */
	public void setTwoFilterId(java.lang.String twoFilterId) {
		this.twoFilterId = twoFilterId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  滤芯更换读数_2
	 */
	@Column(name ="TWO_FILTER_NAME",nullable=true,length=500)
	public java.lang.String getTwoFilterName() {
		return twoFilterName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  滤芯更换读数_2
	 */
	public void setTwoFilterName(java.lang.String twoFilterName) {
		this.twoFilterName = twoFilterName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  滤芯id_3
	 */
	@Column(name ="THREE_FILTER_ID",nullable=true,length=36)
	public java.lang.String getThreeFilterId() {
		return threeFilterId;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  滤芯id_3
	 */
	public void setThreeFilterId(java.lang.String threeFilterId) {
		this.threeFilterId = threeFilterId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  滤芯更换读数_3
	 */
	@Column(name ="THREE_FILTER_NAME",nullable=true,length=500)
	public java.lang.String getThreeFilterName() {
		return threeFilterName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  滤芯更换读数_3
	 */
	public void setThreeFilterName(java.lang.String threeFilterName) {
		this.threeFilterName = threeFilterName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  滤芯id_4
	 */
	@Column(name ="FOUR_FILTER_ID",nullable=true,length=36)
	public java.lang.String getFourFilterId() {
		return fourFilterId;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  滤芯id_4
	 */
	public void setFourFilterId(java.lang.String fourFilterId) {
		this.fourFilterId = fourFilterId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  滤芯更换读数_4
	 */
	@Column(name ="FOUR_FILTER_NAME",nullable=true,length=500)
	public java.lang.String getFourFilterName() {
		return fourFilterName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  滤芯更换读数_4
	 */
	public void setFourFilterName(java.lang.String fourFilterName) {
		this.fourFilterName = fourFilterName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  滤芯id_5
	 */
	@Column(name ="FIVE_FILTER_ID",nullable=true,length=36)
	public java.lang.String getFiveFilterId() {
		return fiveFilterId;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  滤芯id_5
	 */
	public void setFiveFilterId(java.lang.String fiveFilterId) {
		this.fiveFilterId = fiveFilterId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  滤芯更换读数_5
	 */
	@Column(name ="FIVE_FILTER_NAME",nullable=true,length=500)
	public java.lang.String getFiveFilterName() {
		return fiveFilterName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  滤芯更换读数_5
	 */
	public void setFiveFilterName(java.lang.String fiveFilterName) {
		this.fiveFilterName = fiveFilterName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  滤芯id_6
	 */
	@Column(name ="SIX_FILTER_ID",nullable=true,length=36)
	public java.lang.String getSixFilterId() {
		return sixFilterId;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  滤芯id_6
	 */
	public void setSixFilterId(java.lang.String sixFilterId) {
		this.sixFilterId = sixFilterId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  滤芯更换读数_6
	 */
	@Column(name ="SIX_FILTER_NAME",nullable=true,length=500)
	public java.lang.String getSixFilterName() {
		return sixFilterName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  滤芯更换读数_6
	 */
	public void setSixFilterName(java.lang.String sixFilterName) {
		this.sixFilterName = sixFilterName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  维护工人id
	 */
	@Column(name ="MAINTAIN_ERECTOR_ID",nullable=true,length=36)
	public java.lang.String getMaintainErectorId() {
		return maintainErectorId;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  维护工人id
	 */
	public void setMaintainErectorId(java.lang.String maintainErectorId) {
		this.maintainErectorId = maintainErectorId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  维护工人名称
	 */
	@Column(name ="MAINTAIN_ERECTOR_NAME",nullable=true,length=50)
	public java.lang.String getMaintainErectorName() {
		return maintainErectorName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  维护工人名称
	 */
	public void setMaintainErectorName(java.lang.String maintainErectorName) {
		this.maintainErectorName = maintainErectorName;
	}
}
