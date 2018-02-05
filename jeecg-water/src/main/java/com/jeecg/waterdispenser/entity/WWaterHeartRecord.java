package com.jeecg.waterdispenser.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "w_water_heartrecord", schema = "")
public class WWaterHeartRecord {
	private String id;
	private String meterNo;//水表id
	private Integer currentWater;//本次用水量
	private Integer sumWater;//累计用水量
	private Integer lessWater;//剩余水量
	private String waterStatus ;//
	private String waterType ;//水表类型
	private Date updateTime;//更新时间
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name ="meterNo",nullable=true,length=32)
	public String getMeterNo() {
		return meterNo;
	}
	public void setMeterNo(String meterNo) {
		this.meterNo = meterNo;
	}
	@Column(name ="currentWater",nullable=true,length=10)
	public Integer getCurrentWater() {
		return currentWater;
	}
	public void setCurrentWater(Integer currentWater) {
		this.currentWater = currentWater;
	}
	@Column(name ="sumWater",nullable=true,length=10)
	public Integer getSumWater() {
		return sumWater;
	}
	public void setSumWater(Integer sumWater) {
		this.sumWater = sumWater;
	}
	@Column(name ="lessWater",nullable=true,length=10)
	public Integer getLessWater() {
		return lessWater;
	}
	public void setLessWater(Integer lessWater) {
		this.lessWater = lessWater;
	}
	@Column(name ="waterStatus",nullable=true,length=10)
	public String getWaterStatus() {
		return waterStatus;
	}
	public void setWaterStatus(String waterStatus) {
		this.waterStatus = waterStatus;
	}
	@Column(name ="waterType",nullable=true,length=10)
	public String getWaterType() {
		return waterType;
	}
	public void setWaterType(String waterType) {
		this.waterType = waterType;
	}
	@Column(name ="updateTime",nullable=true,length=20)
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "WWaterHeartRecord [id=" + id + ", meterNo=" + meterNo + ", currentWater=" + currentWater + ", sumWater="
				+ sumWater + ", lessWater=" + lessWater + ", waterStatus=" + waterStatus + ", waterType=" + waterType
				+ ", updateTime=" + updateTime + "]";
	}
	
	
}
