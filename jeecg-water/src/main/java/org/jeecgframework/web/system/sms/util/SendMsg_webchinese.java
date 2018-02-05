package org.jeecgframework.web.system.sms.util;

    import java.io.IOException;  
import java.io.UnsupportedEncodingException;  
      




    import org.apache.commons.httpclient.Header;  
import org.apache.commons.httpclient.HttpClient;  
import org.apache.commons.httpclient.HttpException;  
import org.apache.commons.httpclient.NameValuePair;  
import org.apache.commons.httpclient.methods.PostMethod;  
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
      
    public class SendMsg_webchinese {  
      
    	public static String code;
//        public static final String name = "cf_vtreetree";  
//        public static final String password = "vtreetree123";  
//        public static final String SMS_SEND_URI = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";
//        public static final String SMS_NUM_URI = "http://sms.webchinese.cn/web_api/SMS/?Action=SMS_Num";  

        public static final String Uid = "w7635371";  
        public static final String Key = "8103be3a5b715e5916a2";  
        public static final String SMS_SEND_URI = "http://utf8.sms.webchinese.cn/";

          
        // 发送短信  
        public static String sendMessage(String phone, String content) throws HttpException, IOException{  
            PostMethod post = new PostMethod(SMS_SEND_URI); 
            HttpClient client = new HttpClient();
            post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF8");//在头文件中设置转码
            System.out.println(content);
            NameValuePair[] data = { new NameValuePair("Uid", Uid),  
                    new NameValuePair("Key", Key),  
                    new NameValuePair("smsMob", phone),  
                    new NameValuePair("smsText", content) };
            post.setRequestBody(data);
            client.executeMethod(post);
            Header[] headers = post.getResponseHeaders();
            int statusCode = post.getStatusCode();
            System.out.println("statusCode:"+statusCode);
            for(Header h : headers)
            {
            System.out.println(h.toString());
            }
            String result = new String(post.getResponseBodyAsString().getBytes("gbk")); 
            System.out.println(result); //打印返回消息状态
//            String result = executeMethod(post, data);           
//            Document doc;
//			try {
//				doc = DocumentHelper.parseText(result);
//			
//			Element root = doc.getRootElement();
//
//		
//		    code = root.elementText("code");	
//			String msg = root.elementText("msg");	
//			String smsid = root.elementText("smsid");
//			} catch (DocumentException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
//            System.out.println("发送短信数量：" + result + "，手机号：" + phone + "信息：" + content);  
            post.releaseConnection();  
            return code;  
        }  
          
          
        private static String executeMethod(PostMethod post, NameValuePair[] data) throws HttpException, IOException{  
            post.addRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=UTF-8");  
            post.setRequestBody(data);  
            HttpClient client = new HttpClient();  
            client.getParams().setContentCharset("UTF-8");
            client.executeMethod(post);  
            Header[] headers = post.getResponseHeaders();  
            int statusCode = post.getStatusCode();  
            System.out.println("statusCode:" + statusCode);  
            for (Header h : headers) {  
                System.out.println(h.toString());  
            }  
            return new String(post.getResponseBodyAsString());  
        }  
    }  