package com.jeecg.waterdispenser.resultEntity;

/**
 * loginInfo返回信息表
 * @author Foreveross
 *
 */
public class UserDeviceResult implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String water_id;//水表id-
	private String device_id;//设备id-
	
	
	private String member_phone;//会员联系方式-
	private String member_name;//会员姓名-
	
	private String device_name;//设备名称-
	private String device_type;//设备型号-
	private String install_address;//设备安装地址-
	private Integer filter_num;//滤芯数量-
	private Integer water_current;//水表当前水量-
	private Integer water_surplus;//水表剩余水量-
	private Integer water_value;//水表是否告警-
	private Integer one_filter_name;//滤芯1当前读数-
	private Integer two_filter_name;//滤芯2当前读数-
	private Integer three_filter_name;//滤芯3当前读数-
	private Integer four_filter_name;//滤芯4当前读数-
	private Integer five_filter_name;//滤芯5当前读数-
	private Integer six_filter_name;//滤芯6当前读数-
	
	
	public String getWater_id() {
		return water_id;
	}
	public void setWater_id(String water_id) {
		this.water_id = water_id;
	}
	public String getDevice_id() {
		return device_id;
	}
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}
	public String getMember_phone() {
		return member_phone;
	}
	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getInstall_address() {
		return install_address;
	}
	public void setInstall_address(String install_address) {
		this.install_address = install_address;
	}
	public Integer getFilter_num() {
		return filter_num;
	}
	public void setFilter_num(Integer filter_num) {
		this.filter_num = filter_num;
	}
	public Integer getWater_current() {
		return water_current;
	}
	public void setWater_current(Integer water_current) {
		this.water_current = water_current;
	}
	public Integer getOne_filter_name() {
		return one_filter_name;
	}
	public void setOne_filter_name(Integer one_filter_name) {
		this.one_filter_name = one_filter_name;
	}
	public Integer getTwo_filter_name() {
		return two_filter_name;
	}
	public void setTwo_filter_name(Integer two_filter_name) {
		this.two_filter_name = two_filter_name;
	}
	public Integer getThree_filter_name() {
		return three_filter_name;
	}
	public void setThree_filter_name(Integer three_filter_name) {
		this.three_filter_name = three_filter_name;
	}
	public Integer getFour_filter_name() {
		return four_filter_name;
	}
	public void setFour_filter_name(Integer four_filter_name) {
		this.four_filter_name = four_filter_name;
	}
	public Integer getFive_filter_name() {
		return five_filter_name;
	}
	public void setFive_filter_name(Integer five_filter_name) {
		this.five_filter_name = five_filter_name;
	}
	public Integer getSix_filter_name() {
		return six_filter_name;
	}
	public void setSix_filter_name(Integer six_filter_name) {
		this.six_filter_name = six_filter_name;
	}
	public String getDevice_name() {
		return device_name;
	}
	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}
	public String getDevice_type() {
		return device_type;
	}
	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}
	public Integer getWater_surplus() {
		return water_surplus;
	}
	public void setWater_surplus(Integer water_surplus) {
		this.water_surplus = water_surplus;
	}
	public Integer getWater_value() {
		return water_value;
	}
	public void setWater_value(Integer water_value) {
		this.water_value = water_value;
	}
	
	

}
