package com.makervt.elekta.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.annotation.JSONType;
import com.makervt.core.domain.Page;

/**
 * mapping for question
 * meaning 问题
 * @author CodeGenerator
 */
 @JSONType(ignores = {"pageNo", "pageSize", "pageTotal","totalCount","start"})
public class Question extends Page<Question>{


	public Question() {
		super();
	}

	public Question(List<QuestionChoice> choiceItems, String questionId, String examId, String questionNo,
			String questionTitle, String questionType, String questionMultiChoice, String questionExampleContent,String parentId) {
		super();
		this.choiceItems = choiceItems;
		this.questionId = questionId;
		this.examId = examId;
		this.questionNo = questionNo;
		this.questionTitle = questionTitle;
		this.questionType = questionType;
		this.questionMultiChoice = questionMultiChoice;
		this.questionExampleContent = questionExampleContent;
		this.parentId = parentId;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private List<QuestionChoice> choiceItems=new ArrayList<QuestionChoice>();
	
	private List<QuestionExamplePic> examplePic=new ArrayList<QuestionExamplePic>();
	
	/**
	 * mapping for question.question_id
	 * meaning 
	 */
	private String questionId;

	/**
	 * mapping for question.Exam_id
	 * meaning 
	 */
	private String examId;

	/**
	 * mapping for question.question_no
	 * meaning 问题序号
	 */
	private String questionNo;

	/**
	 * mapping for question.question_title
	 * meaning 问题题目标题
	 */
	private String questionTitle;

	/**
	 * mapping for question.question_type
	 * meaning 问题类型（word :文字选择题  pic : 图片选择题　desc : 简答题）
	 */
	private String questionType;

	/**
	 * mapping for question.question_multi_choice
	 * meaning 是否是多选 0 单选 1多选
	 */
	private String questionMultiChoice;

	/**
	 * mapping for question.question_example_content
	 * meaning 问题图例html
	 */
	private String questionExampleContent;

	/**
	 * mapping for question.question_additional_create_user
	 * meaning 创建人
	 */
	private String questionAdditionalCreateUser;

	/**
	 * mapping for question.question_additional_create_date
	 * meaning 创建时间
	 */
	private String questionAdditionalCreateDate;

	/**
	 * mapping for question.question_additional_update_user
	 * meaning 更新人
	 */
	private String questionAdditionalUpdateUser;

	/**
	 * mapping for question.question_additional_update_date
	 * meaning 更新时间
	 */
	private String questionAdditionalUpdateDate;

	private String parentId;
	/**
	 * get question.question_id
	 * @return 
	 */
	public String getQuestionId() {
		return this.questionId;
	}

	/**
	 * set question.question_id
	 * @param 
	 */
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	/**
	 * get question.Exam_id
	 * @return 
	 */
	public String getExamId() {
		return this.examId;
	}

	/**
	 * set question.Exam_id
	 * @param 
	 */
	public void setExamId(String examId) {
		this.examId = examId;
	}

	/**
	 * get question.question_no
	 * @return 问题序号
	 */
	public String getQuestionNo() {
		return this.questionNo;
	}

	/**
	 * set question.question_no
	 * @param 问题序号
	 */
	public void setQuestionNo(String questionNo) {
		this.questionNo = questionNo;
	}

	/**
	 * get question.question_title
	 * @return 问题题目标题
	 */
	public String getQuestionTitle() {
		return this.questionTitle;
	}

	/**
	 * set question.question_title
	 * @param 问题题目标题
	 */
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	/**
	 * get question.question_type
	 * @return 问题类型（word :文字选择题  pic : 图片选择题　desc : 简答题）
	 */
	public String getQuestionType() {
		return this.questionType;
	}

	/**
	 * set question.question_type
	 * @param 问题类型（word :文字选择题  pic : 图片选择题　desc : 简答题）
	 */
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	/**
	 * get question.question_multi_choice
	 * @return 是否是多选 0 单选 1多选
	 */
	public String getQuestionMultiChoice() {
		return this.questionMultiChoice;
	}

	/**
	 * set question.question_multi_choice
	 * @param 是否是多选 0 单选 1多选
	 */
	public void setQuestionMultiChoice(String questionMultiChoice) {
		this.questionMultiChoice = questionMultiChoice;
	}

	/**
	 * get question.question_example_content
	 * @return 问题图例html
	 */
	public String getQuestionExampleContent() {
		return this.questionExampleContent;
	}

	/**
	 * set question.question_example_content
	 * @param 问题图例html
	 */
	public void setQuestionExampleContent(String questionExampleContent) {
		this.questionExampleContent = questionExampleContent;
	}

	/**
	 * get question.question_additional_create_user
	 * @return 创建人
	 */
	public String getQuestionAdditionalCreateUser() {
		return this.questionAdditionalCreateUser;
	}

	/**
	 * set question.question_additional_create_user
	 * @param 创建人
	 */
	public void setQuestionAdditionalCreateUser(String questionAdditionalCreateUser) {
		this.questionAdditionalCreateUser = questionAdditionalCreateUser;
	}

	/**
	 * get question.question_additional_create_date
	 * @return 创建时间
	 */
	public String getQuestionAdditionalCreateDate() {
		return this.questionAdditionalCreateDate;
	}

	/**
	 * set question.question_additional_create_date
	 * @param 创建时间
	 */
	public void setQuestionAdditionalCreateDate(String questionAdditionalCreateDate) {
		this.questionAdditionalCreateDate = questionAdditionalCreateDate;
	}

	/**
	 * get question.question_additional_update_user
	 * @return 更新人
	 */
	public String getQuestionAdditionalUpdateUser() {
		return this.questionAdditionalUpdateUser;
	}

	/**
	 * set question.question_additional_update_user
	 * @param 更新人
	 */
	public void setQuestionAdditionalUpdateUser(String questionAdditionalUpdateUser) {
		this.questionAdditionalUpdateUser = questionAdditionalUpdateUser;
	}

	/**
	 * get question.question_additional_update_date
	 * @return 更新时间
	 */
	public String getQuestionAdditionalUpdateDate() {
		return this.questionAdditionalUpdateDate;
	}

	/**
	 * set question.question_additional_update_date
	 * @param 更新时间
	 */
	public void setQuestionAdditionalUpdateDate(String questionAdditionalUpdateDate) {
		this.questionAdditionalUpdateDate = questionAdditionalUpdateDate;
	}

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
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public  Map<String,Object> returnMap()
	{
		 Map<String,Object> returnMap =new HashMap<String,Object>();
		 	returnMap.put("questionId",this.questionId);
		 	returnMap.put("examId",this.examId);
		 	returnMap.put("questionNo",this.questionNo);
		 	returnMap.put("questionTitle",this.questionTitle);
		 	returnMap.put("questionType",this.questionType);
		 	returnMap.put("questionMultiChoice",this.questionMultiChoice);
		 	returnMap.put("questionExampleContent",this.questionExampleContent);
		 	returnMap.put("questionAdditionalCreateUser",this.questionAdditionalCreateUser);
		 	returnMap.put("questionAdditionalCreateDate",this.questionAdditionalCreateDate);
		 	returnMap.put("questionAdditionalUpdateUser",this.questionAdditionalUpdateUser);
		 	returnMap.put("questionAdditionalUpdateDate",this.questionAdditionalUpdateDate);
		 	returnMap.put("parentId",this.parentId);
		 return returnMap;
	}
}
