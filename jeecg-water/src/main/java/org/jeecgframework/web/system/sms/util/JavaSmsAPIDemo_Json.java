package org.jeecgframework.web.system.sms.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.jeecgframework.core.util.PropertiesUtil;
import org.jeecgframework.web.system.sms.util.smsmengwang.CHttpPost;
import org.jeecgframework.web.system.sms.util.smsmengwang.Message;
import org.jeecgframework.web.system.sms.util.smsmengwang.ConfigManager;

public class JavaSmsAPIDemo_Json {

	// 日期格式定义
	private static SimpleDateFormat	sdf	= new SimpleDateFormat("MMddHHmmss");
	/**
	 * 
	 * @description  单条发送  
	 * @param userid  用户账号
	 * @param pwd 用户密码
	 * @param isEncryptPwd 密码是否加密   true：密码加密;false：密码不加密
	 */
	public static String singleSend(String phone, String content){
		try{
			//主IP信息  必填
			String masterIpAddress="api01.monyun.cn:7901";
			//备IP1  选填
			String ipAddress1="api01.monyun.cn:7901/sms/v2/std/";
			//备IP2  选填
			String ipAddress2="api01.monyun.cn:7901/sms/v2/std/single_send";
			//备IP3  选填
			String ipAddress3=null;
			//设置IP
			ConfigManager.setIpInfo(masterIpAddress, ipAddress1, ipAddress2, ipAddress3);
			//获取配置文件信息
			PropertiesUtil util = new PropertiesUtil("wechat.properties");
			String userId = util.readProperty("wechat.message.user.id");
			String userPwd = util.readProperty("wechat.message.pwd");
			//密码是否加密   true：密码加密;false：密码不加密
			ConfigManager.IS_ENCRYPT_PWD=true;
			boolean isEncryptPwd=ConfigManager.IS_ENCRYPT_PWD;
			
			// 参数类
			Message message = new Message();
			// 实例化短信处理对象
			CHttpPost cHttpPost = new CHttpPost();			
			// 设置账号   将 userid转成大写,以防大小写不一致
			message.setUserid(userId.toUpperCase());			
			//判断密码是否加密。
			//密码加密，则对密码进行加密
			if(isEncryptPwd){
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
				String timestamp = sdf.format(date);
				// 设置时间戳
//				String timestamp = sdf.format(Calendar.getInstance().getTime());
				message.setTimestamp(timestamp);				
				// 对密码进行加密
				String encryptPwd = cHttpPost.encryptPwd(message.getUserid(), userPwd, message.getTimestamp());
				// 设置加密后的密码
				message.setPwd(encryptPwd);				
			}else{				// 设置密码
				message.setPwd(userPwd);
			}
			message.setApikey("3c2090988087f466a3c44eeb91c721f9");
			// 设置手机号码 此处只能设置一个手机号码
			message.setMobile(phone);
			// 设置内容
			message.setContent(content);
			// 设置扩展号
			message.setExno("0006");
			// 用户自定义流水编号
			message.setCustid("b3d0a2783d31b21b8573");
			// 自定义扩展数据
			message.setExdata("abcdef");
			//业务类型
			message.setSvrtype("SMS001");
			// 返回的平台流水编号等信息
			StringBuffer msgId = new StringBuffer();
			// 返回值
//			int result = -310099;
			// 发送短信
			int result = cHttpPost.singleSend(message, msgId);
			// result为0:成功;非0:失败
			if(result == 0){
				System.out.println("单条发送提交成功！");
				System.out.println(msgId.toString());
				return "0";
			}
		}
		catch (Exception e){
			//异常处理
			e.printStackTrace();
		}
		return null;
	}
	
//	public String getTime(){
//		String timestampy = cstr(right("00" &Month(now()),2));
//		String timestampm = cstr(right("00" &day(now()),2));
//		String timestampd = cstr(right("00" &hour(now()),2));
//		String timestamph = cstr(right("00" &Minute(now()),2));
//		String timestamps = cstr(right("00" &Second(now()),2));
//		String timestamp=timestampy+timestampm+timestampd+timestamph+timestamps;
//		return timestamp;
//	}
}
