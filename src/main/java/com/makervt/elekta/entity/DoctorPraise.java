package com.makervt.elekta.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.annotation.JSONType;
import com.makervt.core.domain.Page;

/**
 * mapping for doctor_praise
 * meaning 医生点赞信息
 * @author CodeGenerator
 */
 @JSONType(ignores = {"pageNo", "pageSize", "pageTotal","totalCount","start"})
public class DoctorPraise extends Page<DoctorPraise>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * mapping for doctor_praise.Doctor_Praise_id
	 * meaning 
	 */
	private String doctorPraiseId;

	/**
	 * mapping for doctor_praise.User_id
	 * meaning 
	 */
	private String userId;

	/**
	 * mapping for doctor_praise.doctor_id
	 * meaning 
	 */
	private String doctorId;

	/**
	 * mapping for doctor_praise.Doctor_Praise_date
	 * meaning 点赞日期
	 */
	private String doctorPraiseDate;

	/**
	 * mapping for doctor_praise.Doctor_Praise_create_user
	 * meaning 创建人
	 */
	private String doctorPraiseCreateUser;

	/**
	 * mapping for doctor_praise.Doctor_Praise_create_date
	 * meaning 创建时间
	 */
	private String doctorPraiseCreateDate;

	/**
	 * mapping for doctor_praise.Doctor_Praise_update_user
	 * meaning 更新人
	 */
	private String doctorPraiseUpdateUser;

	/**
	 * mapping for doctor_praise.Doctor_Praise_update_date
	 * meaning 更新时间
	 */
	private String doctorPraiseUpdateDate;

	/**
	 * get doctor_praise.Doctor_Praise_id
	 * @return 
	 */
	public String getDoctorPraiseId() {
		return this.doctorPraiseId;
	}

	/**
	 * set doctor_praise.Doctor_Praise_id
	 * @param 
	 */
	public void setDoctorPraiseId(String doctorPraiseId) {
		this.doctorPraiseId = doctorPraiseId;
	}

	/**
	 * get doctor_praise.User_id
	 * @return 
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * set doctor_praise.User_id
	 * @param 
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * get doctor_praise.doctor_id
	 * @return 
	 */
	public String getDoctorId() {
		return this.doctorId;
	}

	/**
	 * set doctor_praise.doctor_id
	 * @param 
	 */
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	/**
	 * get doctor_praise.Doctor_Praise_date
	 * @return 点赞日期
	 */
	public String getDoctorPraiseDate() {
		return this.doctorPraiseDate;
	}

	/**
	 * set doctor_praise.Doctor_Praise_date
	 * @param 点赞日期
	 */
	public void setDoctorPraiseDate(String doctorPraiseDate) {
		this.doctorPraiseDate = doctorPraiseDate;
	}

	/**
	 * get doctor_praise.Doctor_Praise_create_user
	 * @return 创建人
	 */
	public String getDoctorPraiseCreateUser() {
		return this.doctorPraiseCreateUser;
	}

	/**
	 * set doctor_praise.Doctor_Praise_create_user
	 * @param 创建人
	 */
	public void setDoctorPraiseCreateUser(String doctorPraiseCreateUser) {
		this.doctorPraiseCreateUser = doctorPraiseCreateUser;
	}

	/**
	 * get doctor_praise.Doctor_Praise_create_date
	 * @return 创建时间
	 */
	public String getDoctorPraiseCreateDate() {
		return this.doctorPraiseCreateDate;
	}

	/**
	 * set doctor_praise.Doctor_Praise_create_date
	 * @param 创建时间
	 */
	public void setDoctorPraiseCreateDate(String doctorPraiseCreateDate) {
		this.doctorPraiseCreateDate = doctorPraiseCreateDate;
	}

	/**
	 * get doctor_praise.Doctor_Praise_update_user
	 * @return 更新人
	 */
	public String getDoctorPraiseUpdateUser() {
		return this.doctorPraiseUpdateUser;
	}

	/**
	 * set doctor_praise.Doctor_Praise_update_user
	 * @param 更新人
	 */
	public void setDoctorPraiseUpdateUser(String doctorPraiseUpdateUser) {
		this.doctorPraiseUpdateUser = doctorPraiseUpdateUser;
	}

	/**
	 * get doctor_praise.Doctor_Praise_update_date
	 * @return 更新时间
	 */
	public String getDoctorPraiseUpdateDate() {
		return this.doctorPraiseUpdateDate;
	}

	/**
	 * set doctor_praise.Doctor_Praise_update_date
	 * @param 更新时间
	 */
	public void setDoctorPraiseUpdateDate(String doctorPraiseUpdateDate) {
		this.doctorPraiseUpdateDate = doctorPraiseUpdateDate;
	}

	public  Map<String,Object> returnMap()
	{
		 Map<String,Object> returnMap =new HashMap<String,Object>();
		 	returnMap.put("doctorPraiseId",this.doctorPraiseId);
		 	returnMap.put("userId",this.userId);
		 	returnMap.put("doctorId",this.doctorId);
		 	returnMap.put("doctorPraiseDate",this.doctorPraiseDate);
		 	returnMap.put("doctorPraiseCreateUser",this.doctorPraiseCreateUser);
		 	returnMap.put("doctorPraiseCreateDate",this.doctorPraiseCreateDate);
		 	returnMap.put("doctorPraiseUpdateUser",this.doctorPraiseUpdateUser);
		 	returnMap.put("doctorPraiseUpdateDate",this.doctorPraiseUpdateDate);
		 return returnMap;
	}
}
