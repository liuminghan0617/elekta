package com.makervt.elekta.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.annotation.JSONType;
import com.makervt.core.domain.Page;

/**
 * mapping for Holiday
 * meaning 
 * @author CodeGenerator
 */
 @JSONType(ignores = {"pageNo", "pageSize", "pageTotal","totalCount","start","holidayCreateUser","holidayCreateDate","holidayUpdateUser","holidayUpdateDate"})
public class Holiday extends Page<Holiday>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * mapping for Holiday.Holiday_id
	 * meaning 
	 */
	private String holidayId;

	private String holidayStartDate;
	
	private String holidayEndDate;


	/**
	 * mapping for Holiday.Holiday_date
	 * meaning 节假日期
	 */
	private String holidayDate;

	/**
	 * mapping for Holiday.Holiday_hosp_id
	 * meaning 医院标识
	 */
	private String holidayHospId;

	/**
	 * mapping for Holiday.Holiday_type
	 * meaning 节假日类型（0代表节假日  1代表工作日）
	 */
	private String holidayType;

	/**
	 * mapping for Holiday.Holiday_hosp_name
	 * meaning 医院名称
	 */
	private String holidayHospName;

	/**
	 * mapping for Holiday.Holiday_create_user
	 * meaning 创建人
	 */
	private String holidayCreateUser;

	/**
	 * mapping for Holiday.Holiday_create_date
	 * meaning 创建时间
	 */
	private String holidayCreateDate;

	/**
	 * mapping for Holiday.Holiday_update_user
	 * meaning 更新人
	 */
	private String holidayUpdateUser;

	/**
	 * mapping for Holiday.Holiday_update_date
	 * meaning 更新时间
	 */
	private String holidayUpdateDate;

	/**
	 * get Holiday.Holiday_id
	 * @return 
	 */
	public String getHolidayId() {
		return this.holidayId;
	}

	/**
	 * set Holiday.Holiday_id
	 * @param 
	 */
	public void setHolidayId(String holidayId) {
		this.holidayId = holidayId;
	}

	/**
	 * get Holiday.Holiday_date
	 * @return 节假日期
	 */
	public String getHolidayDate() {
		return this.holidayDate;
	}

	/**
	 * set Holiday.Holiday_date
	 * @param 节假日期
	 */
	public void setHolidayDate(String holidayDate) {
		this.holidayDate = holidayDate;
	}

	/**
	 * get Holiday.Holiday_hosp_id
	 * @return 医院标识
	 */
	public String getHolidayHospId() {
		return this.holidayHospId;
	}

	/**
	 * set Holiday.Holiday_hosp_id
	 * @param 医院标识
	 */
	public void setHolidayHospId(String holidayHospId) {
		this.holidayHospId = holidayHospId;
	}

	/**
	 * get Holiday.Holiday_type
	 * @return 节假日类型（0代表节假日  1代表工作日）
	 */
	public String getHolidayType() {
		return this.holidayType;
	}

	/**
	 * set Holiday.Holiday_type
	 * @param 节假日类型（0代表节假日  1代表工作日）
	 */
	public void setHolidayType(String holidayType) {
		this.holidayType = holidayType;
	}

	/**
	 * get Holiday.Holiday_hosp_name
	 * @return 医院名称
	 */
	public String getHolidayHospName() {
		return this.holidayHospName;
	}

	/**
	 * set Holiday.Holiday_hosp_name
	 * @param 医院名称
	 */
	public void setHolidayHospName(String holidayHospName) {
		this.holidayHospName = holidayHospName;
	}

	/**
	 * get Holiday.Holiday_create_user
	 * @return 创建人
	 */
	public String getHolidayCreateUser() {
		return this.holidayCreateUser;
	}

	/**
	 * set Holiday.Holiday_create_user
	 * @param 创建人
	 */
	public void setHolidayCreateUser(String holidayCreateUser) {
		this.holidayCreateUser = holidayCreateUser;
	}

	/**
	 * get Holiday.Holiday_create_date
	 * @return 创建时间
	 */
	public String getHolidayCreateDate() {
		return this.holidayCreateDate;
	}

	/**
	 * set Holiday.Holiday_create_date
	 * @param 创建时间
	 */
	public void setHolidayCreateDate(String holidayCreateDate) {
		this.holidayCreateDate = holidayCreateDate;
	}

	/**
	 * get Holiday.Holiday_update_user
	 * @return 更新人
	 */
	public String getHolidayUpdateUser() {
		return this.holidayUpdateUser;
	}

	/**
	 * set Holiday.Holiday_update_user
	 * @param 更新人
	 */
	public void setHolidayUpdateUser(String holidayUpdateUser) {
		this.holidayUpdateUser = holidayUpdateUser;
	}

	/**
	 * get Holiday.Holiday_update_date
	 * @return 更新时间
	 */
	public String getHolidayUpdateDate() {
		return this.holidayUpdateDate;
	}

	/**
	 * set Holiday.Holiday_update_date
	 * @param 更新时间
	 */
	public void setHolidayUpdateDate(String holidayUpdateDate) {
		this.holidayUpdateDate = holidayUpdateDate;
	}
	
	public String getHolidayStartDate() {
		return holidayStartDate;
	}

	public void setHolidayStartDate(String holidayStartDate) {
		this.holidayStartDate = holidayStartDate;
	}

	public String getHolidayEndDate() {
		return holidayEndDate;
	}

	public void setHolidayEndDate(String holidayEndDate) {
		this.holidayEndDate = holidayEndDate;
	}

	public  Map<String,Object> returnMap()
	{
		 Map<String,Object> returnMap =new HashMap<String,Object>();
		 	returnMap.put("holidayId",this.holidayId);
		 	returnMap.put("holidayDate",this.holidayDate);
		 	returnMap.put("holidayHospId",this.holidayHospId);
		 	returnMap.put("holidayType",this.holidayType);
		 	returnMap.put("holidayHospName",this.holidayHospName);
		 	returnMap.put("holidayCreateUser",this.holidayCreateUser);
		 	returnMap.put("holidayCreateDate",this.holidayCreateDate);
		 	returnMap.put("holidayUpdateUser",this.holidayUpdateUser);
		 	returnMap.put("holidayUpdateDate",this.holidayUpdateDate);
		 return returnMap;
	}
}
