package com.makervt.elekta.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.annotation.JSONType;
import com.makervt.core.domain.Page;

/**
 * mapping for user
 * meaning 用户信息
 * @author CodeGenerator
 */
 @JSONType(ignores = {"pageNo", "pageSize", "pageTotal","totalCount","userRegisterType","start","userLoginCount","userActivateDate","userCreateUser", "userCreateDate", "userUpdateUser", "userUpdateDate"})
public class User extends Page<User>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * mapping for user.User_id
	 * meaning 
	 */
	private String userId;

	/**
	 * mapping for user.User_Mr_No
	 * meaning 病历号
	 */
	private String userMrNo;

	/**
	 * mapping for user.User_mobile
	 * meaning 当前登陆的，手机号码
	 */
	private String userMobile;

	/**
	 * mapping for user.User_mobile_pool
	 * meaning 用户手机号码池，手机号多个以“,”分隔
	 */
	private String userMobilePool;

	/**
	 * mapping for user.User_device_token
	 * meaning 设备标识
	 */
	private String userDeviceToken;

	/**
	 * mapping for user.User_device_type
	 * meaning 用户设备类型（IOS、ANDROID）
	 */
	private String userDeviceType;

	/**
	 * mapping for user.User_ip
	 * meaning ip地址
	 */
	private String userIp;

	/**
	 * mapping for user.User_area
	 * meaning ip地址区域
	 */
	private String userArea;

	/**
	 * mapping for user.User_name
	 * meaning 用户姓名
	 */
	private String userName;

	/**
	 * mapping for user.user_photo_url
	 * meaning 用户头像访问地址
	 */
	private String userPhotoUrl;

	/**
	 * mapping for user.user_photo_directory
	 * meaning 用户头像存储地址
	 */
	private String userPhotoDirectory;

	/**
	 * mapping for user.User_mobile_sms_code
	 * meaning 手机短信验证码
	 */
	private String userMobileSmsCode;

	/**
	 * mapping for user.User_email
	 * meaning 电子邮件
	 */
	private String userEmail;

	/**
	 * mapping for user.User_type
	 * meaning 用户类型（0 管理员，1普通用户，默认为普通用户）
	 */
	private String userType;

	/**
	 * mapping for user.User_Register_type
	 * meaning 注册类型(qq/weixin/mobile/email等)
	 */
	private String userRegisterType;

	/**
	 * mapping for user.User_Register_date
	 * meaning 注册日期
	 */
	private String userRegisterDate;

	/**
	 * mapping for user.User_login_count
	 * meaning 登陆次数
	 */
	private String userLoginCount;

	/**
	 * mapping for user.User_activate_date
	 * meaning 激活日期
	 */
	private String userActivateDate;

	/**
	 * mapping for user.User_state
	 * meaning 用户状态
	 */
	private String userState;

	/**
	 * mapping for user.User_remark
	 * meaning 备注
	 */
	private String userRemark;

	/**
	 * mapping for user.User_hosp_id
	 * meaning 医院标识
	 */
	private String userHospId;

	/**
	 * mapping for user.User_hosp_name
	 * meaning 医院名称
	 */
	private String userHospName;
	

	/**
	 * mapping for user.userHospVerifyCode
	 * meaning 医院识别码
	 */
	private String userHospVerifyCode;

	/**
	 * mapping for user.User_create_user
	 * meaning 创建人
	 */
	private String userCreateUser;

	/**
	 * mapping for user.User_create_date
	 * meaning 创建时间
	 */
	private String userCreateDate;

	/**
	 * mapping for user.User_update_user
	 * meaning 更新人
	 */
	private String userUpdateUser;

	/**
	 * mapping for user.User_update_date
	 * meaning 更新时间
	 */
	private String userUpdateDate;

	/**
	 * get user.User_id
	 * @return 
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * set user.User_id
	 * @param 
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * get user.User_Mr_No
	 * @return 病历号
	 */
	public String getUserMrNo() {
		return this.userMrNo;
	}

	/**
	 * set user.User_Mr_No
	 * @param 病历号
	 */
	public void setUserMrNo(String userMrNo) {
		this.userMrNo = userMrNo;
	}

	/**
	 * get user.User_mobile
	 * @return 当前登陆的，手机号码
	 */
	public String getUserMobile() {
		return this.userMobile;
	}

	/**
	 * set user.User_mobile
	 * @param 当前登陆的，手机号码
	 */
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	/**
	 * get user.User_mobile_pool
	 * @return 用户手机号码池，手机号多个以“,”分隔
	 */
	public String getUserMobilePool() {
		return this.userMobilePool;
	}

	/**
	 * set user.User_mobile_pool
	 * @param 用户手机号码池，手机号多个以“,”分隔
	 */
	public void setUserMobilePool(String userMobilePool) {
		this.userMobilePool = userMobilePool;
	}

	/**
	 * get user.User_device_token
	 * @return 设备标识
	 */
	public String getUserDeviceToken() {
		return this.userDeviceToken;
	}

	/**
	 * set user.User_device_token
	 * @param 设备标识
	 */
	public void setUserDeviceToken(String userDeviceToken) {
		this.userDeviceToken = userDeviceToken;
	}

	/**
	 * get user.User_device_type
	 * @return 用户设备类型（IOS、ANDROID）
	 */
	public String getUserDeviceType() {
		return this.userDeviceType;
	}

	/**
	 * set user.User_device_type
	 * @param 用户设备类型（IOS、ANDROID）
	 */
	public void setUserDeviceType(String userDeviceType) {
		this.userDeviceType = userDeviceType;
	}

	/**
	 * get user.User_ip
	 * @return ip地址
	 */
	public String getUserIp() {
		return this.userIp;
	}

	/**
	 * set user.User_ip
	 * @param ip地址
	 */
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	/**
	 * get user.User_area
	 * @return ip地址区域
	 */
	public String getUserArea() {
		return this.userArea;
	}

	/**
	 * set user.User_area
	 * @param ip地址区域
	 */
	public void setUserArea(String userArea) {
		this.userArea = userArea;
	}

	/**
	 * get user.User_name
	 * @return 用户姓名
	 */
	public String getUserName() {
		return this.userName;
	}

	/**
	 * set user.User_name
	 * @param 用户姓名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * get user.user_photo_url
	 * @return 用户头像访问地址
	 */
	public String getUserPhotoUrl() {
		return this.userPhotoUrl;
	}

	/**
	 * set user.user_photo_url
	 * @param 用户头像访问地址
	 */
	public void setUserPhotoUrl(String userPhotoUrl) {
		this.userPhotoUrl = userPhotoUrl;
	}

	/**
	 * get user.user_photo_directory
	 * @return 用户头像存储地址
	 */
	public String getUserPhotoDirectory() {
		return this.userPhotoDirectory;
	}

	/**
	 * set user.user_photo_directory
	 * @param 用户头像存储地址
	 */
	public void setUserPhotoDirectory(String userPhotoDirectory) {
		this.userPhotoDirectory = userPhotoDirectory;
	}

	/**
	 * get user.User_mobile_sms_code
	 * @return 手机短信验证码
	 */
	public String getUserMobileSmsCode() {
		return this.userMobileSmsCode;
	}

	/**
	 * set user.User_mobile_sms_code
	 * @param 手机短信验证码
	 */
	public void setUserMobileSmsCode(String userMobileSmsCode) {
		this.userMobileSmsCode = userMobileSmsCode;
	}

	/**
	 * get user.User_email
	 * @return 电子邮件
	 */
	public String getUserEmail() {
		return this.userEmail;
	}

	/**
	 * set user.User_email
	 * @param 电子邮件
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * get user.User_type
	 * @return 用户类型（0 管理员，1普通用户，默认为普通用户）
	 */
	public String getUserType() {
		return this.userType;
	}

	/**
	 * set user.User_type
	 * @param 用户类型（0 管理员，1普通用户，默认为普通用户）
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * get user.User_Register_type
	 * @return 注册类型(qq/weixin/mobile/email等)
	 */
	public String getUserRegisterType() {
		return this.userRegisterType;
	}

	/**
	 * set user.User_Register_type
	 * @param 注册类型(qq/weixin/mobile/email等)
	 */
	public void setUserRegisterType(String userRegisterType) {
		this.userRegisterType = userRegisterType;
	}

	/**
	 * get user.User_Register_date
	 * @return 注册日期
	 */
	public String getUserRegisterDate() {
		return this.userRegisterDate;
	}

	/**
	 * set user.User_Register_date
	 * @param 注册日期
	 */
	public void setUserRegisterDate(String userRegisterDate) {
		this.userRegisterDate = userRegisterDate;
	}

	/**
	 * get user.User_login_count
	 * @return 登陆次数
	 */
	public String getUserLoginCount() {
		return this.userLoginCount;
	}

	/**
	 * set user.User_login_count
	 * @param 登陆次数
	 */
	public void setUserLoginCount(String userLoginCount) {
		this.userLoginCount = userLoginCount;
	}

	/**
	 * get user.User_activate_date
	 * @return 激活日期
	 */
	public String getUserActivateDate() {
		return this.userActivateDate;
	}

	/**
	 * set user.User_activate_date
	 * @param 激活日期
	 */
	public void setUserActivateDate(String userActivateDate) {
		this.userActivateDate = userActivateDate;
	}

	/**
	 * get user.User_state
	 * @return 用户状态
	 */
	public String getUserState() {
		return this.userState;
	}

	/**
	 * set user.User_state
	 * @param 用户状态
	 */
	public void setUserState(String userState) {
		this.userState = userState;
	}

	/**
	 * get user.User_remark
	 * @return 备注
	 */
	public String getUserRemark() {
		return this.userRemark;
	}

	/**
	 * set user.User_remark
	 * @param 备注
	 */
	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark;
	}

	/**
	 * get user.User_hosp_id
	 * @return 医院标识
	 */
	public String getUserHospId() {
		return this.userHospId;
	}

	/**
	 * set user.User_hosp_id
	 * @param 医院标识
	 */
	public void setUserHospId(String userHospId) {
		this.userHospId = userHospId;
	}

	/**
	 * get user.User_hosp_name
	 * @return 医院名称
	 */
	public String getUserHospName() {
		return this.userHospName;
	}

	/**
	 * set user.User_hosp_name
	 * @param 医院名称
	 */
	public void setUserHospName(String userHospName) {
		this.userHospName = userHospName;
	}

	/**
	 * get user.User_create_user
	 * @return 创建人
	 */
	public String getUserCreateUser() {
		return this.userCreateUser;
	}

	/**
	 * set user.User_create_user
	 * @param 创建人
	 */
	public void setUserCreateUser(String userCreateUser) {
		this.userCreateUser = userCreateUser;
	}

	/**
	 * get user.User_create_date
	 * @return 创建时间
	 */
	public String getUserCreateDate() {
		return this.userCreateDate;
	}

	/**
	 * set user.User_create_date
	 * @param 创建时间
	 */
	public void setUserCreateDate(String userCreateDate) {
		this.userCreateDate = userCreateDate;
	}

	/**
	 * get user.User_update_user
	 * @return 更新人
	 */
	public String getUserUpdateUser() {
		return this.userUpdateUser;
	}

	/**
	 * set user.User_update_user
	 * @param 更新人
	 */
	public void setUserUpdateUser(String userUpdateUser) {
		this.userUpdateUser = userUpdateUser;
	}

	/**
	 * get user.User_update_date
	 * @return 更新时间
	 */
	public String getUserUpdateDate() {
		return this.userUpdateDate;
	}
	

	public String getUserHospVerifyCode() {
		return userHospVerifyCode;
	}

	public void setUserHospVerifyCode(String userHospVerifyCode) {
		this.userHospVerifyCode = userHospVerifyCode;
	}

	/**
	 * set user.User_update_date
	 * @param 更新时间
	 */
	public void setUserUpdateDate(String userUpdateDate) {
		this.userUpdateDate = userUpdateDate;
	}

	public  Map<String,Object> returnMap()
	{
		 Map<String,Object> returnMap =new HashMap<String,Object>();
		 	returnMap.put("userId",this.userId);
		 	returnMap.put("userMrNo",this.userMrNo);
		 	returnMap.put("userMobile",this.userMobile);
		 	returnMap.put("userMobilePool",this.userMobilePool);
		 	returnMap.put("userDeviceToken",this.userDeviceToken);
		 	returnMap.put("userDeviceType",this.userDeviceType);
		 	returnMap.put("userIp",this.userIp);
		 	returnMap.put("userArea",this.userArea);
		 	returnMap.put("userName",this.userName);
		 	returnMap.put("userPhotoUrl",this.userPhotoUrl);
		 	returnMap.put("userPhotoDirectory",this.userPhotoDirectory);
		 	returnMap.put("userMobileSmsCode",this.userMobileSmsCode);
		 	returnMap.put("userEmail",this.userEmail);
		 	returnMap.put("userType",this.userType);
		 	returnMap.put("userRegisterType",this.userRegisterType);
		 	returnMap.put("userRegisterDate",this.userRegisterDate);
		 	returnMap.put("userLoginCount",this.userLoginCount);
		 	returnMap.put("userActivateDate",this.userActivateDate);
		 	returnMap.put("userState",this.userState);
		 	returnMap.put("userRemark",this.userRemark);
		 	returnMap.put("userHospId",this.userHospId);
		 	returnMap.put("userHospName",this.userHospName);
			returnMap.put("userHospVerifyCode",this.userHospVerifyCode);
		 	returnMap.put("userCreateUser",this.userCreateUser);
		 	returnMap.put("userCreateDate",this.userCreateDate);
		 	returnMap.put("userUpdateUser",this.userUpdateUser);
		 	returnMap.put("userUpdateDate",this.userUpdateDate);
		 return returnMap;
	}
}
