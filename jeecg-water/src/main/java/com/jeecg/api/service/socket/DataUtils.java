package com.jeecg.api.service.socket;


import java.util.ArrayList;
import java.util.List;

import org.apache.http.util.TextUtils;

/**
 * Created by foreveross_tangyouhua on 2017/6/2.
 * 描述：
 */

public class DataUtils {
    private static final String TAG = DataUtils.class.getSimpleName();

    public static String reverseStr(String reverseHexStr) {

        if (!TextUtils.isEmpty(reverseHexStr) && reverseHexStr.length() >= 2) {
            StringBuilder sb = new StringBuilder();
            int index = reverseHexStr.length();
            while (index >= 2) {
                sb.append(reverseHexStr.substring(index - 2, index));
                index = index - 2;
            }
            return sb.toString();
        }
        return "";
    }

    public static void add(ArrayList<Byte> list, byte[] bytes) {
        if (list != null && bytes != null) {
            for (int i = 0; i < bytes.length; i++) {
                list.add(bytes[i]);
            }
        }
    }


    public static byte[] convertToArray(List<Byte> list) {
        if (list != null) {
            byte[] bytes = new byte[list.size()];
            for (int i = 0; i < list.size(); i++) {
                bytes[i] = list.get(i);
            }

            return bytes;
        }

        return null;
    }

    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);

        }
        return stringBuilder.toString();
    }


    /**
     * byte数组中取int数值，本方法适用于(低位在后，高位在前)的顺序。和intToBytes2（）配套使用
     */
    public static int bytesToInt(byte[] src, int offset) {
        int value;
        value = (int) (((src[offset] & 0xFF) << 24)
                | ((src[offset + 1] & 0xFF) << 16)
                | ((src[offset + 2] & 0xFF) << 8)
                | (src[offset + 3] & 0xFF));
        return value;
    }


    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
    
    /**
     * 将数字转化为长度为8的字符串(写入水量用)
     * @param num
     * @return
     */
    public static String intTo8Str(String num) {
    	 StringBuilder stringBuilder = new StringBuilder("");
    	for(int i = 0;i<(8-num.length());i++){
    		stringBuilder.append(0);
    	}
    	stringBuilder.append(num);
    	return reverseStr(stringBuilder.toString());
    }
    
   /* public static void main(String[] args) {
    	System.out.println(intTo8Str("120"));
	}*/
}
