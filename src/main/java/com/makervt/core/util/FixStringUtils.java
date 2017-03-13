package com.makervt.core.util;

import org.apache.commons.lang.StringUtils;

/**
 * 字符串处理静态工具类
 * 
 * @since JDK1.6
 * @version 1.0.0
 * @author core 2013-5-29 下午4:57:18
 */
public class FixStringUtils {

	/**
	 * 添加字符串缓冲对象
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-21 下午2:16:00
	 * @see {@link StringBuffer#append(String)}
	 * @param buffer
	 *            缓冲对象
	 * @param text
	 *            字符数据
	 * @return 缓冲对象
	 */
	public static StringBuffer append(StringBuffer buffer, String text) {
		buffer.append(text);
		return buffer;
	}

	/**
	 * 添加字符串缓冲对象
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-21 下午2:19:05
	 * @see {@link StringBuffer#append(String)}
	 * @param buffer
	 *            缓冲对象
	 * @param text
	 *            字符数据
	 * @param defaultText
	 *            默认值
	 * @return 缓冲对象
	 */
	public static StringBuffer appendDefault(StringBuffer buffer, String text, String defaultText) {
		buffer.append(StringUtils.defaultIfEmpty(text, defaultText));
		return buffer;
	}

	/**
	 * 添加字符串缓冲对象，字符自动左补齐（中文按照字符数量计算）
	 * 
	 * <pre>
	 * StringBuffer s = new StringBuffer(&quot;aaaa&quot;);
	 * System.out.println(appendLpad(s, &quot;bb&quot;, 5, 'c'));
	 * 在缓冲字符aaaa中增加字符，其字符5位bb，不够位数左补齐c
	 * 输出结果未：aaaacccbb
	 * </pre>
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-21 下午2:26:44
	 * @param buffer
	 *            缓冲对象
	 * @param text
	 *            字符数据
	 * @param length
	 *            字符数据中位置
	 * @param padChar
	 *            自动补齐字符
	 * @return 缓冲对象
	 */
	public static StringBuffer appendLpad(StringBuffer buffer, String text, int length, char padChar) {
		buffer.append(StringUtils.leftPad(StringUtils.defaultIfEmpty(text, ""), length, padChar));
		return buffer;
	}

	/**
	 * 添加字符串缓冲对象，字符自动右补齐（中文按照字符数量计算）
	 * 
	 * <pre>
	 * StringBuffer s = new StringBuffer(&quot;aaaa&quot;);
	 * System.out.println(appendRpad(s, &quot;bb&quot;, 5, 'c'));
	 * 在缓冲字符aaaa中增加字符，其字符5位bb，不够位数右补齐c
	 * 输出结果未：aaaabbccc
	 * </pre>
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-21 下午2:26:44
	 * @param buffer
	 *            缓冲对象
	 * @param text
	 *            字符数据
	 * @param length
	 *            字符数据中位置
	 * @param padChar
	 *            自动补齐字符
	 * @return 缓冲对象
	 */
	public static StringBuffer appendRpad(StringBuffer buffer, String text, int length, char padChar) {
		buffer.append(StringUtils.rightPad(StringUtils.defaultIfEmpty(text, ""), length, padChar));
		return buffer;
	}

	/**
	 * 添加字符串缓冲对象，字符自动右补齐，支持中文处理，使用UTF-8处理的中文字符占3位
	 * 
	 * <pre>
	 * StringBuffer s = new StringBuffer("爱爱爱");
	 * System.out.println(appendRpad(s, "太太太","", 10, 'c'));
	 * 在缓冲字符aaaa中增加字符，其字符5位bb，不够位数右补齐c
	 * 输出结果：爱爱爱太太太c
	 * </pre>
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-21 下午2:36:05
	 * @param buffer
	 *            缓冲对象
	 * @param text
	 *            字符数据
	 * @param encoding
	 *            编码格式，目前未使用
	 * @param length
	 *            字符数据中位置
	 * @param padChar
	 *            自动补齐字符
	 * @return 缓冲对象
	 */
	public static StringBuffer appendRpad(StringBuffer buffer, String text, String encoding, int length, char padChar) {
		int diffLength = text.getBytes().length - text.length();
		buffer.append(StringUtils.rightPad(StringUtils.defaultIfEmpty(text, ""), length - diffLength, padChar));
		return buffer;
	}

	public static void main(String aa[]) {
		StringBuffer s = new StringBuffer("爱爱爱");
		System.out.println(appendRpad(s, "太太太", "", 10, 'c'));
	}
}
