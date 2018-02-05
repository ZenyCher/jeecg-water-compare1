package org.jeecgframework.web.cgform.util;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * $.ajax后需要接受的JSON
 * 
 * @author
 * 
 */
public class TableJson {

	private boolean success = true;// 是否成功
	private String msg = "操作成功";// 提示信息
	private Integer tableType;
	private Object tableData = null;// 单表/主表信息
	private Map<String, Object> subTableDate;// 子表信息
	private boolean tokenValid = true;//token返回信息
	private Object deviceTable = null;//净水器表信息
	private Object deviceTypeTable = null;//净水器类型
	private List<Object> userMember = null;//会员表信息
	private Object installTable = null;//安装表信息
	private Object maintainTable = null;//维护信息
	private Object packageTable = null;//套餐表信息
	private Object filterTable = null;//滤芯表信息
	private Object deviceWaterTable = null;//设备用水量
	private Object waterMeterTable = null;//水表
	private Object userDeviceTable = null;//用户设备水表
	private Object userRegister = null;//亲属信息

	public boolean isTokenValid() {
		return tokenValid;
	}

	public void setTokenValid(boolean tokenValid) {
		this.tokenValid = tokenValid;
	}

	public Object getDeviceTable() {
		return deviceTable;
	}

	public void setDeviceTable(Object deviceTable) {
		this.deviceTable = deviceTable;
	}

	public Object getInstallTable() {
		return installTable;
	}

	public void setInstallTable(Object installTable) {
		this.installTable = installTable;
	}

	public Object getPackageTable() {
		return packageTable;
	}

	public void setPackageTable(Object packageTable) {
		this.packageTable = packageTable;
	}

	public Object getFilterTable() {
		return filterTable;
	}

	public void setFilterTable(Object filterTable) {
		this.filterTable = filterTable;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Integer getTableType() {
		return tableType;
	}

	public void setTableType(Integer tableType) {
		this.tableType = tableType;
	}

	public Object getTableData() {
		return tableData;
	}

	public void setTableData(Object tableData) {
		this.tableData = tableData;
	}

	public Map<String, Object> getSubTableDate() {
		return subTableDate;
	}

	public void setSubTableDate(Map<String, Object> subTableDate) {
		this.subTableDate = subTableDate;
	}
	
	public Object getDeviceWaterTable() {
		return deviceWaterTable;
	}

	public void setDeviceWaterTable(Object deviceWaterTable) {
		this.deviceWaterTable = deviceWaterTable;
	}
	
	public Object getDeviceTypeTable() {
		return deviceTypeTable;
	}

	public void setDeviceTypeTable(Object deviceTypeTable) {
		this.deviceTypeTable = deviceTypeTable;
	}
	
	public List<Object> getUserMember() {
		return userMember;
	}

	public void setUserMember(List<Object> userMember) {
		this.userMember = userMember;
	}
	public Object getWaterMeterTable() {
		return waterMeterTable;
	}

	public void setWaterMeterTable(Object waterMeterTable) {
		this.waterMeterTable = waterMeterTable;
	}
	public Object getMaintainTable() {
		return maintainTable;
	}

	public void setMaintainTable(Object maintainTable) {
		this.maintainTable = maintainTable;
	}
	public Object getUserDeviceTable() {
		return userDeviceTable;
	}

	public void setUserDeviceTable(Object userDeviceTable) {
		this.userDeviceTable = userDeviceTable;
	}
	public Object getUserRegister() {
		return userRegister;
	}

	public void setUserRegister(Object userRegister) {
		this.userRegister = userRegister;
	}

	@Override
	public String toString() {
		return "TableJson [success=" + success + ", msg=" + msg
				+ ", tableType=" + tableType + ", tableData=" + tableData
				+ ", subTableDate=" + subTableDate + ", tokenValid="
				+ tokenValid + ", deviceTable=" + deviceTable
				+ ", deviceTypeTable=" + deviceTypeTable + ", userMember="
				+ userMember + ", installTable=" + installTable
				+ ", maintainTable=" + maintainTable + ", packageTable="
				+ packageTable + ", filterTable=" + filterTable
				+ ", deviceWaterTable=" + deviceWaterTable
				+ ", waterMeterTable=" + waterMeterTable + ", userDeviceTable="
				+ userDeviceTable + ", userRegister=" + userRegister + "]";
	}
	
}
