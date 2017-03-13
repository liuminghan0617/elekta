package com.makervt.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 日期处理静态工具类，继承于{@link org.apache.commons.lang.time.DateUtils}
 * <p>
 * 数据库日期类型建议使用{@link java.util.Date}而不是使用{@link java.sql.Date}
 * 
 * @since JDK1.6
 * @version 1.0.0
 * @author 陈彦吉 2013-5-29 下午4:57:18
 */
public class DateUtils extends org.apache.commons.lang.time.DateUtils {

	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
	/**
	 * yyyyMMddHHmmssSSS
	 */
	public static final String SORT_YYYYMMDDHHMMSS = "yyyyMMddHHmmssSSS";
	/**
	 * yyyy-MM-dd
	 */
	public static final String YYYYMMDD = "yyyy-MM-dd";

	public static java.util.Date getCurrentDate() {
		return new java.util.Date();
	}

	/**
	 * 根据日期字符串自动转换成{@link java.util.Date}
	 * <p>
	 * 支持格式如下：
	 * <ul>
	 * <li>yyyy-MM-dd HH:mm:ss
	 * <li>yyyy-MM-dd
	 * </ul>
	 * 
	 * @version 1.0.0
	 * @author 陈彦吉 2013-10-21 上午11:51:30
	 * @see {@link SimpleDateFormat}
	 * @param date
	 * @return
	 */
	public static java.util.Date getDate(String date) {
		date = date.replaceAll("\\.", "-");
		date = date.replaceAll("/", "-");
		if (date.trim().length() == 10) {
			SimpleDateFormat simpl = new SimpleDateFormat(YYYYMMDD);
			try {
				return simpl.parse(date);
			} catch (ParseException e) {
				throw new RuntimeException(date + "日期格式错误");
			}
		} else if (date.trim().length() == 19) {
			SimpleDateFormat simpl = new SimpleDateFormat(YYYYMMDDHHMMSS);
			try {
				return simpl.parse(date);
			} catch (ParseException e) {
				throw new RuntimeException(date + "日期格式错误");
			}
		} else {
			throw new RuntimeException(date + "日期格式无法识别");
		}
	}

	/**
	 * 获得{@link java.util.Date}格式化字符串，使用默认格式进行格式化yyyy-MM-dd HH:mm:ss
	 * 
	 * @version 1.0.0
	 * @author 陈彦吉 2013-10-21 上午11:54:12
	 * @see #getDate(java.util.Date, String)
	 * @param date
	 * @return
	 */
	public static String getDate(java.util.Date date) {
		SimpleDateFormat simpl = new SimpleDateFormat(YYYYMMDDHHMMSS);
		return simpl.format(date);
	}
	/**
	 * 获得{@link java.util.Date}格式化字符串
	 * 
	 * @version 1.0.0
	 * @author 陈彦吉 2013-10-21 上午11:55:11
	 * @see
	 * @param date 日期对象
	 * @param format 格式化规则
	 * @return
	 */
	public static String getDate(java.util.Date date,String format) {
		SimpleDateFormat simpl = new SimpleDateFormat(format);
		return simpl.format(date);
	}

	public static void main(String aa[]) {
		System.out.println(getDate("2020-07-28 23:59:59"));
	}
}
