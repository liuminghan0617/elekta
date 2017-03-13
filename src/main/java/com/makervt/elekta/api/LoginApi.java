package com.makervt.elekta.api;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.makervt.core.domain.ResponseMessage;
import com.makervt.core.util.EncrypCoder;
import com.makervt.core.web.BaseController;
import com.makervt.elekta.entity.JbUser;
import com.makervt.elekta.entity.JoUser;
import com.makervt.elekta.entity.User;
import com.makervt.elekta.handle.IpAddrHandler;
import com.makervt.elekta.service.JbUserService;
import com.makervt.elekta.service.JoUserService;
import com.makervt.elekta.service.MipProviderService;
import com.makervt.elekta.service.UserService;

@Controller
public class LoginApi extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(LoginApi.class);

	@Autowired
	private UserService userService;

	@Autowired
	private JoUserService joUserService;

	@Autowired
	private JbUserService jbUserService;

	/**
	 * 登陆
	 * 
	 * @param user
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	@Transactional
	@RequestMapping(value = "login.do")
	public @ResponseBody ResponseMessage login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long begin = System.currentTimeMillis();
//		logger.info("method<login> step1");
		ResponseMessage responseMessage = ResponseMessage.createSuccessResponse("0000");
		User user = this.getJsonJavaByInterceptor(request, User.class);
		if (StringUtils.isEmpty(user.getUserMobile()))
			return ResponseMessage.createErrorResponse("1102");
		if (StringUtils.isEmpty(user.getUserMrNo()))
			return ResponseMessage.createErrorResponse("1103");

		User userCheck = new User();
		userCheck.setUserMrNo(user.getUserMrNo());
		userCheck.setUserMobile(user.getUserMobile());
//		logger.info("method<login> step2");
		// 暂时取消
		// userCheck.setUserMobilePool(user.getUserMobile());
		List<User> userList = userService.select(userCheck);
//		logger.info("method<login> step3 userList<{}>", (JSONObject.toJSON(userList).toString()));
		if (userList == null || userList.size() == 0) {
			User userMip = MipProviderService.vaildUserByMip(user);
//			logger.info("method<login> step41 userMip<{}>", (JSONObject.toJSON(userMip).toString()));
			if (null == userMip)
				return ResponseMessage.createErrorResponse("1124");

			if (StringUtils.isEmpty(userMip.getUserId()))
				return ResponseMessage.createErrorResponse("1124");

			User userExist = userService.selectByPK(userMip.getUserId());
			
			if (null == userExist) {
				User regUser = new User();

				regUser.setUserId(userMip.getUserId());
				regUser.setUserHospId(userMip.getUserHospId());
				regUser.setUserHospName(userMip.getUserHospName());
				regUser.setUserName(userMip.getUserName());
				regUser.setUserMrNo(user.getUserMrNo());

				regUser.setUserMobile(user.getUserMobile());
				regUser.setUserMobilePool(getSeparateStr("", user.getUserMobile()));

				if (StringUtils.isNotEmpty(user.getUserDeviceToken()))
					regUser.setUserDeviceToken(user.getUserDeviceToken());

				if (StringUtils.isNotEmpty(user.getUserDeviceType()))
					regUser.setUserDeviceType(user.getUserDeviceType());

				regUser.setUserRegisterType("mobile");
				regUser.setUserType("1");
				regUser.setUserState("0");
				regUser.setUserIp(request.getRemoteAddr());
				regUser.setUserMobileSmsCode(userMip.getUserMobileSmsCode());
//				logger.info("method<login> step421");
				userService.create(regUser);
//				logger.info("method<login> step422");
				userService.invalidVerifyCode(regUser);
//				logger.info("method<login> step423");
				// 创建bbs用户
				createBbsUser(regUser);
//				logger.info("method<login> step424");
				// 更新注册用户所在区域
				IpAddrHandler.updateArea(regUser);
//				logger.info("method<login> step425");
				responseMessage.setData("user", regUser);
//				logger.info("login cost:<{}>", (System.currentTimeMillis() - begin));
				return responseMessage;
			} else {
//				logger.info("method<login> step42 User<{}>", (JSONObject.toJSON(userExist).toString()));
//				logger.info("method<login> step431");
				// 用户信息与MIP不符合情况（以前规则，正常情况没什么用）
				User updateUser = new User();
				updateUser.setUserId(userMip.getUserId());
				updateUser.setUserHospId(userMip.getUserHospId());
				updateUser.setUserHospName(userMip.getUserHospName());
				updateUser.setUserName(userMip.getUserName());
				updateUser.setUserMobile(user.getUserMobile());
				updateUser.setUserMobilePool(getSeparateStr(userExist.getUserMobilePool(), user.getUserMobile()));
				updateUser.setUserDeviceToken(user.getUserDeviceToken());
				updateUser.setUserDeviceType(user.getUserDeviceType());
				updateUser.setUserState("0");
				updateUser.setUserMobileSmsCode(userMip.getUserMobileSmsCode());
				userService.modify(updateUser);
//				logger.info("method<login> step432");
				responseMessage.setData("user", updateUser);
//				logger.info("login cost:<{}>", (System.currentTimeMillis() - begin));
				return responseMessage;
			}
		} else {
			// 每次登陆需要进行验证码验证
			User userResult = userList.get(0);
//			logger.info("method<login> step51 User<{}>", (JSONObject.toJSON(userResult).toString()));
			User userMip = MipProviderService.vaildUserByMip(userResult);
//			logger.info("method<login> step52 User<{}>", (JSONObject.toJSON(userMip).toString()));
			if (null == userMip)
				return ResponseMessage.createErrorResponse("1124");

			if (StringUtils.isEmpty(userMip.getUserId()))
				return ResponseMessage.createErrorResponse("1124");
			userResult.setUserMobile(user.getUserMobile());
			userResult.setUserState("0");
			userResult.setUserHospId(userMip.getUserHospId());
			userResult.setUserHospName(userMip.getUserHospName());
			userResult.setUserName(userMip.getUserName());
			userResult.setUserDeviceToken(user.getUserDeviceToken());
			userResult.setUserDeviceType(user.getUserDeviceType());
			userResult.setUserMobileSmsCode(userMip.getUserMobileSmsCode());
			logger.info("method<login> step53 User<{}>", (JSONObject.toJSON(userResult).toString()));
			userService.modify(userResult);
//			logger.info("method<login> step54");
			userService.invalidVerifyCode(userResult);
//			logger.info("method<login> step55");
			responseMessage.setData("user", userResult);
			logger.info("login cost:<{}>", (System.currentTimeMillis() - begin));
			return responseMessage;
		}
		
	}

	/**
	 * 登陆
	 * 
	 * @param user
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	@Transactional
	@RequestMapping(value = "loginByOther.do")
	public @ResponseBody ResponseMessage loginByOther(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseMessage responseMessage = ResponseMessage.createSuccessResponse("0000");
		User user = this.getJsonJavaByInterceptor(request, User.class);
		if (StringUtils.isEmpty(user.getUserMrNo()))
			return ResponseMessage.createErrorResponse("1103");
		if (StringUtils.isEmpty(user.getUserHospVerifyCode()))
			return ResponseMessage.createErrorResponse("1131");

		User userMip = MipProviderService.vaildUserOtherByMip(user);
		if (null == userMip)
			return ResponseMessage.createErrorResponse("1124");

		User userExist = userService.selectByPK(userMip.getUserId());
		if (userExist == null) {
			User regUser = new User();
			regUser.setUserId(userMip.getUserId());
			regUser.setUserHospId(userMip.getUserHospId());
			regUser.setUserHospName(userMip.getUserHospName());
			regUser.setUserName(userMip.getUserName());
			regUser.setUserMrNo(userMip.getUserMrNo());
			regUser.setUserMobile(userMip.getUserMobile());
			regUser.setUserMobilePool(getSeparateStr("", userMip.getUserMobile()));

			if (StringUtils.isNotEmpty(user.getUserDeviceToken()))
				regUser.setUserDeviceToken(user.getUserDeviceToken());

			if (StringUtils.isNotEmpty(user.getUserDeviceType()))
				regUser.setUserDeviceType(user.getUserDeviceType());

			regUser.setUserRegisterType("mobile");
			regUser.setUserType("1");
			regUser.setUserState("1");
			regUser.setUserIp(request.getRemoteAddr());
			regUser.setUserLoginCount("1");
			userService.create(regUser);

			// 创建bbs用户
			createBbsUser(regUser);

			// 更新注册用户所在区域
			IpAddrHandler.updateArea(regUser);
			responseMessage.setToken(userService.generateToken(regUser));
			responseMessage.setData("user", regUser);
			return responseMessage;
		} else {
			User updateUser = new User();
			updateUser.setUserId(userMip.getUserId());
			updateUser.setUserHospId(userMip.getUserHospId());
			updateUser.setUserHospName(userMip.getUserHospName());
			updateUser.setUserName(userMip.getUserName());
			updateUser.setUserMobile(userMip.getUserMobile());
			updateUser.setUserMrNo(userMip.getUserMrNo());
			updateUser.setUserMobilePool(getSeparateStr("", userMip.getUserMobile()));
			updateUser.setUserState("1");
			updateUser.setUserLoginCount(String.valueOf(NumberUtils.toInt(updateUser.getUserLoginCount() + 1)));
			userService.modify(updateUser);
			responseMessage.setToken(userService.generateToken(updateUser));
			responseMessage.setData("user", updateUser);
			return responseMessage;
		}
	}

	private void createBbsUser(User regUser) throws Exception {
		// 添加论坛用户
		JoUser joUser = new JoUser();
		joUser.setUsername(regUser.getUserId());
		joUser.setRegisterIp(regUser.getUserIp());
		joUser.setPassword(EncrypCoder.encryptMD5Hex(regUser.getUserMrNo()));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Timestamp(System.currentTimeMillis());
		joUser.setEmail("");
		joUser.setRegisterTime(sdf.format(now));
		joUser.setLastLoginTime(sdf.format(now));
		joUser.setLoginCount("0");
		joUser.setActivation("1");
		joUserService.create(joUser);

		JbUser jbUser = new JbUser();
		jbUser.setGroupId("1");
		jbUser.setUsername(regUser.getUserId());
		jbUser.setUserId(joUser.getUserId());
		jbUser.setEmail("");
		jbUser.setRegisterTime(sdf.format(now));
		jbUser.setLastLoginTime(sdf.format(now));
		jbUser.setRegisterIp(regUser.getUserIp());
		jbUser.setAvatar("09.gif");
		jbUser.setIsAdmin("0");
		jbUser.setIsDisabled("0");
		jbUser.setMagicPacketSize("0");
		jbUser.setIsOfficial("0");
		jbUserService.create(jbUser);
	}

	private String getSeparateStr(String separateStr, String addValue) {
		List<String> separateList = new ArrayList<String>();
		if (StringUtils.isNotEmpty(separateStr)) {
			separateList = Arrays.asList(separateStr.split(","));
		}
		List<String> resultList = new ArrayList<String>(separateList);
		resultList.add(addValue);
		return StringUtils.join(resultList.toArray(new String[] {}), ",");
	}
}
