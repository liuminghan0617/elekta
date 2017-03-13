package com.makervt.elekta.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.annotation.JSONType;
import com.makervt.core.domain.Page;

/**
 * mapping for exam
 * meaning 问卷
 * @author CodeGenerator
 */
 @JSONType(ignores = {"pageNo", "pageSize", "pageTotal","totalCount","start"})
public class Exam extends Page<Exam>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<Question> questions=new ArrayList<Question>();
	
	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	/**
	 * mapping for exam.Exam_id
	 * meaning 
	 */
	private String examId;

	/**
	 * mapping for exam.Exam_title
	 * meaning 问卷标题
	 */
	private String examTitle;

	/**
	 * mapping for exam.Exam_summary
	 * meaning 问卷摘要
	 */
	private String examSummary;

	/**
	 * mapping for exam.Exam_total
	 * meaning 总共题数
	 */
	private String examTotal;

	/**
	 * mapping for exam.Exam_doctor_word
	 * meaning 医师寄语
	 */
	private String examDoctorWord;

	/**
	 * mapping for exam.Exam_create_user
	 * meaning 创建人
	 */
	private String examCreateUser;

	/**
	 * mapping for exam.Exam_create_date
	 * meaning 创建时间
	 */
	private String examCreateDate;

	/**
	 * mapping for exam.Exam_update_user
	 * meaning 更新人
	 */
	private String examUpdateUser;

	/**
	 * mapping for exam.Exam_update_date
	 * meaning 更新时间
	 */
	private String examUpdateDate;

	/**
	 * get exam.Exam_id
	 * @return 
	 */
	public String getExamId() {
		return this.examId;
	}

	/**
	 * set exam.Exam_id
	 * @param 
	 */
	public void setExamId(String examId) {
		this.examId = examId;
	}

	/**
	 * get exam.Exam_title
	 * @return 问卷标题
	 */
	public String getExamTitle() {
		return this.examTitle;
	}

	/**
	 * set exam.Exam_title
	 * @param 问卷标题
	 */
	public void setExamTitle(String examTitle) {
		this.examTitle = examTitle;
	}

	/**
	 * get exam.Exam_summary
	 * @return 问卷摘要
	 */
	public String getExamSummary() {
		return this.examSummary;
	}

	/**
	 * set exam.Exam_summary
	 * @param 问卷摘要
	 */
	public void setExamSummary(String examSummary) {
		this.examSummary = examSummary;
	}

	/**
	 * get exam.Exam_total
	 * @return 总共题数
	 */
	public String getExamTotal() {
		return this.examTotal;
	}

	/**
	 * set exam.Exam_total
	 * @param 总共题数
	 */
	public void setExamTotal(String examTotal) {
		this.examTotal = examTotal;
	}

	/**
	 * get exam.Exam_doctor_word
	 * @return 医师寄语
	 */
	public String getExamDoctorWord() {
		return this.examDoctorWord;
	}

	/**
	 * set exam.Exam_doctor_word
	 * @param 医师寄语
	 */
	public void setExamDoctorWord(String examDoctorWord) {
		this.examDoctorWord = examDoctorWord;
	}

	/**
	 * get exam.Exam_create_user
	 * @return 创建人
	 */
	public String getExamCreateUser() {
		return this.examCreateUser;
	}

	/**
	 * set exam.Exam_create_user
	 * @param 创建人
	 */
	public void setExamCreateUser(String examCreateUser) {
		this.examCreateUser = examCreateUser;
	}

	/**
	 * get exam.Exam_create_date
	 * @return 创建时间
	 */
	public String getExamCreateDate() {
		return this.examCreateDate;
	}

	/**
	 * set exam.Exam_create_date
	 * @param 创建时间
	 */
	public void setExamCreateDate(String examCreateDate) {
		this.examCreateDate = examCreateDate;
	}

	/**
	 * get exam.Exam_update_user
	 * @return 更新人
	 */
	public String getExamUpdateUser() {
		return this.examUpdateUser;
	}

	/**
	 * set exam.Exam_update_user
	 * @param 更新人
	 */
	public void setExamUpdateUser(String examUpdateUser) {
		this.examUpdateUser = examUpdateUser;
	}

	/**
	 * get exam.Exam_update_date
	 * @return 更新时间
	 */
	public String getExamUpdateDate() {
		return this.examUpdateDate;
	}

	/**
	 * set exam.Exam_update_date
	 * @param 更新时间
	 */
	public void setExamUpdateDate(String examUpdateDate) {
		this.examUpdateDate = examUpdateDate;
	}

	public  Map<String,Object> returnMap()
	{
		 Map<String,Object> returnMap =new HashMap<String,Object>();
		 	returnMap.put("examId",this.examId);
		 	returnMap.put("examTitle",this.examTitle);
		 	returnMap.put("examSummary",this.examSummary);
		 	returnMap.put("examTotal",this.examTotal);
		 	returnMap.put("examDoctorWord",this.examDoctorWord);
		 	returnMap.put("examCreateUser",this.examCreateUser);
		 	returnMap.put("examCreateDate",this.examCreateDate);
		 	returnMap.put("examUpdateUser",this.examUpdateUser);
		 	returnMap.put("examUpdateDate",this.examUpdateDate);
		 return returnMap;
	}
}
