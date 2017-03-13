package com.makervt.core.component.push.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UmengPush implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3531502715167609322L;

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Map<String, String> getExtraFields() {
		return extraFields;
	}

	public void setExtraFields(Map<String, String> extraFields) {
		this.extraFields = extraFields;
	}

	public String getPushType() {
		return pushType;
	}

	public void setPushType(String pushType) {
		this.pushType = pushType;
	}

	private String deviceToken;
	private String ticker;
	private String title;
	private String text;
	private Map<String, String> extraFields;
	private String pushType;
	private List<String> users = new ArrayList<String>();
	private String user;
	private String deviceType;

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public List<String> getUsers() {
		return users;
	}

	public void setUsers(List<String> users) {
		this.users = users;
	}

	/**
	 * 
	 * 枚举提示类型(info、waring、error、success)
	 */
	public enum PushType {
		UNI("unicast"), LIST("listcast"), BROAD("broadcast"), GROUP("groupcast"), FILE("filecast"), CUSTOM("customizedcast");
		private String type;

		PushType(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}
	}
}
