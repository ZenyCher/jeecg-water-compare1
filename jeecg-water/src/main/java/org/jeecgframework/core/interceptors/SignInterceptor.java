package org.jeecgframework.core.interceptors;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.util.JSONHelper;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.web.cgform.util.SignatureUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by dangzhenghui on 2017-4-1.
 */
public class SignInterceptor implements HandlerInterceptor {
    private static final String SIGN_KEY = "26F72780372E84B6CFAED6F7B19139CC47B1912B6CAED753";

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
            JSONObject j=new JSONObject();
        try {
//            String sign= request.getHeader("X-JEECG-SIGN");
//            String body = new String(request.getParameter("body").getBytes("iso-8859-1"), "utf-8");
//            此map用来做参数校验
//			Map map = JSONHelper.json2Map(body);
//            if( oConvertUtils.isEmpty(map.get("member_phone")) && oConvertUtils.isEmpty(map.get("token")) ) {
//            	j.put("success","false");
//                j.put("msg","手机号码及token不能为空");
//                response.getWriter().print(j.toJSONString());
//                return false;
//            }
        	String body = "{'member_phone':'13751772026'}";
            Map param=new HashMap();
			param.put("body",body);
			String sign=SignatureUtil.sign(param,SIGN_KEY);
            if (StringUtil.isEmpty(sign)) {
                throw new BusinessException("sign不能为空");
            }
            if (StringUtil.isEmpty(body)){
                throw new BusinessException("body不能为空");
            }
			Map paramMap =new HashMap();
            paramMap.put("body",body);
            if(!SignatureUtil.checkSign(paramMap, SIGN_KEY, sign)){
                throw new BusinessException("签名验证失败");
            }
        } catch (BusinessException e) {
            j.put("success","false");
            j.put("msg",e.getMessage());
            response.getWriter().print(j.toJSONString());
            return false;

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
