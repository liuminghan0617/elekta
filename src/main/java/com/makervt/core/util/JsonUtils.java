package com.makervt.core.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 基于fastjson的处理静态工具类
 * 
 * @since JDK1.6
 * @version 1.0.0
 * @author core 2013-5-29 下午4:57:18
 */
public class JsonUtils {
	/**
	 * 获取JSON字符串
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-21 下午3:47:21
	 * @param object
	 *            实例对象
	 * @return JSON
	 */
	public static String toJson(Object object) {
		return JSON.toJSONString(object);
	}

	/**
	 * 获取JSON字符串。（各系统已使用此方式）
	 * <ul>
	 * <li>默认日期格式化格式yyyy-MM-dd HH:mm:ss
	 * <li>数字类型null时默认为数字0
	 * <li>字符串类型null默认字符串""
	 * <li>Map类型默认为null
	 * </ul>
	 * 由于fastjson中
	 * {@link JSON#toJSONStringWithDateFormat(Object, String, SerializerFeature...)
	 * 不支持对自定义拦截器{@link SerializeFilter}的支持。修改其JAR增加方法
	 * {@link JSON#toJSONStringWithDateFormat(Object, SerializeFilter, String, SerializerFeature...)}
	 * 
	 * @version 1.0.0
	 * @author 陈彦吉 2013-10-21 下午3:49:53
	 * @see
	 * @param json
	 *            JSON对象
	 * @param filter
	 *            过滤器
	 * @return JSON
	 */
	@Deprecated
	public static String toJson(JSONObject json, SerializeFilter filter) {
		SerializerFeature[] serializerFeatureNull = new SerializerFeature[] { SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullStringAsEmpty };
		return JSON.toJSONString(json, filter, serializerFeatureNull);
	}

	/**
	 * 获取JSON字符串。
	 * <ul>
	 * <li>默认日期格式化格式yyyy-MM-dd HH:mm:ss
	 * <li>Map类型默认为null
	 * </ul>
	 * 
	 * @version 1.0.0
	 * @author 陈彦吉 2013-10-21 下午3:49:53
	 * @see #toJsonNoDefault(JSONObject, SerializeFilter, String)
	 * @param json
	 *            JSON对象
	 * @param filter
	 *            过滤器
	 * @return JSON
	 */
	public static String toJsonNoDefault(JSONObject json, SerializeFilter filter) {
		return toJsonNoDefault(json, filter, DateUtils.YYYYMMDDHHMMSS);
	}

	/**
	 * 获取JSON字符串。
	 * <ul>
	 * <li>Map类型默认为null
	 * </ul>
	 * 由于fastjson中
	 * {@link JSON#toJSONStringWithDateFormat(Object, String, SerializerFeature...)
	 * 不支持对自定义拦截器{@link SerializeFilter}的支持。修改其JAR增加方法
	 * {@link JSON#toJSONStringWithDateFormat(Object, SerializeFilter, String, SerializerFeature...)}
	 * 
	 * @version 1.0.0
	 * @author 陈彦吉 2013-10-21 下午3:49:53
	 * @see
	 * @param json
	 *            JSON对象
	 * @param filter
	 *            过滤器
	 * @param dateFormat
	 *            日期格式化格式
	 * @return JSON
	 */
	public static String toJsonNoDefault(JSONObject json, SerializeFilter filter, String dateFormat) {
		SerializerFeature[] serializerFeatureNull = new SerializerFeature[] { SerializerFeature.WriteMapNullValue };
		return JSON.toJSONString(json, filter, serializerFeatureNull);
	}

	/**
	 * 获取JSON字符串。
	 * <ul>
	 * <li>默认日期格式化格式yyyy-MM-dd HH:mm:ss
	 * <li>Map类型默认为null
	 * </ul>
	 * 
	 * @version 1.0.0
	 * @author 陈彦吉 2013-10-21 下午3:49:53
	 * @see
	 * @param json
	 *            JSON对象
	 * @param filter
	 *            过滤器
	 * @return JSON
	 */
	public static String toJsonNoDefault(JSONObject json) {
		return toJsonNoDefault(json, DateUtils.YYYYMMDDHHMMSS);
	}

	/**
	 * 获取JSON字符串。
	 * <ul>
	 * <li>Map类型值默认为null
	 * </ul>
	 * 
	 * @version 1.0.0
	 * @author 陈彦吉 2013-10-21 下午3:49:53
	 * @see
	 * @param json
	 *            JSON对象
	 * @param filter
	 *            过滤器
	 * @param dateFormat
	 *            日期格式化格式
	 * @return JSON
	 */
	public static String toJsonNoDefault(JSONObject json, String dateFormat) {
		SerializerFeature[] serializerFeatureNull = new SerializerFeature[] { SerializerFeature.WriteMapNullValue };
		return JSON.toJSONStringWithDateFormat(json, dateFormat, serializerFeatureNull);
	}

}
