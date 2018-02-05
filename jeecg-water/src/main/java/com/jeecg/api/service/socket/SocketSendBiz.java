package com.jeecg.api.service.socket;

import java.net.Socket;
import java.util.ArrayList;

import org.apache.log4j.Logger;


/**
 * Created by foreveross_tangyouhua on 2017/6/5.
 * 描述：发送指 令业务处理类
 */

public class SocketSendBiz {

	private static final Logger logger = Logger.getLogger(SocketSendBiz.class);
    /**
     * 表开阀
     * @param meterNo 表编号
     * @param isUdp 是否udp方式发送，true用udp,false用tcp
     */
    public static void sendOpen(String meterNo,boolean isUdp) {
        SocketSendData sendData = new SocketSendData();
        byte[] bytes = DataUtils.hexStringToBytes("ffffffff");
        byte[] command = DataUtils.hexStringToBytes(SocketSendComand.OPEN);
        DataUtils.add(sendData.validData, bytes);
        DataUtils.add(sendData.validData, command);
        if(isUdp){
//            SocketUdpServerManager.getInstance().sendCommandByUDP( sendData);
        }else {
            SocketTcpServerManager.getInstance().sendCommand(meterNo, sendData);
        }

    }

    /**
     * 所有连接的表开阀
     */
    public static void sendAllOpen() {
        ArrayList<String> meterNos = SocketTcpServerManager.getInstance().getMeterNos();
        if (meterNos != null && meterNos.size() > 0) {
            for (String meterNo : meterNos) {
                sendOpen(meterNo,false);
            }
        }
    }

    /**
     * 表关阀
     *
     * @param meterNo 表编号
     * @param isUdp 是否udp方式发送，true用udp,false用tcp
     */
    public static void sendClose(String meterNo,boolean isUdp) {
        SocketSendData sendData = new SocketSendData();
        byte[] bytes = DataUtils.hexStringToBytes("ffffffff");
        byte[] command = DataUtils.hexStringToBytes(SocketSendComand.CLOSE);
        DataUtils.add(sendData.validData, bytes);
        DataUtils.add(sendData.validData, command);
        System.out.println(DataUtils.bytesToHexString(sendData.getContent()));
        if(isUdp){
//            SocketUdpServerManager.getInstance().sendCommandByUDP(sendData);
        }else{
            SocketTcpServerManager.getInstance().sendCommand(meterNo, sendData);
        }

    }

    /**
     * 读表,首次连接
     */
    public static void sendReadMeter(String meterNo, Socket socket) {
        SocketSendData sendData = new SocketSendData();
        byte[] bytes = DataUtils.hexStringToBytes(meterNo);
        byte[] command = DataUtils.hexStringToBytes(SocketSendComand.READ);
        DataUtils.add(sendData.validData, bytes);
        DataUtils.add(sendData.validData, command);
        SocketTcpServerManager.getInstance().sendCommand(sendData, socket);
    }


    /**
     * 读表
     * @param meterNo 表编号
     * @param isUdp 是否udp方式发送，true用udp,false用tcp
     */
    public static void sendReadMeter(String meterNo,boolean isUdp) {
        SocketSendData sendData = new SocketSendData();
        byte[] bytes = DataUtils.hexStringToBytes(meterNo);
        byte[] command = DataUtils.hexStringToBytes(SocketSendComand.READ);
        DataUtils.add(sendData.validData, bytes);
        DataUtils.add(sendData.validData, command);
        
        System.err.println("读表:" + DataUtils.bytesToHexString(sendData.getContent()));
        if(isUdp){
//            SocketUdpServerManager.getInstance().sendCommandByUDP(sendData);
        }else{
            SocketTcpServerManager.getInstance().sendCommand(meterNo, sendData);
        }

    }
    
    /**
     * 告警处理回复指令
     * @param meterNo
     */
    public static void sendWarnReply(String meterNo) {
    	 SocketSendData sendData = new SocketSendData();
         byte[] bytes = DataUtils.hexStringToBytes(meterNo);
         byte[] command = DataUtils.hexStringToBytes(SocketSendComand.WARNREPLY);
         DataUtils.add(sendData.validData, bytes);
         DataUtils.add(sendData.validData, command);
         logger.info("发送告警响应指令：" + meterNo);
         SocketTcpServerManager.getInstance().sendCommand(meterNo, sendData);
         
    }

    /**
     * @param meterNo                表 编 号
     * @param settingFunctionCommand 设置功能指令
     * @param settingData            设置数据
     */
    public static void sendSettingMeter(String meterNo, byte settingFunctionCommand, byte[] settingData,boolean isUdp) {
        SocketSendData sendData = new SocketSendData();
        byte[] bytes = DataUtils.hexStringToBytes(meterNo);
        byte[] command = DataUtils.hexStringToBytes(SocketSendComand.SETTING);
        DataUtils.add(sendData.validData, bytes);
        DataUtils.add(sendData.validData, command);
        if (sendData.validData != null) {
            sendData.validData.add(settingFunctionCommand);
        }
        DataUtils.add(sendData.validData, settingData);
        System.err.println("设置水20L:" + DataUtils.bytesToHexString(sendData.getContent()));
        if(isUdp){
//            SocketUdpServerManager.getInstance().sendCommandByUDP(sendData);
        }else{
            SocketTcpServerManager.getInstance().sendCommand(meterNo, sendData);
        }
    }
    
    /**
     * 写水 如果需要写入120L waterNum = 120
     * @param meterNo
     * @param waterNum
     */
    public static void sendWriteWater(String meterNo, String waterNum) {
//    	FE FE FE 42 42 42 42 53 FF FF FF FF 53 0B 02 00 00 00 47 5A 45
    	String waterStr = DataUtils.intTo8Str(waterNum);
    	System.out.println(waterStr);
    	SocketSendData sendData = new SocketSendData();
//    	DataUtils.hexStringToBytes(SocketSendComand.WRITE);
        byte[] command = DataUtils.hexStringToBytes(SocketSendComand.SETTING);
        DataUtils.add(sendData.validData, DataUtils.hexStringToBytes("FFFFFFFF"));
        DataUtils.add(sendData.validData, command);
        sendData.validData.add(SocketSendComand.SettingFunctionCommand.SETTING_PRICE);
        DataUtils.add(sendData.validData, DataUtils.hexStringToBytes(waterStr));
        System.err.println("test:" + DataUtils.bytesToHexString(sendData.getContent()));
        SocketTcpServerManager.getInstance().sendCommand(meterNo, sendData);
    }
    
    /**
     * 回复出厂设置
     * @param meterNo
     */
    public static void recoverMeter(String meterNo) {
    	SocketSendData sendData = new SocketSendData();
    	DataUtils.add(sendData.validData, DataUtils.hexStringToBytes(meterNo+"53FF"));
    	System.err.println(DataUtils.bytesToHexString(sendData.getContent()));
    }
    
    public static void getIP(String meterNo,String ipStr) {
//    	424242425301000000530DC0A8FD01138831E645

    	SocketSendData sendData = new SocketSendData();
    	DataUtils.add(sendData.validData, DataUtils.hexStringToBytes(meterNo+"530D"+ipStr + "1388"));
    	System.err.println("test:" + DataUtils.bytesToHexString(sendData.getContent()));
    	  
//    	  42424242537F018278530DAC1CCB011388C2B745
    	
    }
    
    public static void main(String[] args) {
//    	getIP("88026040","C0A83101");
//    	sendReadMeter("88026040", false);
//  	sendClose("88026040", false);
    	recoverMeter("01000000");
//    	42424242530100000053FF254B45
//    	sendWriteWater("7F018278", "2");
    }
}
