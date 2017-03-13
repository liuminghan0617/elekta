package com.makervt.elekta.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.annotation.JSONType;
import com.makervt.core.domain.Page;

/**
 * mapping for question_add_pic
 * meaning 问题补充图片列表
 * @author CodeGenerator
 */
 @JSONType(ignores = {"pageNo", "pageSize", "pageTotal","totalCount","start"})
public class QuestionAddPic extends Page<QuestionAddPic>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * mapping for question_add_pic.question_add_pic_id
	 * meaning 
	 */
	private String questionAddPicId;

	/**
	 * mapping for question_add_pic.user_question_id
	 * meaning 
	 */
	private String userQuestionId;

	/**
	 * mapping for question_add_pic.question_add_pic_url
	 * meaning 图片地址
	 */
	private String questionAddPicUrl;

	/**
	 * mapping for question_add_pic.question_add_pic_dir
	 * meaning 图片物理地址
	 */
	private String questionAddPicDir;

	/**
	 * mapping for question_add_pic.question_add_pic_create_user
	 * meaning 创建人
	 */
	private String questionAddPicCreateUser;

	/**
	 * mapping for question_add_pic.question_add_pic_create_date
	 * meaning 创建时间
	 */
	private String questionAddPicCreateDate;

	/**
	 * mapping for question_add_pic.question_add_pic_update_user
	 * meaning 更新人
	 */
	private String questionAddPicUpdateUser;

	/**
	 * mapping for question_add_pic.question_add_pic_update_date
	 * meaning 更新时间
	 */
	private String questionAddPicUpdateDate;

	/**
	 * get question_add_pic.question_add_pic_id
	 * @return 
	 */
	public String getQuestionAddPicId() {
		return this.questionAddPicId;
	}

	/**
	 * set question_add_pic.question_add_pic_id
	 * @param 
	 */
	public void setQuestionAddPicId(String questionAddPicId) {
		this.questionAddPicId = questionAddPicId;
	}

	/**
	 * get question_add_pic.user_question_id
	 * @return 
	 */
	public String getUserQuestionId() {
		return this.userQuestionId;
	}

	/**
	 * set question_add_pic.user_question_id
	 * @param 
	 */
	public void setUserQuestionId(String userQuestionId) {
		this.userQuestionId = userQuestionId;
	}

	/**
	 * get question_add_pic.question_add_pic_url
	 * @return 图片地址
	 */
	public String getQuestionAddPicUrl() {
		return this.questionAddPicUrl;
	}

	/**
	 * set question_add_pic.question_add_pic_url
	 * @param 图片地址
	 */
	public void setQuestionAddPicUrl(String questionAddPicUrl) {
		this.questionAddPicUrl = questionAddPicUrl;
	}

	/**
	 * get question_add_pic.question_add_pic_dir
	 * @return 图片物理地址
	 */
	public String getQuestionAddPicDir() {
		return this.questionAddPicDir;
	}

	/**
	 * set question_add_pic.question_add_pic_dir
	 * @param 图片物理地址
	 */
	public void setQuestionAddPicDir(String questionAddPicDir) {
		this.questionAddPicDir = questionAddPicDir;
	}

	/**
	 * get question_add_pic.question_add_pic_create_user
	 * @return 创建人
	 */
	public String getQuestionAddPicCreateUser() {
		return this.questionAddPicCreateUser;
	}

	/**
	 * set question_add_pic.question_add_pic_create_user
	 * @param 创建人
	 */
	public void setQuestionAddPicCreateUser(String questionAddPicCreateUser) {
		this.questionAddPicCreateUser = questionAddPicCreateUser;
	}

	/**
	 * get question_add_pic.question_add_pic_create_date
	 * @return 创建时间
	 */
	public String getQuestionAddPicCreateDate() {
		return this.questionAddPicCreateDate;
	}

	/**
	 * set question_add_pic.question_add_pic_create_date
	 * @param 创建时间
	 */
	public void setQuestionAddPicCreateDate(String questionAddPicCreateDate) {
		this.questionAddPicCreateDate = questionAddPicCreateDate;
	}

	/**
	 * get question_add_pic.question_add_pic_update_user
	 * @return 更新人
	 */
	public String getQuestionAddPicUpdateUser() {
		return this.questionAddPicUpdateUser;
	}

	/**
	 * set question_add_pic.question_add_pic_update_user
	 * @param 更新人
	 */
	public void setQuestionAddPicUpdateUser(String questionAddPicUpdateUser) {
		this.questionAddPicUpdateUser = questionAddPicUpdateUser;
	}

	/**
	 * get question_add_pic.question_add_pic_update_date
	 * @return 更新时间
	 */
	public String getQuestionAddPicUpdateDate() {
		return this.questionAddPicUpdateDate;
	}

	/**
	 * set question_add_pic.question_add_pic_update_date
	 * @param 更新时间
	 */
	public void setQuestionAddPicUpdateDate(String questionAddPicUpdateDate) {
		this.questionAddPicUpdateDate = questionAddPicUpdateDate;
	}

	public  Map<String,Object> returnMap()
	{
		 Map<String,Object> returnMap =new HashMap<String,Object>();
		 	returnMap.put("questionAddPicId",this.questionAddPicId);
		 	returnMap.put("userQuestionId",this.userQuestionId);
		 	returnMap.put("questionAddPicUrl",this.questionAddPicUrl);
		 	returnMap.put("questionAddPicDir",this.questionAddPicDir);
		 	returnMap.put("questionAddPicCreateUser",this.questionAddPicCreateUser);
		 	returnMap.put("questionAddPicCreateDate",this.questionAddPicCreateDate);
		 	returnMap.put("questionAddPicUpdateUser",this.questionAddPicUpdateUser);
		 	returnMap.put("questionAddPicUpdateDate",this.questionAddPicUpdateDate);
		 return returnMap;
	}
}
