package com.makervt.elekta.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.annotation.JSONType;
import com.makervt.core.domain.Page;

/**
 * mapping for user_exam
 * meaning 用户答卷
 * @author CodeGenerator
 */
 @JSONType(ignores = {"pageNo", "pageSize", "pageTotal","totalCount","start"})
public class UserExam extends Page<UserExam>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * mapping for user_exam.user_exam_id
	 * meaning 
	 */
	private String userExamId;

	/**
	 * mapping for user_exam.Exam_id
	 * meaning 
	 */
	private String examId;

	/**
	 * mapping for user_exam.User_id
	 * meaning 
	 */
	private String userId;

	/**
	 * mapping for user_exam.user_Exam_title
	 * meaning 问卷标题
	 */
	private String userExamTitle;

	/**
	 * mapping for user_exam.user_Exam_summary
	 * meaning 问卷摘要
	 */
	private String userExamSummary;

	/**
	 * mapping for user_exam.user_Exam_total
	 * meaning 总共题数
	 */
	private String userExamTotal;

	/**
	 * mapping for user_exam.user_Exam_doctor_word
	 * meaning 医师寄语
	 */
	private String userExamDoctorWord;

	/**
	 * mapping for user_exam.user_Exam_Progress
	 * meaning 进展状态(0未开始　1 进行中)
	 */
	private String userExamProgress;

	/**
	 * mapping for user_exam.user_exam_finish
	 * meaning 已经完成数量
	 */
	private String userExamFinish;

	/**
	 * mapping for user_exam.user_exam_doctor_id
	 * meaning 用户主治医师标识
	 */
	private String userExamDoctorId;

	/**
	 * mapping for user_exam.user_exam_doctor_name
	 * meaning 用户主治医师姓名
	 */
	private String userExamDoctorName;

	/**
	 * mapping for user_exam.user_exam_start_date
	 * meaning 用户试卷下发时间
	 */
	private String userExamStartDate;

	/**
	 * mapping for user_exam.user_exam_expire_Date
	 * meaning 用户试卷过期时间
	 */
	private String userExamExpireDate;

	/**
	 * mapping for user_exam.user_Exam_create_date
	 * meaning 创建时间
	 */
	private String userExamCreateDate;

	/**
	 * mapping for user_exam.user_Exam_update_date
	 * meaning 更新时间
	 */
	private String userExamUpdateDate;

	/**
	 * mapping for user_exam.user_exam_feedback
	 * meaning 用户问卷反馈
	 */
	private String userExamFeedback;

	/**
	 * mapping for user_exam.user_exam_status
	 * meaning 问卷状态(0未开始　1 进行中 2已完成)
	 */
	private String userExamStatus;

	/**
	 * get user_exam.user_exam_id
	 * @return 
	 */
	public String getUserExamId() {
		return this.userExamId;
	}

	/**
	 * set user_exam.user_exam_id
	 * @param 
	 */
	public void setUserExamId(String userExamId) {
		this.userExamId = userExamId;
	}

	/**
	 * get user_exam.Exam_id
	 * @return 
	 */
	public String getExamId() {
		return this.examId;
	}

	/**
	 * set user_exam.Exam_id
	 * @param 
	 */
	public void setExamId(String examId) {
		this.examId = examId;
	}

	/**
	 * get user_exam.User_id
	 * @return 
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * set user_exam.User_id
	 * @param 
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * get user_exam.user_Exam_title
	 * @return 问卷标题
	 */
	public String getUserExamTitle() {
		return this.userExamTitle;
	}

	/**
	 * set user_exam.user_Exam_title
	 * @param 问卷标题
	 */
	public void setUserExamTitle(String userExamTitle) {
		this.userExamTitle = userExamTitle;
	}

	/**
	 * get user_exam.user_Exam_summary
	 * @return 问卷摘要
	 */
	public String getUserExamSummary() {
		return this.userExamSummary;
	}

	/**
	 * set user_exam.user_Exam_summary
	 * @param 问卷摘要
	 */
	public void setUserExamSummary(String userExamSummary) {
		this.userExamSummary = userExamSummary;
	}

	/**
	 * get user_exam.user_Exam_total
	 * @return 总共题数
	 */
	public String getUserExamTotal() {
		return this.userExamTotal;
	}

	/**
	 * set user_exam.user_Exam_total
	 * @param 总共题数
	 */
	public void setUserExamTotal(String userExamTotal) {
		this.userExamTotal = userExamTotal;
	}

	/**
	 * get user_exam.user_Exam_doctor_word
	 * @return 医师寄语
	 */
	public String getUserExamDoctorWord() {
		return this.userExamDoctorWord;
	}

	/**
	 * set user_exam.user_Exam_doctor_word
	 * @param 医师寄语
	 */
	public void setUserExamDoctorWord(String userExamDoctorWord) {
		this.userExamDoctorWord = userExamDoctorWord;
	}

	/**
	 * get user_exam.user_Exam_Progress
	 * @return 进展状态(0未开始　1 进行中)
	 */
	public String getUserExamProgress() {
		return this.userExamProgress;
	}

	/**
	 * set user_exam.user_Exam_Progress
	 * @param 进展状态(0未开始　1 进行中)
	 */
	public void setUserExamProgress(String userExamProgress) {
		this.userExamProgress = userExamProgress;
	}

	/**
	 * get user_exam.user_exam_finish
	 * @return 已经完成数量
	 */
	public String getUserExamFinish() {
		return this.userExamFinish;
	}

	/**
	 * set user_exam.user_exam_finish
	 * @param 已经完成数量
	 */
	public void setUserExamFinish(String userExamFinish) {
		this.userExamFinish = userExamFinish;
	}

	/**
	 * get user_exam.user_exam_doctor_id
	 * @return 用户主治医师标识
	 */
	public String getUserExamDoctorId() {
		return this.userExamDoctorId;
	}

	/**
	 * set user_exam.user_exam_doctor_id
	 * @param 用户主治医师标识
	 */
	public void setUserExamDoctorId(String userExamDoctorId) {
		this.userExamDoctorId = userExamDoctorId;
	}

	/**
	 * get user_exam.user_exam_doctor_name
	 * @return 用户主治医师姓名
	 */
	public String getUserExamDoctorName() {
		return this.userExamDoctorName;
	}

	/**
	 * set user_exam.user_exam_doctor_name
	 * @param 用户主治医师姓名
	 */
	public void setUserExamDoctorName(String userExamDoctorName) {
		this.userExamDoctorName = userExamDoctorName;
	}

	/**
	 * get user_exam.user_exam_start_date
	 * @return 用户试卷下发时间
	 */
	public String getUserExamStartDate() {
		return this.userExamStartDate;
	}

	/**
	 * set user_exam.user_exam_start_date
	 * @param 用户试卷下发时间
	 */
	public void setUserExamStartDate(String userExamStartDate) {
		this.userExamStartDate = userExamStartDate;
	}

	/**
	 * get user_exam.user_exam_expire_Date
	 * @return 用户试卷过期时间
	 */
	public String getUserExamExpireDate() {
		return this.userExamExpireDate;
	}

	/**
	 * set user_exam.user_exam_expire_Date
	 * @param 用户试卷过期时间
	 */
	public void setUserExamExpireDate(String userExamExpireDate) {
		this.userExamExpireDate = userExamExpireDate;
	}

	/**
	 * get user_exam.user_Exam_create_date
	 * @return 创建时间
	 */
	public String getUserExamCreateDate() {
		return this.userExamCreateDate;
	}

	/**
	 * set user_exam.user_Exam_create_date
	 * @param 创建时间
	 */
	public void setUserExamCreateDate(String userExamCreateDate) {
		this.userExamCreateDate = userExamCreateDate;
	}

	/**
	 * get user_exam.user_Exam_update_date
	 * @return 更新时间
	 */
	public String getUserExamUpdateDate() {
		return this.userExamUpdateDate;
	}

	/**
	 * set user_exam.user_Exam_update_date
	 * @param 更新时间
	 */
	public void setUserExamUpdateDate(String userExamUpdateDate) {
		this.userExamUpdateDate = userExamUpdateDate;
	}

	/**
	 * get user_exam.user_exam_feedback
	 * @return 用户问卷反馈
	 */
	public String getUserExamFeedback() {
		return this.userExamFeedback;
	}

	/**
	 * set user_exam.user_exam_feedback
	 * @param 用户问卷反馈
	 */
	public void setUserExamFeedback(String userExamFeedback) {
		this.userExamFeedback = userExamFeedback;
	}

	/**
	 * get user_exam.user_exam_status
	 * @return 问卷状态(0未开始　1 进行中 2已完成)
	 */
	public String getUserExamStatus() {
		return this.userExamStatus;
	}

	/**
	 * set user_exam.user_exam_status
	 * @param 问卷状态(0未开始　1 进行中 2已完成)
	 */
	public void setUserExamStatus(String userExamStatus) {
		this.userExamStatus = userExamStatus;
	}

	public  Map<String,Object> returnMap()
	{
		 Map<String,Object> returnMap =new HashMap<String,Object>();
		 	returnMap.put("userExamId",this.userExamId);
		 	returnMap.put("examId",this.examId);
		 	returnMap.put("userId",this.userId);
		 	returnMap.put("userExamTitle",this.userExamTitle);
		 	returnMap.put("userExamSummary",this.userExamSummary);
		 	returnMap.put("userExamTotal",this.userExamTotal);
		 	returnMap.put("userExamDoctorWord",this.userExamDoctorWord);
		 	returnMap.put("userExamProgress",this.userExamProgress);
		 	returnMap.put("userExamFinish",this.userExamFinish);
		 	returnMap.put("userExamDoctorId",this.userExamDoctorId);
		 	returnMap.put("userExamDoctorName",this.userExamDoctorName);
		 	returnMap.put("userExamStartDate",this.userExamStartDate);
		 	returnMap.put("userExamExpireDate",this.userExamExpireDate);
		 	returnMap.put("userExamCreateDate",this.userExamCreateDate);
		 	returnMap.put("userExamUpdateDate",this.userExamUpdateDate);
		 	returnMap.put("userExamFeedback",this.userExamFeedback);
		 	returnMap.put("userExamStatus",this.userExamStatus);
		 return returnMap;
	}
}
