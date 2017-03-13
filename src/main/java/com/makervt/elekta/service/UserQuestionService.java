package com.makervt.elekta.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.makervt.core.cache.AppCache;
import com.makervt.core.domain.ResponseMessage;
import com.makervt.core.service.BaseService;
import com.makervt.core.util.DateUtils;
import com.makervt.core.util.FileOperateUtil;
import com.makervt.elekta.dao.QuestionAddPicDao;
import com.makervt.elekta.dao.QuestionChoiceDao;
import com.makervt.elekta.dao.QuestionDao;
import com.makervt.elekta.dao.QuestionExamplePicDao;
import com.makervt.elekta.dao.UserExamDao;
import com.makervt.elekta.dao.UserQuestionDao;
import com.makervt.elekta.entity.Question;
import com.makervt.elekta.entity.QuestionAddPic;
import com.makervt.elekta.entity.QuestionChoice;
import com.makervt.elekta.entity.QuestionExamplePic;
import com.makervt.elekta.entity.UserExam;
import com.makervt.elekta.entity.UserQuestion;

@Service("userQuestionService")
public class UserQuestionService extends BaseService<UserQuestion> {
	private static Logger logger = LoggerFactory.getLogger(UserQuestionService.class);
	@Autowired
	private UserQuestionDao userQuestionDao;

	@Autowired
	private UserExamDao userExamDao;

	@Autowired
	private QuestionExamplePicDao questionExamplePicDao;

	@Autowired
	private QuestionAddPicDao questionAddPicDao;

	@Autowired
	private QuestionChoiceDao questionChoiceDao;
	@Autowired
	private QuestionDao questionDao;

	private static String QUESTION_VOICE_URL = "exam/voice.do?filePath=";
	private static String QUESTION_ADDTION_URL = "exam/addtionImage.do?filePath=";

	private static String QUESTION_VOICE_DIR = AppCache.serviceConfig.get("question.voice.dir");
	private static String QUESTION_ADDTION_PICS_DIR = AppCache.serviceConfig.get("question.addtion.dir");
	private static String QUESTION_DEFAULT_DIR = AppCache.serviceConfig.get("question.default.dir");

	public ResponseMessage submitExam(UserExam userExam) throws Exception {
		ResponseMessage responseMsg = ResponseMessage.createSuccessResponse("0000");
		userExam = userExamDao.selectByPK(userExam.getUserExamId());
//		if (!StringUtils.equals(userExam.getUserExamFinish(), userExam.getUserExamTotal()))
//			return ResponseMessage.createErrorResponse("1119");
		
		if (StringUtils.equals(userExam.getUserExamStatus(), "1"))
			return ResponseMessage.createErrorResponse("1120");
		
//		if (userExam == null)
//			return ResponseMessage.createErrorResponse("9999");

		UserQuestion userQuestion = new UserQuestion();
		userQuestion.setUserExamId(userExam.getUserExamId());
		userQuestion.setUserQuestionStatus("1");
		List<UserQuestion> questionAnswer = userQuestionDao.selectAllQuestion(userQuestion);
//		if (questionAnswer != null && questionAnswer.size() == NumberUtils.toInt(userExam.getUserExamTotal())) {
		if (questionAnswer != null ) {
			ResponseMessage mipResponse=MipProviderService.submitExam(questionAnswer);
			if(StringUtils.equalsIgnoreCase(ResponseMessage.PromptType.SUCCESS.getType(), mipResponse.getType()))
			{
				Object feedback=mipResponse.getData().get("userExamFeed");
				String userExamFeedback=(String)(feedback==null?"":feedback);
				UserExam	userExamUpdate=new UserExam();
				if(StringUtils.isNotEmpty(userExamFeedback))
				{
					userExamUpdate.setUserExamFeedback(userExamFeedback);					
					responseMsg.setData("userExamFeedback", userExamFeedback);
				}
				userExamUpdate.setUserExamId(userExam.getUserExamId());
				userExamUpdate.setUserExamStatus("1");
				userExamDao.updateByPK(userExamUpdate);
			}
			else
			{
				return mipResponse;
			}
		} else {
			return ResponseMessage.createErrorResponse("1119");
		}
		
		return responseMsg;
	}

	public ResponseMessage answer(HttpServletRequest request, UserQuestion userQuestion) throws Exception {
		ResponseMessage responseMsg = ResponseMessage.createSuccessResponse("0000");
		UserQuestion userQuestionExist = userQuestionDao.selectByPK(userQuestion.getUserQuestionId());
		if (userQuestionExist == null)
			return ResponseMessage.createErrorResponse("9999");

		UserExam userExam = userExamDao.selectByPK(userQuestionExist.getUserExamId());
		if (userExam == null)
			return ResponseMessage.createErrorResponse("9999");
		if (StringUtils.equals(userExam.getUserExamStatus(), "1"))
			return ResponseMessage.createErrorResponse("1120");
		
		Date expireDate = DateUtils.getDate(userExam.getUserExamExpireDate());
		Date nowDate = DateUtils.truncate(DateUtils.getCurrentDate(), Calendar.DAY_OF_MONTH);
		if (expireDate.getTime() < nowDate.getTime())
			return ResponseMessage.createErrorResponse("1117");
		
		if(StringUtils.isNotEmpty(userQuestion.getUserQuestionAdditionalText()))
		{
			userQuestion.setUserQuestionAdditionalTextTime(DateUtils.getDate(new Date()));
		}
		
		responseMsg = handleUpload(request);
		if (StringUtils.equalsIgnoreCase(ResponseMessage.PromptType.SUCCESS.getType(), responseMsg.getType())) {
			Map<String, Object> filesMap = (Map<String, Object>) responseMsg.getData();
			List<QuestionAddPic> pics = new ArrayList<QuestionAddPic>();
			if (null != filesMap) {
				for (String key : filesMap.keySet()) {
					Map file = (Map) filesMap.get(key);
					String fileName = (String) file.get("name");
					if (FileOperateUtil.isVoice(fileName)) {
						if (StringUtils.isNotEmpty(userQuestion.getUserQuestionAdditionalVoiceDir())) {
							FileUtils.forceDeleteOnExit(new File(userQuestion.getUserQuestionAdditionalVoiceDir()));
						}
						userQuestion.setUserQuestionAdditionalVoiceDir(
								(String) file.get("path") + (String) file.get("name"));
						userQuestion.setUserQuestionAdditionalVoiceUrl(QUESTION_VOICE_URL + (String) file.get("name"));
						userQuestion.setUserQuestionAdditionalVoiceTime(DateUtils.getDate(new Date()));
					} else if (FileOperateUtil.isImage(fileName)) {
						QuestionAddPic pic = new QuestionAddPic();
						pic.setUserQuestionId(userQuestion.getUserQuestionId());
						pic.setQuestionAddPicDir((String) file.get("path") + (String) file.get("name"));
						pic.setQuestionAddPicUrl(QUESTION_ADDTION_URL + (String) file.get("name"));
						pics.add(pic);
						userQuestion.setUserQuestionAdditionalPicTime(DateUtils.getDate(new Date()));
					}
				}
			}
			if (pics.size() >= 1)
				userQuestion.setQuestionAdditionaPics(pics);

			userQuestion.setUserQuestionStatus("1");

			userQuestionDao.updateByPK(userQuestion);

			UserQuestion userQuestionFinish = new UserQuestion();
			userQuestionFinish.setUserExamId(userQuestionExist.getUserExamId());
			userQuestionFinish.setUserQuestionStatus("1");
			Integer finishCount = userQuestionDao.count(userQuestionFinish);

			// 更新用户试卷状态
			userExam.setUserExamProgress("1");
			userExam.setUserExamFinish(String.valueOf(finishCount));
			/*
			 * if (StringUtils.equals(String.valueOf(finishCount),
			 * userExam.getUserExamTotal())) { userExam.setUserExamStatus("1");
			 * }
			 */
			userExamDao.updateByPK(userExam);

			QuestionAddPic questionAddPic = new QuestionAddPic();
			questionAddPic.setUserQuestionId(userQuestion.getUserQuestionId());
			List<QuestionAddPic> addPicList = questionAddPicDao.select(questionAddPic);

			// 删除原有图片
			if (addPicList != null && addPicList.size() > 0) {
				for (QuestionAddPic addPic : addPicList) {
					FileUtils.forceDeleteOnExit(new File(addPic.getQuestionAddPicDir()));
				}
				questionAddPicDao.delete(questionAddPic);
			}
			for (QuestionAddPic addPic : pics) {
				questionAddPicDao.insert(addPic);
			}
			logger.debug("保存补充问题结果:" + JSON.toJSONString(userQuestion));
		}
		responseMsg = ResponseMessage.createSuccessResponse("0000");
		return responseMsg;
	}

	public static ResponseMessage handleUpload(HttpServletRequest request) throws Exception {
		ResponseMessage responseMessage = ResponseMessage.createSuccessResponse("0000");
		MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = mRequest.getFileMap();
		if (fileMap == null || fileMap.keySet().size() == 0) {
			return ResponseMessage.createSuccessResponse("0000");
		}
		String fileName = null;
		int i = 0;
		for (Iterator<Map.Entry<String, MultipartFile>> it = fileMap.entrySet().iterator(); it.hasNext(); i++) {
			Map.Entry<String, MultipartFile> entry = it.next();
			MultipartFile mFile = entry.getValue();
			fileName = new String(mFile.getOriginalFilename().getBytes("utf-8"));
			if (!fileName.equals("")) {
				String storeName = FileOperateUtil.rename(fileName);
				String dir = null;
				String realName = null;
				if (FileOperateUtil.isVoice(fileName))
					dir = QUESTION_VOICE_DIR;
				if (FileOperateUtil.isImage(fileName))
					dir = QUESTION_ADDTION_PICS_DIR;

				if (StringUtils.isEmpty(dir))
					dir = QUESTION_DEFAULT_DIR;

				File file = new File(dir);

				if (!file.exists()) {
					FileUtils.forceMkdir(file);
				}

				realName = dir + storeName;

				Map<String, Object> map = new HashMap<String, Object>();
				mFile.transferTo(new File(realName));
				// 固定参数值对
				map.put("type", "SUCCESS");
				map.put("path", dir);
				map.put("old", fileName);
				map.put("name", storeName);
				map.put("size", mFile.getSize());
				responseMessage.setData("file" + i, map);
			}
		}
		return responseMessage;
	}

	public List<UserQuestion> queryQuestions(UserQuestion userQuestion) {
		userQuestion.setParentId("0");
		List<UserQuestion> questions = userQuestionDao.select(userQuestion);
//		logger.info("userQuestionService-userQuestionService questions_db:<{}>", JSONObject.toJSON(questions).toString());
		List<UserQuestion> questionsReturn = new ArrayList<UserQuestion>();
		List<String> questionChoiceId_list = new ArrayList<>();
		for (UserQuestion uq : questions) {
			QuestionExamplePic questionExamplePic = new QuestionExamplePic();
			questionExamplePic.setQuestionId(uq.getQuestionId());
			List<QuestionExamplePic> questionExamplePics = questionExamplePicDao.select(questionExamplePic);

			QuestionChoice questionChoice = new QuestionChoice();
			questionChoice.setQuestionId(uq.getQuestionId());
			List<QuestionChoice> questionChoices = questionChoiceDao.select(questionChoice);
			uq.setExamplePic(questionExamplePics);
			uq.setChoiceItems(questionChoices);
			
			QuestionAddPic pic=new QuestionAddPic();
			pic.setUserQuestionId(uq.getUserQuestionId());
			List<QuestionAddPic> pics=questionAddPicDao.select(pic);
			uq.setQuestionAdditionaPics(pics);
			
//			Question question = new Question();
//			question.setQuestionId(uq.getQuestionId());
			Question question = questionDao.selectByPK(uq.getQuestionId());
			uq.setParentId(question.getParentId());
			if (!StringUtils.equals(question.getParentId(), "0")) {
				questionChoiceId_list.add(question.getParentId());
			}
			questionsReturn.add(uq);
		}
		
		List<String> questionId_list = getParentQuestionId(questionChoiceId_list, questionsReturn);
//		setSubtitleFlag(questionId_list, questionsReturn);
		logger.info("userQuestionService-userQuestionService questiConsReturn:<{}>", JSONObject.toJSON(questionsReturn).toString());
		return questionsReturn;
	}
	
	public List<String> getParentQuestionId(List<String> questionChoiceId_list, List<UserQuestion> questionsReturn) {
		logger.info("选项id列表:<{}>", JSONObject.toJSON(questionChoiceId_list).toString());
		List<String> questionId_list = new ArrayList<>();
		for (UserQuestion userQuestion : questionsReturn) {
			List<QuestionChoice> choice_list = userQuestion.getChoiceItems();
			if (choice_list != null) {
				for (QuestionChoice questionChoice : choice_list) {
					String questionChoiceId = questionChoice.getQuestionChoiceId();
					if (questionChoiceId_list.contains(questionChoiceId)) {
//						String questionId = questionChoice.getQuestionId();
//						questionId_list.add(questionId);
						questionChoice.setSubtitleFlag(1);
					}
				}
			}
		}
		logger.info("主题列表:<{}>", JSONObject.toJSON(questionId_list).toString());
		return questionId_list;
	} 
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("H0001-1332");
		if (list.contains("H0001-1333")) {
			System.out.println(123);
		}
	}
	
	public void setSubtitleFlag(List<String> questionId_list,List<UserQuestion> questionsReturn){
		for (UserQuestion userQuestion : questionsReturn) {
			String questionId = userQuestion.getQuestionId();
			if (questionId_list.contains(questionId)) {
				userQuestion.setSubtitleFlag(1);
			}
		}
	}

	public Integer create(UserQuestion userQuestion) {
		return userQuestionDao.insert(userQuestion);
	}

	public Integer modify(UserQuestion userQuestion) {
		return userQuestionDao.updateByPK(userQuestion);
	}

	public Integer remove(UserQuestion userQuestion) {
		return userQuestionDao.delete(userQuestion);
	}

	public Integer removeBatch(String[] array) {
		return userQuestionDao.deleteBatch(array);
	}

	@Override
	public Integer count(UserQuestion entity) {
		return userQuestionDao.count(entity);
	}

	public List<UserQuestion> select(UserQuestion entity) {
		return userQuestionDao.select(entity);
	}

	@Override
	public List<UserQuestion> selectPage(UserQuestion entity) {
		return userQuestionDao.selectPage(entity);
	}
	
	
}
