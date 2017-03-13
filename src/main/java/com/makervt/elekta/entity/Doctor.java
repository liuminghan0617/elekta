package com.makervt.elekta.entity;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.annotation.JSONType;
import com.makervt.core.domain.Page;

/**
 * mapping for doctor meaning 医生信息
 * 
 * @author CodeGenerator
 */
@JSONType(ignores = { "pageNo", "pageSize", "pageTotal", "totalCount", "start" })
public class Doctor extends Page<Doctor> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userId;

	private List<DoctorPic> doctorPicList = new ArrayList<DoctorPic>();
	/**
	 * mapping for doctor.doctor_id meaning
	 */
	private String doctorId;

	/**
	 * mapping for doctor.doctor_name meaning 姓名
	 */
	private String doctorName;

	/**
	 * mapping for doctor.doctor_hosp_id meaning 医院标识
	 */
	private String doctorHospId;

	/**
	 * mapping for doctor.doctor_hosp_name meaning 医院名称
	 */
	private String doctorHospName;

	/**
	 * mapping for doctor.doctor_summary meaning 医生简介
	 */
	private String doctorSummary;

	/**
	 * mapping for doctor.doctor_photo_url meaning 医生照片url
	 */
	private String doctorPhotoUrl;

	/**
	 * mapping for doctor.doctor_photo_dir meaning 医生照片物理路径
	 */
	private String doctorPhotoDir;

	/**
	 * mapping for doctor.doctor_content meaning 医生简介html
	 */
	private String doctorContent;

	/**
	 * mapping for doctor.doctor_create_user meaning 创建人
	 */
	private String doctorCreateUser;

	/**
	 * mapping for doctor.doctor_create_date meaning 创建时间
	 */
	private String doctorCreateDate;

	/**
	 * mapping for doctor.doctor_update_user meaning 更新人
	 */
	private String doctorUpdateUser;

	/**
	 * mapping for doctor.doctor_update_date meaning 更新时间
	 */
	private String doctorUpdateDate;

	/**
	 * get doctor.doctor_id
	 * 
	 * @return
	 */
	public String getDoctorId() {
		return this.doctorId;
	}

	/**
	 * set doctor.doctor_id
	 * 
	 * @param
	 */
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	/**
	 * get doctor.doctor_name
	 * 
	 * @return 姓名
	 */
	public String getDoctorName() {
		return this.doctorName;
	}

	/**
	 * set doctor.doctor_name
	 * 
	 * @param 姓名
	 */
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	/**
	 * get doctor.doctor_hosp_id
	 * 
	 * @return 医院标识
	 */
	public String getDoctorHospId() {
		return this.doctorHospId;
	}

	/**
	 * set doctor.doctor_hosp_id
	 * 
	 * @param 医院标识
	 */
	public void setDoctorHospId(String doctorHospId) {
		this.doctorHospId = doctorHospId;
	}

	/**
	 * get doctor.doctor_hosp_name
	 * 
	 * @return 医院名称
	 */
	public String getDoctorHospName() {
		return this.doctorHospName;
	}

	/**
	 * set doctor.doctor_hosp_name
	 * 
	 * @param 医院名称
	 */
	public void setDoctorHospName(String doctorHospName) {
		this.doctorHospName = doctorHospName;
	}

	/**
	 * get doctor.doctor_summary
	 * 
	 * @return 医生简介
	 */
	public String getDoctorSummary() {
		return this.doctorSummary;
	}

	/**
	 * set doctor.doctor_summary
	 * 
	 * @param 医生简介
	 */
	public void setDoctorSummary(String doctorSummary) {
		this.doctorSummary = doctorSummary;
	}

	/**
	 * get doctor.doctor_photo_url
	 * 
	 * @return 医生照片url
	 */
	public String getDoctorPhotoUrl() {
		return this.doctorPhotoUrl;
	}

	/**
	 * set doctor.doctor_photo_url
	 * 
	 * @param 医生照片url
	 */
	public void setDoctorPhotoUrl(String doctorPhotoUrl) {
		this.doctorPhotoUrl = doctorPhotoUrl;
	}

	/**
	 * get doctor.doctor_photo_dir
	 * 
	 * @return 医生照片物理路径
	 */
	public String getDoctorPhotoDir() {
		return this.doctorPhotoDir;
	}

	/**
	 * set doctor.doctor_photo_dir
	 * 
	 * @param 医生照片物理路径
	 */
	public void setDoctorPhotoDir(String doctorPhotoDir) {
		this.doctorPhotoDir = doctorPhotoDir;
	}

	/**
	 * get doctor.doctor_content
	 * 
	 * @return 医生简介html
	 */
	public String getDoctorContent() {
		return this.doctorContent;
	}

	/**
	 * set doctor.doctor_content
	 * 
	 * @param 医生简介html
	 */
	public void setDoctorContent(String doctorContent) {
		this.doctorContent = doctorContent;
	}

	/**
	 * get doctor.doctor_create_user
	 * 
	 * @return 创建人
	 */
	public String getDoctorCreateUser() {
		return this.doctorCreateUser;
	}

	/**
	 * set doctor.doctor_create_user
	 * 
	 * @param 创建人
	 */
	public void setDoctorCreateUser(String doctorCreateUser) {
		this.doctorCreateUser = doctorCreateUser;
	}

	/**
	 * get doctor.doctor_create_date
	 * 
	 * @return 创建时间
	 */
	public String getDoctorCreateDate() {
		return this.doctorCreateDate;
	}

	/**
	 * set doctor.doctor_create_date
	 * 
	 * @param 创建时间
	 */
	public void setDoctorCreateDate(String doctorCreateDate) {
		this.doctorCreateDate = doctorCreateDate;
	}

	/**
	 * get doctor.doctor_update_user
	 * 
	 * @return 更新人
	 */
	public String getDoctorUpdateUser() {
		return this.doctorUpdateUser;
	}

	/**
	 * set doctor.doctor_update_user
	 * 
	 * @param 更新人
	 */
	public void setDoctorUpdateUser(String doctorUpdateUser) {
		this.doctorUpdateUser = doctorUpdateUser;
	}

	/**
	 * get doctor.doctor_update_date
	 * 
	 * @return 更新时间
	 */
	public String getDoctorUpdateDate() {
		return this.doctorUpdateDate;
	}

	/**
	 * set doctor.doctor_update_date
	 * 
	 * @param 更新时间
	 */
	public void setDoctorUpdateDate(String doctorUpdateDate) {
		this.doctorUpdateDate = doctorUpdateDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<DoctorPic> getDoctorPicList() {
		return doctorPicList;
	}

	public void setDoctorPicList(List<DoctorPic> doctorPicList) {
		this.doctorPicList = doctorPicList;
	}

	public Map<String, Object> returnMap() {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("userId", this.userId);
		returnMap.put("doctorId", this.doctorId);
		returnMap.put("doctorName", this.doctorName);
		returnMap.put("doctorHospId", this.doctorHospId);
		returnMap.put("doctorHospName", this.doctorHospName);
		returnMap.put("doctorSummary", this.doctorSummary);
		returnMap.put("doctorPhotoUrl", this.doctorPhotoUrl);
		returnMap.put("doctorPhotoDir", this.doctorPhotoDir);
		returnMap.put("doctorContent", this.doctorContent);
		returnMap.put("doctorCreateUser", this.doctorCreateUser);
		returnMap.put("doctorCreateDate", this.doctorCreateDate);
		returnMap.put("doctorUpdateUser", this.doctorUpdateUser);
		returnMap.put("doctorUpdateDate", this.doctorUpdateDate);
		returnMap.put("doctorPicList", this.doctorPicList);
		return returnMap;
	}
}
