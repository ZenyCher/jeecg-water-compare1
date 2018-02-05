package com.jeecg.api.service.socket;

/**
 * Created by foreveross_tangyouhua on 2017/6/1.
 * 描述：发送到水表的指令
 */

public class SocketSendComand {
    /**
     * 读表
     */
    public static final String READ = "52"; //十六进制字符串
    /**
     * 设置表
     */
    public static final String SETTING = "53"; //十六进制字符串
    /**
     * 表阀门开
     */
    public static final String OPEN = "4B"; //十六进制字符串
    /**
     * 表阀门关
     */
    public static final String CLOSE = "47"; //十六进制字符串
    
    /**
     * 告警回复
     */
    public static final String WARNREPLY = "54";//告警回复
    
    public static final String WRITE = "FEFEFE";


    /**
     * 设置功能指令
     * 二进制表示：D7 D6 D5 D4 D3 D2 D1 D0
     */
    public static class SettingFunctionCommand {
        //0   0  0  0  0  0  0  1   –设置表地址
        public static final byte SETTING_ADDR = 1;
        //0   0  0  0  0  0  1  0   - 设置表读数
        public static final byte SETTING_READ = 2;
        //0   0  0  0  0  0  1  1   -设置第一道滤芯寿命
        public static final byte SETTING_FIRST_FILTER = 3;

        //0   0  0  0  0  1  0  0   -设置第二道滤芯寿命
        public static final byte SETTING_SECOND_FILTER = 4;

        //0   0  0  0  0  1  0  1   -设置第三道滤芯寿命
        public static final byte SETTING_THIRD_FILTER = 5;
        //0   0  0  0  0  1  1  0   -设置第四道滤芯寿命
        public static final byte SETTING_FOURTH_FILTER = 6;
        //0   0  0  0  0  1  1  1   -设置连续出水时长1时长
        public static final byte SETTING_WATER_FLOW_1 = 7;
        //0   0  0  0  1  0  0  0   -设置连续出水时长2时长
        public static final byte SETTING_WATER_FLOW_2 = 8;
        //0   0  0  0  1  0  0  1   -设置连续出水时长3时长
        public static final byte SETTING_WATER_FLOW_3 = 9;
        //0   0  0  0  1  0  1  0   -设置表时钟
        public static final byte SETTING_TIME = 10;

        //0   0  0  0  1  0  1  1   -设置直饮净水单价
        public static final byte SETTING_PRICE = 11;
        //0   0  0  0  1  1  0  0   -设置Wifi名及密码
        public static final byte SETTING_WIFI_NAME_PW = 12;
        //0   0  0  0  1  1  0  1   -设置Wifi链路1
        public static final byte SETTING_WIFI_LINE_1 = 13;
        //0   0  0  0  1  1  1  0   -设置Wifi链路2
        public static final byte SETTING_WIFI_LINE_2 = 14;
        //0   0  0  0  1  1  1  1   -设置Wifi链路3
        public static final byte SETTING_WIFI_LINE_3 = 15;
        //0   0  0  1  0  0  0  0   -设置Wifi链路4
        public static final byte SETTING_WIFI_LINE_4 = 16;
        //1   1  1  1  1  1  1  1   -恢复出厂设置
        public static final byte SETTING_DEFAULT = -1;

    }


}
