package com.makervt.core.domain;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.alibaba.fastjson.annotation.JSONType;

/**
 * 过滤JSON时的引用范围，{@link #ignores()} 优先级高于{@link #includeSimpleProperty()}
 * ，同一对象中只有1个属性有效。
 * 
 * @since JDK1.6
 * @version 1.0.0
 * @author 陈彦吉 2013-5-29 下午4:57:18
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface JSONFilter {

	/**
	 * 动态过滤节点、属性名（优先级高于simpleProperty），其中支持对动态值的获取。
	 * <p>
	 * example:排除JSON对象中id和动态属性par，下例中显示结果只包含name，如果使用了动态参数进行排除时，需对动态属性本身进行排除。
	 * 
	 * <pre>
	 * &#064;JSONFilter(ignores = { &quot;par&quot;, &quot;id&quot;, &quot;${par}&quot; })
	 * public class test {
	 * 	private String[] par;
	 * 	private String id;
	 * 	private String name;
	 * 	private String age;
	 * 
	 * 	public String[] getPar() {
	 * 		return new String[] { &quot;age&quot; };
	 * 	}
	 * 
	 * 	public void setPar(String[] par) {
	 * 		this.par = par;
	 * 	}
	 * 
	 * 	public String getId() {
	 * 		return id;
	 * 	}
	 * 
	 * 	public void setId(String id) {
	 * 		this.id = id;
	 * 	}
	 * 
	 * 	public String getName() {
	 * 		return name;
	 * 	}
	 * 
	 * 	public void setName(String name) {
	 * 		this.name = name;
	 * 	}
	 * 
	 * 	public String getAge() {
	 * 		return age;
	 * 	}
	 * 
	 * 	public void setAge(String age) {
	 * 		this.age = age;
	 * 	}
	 * }
	 * </pre>
	 * 
	 * @author 陈彦吉 2013-5-30 下午1:45:37
	 * @see {@link Page#toJsonString(Object)}
	 */
	public abstract String[] ignores() default {};

	/**
	 * 动态包含数据对象属性，当使用动态包含时，需要增加{@link JSONType#ignores()}来完成对动态属性的排除
	 * <p>
	 * example:例子JSON只包含age属性
	 * 
	 * <pre>
	 * &#064;JSONType(ignores = &quot;par&quot;)
	 * &#064;JSONFilter(includeSimpleProperty = { &quot;${par}&quot; })
	 * public class test {
	 * 	private String[] par;
	 * 	private String id;
	 * 	private String name;
	 * 	private String age;
	 * 
	 * 	public String[] getPar() {
	 * 		return new String[] { &quot;age&quot; };
	 * 	}
	 * 
	 * 	public void setPar(String[] par) {
	 * 		this.par = par;
	 * 	}
	 * 
	 * 	public String getId() {
	 * 		return id;
	 * 	}
	 * 
	 * 	public void setId(String id) {
	 * 		this.id = id;
	 * 	}
	 * 
	 * 	public String getName() {
	 * 		return name;
	 * 	}
	 * 
	 * 	public void setName(String name) {
	 * 		this.name = name;
	 * 	}
	 * 
	 * 	public String getAge() {
	 * 		return age;
	 * 	}
	 * 
	 * 	public void setAge(String age) {
	 * 		this.age = age;
	 * 	}
	 * }
	 * </pre>
	 * 
	 * @author 陈彦吉 2013-5-30 下午1:46:03
	 * @see {@link Page#toJsonString(Object)}
	 */
	public abstract String[] includeSimpleProperty() default {};
}
