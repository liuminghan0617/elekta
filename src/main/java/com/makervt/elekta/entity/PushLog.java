package com.makervt.elekta.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.annotation.JSONType;
import com.makervt.core.domain.Page;

/**
 * mapping for push_log
 * meaning 推送记录
 * @author CodeGenerator
 */
 @JSONType(ignores = {"pageNo", "pageSize", "pageTotal","totalCount","start"})
public class PushLog extends Page<PushLog>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * mapping for push_log.push_log_id
	 * meaning 
	 */
	private String pushLogId;

	/**
	 * mapping for push_log.push_log_title
	 * meaning 推送标题
	 */
	private String pushLogTitle;

	/**
	 * mapping for push_log.push_log_content
	 * meaning 推送内容
	 */
	private String pushLogContent;

	/**
	 * mapping for push_log.push_log_type
	 * meaning 推送类型（单播、组播、全播‘、列播、文件播）
	 */
	private String pushLogType;

	/**
	 * mapping for push_log.push_log_ticker
	 * meaning 推送通知栏提示文字
	 */
	private String pushLogTicker;

	/**
	 * mapping for push_log.push_log_extra
	 * meaning 推送扩展内容
	 */
	private String pushLogExtra;

	/**
	 * mapping for push_log.push_log_time
	 * meaning 推送时间
	 */
	private String pushLogTime;

	/**
	 * mapping for push_log.push_log_response
	 * meaning 推送返回值
	 */
	private String pushLogResponse;

	/**
	 * mapping for push_log.push_log_user
	 * meaning 推送用户
	 */
	private String pushLogUser;

	/**
	 * get push_log.push_log_id
	 * @return 
	 */
	public String getPushLogId() {
		return this.pushLogId;
	}

	/**
	 * set push_log.push_log_id
	 * @param 
	 */
	public void setPushLogId(String pushLogId) {
		this.pushLogId = pushLogId;
	}

	/**
	 * get push_log.push_log_title
	 * @return 推送标题
	 */
	public String getPushLogTitle() {
		return this.pushLogTitle;
	}

	/**
	 * set push_log.push_log_title
	 * @param 推送标题
	 */
	public void setPushLogTitle(String pushLogTitle) {
		this.pushLogTitle = pushLogTitle;
	}

	/**
	 * get push_log.push_log_content
	 * @return 推送内容
	 */
	public String getPushLogContent() {
		return this.pushLogContent;
	}

	/**
	 * set push_log.push_log_content
	 * @param 推送内容
	 */
	public void setPushLogContent(String pushLogContent) {
		this.pushLogContent = pushLogContent;
	}

	/**
	 * get push_log.push_log_type
	 * @return 推送类型（单播、组播、全播‘、列播、文件播）
	 */
	public String getPushLogType() {
		return this.pushLogType;
	}

	/**
	 * set push_log.push_log_type
	 * @param 推送类型（单播、组播、全播‘、列播、文件播）
	 */
	public void setPushLogType(String pushLogType) {
		this.pushLogType = pushLogType;
	}

	/**
	 * get push_log.push_log_ticker
	 * @return 推送通知栏提示文字
	 */
	public String getPushLogTicker() {
		return this.pushLogTicker;
	}

	/**
	 * set push_log.push_log_ticker
	 * @param 推送通知栏提示文字
	 */
	public void setPushLogTicker(String pushLogTicker) {
		this.pushLogTicker = pushLogTicker;
	}

	/**
	 * get push_log.push_log_extra
	 * @return 推送扩展内容
	 */
	public String getPushLogExtra() {
		return this.pushLogExtra;
	}

	/**
	 * set push_log.push_log_extra
	 * @param 推送扩展内容
	 */
	public void setPushLogExtra(String pushLogExtra) {
		this.pushLogExtra = pushLogExtra;
	}

	/**
	 * get push_log.push_log_time
	 * @return 推送时间
	 */
	public String getPushLogTime() {
		return this.pushLogTime;
	}

	/**
	 * set push_log.push_log_time
	 * @param 推送时间
	 */
	public void setPushLogTime(String pushLogTime) {
		this.pushLogTime = pushLogTime;
	}

	/**
	 * get push_log.push_log_response
	 * @return 推送返回值
	 */
	public String getPushLogResponse() {
		return this.pushLogResponse;
	}

	/**
	 * set push_log.push_log_response
	 * @param 推送返回值
	 */
	public void setPushLogResponse(String pushLogResponse) {
		this.pushLogResponse = pushLogResponse;
	}

	/**
	 * get push_log.push_log_user
	 * @return 推送用户
	 */
	public String getPushLogUser() {
		return this.pushLogUser;
	}

	/**
	 * set push_log.push_log_user
	 * @param 推送用户
	 */
	public void setPushLogUser(String pushLogUser) {
		this.pushLogUser = pushLogUser;
	}

	public  Map<String,Object> returnMap()
	{
		 Map<String,Object> returnMap =new HashMap<String,Object>();
		 	returnMap.put("pushLogId",this.pushLogId);
		 	returnMap.put("pushLogTitle",this.pushLogTitle);
		 	returnMap.put("pushLogContent",this.pushLogContent);
		 	returnMap.put("pushLogType",this.pushLogType);
		 	returnMap.put("pushLogTicker",this.pushLogTicker);
		 	returnMap.put("pushLogExtra",this.pushLogExtra);
		 	returnMap.put("pushLogTime",this.pushLogTime);
		 	returnMap.put("pushLogResponse",this.pushLogResponse);
		 	returnMap.put("pushLogUser",this.pushLogUser);
		 return returnMap;
	}
}
