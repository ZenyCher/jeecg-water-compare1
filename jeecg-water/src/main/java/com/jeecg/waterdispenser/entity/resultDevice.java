package com.jeecg.waterdispenser.entity;

@SuppressWarnings("serial")
public class resultDevice implements java.io.Serializable {
	
	private String device_type;
	private String device_name;
	private Integer device_filter_num;
	private String purchase_order;
	private String device_type_id;
	private String purchase_state;
	private String purchase_handle;
	private String purchase_number;
	private String purchase_time;
	private String purchase_people;
	private String purchase_phone;
	private String purchase_express;
	private String purchase_couriernumber;
	private String purchase_operator;
	private String purchase_cost;
	private String purchase_mailtime;
	private Integer purchase_pay;
	private Integer purchase_goods;
	private String mall_deposit;
	private String mall_image;
	private String address;
	private String receiver;//收件人
	private String receiverMobile;//收件人联系方式
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMall_deposit() {
		return mall_deposit;
	}
	public void setMall_deposit(String mall_deposit) {
		this.mall_deposit = mall_deposit;
	}
	public String getMall_image() {
		return mall_image;
	}
	public void setMall_image(String mall_image) {
		this.mall_image = mall_image;
	}
	public String getDevice_type() {
		return device_type;
	}
	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}
	public String getDevice_name() {
		return device_name;
	}
	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}
	
	public Integer getDevice_filter_num() {
		return device_filter_num;
	}
	public void setDevice_filter_num(Integer device_filter_num) {
		this.device_filter_num = device_filter_num;
	}
	public String getPurchase_order() {
		return purchase_order;
	}
	public void setPurchase_order(String purchase_order) {
		this.purchase_order = purchase_order;
	}
	public String getDevice_type_id() {
		return device_type_id;
	}
	public void setDevice_type_id(String device_type_id) {
		this.device_type_id = device_type_id;
	}
	public String getPurchase_state() {
		return purchase_state;
	}
	public void setPurchase_state(String purchase_state) {
		this.purchase_state = purchase_state;
	}
	public String getPurchase_handle() {
		return purchase_handle;
	}
	public void setPurchase_handle(String purchase_handle) {
		this.purchase_handle = purchase_handle;
	}
	public String getPurchase_number() {
		return purchase_number;
	}
	public void setPurchase_number(String purchase_number) {
		this.purchase_number = purchase_number;
	}
	public String getPurchase_time() {
		return purchase_time;
	}
	public void setPurchase_time(String purchase_time) {
		this.purchase_time = purchase_time;
	}
	public String getPurchase_people() {
		return purchase_people;
	}
	public void setPurchase_people(String purchase_people) {
		this.purchase_people = purchase_people;
	}
	public String getPurchase_phone() {
		return purchase_phone;
	}
	public void setPurchase_phone(String purchase_phone) {
		this.purchase_phone = purchase_phone;
	}
	public String getPurchase_express() {
		return purchase_express;
	}
	public void setPurchase_express(String purchase_express) {
		this.purchase_express = purchase_express;
	}
	public String getPurchase_couriernumber() {
		return purchase_couriernumber;
	}
	public void setPurchase_couriernumber(String purchase_couriernumber) {
		this.purchase_couriernumber = purchase_couriernumber;
	}
	public String getPurchase_operator() {
		return purchase_operator;
	}
	public void setPurchase_operator(String purchase_operator) {
		this.purchase_operator = purchase_operator;
	}
	public String getPurchase_cost() {
		return purchase_cost;
	}
	public void setPurchase_cost(String purchase_cost) {
		this.purchase_cost = purchase_cost;
	}
	public String getPurchase_mailtime() {
		return purchase_mailtime;
	}
	public void setPurchase_mailtime(String purchase_mailtime) {
		this.purchase_mailtime = purchase_mailtime;
	}
	public Integer getPurchase_pay() {
		return purchase_pay;
	}
	public void setPurchase_pay(Integer purchase_pay) {
		this.purchase_pay = purchase_pay;
	}
	public Integer getPurchase_goods() {
		return purchase_goods;
	}
	public void setPurchase_goods(Integer purchase_goods) {
		this.purchase_goods = purchase_goods;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getReceiverMobile() {
		return receiverMobile;
	}
	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}
	
}
