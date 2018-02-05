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
 * @Description: 净水器商城
 * @author onlineGenerator
 * @date 2017-06-02 21:29:31
 * @version V1.0   
 *
 */
@Entity
@Table(name = "w_mall", schema = "")
@SuppressWarnings("serial")
public class WMallEntity implements java.io.Serializable {
	/**id*/
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
	/**产品名称*/
	@Excel(name="产品名称")
	private java.lang.String mallName;
	/**所需押金元*/
	@Excel(name="所需押金元")
	private java.lang.String mallDeposit;
	/**产品图片*/
	@Excel(name="产品图片")
	private java.lang.String mallImage;
	/**产品说明*/
	@Excel(name="产品说明")
	private java.lang.String mallExplain;
	/**操作手册*/
	@Excel(name="操作手册")
	private java.lang.String mallOperation;
	/**产品类型id*/
	@Excel(name="产品类型id")
	private java.lang.String mallDeviceTypeId;
	/**净水器型号*/
	@Excel(name="净水器类型")
	private java.lang.String mallDeviceType;
	/**净水器名称*/
	@Excel(name="净水器名称")
	private java.lang.String mallDeviceName;
	/**净水器滤芯数量*/
	@Excel(name="滤芯数量")
	private java.lang.Integer mallFilterNum;
	
	
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
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
	 *@param: java.lang.String  id
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品名称
	 */
	@Column(name ="MALL_NAME",nullable=true,length=32)
	public java.lang.String getMallName(){
		return this.mallName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品名称
	 */
	public void setMallName(java.lang.String mallName){
		this.mallName = mallName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所需押金元
	 */
	@Column(name ="MALL_DEPOSIT",nullable=true,length=32)
	public java.lang.String getMallDeposit(){
		return this.mallDeposit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所需押金元
	 */
	public void setMallDeposit(java.lang.String mallDeposit){
		this.mallDeposit = mallDeposit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品图片
	 */
	@Column(name ="MALL_IMAGE",nullable=true,length=100)
	public java.lang.String getMallImage(){
		return this.mallImage;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品图片
	 */
	public void setMallImage(java.lang.String mallImage){
		this.mallImage = mallImage;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品说明
	 */
	@Column(name ="MALL_EXPLAIN",nullable=true,length=32)
	public java.lang.String getMallExplain(){
		return this.mallExplain;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品说明
	 */
	public void setMallExplain(java.lang.String mallExplain){
		this.mallExplain = mallExplain;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  操作手册
	 */
	@Column(name ="MALL_OPERATION",nullable=true,length=100)
	public java.lang.String getMallOperation(){
		return this.mallOperation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  操作手册
	 */
	public void setMallOperation(java.lang.String mallOperation){
		this.mallOperation = mallOperation;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  净水器类型ID
	 */
	@Column(name ="MALL_DEVICE_TYPE_ID",nullable=true,length=36)
	public java.lang.String getMallDeviceTypeId(){
		return this.mallDeviceTypeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  净水器类型ID
	 */
	public void setMallDeviceTypeId(java.lang.String mallDeviceTypeId){
		this.mallDeviceTypeId = mallDeviceTypeId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  净水器型号
	 */
	@Column(name ="MALL_DEVICE_TYPE",nullable=true,length=50)
	public java.lang.String getMallDeviceType(){
		return this.mallDeviceType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  净水器型号
	 */
	public void setMallDeviceType(java.lang.String mallDeviceType){
		this.mallDeviceType = mallDeviceType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  净水器名称
	 */
	@Column(name ="MALL_DEVICE_NAME",nullable=true,length=50)
	public java.lang.String getmallDeviceName(){
		return this.mallDeviceName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  净水器名称
	 */
	public void setmallDeviceName(java.lang.String mallDeviceName){
		this.mallDeviceName = mallDeviceName;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  滤芯数量
	 */
	@Column(name ="MALL_FILTER_NUM",nullable=true,length=1)
	public java.lang.Integer getMallFilterNum(){
		return this.mallFilterNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  滤芯数量
	 */
	public void setMallFilterNum(java.lang.Integer mallFilterNum){
		this.mallFilterNum = mallFilterNum;
	}
}
