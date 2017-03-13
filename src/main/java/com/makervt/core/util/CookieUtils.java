package com.makervt.core.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

/**
 * 应用cookie处理静态类
 * 
 * @since JDK1.6
 * @version 1.0.0
 * @author core 2013-5-29 下午4:57:18
 */
public class CookieUtils {
	private static final int DEFAULT_COOKIE_TIMEOUT = -1; // 缺省Cookie过期时间:在浏览器打开期间一直有效

	/**
	 * 设置cookie
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-21 上午11:28:00
	 * @see #setCookieValue(HttpServletResponse, String, String, int)
	 * @param response
	 *            {@link HttpServletResponse}
	 * @param name
	 *            cookie名
	 * @param value
	 *            cookie值
	 */
	public static void setCookieValue(HttpServletResponse response, String name, String value) {
		setCookieValue(response, name, value, DEFAULT_COOKIE_TIMEOUT);
	}

	/**
	 * 设置cookie
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-21 上午11:28:00
	 * @param response
	 *            {@link HttpServletResponse}
	 * @param name
	 *            cookie名
	 * @param value
	 *            cookie值
	 * @param expiredSeconds
	 *            cookie超时时间
	 */
	public static void setCookieValue(HttpServletResponse response, String name, String value, int expiredSeconds) {
		Cookie cookies = new Cookie(name, value);
		cookies.setPath("/");
		cookies.setMaxAge(expiredSeconds);
		response.addCookie(cookies);
	}

	/**
	 * 获得cookie值
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-21 上午11:30:41
	 * @param request
	 *            {@link HttpServletRequest}
	 * @param cookieName
	 *            cookie名
	 * @return cookie值
	 */
	public static String getCookieValue(HttpServletRequest request, String cookieName) {
		if (request.getCookies() == null)
			return "";
		for (Cookie cookie : request.getCookies()) {
			if (cookieName.equals(cookie.getName()))
				return cookie.getValue();
		}
		return "";
	}

	/**
	 * 从请求头中获得cookie值
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-21 上午11:32:50
	 * @see {@link HttpServletRequest#getHeader(String)}
	 * @param request
	 *            {@link HttpServletRequest}
	 * @param cookieName
	 *            cookie名
	 * @return cookie值
	 */
	public static String getCookieValueFromHeader(HttpServletRequest request, String cookieName) {
		String cookies = request.getHeader("Cookie");
		if (StringUtils.isBlank(cookies))
			return "";
		for (String cookie : cookies.split(";")) {
			String[] cookiePair = StringUtils.split(cookie, "=", 2);
			if (cookieName.equals(StringUtils.trim(cookiePair[0])))
				return StringUtils.trim(cookiePair[1]);
		}
		return "";
	}

}
