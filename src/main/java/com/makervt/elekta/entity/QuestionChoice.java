package com.makervt.elekta.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.annotation.JSONType;
import com.makervt.core.domain.Page;

/**
 * mapping for question_choice
 * meaning 选择题信息
 * @author CodeGenerator
 */
 @JSONType(ignores = {"pageNo", "pageSize", "pageTotal","totalCount","start"})
public class QuestionChoice extends Page<QuestionChoice>{

	 public QuestionChoice() {
			super();
		}

	public QuestionChoice(String questionChoiceId,String questionChoiceItem, String questionChoiceItemName, String questionChoicePicUrl) {
		super();
		this.questionChoiceId=questionChoiceId;
		this.questionChoiceItem = questionChoiceItem;
		this.questionChoiceItemName = questionChoiceItemName;
		this.questionChoicePicUrl = questionChoicePicUrl;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * mapping for question_choice.question_Choice_id
	 * meaning 选择题选项标识
	 */
	private String questionChoiceId;

	/**
	 * mapping for question_choice.question_id
	 * meaning 
	 */
	private String questionId;

	/**
	 * mapping for question_choice.question_Choice_item
	 * meaning 选项标识如（ａ、b、c、d）
	 */
	private String questionChoiceItem;

	/**
	 * mapping for question_choice.question_Choice_item_name
	 * meaning 选项名称
	 */
	private String questionChoiceItemName;

	/**
	 * mapping for question_choice.question_Choice_pic_url
	 * meaning 图片访问url
	 */
	private String questionChoicePicUrl;

	/**
	 * mapping for question_choice.question_Choice_dir
	 * meaning 图片物理路径
	 */
	private String questionChoiceDir;

	/**
	 * mapping for question_choice.question_Choice_create_user
	 * meaning 创建人
	 */
	private String questionChoiceCreateUser;

	/**
	 * mapping for question_choice.question_Choice_create_date
	 * meaning 创建时间
	 */
	private String questionChoiceCreateDate;

	/**
	 * mapping for question_choice.question_Choice_update_user
	 * meaning 更新人
	 */
	private String questionChoiceUpdateUser;

	/**
	 * mapping for question_choice.question_Choice_update_date
	 * meaning 更新时间
	 */
	private String questionChoiceUpdateDate;
	
	private int subtitleFlag = 0;
	
	/**
	 * get question_choice.question_Choice_id
	 * @return 选择题选项标识
	 */
	public String getQuestionChoiceId() {
		return this.questionChoiceId;
	}

	/**
	 * set question_choice.question_Choice_id
	 * @param 选择题选项标识
	 */
	public void setQuestionChoiceId(String questionChoiceId) {
		this.questionChoiceId = questionChoiceId;
	}

	/**
	 * get question_choice.question_id
	 * @return 
	 */
	public String getQuestionId() {
		return this.questionId;
	}

	/**
	 * set question_choice.question_id
	 * @param 
	 */
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	/**
	 * get question_choice.question_Choice_item
	 * @return 选项标识如（ａ、b、c、d）
	 */
	public String getQuestionChoiceItem() {
		return this.questionChoiceItem;
	}

	/**
	 * set question_choice.question_Choice_item
	 * @param 选项标识如（ａ、b、c、d）
	 */
	public void setQuestionChoiceItem(String questionChoiceItem) {
		this.questionChoiceItem = questionChoiceItem;
	}

	/**
	 * get question_choice.question_Choice_item_name
	 * @return 选项名称
	 */
	public String getQuestionChoiceItemName() {
		return this.questionChoiceItemName;
	}

	/**
	 * set question_choice.question_Choice_item_name
	 * @param 选项名称
	 */
	public void setQuestionChoiceItemName(String questionChoiceItemName) {
		this.questionChoiceItemName = questionChoiceItemName;
	}

	/**
	 * get question_choice.question_Choice_pic_url
	 * @return 图片访问url
	 */
	public String getQuestionChoicePicUrl() {
		return this.questionChoicePicUrl;
	}

	/**
	 * set question_choice.question_Choice_pic_url
	 * @param 图片访问url
	 */
	public void setQuestionChoicePicUrl(String questionChoicePicUrl) {
		this.questionChoicePicUrl = questionChoicePicUrl;
	}

	/**
	 * get question_choice.question_Choice_dir
	 * @return 图片物理路径
	 */
	public String getQuestionChoiceDir() {
		return this.questionChoiceDir;
	}

	/**
	 * set question_choice.question_Choice_dir
	 * @param 图片物理路径
	 */
	public void setQuestionChoiceDir(String questionChoiceDir) {
		this.questionChoiceDir = questionChoiceDir;
	}

	/**
	 * get question_choice.question_Choice_create_user
	 * @return 创建人
	 */
	public String getQuestionChoiceCreateUser() {
		return this.questionChoiceCreateUser;
	}

	/**
	 * set question_choice.question_Choice_create_user
	 * @param 创建人
	 */
	public void setQuestionChoiceCreateUser(String questionChoiceCreateUser) {
		this.questionChoiceCreateUser = questionChoiceCreateUser;
	}

	/**
	 * get question_choice.question_Choice_create_date
	 * @return 创建时间
	 */
	public String getQuestionChoiceCreateDate() {
		return this.questionChoiceCreateDate;
	}

	/**
	 * set question_choice.question_Choice_create_date
	 * @param 创建时间
	 */
	public void setQuestionChoiceCreateDate(String questionChoiceCreateDate) {
		this.questionChoiceCreateDate = questionChoiceCreateDate;
	}

	/**
	 * get question_choice.question_Choice_update_user
	 * @return 更新人
	 */
	public String getQuestionChoiceUpdateUser() {
		return this.questionChoiceUpdateUser;
	}

	/**
	 * set question_choice.question_Choice_update_user
	 * @param 更新人
	 */
	public void setQuestionChoiceUpdateUser(String questionChoiceUpdateUser) {
		this.questionChoiceUpdateUser = questionChoiceUpdateUser;
	}

	/**
	 * get question_choice.question_Choice_update_date
	 * @return 更新时间
	 */
	public String getQuestionChoiceUpdateDate() {
		return this.questionChoiceUpdateDate;
	}

	/**
	 * set question_choice.question_Choice_update_date
	 * @param 更新时间
	 */
	public void setQuestionChoiceUpdateDate(String questionChoiceUpdateDate) {
		this.questionChoiceUpdateDate = questionChoiceUpdateDate;
	}

	public  Map<String,Object> returnMap()
	{
		 Map<String,Object> returnMap =new HashMap<String,Object>();
		 	returnMap.put("questionChoiceId",this.questionChoiceId);
		 	returnMap.put("questionId",this.questionId);
		 	returnMap.put("questionChoiceItem",this.questionChoiceItem);
		 	returnMap.put("questionChoiceItemName",this.questionChoiceItemName);
		 	returnMap.put("questionChoicePicUrl",this.questionChoicePicUrl);
		 	returnMap.put("questionChoiceDir",this.questionChoiceDir);
		 	returnMap.put("questionChoiceCreateUser",this.questionChoiceCreateUser);
		 	returnMap.put("questionChoiceCreateDate",this.questionChoiceCreateDate);
		 	returnMap.put("questionChoiceUpdateUser",this.questionChoiceUpdateUser);
		 	returnMap.put("questionChoiceUpdateDate",this.questionChoiceUpdateDate);
		 return returnMap;
	}

	public int getSubtitleFlag() {
		return subtitleFlag;
	}

	public void setSubtitleFlag(int subtitleFlag) {
		this.subtitleFlag = subtitleFlag;
	}
}
