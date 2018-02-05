package com.jeecg.waterdispenser.service;

import org.jeecgframework.core.common.service.CommonService;

public interface WechatServiceI extends CommonService{
	
	
	/**
	 * 付款成功之后根据联系方式判断该次充值是充值水量还是积分，并进行保存
	 * @param memberPhone 会员联系方式
	 * @param packageMoney 该次充值金额
	 * @param waterId 水表id
	 * @return
	 * @throws Exception
	 */
	public boolean saveUserIntegral(String memberPhone,String packageMoney,String waterId) throws Exception;
	
	/**
	 * 根据水表id及类型判断水表是否需要开关阀
	 * @param waterId 水表id
	 * @param type 开关阀类型0是开，1是关
	 * @return
	 * @throws Exception
	 */
	public boolean operationWater(String waterId, String type) throws Exception;

}
