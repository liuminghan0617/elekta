package com.makervt.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import com.makervt.core.exception.AppException;

/**
 * 属性文件读取工具
 * 
 * @since JDK1.6
 * @version 1.0.0
 * @author core 2013-10-18 上午11:03:04
 */
public class PropertyUtils {

	/**
	 * @param fileName 属性文件路径及名字
	 */
	public PropertyUtils(String fileName) {
		this.fileName = fileName;
		PropertyUtils.loadProperty(this.fileName);
	}

	private String fileName;

	private static Properties config = new Properties();

	/**
	 * 加载属性文件
	 * <p>example:<pre>
	 * PropertyUtils p = PropertyUtils.loadProperty("c:/aa.property");
	 * </pre>
	 * @version 1.0.0
	 * @author core 2013-10-18 上午11:13:02
	 * @see {@link InputStream}
	 * @see {@link Properties}
	 * @param fileName 属性文件
	 */
	public static void loadProperty(String fileName) {
		InputStream in = null;
		in = PropertyUtils.class.getClassLoader().getResourceAsStream(fileName);
		try {
			config.load(in);
			//config.list(System.out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取属性文件中属性值
	 * <p>example:<pre>
	 * PropertyUtils p = PropertyUtils.loadProperty("c:/aa.property");
	 * String str = p.getProperty("test.test");
	 * </pre>
	 * @version 1.0.0
	 * @author core 2013-10-18 上午11:15:57
	 * @see #loadProperty(String)
	 * @param name
	 * @return {@link String}
	 */
	public static String getProperty(String name) {
		String value = null;
		try {
			value = config.getProperty(name);
		} catch (Exception e) {
			AppException.getException("4515", e);
		}
		return value;
	}

	/**
	 * 根据标识获取属性名称列表，例如verify.0001  verify.0002
	 * @param prefix
	 * @return
	 */
	public List<String> getNamesList(String prefix) {
		if (config == null || prefix == null) {
			return Collections.emptyList();
		}
		List<String> list = new ArrayList<String>();
		Enumeration<?> en = config.propertyNames();
		String key;
		while (en.hasMoreElements()) {
			key = (String) en.nextElement();
			if (key.startsWith(prefix)) {
				list.add(key);
			}
		}
		return list;
	}
	
	/**
	 * 根据标识获取属性列表，例如verify.0001  verify.0002
	 * @param prefix
	 * @return
	 */
	public List<String> getValuesList(String prefix) {
		if (config == null || prefix == null) {
			return Collections.emptyList();
		}
		List<String> list = new ArrayList<String>();
		Enumeration<?> en = config.propertyNames();
		String key;
		while (en.hasMoreElements()) {
			key = (String) en.nextElement();
			if (key.startsWith(prefix)) {
				list.add(config.getProperty(key));
			}
		}
		return list;
	}
	
	public Map<String,String> toHashMap()
	{
		Map<String, String> configMap= new HashMap<String,String>((Map)config);
		return configMap;
	}
	
	/**
	 * @param args
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PropertyUtils error = new PropertyUtils("error.properties");
		error.config.list(System.out);
		try {
			System.out.println(new String(PropertyUtils.getProperty("1001").getBytes(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
