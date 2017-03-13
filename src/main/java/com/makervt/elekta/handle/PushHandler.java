package com.makervt.elekta.handle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.makervt.core.component.push.UmengComponent;
import com.makervt.core.component.push.model.UmengPush;
import com.makervt.core.util.SpringContextHolder;
import com.makervt.elekta.entity.PushLog;
import com.makervt.elekta.service.AppService;
import com.makervt.elekta.service.PushLogService;

public class PushHandler implements Runnable {

	private static String DEVICE_TYPE_IOS = "IOS";
	private static String DEVICE_TYPE_ANDROID = "ANDROID";
	private UmengComponent umengCom = new UmengComponent();
	private ExecutorService pool = Executors.newCachedThreadPool();
	/**
	 * pushservice
	 */
	private static PushLogService pushService = (PushLogService) SpringContextHolder.getBean(PushLogService.class);

	@Override
	public void run() {
		try {
			final UmengPush umengPush = (UmengPush) AppService.pushQueues.take();

			if (null != umengPush) {

				Thread pushThread = new Thread() {
					@Override
					public void run() {
						try {
							if (StringUtils.equalsIgnoreCase(umengPush.getPushType(),
									UmengPush.PushType.UNI.getType())) {							
									// TODO 單播
									if (StringUtils.equalsIgnoreCase(DEVICE_TYPE_ANDROID, umengPush.getDeviceType()))
	
										umengCom.sendAndroidUnicast(umengPush.getDeviceToken(), umengPush.getTicker(),
												umengPush.getTitle(), umengPush.getText(), umengPush.getExtraFields());
	
									if (StringUtils.equalsIgnoreCase(DEVICE_TYPE_IOS, umengPush.getDeviceType()))
	
										umengCom.sendIOSUnicast(umengPush.getDeviceToken(), umengPush.getText(), umengPush.getExtraFields());
							

							} else if (StringUtils.equalsIgnoreCase(umengPush.getPushType(),
									UmengPush.PushType.BROAD.getType())) {
								// TODO 廣播
								umengCom.sendAndroidBroadcast(umengPush.getTicker(), umengPush.getTitle(),
											umengPush.getText(), umengPush.getExtraFields());
								umengCom.sendIOSBroadcast(umengPush.getText(), umengPush.getExtraFields());
							} 

							PushLog pushLog = new PushLog();
							pushLog.setPushLogContent(JSON.toJSONString(umengPush.getExtraFields())+"------ content:"+umengPush.getText());
							pushLog.setPushLogType(umengPush.getPushType());
							pushLog.setPushLogTitle(umengPush.getTitle());
							pushLog.setPushLogUser(umengPush.getUser());
							pushLog.setPushLogTicker(umengPush.getTicker());
							pushLog.setPushLogType(umengPush.getPushType());
							pushService.create(pushLog);
						} catch (Exception e) {

						}
					}
				};
				pushThread.setName("SmsThread:" + pushThread.getId());
				pool.execute(pushThread);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			new PushHandler().run();
		}

	}

	public static void addPushQueue(UmengPush umengPush) {
		AppService.pushQueues.offer(umengPush);
	}

}
