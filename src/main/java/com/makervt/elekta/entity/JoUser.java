package com.makervt.elekta.entity;

import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.annotation.JSONType;
import com.makervt.core.domain.Page;

/**
 * mapping for jo_user
 * meaning 用户表
 * @author CodeGenerator
 */
 @JSONType(ignores = {"pageNo", "pageSize", "pageTotal","totalCount","start"})
public class JoUser extends Page<JoUser>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * mapping for jo_user.user_id
	 * meaning 用户ID
	 */
	private String userId;

	/**
	 * mapping for jo_user.username
	 * meaning 用户名
	 */
	private String username;

	/**
	 * mapping for jo_user.email
	 * meaning 电子邮箱
	 */
	private String email;

	/**
	 * mapping for jo_user.password
	 * meaning 密码
	 */
	private String password;

	/**
	 * mapping for jo_user.register_time
	 * meaning 注册时间
	 */
	private String registerTime;

	/**
	 * mapping for jo_user.register_ip
	 * meaning 注册IP
	 */
	private String registerIp;

	/**
	 * mapping for jo_user.last_login_time
	 * meaning 最后登录时间
	 */
	private String lastLoginTime;

	/**
	 * mapping for jo_user.last_login_ip
	 * meaning 最后登录IP
	 */
	private String lastLoginIp;

	/**
	 * mapping for jo_user.login_count
	 * meaning 登录次数
	 */
	private String loginCount;

	/**
	 * mapping for jo_user.reset_key
	 * meaning 重置密码KEY
	 */
	private String resetKey;

	/**
	 * mapping for jo_user.reset_pwd
	 * meaning 重置密码VALUE
	 */
	private String resetPwd;

	/**
	 * mapping for jo_user.activation
	 * meaning 激活状态
	 */
	private String activation;

	/**
	 * mapping for jo_user.activation_code
	 * meaning 激活码
	 */
	private String activationCode;

	/**
	 * mapping for jo_user.error_time
	 * meaning 登录错误时间
	 */
	private String errorTime;

	/**
	 * mapping for jo_user.error_count
	 * meaning 登录错误次数
	 */
	private String errorCount;

	/**
	 * mapping for jo_user.error_ip
	 * meaning 登录错误IP
	 */
	private String errorIp;

	/**
	 * get jo_user.user_id
	 * @return 用户ID
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * set jo_user.user_id
	 * @param 用户ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * get jo_user.username
	 * @return 用户名
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * set jo_user.username
	 * @param 用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * get jo_user.email
	 * @return 电子邮箱
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * set jo_user.email
	 * @param 电子邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * get jo_user.password
	 * @return 密码
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * set jo_user.password
	 * @param 密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * get jo_user.register_time
	 * @return 注册时间
	 */
	public String getRegisterTime() {
		return this.registerTime;
	}

	/**
	 * set jo_user.register_time
	 * @param 注册时间
	 */
	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	/**
	 * get jo_user.register_ip
	 * @return 注册IP
	 */
	public String getRegisterIp() {
		return this.registerIp;
	}

	/**
	 * set jo_user.register_ip
	 * @param 注册IP
	 */
	public void setRegisterIp(String registerIp) {
		this.registerIp = registerIp;
	}

	/**
	 * get jo_user.last_login_time
	 * @return 最后登录时间
	 */
	public String getLastLoginTime() {
		return this.lastLoginTime;
	}

	/**
	 * set jo_user.last_login_time
	 * @param 最后登录时间
	 */
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * get jo_user.last_login_ip
	 * @return 最后登录IP
	 */
	public String getLastLoginIp() {
		return this.lastLoginIp;
	}

	/**
	 * set jo_user.last_login_ip
	 * @param 最后登录IP
	 */
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	/**
	 * get jo_user.login_count
	 * @return 登录次数
	 */
	public String getLoginCount() {
		return this.loginCount;
	}

	/**
	 * set jo_user.login_count
	 * @param 登录次数
	 */
	public void setLoginCount(String loginCount) {
		this.loginCount = loginCount;
	}

	/**
	 * get jo_user.reset_key
	 * @return 重置密码KEY
	 */
	public String getResetKey() {
		return this.resetKey;
	}

	/**
	 * set jo_user.reset_key
	 * @param 重置密码KEY
	 */
	public void setResetKey(String resetKey) {
		this.resetKey = resetKey;
	}

	/**
	 * get jo_user.reset_pwd
	 * @return 重置密码VALUE
	 */
	public String getResetPwd() {
		return this.resetPwd;
	}

	/**
	 * set jo_user.reset_pwd
	 * @param 重置密码VALUE
	 */
	public void setResetPwd(String resetPwd) {
		this.resetPwd = resetPwd;
	}

	/**
	 * get jo_user.activation
	 * @return 激活状态
	 */
	public String getActivation() {
		return this.activation;
	}

	/**
	 * set jo_user.activation
	 * @param 激活状态
	 */
	public void setActivation(String activation) {
		this.activation = activation;
	}

	/**
	 * get jo_user.activation_code
	 * @return 激活码
	 */
	public String getActivationCode() {
		return this.activationCode;
	}

	/**
	 * set jo_user.activation_code
	 * @param 激活码
	 */
	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	/**
	 * get jo_user.error_time
	 * @return 登录错误时间
	 */
	public String getErrorTime() {
		return this.errorTime;
	}

	/**
	 * set jo_user.error_time
	 * @param 登录错误时间
	 */
	public void setErrorTime(String errorTime) {
		this.errorTime = errorTime;
	}

	/**
	 * get jo_user.error_count
	 * @return 登录错误次数
	 */
	public String getErrorCount() {
		return this.errorCount;
	}

	/**
	 * set jo_user.error_count
	 * @param 登录错误次数
	 */
	public void setErrorCount(String errorCount) {
		this.errorCount = errorCount;
	}

	/**
	 * get jo_user.error_ip
	 * @return 登录错误IP
	 */
	public String getErrorIp() {
		return this.errorIp;
	}

	/**
	 * set jo_user.error_ip
	 * @param 登录错误IP
	 */
	public void setErrorIp(String errorIp) {
		this.errorIp = errorIp;
	}

	public  Map<String,Object> returnMap()
	{
		 Map<String,Object> returnMap =new HashMap<String,Object>();
		 	returnMap.put("userId",this.userId);
		 	returnMap.put("username",this.username);
		 	returnMap.put("email",this.email);
		 	returnMap.put("password",this.password);
		 	returnMap.put("registerTime",this.registerTime);
		 	returnMap.put("registerIp",this.registerIp);
		 	returnMap.put("lastLoginTime",this.lastLoginTime);
		 	returnMap.put("lastLoginIp",this.lastLoginIp);
		 	returnMap.put("loginCount",this.loginCount);
		 	returnMap.put("resetKey",this.resetKey);
		 	returnMap.put("resetPwd",this.resetPwd);
		 	returnMap.put("activation",this.activation);
		 	returnMap.put("activationCode",this.activationCode);
		 	returnMap.put("errorTime",this.errorTime);
		 	returnMap.put("errorCount",this.errorCount);
		 	returnMap.put("errorIp",this.errorIp);
		 return returnMap;
	}
}
