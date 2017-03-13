package com.makervt.core.util;

/**
 * 逻辑判断静态工具类，未来版本中可能被删除（预计维护vaildate相关验证类）
 * 
 * @since JDK1.6
 * @version 1.0.0
 * @author core 2013-5-29 下午4:57:18
 */
@Deprecated
public class LogicUtils {
	public static boolean isEmpty(String str) {
		return (str == null || str.trim().length()==0);
	}
	public static boolean isEmpty(String str, String emptyStr) {
		return (isEmpty(str) || str.trim().equalsIgnoreCase(emptyStr));
	}

	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
	
	public static boolean isNotEmpty(String str, String emptyStr) {
		return !isEmpty(str, emptyStr);
	}
	
	public static boolean isEquals(String one, String two) {
		if (one != null && two != null) {
			return one.trim().equals(two.trim());
		} else if (one == null && two == null) {
			return true;
		} else if (one == null && two.trim().length() == 0) {
			return true;
		} else if (two == null && one.trim().length() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isEqualsIgnoreCase(String one, String two) {
		if (one != null && two != null) {
			return one.trim().equalsIgnoreCase(two.trim());
		} else if (one == null && two == null) {
			return true;
		} else if (one == null && two.trim().length() == 0) {
			return true;
		} else if (two == null && one.trim().length() == 0) {
			return true;
		} else {
			return false;
		}
	}
}
