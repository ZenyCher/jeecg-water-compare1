package com.jeecg.waterdispenser.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.jeecgframework.core.util.oConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeecg.waterdispenser.entity.WIntegralEntity;
import com.jeecg.waterdispenser.entity.WPackageEntity;
import com.jeecg.waterdispenser.service.WIntegralServiceI;
import com.sun.star.ucb.InteractiveNetworkGeneralException;


public class waterUtil {
	
	/**
	 * 判断该次充值超出标准金额几倍
	 * @param bigDecimal 金额
	 * @param packageMax 标准
	 * @return
	 */
	public static Integer moneyConversionWater(BigDecimal bigDecimal,Integer packageMax){
		BigInteger bigInteger = bigDecimal.multiply(new BigDecimal(100)).toBigInteger();
		int i = bigInteger.intValue();
		Integer packageMoney = Integer.valueOf(i);
		double c = (packageMoney/packageMax)/100;
		int j = (new Double(c)).intValue();
		Integer water = Integer.valueOf(j);
		return water;
	}
	
	/***
	 * 判断该次充值共充值多少水量
	 * @param bigDecimal 金额
	 * @param packageConver 换算比例
	 * @return
	 */
	public static Double waterConversion(BigDecimal bigDecimal,Float packageConver){
		BigInteger bigInteger = bigDecimal.multiply(new BigDecimal(100)).toBigInteger();
		int i = bigInteger.intValue();
		Integer money = Integer.valueOf(i);
		double startWater = (money*packageConver)/100;//该次充值水量
		Double water = Double.valueOf(startWater);
		return water;
	}
	
	/***
	 * 查看会员该次充值得到多少水量或积分
	 * @param wPackage
	 * @param bigDecimal
	 * @return
	 */
	public static Map<String, Object> resultDonatedWaterPackage(WPackageEntity wPackage,BigDecimal bigDecimal){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		//根据套餐标准及换算金额得出该次充值能充值多少水量或积分
		Integer waterClass = wPackage.getPackageClass();//充值类型
		Integer packageState = wPackage.getPackageState();//是否启用
		Integer packageMax = wPackage.getPackageMax();//充值标准
		Float packageConver = wPackage.getPackageConver();//换算比例
		Integer packageVlaue = Integer.valueOf(oConvertUtils.getString(wPackage.getPackageValue()));//变量值
		if( packageState == 1 ){
			Double thisWater = waterUtil.waterConversion(bigDecimal, packageConver);//当前充值水量
			BigDecimal b = new BigDecimal(thisWater);
			Double str = b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
			Integer exchange = waterUtil.moneyConversionWater(bigDecimal,packageMax);//改充值金额能够充值完成之后能够送几倍水量或积分\
			Integer thisGive = exchange*packageVlaue;
			resultMap.put("waterClass", waterClass);//该次充值类型
			if( waterClass == 0 ){//如果是充值积分的话，就返回该次充值的水量和该赠送的积分
				resultMap.put("rechargeWater", str);//保留两位小数
				resultMap.put("donatedWater", thisGive);//该次赠送水量或积分
			}
			if( waterClass == 1 ){//如果是充值水量的话，那么返回该次充值的水量加上该次赠送的水量和。
				resultMap.put("rechargeWater", str+thisGive);//该次充值水量
			}
		}else {
			resultMap.put("Msg", "该套餐被停用!");
			resultMap.put("success", false);
		}
		return resultMap;
	}

	
	public static void main(String[] args) {
//		String s = "0.0";
//		BigDecimal big = new BigDecimal(s);
//		BigInteger bigInteger = big.multiply(new BigDecimal(100)).toBigInteger();
//		int i = bigInteger.intValue();
//		Integer packageMoney = Integer.valueOf(i);
//		Integer packageMax = 100;
//		double c = (packageMoney/packageMax)/100;
//		int j = (new   Double(c)).intValue();
		String packageMoney = "50";
		BigDecimal bigDecimal = new BigDecimal(packageMoney);//充值金额
		Float packageConver = Float.valueOf((float)0.9);
		Double lin = waterConversion(bigDecimal, packageConver);
		System.out.println(lin);
	}
}
