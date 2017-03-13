package com.makervt.elekta.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.annotation.JSONType;
import com.makervt.core.domain.Page;

/**
 * mapping for attention_pic
 * meaning 注意事项图片
 * @author CodeGenerator
 */
 @JSONType(ignores = {"pageNo", "pageSize", "pageTotal","totalCount","start"})
public class AttentionPic extends Page<AttentionPic>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * mapping for attention_pic.Attention_pic_id
	 * meaning 
	 */
	private String attentionPicId;

	/**
	 * mapping for attention_pic.Attention_id
	 * meaning 
	 */
	private String attentionId;

	/**
	 * mapping for attention_pic.Attention_pic_url
	 * meaning 注意事项图片访问路径
	 */
	private String attentionPicUrl;

	/**
	 * mapping for attention_pic.Attention_pic_dir
	 * meaning 注意事项图片物理路径
	 */
	private String attentionPicDir;

	/**
	 * mapping for attention_pic.Attention_pic_create_user
	 * meaning 创建人
	 */
	private String attentionPicCreateUser;

	/**
	 * mapping for attention_pic.Attention_pic_create_date
	 * meaning 创建时间
	 */
	private String attentionPicCreateDate;

	/**
	 * mapping for attention_pic.Attention_pic_update_user
	 * meaning 更新人
	 */
	private String attentionPicUpdateUser;

	/**
	 * mapping for attention_pic.Attention_pic_update_date
	 * meaning 更新时间
	 */
	private String attentionPicUpdateDate;

	/**
	 * get attention_pic.Attention_pic_id
	 * @return 
	 */
	public String getAttentionPicId() {
		return this.attentionPicId;
	}

	/**
	 * set attention_pic.Attention_pic_id
	 * @param 
	 */
	public void setAttentionPicId(String attentionPicId) {
		this.attentionPicId = attentionPicId;
	}

	/**
	 * get attention_pic.Attention_id
	 * @return 
	 */
	public String getAttentionId() {
		return this.attentionId;
	}

	/**
	 * set attention_pic.Attention_id
	 * @param 
	 */
	public void setAttentionId(String attentionId) {
		this.attentionId = attentionId;
	}

	/**
	 * get attention_pic.Attention_pic_url
	 * @return 注意事项图片访问路径
	 */
	public String getAttentionPicUrl() {
		return this.attentionPicUrl;
	}

	/**
	 * set attention_pic.Attention_pic_url
	 * @param 注意事项图片访问路径
	 */
	public void setAttentionPicUrl(String attentionPicUrl) {
		this.attentionPicUrl = attentionPicUrl;
	}

	/**
	 * get attention_pic.Attention_pic_dir
	 * @return 注意事项图片物理路径
	 */
	public String getAttentionPicDir() {
		return this.attentionPicDir;
	}

	/**
	 * set attention_pic.Attention_pic_dir
	 * @param 注意事项图片物理路径
	 */
	public void setAttentionPicDir(String attentionPicDir) {
		this.attentionPicDir = attentionPicDir;
	}

	/**
	 * get attention_pic.Attention_pic_create_user
	 * @return 创建人
	 */
	public String getAttentionPicCreateUser() {
		return this.attentionPicCreateUser;
	}

	/**
	 * set attention_pic.Attention_pic_create_user
	 * @param 创建人
	 */
	public void setAttentionPicCreateUser(String attentionPicCreateUser) {
		this.attentionPicCreateUser = attentionPicCreateUser;
	}

	/**
	 * get attention_pic.Attention_pic_create_date
	 * @return 创建时间
	 */
	public String getAttentionPicCreateDate() {
		return this.attentionPicCreateDate;
	}

	/**
	 * set attention_pic.Attention_pic_create_date
	 * @param 创建时间
	 */
	public void setAttentionPicCreateDate(String attentionPicCreateDate) {
		this.attentionPicCreateDate = attentionPicCreateDate;
	}

	/**
	 * get attention_pic.Attention_pic_update_user
	 * @return 更新人
	 */
	public String getAttentionPicUpdateUser() {
		return this.attentionPicUpdateUser;
	}

	/**
	 * set attention_pic.Attention_pic_update_user
	 * @param 更新人
	 */
	public void setAttentionPicUpdateUser(String attentionPicUpdateUser) {
		this.attentionPicUpdateUser = attentionPicUpdateUser;
	}

	/**
	 * get attention_pic.Attention_pic_update_date
	 * @return 更新时间
	 */
	public String getAttentionPicUpdateDate() {
		return this.attentionPicUpdateDate;
	}

	/**
	 * set attention_pic.Attention_pic_update_date
	 * @param 更新时间
	 */
	public void setAttentionPicUpdateDate(String attentionPicUpdateDate) {
		this.attentionPicUpdateDate = attentionPicUpdateDate;
	}

	public  Map<String,Object> returnMap()
	{
		 Map<String,Object> returnMap =new HashMap<String,Object>();
		 	returnMap.put("attentionPicId",this.attentionPicId);
		 	returnMap.put("attentionId",this.attentionId);
		 	returnMap.put("attentionPicUrl",this.attentionPicUrl);
		 	returnMap.put("attentionPicDir",this.attentionPicDir);
		 	returnMap.put("attentionPicCreateUser",this.attentionPicCreateUser);
		 	returnMap.put("attentionPicCreateDate",this.attentionPicCreateDate);
		 	returnMap.put("attentionPicUpdateUser",this.attentionPicUpdateUser);
		 	returnMap.put("attentionPicUpdateDate",this.attentionPicUpdateDate);
		 return returnMap;
	}
}
