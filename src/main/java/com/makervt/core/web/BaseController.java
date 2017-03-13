package com.makervt.core.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.alibaba.fastjson.JSON;
import com.makervt.core.domain.ResponseMessage;
import com.makervt.elekta.api.ScheduleApi;

public class BaseController implements Controller{  
   
   private static String USER_KEY="USER_KEY";
   private static Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	@ExceptionHandler  
    public @ResponseBody ResponseMessage handleException(HttpServletRequest request, Exception ex) {  
    	ResponseMessage responseMessage=ResponseMessage.createErrorResponse("9999");
    	Map<String, String> errorMap = new HashMap<String, String>();  
		errorMap.put("ex", ex.getMessage());  
		responseMessage.setError(errorMap);
		ex.printStackTrace();
         return  responseMessage;
    }

 
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	private  HttpServletRequest request;
	
	protected HttpServletRequest getRequest() {
		return  ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();

	}
	protected String getJsonByInterceptor(HttpServletRequest request)
	{
		String json=(String)request.getAttribute("JSON_DATA");
		return json;
	}
	
	protected String getJson(HttpServletRequest request) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String line;
		StringBuffer jsonStr = new StringBuffer();
		while ((line = in.readLine()) != null) {
			jsonStr.append(line);
		}
		return jsonStr.toString();
	}
	protected <T> T getJsonJavaByInterceptor(HttpServletRequest request,Class<T> clazz) throws Exception
	{
		Object object=request.getAttribute("JSON_DATA");
		if(null==object)
			return clazz.newInstance();
		String json=(String)request.getAttribute("JSON_DATA");
		return  JSON.parseObject(json, clazz);
	}
	
	
	protected Object getAttribute(HttpServletRequest request,String key)
	{
		return request.getAttribute(key);
	}
	
	/*
	 * 验证回话中的用户是否符合当前用户
	 */
	protected boolean isVerfityUser(HttpServletRequest request, String userKey) {
		String key = (String) getAttribute(request, USER_KEY);
		logger.debug("userKey:" + key + " now user:" + userKey);
		return StringUtils.equalsIgnoreCase(key, userKey);
	}
	
}  