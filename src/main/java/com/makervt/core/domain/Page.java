package com.makervt.core.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.makervt.core.util.JsonUtils;
import com.makervt.core.util.StringUtils;
import com.google.common.collect.Lists;

/**
 * 与具体ORM实现无关的分页查询结果封装.
 * 
 * @since JDK1.6
 * @version 1.0.0
 * @author core 2013-5-29 下午4:57:18
 */
public class Page<T> extends PageRequest implements Iterable<T>, Serializable {
	private static final long serialVersionUID = 1L;
	protected List<T> result = null;
	
	

	/**
	 * 数据集合result外的其他数据
	 */
	protected Map<String, Object> resultMap = null;

	public Page() {
	}

	/**
	 * 获得JSON扩展属性
	 * 
	 * @version 1.0.0
	 * @author 陈彦吉 2013-10-21 上午10:04:43
	 * @return
	 */
	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	/**
	 * 设置JSON中根节点属性值，作为JSON属性的扩展
	 * 
	 * @version 1.0.0
	 * @author 陈彦吉 2013-10-21 上午10:05:06
	 * @see #toJsonString(Object)
	 * @param resultMap
	 */
	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	/**
	 * 获得页内的记录列表.
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-21 上午10:08:15
	 * @return 记录集
	 */
	public List<T> getResult() {
		return result;
	}

	/**
	 * 设置页内的记录列表.
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-21 上午10:08:50
	 * @param result
	 */
	public void setResult(final List<T> result) {
		this.result = result;
	}

	/**
	 * 实现Iterable接口, 可以for(Object item : page)遍历使用
	 */
	public Iterator<T> iterator() {
		return result.iterator();
	}

	



	/**
	 * 与页面datatable分页组件对应的json数据封装
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-21 上午10:14:03
	 * @see #initJsonString(SerializeFilter)
	 */
	public String toJsonString() {
		return initJsonString(null);
	}

	/**
	 * 转换JSON对象，当使用到JSONFilter对节点属性与类属性引用时有效
	 * 
	 * @version 1.0.0
	 * @author 陈彦吉 2013-5-30 下午1:42:26
	 * @see #initJsonString(SerializeFilter)
	 * @see #propertyFilter(Object)
	 * @param clazz
	 *            已经实例化类对象，{@link JSONFilter}逻辑所需
	 */
	public String toJsonString(Object clazz) {
		return initJsonString(propertyFilter(clazz));
	}

	/**
	 * 初始化JSON默认属性，包括分页、附加属性值、对象默认值等，在部分系统中设置了默认值可能存在问题。
	 * 
	 * @version 1.0.0
	 * @author 陈彦吉 2013-5-30 下午1:42:26
	 * @see {@link JsonUtils#toJson(JSONObject, SerializeFilter)}
	 * @param filter
	 * @return
	 */
	@Deprecated
	protected String initJsonString(SerializeFilter filter) {
		JSONObject json = new JSONObject();
		// json.put("sEcho",this.getsEcho());
		json.put("iTotalRecords", String.valueOf(this.getTotalCount()));
		json.put("iTotalDisplayRecords", String.valueOf(this.getTotalCount()));
		json.put("aaData", this.getResult());
		if (this.getResultMap() != null) {
			for (Entry<String, Object> entry : this.getResultMap().entrySet()) {
				json.put(entry.getKey(), entry.getValue());
			}
		}
		// 序列化配置
		return JsonUtils.toJson(json, filter);
	}

	/**
	 * 完成JSONFilter处理过程，并根据值（动态参数）完成逻辑校验
	 * 
	 * @version 1.0.0
	 * @author 陈彦吉 2013-5-30 下午1:42:26
	 */
	protected SerializeFilter propertyFilter(Object clazz) {
		SerializeFilter filter = null;
		if (clazz == null) {
			return null;
		}
		try {
			JSONFilter jSONGis = (JSONFilter) clazz.getClass().getAnnotation(
					JSONFilter.class);
			if (jSONGis != null && jSONGis.ignores().length > 0) {
				final String[] property = includeProperty(jSONGis, clazz,
						jSONGis.ignores());
				filter = new PropertyFilter() {
					@Override
					public boolean apply(Object source, String name,
							Object value) {
						for (String per : property) {
							if (per.equals(name)) {
								return false;
							}
						}
						return true;
					}
				};
			} else if (jSONGis != null
					&& jSONGis.includeSimpleProperty().length > 0) {
				String strs[] = includeProperty(jSONGis, clazz,
						jSONGis.includeSimpleProperty());
				if (strs != null) {
					filter = new SimplePropertyPreFilter(clazz.getClass(), strs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return filter;
	}

	/**
	 * 从类对象中解析数组，支持动态参数${}，其中动态参数必须包含get方法。（如果是${}类型则进行反射）
	 * 
	 * @version 1.0.0
	 * @author 陈彦吉 2013-5-30 下午1:42:26
	 * @param jSONGis
	 * @param clazz
	 *            类对象
	 * @param property
	 *            拦截属性
	 */
	protected String[] includeProperty(JSONFilter jSONGis, Object clazz,
			String[] property) {
		String[] strs = null;
		String[] pro = property;
		List<String> list = new ArrayList<String>();
		for (String include : pro) {
			if (include.indexOf("$") == 0) {
				String[] temp = null;
				try {
					temp = (String[]) clazz
							.getClass()
							.getMethod(
									"get"
											+ StringUtils
													.removeUnderscores(include
															.replace("${", "")
															.replace("}", "")))
							.invoke(clazz);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (temp != null) {
					for (String in : temp) {
						list.add(in);
					}
				}
			} else {
				list.add(include);
			}
		}
		if (list.size() != 0) {
			strs = list.toArray(new String[list.size()]);
		}
		return strs;
	}
}
