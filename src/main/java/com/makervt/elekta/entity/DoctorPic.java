package com.makervt.elekta.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.annotation.JSONType;
import com.makervt.core.domain.Page;

/**
 * mapping for doctor_pic
 * meaning 医生图片
 * @author CodeGenerator
 */
 @JSONType(ignores = {"pageNo", "pageSize", "pageTotal","totalCount","start"})
public class DoctorPic extends Page<DoctorPic>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * mapping for doctor_pic.doctor_pic_id
	 * meaning 
	 */
	private String doctorPicId;

	/**
	 * mapping for doctor_pic.doctor_id
	 * meaning 
	 */
	private String doctorId;

	/**
	 * mapping for doctor_pic.doctor_pic_url
	 * meaning 医生图片访问路径
	 */
	private String doctorPicUrl;

	/**
	 * mapping for doctor_pic.doctor_pic_dir
	 * meaning 医生图片物理路径
	 */
	private String doctorPicDir;

	/**
	 * mapping for doctor_pic.doctor_pic_create_user
	 * meaning 创建人
	 */
	private String doctorPicCreateUser;

	/**
	 * mapping for doctor_pic.doctor_pic_create_date
	 * meaning 创建时间
	 */
	private String doctorPicCreateDate;

	/**
	 * mapping for doctor_pic.doctor_pic_update_user
	 * meaning 更新人
	 */
	private String doctorPicUpdateUser;

	/**
	 * mapping for doctor_pic.doctor_pic_update_date
	 * meaning 更新时间
	 */
	private String doctorPicUpdateDate;

	/**
	 * get doctor_pic.doctor_pic_id
	 * @return 
	 */
	public String getDoctorPicId() {
		return this.doctorPicId;
	}

	/**
	 * set doctor_pic.doctor_pic_id
	 * @param 
	 */
	public void setDoctorPicId(String doctorPicId) {
		this.doctorPicId = doctorPicId;
	}

	/**
	 * get doctor_pic.doctor_id
	 * @return 
	 */
	public String getDoctorId() {
		return this.doctorId;
	}

	/**
	 * set doctor_pic.doctor_id
	 * @param 
	 */
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	/**
	 * get doctor_pic.doctor_pic_url
	 * @return 医生图片访问路径
	 */
	public String getDoctorPicUrl() {
		return this.doctorPicUrl;
	}

	/**
	 * set doctor_pic.doctor_pic_url
	 * @param 医生图片访问路径
	 */
	public void setDoctorPicUrl(String doctorPicUrl) {
		this.doctorPicUrl = doctorPicUrl;
	}

	/**
	 * get doctor_pic.doctor_pic_dir
	 * @return 医生图片物理路径
	 */
	public String getDoctorPicDir() {
		return this.doctorPicDir;
	}

	/**
	 * set doctor_pic.doctor_pic_dir
	 * @param 医生图片物理路径
	 */
	public void setDoctorPicDir(String doctorPicDir) {
		this.doctorPicDir = doctorPicDir;
	}

	/**
	 * get doctor_pic.doctor_pic_create_user
	 * @return 创建人
	 */
	public String getDoctorPicCreateUser() {
		return this.doctorPicCreateUser;
	}

	/**
	 * set doctor_pic.doctor_pic_create_user
	 * @param 创建人
	 */
	public void setDoctorPicCreateUser(String doctorPicCreateUser) {
		this.doctorPicCreateUser = doctorPicCreateUser;
	}

	/**
	 * get doctor_pic.doctor_pic_create_date
	 * @return 创建时间
	 */
	public String getDoctorPicCreateDate() {
		return this.doctorPicCreateDate;
	}

	/**
	 * set doctor_pic.doctor_pic_create_date
	 * @param 创建时间
	 */
	public void setDoctorPicCreateDate(String doctorPicCreateDate) {
		this.doctorPicCreateDate = doctorPicCreateDate;
	}

	/**
	 * get doctor_pic.doctor_pic_update_user
	 * @return 更新人
	 */
	public String getDoctorPicUpdateUser() {
		return this.doctorPicUpdateUser;
	}

	/**
	 * set doctor_pic.doctor_pic_update_user
	 * @param 更新人
	 */
	public void setDoctorPicUpdateUser(String doctorPicUpdateUser) {
		this.doctorPicUpdateUser = doctorPicUpdateUser;
	}

	/**
	 * get doctor_pic.doctor_pic_update_date
	 * @return 更新时间
	 */
	public String getDoctorPicUpdateDate() {
		return this.doctorPicUpdateDate;
	}

	/**
	 * set doctor_pic.doctor_pic_update_date
	 * @param 更新时间
	 */
	public void setDoctorPicUpdateDate(String doctorPicUpdateDate) {
		this.doctorPicUpdateDate = doctorPicUpdateDate;
	}

	public  Map<String,Object> returnMap()
	{
		 Map<String,Object> returnMap =new HashMap<String,Object>();
		 	returnMap.put("doctorPicId",this.doctorPicId);
		 	returnMap.put("doctorId",this.doctorId);
		 	returnMap.put("doctorPicUrl",this.doctorPicUrl);
		 	returnMap.put("doctorPicDir",this.doctorPicDir);
		 	returnMap.put("doctorPicCreateUser",this.doctorPicCreateUser);
		 	returnMap.put("doctorPicCreateDate",this.doctorPicCreateDate);
		 	returnMap.put("doctorPicUpdateUser",this.doctorPicUpdateUser);
		 	returnMap.put("doctorPicUpdateDate",this.doctorPicUpdateDate);
		 return returnMap;
	}
}
