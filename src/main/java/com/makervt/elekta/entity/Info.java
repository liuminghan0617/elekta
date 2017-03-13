package com.makervt.elekta.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.annotation.JSONType;
import com.makervt.core.domain.Page;

/**
 * mapping for info
 * meaning 资讯
 * @author CodeGenerator
 */
 @JSONType(ignores = {"pageNo", "pageSize", "pageTotal","totalCount","start"})
public class Info extends Page<Info>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * mapping for info.info_id
	 * meaning 
	 */
	private String infoId;

	/**
	 * mapping for info.info_title
	 * meaning 资讯标题
	 */
	private String infoTitle;

	/**
	 * mapping for info.info_pic_url
	 * meaning 缩略图地址
	 */
	private String infoPicUrl;

	/**
	 * mapping for info.info_pic_dir
	 * meaning 缩略图物理地址
	 */
	private String infoPicDir;

	/**
	 * mapping for info.info_summary
	 * meaning 资讯摘要
	 */
	private String infoSummary;

	/**
	 * mapping for info.info_content
	 * meaning 资讯内容html
	 */
	private String infoContent;

	/**
	 * mapping for info.info_time
	 * meaning 资讯发布时间
	 */
	private String infoTime;

	/**
	 * mapping for info.info_hosp_id
	 * meaning 医院标识
	 */
	private String infoHospId;

	/**
	 * mapping for info.info_hosp_name
	 * meaning 医院名称
	 */
	private String infoHospName;

	/**
	 * mapping for info.info_display
	 * meaning 是否显示(0 不显示 1显示)
	 */
	private String infoDisplay;

	/**
	 * mapping for info.info_create_user
	 * meaning 创建人
	 */
	private String infoCreateUser;

	/**
	 * mapping for info.info_create_date
	 * meaning 创建时间
	 */
	private String infoCreateDate;

	/**
	 * mapping for info.info_update_user
	 * meaning 更新人
	 */
	private String infoUpdateUser;

	/**
	 * mapping for info.info_update_date
	 * meaning 更新时间
	 */
	private String infoUpdateDate;

	/**
	 * get info.info_id
	 * @return 
	 */
	public String getInfoId() {
		return this.infoId;
	}

	/**
	 * set info.info_id
	 * @param 
	 */
	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}

	/**
	 * get info.info_title
	 * @return 资讯标题
	 */
	public String getInfoTitle() {
		return this.infoTitle;
	}

	/**
	 * set info.info_title
	 * @param 资讯标题
	 */
	public void setInfoTitle(String infoTitle) {
		this.infoTitle = infoTitle;
	}

	/**
	 * get info.info_pic_url
	 * @return 缩略图地址
	 */
	public String getInfoPicUrl() {
		return this.infoPicUrl;
	}

	/**
	 * set info.info_pic_url
	 * @param 缩略图地址
	 */
	public void setInfoPicUrl(String infoPicUrl) {
		this.infoPicUrl = infoPicUrl;
	}

	/**
	 * get info.info_pic_dir
	 * @return 缩略图物理地址
	 */
	public String getInfoPicDir() {
		return this.infoPicDir;
	}

	/**
	 * set info.info_pic_dir
	 * @param 缩略图物理地址
	 */
	public void setInfoPicDir(String infoPicDir) {
		this.infoPicDir = infoPicDir;
	}

	/**
	 * get info.info_summary
	 * @return 资讯摘要
	 */
	public String getInfoSummary() {
		return this.infoSummary;
	}

	/**
	 * set info.info_summary
	 * @param 资讯摘要
	 */
	public void setInfoSummary(String infoSummary) {
		this.infoSummary = infoSummary;
	}

	/**
	 * get info.info_content
	 * @return 资讯内容html
	 */
	public String getInfoContent() {
		return this.infoContent;
	}

	/**
	 * set info.info_content
	 * @param 资讯内容html
	 */
	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}

	/**
	 * get info.info_time
	 * @return 资讯发布时间
	 */
	public String getInfoTime() {
		return this.infoTime;
	}

	/**
	 * set info.info_time
	 * @param 资讯发布时间
	 */
	public void setInfoTime(String infoTime) {
		this.infoTime = infoTime;
	}

	/**
	 * get info.info_hosp_id
	 * @return 医院标识
	 */
	public String getInfoHospId() {
		return this.infoHospId;
	}

	/**
	 * set info.info_hosp_id
	 * @param 医院标识
	 */
	public void setInfoHospId(String infoHospId) {
		this.infoHospId = infoHospId;
	}

	/**
	 * get info.info_hosp_name
	 * @return 医院名称
	 */
	public String getInfoHospName() {
		return this.infoHospName;
	}

	/**
	 * set info.info_hosp_name
	 * @param 医院名称
	 */
	public void setInfoHospName(String infoHospName) {
		this.infoHospName = infoHospName;
	}

	/**
	 * get info.info_display
	 * @return 是否显示(0 不显示 1显示)
	 */
	public String getInfoDisplay() {
		return this.infoDisplay;
	}

	/**
	 * set info.info_display
	 * @param 是否显示(0 不显示 1显示)
	 */
	public void setInfoDisplay(String infoDisplay) {
		this.infoDisplay = infoDisplay;
	}

	/**
	 * get info.info_create_user
	 * @return 创建人
	 */
	public String getInfoCreateUser() {
		return this.infoCreateUser;
	}

	/**
	 * set info.info_create_user
	 * @param 创建人
	 */
	public void setInfoCreateUser(String infoCreateUser) {
		this.infoCreateUser = infoCreateUser;
	}

	/**
	 * get info.info_create_date
	 * @return 创建时间
	 */
	public String getInfoCreateDate() {
		return this.infoCreateDate;
	}

	/**
	 * set info.info_create_date
	 * @param 创建时间
	 */
	public void setInfoCreateDate(String infoCreateDate) {
		this.infoCreateDate = infoCreateDate;
	}

	/**
	 * get info.info_update_user
	 * @return 更新人
	 */
	public String getInfoUpdateUser() {
		return this.infoUpdateUser;
	}

	/**
	 * set info.info_update_user
	 * @param 更新人
	 */
	public void setInfoUpdateUser(String infoUpdateUser) {
		this.infoUpdateUser = infoUpdateUser;
	}

	/**
	 * get info.info_update_date
	 * @return 更新时间
	 */
	public String getInfoUpdateDate() {
		return this.infoUpdateDate;
	}

	/**
	 * set info.info_update_date
	 * @param 更新时间
	 */
	public void setInfoUpdateDate(String infoUpdateDate) {
		this.infoUpdateDate = infoUpdateDate;
	}

	public  Map<String,Object> returnMap()
	{
		 Map<String,Object> returnMap =new HashMap<String,Object>();
		 	returnMap.put("infoId",this.infoId);
		 	returnMap.put("infoTitle",this.infoTitle);
		 	returnMap.put("infoPicUrl",this.infoPicUrl);
		 	returnMap.put("infoPicDir",this.infoPicDir);
		 	returnMap.put("infoSummary",this.infoSummary);
		 	returnMap.put("infoContent",this.infoContent);
		 	returnMap.put("infoTime",this.infoTime);
		 	returnMap.put("infoHospId",this.infoHospId);
		 	returnMap.put("infoHospName",this.infoHospName);
		 	returnMap.put("infoDisplay",this.infoDisplay);
		 	returnMap.put("infoCreateUser",this.infoCreateUser);
		 	returnMap.put("infoCreateDate",this.infoCreateDate);
		 	returnMap.put("infoUpdateUser",this.infoUpdateUser);
		 	returnMap.put("infoUpdateDate",this.infoUpdateDate);
		 return returnMap;
	}
}
