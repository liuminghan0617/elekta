package com.makervt.core.util;

import java.util.Date;

import org.joda.time.format.DateTimeFormat;

/**
 * 时间处理静态工具类
 * 
 * @since JDK1.6
 * @version 1.0.0
 * @author core 2013-5-29 下午4:57:18
 */
public class TimeUtils {

	/**
	 * 获取当前时间
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-22 下午4:24:12
	 * @see {@link java.util.Date}
	 * @return
	 */
	public static Date now() {
		return new Date();
	}

	/**
	 * 格式化当前系统日期
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-22 下午4:25:12
	 * @param format 格式化方式
	 * @return
	 */
	public static String formatNow(String format) {
		return DateTimeFormat.forPattern(format).print(System.currentTimeMillis());
	}

	/**
	 * 使用默认格式化当前系统时间
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-22 下午4:25:57
	 * @see {@link DateUtils#SORT_YYYYMMDDHHMMSS}
	 * @return
	 */
	public static String formatNow() {
		return formatNow(DateUtils.SORT_YYYYMMDDHHMMSS);
	}

}
