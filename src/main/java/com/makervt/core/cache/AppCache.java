package com.makervt.core.cache;

import java.util.Map;
import org.springframework.stereotype.Service;
import com.makervt.core.util.PropertyUtils;

/**
 * 应用缓存类，使用静态对象方式对部分常用参数进行内存缓存。
 * <p>
 * {@link #errorInfoConfig}异常错误代码缓存对象，当服务启动时从数据库加载异常代码及消息。
 * 
 * @since JDK1.6
 * @version 1.0.0
 * @author core 2013-10-17 下午6:09:42
 */
@Service
public class AppCache {



	/**
	 * 初始化ErrorCode配置
	 */
	public static Map<String, String> errorInfoConfig = null;

	/**
	 * 初始化prompt配置
	 */
	public static Map<String, String> promptInfoConfig = null;

	

	/**
	 * 初始化服务配置
	 */
	public static Map<String, String> serviceConfig = null;
	
	static{
		init();
	}
	
	
	public static void init() {
		errorInfoConfig = new PropertyUtils("error.properties").toHashMap();
		promptInfoConfig = new PropertyUtils("prompt.properties").toHashMap();
		serviceConfig = new PropertyUtils("service.properties").toHashMap();
	}

	/**
	 * 清理代码缓存
	 * 
	 * @version 1.0.0
	 * @author 陈彦吉 2013-10-25 下午3:07:22
	 * @see
	 */
	public void clear() {
		errorInfoConfig.clear();
		promptInfoConfig.clear();
		serviceConfig.clear();
	}

	/**
	 * 重新加载代码缓存
	 * 
	 * @version 1.0.0
	 * @author 陈彦吉 2013-10-25 下午3:08:32
	 * @see
	 */
	public void reLoad() {
		clear();
		init();
	}

}
