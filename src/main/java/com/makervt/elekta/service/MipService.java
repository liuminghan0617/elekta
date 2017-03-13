package com.makervt.elekta.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.makervt.core.cache.AppCache;
import com.makervt.core.component.push.model.UmengPush;
import com.makervt.core.domain.ResponseMessage;
import com.makervt.core.service.BaseService;
import com.makervt.core.util.FileOperateUtil;
import com.makervt.core.util.HtmlUtils;
import com.makervt.elekta.dao.AttentionDao;
import com.makervt.elekta.dao.AttentionPicDao;
import com.makervt.elekta.dao.DoctorDao;
import com.makervt.elekta.dao.DoctorPicDao;
import com.makervt.elekta.dao.ExamDao;
import com.makervt.elekta.dao.HolidayDao;
import com.makervt.elekta.dao.InfoDao;
import com.makervt.elekta.dao.InfoPicDao;
import com.makervt.elekta.dao.MessageDao;
import com.makervt.elekta.dao.QuestionChoiceDao;
import com.makervt.elekta.dao.QuestionDao;
import com.makervt.elekta.dao.QuestionExamplePicDao;
import com.makervt.elekta.dao.UserExamDao;
import com.makervt.elekta.dao.UserQuestionDao;
import com.makervt.elekta.entity.Attention;
import com.makervt.elekta.entity.AttentionPic;
import com.makervt.elekta.entity.Doctor;
import com.makervt.elekta.entity.DoctorPic;
import com.makervt.elekta.entity.Exam;
import com.makervt.elekta.entity.Holiday;
import com.makervt.elekta.entity.Info;
import com.makervt.elekta.entity.InfoPic;
import com.makervt.elekta.entity.Message;
import com.makervt.elekta.entity.Question;
import com.makervt.elekta.entity.QuestionChoice;
import com.makervt.elekta.entity.QuestionExamplePic;
import com.makervt.elekta.entity.User;
import com.makervt.elekta.entity.UserExam;
import com.makervt.elekta.entity.UserQuestion;
import com.makervt.elekta.handle.PushHandler;

@Service("mipService")
public class MipService {

	private static Logger logger = LoggerFactory.getLogger(MipService.class);

	private static String ATTENTION_PHOTO_VIEW = "schedule/attentionImage.do?filePath=";

	private static String DOCTOR_PHOTO_VIEW = "doctor/image.do?filePath=";

	private static String DOCTOR_CONTENT_VIEW = "doctor/imageContent.do?filePath=";

	private static String QUESTION_CHOICE_PHOTO_VIEW = "exam/choiceImage.do?filePath=";

	private static String QUESTION_EXAMPLE_PHOTO_VIEW = "exam/exampleImage.do?filePath=";

	private static String INFO_PHOTO_VIEW = "info/image.do?filePath=";

	private static String INFO_CONTENT_VIEW = "info/imageContent.do?filePath=";

	private static String context = AppCache.serviceConfig.get("app.context");

	public ResponseMessage addDoctor(HttpServletRequest request, Doctor doctor) {
		ResponseMessage responseMsg = ResponseMessage.createSuccessResponse("0000");
		try {
			// 处理文件上传
			responseMsg = FileOperateUtil.handleUpload(request, AppCache.serviceConfig.get("doctor.default.dir"), false,
					null, null);

			List<DoctorPic> doctorPicList = new ArrayList<DoctorPic>();
			if (StringUtils.equalsIgnoreCase(ResponseMessage.PromptType.SUCCESS.getType(), responseMsg.getType())) {
				Map<String, Object> filesMap = (Map<String, Object>) responseMsg.getData();
				if (null != filesMap || filesMap.size() > 0) {
					for (String key : filesMap.keySet()) {
						Map file = (Map) filesMap.get(key);
						String oldName = (String) file.get("old");
						String newName = (String) file.get("name");

						String dir = (String) file.get("path") + (String) file.get("name");
						String content = doctor.getDoctorContent();
						if (StringUtils.isNotEmpty(content) && HtmlUtils.isExistImg(content, oldName)) {
							String contentUrl = context + DOCTOR_CONTENT_VIEW + newName;
							String contentDir = AppCache.serviceConfig.get("doctor.content.dir") + newName;
							content = HtmlUtils.replaceHtmlImg(content, oldName, contentUrl);
							FileUtils.moveFile(new File(dir), new File(contentDir));
							DoctorPic doctorPic = new DoctorPic();
							doctorPic.setDoctorId(doctor.getDoctorId());
							doctorPic.setDoctorPicDir(contentDir);
							doctorPic.setDoctorPicUrl(contentUrl);
							doctorPicList.add(doctorPic);
						} else if (StringUtils.isNotEmpty(doctor.getDoctorPhotoUrl())
								&& doctor.getDoctorPhotoUrl().indexOf(oldName) >= 0) {
							String photoUrl = DOCTOR_PHOTO_VIEW + newName;
							String photoDir = AppCache.serviceConfig.get("doctor.photo.dir") + newName;
							FileUtils.moveFile(new File(dir), new File(photoDir));
							doctor.setDoctorPhotoUrl(photoUrl);
							doctor.setDoctorPhotoDir(photoDir);
						}
						doctor.setDoctorContent(content);
					}
				}
				Doctor doctorCheck = doctorDao.selectByPK(doctor.getDoctorId());
				if (null != doctorCheck) {
					doctorDao.updateByPK(doctor);
					DoctorPic doctorPic = new DoctorPic();
					doctorPic.setDoctorId(doctor.getDoctorId());
					List<DoctorPic> picList = doctorPicDao.select(doctorPic);
					for (DoctorPic pic : picList) {
						FileUtils.forceDeleteOnExit(new File(pic.getDoctorPicDir()));
					}
					doctorPicDao.delete(doctorPic);
				} else {
					doctorDao.insert(doctor);
				}
				for (DoctorPic pic : doctorPicList) {
					doctorPicDao.insert(pic);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("上传图片失败!", e);
			return ResponseMessage.createErrorResponse("9999");
		}
		return responseMsg;
	}

	public ResponseMessage addAttention(HttpServletRequest request, Attention attention) {
		ResponseMessage responseMsg = ResponseMessage.createSuccessResponse("0000");
		try {
			List<AttentionPic> pics = new ArrayList<AttentionPic>();
			// 处理文件上传
			responseMsg = FileOperateUtil.handleUpload(request, AppCache.serviceConfig.get("attention.photo.dir"),
					false, null, null);
			if (StringUtils.equalsIgnoreCase(ResponseMessage.PromptType.SUCCESS.getType(), responseMsg.getType())) {
				Map<String, Object> filesMap = (Map<String, Object>) responseMsg.getData();
				if (null != filesMap || filesMap.size() > 0) {
					for (String key : filesMap.keySet()) {
						Map file = (Map) filesMap.get(key);
						String oldName = (String) file.get("old");
						String newName = (String) file.get("name");
						String dir = (String) file.get("path") + (String) file.get("name");
						String content = attention.getAttentionContent();
						String contentUrl = context + ATTENTION_PHOTO_VIEW + newName;
						if (StringUtils.isNotEmpty(content) && HtmlUtils.isExistImg(content, oldName)) {
							content = HtmlUtils.replaceHtmlImg(content, oldName, contentUrl);
							attention.setAttentionContent(content);
							
							AttentionPic attentionPic = new AttentionPic();
							attentionPic.setAttentionPicUrl(contentUrl);
							attentionPic.setAttentionPicDir(dir);
							pics.add(attentionPic);
						}
					}
				}
				
				Attention check = attentionDao.selectByPK(attention.getAttentionId());
				
				attention.setAttentionUpdateDate(null);
				attention.setAttentionCreateDate(null);
				if (null != check) {
					attentionDao.updateByPK(attention);
				} else {
					attentionDao.insert(attention);
				}
				if (pics != null && pics.size() > 0) {
					AttentionPic del = new AttentionPic();
					del.setAttentionId(attention.getAttentionId());
					List<AttentionPic> existAttentionPic = attentionPicDao.select(del);
					if (existAttentionPic != null && existAttentionPic.size() > 0) {
						for (AttentionPic delPic : existAttentionPic) {
							FileUtils.forceDeleteOnExit(new File(delPic.getAttentionPicDir()));
						}
						attentionPicDao.delete(del);
					}

					for (AttentionPic pic : pics) {
						pic.setAttentionId(attention.getAttentionId());
						attentionPicDao.insert(pic);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("上传图片失败!", e);
			return ResponseMessage.createErrorResponse("9999");
		}
		return responseMsg;
	}

	public ResponseMessage addExam(HttpServletRequest request, Exam exam) {
		ResponseMessage responseMsg = ResponseMessage.createSuccessResponse("0000");
		try {
			UserQuestion userQuestion = new UserQuestion();
			userQuestion.setExamId(exam.getExamId());
			Integer count = userQuestionDao.count(userQuestion);
			if (count > 0) {
				return ResponseMessage.createErrorResponse("1118");
			}
			Exam check = examDao.selectByPK(exam.getExamId());
			if (null != check) {
				examDao.updateByPK(exam);
			} else {
				examDao.insert(exam);
			}

			// 清理已存在的数据和文件
			Question question = new Question();
			question.setExamId(exam.getExamId());

			List<Question> questionDel = questionDao.select(question);
			if (questionDel != null && questionDel.size() > 0) {
				for (Question q : questionDel) {
					QuestionExamplePic questionExamplePicDel = new QuestionExamplePic();
					QuestionChoice questionChoiceDel = new QuestionChoice();
					questionExamplePicDel.setQuestionId(q.getQuestionId());
					questionChoiceDel.setQuestionId(q.getQuestionId());

					List<QuestionExamplePic> exampleDel = questionExamplePicDao.select(questionExamplePicDel);
					List<QuestionChoice> choiceItemsDel = questionChoiceDao.select(questionChoiceDel);
					if (exampleDel != null && exampleDel.size() > 0) {
						for (QuestionExamplePic ep : exampleDel) {
							if (StringUtils.isNotEmpty(ep.getQuestionExamplePicDir()))
								FileUtils.forceDeleteOnExit(new File(ep.getQuestionExamplePicDir()));
						}
					}
					if (choiceItemsDel != null && choiceItemsDel.size() > 0) {
						for (QuestionChoice qc : choiceItemsDel) {
							if (StringUtils.isNotEmpty(qc.getQuestionChoiceDir()))
								FileUtils.forceDeleteOnExit(new File(qc.getQuestionChoiceDir()));
						}
					}

				}
				questionDao.delete(question);
			}
			List<Question> questions = exam.getQuestions();
			// 处理文件上传
			responseMsg = FileOperateUtil.handleUpload(request, AppCache.serviceConfig.get("question.default.dir"), false, null, null);
			if (StringUtils.equalsIgnoreCase(ResponseMessage.PromptType.SUCCESS.getType(), responseMsg.getType())) {
				Map<String, Object> filesMap = (Map<String, Object>) responseMsg.getData();

				for (Question ques : questions) {
					ques.setExamId(exam.getExamId());

					List<QuestionExamplePic> examplePics = new ArrayList<QuestionExamplePic>();
					List<QuestionChoice> choiceItems = new ArrayList<QuestionChoice>();
					List<QuestionExamplePic> examplePicsTemp = ques.getExamplePic();
					List<QuestionChoice> choiceItemsTemp = ques.getChoiceItems();

					String content = ques.getQuestionExampleContent();
					if (StringUtils.isNotEmpty(content)) {
						for (QuestionExamplePic example : examplePicsTemp) {
							if (null != filesMap || filesMap.size() > 0) {
								for (String key : filesMap.keySet()) {
									Map file = (Map) filesMap.get(key);
									String oldName = (String) file.get("old");
									String newName = (String) file.get("name");
									String dir = (String) file.get("path") + (String) file.get("name");
									String contentUrl = context + QUESTION_EXAMPLE_PHOTO_VIEW + newName;
									if (HtmlUtils.isExistImg(content, oldName)) {
										content = HtmlUtils.replaceHtmlImg(content, oldName, contentUrl);
										ques.setQuestionExampleContent(content);
									}

									if (StringUtils.contains(example.getQuestionExamplePicUrl(), oldName)) {
										example.setQuestionExamplePicDir(
												AppCache.serviceConfig.get("question.example.dir") + newName);
										example.setQuestionExamplePicUrl(QUESTION_EXAMPLE_PHOTO_VIEW + newName);
										FileUtils.moveFile(new File(dir), new File(example.getQuestionExamplePicDir()));
									}
								}
							}
							examplePics.add(example);
						}
					}
					ques.setExamplePic(examplePics);
					for (QuestionChoice choice : choiceItemsTemp) {
						if (null != filesMap || filesMap.size() > 0) {
							for (String key : filesMap.keySet()) {
								Map file = (Map) filesMap.get(key);
								String oldName = (String) file.get("old");
								String name = (String) file.get("name");
								String path = (String) file.get("path");
								if (StringUtils.contains(choice.getQuestionChoicePicUrl(), oldName)) {
									choice.setQuestionChoiceDir(
											AppCache.serviceConfig.get("question.choice.dir") + name);
									choice.setQuestionChoicePicUrl(QUESTION_CHOICE_PHOTO_VIEW + name);
									FileUtils.moveFile(new File(path + name), new File(choice.getQuestionChoiceDir()));
								}
							}
						}
						choiceItems.add(choice);
					}

					// 保存新数据
					ques.setChoiceItems(choiceItems);
					logger.info("question:<{}>", JSONObject.toJSON(ques).toString());
					questionDao.insert(ques);
					if (examplePics != null && examplePics.size() > 0) {
						for (QuestionExamplePic ep : examplePics) {
							ep.setQuestionId(ques.getQuestionId());
							questionExamplePicDao.insert(ep);
						}
					}
					if (choiceItems != null && choiceItems.size() > 0) {
						for (QuestionChoice qc : choiceItems) {
							qc.setQuestionId(ques.getQuestionId());
							questionChoiceDao.insert(qc);
						}
					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("上传图片失败!", e);
			return ResponseMessage.createErrorResponse("9999");
		}
		return responseMsg;
	}
	
	

	public ResponseMessage sendExam(List<UserExam> userExamList) {
		ResponseMessage responseMsg = ResponseMessage.createSuccessResponse("0000");
		if (userExamList != null && userExamList.size() > 0) {
			for (UserExam userExam : userExamList) {
				if (StringUtils.isEmpty(userExam.getExamId()))
					return ResponseMessage.createErrorResponse("1109");

				if (StringUtils.isEmpty(userExam.getUserExamId()))
					return ResponseMessage.createErrorResponse("1121");

				if (StringUtils.isEmpty(userExam.getUserId()))
					return ResponseMessage.createErrorResponse("1101");

				Exam exam = examDao.selectByPK(userExam.getExamId());

				if (null == exam)
					return ResponseMessage.createErrorResponse("1122");

				UserExam userExamCheck = userExamDao.selectByPK(userExam.getUserExamId());
				if (null != userExamCheck)
					return ResponseMessage.createErrorResponse("1123");

				Question question = new Question();
				question.setExamId(userExam.getExamId());
				List<Question> questions = questionDao.select(question);
				userExam.setUserExamTitle(exam.getExamTitle());
				userExam.setUserExamSummary(exam.getExamSummary());
				userExam.setUserExamDoctorWord(exam.getExamDoctorWord());
				userExam.setUserExamTotal(exam.getExamTotal());
				userExam.setUserExamProgress("0");
				userExam.setUserExamFinish("0");
				userExam.setUserExamStatus("0");
				userExam.setUserExamCreateDate(null);
				userExam.setUserExamUpdateDate(null);
				userExamDao.insert(userExam);
				for (Question ques : questions) {
					UserQuestion userQuestion = new UserQuestion();
					userQuestion.setUserExamId(userExam.getUserExamId());
					userQuestion.setQuestionId(ques.getQuestionId());
					userQuestion.setUserQuestionMultiChoice(ques.getQuestionMultiChoice());
					userQuestion.setExamId(userExam.getExamId());
					userQuestion.setUserQuestionStatus("0");
					userQuestion.setUserId(userExam.getUserId());
					userQuestion.setUserQuestionNo(ques.getQuestionNo());
					userQuestion.setUserQuestionTitle(ques.getQuestionTitle());
					userQuestion.setUserQuestionType(ques.getQuestionType());
					userQuestion.setUserQuestionExampleContent(ques.getQuestionExampleContent());
					userQuestionDao.insert(userQuestion);
				}
			}
		}

		for (UserExam userExam : userExamList) {
			logger.info("userid:<{}>",userExam.getUserId());
			User pushUser = userService.selectByPK(userExam.getUserId());
			logger.info("userid:<{}> pushUser:<{}>",userExam.getUserId(),(pushUser == null));
			if (pushUser != null) {
				logger.info("userid:<{}> token:<{}>",userExam.getUserId(),pushUser.getUserDeviceToken());
			}
			
			if (null != pushUser && StringUtils.isNotEmpty(pushUser.getUserDeviceToken())) {
				pushMessage(pushUser.getUserDeviceType(), pushUser.getUserDeviceToken(),
						UmengPush.PushType.UNI.getType(), pushUser.getUserId(),
						"【新】医生给您发送了《" + userExam.getUserExamTitle() + "》，开始答题<<",
						"【新】医生给您发送了《" + userExam.getUserExamTitle() + "》，开始答题<<", "3",
						"【新】医生给您发送了《" + userExam.getUserExamTitle() + "》，开始答题<<");
			}
		}

		return responseMsg;
	}

	public ResponseMessage sendFeedBack(List<UserExam> userExamList) {
		ResponseMessage responseMsg = ResponseMessage.createSuccessResponse("0000");
		if (userExamList != null && userExamList.size() > 0) {
			for (UserExam userExam : userExamList) {
				if (StringUtils.isEmpty(userExam.getUserExamId()))
					return ResponseMessage.createErrorResponse("1121");

				if (StringUtils.isEmpty(userExam.getUserExamFeedback()))
					return ResponseMessage.createErrorResponse("1128");

				UserExam userExamCheck = userExamDao.selectByPK(userExam.getUserExamId());
				if (null == userExamCheck)
					return ResponseMessage.createErrorResponse("1122");
				if (!StringUtils.equalsIgnoreCase(userExamCheck.getUserExamStatus(), "1"))
					return ResponseMessage.createErrorResponse("1129");

				userExamDao.updateByPK(userExam);
				/*User pushUser = userService.selectByPK(userExam.getUserId());
				if (null != pushUser && StringUtils.isNotEmpty(pushUser.getUserDeviceToken())) {
					pushMessage(pushUser.getUserDeviceType(), pushUser.getUserDeviceToken(),
							UmengPush.PushType.UNI.getType(), pushUser.getUserId(),
							"您收到" + userExam.getUserExamTitle() + "调查问卷的反馈",
							"您收到" + userExam.getUserExamTitle() + "调查问卷的反馈", "3",
							"您收到了《" + userExam.getUserExamTitle() + "》调查问卷的一声反馈，请查看！");
				}*/
			}
		}
		return responseMsg;
	}

	public ResponseMessage addInfo(HttpServletRequest request, Info info) {
		ResponseMessage responseMsg = ResponseMessage.createSuccessResponse("0000");
		try {
			List<InfoPic> pics = new ArrayList<InfoPic>();
			// 处理文件上传
			responseMsg = FileOperateUtil.handleUpload(request, AppCache.serviceConfig.get("info.default.dir"), false,
					null, null);
			if (StringUtils.equalsIgnoreCase(ResponseMessage.PromptType.SUCCESS.getType(), responseMsg.getType())) {
				Map<String, Object> filesMap = (Map<String, Object>) responseMsg.getData();
				if (null != filesMap || filesMap.size() > 0) {
					for (String key : filesMap.keySet()) {
						Map file = (Map) filesMap.get(key);
						String oldName = (String) file.get("old");
						String newName = (String) file.get("name");
						String dir = (String) file.get("path") + (String) file.get("name");
						String content = info.getInfoContent();
						if (StringUtils.isNotEmpty(content) && HtmlUtils.isExistImg(content, oldName)) {
							String contentUrl = context + INFO_CONTENT_VIEW + newName;
							String contentDir = AppCache.serviceConfig.get("info.content.dir") + newName;
							content = HtmlUtils.replaceHtmlImg(content, oldName, contentUrl);
							FileUtils.moveFile(new File(dir), new File(contentDir));
							InfoPic infoPic = new InfoPic();
							infoPic.setInfoPicUrl(contentUrl);
							infoPic.setInfoPicDir(contentDir);
							pics.add(infoPic);
							info.setInfoContent(content);
						} else if (StringUtils.isNotEmpty(info.getInfoPicUrl())
								&& info.getInfoPicUrl().indexOf(oldName) >= 0) {
							String photoUrl = INFO_PHOTO_VIEW + newName;
							String photoDir = AppCache.serviceConfig.get("info.photo.dir") + newName;
							FileUtils.moveFile(new File(dir), new File(photoDir));
							info.setInfoPicUrl(photoUrl);
							info.setInfoPicDir(photoDir);
						}

					}
				}
				Info check = infoDao.selectByPK(info.getInfoId());
				
				info.setInfoCreateDate(null);
				info.setInfoUpdateDate(null);
				if (null != check) {
					infoDao.updateByPK(info);
				} else {
					infoDao.insert(info);
					pushMessage("", "", UmengPush.PushType.BROAD.getType(), null, info.getInfoTitle()+"，看资讯>>",
							info.getInfoTitle()+"，看资讯>>", "4", info.getInfoSummary());
				}
				if (pics != null && pics.size() > 0) {
					InfoPic del = new InfoPic();
					del.setInfoId(info.getInfoId());
					List<InfoPic> existInfoPic = infoPicDao.select(del);
					if (existInfoPic != null && existInfoPic.size() > 0) {
						for (InfoPic delPic : pics) {
							FileUtils.forceDeleteOnExit(new File(delPic.getInfoPicDir()));
						}
						infoPicDao.delete(del);
					}

					for (InfoPic pic : pics) {
						pic.setInfoId(info.getInfoId());
						infoPicDao.insert(pic);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("上传图片失败!", e);
			return ResponseMessage.createErrorResponse("9999");
		}
		return responseMsg;
	}

	public ResponseMessage addHoliday(List<Holiday> holidays) {
		ResponseMessage responseMsg = ResponseMessage.createSuccessResponse("0000");
		Holiday holiday = new Holiday();
		holidayDao.delete(holiday);
		holidayDao.insertBatch(holidays);
		return responseMsg;
	}

	public ResponseMessage addMessage(List<Message> messages) {
		ResponseMessage responseMsg = ResponseMessage.createSuccessResponse("0000");
		List<Message> msgList = messageDao.selectMessageBatch(messages);

		if (msgList != null && msgList.size() > 0) {
			String[] msgIds = null;
			List<String> msgIdList = new ArrayList<String>();
			for (Message msg : msgList) {
				msgIdList.add(msg.getMessageId());

			}
			msgIds = msgIdList.toArray(new String[] {});
			responseMsg = ResponseMessage.createErrorResponse("1130");
			responseMsg.setText(responseMsg.getText() + StringUtils.join(msgIds, "、"));
		} else {
			messageDao.insertBatch(messages);
			for (Message message : messages) {
				if (StringUtils.isNotEmpty(message.getUserId())) {
					User pushUser = userService.selectByPK(message.getUserId());
					if (null != pushUser && StringUtils.isNotEmpty(pushUser.getUserDeviceToken())) {
						pushMessage(pushUser.getUserDeviceType(), pushUser.getUserDeviceToken(),
								UmengPush.PushType.UNI.getType(), pushUser.getUserId(), message.getMessageTitle(),
								message.getMessageTitle(), "2", message.getMessageContent());
					}
				}
			}
		}

		return responseMsg;
	}

	private static void pushMessage(String deviceType, String deviceToken, String pushType, String user, String title,
			String ticker, String messageType, String messageContent) {
		logger.info("pushMsg token:<{}>",deviceToken);
		UmengPush umengPush = new UmengPush();
		umengPush.setDeviceToken(deviceToken);
		umengPush.setDeviceType(deviceType);
		umengPush.setPushType(pushType);
		umengPush.setUser(user);
		umengPush.setTitle(title);
		umengPush.setTicker(ticker);
		HashMap map = Maps.newHashMap();
		map.put("type", messageType);
		umengPush.setExtraFields(map);
		umengPush.setText(messageContent);
		PushHandler.addPushQueue(umengPush);
	}

	@Autowired
	private DoctorDao doctorDao;

	@Autowired
	private HolidayDao holidayDao;

	@Autowired
	private DoctorPicDao doctorPicDao;

	@Autowired
	private AttentionDao attentionDao;

	@Autowired
	private AttentionPicDao attentionPicDao;

	@Autowired
	private ExamDao examDao;

	@Autowired
	private MessageDao messageDao;

	@Autowired
	private QuestionDao questionDao;

	@Autowired
	private QuestionExamplePicDao questionExamplePicDao;

	@Autowired
	private QuestionChoiceDao questionChoiceDao;

	@Autowired
	private UserExamDao userExamDao;

	@Autowired
	private InfoPicDao infoPicDao;

	@Autowired
	private InfoDao infoDao;

	@Autowired
	private UserService userService;

	@Autowired
	private UserQuestionDao userQuestionDao;
}
