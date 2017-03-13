package com.makervt.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;

/**
 * 以静态变量保存Spring ApplicationContext, 可在任何代码任何地方任何时候中取出ApplicaitonContext.
 * 
 * @since JDK1.6
 * @version 1.0.0
 * @author core 2013-10-18 上午11:03:04
 * @see ApplicationContextAware
 * @see DisposableBean
 */
@Repository
@SuppressWarnings("unchecked")
public class SpringContextHolder implements ApplicationContextAware, DisposableBean {

	private static ApplicationContext applicationContext = null;

	private static Logger logger = LoggerFactory.getLogger(SpringContextHolder.class);

	/**
	 * 取得存储在静态变量中的ApplicationContext.
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-18 下午2:07:28
	 * @see #assertContextInjected()
	 * @return {@link ApplicationContext}
	 */
	public static ApplicationContext getApplicationContext() {
		assertContextInjected();
		return applicationContext;
	}

	/**
	 * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-18 下午2:08:23
	 * @see #assertContextInjected()
	 * @param name
	 *            bean属性ID
	 * @return
	 */
	public static <T> T getBean(String name) {
		assertContextInjected();
		try {
			return (T) applicationContext.getBean(name);
		} catch (Exception e) {
			logger.error("获取Bean失败", e);
			return null;
		}
	}

	/**
	 * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型,如获取失败，线程等待，直到获取成功
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-18 下午2:11:09
	 * @see #ensureContext()
	 * @param name
	 *            bean属性ID
	 * @return
	 */
	public static <T> T getBeanAwait(String name) {
		ensureContext();
		return (T) getBean(name);
	}

	/**
	 * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-18 下午2:12:31
	 * @see #assertContextInjected()
	 * @param requiredType
	 *            bean对象class
	 * @return
	 */
	public static <T> T getBean(Class<T> requiredType) {
		assertContextInjected();
		try {
			return applicationContext.getBean(requiredType);
		} catch (Exception e) {
			logger.error("获取Bean失败", e);
			return null;
		}
	}

	/**
	 * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.如获取失败，线程等待，直到获取成功
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-18 下午2:13:39
	 * @see #ensureContext()
	 * @param requiredType
	 *            bean对象class
	 * @return
	 */
	public static <T> T getBeanAwait(Class<T> requiredType) {
		ensureContext();
		return getBean(requiredType);
	}

	/**
	 * 清除SpringContextHolder中的ApplicationContext为Null.
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-18 下午2:14:09
	 */
	public static void clear() {
		logger.debug("清除SpringContextHolder中的ApplicationContext:" + applicationContext);
		applicationContext = null;
	}

	/**
	 * 实现ApplicationContextAware接口, 注入Context到静态变量中.
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		logger.debug("注入ApplicationContext到SpringContextHolder:" + applicationContext);

		if (SpringContextHolder.applicationContext != null) {
			logger.warn("SpringContextHolder中的ApplicationContext被覆盖, 原有ApplicationContext为:" + SpringContextHolder.applicationContext);
		}

		SpringContextHolder.applicationContext = applicationContext; // NOSONAR

	}

	/**
	 * 实现DisposableBean接口, 在Context关闭时清理静态变量.
	 */
	@Override
	public void destroy() throws Exception {
		SpringContextHolder.clear();
	}

	/**
	 * 检查ApplicationContext不为空.
	 */
	private static void assertContextInjected() {
		if (applicationContext == null) {
			throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义SpringContextHolder");
		}
	}

	private static void ensureContext() {
		while (true) {
			if (applicationContext != null)
				break;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}

}
