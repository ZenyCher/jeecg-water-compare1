package com.jeecg.waterdispenser.util;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.util.StringUtil;


public class SecurityUtil {
	
	private static Integer operateValue = 0;

    /** 
     *  
     *  @Description    : 身份验证token值算法： 
     *                              算法是：将特定的某几个参数一map的数据结构传入， 
     *                              进行字典序排序以后进行md5加密,32位小写加密； 
     *  @Method_Name    : authentication 
     *  @param token        请求传过来的token 
     *  @param srcData   约定用来计算token的参数 
     *  @return  
     */  
    public static String authentication(Map<String , Object > srcData) throws Exception{  
        //排序，根据keyde 字典序排序  
        if(null == srcData){  
            throw new BusinessException("传入参数为空");
        }  
        List<Map.Entry<String,Object>> list = new ArrayList<Map.Entry<String,Object>>(srcData.entrySet());  
        Collections.sort(list, new Comparator<Map.Entry<String, Object>>(){  
            //升序排序  
            public int compare(Entry<String,Object> o1, Entry<String,Object> o2){  
                return o1.getKey().compareTo(o2.getKey());  
            }  
        });  
          
        StringBuffer srcSb = new StringBuffer();  
        for(Map.Entry<String , Object>srcAtom : list){  
            srcSb.append(String.valueOf(srcAtom.getValue()));  
        }  
        System.out.println("身份验证加密前字符串："+srcSb.toString());  
        //计算token  
        String token = MD5Util.md5(srcSb.toString());  
//      System.out.println(cToken);//for test  
        return token;  
    }  
    
    
	public static boolean saveVerificationToken(String phone,String token){
		boolean flag = false;
		if (StringUtil.isNotEmpty(token) && StringUtil.isNotEmpty(phone)) {
//			如果token不为空则查看是否在缓存中存在，如果存在则放心，如不存在就跳转登录页面
//			Cache cache = manager.getCache("eternalCache");
			Cache eternalCache = CacheManager.getInstance().getCache("eternalCache");
			Element element = eternalCache.get(phone);
			if(element != null){
				String newToken = element.getValue().toString();
				if( token.equals(newToken) ){
					flag = true;
				}
			}
		}
		return flag;
	}
	
	public static boolean updateVerElementValue(String phone,String token){
		boolean fals = false;
		if(StringUtil.isNotEmpty(phone) && StringUtil.isNotEmpty(token)){
			Cache eternalCache = CacheManager.getInstance().getCache("eternalCache");
			synchronized (phone) {
//				先将缓存中该用户的key清除，然后重新生成并保存之后返回前台
				eternalCache.remove(phone);
				eternalCache.put(new Element(phone, token));
				fals = true;
				return fals;
			}
		}
		return fals;
	}
	
	/**
	 * 保存Socket
	 * @param value
	 * @return
	 */
	public static void setSocketValue(String meterNo, Socket socket){
		Cache eternalCache = CacheManager.getInstance().getCache("eternalCache");
		Element element = new Element(meterNo, socket);
		eternalCache.put(element);
	}
	
	/**
	 * 获取socket
	 * @param meterNo
	 * @return
	 */
	public static Socket getSocketValue(String meterNo){
		Cache eternalCache = CacheManager.getInstance().getCache("eternalCache");
		Element element = eternalCache.get(meterNo);
		try {
			if(element !=null){
				Socket socket = (Socket) element.getObjectValue();
				return socket;
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}
	
	/**
	 * 获取读表操作
	 * 0：发送读水表操作
	 * 1：检查是否需要开阀
	 * 2：检查是否需要写表
	 * @param meterNo
	 * @return
	 */
	public static int getOperateValue(String meterNo){
		Cache eternalCache = CacheManager.getInstance().getCache("eternalCache");
		String key = "COUNT_" + meterNo;
		Element element = eternalCache.get(key);
		if(element != null){
			try {
				return Integer.parseInt(element.getObjectValue().toString());
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
		return 0;
	}
	
	/**
	 * 设置表的心跳次数
	 * 2次一个轮回
	 * @param meterNo
	 */
	public static void setHeartBeep(String meterNo){
		Cache eternalCache = CacheManager.getInstance().getCache("eternalCache");
		String key = "COUNT_" + meterNo;
		Element element = eternalCache.get(key);
		try {
			if(element != null){
				if((Integer.parseInt(element.getObjectValue().toString()) +1) < 2){
					operateValue = Integer.parseInt(element.getObjectValue().toString()) + 1;
				}else {
					operateValue = 0;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Element el = new Element(key, operateValue);
		System.out.println(operateValue);
		eternalCache.put(el);
	}
	public static void main(String[] args) {
		setHeartBeep("123123");
	}
}
