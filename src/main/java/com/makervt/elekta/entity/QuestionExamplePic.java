package com.makervt.elekta.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.annotation.JSONType;
import com.makervt.core.domain.Page;

/**
 * mapping for question_example_pic
 * meaning 问题图例信息的图片
 * @author CodeGenerator
 */
 @JSONType(ignores = {"pageNo", "pageSize", "pageTotal","totalCount","start"})
public class QuestionExamplePic extends Page<QuestionExamplePic>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * mapping for question_example_pic.question_example_pic_id
	 * meaning 
	 */
	private String questionExamplePicId;

	/**
	 * mapping for question_example_pic.question_id
	 * meaning 
	 */
	private String questionId;

	/**
	 * mapping for question_example_pic.question_example_pic_url
	 * meaning 图例图片访问路径
	 */
	private String questionExamplePicUrl;

	/**
	 * mapping for question_example_pic.question_example_pic_dir
	 * meaning 图例图片物理存储路径
	 */
	private String questionExamplePicDir;

	/**
	 * mapping for question_example_pic.question_example_pic_create_user
	 * meaning 创建人
	 */
	private String questionExamplePicCreateUser;

	/**
	 * mapping for question_example_pic.question_example_pic_create_date
	 * meaning 创建时间
	 */
	private String questionExamplePicCreateDate;

	/**
	 * mapping for question_example_pic.question_example_pic_update_user
	 * meaning 更新人
	 */
	private String questionExamplePicUpdateUser;

	/**
	 * mapping for question_example_pic.question_example_pic_update_date
	 * meaning 更新时间
	 */
	private String questionExamplePicUpdateDate;

	/**
	 * get question_example_pic.question_example_pic_id
	 * @return 
	 */
	public String getQuestionExamplePicId() {
		return this.questionExamplePicId;
	}

	/**
	 * set question_example_pic.question_example_pic_id
	 * @param 
	 */
	public void setQuestionExamplePicId(String questionExamplePicId) {
		this.questionExamplePicId = questionExamplePicId;
	}

	/**
	 * get question_example_pic.question_id
	 * @return 
	 */
	public String getQuestionId() {
		return this.questionId;
	}

	/**
	 * set question_example_pic.question_id
	 * @param 
	 */
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	/**
	 * get question_example_pic.question_example_pic_url
	 * @return 图例图片访问路径
	 */
	public String getQuestionExamplePicUrl() {
		return this.questionExamplePicUrl;
	}

	/**
	 * set question_example_pic.question_example_pic_url
	 * @param 图例图片访问路径
	 */
	public void setQuestionExamplePicUrl(String questionExamplePicUrl) {
		this.questionExamplePicUrl = questionExamplePicUrl;
	}

	/**
	 * get question_example_pic.question_example_pic_dir
	 * @return 图例图片物理存储路径
	 */
	public String getQuestionExamplePicDir() {
		return this.questionExamplePicDir;
	}

	/**
	 * set question_example_pic.question_example_pic_dir
	 * @param 图例图片物理存储路径
	 */
	public void setQuestionExamplePicDir(String questionExamplePicDir) {
		this.questionExamplePicDir = questionExamplePicDir;
	}

	/**
	 * get question_example_pic.question_example_pic_create_user
	 * @return 创建人
	 */
	public String getQuestionExamplePicCreateUser() {
		return this.questionExamplePicCreateUser;
	}

	/**
	 * set question_example_pic.question_example_pic_create_user
	 * @param 创建人
	 */
	public void setQuestionExamplePicCreateUser(String questionExamplePicCreateUser) {
		this.questionExamplePicCreateUser = questionExamplePicCreateUser;
	}

	/**
	 * get question_example_pic.question_example_pic_create_date
	 * @return 创建时间
	 */
	public String getQuestionExamplePicCreateDate() {
		return this.questionExamplePicCreateDate;
	}

	/**
	 * set question_example_pic.question_example_pic_create_date
	 * @param 创建时间
	 */
	public void setQuestionExamplePicCreateDate(String questionExamplePicCreateDate) {
		this.questionExamplePicCreateDate = questionExamplePicCreateDate;
	}

	/**
	 * get question_example_pic.question_example_pic_update_user
	 * @return 更新人
	 */
	public String getQuestionExamplePicUpdateUser() {
		return this.questionExamplePicUpdateUser;
	}

	/**
	 * set question_example_pic.question_example_pic_update_user
	 * @param 更新人
	 */
	public void setQuestionExamplePicUpdateUser(String questionExamplePicUpdateUser) {
		this.questionExamplePicUpdateUser = questionExamplePicUpdateUser;
	}

	/**
	 * get question_example_pic.question_example_pic_update_date
	 * @return 更新时间
	 */
	public String getQuestionExamplePicUpdateDate() {
		return this.questionExamplePicUpdateDate;
	}

	/**
	 * set question_example_pic.question_example_pic_update_date
	 * @param 更新时间
	 */
	public void setQuestionExamplePicUpdateDate(String questionExamplePicUpdateDate) {
		this.questionExamplePicUpdateDate = questionExamplePicUpdateDate;
	}

	public  Map<String,Object> returnMap()
	{
		 Map<String,Object> returnMap =new HashMap<String,Object>();
		 	returnMap.put("questionExamplePicId",this.questionExamplePicId);
		 	returnMap.put("questionId",this.questionId);
		 	returnMap.put("questionExamplePicUrl",this.questionExamplePicUrl);
		 	returnMap.put("questionExamplePicDir",this.questionExamplePicDir);
		 	returnMap.put("questionExamplePicCreateUser",this.questionExamplePicCreateUser);
		 	returnMap.put("questionExamplePicCreateDate",this.questionExamplePicCreateDate);
		 	returnMap.put("questionExamplePicUpdateUser",this.questionExamplePicUpdateUser);
		 	returnMap.put("questionExamplePicUpdateDate",this.questionExamplePicUpdateDate);
		 return returnMap;
	}
}
