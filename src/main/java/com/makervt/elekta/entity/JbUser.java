package com.makervt.elekta.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.annotation.JSONType;
import com.makervt.core.domain.Page;

/**
 * mapping for jb_user
 * meaning BBS用户表
 * @author CodeGenerator
 */
 @JSONType(ignores = {"pageNo", "pageSize", "pageTotal","totalCount","start"})
public class JbUser extends Page<JbUser>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * mapping for jb_user.user_id
	 * meaning 
	 */
	private String userId;

	/**
	 * mapping for jb_user.group_id
	 * meaning 
	 */
	private String groupId;

	/**
	 * mapping for jb_user.username
	 * meaning 用户名
	 */
	private String username;

	/**
	 * mapping for jb_user.email
	 * meaning 邮箱
	 */
	private String email;

	/**
	 * mapping for jb_user.register_time
	 * meaning 注册时间
	 */
	private String registerTime;

	/**
	 * mapping for jb_user.register_ip
	 * meaning 注册IP
	 */
	private String registerIp;

	/**
	 * mapping for jb_user.last_login_time
	 * meaning 最后登录时间
	 */
	private String lastLoginTime;

	/**
	 * mapping for jb_user.last_login_ip
	 * meaning 最后登录IP
	 */
	private String lastLoginIp;

	/**
	 * mapping for jb_user.login_count
	 * meaning 登录次数
	 */
	private String loginCount;

	/**
	 * mapping for jb_user.upload_total
	 * meaning 上传总大小
	 */
	private String uploadTotal;

	/**
	 * mapping for jb_user.upload_size
	 * meaning 上传大小
	 */
	private String uploadSize;

	/**
	 * mapping for jb_user.upload_date
	 * meaning 上传日期
	 */
	private String uploadDate;

	/**
	 * mapping for jb_user.is_admin
	 * meaning 是否管理员
	 */
	private String isAdmin;

	/**
	 * mapping for jb_user.is_disabled
	 * meaning 是否禁用
	 */
	private String isDisabled;

	/**
	 * mapping for jb_user.PROHIBIT_POST
	 * meaning 禁言(0:不禁言;1:永久禁言;2:定期禁言)
	 */
	private String prohibitPost;

	/**
	 * mapping for jb_user.PROHIBIT_TIME
	 * meaning 解禁时间
	 */
	private String prohibitTime;

	/**
	 * mapping for jb_user.GRADE_TODAY
	 * meaning 今日评分
	 */
	private String gradeToday;

	/**
	 * mapping for jb_user.UPLOAD_TODAY
	 * meaning 今日上传
	 */
	private String uploadToday;

	/**
	 * mapping for jb_user.POINT
	 * meaning 积分
	 */
	private String point;

	/**
	 * mapping for jb_user.INTRODUCTION
	 * meaning 个人介绍
	 */
	private String introduction;

	/**
	 * mapping for jb_user.SIGNED
	 * meaning 个性签名
	 */
	private String signed;

	/**
	 * mapping for jb_user.AVATAR
	 * meaning 个人头像
	 */
	private String avatar;

	/**
	 * mapping for jb_user.AVATAR_TYPE
	 * meaning 头像类型
	 */
	private String avatarType;

	/**
	 * mapping for jb_user.TOPIC_COUNT
	 * meaning 主题总数
	 */
	private String topicCount;

	/**
	 * mapping for jb_user.REPLY_COUNT
	 * meaning 回复总数
	 */
	private String replyCount;

	/**
	 * mapping for jb_user.PRIME_COUNT
	 * meaning 精华总数
	 */
	private String primeCount;

	/**
	 * mapping for jb_user.POST_TODAY
	 * meaning 今日发帖
	 */
	private String postToday;

	/**
	 * mapping for jb_user.LAST_POST_TIME
	 * meaning 最后回帖时间
	 */
	private String lastPostTime;

	/**
	 * mapping for jb_user.PRESTIGE
	 * meaning 威望
	 */
	private String prestige;

	/**
	 * mapping for jb_user.magic_packet_size
	 * meaning 用户道具包现有容量
	 */
	private String magicPacketSize;

	/**
	 * mapping for jb_user.session_id
	 * meaning 
	 */
	private String sessionId;

	/**
	 * mapping for jb_user.active_level_id
	 * meaning 
	 */
	private String activeLevelId;

	/**
	 * mapping for jb_user.is_official
	 * meaning 
	 */
	private String isOfficial;

	/**
	 * get jb_user.user_id
	 * @return 
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * set jb_user.user_id
	 * @param 
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * get jb_user.group_id
	 * @return 
	 */
	public String getGroupId() {
		return this.groupId;
	}

	/**
	 * set jb_user.group_id
	 * @param 
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	/**
	 * get jb_user.username
	 * @return 用户名
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * set jb_user.username
	 * @param 用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * get jb_user.email
	 * @return 邮箱
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * set jb_user.email
	 * @param 邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * get jb_user.register_time
	 * @return 注册时间
	 */
	public String getRegisterTime() {
		return this.registerTime;
	}

	/**
	 * set jb_user.register_time
	 * @param 注册时间
	 */
	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	/**
	 * get jb_user.register_ip
	 * @return 注册IP
	 */
	public String getRegisterIp() {
		return this.registerIp;
	}

	/**
	 * set jb_user.register_ip
	 * @param 注册IP
	 */
	public void setRegisterIp(String registerIp) {
		this.registerIp = registerIp;
	}

	/**
	 * get jb_user.last_login_time
	 * @return 最后登录时间
	 */
	public String getLastLoginTime() {
		return this.lastLoginTime;
	}

	/**
	 * set jb_user.last_login_time
	 * @param 最后登录时间
	 */
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * get jb_user.last_login_ip
	 * @return 最后登录IP
	 */
	public String getLastLoginIp() {
		return this.lastLoginIp;
	}

	/**
	 * set jb_user.last_login_ip
	 * @param 最后登录IP
	 */
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	/**
	 * get jb_user.login_count
	 * @return 登录次数
	 */
	public String getLoginCount() {
		return this.loginCount;
	}

	/**
	 * set jb_user.login_count
	 * @param 登录次数
	 */
	public void setLoginCount(String loginCount) {
		this.loginCount = loginCount;
	}

	/**
	 * get jb_user.upload_total
	 * @return 上传总大小
	 */
	public String getUploadTotal() {
		return this.uploadTotal;
	}

	/**
	 * set jb_user.upload_total
	 * @param 上传总大小
	 */
	public void setUploadTotal(String uploadTotal) {
		this.uploadTotal = uploadTotal;
	}

	/**
	 * get jb_user.upload_size
	 * @return 上传大小
	 */
	public String getUploadSize() {
		return this.uploadSize;
	}

	/**
	 * set jb_user.upload_size
	 * @param 上传大小
	 */
	public void setUploadSize(String uploadSize) {
		this.uploadSize = uploadSize;
	}

	/**
	 * get jb_user.upload_date
	 * @return 上传日期
	 */
	public String getUploadDate() {
		return this.uploadDate;
	}

	/**
	 * set jb_user.upload_date
	 * @param 上传日期
	 */
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	/**
	 * get jb_user.is_admin
	 * @return 是否管理员
	 */
	public String getIsAdmin() {
		return this.isAdmin;
	}

	/**
	 * set jb_user.is_admin
	 * @param 是否管理员
	 */
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	/**
	 * get jb_user.is_disabled
	 * @return 是否禁用
	 */
	public String getIsDisabled() {
		return this.isDisabled;
	}

	/**
	 * set jb_user.is_disabled
	 * @param 是否禁用
	 */
	public void setIsDisabled(String isDisabled) {
		this.isDisabled = isDisabled;
	}

	/**
	 * get jb_user.PROHIBIT_POST
	 * @return 禁言(0:不禁言;1:永久禁言;2:定期禁言)
	 */
	public String getProhibitPost() {
		return this.prohibitPost;
	}

	/**
	 * set jb_user.PROHIBIT_POST
	 * @param 禁言(0:不禁言;1:永久禁言;2:定期禁言)
	 */
	public void setProhibitPost(String prohibitPost) {
		this.prohibitPost = prohibitPost;
	}

	/**
	 * get jb_user.PROHIBIT_TIME
	 * @return 解禁时间
	 */
	public String getProhibitTime() {
		return this.prohibitTime;
	}

	/**
	 * set jb_user.PROHIBIT_TIME
	 * @param 解禁时间
	 */
	public void setProhibitTime(String prohibitTime) {
		this.prohibitTime = prohibitTime;
	}

	/**
	 * get jb_user.GRADE_TODAY
	 * @return 今日评分
	 */
	public String getGradeToday() {
		return this.gradeToday;
	}

	/**
	 * set jb_user.GRADE_TODAY
	 * @param 今日评分
	 */
	public void setGradeToday(String gradeToday) {
		this.gradeToday = gradeToday;
	}

	/**
	 * get jb_user.UPLOAD_TODAY
	 * @return 今日上传
	 */
	public String getUploadToday() {
		return this.uploadToday;
	}

	/**
	 * set jb_user.UPLOAD_TODAY
	 * @param 今日上传
	 */
	public void setUploadToday(String uploadToday) {
		this.uploadToday = uploadToday;
	}

	/**
	 * get jb_user.POINT
	 * @return 积分
	 */
	public String getPoint() {
		return this.point;
	}

	/**
	 * set jb_user.POINT
	 * @param 积分
	 */
	public void setPoint(String point) {
		this.point = point;
	}

	/**
	 * get jb_user.INTRODUCTION
	 * @return 个人介绍
	 */
	public String getIntroduction() {
		return this.introduction;
	}

	/**
	 * set jb_user.INTRODUCTION
	 * @param 个人介绍
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	/**
	 * get jb_user.SIGNED
	 * @return 个性签名
	 */
	public String getSigned() {
		return this.signed;
	}

	/**
	 * set jb_user.SIGNED
	 * @param 个性签名
	 */
	public void setSigned(String signed) {
		this.signed = signed;
	}

	/**
	 * get jb_user.AVATAR
	 * @return 个人头像
	 */
	public String getAvatar() {
		return this.avatar;
	}

	/**
	 * set jb_user.AVATAR
	 * @param 个人头像
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/**
	 * get jb_user.AVATAR_TYPE
	 * @return 头像类型
	 */
	public String getAvatarType() {
		return this.avatarType;
	}

	/**
	 * set jb_user.AVATAR_TYPE
	 * @param 头像类型
	 */
	public void setAvatarType(String avatarType) {
		this.avatarType = avatarType;
	}

	/**
	 * get jb_user.TOPIC_COUNT
	 * @return 主题总数
	 */
	public String getTopicCount() {
		return this.topicCount;
	}

	/**
	 * set jb_user.TOPIC_COUNT
	 * @param 主题总数
	 */
	public void setTopicCount(String topicCount) {
		this.topicCount = topicCount;
	}

	/**
	 * get jb_user.REPLY_COUNT
	 * @return 回复总数
	 */
	public String getReplyCount() {
		return this.replyCount;
	}

	/**
	 * set jb_user.REPLY_COUNT
	 * @param 回复总数
	 */
	public void setReplyCount(String replyCount) {
		this.replyCount = replyCount;
	}

	/**
	 * get jb_user.PRIME_COUNT
	 * @return 精华总数
	 */
	public String getPrimeCount() {
		return this.primeCount;
	}

	/**
	 * set jb_user.PRIME_COUNT
	 * @param 精华总数
	 */
	public void setPrimeCount(String primeCount) {
		this.primeCount = primeCount;
	}

	/**
	 * get jb_user.POST_TODAY
	 * @return 今日发帖
	 */
	public String getPostToday() {
		return this.postToday;
	}

	/**
	 * set jb_user.POST_TODAY
	 * @param 今日发帖
	 */
	public void setPostToday(String postToday) {
		this.postToday = postToday;
	}

	/**
	 * get jb_user.LAST_POST_TIME
	 * @return 最后回帖时间
	 */
	public String getLastPostTime() {
		return this.lastPostTime;
	}

	/**
	 * set jb_user.LAST_POST_TIME
	 * @param 最后回帖时间
	 */
	public void setLastPostTime(String lastPostTime) {
		this.lastPostTime = lastPostTime;
	}

	/**
	 * get jb_user.PRESTIGE
	 * @return 威望
	 */
	public String getPrestige() {
		return this.prestige;
	}

	/**
	 * set jb_user.PRESTIGE
	 * @param 威望
	 */
	public void setPrestige(String prestige) {
		this.prestige = prestige;
	}

	/**
	 * get jb_user.magic_packet_size
	 * @return 用户道具包现有容量
	 */
	public String getMagicPacketSize() {
		return this.magicPacketSize;
	}

	/**
	 * set jb_user.magic_packet_size
	 * @param 用户道具包现有容量
	 */
	public void setMagicPacketSize(String magicPacketSize) {
		this.magicPacketSize = magicPacketSize;
	}

	/**
	 * get jb_user.session_id
	 * @return 
	 */
	public String getSessionId() {
		return this.sessionId;
	}

	/**
	 * set jb_user.session_id
	 * @param 
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * get jb_user.active_level_id
	 * @return 
	 */
	public String getActiveLevelId() {
		return this.activeLevelId;
	}

	/**
	 * set jb_user.active_level_id
	 * @param 
	 */
	public void setActiveLevelId(String activeLevelId) {
		this.activeLevelId = activeLevelId;
	}

	/**
	 * get jb_user.is_official
	 * @return 
	 */
	public String getIsOfficial() {
		return this.isOfficial;
	}

	/**
	 * set jb_user.is_official
	 * @param 
	 */
	public void setIsOfficial(String isOfficial) {
		this.isOfficial = isOfficial;
	}

	public  Map<String,Object> returnMap()
	{
		 Map<String,Object> returnMap =new HashMap<String,Object>();
		 	returnMap.put("userId",this.userId);
		 	returnMap.put("groupId",this.groupId);
		 	returnMap.put("username",this.username);
		 	returnMap.put("email",this.email);
		 	returnMap.put("registerTime",this.registerTime);
		 	returnMap.put("registerIp",this.registerIp);
		 	returnMap.put("lastLoginTime",this.lastLoginTime);
		 	returnMap.put("lastLoginIp",this.lastLoginIp);
		 	returnMap.put("loginCount",this.loginCount);
		 	returnMap.put("uploadTotal",this.uploadTotal);
		 	returnMap.put("uploadSize",this.uploadSize);
		 	returnMap.put("uploadDate",this.uploadDate);
		 	returnMap.put("isAdmin",this.isAdmin);
		 	returnMap.put("isDisabled",this.isDisabled);
		 	returnMap.put("prohibitPost",this.prohibitPost);
		 	returnMap.put("prohibitTime",this.prohibitTime);
		 	returnMap.put("gradeToday",this.gradeToday);
		 	returnMap.put("uploadToday",this.uploadToday);
		 	returnMap.put("point",this.point);
		 	returnMap.put("introduction",this.introduction);
		 	returnMap.put("signed",this.signed);
		 	returnMap.put("avatar",this.avatar);
		 	returnMap.put("avatarType",this.avatarType);
		 	returnMap.put("topicCount",this.topicCount);
		 	returnMap.put("replyCount",this.replyCount);
		 	returnMap.put("primeCount",this.primeCount);
		 	returnMap.put("postToday",this.postToday);
		 	returnMap.put("lastPostTime",this.lastPostTime);
		 	returnMap.put("prestige",this.prestige);
		 	returnMap.put("magicPacketSize",this.magicPacketSize);
		 	returnMap.put("sessionId",this.sessionId);
		 	returnMap.put("activeLevelId",this.activeLevelId);
		 	returnMap.put("isOfficial",this.isOfficial);
		 return returnMap;
	}
}
