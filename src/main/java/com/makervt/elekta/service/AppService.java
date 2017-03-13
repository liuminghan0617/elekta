package com.makervt.elekta.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeoutException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.makervt.core.component.push.model.UmengPush;
import com.makervt.elekta.entity.User;
import com.makervt.elekta.handle.IpAddrHandler;
import com.makervt.elekta.handle.PushHandler;

@Component
public class AppService {

	public static  ExecutorService cachedThreadPool = Executors
			.newCachedThreadPool();
	private static Logger logger = LoggerFactory.getLogger(AppService.class);


	/**
	 * 推送队列
	 */
	public static BlockingQueue<UmengPush> pushQueues;
	
	/**
	 * ip地址处理队列
	 */
	public static BlockingQueue<User> ipAreaQueues;
	
	
	

	@PostConstruct
	public static void init() {
		pushQueues= new LinkedBlockingDeque<UmengPush>();
		ipAreaQueues=new LinkedBlockingDeque<User>();
		
		logger.debug("=======================启动相关队列================================");
		PushHandler pushHandle=new PushHandler();
		IpAddrHandler ipAddrHandler=new IpAddrHandler();
		cachedThreadPool.execute(pushHandle);
		cachedThreadPool.execute(pushHandle);
	}

	@PreDestroy
	public void dostory() {
		ipAreaQueues.clear();
		pushQueues.clear();
	}
	
}