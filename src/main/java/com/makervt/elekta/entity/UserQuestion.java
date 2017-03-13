package com.makervt.elekta.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.annotation.JSONType;
import com.makervt.core.domain.Page;

/**
 * mapping for user_question
 * meaning 用户答题
 * @author CodeGenerator
 */
 @JSONType(ignores = {"pageNo", "pageSize", "pageTotal","totalCount","start"})
public class UserQuestion extends Page<UserQuestion>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<QuestionChoice> getChoiceItems() {
		return choiceItems;
	}

	public void setChoiceItems(List<QuestionChoice> choiceItems) {
		this.choiceItems = choiceItems;
	}

	public List<QuestionExamplePic> getExamplePic() {
		return examplePic;
	}

	public void setExamplePic(List<QuestionExamplePic> examplePic) {
		this.examplePic = examplePic;
	}

	public List<QuestionAddPic> getQuestionAdditionaPics() {
		return questionAdditionaPics;
	}

	public void setQuestionAdditionaPics(List<QuestionAddPic> questionAdditionaPics) {
		this.questionAdditionaPics = questionAdditionaPics;
	}

	private List<QuestionChoice> choiceItems=new ArrayList<QuestionChoice>();
	
	private List<QuestionExamplePic> examplePic=new ArrayList<QuestionExamplePic>();

	private List<QuestionAddPic> questionAdditionaPics=new ArrayList<QuestionAddPic>();
	/**
	 * mapping for user_question.user_question_id
	 * meaning 
	 */
	private String userQuestionId;

	/**
	 * mapping for user_question.User_id
	 * meaning 
	 */
	private String userId;

	/**
	 * mapping for user_question.user_exam_id
	 * meaning 
	 */
	private String userExamId;

	/**
	 * mapping for user_question.question_id
	 * meaning 
	 */
	private String questionId;

	/**
	 * mapping for user_question.Exam_id
	 * meaning 
	 */
	private String examId;

	/**
	 * mapping for user_question.user_question_no
	 * meaning 回答问题序号
	 */
	private String userQuestionNo;

	/**
	 * mapping for user_question.user_question_answer
	 * meaning 问题回答结果
	 */
	private String userQuestionAnswer;

	/**
	 * mapping for user_question.user_question_status
	 * meaning 回答状态(1 已答 0未答)
	 */
	private String userQuestionStatus;

	/**
	 * mapping for user_question.user_question_additional_text
	 * meaning 问题补充 文字
	 */
	private String userQuestionAdditionalText;

	/**
	 * mapping for user_question.user_question_additional_voice_url
	 * meaning 问题补充语音地址
	 */
	private String userQuestionAdditionalVoiceUrl;

	/**
	 * mapping for user_question.user_question_additional_voice_dir
	 * meaning 问题补充语音物理路径
	 */
	private String userQuestionAdditionalVoiceDir;

	/**
	 * mapping for user_question.user_question_additional_text_time
	 * meaning 问题补充 文字时间
	 */
	private String userQuestionAdditionalTextTime;

	/**
	 * mapping for user_question.user_question_additional_voice_time
	 * meaning 问题补充语音时间
	 */
	private String userQuestionAdditionalVoiceTime;

	/**
	 * mapping for user_question.user_question_additional_pic_time
	 * meaning 问题补充图片时间
	 */
	private String userQuestionAdditionalPicTime;

	/**
	 * mapping for user_question.user_question_answer_create_user
	 * meaning 创建人
	 */
	private String userQuestionAnswerCreateUser;

	/**
	 * mapping for user_question.user_question_answerl_create_date
	 * meaning 创建时间
	 */
	private String userQuestionAnswerlCreateDate;

	/**
	 * mapping for user_question.user_question_answer_update_user
	 * meaning 更新人
	 */
	private String userQuestionAnswerUpdateUser;

	/**
	 * mapping for user_question.user_question_answer_update_date
	 * meaning 更新时间
	 */
	private String userQuestionAnswerUpdateDate;

	/**
	 * mapping for user_question.user_question_title
	 * meaning 问题题目标题
	 */
	private String userQuestionTitle;

	/**
	 * mapping for user_question.user_question_multi_choice
	 * meaning 是否是多选 0 单选 1多选
	 */
	private String userQuestionMultiChoice;

	/**
	 * mapping for user_question.user_question_type
	 * meaning 问题类型（word :文字选择题  pic : 图片选择题　desc : 简答题）
	 */
	private String userQuestionType;

	/**
	 * mapping for user_question.user_question_example_content
	 * meaning 问题图例html
	 */
	private String userQuestionExampleContent;
	
	private String parentId;
	
	private int subtitleFlag = 0;

	/**
	 * get user_question.user_question_id
	 * @return 
	 */
	public String getUserQuestionId() {
		return this.userQuestionId;
	}

	/**
	 * set user_question.user_question_id
	 * @param 
	 */
	public void setUserQuestionId(String userQuestionId) {
		this.userQuestionId = userQuestionId;
	}

	/**
	 * get user_question.User_id
	 * @return 
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * set user_question.User_id
	 * @param 
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * get user_question.user_exam_id
	 * @return 
	 */
	public String getUserExamId() {
		return this.userExamId;
	}

	/**
	 * set user_question.user_exam_id
	 * @param 
	 */
	public void setUserExamId(String userExamId) {
		this.userExamId = userExamId;
	}

	/**
	 * get user_question.question_id
	 * @return 
	 */
	public String getQuestionId() {
		return this.questionId;
	}

	/**
	 * set user_question.question_id
	 * @param 
	 */
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	/**
	 * get user_question.Exam_id
	 * @return 
	 */
	public String getExamId() {
		return this.examId;
	}

	/**
	 * set user_question.Exam_id
	 * @param 
	 */
	public void setExamId(String examId) {
		this.examId = examId;
	}

	/**
	 * get user_question.user_question_no
	 * @return 回答问题序号
	 */
	public String getUserQuestionNo() {
		return this.userQuestionNo;
	}

	/**
	 * set user_question.user_question_no
	 * @param 回答问题序号
	 */
	public void setUserQuestionNo(String userQuestionNo) {
		this.userQuestionNo = userQuestionNo;
	}

	/**
	 * get user_question.user_question_answer
	 * @return 问题回答结果
	 */
	public String getUserQuestionAnswer() {
		return this.userQuestionAnswer;
	}

	/**
	 * set user_question.user_question_answer
	 * @param 问题回答结果
	 */
	public void setUserQuestionAnswer(String userQuestionAnswer) {
		this.userQuestionAnswer = userQuestionAnswer;
	}

	/**
	 * get user_question.user_question_status
	 * @return 回答状态(1 已答 0未答)
	 */
	public String getUserQuestionStatus() {
		return this.userQuestionStatus;
	}

	/**
	 * set user_question.user_question_status
	 * @param 回答状态(1 已答 0未答)
	 */
	public void setUserQuestionStatus(String userQuestionStatus) {
		this.userQuestionStatus = userQuestionStatus;
	}

	/**
	 * get user_question.user_question_additional_text
	 * @return 问题补充 文字
	 */
	public String getUserQuestionAdditionalText() {
		return this.userQuestionAdditionalText;
	}

	/**
	 * set user_question.user_question_additional_text
	 * @param 问题补充 文字
	 */
	public void setUserQuestionAdditionalText(String userQuestionAdditionalText) {
		this.userQuestionAdditionalText = userQuestionAdditionalText;
	}

	/**
	 * get user_question.user_question_additional_voice_url
	 * @return 问题补充语音地址
	 */
	public String getUserQuestionAdditionalVoiceUrl() {
		return this.userQuestionAdditionalVoiceUrl;
	}

	/**
	 * set user_question.user_question_additional_voice_url
	 * @param 问题补充语音地址
	 */
	public void setUserQuestionAdditionalVoiceUrl(String userQuestionAdditionalVoiceUrl) {
		this.userQuestionAdditionalVoiceUrl = userQuestionAdditionalVoiceUrl;
	}

	/**
	 * get user_question.user_question_additional_voice_dir
	 * @return 问题补充语音物理路径
	 */
	public String getUserQuestionAdditionalVoiceDir() {
		return this.userQuestionAdditionalVoiceDir;
	}

	/**
	 * set user_question.user_question_additional_voice_dir
	 * @param 问题补充语音物理路径
	 */
	public void setUserQuestionAdditionalVoiceDir(String userQuestionAdditionalVoiceDir) {
		this.userQuestionAdditionalVoiceDir = userQuestionAdditionalVoiceDir;
	}

	/**
	 * get user_question.user_question_additional_text_time
	 * @return 问题补充 文字时间
	 */
	public String getUserQuestionAdditionalTextTime() {
		return this.userQuestionAdditionalTextTime;
	}

	/**
	 * set user_question.user_question_additional_text_time
	 * @param 问题补充 文字时间
	 */
	public void setUserQuestionAdditionalTextTime(String userQuestionAdditionalTextTime) {
		this.userQuestionAdditionalTextTime = userQuestionAdditionalTextTime;
	}

	/**
	 * get user_question.user_question_additional_voice_time
	 * @return 问题补充语音时间
	 */
	public String getUserQuestionAdditionalVoiceTime() {
		return this.userQuestionAdditionalVoiceTime;
	}

	/**
	 * set user_question.user_question_additional_voice_time
	 * @param 问题补充语音时间
	 */
	public void setUserQuestionAdditionalVoiceTime(String userQuestionAdditionalVoiceTime) {
		this.userQuestionAdditionalVoiceTime = userQuestionAdditionalVoiceTime;
	}

	/**
	 * get user_question.user_question_additional_pic_time
	 * @return 问题补充图片时间
	 */
	public String getUserQuestionAdditionalPicTime() {
		return this.userQuestionAdditionalPicTime;
	}

	/**
	 * set user_question.user_question_additional_pic_time
	 * @param 问题补充图片时间
	 */
	public void setUserQuestionAdditionalPicTime(String userQuestionAdditionalPicTime) {
		this.userQuestionAdditionalPicTime = userQuestionAdditionalPicTime;
	}

	/**
	 * get user_question.user_question_answer_create_user
	 * @return 创建人
	 */
	public String getUserQuestionAnswerCreateUser() {
		return this.userQuestionAnswerCreateUser;
	}

	/**
	 * set user_question.user_question_answer_create_user
	 * @param 创建人
	 */
	public void setUserQuestionAnswerCreateUser(String userQuestionAnswerCreateUser) {
		this.userQuestionAnswerCreateUser = userQuestionAnswerCreateUser;
	}

	/**
	 * get user_question.user_question_answerl_create_date
	 * @return 创建时间
	 */
	public String getUserQuestionAnswerlCreateDate() {
		return this.userQuestionAnswerlCreateDate;
	}

	/**
	 * set user_question.user_question_answerl_create_date
	 * @param 创建时间
	 */
	public void setUserQuestionAnswerlCreateDate(String userQuestionAnswerlCreateDate) {
		this.userQuestionAnswerlCreateDate = userQuestionAnswerlCreateDate;
	}

	/**
	 * get user_question.user_question_answer_update_user
	 * @return 更新人
	 */
	public String getUserQuestionAnswerUpdateUser() {
		return this.userQuestionAnswerUpdateUser;
	}

	/**
	 * set user_question.user_question_answer_update_user
	 * @param 更新人
	 */
	public void setUserQuestionAnswerUpdateUser(String userQuestionAnswerUpdateUser) {
		this.userQuestionAnswerUpdateUser = userQuestionAnswerUpdateUser;
	}

	/**
	 * get user_question.user_question_answer_update_date
	 * @return 更新时间
	 */
	public String getUserQuestionAnswerUpdateDate() {
		return this.userQuestionAnswerUpdateDate;
	}

	/**
	 * set user_question.user_question_answer_update_date
	 * @param 更新时间
	 */
	public void setUserQuestionAnswerUpdateDate(String userQuestionAnswerUpdateDate) {
		this.userQuestionAnswerUpdateDate = userQuestionAnswerUpdateDate;
	}

	/**
	 * get user_question.user_question_title
	 * @return 问题题目标题
	 */
	public String getUserQuestionTitle() {
		return this.userQuestionTitle;
	}

	/**
	 * set user_question.user_question_title
	 * @param 问题题目标题
	 */
	public void setUserQuestionTitle(String userQuestionTitle) {
		this.userQuestionTitle = userQuestionTitle;
	}

	/**
	 * get user_question.user_question_multi_choice
	 * @return 是否是多选 0 单选 1多选
	 */
	public String getUserQuestionMultiChoice() {
		return this.userQuestionMultiChoice;
	}

	/**
	 * set user_question.user_question_multi_choice
	 * @param 是否是多选 0 单选 1多选
	 */
	public void setUserQuestionMultiChoice(String userQuestionMultiChoice) {
		this.userQuestionMultiChoice = userQuestionMultiChoice;
	}

	/**
	 * get user_question.user_question_type
	 * @return 问题类型（word :文字选择题  pic : 图片选择题　desc : 简答题）
	 */
	public String getUserQuestionType() {
		return this.userQuestionType;
	}

	/**
	 * set user_question.user_question_type
	 * @param 问题类型（word :文字选择题  pic : 图片选择题　desc : 简答题）
	 */
	public void setUserQuestionType(String userQuestionType) {
		this.userQuestionType = userQuestionType;
	}

	/**
	 * get user_question.user_question_example_content
	 * @return 问题图例html
	 */
	public String getUserQuestionExampleContent() {
		return this.userQuestionExampleContent;
	}

	/**
	 * set user_question.user_question_example_content
	 * @param 问题图例html
	 */
	public void setUserQuestionExampleContent(String userQuestionExampleContent) {
		this.userQuestionExampleContent = userQuestionExampleContent;
	}

	public  Map<String,Object> returnMap()
	{
		 Map<String,Object> returnMap =new HashMap<String,Object>();
		 	returnMap.put("userQuestionId",this.userQuestionId);
		 	returnMap.put("userId",this.userId);
		 	returnMap.put("userExamId",this.userExamId);
		 	returnMap.put("questionId",this.questionId);
		 	returnMap.put("examId",this.examId);
		 	returnMap.put("userQuestionNo",this.userQuestionNo);
		 	returnMap.put("userQuestionAnswer",this.userQuestionAnswer);
		 	returnMap.put("userQuestionStatus",this.userQuestionStatus);
		 	returnMap.put("userQuestionAdditionalText",this.userQuestionAdditionalText);
		 	returnMap.put("userQuestionAdditionalVoiceUrl",this.userQuestionAdditionalVoiceUrl);
		 	returnMap.put("userQuestionAdditionalVoiceDir",this.userQuestionAdditionalVoiceDir);
		 	returnMap.put("userQuestionAdditionalTextTime",this.userQuestionAdditionalTextTime);
		 	returnMap.put("userQuestionAdditionalVoiceTime",this.userQuestionAdditionalVoiceTime);
		 	returnMap.put("userQuestionAdditionalPicTime",this.userQuestionAdditionalPicTime);
		 	returnMap.put("userQuestionAnswerCreateUser",this.userQuestionAnswerCreateUser);
		 	returnMap.put("userQuestionAnswerlCreateDate",this.userQuestionAnswerlCreateDate);
		 	returnMap.put("userQuestionAnswerUpdateUser",this.userQuestionAnswerUpdateUser);
		 	returnMap.put("userQuestionAnswerUpdateDate",this.userQuestionAnswerUpdateDate);
		 	returnMap.put("userQuestionTitle",this.userQuestionTitle);
		 	returnMap.put("userQuestionMultiChoice",this.userQuestionMultiChoice);
		 	returnMap.put("userQuestionType",this.userQuestionType);
		 	returnMap.put("userQuestionExampleContent",this.userQuestionExampleContent);
		 	returnMap.put("parentId",this.parentId);
		 return returnMap;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public int getSubtitleFlag() {
		return subtitleFlag;
	}

	public void setSubtitleFlag(int subtitleFlag) {
		this.subtitleFlag = subtitleFlag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
