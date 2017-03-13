package com.makervt.elekta.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.makervt.core.cache.AppCache;
import com.makervt.core.domain.Page;
import com.makervt.core.domain.ResponseMessage;
import com.makervt.core.util.DateUtils;
import com.makervt.core.util.FileOperateUtil;
import com.makervt.core.web.BaseController;
import com.makervt.elekta.domain.Schedule;
import com.makervt.elekta.entity.Attention;
import com.makervt.elekta.entity.Exam;
import com.makervt.elekta.entity.Question;
import com.makervt.elekta.entity.UserExam;
import com.makervt.elekta.entity.UserQuestion;
import com.makervt.elekta.service.DoctorService;
import com.makervt.elekta.service.ExamService;
import com.makervt.elekta.service.QuestionService;
import com.makervt.elekta.service.ScheduleService;
import com.makervt.elekta.service.UserExamService;
import com.makervt.elekta.service.UserQuestionService;

@Controller
@RequestMapping(value = "exam")
public class ExamApi extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(ExamApi.class);

	@Autowired
	private UserExamService userExamService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private UserQuestionService userQuestionService;

	@RequestMapping(value = "list.do")
	public @ResponseBody ResponseMessage queryExamList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		UserExam exam = this.getJsonJavaByInterceptor(request, UserExam.class);
		logger.info("method:<queryExamList> param:<{}>", JSONObject.toJSON(exam).toString());
		if (StringUtils.isEmpty(exam.getUserId()))
			return ResponseMessage.createErrorResponse("1101");

		if (!this.isVerfityUser(request, exam.getUserId()))
			return ResponseMessage.createErrorResponse("1106");

		ResponseMessage msg = ResponseMessage.createSuccessResponse("0000");
		Page<List> examList = userExamService.queryPage(exam);
		if(examList != null){
			logger.info("method:<queryExamList> examList:<{}>", examList.getTotalCount());
		}
		
		msg.setData("examList", examList);
		return msg;
	}

	@RequestMapping(value = "count.do")
	public @ResponseBody ResponseMessage countExamList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserExam exam = this.getJsonJavaByInterceptor(request, UserExam.class);

		if (StringUtils.isEmpty(exam.getUserId()))
			return ResponseMessage.createErrorResponse("1101");

		if (!this.isVerfityUser(request, exam.getUserId()))
			return ResponseMessage.createErrorResponse("1106");

		ResponseMessage msg = ResponseMessage.createSuccessResponse("0000");
		Integer count = userExamService.count(exam);
		msg.setData("examCount", count);
		return msg;
	}

	@RequestMapping(value = "listQuestion.do")
	public @ResponseBody ResponseMessage listQuestion(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserQuestion question = this.getJsonJavaByInterceptor(request, UserQuestion.class);
//		logger.info("exam-listQuestion.do question:<{}>", JSONObject.toJSON(question).toString());
		if (StringUtils.isEmpty(question.getUserExamId()))
			return ResponseMessage.createErrorResponse("1116");

		if (StringUtils.isEmpty(question.getUserId()))
			return ResponseMessage.createErrorResponse("1101");

		if (!this.isVerfityUser(request, question.getUserId()))
			return ResponseMessage.createErrorResponse("1106");

		ResponseMessage msg = ResponseMessage.createSuccessResponse("0000");
		List<UserQuestion> questionList = userQuestionService.queryQuestions(question);
//		logger.info("exam-listQuestion.do questionList:<{}>", JSONObject.toJSON(questionList).toString());
		msg.setData("questionList", questionList);
		return msg;
	}

	@RequestMapping(value = "answer.do")
	public @ResponseBody ResponseMessage answerQuestion(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseMessage msg = ResponseMessage.createSuccessResponse("0000");
		String json = ServletRequestUtils.getStringParameter(request, "jsonData");
		if (StringUtils.isEmpty(json))
			return ResponseMessage.createErrorResponse("9999");
		UserQuestion question = JSON.parseObject(json, UserQuestion.class);

		if (StringUtils.isEmpty(question.getUserQuestionId()))
			return ResponseMessage.createErrorResponse("1110");

		if (StringUtils.isEmpty(question.getUserQuestionAnswer()))
			return ResponseMessage.createErrorResponse("1115");

		msg = userQuestionService.answer(request, question);
		return msg;
	}

	@RequestMapping(value = "submitExam.do")
	public @ResponseBody ResponseMessage submitExam(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseMessage msg = ResponseMessage.createSuccessResponse("0000");
		UserExam userExam = this.getJsonJavaByInterceptor(request, UserExam.class);
		if (userExam == null || StringUtils.isEmpty(userExam.getUserExamId()))
			return ResponseMessage.createErrorResponse("1116");
		return userQuestionService.submitExam(userExam);
	}

	/**
	 * 显示图片
	 * 
	 * @param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "choiceImage.do")
	public ModelAndView choiceImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String filePath = request.getParameter("filePath");
		// 返回图片显示
		FileOperateUtil.view(request, response, AppCache.serviceConfig.get("question.choice.dir") + filePath);

		return null;
	}

	/**
	 * 显示图片
	 * 
	 * @param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "addtionImage.do")
	public ModelAndView addtionImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String filePath = request.getParameter("filePath");
		// 返回图片显示
		FileOperateUtil.view(request, response, AppCache.serviceConfig.get("question.addtion.dir") + filePath);

		return null;
	}

	/**
	 * 显示图片
	 * 
	 * @param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "exampleImage.do")
	public ModelAndView exampleImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String filePath = request.getParameter("filePath");
		// 返回图片显示
		FileOperateUtil.view(request, response, AppCache.serviceConfig.get("question.example.dir") + filePath);

		return null;
	}

	/**
	 * voice
	 * 
	 * @param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "voice.do")
	public ModelAndView voice(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String filePath = request.getParameter("filePath");
		// 返回图片显示
		FileOperateUtil.voice(request, response, AppCache.serviceConfig.get("question.voice.dir") + filePath);

		return null;
	}
}
