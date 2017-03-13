package com.makervt.elekta.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.annotation.JSONType;
import com.makervt.core.domain.Page;

/**
 * mapping for message
 * meaning 消息
 * @author CodeGenerator
 */
 @JSONType(ignores = {"messageUpdateDate","messagerUpdateUser","messageCreateDate","messageCreateUser","pageNo", "pageSize", "pageTotal","totalCount","start"})
public class Message extends Page<Message>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * mapping for message.message_id
	 * meaning 
	 */
	private String messageId;

	/**
	 * mapping for message.User_id
	 * meaning 
	 */
	private String userId;

	/**
	 * mapping for message.message_Time
	 * meaning 消息发送时间（2016-12-31 10:00）
	 */
	private String messageTime;

	/**
	 * mapping for message.message_Title
	 * meaning 消息标题
	 */
	private String messageTitle;

	/**
	 * mapping for message.message_Content
	 * meaning 消息内容
	 */
	private String messageContent;

	/**
	 * mapping for message.message_Type
	 * meaning 消息类型（0医院（系统）消息　1医生消息）
	 */
	private String messageType;

	/**
	 * mapping for message.message_Status
	 * meaning 消息状态(1已查看 0未查看)
	 */
	private String messageStatus;

	/**
	 * mapping for message.message_Sender_name
	 * meaning 发送者名称
	 */
	private String messageSenderName;

	/**
	 * mapping for message.message_Sender
	 * meaning 发送者标识
	 */
	private String messageSender;

	/**
	 * mapping for message.message_create_user
	 * meaning 创建人
	 */
	private String messageCreateUser;

	/**
	 * mapping for message.message_create_date
	 * meaning 创建时间
	 */
	private String messageCreateDate;

	/**
	 * mapping for message.messager_update_user
	 * meaning 更新人
	 */
	private String messagerUpdateUser;

	/**
	 * mapping for message.message_update_date
	 * meaning 更新时间
	 */
	private String messageUpdateDate;

	/**
	 * get message.message_id
	 * @return 
	 */
	public String getMessageId() {
		return this.messageId;
	}

	/**
	 * set message.message_id
	 * @param 
	 */
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	/**
	 * get message.User_id
	 * @return 
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * set message.User_id
	 * @param 
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * get message.message_Time
	 * @return 消息发送时间（2016-12-31 10:00）
	 */
	public String getMessageTime() {
		return this.messageTime;
	}

	/**
	 * set message.message_Time
	 * @param 消息发送时间（2016-12-31 10:00）
	 */
	public void setMessageTime(String messageTime) {
		this.messageTime = messageTime;
	}

	/**
	 * get message.message_Title
	 * @return 消息标题
	 */
	public String getMessageTitle() {
		return this.messageTitle;
	}

	/**
	 * set message.message_Title
	 * @param 消息标题
	 */
	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}

	/**
	 * get message.message_Content
	 * @return 消息内容
	 */
	public String getMessageContent() {
		return this.messageContent;
	}

	/**
	 * set message.message_Content
	 * @param 消息内容
	 */
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	/**
	 * get message.message_Type
	 * @return 消息类型（0医院（系统）消息　1医生消息）
	 */
	public String getMessageType() {
		return this.messageType;
	}

	/**
	 * set message.message_Type
	 * @param 消息类型（0医院（系统）消息　1医生消息）
	 */
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	/**
	 * get message.message_Status
	 * @return 消息状态(1已查看 0未查看)
	 */
	public String getMessageStatus() {
		return this.messageStatus;
	}

	/**
	 * set message.message_Status
	 * @param 消息状态(1已查看 0未查看)
	 */
	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}

	/**
	 * get message.message_Sender_name
	 * @return 发送者名称
	 */
	public String getMessageSenderName() {
		return this.messageSenderName;
	}

	/**
	 * set message.message_Sender_name
	 * @param 发送者名称
	 */
	public void setMessageSenderName(String messageSenderName) {
		this.messageSenderName = messageSenderName;
	}

	/**
	 * get message.message_Sender
	 * @return 发送者标识
	 */
	public String getMessageSender() {
		return this.messageSender;
	}

	/**
	 * set message.message_Sender
	 * @param 发送者标识
	 */
	public void setMessageSender(String messageSender) {
		this.messageSender = messageSender;
	}

	/**
	 * get message.message_create_user
	 * @return 创建人
	 */
	public String getMessageCreateUser() {
		return this.messageCreateUser;
	}

	/**
	 * set message.message_create_user
	 * @param 创建人
	 */
	public void setMessageCreateUser(String messageCreateUser) {
		this.messageCreateUser = messageCreateUser;
	}

	/**
	 * get message.message_create_date
	 * @return 创建时间
	 */
	public String getMessageCreateDate() {
		return this.messageCreateDate;
	}

	/**
	 * set message.message_create_date
	 * @param 创建时间
	 */
	public void setMessageCreateDate(String messageCreateDate) {
		this.messageCreateDate = messageCreateDate;
	}

	/**
	 * get message.messager_update_user
	 * @return 更新人
	 */
	public String getMessagerUpdateUser() {
		return this.messagerUpdateUser;
	}

	/**
	 * set message.messager_update_user
	 * @param 更新人
	 */
	public void setMessagerUpdateUser(String messagerUpdateUser) {
		this.messagerUpdateUser = messagerUpdateUser;
	}

	/**
	 * get message.message_update_date
	 * @return 更新时间
	 */
	public String getMessageUpdateDate() {
		return this.messageUpdateDate;
	}

	/**
	 * set message.message_update_date
	 * @param 更新时间
	 */
	public void setMessageUpdateDate(String messageUpdateDate) {
		this.messageUpdateDate = messageUpdateDate;
	}

	public  Map<String,Object> returnMap()
	{
		 Map<String,Object> returnMap =new HashMap<String,Object>();
		 	returnMap.put("messageId",this.messageId);
		 	returnMap.put("userId",this.userId);
		 	returnMap.put("messageTime",this.messageTime);
		 	returnMap.put("messageTitle",this.messageTitle);
		 	returnMap.put("messageContent",this.messageContent);
		 	returnMap.put("messageType",this.messageType);
		 	returnMap.put("messageStatus",this.messageStatus);
		 	returnMap.put("messageSenderName",this.messageSenderName);
		 	returnMap.put("messageSender",this.messageSender);
		 	returnMap.put("messageCreateUser",this.messageCreateUser);
		 	returnMap.put("messageCreateDate",this.messageCreateDate);
		 	returnMap.put("messagerUpdateUser",this.messagerUpdateUser);
		 	returnMap.put("messageUpdateDate",this.messageUpdateDate);
		 return returnMap;
	}
}
