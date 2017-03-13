package com.makervt.core.domain;

/**
 * 登陆用户实体类,用于保存登陆用户的相关属性
 * 
 * @since JDK1.6
 * @version 1.0.0
 * @author core 2013-10-17 下午6:32:38
 */
public class LoginUser {

	/**
	 * 用户id
	 */
	private String userId;

	public LoginUser() {
		super();
	}

	public LoginUser(String userId, String seatSoftId, String seatId, String roleId, String userName) {
		super();
		this.userId = userId;
		this.seatSoftId = seatSoftId;
		this.seatId = seatId;
		this.roleId = roleId;
		this.userName = userName;
	}

	/**
	 * 席位应用软件id
	 */
	private String seatSoftId;

	/**
	 * 席位id
	 */
	private String seatId;

	/**
	 * 角色id
	 */
	private String roleId;

	private String userName;

	/**
	 * 获取用户名称
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-17 下午6:34:08
	 * @return String
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置用户名称
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-17 下午6:36:00
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 获得用户ID
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-17 下午6:36:19
	 * @return
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 设置用户ID
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-17 下午6:36:33
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 获得席位应用软件id
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-17 下午6:36:46
	 * @return
	 */
	public String getSeatSoftId() {
		return seatSoftId;
	}

	/**
	 * 设置席位应用软件id
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-17 下午6:37:07
	 * @param seatSoftId
	 */
	public void setSeatSoftId(String seatSoftId) {
		this.seatSoftId = seatSoftId;
	}

	/**
	 * 获得席位id
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-17 下午6:37:26
	 * @return
	 */
	public String getSeatId() {
		return seatId;
	}

	/**
	 * 设置席位id
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-17 下午6:37:33
	 * @param seatId
	 */
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

	/**
	 * 获得角色id
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-17 下午6:37:48
	 * @return
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * 设置角色id
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-17 下午6:37:56
	 * @param roleId
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}
