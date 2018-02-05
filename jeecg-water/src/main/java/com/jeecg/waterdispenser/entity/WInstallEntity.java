package com.jeecg.waterdispenser.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

import com.sun.star.lib.uno.environments.java.java_environment;

/**   
 * @Title: Entity
 * @Description: 安装管理表
 * @author onlineGenerator
 * @date 2017-07-06 14:27:49
 * @version V1.0   
 *
 */
@Entity
@Table(name = "w_install", schema = "")
@SuppressWarnings("serial")
public class WInstallEntity implements java.io.Serializable {
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
	/**安装进度*/
	@Excel(name="安装进度")
	private java.lang.String installProgress;
	/**会员姓名*/
	@Excel(name="会员姓名")
	private java.lang.String installMembername;
	/**会员联系方式*/
	@Excel(name="会员联系方式")
	private java.lang.String instalPhont;
	/**安装地址*/
	@Excel(name="安装地址")
	private java.lang.String installAddress;
	/**水表编号*/
	@Excel(name="水表编号")
	private java.lang.String installNumber;
	/**安装来源*/
	@Excel(name="安装来源")
	private java.lang.String installSource;
	/**安装工*/
	@Excel(name="安装工")
	private java.lang.String installWorker;
	/**安装时间*/
	@Excel(name="安装时间",format = "yyyy-MM-dd")
	private java.util.Date installTime;
	/**安装等级信息*/
	@Excel(name="安装等级信息")
	private java.lang.String installMessage;
	/**位置签到*/
	@Excel(name="位置签到")
	private java.lang.String installSign;
	/**提交照片*/
	@Excel(name="提交照片")
	private java.lang.String installSubphoto;
	/**证件*/
	@Excel(name="证件")
	private java.lang.String installCertificates;
	/**合同*/
	@Excel(name="合同")
	private java.lang.String installContract;
	@Excel(name="当前水量")
	private java.lang.Integer installWater;
	@Excel(name="滤芯")
	private java.lang.String installFilterId;
	@Excel(name="更换滤芯前水量")
	private java.lang.Integer installFilterWater;
	@Excel(name="安装完成时间")
	private java.util.Date installEndtime;
	@Excel(name="安装公司id")
	private java.lang.String installWorkerId;
	/**会员id*/
	@Excel(name="会员id")
	private java.lang.String memberId;
	/**安装工人id*/
	@Excel(name="安装工人id")
	private java.lang.String installErectorId;
	/**安装工人姓名*/
	@Excel(name="安装工人姓名")
	private java.lang.String installErectorName;
	
	
	
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
	 *@return: java.lang.String  安装进度
	 */
	@Column(name ="INSTALL_PROGRESS",nullable=true,length=32)
	public java.lang.String getInstallProgress(){
		return this.installProgress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  安装进度
	 */
	public void setInstallProgress(java.lang.String installProgress){
		this.installProgress = installProgress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  会员姓名
	 */
	@Column(name ="INSTALL_MEMBERNAME",nullable=true,length=32)
	public java.lang.String getInstallMembername(){
		return this.installMembername;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  会员姓名
	 */
	public void setInstallMembername(java.lang.String installMembername){
		this.installMembername = installMembername;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  会员联系方式
	 */
	@Column(name ="INSTAL_PHONT",nullable=true,length=32)
	public java.lang.String getInstalPhont(){
		return this.instalPhont;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  会员联系方式
	 */
	public void setInstalPhont(java.lang.String instalPhont){
		this.instalPhont = instalPhont;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  安装地址
	 */
	@Column(name ="INSTALL_ADDRESS",nullable=true,length=32)
	public java.lang.String getInstallAddress(){
		return this.installAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  安装地址
	 */
	public void setInstallAddress(java.lang.String installAddress){
		this.installAddress = installAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  水表编号
	 */
	@Column(name ="INSTALL_NUMBER",nullable=true,length=32)
	public java.lang.String getInstallNumber(){
		return this.installNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  水表编号
	 */
	public void setInstallNumber(java.lang.String installNumber){
		this.installNumber = installNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  安装来源
	 */
	@Column(name ="INSTALL_SOURCE",nullable=true,length=32)
	public java.lang.String getInstallSource(){
		return this.installSource;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  安装来源
	 */
	public void setInstallSource(java.lang.String installSource){
		this.installSource = installSource;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  安装工
	 */
	@Column(name ="INSTALL_WORKER",nullable=true,length=32)
	public java.lang.String getInstallWorker(){
		return this.installWorker;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  安装工
	 */
	public void setInstallWorker(java.lang.String installWorker){
		this.installWorker = installWorker;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  安装时间
	 */
	@Column(name ="INSTALL_TIME",nullable=true,length=32)
	public java.util.Date getInstallTime(){
		return this.installTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  安装时间
	 */
	public void setInstallTime(java.util.Date installTime){
		this.installTime = installTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  安装等级信息
	 */
	@Column(name ="INSTALL_MESSAGE",nullable=true,length=32)
	public java.lang.String getInstallMessage(){
		return this.installMessage;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  安装等级信息
	 */
	public void setInstallMessage(java.lang.String installMessage){
		this.installMessage = installMessage;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  位置签到
	 */
	@Column(name ="INSTALL_SIGN",nullable=true,length=32)
	public java.lang.String getInstallSign(){
		return this.installSign;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  位置签到
	 */
	public void setInstallSign(java.lang.String installSign){
		this.installSign = installSign;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  提交照片
	 */
	@Column(name ="INSTALL_SUBPHOTO",nullable=true,length=100)
	public java.lang.String getInstallSubphoto(){
		return this.installSubphoto;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  提交照片
	 */
	public void setInstallSubphoto(java.lang.String installSubphoto){
		this.installSubphoto = installSubphoto;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证件
	 */
	@Column(name ="INSTALL_CERTIFICATES",nullable=true,length=100)
	public java.lang.String getInstallCertificates() {
		return installCertificates;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证件
	 */
	public void setInstallCertificates(java.lang.String installCertificates) {
		this.installCertificates = installCertificates;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同
	 */
	@Column(name ="INSTALL_CONTRACT",nullable=true,length=100)
	public java.lang.String getInstallContract() {
		return installContract;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同
	 */
	public void setInstallContract(java.lang.String installContract) {
		this.installContract = installContract;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  当前水量
	 */
	@Column(name ="INSTALL_WATER",nullable=true,length=11)
	public java.lang.Integer getInstallWater() {
		return installWater;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  当前水量
	 */
	public void setInstallWater(java.lang.Integer installWater) {
		this.installWater = installWater;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  滤芯
	 */
	@Column(name ="INSTALL_FILTER_ID",nullable=true,length=36)
	public java.lang.String getInstallFilterId() {
		return installFilterId;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  滤芯
	 */
	public void setInstallFilterId(java.lang.String installFilterId) {
		this.installFilterId = installFilterId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  更换滤芯前水量
	 */
	@Column(name ="INSTALL_FILTER_WATER",nullable=true,length=11)
	public java.lang.Integer getInstallFilterWater() {
		return installFilterWater;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  更换滤芯前水量
	 */
	public void setInstallFilterWater(java.lang.Integer installFilterWater) {
		this.installFilterWater = installFilterWater;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  安装完成时间
	 */
	@Column(name ="INSTALL_ENDTIME",nullable=true,length=32)
	public java.util.Date getInstallEndtime() {
		return installEndtime;
	}
	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  安装完成时间
	 */
	public void setInstallEndtime(java.util.Date installEndtime) {
		this.installEndtime = installEndtime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  安装公司id
	 */
	@Column(name ="INSTALL_WORKER_ID",nullable=true,length=32)
	public java.lang.String getInstallWorkerId() {
		return installWorkerId;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  安装公司id
	 */
	public void setInstallWorkerId(java.lang.String installWorkerId) {
		this.installWorkerId = installWorkerId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  会员id
	 */
	@Column(name ="MEMBER_ID",nullable=true,length=36)
	public java.lang.String getMemberId() {
		return memberId;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  会员id
	 */
	public void setMemberId(java.lang.String memberId) {
		this.memberId = memberId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  安装工人id
	 */
	@Column(name ="INSTALL_ERECTOR_ID",nullable=true,length=36)
	public java.lang.String getInstallErectorId() {
		return installErectorId;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  安装工人id
	 */
	public void setInstallErectorId(java.lang.String installErectorId) {
		this.installErectorId = installErectorId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  安装工人姓名
	 */
	@Column(name ="INSTALL_ERECTOR_NAME",nullable=true,length=36)
	public java.lang.String getInstallErectorName() {
		return installErectorName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  安装工人姓名
	 */
	public void setInstallErectorName(java.lang.String installErectorName) {
		this.installErectorName = installErectorName;
	}
}
