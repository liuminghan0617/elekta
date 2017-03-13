package com.makervt.core.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 随机数工具类.
 * 
 * @since JDK1.6
 * @version 1.0.0
 * @author core 2013-5-29 下午4:57:18
 */
public final class IdentityUtils {
	@SuppressWarnings("unused")
	private static final Log logger = LogFactory.getLog(IdentityUtils.class);
	
	/**
	 * 获取20位随即数，其中包含13位系统时间+位随机数
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-21 下午3:38:44
	 * @see #mathRandom(long)
	 */
	public static final String generateID() {
		String id = System.currentTimeMillis() + "" + mathRandom(7);
		/*SessionReport report = new SessionReport();
		if(!report.getResponse())
			throw new ProjectException();*/
		return id;
	}
	/**
	 * 产生指定长度的数学随机数
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-21 下午3:40:27
	 * @param length 随机数长度
	 * @return 随机数
	 */
	public static final String mathRandom(final long length) {
		double len = Math.pow(10D, length);
		long result = (long) (len * Math.random());

		// 补齐随机数长度
		while (len / result > 10) {
			result *= 10;
		}
		return Long.toString(result);
	}
	
	public static void main(String aa[]){
		System.out.println(System.currentTimeMillis());
	}
}
