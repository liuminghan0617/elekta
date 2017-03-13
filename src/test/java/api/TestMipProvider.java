package api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Maps;
import com.makervt.core.domain.Page;
import com.makervt.core.domain.ResponseMessage;
import com.makervt.core.util.HttpUtils;
import com.makervt.elekta.domain.Healing;
import com.makervt.elekta.domain.Schedule;
import com.makervt.elekta.entity.Doctor;
import com.makervt.elekta.entity.Message;
import com.makervt.elekta.entity.Question;
import com.makervt.elekta.entity.QuestionAddPic;
import com.makervt.elekta.entity.QuestionChoice;
import com.makervt.elekta.entity.QuestionExamplePic;
import com.makervt.elekta.entity.User;
import com.makervt.elekta.entity.UserQuestion;
import com.makervt.elekta.service.MipProviderService;

import junit.framework.TestCase;

public class TestMipProvider  extends TestCase{
	private static Logger logger = LoggerFactory.getLogger(TestMipProvider.class);
	
	public  void testLogin()
	{
		User user=new User();
		user.setUserMobile("0001");
		user.setUserMrNo("0001");
		User  userMip =MipProviderService.vaildUserByMip(user);
		logger.debug(JSON.toJSONString(userMip));
	}
	
	public void testqueryScheduleListByMip()
	{
		Schedule schedule =new Schedule();
		schedule.setScheduleStartTime("2016-02-15");
		schedule.setScheduleEndTime("2016-02-18");
		schedule.setUserId("1");
		List<Schedule>  scheduleList=MipProviderService.queryScheduleListByMip(schedule);
		logger.debug(JSON.toJSONString(scheduleList));
	}
	
	public void testqueryScheduleDetailListByMip()
	{
		Schedule schedule =new Schedule();
		schedule.setScheduleDate("2016-01-01");
		schedule.setPageNo(1);
		schedule.setPageSize(3);
		schedule.setUserId("1");
		Schedule scheduleReturn=MipProviderService.queryScheduleDetailListByMip(schedule);
		
		logger.debug(JSON.toJSONString(scheduleReturn));
	}
	
	public void testqueryDoctor()
	{
		Doctor doctor =new Doctor();
		doctor.setUserId("0001");
		Doctor doctorReturn=MipProviderService.queryDoctorByMip(doctor.getUserId());
		
		logger.debug(JSON.toJSONString(doctorReturn));
	}
	
	public void testmessagViewByMip()
	{
		List<Message> messagesMip=new ArrayList<Message>();
		for(int i=0;i<5;i++)
		{
			Message msgMip=new Message();
			msgMip.setUserId(String.valueOf(i+1));
			msgMip.setMessageId(String.valueOf(i+1));
			messagesMip.add(msgMip);
		}
		ResponseMessage  responseMessage =MipProviderService.messagViewByMip(messagesMip);
		logger.debug(JSON.toJSONString(responseMessage));
	}
	
	public void testqueryHealingByMip()
	{
		Healing proc =new Healing();
		proc.setUserId("18");
		Healing procReturn=MipProviderService.queryHealingByMip(proc);
		logger.debug(JSON.toJSONString(procReturn));
	}
	
	public void testSubmitExam()
	{
		List<UserQuestion> questionList = new ArrayList<UserQuestion>();
		UserQuestion question = new UserQuestion();
		question.setQuestionId("1");
		question.setUserQuestionType("word");
		question.setUserQuestionMultiChoice("0");
		question.setUserId("1");
		question.setUserExamId("1");
		question.setExamId("1");
		question.setUserQuestionAnswer("A");
		question.setUserQuestionNo("1");
		List<QuestionChoice> wordList = new ArrayList<QuestionChoice>();
		QuestionChoice questionChoice=new QuestionChoice();
		questionChoice.setQuestionChoiceId("1");
		wordList.add(questionChoice);
		question.setUserQuestionAdditionalText("精神状态不好");
		question.setChoiceItems(wordList);
		
		questionList.add(question);
		
		
		UserQuestion quesPic = new UserQuestion();
		quesPic.setUserQuestionNo("2");
		quesPic.setQuestionId("2");
		quesPic.setUserExamId("1");
		quesPic.setExamId("1");
		quesPic.setUserQuestionMultiChoice("1");
		quesPic.setUserQuestionType("pic");
		quesPic.setUserQuestionAnswer("A,B");
		List<QuestionChoice> picList = new ArrayList<QuestionChoice>();
		QuestionChoice questionPic1=new QuestionChoice();
		QuestionChoice questionPic2=new QuestionChoice();
		questionPic1.setQuestionChoiceId("3");
		questionPic2.setQuestionChoiceId("4");
		picList=Arrays.asList(questionPic1,questionPic2);
		quesPic.setChoiceItems(picList);
		
		List<QuestionAddPic> addPicsList= new ArrayList<QuestionAddPic>();
		QuestionAddPic questionAddPic1=new QuestionAddPic();
		QuestionAddPic questionAddPic2=new QuestionAddPic();
		QuestionAddPic questionAddPic3=new QuestionAddPic();
		QuestionAddPic questionAddPic4=new QuestionAddPic();
		questionAddPic1.setQuestionAddPicDir("E:\\usr\\a.jpg");
		questionAddPic1.setQuestionAddPicUrl("http://xxxx.co?sss=a.jpg");
		
		questionAddPic2.setQuestionAddPicDir("E:\\usr\\b.jpg");
		questionAddPic2.setQuestionAddPicUrl("http://xxxx.co?sss=b.jpg");
		
		questionAddPic3.setQuestionAddPicDir("E:\\usr\\c.jpg");
		questionAddPic3.setQuestionAddPicUrl("http://xxxx.co?sss=c.jpg");
		
		questionAddPic4.setQuestionAddPicDir("E:\\usr\\d.jpg");
		questionAddPic4.setQuestionAddPicUrl("http://xxxx.co?sss=d.jpg");
		addPicsList=Arrays.asList(questionAddPic1,questionAddPic2,questionAddPic3,questionAddPic4);
		quesPic.setQuestionAdditionaPics(addPicsList);
		questionList.add(quesPic);

		UserQuestion quesDesc = new UserQuestion();
		
		
		List<QuestionAddPic> addPicsDescList= new ArrayList<QuestionAddPic>();
		QuestionAddPic questionAddDesc=new QuestionAddPic();
		questionAddDesc.setQuestionAddPicDir("E:\\usr\\example.jpg");
		questionAddDesc.setQuestionAddPicUrl("http://xxxx.co?sss=example.jpg");
		addPicsDescList.add(questionAddDesc);
		quesDesc.setQuestionAdditionaPics(addPicsDescList);
		quesDesc.setQuestionId("3");
		quesDesc.setUserExamId("1");
		quesDesc.setExamId("1");
		quesDesc.setUserQuestionNo("3");
		quesDesc.setUserQuestionType("desc");
		quesDesc.setUserQuestionAdditionalVoiceDir("E:\\usr\\Ringtone02.wma");
		quesDesc.setUserQuestionAdditionalVoiceUrl("http://xxx.co?sss=Ringtone02.wma");
		quesDesc.setUserQuestionAnswer("睡眠不是很好!");
	
		questionList.add(quesDesc);
		
		ResponseMessage responseMessage=null;
		try {
			responseMessage = MipProviderService.submitExam(questionList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug(JSON.toJSONString(responseMessage));
	}
	
}
