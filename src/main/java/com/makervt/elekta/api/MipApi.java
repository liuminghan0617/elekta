package com.makervt.elekta.api;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.makervt.core.component.push.model.UmengPush;
import com.makervt.core.domain.ResponseMessage;
import com.makervt.core.web.BaseController;
import com.makervt.elekta.entity.Attention;
import com.makervt.elekta.entity.Doctor;
import com.makervt.elekta.entity.DoctorPraise;
import com.makervt.elekta.entity.Exam;
import com.makervt.elekta.entity.Holiday;
import com.makervt.elekta.entity.Info;
import com.makervt.elekta.entity.Message;
import com.makervt.elekta.entity.User;
import com.makervt.elekta.entity.UserExam;
import com.makervt.elekta.handle.PushHandler;
import com.makervt.elekta.service.AttentionPicService;
import com.makervt.elekta.service.AttentionService;
import com.makervt.elekta.service.DoctorPraiseService;
import com.makervt.elekta.service.DoctorService;
import com.makervt.elekta.service.ExamService;
import com.makervt.elekta.service.InfoService;
import com.makervt.elekta.service.MipService;
import com.makervt.elekta.service.UserService;

@Controller
@RequestMapping(value = "mip")
public class MipApi extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(MipApi.class);

	@Autowired
	private MipService mipService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "docotor.do")
	public @ResponseBody ResponseMessage docotor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseMessage msg = ResponseMessage.createSuccessResponse("0000");
		String json = ServletRequestUtils.getStringParameter(request, "jsonData");
		if (StringUtils.isEmpty(json))
			return ResponseMessage.createErrorResponse("9996");
		Doctor doctor = JSON.parseObject(json, Doctor.class);
		ResponseMessage fileMsg = mipService.addDoctor(request, doctor);
		if (!StringUtils.equalsIgnoreCase(ResponseMessage.PromptType.SUCCESS.getType(), fileMsg.getType())) {
			return fileMsg;
		}
		return msg;
	}

	@RequestMapping(value = "attention.do")
	public @ResponseBody ResponseMessage attention(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseMessage msg = ResponseMessage.createSuccessResponse("0000");
		String json = ServletRequestUtils.getStringParameter(request, "jsonData");
		if (StringUtils.isEmpty(json))
			return ResponseMessage.createErrorResponse("9996");
		Attention attention = JSON.parseObject(json, Attention.class);
		ResponseMessage fileMsg = mipService.addAttention(request, attention);
		if (!StringUtils.equalsIgnoreCase(ResponseMessage.PromptType.SUCCESS.getType(), fileMsg.getType())) {
			return fileMsg;
		}
		return msg;
	}

	@RequestMapping(value = "exam.do")
	public @ResponseBody ResponseMessage exam(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseMessage msg = ResponseMessage.createSuccessResponse("0000");
		String json = ServletRequestUtils.getStringParameter(request, "jsonData");
		logger.info("json:<{}>", json);
		if (StringUtils.isEmpty(json))
			return ResponseMessage.createErrorResponse("9996");
		Exam exam = JSON.parseObject(json, Exam.class);
		logger.info("exam:<{}>", JSONObject.toJSON(exam).toString());
		ResponseMessage fileMsg = mipService.addExam(request, exam);
		logger.info("fileMsg:<{}>", JSONObject.toJSON(fileMsg).toString());
		if (!StringUtils.equalsIgnoreCase(ResponseMessage.PromptType.SUCCESS.getType(), fileMsg.getType())) {
			return fileMsg;
		}
		return msg;
	}

	@RequestMapping(value = "sendExam.do")
	public @ResponseBody ResponseMessage sendExam(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseMessage msg = ResponseMessage.createSuccessResponse("0000");
		String json = this.getJson(request);
		logger.info("method:<sendExam> param:<{}>", json);
		JSONObject quesJson = JSON.parseObject(json);
//		logger.info("method:<sendExam> JSONObject:<{}>", quesJson);
		List<UserExam> userExamList = JSON.parseArray(quesJson.getString("sendExam"), UserExam.class);
//		logger.info("method:<sendExam> userExamList:<{}>", quesJson.getString("sendExam"));
		msg = mipService.sendExam(userExamList);
		return msg;
	}

	@RequestMapping(value = "sendFeedBack.do")
	public @ResponseBody ResponseMessage sendFeedBack(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseMessage msg = ResponseMessage.createSuccessResponse("0000");
		String json = this.getJson(request);
		JSONObject quesJson = JSON.parseObject(json);
		List<UserExam> userExamList = JSON.parseArray(quesJson.getString("sendExam"), UserExam.class);
		msg = mipService.sendFeedBack(userExamList);
		return msg;
	}

	@RequestMapping(value = "info.do")
	public @ResponseBody ResponseMessage info(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseMessage msg = ResponseMessage.createSuccessResponse("0000");
		String json = ServletRequestUtils.getStringParameter(request, "jsonData");
		if (StringUtils.isEmpty(json))
			return ResponseMessage.createErrorResponse("9996");
		Info info = JSON.parseObject(json, Info.class);
		ResponseMessage fileMsg = mipService.addInfo(request, info);
		if (!StringUtils.equalsIgnoreCase(ResponseMessage.PromptType.SUCCESS.getType(), fileMsg.getType())) {
			return fileMsg;
		}
		return msg;
	}

	@RequestMapping(value = "holiday.do")
	public @ResponseBody ResponseMessage holiday(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String jsonStr = this.getJson(request);
		JSONObject jsonObj = JSON.parseObject(jsonStr);
		Object obj = jsonObj.get("holiday");
		List<Holiday> holidayList = JSON.parseArray(JSON.toJSONString(obj), Holiday.class);
		ResponseMessage msg = mipService.addHoliday(holidayList);
		return msg;
	}

	@RequestMapping(value = "message.do")
	public @ResponseBody ResponseMessage message(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String jsonStr = this.getJson(request);
		JSONObject jsonObj = JSON.parseObject(jsonStr);
		Object obj = jsonObj.get("messages");
		List<Message> messageList = JSON.parseArray(JSON.toJSONString(obj), Message.class);
		ResponseMessage msg = mipService.addMessage(messageList);
		return msg;
	}

	@RequestMapping(value = "push.do")
	public @ResponseBody ResponseMessage push(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String jsonStr = this.getJson(request);
		logger.info("調用push:<{}>", jsonStr);
		UmengPush umengPush = JSON.parseObject(jsonStr, UmengPush.class);

		Map<String, String> extraField = umengPush.getExtraFields();
		logger.info("extraField:<{}>", JSONObject.toJSON(extraField).toString());
		if (extraField == null || null == extraField.get("type")) {
			extraField = Maps.newHashMap();
			extraField.put("type", "1");
			umengPush.setExtraFields(extraField);
		}

		if (StringUtils.equalsIgnoreCase(umengPush.getPushType(), UmengPush.PushType.BROAD.getType()))
			PushHandler.addPushQueue(umengPush);
		else {
			JSONObject jsonObj = JSON.parseObject(jsonStr);
			Object obj = jsonObj.get("users");
			List<String> userList = JSON.parseArray(JSON.toJSONString(obj), String.class);
			logger.info("userList:<{}>", JSONObject.toJSON(userList).toString());
			if (userList != null && userList.size() > 0) {
				for (String user : userList) {
					User pushUser = userService.selectByPK(user);
					if (pushUser != null) {
						umengPush.setUser(user);
						umengPush.setDeviceToken(pushUser.getUserDeviceToken());
						umengPush.setDeviceType(pushUser.getUserDeviceType());
						PushHandler.addPushQueue(umengPush);
					} else {
						logger.info("DB user:<{}> is null.", user);
					}
				}
			}
		}
		ResponseMessage msg = ResponseMessage.createSuccessResponse("0000");
		return msg;
	}
}
