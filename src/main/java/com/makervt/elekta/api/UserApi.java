package com.makervt.elekta.api;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.makervt.core.domain.ResponseMessage;
import com.makervt.core.web.BaseController;
import com.makervt.elekta.entity.User;
import com.makervt.elekta.service.MipProviderService;
import com.makervt.elekta.service.UserService;

@Controller
@RequestMapping(value = "user")
public class UserApi extends BaseController {
	@Autowired
	private UserService userService;

	/**
	 * 验证手机
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@Transactional
	@RequestMapping(value = "validSms.do")
	public @ResponseBody ResponseMessage validSms(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		User user = this.getJsonJavaByInterceptor(request, User.class);

		if (StringUtils.isEmpty(user.getUserId()))
			return ResponseMessage.createErrorResponse("1101");

		User userQuery = new User();
		userQuery = userService.selectByPK(user.getUserId());
		if (userQuery == null)
			return ResponseMessage.createErrorResponse("1106");
		if (!StringUtils.equalsIgnoreCase(userQuery.getUserMobileSmsCode(), user.getUserMobileSmsCode())||StringUtils.isEmpty( user.getUserMobileSmsCode()))
			return ResponseMessage.createErrorResponse("1105");

		if (!StringUtils.equalsIgnoreCase("0", userQuery.getUserState()))
			return ResponseMessage.createErrorResponse("1107");

		ResponseMessage responseMsg = ResponseMessage.createSuccessResponse("0000");
		userQuery.setUserState("1");
		userQuery.setUserLoginCount(String.valueOf(NumberUtils.toInt(userQuery.getUserLoginCount()+1)));
		userService.modify(userQuery);
		responseMsg.setToken(userService.generateToken(userQuery));
		responseMsg.setData("user", userQuery);
		return responseMsg;
	}

	/**
	 * 发送短信验证码
	 * 
	 * @param user
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	@Transactional
	@RequestMapping(value = "sendVerifyCode.do")
	public @ResponseBody ResponseMessage sendVerifyCode(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		User user = this.getJsonJavaByInterceptor(request, User.class);
		if (StringUtils.isEmpty(user.getUserId()))
			return ResponseMessage.createErrorResponse("1106");

		user = userService.selectByPK(user.getUserId());
		if (user == null)
			return ResponseMessage.createErrorResponse("1106");

		User userMip = MipProviderService.vaildUserByMip(user);

		if (null == userMip)
			return ResponseMessage.createErrorResponse("1124");

		if (StringUtils.isEmpty(userMip.getUserId()))
			return ResponseMessage.createErrorResponse("1124");

		// 更新用户手机验证码
		User userUpdate = new User();
		userUpdate.setUserMobile(user.getUserMobile());
		userUpdate.setUserId(user.getUserId());
		userUpdate.setUserMobileSmsCode(userMip.getUserMobileSmsCode());
		userService.modify(userUpdate);
		userService.invalidVerifyCode(userUpdate);
		ResponseMessage responseMsg = ResponseMessage.createSuccessResponse("0000");
		return responseMsg;
	}

}
