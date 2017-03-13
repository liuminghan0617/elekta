package com.makervt.elekta.interceptor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.makervt.core.domain.ResponseMessage;
import com.makervt.core.util.EncrypCoder;

/**
 * TODO 安全拦截器
 * 
 * @author JimmySally
 *
 */
public class SignInterceptor implements HandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 不用校验的json格式接口
	 */
	private List<String> JsonExcluded = new ArrayList<String>();

	
	/**
	 * 不用校验的json格式接口
	 */
	private List<String> excluded = new ArrayList<String>();


	/**
	 * 参数值请求接口
	 */
	private List<String> paramIncluded = new ArrayList<String>();

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		ResponseMessage responseMsg = ResponseMessage.createSuccessResponse("0000");

		String sign = null;
		SortedMap<String, String> paramMap = new TreeMap<String, String>();
		if (excluded.contains(request.getServletPath())) 
				return true;
		
		if (paramIncluded.contains(request.getServletPath())) {
			sign = request.getHeader("sign");
			logger.info("sign1:<{}>", sign);
			if (StringUtils.isEmpty(sign)) {
				responseMsg = ResponseMessage.createErrorResponse("9997");
				response.getOutputStream().write(JSON.toJSONString(responseMsg).getBytes());
				return false;
			}
			Enumeration<String> enumer = request.getParameterNames();
			while (enumer.hasMoreElements()) {
				String key = enumer.nextElement();
				paramMap.put(key, ServletRequestUtils.getStringParameter(request, key));
			}
		} else if (JsonExcluded.contains(request.getServletPath())) {
			return true;
		} else {
			sign = request.getHeader("sign");
			logger.info("sign2:<{}>", sign);
			if (StringUtils.isEmpty(sign)) {
				responseMsg = ResponseMessage.createErrorResponse("9997");
				response.getOutputStream().write(JSON.toJSONString(responseMsg).getBytes());
				return false;
			}
			
			BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
			String line;
			StringBuffer jsonStr = new StringBuffer();
			while ((line = in.readLine()) != null) {
				jsonStr.append(line);
			}
			logger.info("接收到的参数:"+jsonStr.toString());
			if(StringUtils.isNotEmpty(jsonStr.toString()))
			{
				//由于反序列化排序问题放弃了好用的fastjson
				net.sf.json.JSONObject json=net.sf.json.JSONObject.fromObject(jsonStr.toString());
				//JSONObject json = JSON.parseObject(jsonStr.toString());
				request.setAttribute("JSON_DATA", jsonStr.toString());
				if(json!=null)
				{
					Iterator<String> it=json.keys();
					while(it.hasNext())
					{
						String key=it.next();
						String value=json.getString(key);
						paramMap.put(key, value);
					}
				}
			}
		}
		logger.info("paramMap:<{}>",paramMap);
		//验证签名
		boolean checkSign = EncrypCoder.verfitySign(paramMap, sign);
		if (checkSign) {
			return true;
		} else {
			responseMsg = ResponseMessage.createErrorResponse("9997");
			response.getOutputStream().write(JSON.toJSONString(responseMsg).getBytes());
			return false;
		}
	}

	public List<String> getJsonExcluded() {
		return JsonExcluded;
	}

	public void setJsonExcluded(List<String> jsonExcluded) {
		JsonExcluded = jsonExcluded;
	}

	public List<String> getParamIncluded() {
		return paramIncluded;
	}

	public void setParamIncluded(List<String> paramIncluded) {
		this.paramIncluded = paramIncluded;
	}
	public List<String> getExcluded() {
		return excluded;
	}

	public void setExcluded(List<String> excluded) {
		this.excluded = excluded;
	}
	
}
