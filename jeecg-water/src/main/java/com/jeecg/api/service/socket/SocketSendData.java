package com.jeecg.api.service.socket;

import java.util.ArrayList;

/**
 * Created by foreveross_tangyouhua on 2017/6/1.
 * 描述：socket发送数据
 */

public class SocketSendData {
    /**
     * 发送数据包包头，十六进制字符
     */
    public final static String HEADER_DATA = "4242424253"; //0x42 42 42 42 53H;BBBBS
    
    /**
     * 发送数据包包尾，十六进制字符
     */
    public final static String END_DATA = "45"; //0x45H  E
    /**
     * 表编号
     */
    private String meterNo;

    /**
     * 校验数据
     */
    private byte[] crc;

    /**
     * 有效数据
     */
    public ArrayList<Byte> validData = new ArrayList<Byte>();
    /**
     * 全部数据
     */
    public ArrayList<Byte> content = new ArrayList<Byte>();

    public String getMeterNo() {
        return meterNo;
    }

    public void setMeterNo(String meterNo) {
        this.meterNo = meterNo;
    }

    public void setCrc(byte[] src) {
        crc = SocketDataCRC.getCRCData(src);
    }


    public byte[] getContent() {
        addContent();
        return DataUtils.convertToArray(content);
    }

    private void addContent() {
        content.clear();
        try {
            DataUtils.add(content, DataUtils.hexStringToBytes(HEADER_DATA));
            content.addAll(validData);
            setCrc(DataUtils.convertToArray(validData));
            DataUtils.add(content, crc);
            DataUtils.add(content, DataUtils.hexStringToBytes(END_DATA));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
