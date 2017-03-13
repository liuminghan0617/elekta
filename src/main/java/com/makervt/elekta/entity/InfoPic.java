package com.makervt.elekta.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.annotation.JSONType;
import com.makervt.core.domain.Page;

/**
 * mapping for Info_Pic
 * meaning 资讯详情图片
 * @author CodeGenerator
 */
 @JSONType(ignores = {"pageNo", "pageSize", "pageTotal","totalCount","start"})
public class InfoPic extends Page<InfoPic>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * mapping for Info_Pic.Info_Pic_id
	 * meaning 
	 */
	private String infoPicId;

	/**
	 * mapping for Info_Pic.info_id
	 * meaning 
	 */
	private String infoId;

	/**
	 * mapping for Info_Pic.Info_Pic_url
	 * meaning 访问路径
	 */
	private String infoPicUrl;

	/**
	 * mapping for Info_Pic.Info_Pic_dir
	 * meaning 物理路径
	 */
	private String infoPicDir;

	/**
	 * mapping for Info_Pic.Info_Pic_create_user
	 * meaning 创建人
	 */
	private String infoPicCreateUser;

	/**
	 * mapping for Info_Pic.Info_Pic_create_date
	 * meaning 创建时间
	 */
	private String infoPicCreateDate;

	/**
	 * mapping for Info_Pic.Info_Pic_update_user
	 * meaning 更新人
	 */
	private String infoPicUpdateUser;

	/**
	 * mapping for Info_Pic.Info_Pic_update_date
	 * meaning 更新时间
	 */
	private String infoPicUpdateDate;

	/**
	 * get Info_Pic.Info_Pic_id
	 * @return 
	 */
	public String getInfoPicId() {
		return this.infoPicId;
	}

	/**
	 * set Info_Pic.Info_Pic_id
	 * @param 
	 */
	public void setInfoPicId(String infoPicId) {
		this.infoPicId = infoPicId;
	}

	/**
	 * get Info_Pic.info_id
	 * @return 
	 */
	public String getInfoId() {
		return this.infoId;
	}

	/**
	 * set Info_Pic.info_id
	 * @param 
	 */
	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}

	/**
	 * get Info_Pic.Info_Pic_url
	 * @return 访问路径
	 */
	public String getInfoPicUrl() {
		return this.infoPicUrl;
	}

	/**
	 * set Info_Pic.Info_Pic_url
	 * @param 访问路径
	 */
	public void setInfoPicUrl(String infoPicUrl) {
		this.infoPicUrl = infoPicUrl;
	}

	/**
	 * get Info_Pic.Info_Pic_dir
	 * @return 物理路径
	 */
	public String getInfoPicDir() {
		return this.infoPicDir;
	}

	/**
	 * set Info_Pic.Info_Pic_dir
	 * @param 物理路径
	 */
	public void setInfoPicDir(String infoPicDir) {
		this.infoPicDir = infoPicDir;
	}

	/**
	 * get Info_Pic.Info_Pic_create_user
	 * @return 创建人
	 */
	public String getInfoPicCreateUser() {
		return this.infoPicCreateUser;
	}

	/**
	 * set Info_Pic.Info_Pic_create_user
	 * @param 创建人
	 */
	public void setInfoPicCreateUser(String infoPicCreateUser) {
		this.infoPicCreateUser = infoPicCreateUser;
	}

	/**
	 * get Info_Pic.Info_Pic_create_date
	 * @return 创建时间
	 */
	public String getInfoPicCreateDate() {
		return this.infoPicCreateDate;
	}

	/**
	 * set Info_Pic.Info_Pic_create_date
	 * @param 创建时间
	 */
	public void setInfoPicCreateDate(String infoPicCreateDate) {
		this.infoPicCreateDate = infoPicCreateDate;
	}

	/**
	 * get Info_Pic.Info_Pic_update_user
	 * @return 更新人
	 */
	public String getInfoPicUpdateUser() {
		return this.infoPicUpdateUser;
	}

	/**
	 * set Info_Pic.Info_Pic_update_user
	 * @param 更新人
	 */
	public void setInfoPicUpdateUser(String infoPicUpdateUser) {
		this.infoPicUpdateUser = infoPicUpdateUser;
	}

	/**
	 * get Info_Pic.Info_Pic_update_date
	 * @return 更新时间
	 */
	public String getInfoPicUpdateDate() {
		return this.infoPicUpdateDate;
	}

	/**
	 * set Info_Pic.Info_Pic_update_date
	 * @param 更新时间
	 */
	public void setInfoPicUpdateDate(String infoPicUpdateDate) {
		this.infoPicUpdateDate = infoPicUpdateDate;
	}

	public  Map<String,Object> returnMap()
	{
		 Map<String,Object> returnMap =new HashMap<String,Object>();
		 	returnMap.put("infoPicId",this.infoPicId);
		 	returnMap.put("infoId",this.infoId);
		 	returnMap.put("infoPicUrl",this.infoPicUrl);
		 	returnMap.put("infoPicDir",this.infoPicDir);
		 	returnMap.put("infoPicCreateUser",this.infoPicCreateUser);
		 	returnMap.put("infoPicCreateDate",this.infoPicCreateDate);
		 	returnMap.put("infoPicUpdateUser",this.infoPicUpdateUser);
		 	returnMap.put("infoPicUpdateDate",this.infoPicUpdateDate);
		 return returnMap;
	}
}
