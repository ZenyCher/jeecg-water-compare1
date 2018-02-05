package com.jeecg.api.service;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class KeepAlive implements Serializable{
	
    private static final long serialVersionUID = -2813120366138988480L;
    
//    private String instructions;//指令
//    private String tableNUmber;//表编号
//    private String tableCurrentConsumption;//表当前用水量
//    private String thisConsumption;//本次用水量
//    private String consumptionStartDate;//本次用水开始时间
//    private String tableType;//表类型
//    private String tableState;//表状态
//    private String filterLife;//滤芯寿命
//    private String warning;//告警
//    private String effluentDate;//连续出水时长
//    private String deviceMoney;//直饮净水机单价
//    private Map<String, Object> wiFi;//wifi名及密码
//    private String link;//链路
//    private String crcCode;//校验码
//    private String setUpInstructions;//设置指令
    
    
    /* 覆盖该方法，仅用于测试使用。 
     * @see java.lang.Object#toString() 
     */  
    @Override  
    public String toString() {  
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"\t维持连接包";  
    } 
}
