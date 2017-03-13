package com.makervt.elekta.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.makervt.core.domain.ResponseMessage;
import com.makervt.elekta.entity.User;
import com.makervt.elekta.service.UserService;

/**
 * TODO 安全拦截器
 * 
 * @author JimmySally
 *
 */
public class TokenInterceptor implements HandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(getClass());

	private List<String> included = new ArrayList<String>();
	private List<String> excluded = new ArrayList<String>();

	public List<String> getIncluded() {
		return included;
	}

	public void setIncluded(List<String> included) {
		this.included = included;
	}

	public List<String> getExcluded() {
		return excluded;
	}

	public void setExcluded(List<String> excluded) {
		this.excluded = excluded;
	}

	@Autowired
	private UserService userService;

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
		// 如果url在排除范围内则直接通过
		if (excluded.contains(request.getServletPath()))
			return true;
		if (included.contains(request.getServletPath())) {
			String token = request.getHeader("Authorization");
			String tokenNow = "";
			if (StringUtils.isEmpty(token)) {
				responseMsg = ResponseMessage.createErrorResponse("9998");
				response.getOutputStream().write(JSON.toJSONString(responseMsg).getBytes());
				return false;
			}
			try {
				User user = userService.explainToken(token);
				request.setAttribute("user", user);
				request.setAttribute("USER_KEY", user.getUserId());
				logger.debug("放入USER_KEY:"+user.getUserId());
				List<User> userList = userService.select(user);
				if (userList != null && userList.size() == 1) {
					user = userList.get(0);
					tokenNow = userService.generateToken(user);
					if (!StringUtils.equalsIgnoreCase(token, tokenNow)) {
						responseMsg = ResponseMessage.createErrorResponse("9998");
						response.getOutputStream().write(JSON.toJSONString(responseMsg).getBytes());
						return false;
					}
				} else {
					responseMsg = ResponseMessage.createErrorResponse("9998");
					response.getOutputStream().write(JSON.toJSONString(responseMsg).getBytes());
					return false;
				}
			} catch (Exception e) {
				logger.equals(e);
				responseMsg = ResponseMessage.createErrorResponse("9998");
				response.getOutputStream().write(JSON.toJSONString(responseMsg).getBytes());
				return false;
			}
		}
		return true;
	}

}
