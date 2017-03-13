package com.makervt.elekta.task;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;
import com.makervt.core.component.push.model.UmengPush;
import com.makervt.elekta.entity.User;
import com.makervt.elekta.entity.UserExam;
import com.makervt.elekta.handle.PushHandler;
import com.makervt.elekta.service.UserExamService;
import com.makervt.elekta.service.UserService;

@Component
public class ExamCheckTask {

	@Autowired
	private UserExamService userExamService;

	@Autowired
	private UserService userService;

	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 定时检测问卷是否过期，【即将失效】您的《XXXXXX》明日就要失效了，将会无法作答，请您尽快提交结果。
	 * 【即将失效】你的《XXXXXX》今日即将失效，将会无法作答，请您尽快提交结果。
	 */
	//@Scheduled(cron = "0/5 * * * * ?")
	// 每5秒执行一次
	@Scheduled(cron = "0 15 10 ? * *")
	public void handleCheck() {
		logger.debug("定时检测问卷是否过期");
		UserExam userExam = new UserExam();
		List<UserExam> userExamList = userExamService.selectExpire(userExam);
		for (UserExam ue : userExamList) {
			if (StringUtils.equalsIgnoreCase(ue.getUserExamStatus(), "0")) {
				User user = userService.selectByPK(ue.getUserId());
				pushMessage(user.getUserDeviceType(), user.getUserDeviceToken(), UmengPush.PushType.UNI.getType(),
						user.getUserId(), "【即将失效】你的《" + ue.getUserExamTitle() + "》问卷今日即将失效，将会无法作答，请您尽快提交结果。",
						"【即将失效】你的《" + ue.getUserExamTitle() + "》问卷今日即将失效，将会无法作答，请您尽快提交结果。", "3",
						"【即将失效】你的《" + ue.getUserExamTitle() + "》问卷今日即将失效，将会无法作答，请您尽快提交结果。");
			} else if (StringUtils.equalsIgnoreCase(ue.getUserExamStatus(), "1")) {
				User user = userService.selectByPK(ue.getUserId());
				pushMessage(user.getUserDeviceType(), user.getUserDeviceToken(), UmengPush.PushType.UNI.getType(),
						user.getUserId(), "【即将失效】您的《" + ue.getUserExamTitle() + "》明日就要失效了，将会无法作答，请您尽快提交结果。",
						"【即将失效】您的《" + ue.getUserExamTitle() + "》明日就要失效了，将会无法作答，请您尽快提交结果。", "3",
						"【即将失效】您的《" + ue.getUserExamTitle() + "》明日就要失效了，将会无法作答，请您尽快提交结果。");
			}
		}
	}

	private static void pushMessage(String deviceType, String deviceToken, String pushType, String user, String title,
			String ticker, String messageType, String messageContent) {
		UmengPush umengPush = new UmengPush();
		umengPush.setDeviceToken(deviceToken);
		umengPush.setDeviceType(deviceType);
		umengPush.setPushType(pushType);
		umengPush.setUser(user);
		umengPush.setTitle(title);
		umengPush.setTicker(ticker);
		HashMap map = Maps.newHashMap();
		map.put("type", messageType);
		umengPush.setExtraFields(map);
		umengPush.setText(messageContent);
		PushHandler.addPushQueue(umengPush);
	}
}
