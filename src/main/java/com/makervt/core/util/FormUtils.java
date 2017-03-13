package com.makervt.core.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;

import com.makervt.core.domain.Page;

/**
 * 表单绑定静态工具类，多用于前后台请求参数传递时的类对象绑定
 * 
 * @since JDK1.6
 * @version 1.0.0
 * @author core 2013-5-29 下午4:57:18
 */
public class FormUtils {

	/**
	 * 為調用方便提供靜態方法
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-21 下午2:51:15
	 * @see #FormUtils()
	 */
	public static FormUtils getFormUtilsInstance() {
		return new FormUtils();
	}

	/**
	 * 通过反射方式按照属性名称调用对象的set方法设置该属性的值
	 * 
	 * @param obj
	 *            被调用对象
	 * @param property
	 *            属性名称
	 * @param value
	 *            属性值
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	private static void invokeSetMethod(Object obj, String property, Object value) throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		Method[] mets = obj.getClass().getMethods();
		for (Method m : mets) {
			String n = m.getName();
			if (n.length() > 3 && n.substring(0, 3).equals("set") && n.substring(3).toLowerCase().equals(property.toLowerCase())) {
				m.invoke(obj, value);
				break;
			}
		}
	}
	
	public static Object invokeGetMethod(Object obj, String property)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		Object ob = null;
		Method[] mets = obj.getClass().getMethods();
		for (Method m : mets) {
			String n = m.getName();
			if (n.length() > 3 && n.substring(0, 3).equals("get")
					&& n.substring(3).toLowerCase().equals(property)) {
				ob = m.invoke(obj);
				break;
			}
		}
		return ob;
	}

	/**
	 * 从rquest中将页面DataTable分页组件传过的参数绑定至需要分页的对象中
	 * 
	 * @param clazz
	 *            集成Page的domain对象
	 * @return clazz
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 */
	@SuppressWarnings("static-access")
	public Object bindDataTableParm(Class<? extends Page> clazz, HttpServletRequest request) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException, InstantiationException {
		Object object = this.bindFormToObject(clazz, request);
		this.invokeSetMethod(object, "pageSize", NumberUtils.createInteger(request.getParameter("iDisplayLength")));
		String orderBy = request.getParameter("mDataProp_" + request.getParameter("iSortCol_0"));
		this.invokeSetMethod(object, "orderBy", "0".equalsIgnoreCase(orderBy) ? "" : orderBy);
		this.invokeSetMethod(object, "orderDir", request.getParameter("sSortDir_0"));
		this.invokeSetMethod(object, "sSearch", request.getParameter("sSearch"));
		this.invokeSetMethod(object, "start", NumberUtils.createInteger(request.getParameter("iDisplayStart")));
		return object;
	}

	/**
	 * 将页面传入request按名称绑定至domain对象
	 * 
	 * @param <T>
	 * @param requiredType
	 * @return
	 * @throws InstantiationException
	 */
	@SuppressWarnings("static-access")
	public <T> T bindFormToObject(Class<T> t, HttpServletRequest request) throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, InstantiationException {
		Map<String, Object> map = request.getParameterMap();
		return this.bindFormToObject(t, map);
	}

	/**
	 * 将页面传入参数按名称绑定至domain对象
	 * <p>
	 * 支持如下对象的绑定
	 * <ul>
	 * <li>{@link java.lang.String}
	 * <li>{@link java.math.BigDecimal}
	 * <li>{@link java.sql.Timestamp}
	 * <li>{@link java.util.Date}
	 * <li>{@link java.sql.Date}
	 * <li>{@link java.lang.Double}
	 * <li>{@link java.lang.Integer}
	 * </ul>
	 * 
	 * @param <T>
	 * @param requiredType
	 * @return
	 * @throws InstantiationException
	 */
	@SuppressWarnings("static-access")
	public <T> T bindFormToObject(Class<T> t, Map map) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException,
			InstantiationException {
		Object object = t.newInstance();
		Field[] fields = getField(t);
		for (Field field : fields) {
			String[] values = (String[]) map.get(field.getName());
			if (values != null && values.length > 0)
				if ("java.lang.String".equals(field.getType().getName())) {
					this.invokeSetMethod(object, field.getName().toLowerCase(), values[0]);
				} else if ("java.math.BigDecimal".equals(field.getType().getName())) {
					if (!"".equals(values[0].trim()))
						this.invokeSetMethod(object, field.getName().toLowerCase(), NumberUtils.createBigDecimal(values[0]));
				} else if ("java.sql.Timestamp".equals(field.getType().getName())) {
					if (!"".equals(values[0].trim()))
						this.invokeSetMethod(object, field.getName().toLowerCase(), Timestamp.valueOf((values[0])));
				} else if ("java.util.Date".equals(field.getType().getName())) {
					if (!"".equals(values[0].trim()))
						this.invokeSetMethod(object, field.getName().toLowerCase(), com.makervt.core.util.DateUtils.getDate(values[0]));
				} else if ("java.sql.Date".equals(field.getType().getName())) {
					if (!"".equals(values[0].trim()))
						this.invokeSetMethod(object, field.getName().toLowerCase(), java.sql.Date.valueOf(values[0]));
				} else if ("java.lang.Double".equals(field.getType().getName())) {
					if (!"".equals(values[0].trim()))
						this.invokeSetMethod(object, field.getName().toLowerCase(), NumberUtils.createDouble(values[0]));
				} else if ("java.lang.Integer".equals(field.getType().getName()) || "int".equalsIgnoreCase(field.getType().getName())) {
					if (!"".equals(values[0].trim()))
						this.invokeSetMethod(object, field.getName().toLowerCase(), NumberUtils.createInteger(values[0]));
				}
			
		}
		return (T) object;
	}

	/**
	 * 返回对象属性对象集合（使用递归方式完成对父类的支持）
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-21 下午2:57:26
	 * @param clazz
	 *            类对象
	 * @return
	 */
	public  Field[] getField(Class clazz) {
		List<Field> fieldList = new ArrayList<Field>();
		for (Field field : clazz.getDeclaredFields()) {
			fieldList.add(field);
		}
		if (clazz.getSuperclass() != null) {
			for (Field field : this.getField(clazz.getSuperclass())) {
				fieldList.add(field);
			}
		}
		Field[] fields = new Field[fieldList.size()];
		fieldList.toArray(fields);
		return fields;
	}

}
