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
 * @Description: 商城产品介绍
 * @author onlineGenerator
 * @date 2017-07-10 10:13:37
 * @version V1.0   
 *
 */
@Entity
@Table(name = "w_mall_introduce", schema = "")
@SuppressWarnings("serial")
public class WMallIntroduceEntity implements java.io.Serializable {
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
	/**商城产品id*/
	private java.lang.String mallId;
	/**产品标题*/
	@Excel(name="产品标题")
	private java.lang.String title;
	/**产品介绍*/
	@Excel(name="产品介绍")
	private java.lang.String introduce;
	/**押金*/
	@Excel(name="押金")
	private java.lang.String deposit;
	/**颜色*/
	@Excel(name="颜色")
	private java.lang.String colour;
	/**品牌*/
	@Excel(name="品牌")
	private java.lang.String brand;
	/**型号*/
	@Excel(name="型号")
	private java.lang.String model;
	/**安装方式*/
	@Excel(name="安装方式")
	private java.lang.String mode;
	/**过滤原理*/
	@Excel(name="过滤原理")
	private java.lang.String principle;
	/**额定净水量*/
	@Excel(name="额定净水量")
	private java.lang.String netWater;
	/**产品尺寸*/
	@Excel(name="产品尺寸")
	private java.lang.String size;
	/**产品净重*/
	@Excel(name="产品净重")
	private java.lang.String netWeight;
	/**净流水量*/
	@Excel(name="净流水量")
	private java.lang.String water;
	/**商品描述*/
	@Excel(name="商品描述")
	private java.lang.String commodityDescribe;
	/**详情图片*/
	@Excel(name="详情图片")
	private java.lang.String detailsPicture;
	
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
	 *@return: java.lang.String  商城产品id
	 */
	@Column(name ="MALL_ID",nullable=true,length=36)
	public java.lang.String getMallId(){
		return this.mallId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商城产品id
	 */
	public void setMallId(java.lang.String mallId){
		this.mallId = mallId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品标题
	 */
	@Column(name ="TITLE",nullable=true,length=32)
	public java.lang.String getTitle(){
		return this.title;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品标题
	 */
	public void setTitle(java.lang.String title){
		this.title = title;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品介绍
	 */
	@Column(name ="INTRODUCE",nullable=true,length=100)
	public java.lang.String getIntroduce(){
		return this.introduce;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品介绍
	 */
	public void setIntroduce(java.lang.String introduce){
		this.introduce = introduce;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  押金
	 */
	@Column(name ="DEPOSIT",nullable=true,length=32)
	public java.lang.String getDeposit(){
		return this.deposit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  押金
	 */
	public void setDeposit(java.lang.String deposit){
		this.deposit = deposit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  颜色
	 */
	@Column(name ="COLOUR",nullable=true,length=32)
	public java.lang.String getColour(){
		return this.colour;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  颜色
	 */
	public void setColour(java.lang.String colour){
		this.colour = colour;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  品牌
	 */
	@Column(name ="BRAND",nullable=true,length=32)
	public java.lang.String getBrand(){
		return this.brand;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  品牌
	 */
	public void setBrand(java.lang.String brand){
		this.brand = brand;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  型号
	 */
	@Column(name ="MODEL",nullable=true,length=32)
	public java.lang.String getModel(){
		return this.model;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  型号
	 */
	public void setModel(java.lang.String model){
		this.model = model;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  安装方式
	 */
	@Column(name ="MODE",nullable=true,length=32)
	public java.lang.String getMode(){
		return this.mode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  安装方式
	 */
	public void setMode(java.lang.String mode){
		this.mode = mode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  过滤原理
	 */
	@Column(name ="PRINCIPLE",nullable=true,length=32)
	public java.lang.String getPrinciple(){
		return this.principle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  过滤原理
	 */
	public void setPrinciple(java.lang.String principle){
		this.principle = principle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  额定净水量
	 */
	@Column(name ="NET_WATER",nullable=true,length=32)
	public java.lang.String getNetWater(){
		return this.netWater;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  额定净水量
	 */
	public void setNetWater(java.lang.String netWater){
		this.netWater = netWater;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品尺寸
	 */
	@Column(name ="SIZE",nullable=true,length=32)
	public java.lang.String getSize(){
		return this.size;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品尺寸
	 */
	public void setSize(java.lang.String size){
		this.size = size;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品净重
	 */
	@Column(name ="NET_WEIGHT",nullable=true,length=32)
	public java.lang.String getNetWeight(){
		return this.netWeight;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品净重
	 */
	public void setNetWeight(java.lang.String netWeight){
		this.netWeight = netWeight;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  净流水量
	 */
	@Column(name ="WATER",nullable=true,length=32)
	public java.lang.String getWater(){
		return this.water;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  净流水量
	 */
	public void setWater(java.lang.String water){
		this.water = water;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品描述
	 */
	@Column(name ="COMMODITY_DESCRIBE",nullable=true,length=100)
	public java.lang.String getCommodityDescribe(){
		return this.commodityDescribe;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品描述
	 */
	public void setCommodityDescribe(java.lang.String commodityDescribe){
		this.commodityDescribe = commodityDescribe;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  详情图片
	 */
	@Column(name ="DETAILS_PICTURE",nullable=true,length=500)
	public java.lang.String getDetailsPicture(){
		return this.detailsPicture;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  详情图片
	 */
	public void setDetailsPicture(java.lang.String detailsPicture){
		this.detailsPicture = detailsPicture;
	}
}
