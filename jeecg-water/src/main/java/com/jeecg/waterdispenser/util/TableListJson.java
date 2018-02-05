package com.jeecg.waterdispenser.util;

import com.alibaba.fastjson.JSONObject;

public class TableListJson {
	
	private boolean success = true;// 是否成功
	private String msg = "操作成功";// 提示信息
	private Object deviceTable = null;//净水器表信息
	private Object installTable = null;//安装表信息
	private Object packageTable = null;//套餐表信息
	private Object filterTable = null;//滤芯表信息
	
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
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
	@Override
	public String toString() {
		return "TableJson [success=" + success + ", msg=" + msg
				+ ", deviceTable=" + deviceTable + ", installTable=" + installTable
				+ ", packageTable=" + packageTable + ",filterTable=" + filterTable + "]";
	}
}
