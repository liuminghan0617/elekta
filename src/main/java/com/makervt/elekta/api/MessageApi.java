package com.makervt.elekta.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.makervt.core.domain.Page;
import com.makervt.core.domain.ResponseMessage;
import com.makervt.core.web.BaseController;
import com.makervt.elekta.domain.Healing;
import com.makervt.elekta.entity.AppVersion;
import com.makervt.elekta.entity.Message;
import com.makervt.elekta.service.HealingService;
import com.makervt.elekta.service.MessageService;

@Controller
@RequestMapping(value = "message")
public class MessageApi extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(MessageApi.class);

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private HealingService healingService;

	@RequestMapping(value = "list.do")
	public @ResponseBody ResponseMessage messageList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Message message = this.getJsonJavaByInterceptor(request, Message.class);
		
		if (StringUtils.isEmpty(message.getUserId()))
			return ResponseMessage.createErrorResponse("1101");
		
		if (!this.isVerfityUser(request, message.getUserId()))
			return ResponseMessage.createErrorResponse("1106");
		
		ResponseMessage msg = ResponseMessage.createSuccessResponse("0000");
		Page<Message> messageList = messageService.queryMessageList(message);
		msg.setData("messages", messageList);
		return msg;
	}
	
	@RequestMapping(value = "count.do")
	public @ResponseBody ResponseMessage countMessage(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Message message = this.getJsonJavaByInterceptor(request, Message.class);
		
		if (StringUtils.isEmpty(message.getUserId()))
			return ResponseMessage.createErrorResponse("1101");
		
		if (!this.isVerfityUser(request, message.getUserId()))
			return ResponseMessage.createErrorResponse("1106");
		
		ResponseMessage msg = ResponseMessage.createSuccessResponse("0000");
		 String count = messageService.countMessage(message);
		msg.setData("msgCount", count);
		return msg;
	}
	
	@RequestMapping(value = "healing.do")
	public @ResponseBody ResponseMessage healing(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Healing healing = this.getJsonJavaByInterceptor(request, Healing.class);
		
		if (StringUtils.isEmpty(healing.getUserId()))
			return ResponseMessage.createErrorResponse("1101");
		
		if (!this.isVerfityUser(request, healing.getUserId()))
			return ResponseMessage.createErrorResponse("1106");
		
		ResponseMessage msg = ResponseMessage.createSuccessResponse("0000");
		healing=healingService.queryHealing(healing);
		msg.setData("healing", healing);
		return msg;
	}
	
	@RequestMapping(value = "getAppVersion.do")
	public @ResponseBody ResponseMessage getAppVersion(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String app_type = request.getParameter("app_type");
//		AppVersion appVersion = this.getJsonJavaByInterceptor(request, AppVersion.class);
		logger.info("app_type:<{}>", app_type);
		if (StringUtils.isEmpty(app_type))
			return ResponseMessage.createErrorResponse("1101");
		
		AppVersion appVersion = new AppVersion();
		appVersion.setApp_type(Integer.valueOf(app_type));
		ResponseMessage msg = ResponseMessage.createSuccessResponse("0000");
		AppVersion appVersion_DB = messageService.getAppVersion(appVersion);
		msg.setData("appVersion", appVersion_DB);
		return msg;
	}
	
	@RequestMapping(value = "addAppVersion.do")
	public @ResponseBody ResponseMessage addAppVersion(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String app_type = request.getParameter("app_type");
		String app_url = request.getParameter("app_url");
		String version_code = request.getParameter("version_code");
		String force_update_flag = request.getParameter("force_update_flag");
		logger.info("app_type:<{}> app_url:<{}> version_code:<{}> force_update_flag:<{}>", app_type, app_url, version_code, force_update_flag);
		if (StringUtils.isEmpty(app_type) || StringUtils.isEmpty(app_url) || StringUtils.isEmpty(version_code))
			return ResponseMessage.createErrorResponse("1101");
		
		AppVersion appVersion = new AppVersion();
		appVersion.setApp_type(Integer.valueOf(app_type));
		appVersion.setApp_url(app_url);
		appVersion.setVersion_code(version_code);
		try {
			int force_update_flag_int = Integer.parseInt(force_update_flag);
			if (force_update_flag_int < 0 && force_update_flag_int > 1) {
				force_update_flag_int = 0;
			}
			appVersion.setForce_update_flag(force_update_flag_int);
		} catch (Exception e) {
			appVersion.setForce_update_flag(0);
		}
		
		ResponseMessage msg = ResponseMessage.createSuccessResponse("0000");
		messageService.addAppVersion(appVersion);
		
		AppVersion appVersion_DB = messageService.getAppVersion(appVersion);
		msg.setData("appVersion", appVersion_DB);
		return msg;
	}
}
