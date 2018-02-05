package com.jeecg.waterdispenser.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.KeyStore.PrivateKeyEntry;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.aspectj.weaver.AjAttribute.PrivilegedAttribute;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.oConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecg.waterdispenser.controller.WComplaintController;
import com.jeecg.waterdispenser.entity.WDeviceEntity;
import com.jeecg.waterdispenser.entity.WIntegralEntity;
import com.jeecg.waterdispenser.entity.WPackageEntity;
import com.jeecg.waterdispenser.entity.WRechargeEntity;
import com.jeecg.waterdispenser.entity.WRechargeStatisticsEntity;
import com.jeecg.waterdispenser.entity.WUserDeviceEntity;
import com.jeecg.waterdispenser.entity.WUserMemberEntity;
import com.jeecg.waterdispenser.entity.WWaterMeterEntity;
import com.jeecg.waterdispenser.entity.WWaterOpenEntity;
import com.jeecg.waterdispenser.service.WDeviceServiceI;
import com.jeecg.waterdispenser.service.WIntegralServiceI;
import com.jeecg.waterdispenser.service.WPackageServiceI;
import com.jeecg.waterdispenser.service.WRechargeServiceI;
import com.jeecg.waterdispenser.service.WRechargeStatisticsServiceI;
import com.jeecg.waterdispenser.service.WUserDeviceServiceI;
import com.jeecg.waterdispenser.service.WUserMemberServiceI;
import com.jeecg.waterdispenser.service.WWaterMeterServiceI;
import com.jeecg.waterdispenser.service.WWaterOpenServiceI;
import com.jeecg.waterdispenser.service.WechatServiceI;
import com.jeecg.waterdispenser.util.waterUtil;
import com.sun.star.ucb.InteractiveNetworkGeneralException;

@Service("wechatService")
@Transactional
public class WechatServiceImpl extends CommonServiceImpl implements WechatServiceI {
	
	private static final Logger logger = Logger.getLogger(WechatServiceImpl.class);
	
	@Autowired
	private WRechargeServiceI wRechargeServiceI;
	@Autowired
	private WUserDeviceServiceI wUserDeviceServiceI;
	@Autowired
	private WPackageServiceI wPackageServiceI;
	@Autowired
	private WIntegralServiceI wIntegralServiceI;
	@Autowired
	private WWaterMeterServiceI wWaterMeterServiceI;
	@Autowired
	private WUserMemberServiceI wUserMemberServiceI;
	@Autowired
	private WDeviceServiceI wDeviceServiceI;
	@Autowired
	private WWaterOpenServiceI wWaterOpenServiceI;
	@Autowired
	private WRechargeStatisticsServiceI wRechargeStatisticsServiceI;
	
	
	public boolean saveUserIntegral(String memberPhone,String packageMoney,String waterId) throws Exception{
		logger.info("==========================================="
				+ "========================================================memberPhone="+memberPhone+"packageMoney="+packageMoney+"waterId="+waterId);
		packageMoney = "10";
		BigDecimal bigDecimal = new BigDecimal(packageMoney);//充值金额
		WUserMemberEntity wUserMember = wUserMemberServiceI.findUniqueByProperty(WUserMemberEntity.class, "deviceId", waterId);
		Map<String, Object> map = new HashMap<String,Object>();
		Integer packageValue = 0;
		if( wUserMember != null ){
			//如果充值记录不为空则代表是正常套餐，如果是为空则为首冲套餐
			WPackageEntity wPackage = new WPackageEntity();
			//查看该用户是否为首冲(查询充值记录表)
			List<WRechargeEntity> wRecharge = wRechargeServiceI.findByProperty(WRechargeEntity.class, "memberPhone", memberPhone);
			if( !wRecharge.isEmpty() && wRecharge.size() > 0 ){
				wPackage = wPackageServiceI.findUniqueByProperty(WPackageEntity.class, "id", oConvertUtils.getString(wUserMember.getMemberNormalPackageId()));
				if( wPackage == null ){
					return false;
				}
				packageValue = oConvertUtils.getInt(wPackage.getPackageValue());
				map = waterUtil.resultDonatedWaterPackage(wPackage, bigDecimal);
			}else {
				wPackage = wPackageServiceI.findUniqueByProperty(WPackageEntity.class, "id", oConvertUtils.getString(wUserMember.getMemberPackageId()));
				if( wPackage == null ){
					return false;
				}
				packageValue = oConvertUtils.getInt(wPackage.getPackageValue());
				map = waterUtil.resultDonatedWaterPackage(wPackage, bigDecimal);
			}
		}else {
			return false;
		}
		Integer waterClass = Integer.valueOf(oConvertUtils.getString(map.get("waterClass")));//该次充值类型
		String rechargeWater = oConvertUtils.getString(map.get("rechargeWater"));//该次充值水量
		String donatedWater = oConvertUtils.getString(map.get("donatedWater"));//该次充值赠送积分
		if( waterClass == 0 ){//充积分
			WIntegralEntity wIntegral = new WIntegralEntity();
			wIntegral.setMemberPhone(wUserMember.getMemberPhone());
			wIntegral.setIntegralSource("充值水量");
			wIntegral.setIntegralType(0);
			//充值多少金额，送多少积分
			BigInteger bigInteger = bigDecimal.multiply(new BigDecimal(100)).toBigInteger();
			int i = bigInteger.intValue();
			wIntegral.setIntegralNumber(String.valueOf(Integer.valueOf(donatedWater) + Integer.valueOf(i)));
			wIntegralServiceI.save(wIntegral);
		}
		//除去充积分之外需增加一条积分记录之外，以下需都增加
		WWaterMeterEntity wWater = wWaterMeterServiceI.findUniqueByProperty(WWaterMeterEntity.class, "waterId", waterId);
		if( wWater == null ){
			return false;
		}
		Integer waterRecharge = wWater.getWaterRecharge();//水表当前已充水量
		BigDecimal waterNumInteger =  new BigDecimal(rechargeWater).setScale(0, BigDecimal.ROUND_HALF_UP);
		Integer sumWater = waterRecharge + Integer.valueOf(oConvertUtils.getString(waterNumInteger));//累计已充值水量
		//获取水表当前水量及初始水量，算出剩余水量。算法（累计已充值水量+水表初始水量-水表当前水量=剩余水量）
		Integer waterNum = wWater.getWaterNum() == null ? 0 : wWater.getWaterNum();//水表初始水量
		Integer waterCurrent = wWater.getWaterCurrent() == null ? 0 : wWater.getWaterCurrent();//水表当前水量
		Integer waterSurplus = sumWater + waterNum - waterCurrent;
		wWater.setWaterRecharge(sumWater);
		wWater.setWaterNum(waterNum);
		wWater.setWaterCurrent(waterCurrent);
//		wWater.setWaterSurplus(waterSurplus);
		logger.info("======================================================="
				+ "======================================================="
				+ "======================================================="
				+ "=======================================================wWater="+wWater);
		wWaterMeterServiceI.saveOrUpdate(wWater);
		
		//增加一条充值记录
		WUserDeviceEntity wUserDevice = wUserDeviceServiceI.saveUserDeviceByPhoneAndWaterId(memberPhone, waterId);
		if( wUserDevice == null ){
			return false;
		}
		WDeviceEntity wDeviceEntity = wDeviceServiceI.findUniqueByProperty(WDeviceEntity.class, "deviceId", wUserDevice.getDeviceId());
		//根据用户联系方式查找所有的充值记录并累加，累加完成之后将已累加的充值记录更改为已写
		List<WRechargeEntity> list = wRechargeServiceI.listWaterCountByPhone(memberPhone);
		Integer countNum = 0;//未写水表累计充值总水量
		if( !list.isEmpty() && list.size() > 0 ){
			for (int i = 0; i < list.size(); i++) {
				if( oConvertUtils.isNotEmpty(list.get(i).getRechargeWater()) ){
					countNum += list.get(i).getRechargeWater();
					list.get(i).setRechargeWaterCount(countNum);
					list.get(i).setIsWater(Integer.valueOf(1));
					wRechargeServiceI.updateEntitie(list.get(i));
				}
			}
		}
		//增加一条充值记录表
		WRechargeEntity wRechargeEntity = new WRechargeEntity();
		wRechargeEntity.setMemberPhone(memberPhone);
		wRechargeEntity.setMemberName(wUserMember.getMemberName());
		wRechargeEntity.setMemberAddress(wUserMember.getMemberAddress());
		wRechargeEntity.setDeviceId(wUserDevice.getDeviceId());
		wRechargeEntity.setDeviceName(wDeviceEntity.getDeviceName());
		wRechargeEntity.setRechargeSum(packageMoney);
		wRechargeEntity.setRechargeTime(DateUtils.getDateProgram());
		wRechargeEntity.setWaterId(waterId);
		wRechargeEntity.setIsWater(0);
		wRechargeEntity.setRechargeWaterCount(countNum + Integer.valueOf(Integer.valueOf(oConvertUtils.getString(waterNumInteger))));//用户累计充值未写入水表的充值水量
		wRechargeEntity.setRechargeWater(Integer.valueOf(Integer.valueOf(oConvertUtils.getString(waterNumInteger))));
		wRechargeEntity.setRechargeReceiveWater(packageValue);
		wRechargeEntity.setRechargeCountWater(countNum);
		wRechargeEntity.setRechargeCountIntegral(countNum);
		wRechargeEntity.setCreateDate(DateUtils.getDateProgram());
		wRechargeServiceI.save(wRechargeEntity);
		//充值记录成功增加之后增加一条充值统计记录
		WRechargeStatisticsEntity wRechargeStatisticsEntity = new WRechargeStatisticsEntity();
		wRechargeStatisticsEntity.setMemberName(wUserMember.getMemberName());
		wRechargeStatisticsEntity.setRechargeStatistics(new BigDecimal(packageMoney));
		wRechargeStatisticsEntity.setMemberPhone(memberPhone);
		wRechargeStatisticsServiceI.save(wRechargeStatisticsEntity);
		//增加一条充值记录的同时，并将充值金额算成积分增加
		WIntegralEntity wIntegral = new WIntegralEntity();
		wIntegral.setMemberPhone(wUserMember.getMemberPhone());
		wIntegral.setIntegralSource("充值水量");
		wIntegral.setIntegralType(0);
		//充值多少金额，送多少积分
		BigInteger bigInteger = bigDecimal.multiply(new BigDecimal(100)).toBigInteger();
		int i = bigInteger.intValue();
		wIntegral.setIntegralNumber(String.valueOf(Integer.valueOf(i)));
		wIntegralServiceI.save(wIntegral);
		logger.info("memberPhone="+memberPhone+"packageMoney="+packageMoney+"waterId="+waterId+"完成更新");
		return true;
	}
	
	public boolean operationWater(String waterId, String type) throws Exception{
		WWaterOpenEntity wWaterOpen = new WWaterOpenEntity();
		wWaterOpen = wWaterOpenServiceI.findUniqueByProperty(WWaterOpenEntity.class, "waterId", waterId);
		if( wWaterOpen != null ){
			wWaterOpen.setWaterId(waterId);
			wWaterOpen.setWaterOpenType(Integer.valueOf(type));
			wWaterOpenServiceI.saveOrUpdate(wWaterOpen);
		}else{
			WWaterOpenEntity water = new WWaterOpenEntity();
			water.setWaterId(waterId);
			water.setWaterOpenType(Integer.valueOf(type));
			wWaterOpenServiceI.save(water);
		}
		return true;
	}
}
