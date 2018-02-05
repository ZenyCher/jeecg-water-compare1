package com.jeecg.api.util;

import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.jeecg.waterdispenser.dao.WRechargeDao;
import com.jeecg.waterdispenser.entity.WRechargeEntity;
import com.jeecg.waterdispenser.service.WRechargeServiceI;
import com.jeecg.waterdispenser.service.WUserDeviceServiceI;
import com.jeecg.waterdispenser.service.WWaterHeartRecordServiceI;
import com.jeecg.waterdispenser.service.WWaterMeterServiceI;
import com.jeecg.waterdispenser.service.WWaterOpenServiceI;
import com.jeecg.waterdispenser.service.WWriterRecordServiceI;

/**
 * 获取ApplicationContext和Object的工具类
 * 
 * @author zengyq
 *
 */
public class SpringContextUtils implements ServletContextListener {

//	private static WRechargeDao wrechargeDao;
	
	private static WWaterMeterServiceI wWaterMeterService;
	
	private static WRechargeServiceI wRechargeService;
	
	private static WWriterRecordServiceI wWriterRecordService;
	
	private static WWaterOpenServiceI waterOpenService;
	
	private static WWaterHeartRecordServiceI waterHeartRecordService;
	
	private static WUserDeviceServiceI userDeviceService;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
//		wrechargeDao = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext())
//				.getBean(WRechargeDao.class);
		
		wWaterMeterService = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext())
				.getBean(WWaterMeterServiceI.class);
		
		wRechargeService = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext())
				.getBean(WRechargeServiceI.class);
		
		wWriterRecordService = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext())
		.getBean(WWriterRecordServiceI.class);
		
		waterOpenService = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext())
				.getBean(WWaterOpenServiceI.class);
		
		waterHeartRecordService = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext())
				.getBean(WWaterHeartRecordServiceI.class);
		
		userDeviceService = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext())
				.getBean(WUserDeviceServiceI.class);
		
	}
	
/*	public static WRechargeEntity getNeedWriteWater(String meterNo) {
		return wrechargeDao.getNeedWriteWater(meterNo);
	}*/
	
	public static WWaterMeterServiceI getWwaterMeterService() {
		return  wWaterMeterService;
	}
	
	public static WRechargeServiceI getWRechargeService() {
		return  wRechargeService;
	}

	public static WWriterRecordServiceI getWWriterRecordServiceI() {
		return  wWriterRecordService;
	}
	
	public static WWaterOpenServiceI getWaterOpenService() {
		return  waterOpenService;
	}
	
	public static WWaterHeartRecordServiceI getWaterHeartRecordServiceI() {
		return  waterHeartRecordService;
	}
	public static WUserDeviceServiceI getUserdeviceService() {
		return  userDeviceService;
	}
}
