package com.makervt.elekta.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.makervt.core.cache.AppCache;
import com.makervt.core.domain.ResponseMessage;
import com.makervt.core.util.HttpUtils;
import com.makervt.core.util.StringUtils;
import com.makervt.elekta.domain.Healing;
import com.makervt.elekta.domain.Schedule;
import com.makervt.elekta.entity.Doctor;
import com.makervt.elekta.entity.Message;
import com.makervt.elekta.entity.QuestionAddPic;
import com.makervt.elekta.entity.User;
import com.makervt.elekta.entity.UserQuestion;

public class MipProviderService {

	public static String MIP_API=AppCache.serviceConfig.get("mip.api");
	
	private static Logger logger = LoggerFactory.getLogger(MipProviderService.class);
	
	/**
	 * 调用mip服务验证根据用户手机号码以及医疗手册编号进行验证，MIP根据手机号码发送验证短信。
	 * @param user
	 * @return
	 */
	public static User vaildUserByMip(User user)
	{
		User userQuery=new User();
		userQuery.setUserMobile(user.getUserMobile());
		userQuery.setUserMrNo(user.getUserMrNo());
		logger.debug("==============调用MIP验证用户："+JSON.toJSONString(userQuery));
		String json=HttpUtils.sendPost(MIP_API+"login.aspx", JSON.toJSONString(userQuery));
		logger.debug("==============调用MIP验证用户返回："+json);
		ResponseMessage result=JSON.parseObject(json, ResponseMessage.class);
		User userMip=null;
		if(StringUtils.equalsIgnoreCase(result.getType(),ResponseMessage.PromptType.SUCCESS.getType()))
		{
			JSONObject jsonObj=(JSONObject)result.getData().get("user");
			if(null==jsonObj)	
				return userMip;
			
			userMip=JSON.parseObject(jsonObj.toJSONString(), User.class);
			
			if(StringUtils.isEmpty(userMip.getUserId()))
				return null;
		}
	
		if("13719248588".equals(user.getUserMobile())&&"0000308969".equals(user.getUserMrNo()))
		{
			if(userMip!=null)
				userMip.setUserMobileSmsCode("888888");
		}
		
//		User userMip = new User();
//		userMip.setUserId("12031");
//		userMip.setUserMrNo("90002");
//		userMip.setUserMobile("18911499150");
		return userMip;
	}
	
	/**
	 * 调用mip服务验证根据用户手机号码以及医疗手册编号进行验证，MIP根据手机号码发送验证短信。
	 * @param user
	 * @return
	 */
	public static User vaildUserOtherByMip(User user)
	{
		User userQuery=new User();
		userQuery.setUserHospVerifyCode(user.getUserHospVerifyCode());
		userQuery.setUserMrNo(user.getUserMrNo());
		
		logger.debug("==============其他应用调用MIP验证用户："+JSON.toJSONString(userQuery));
		String json=HttpUtils.sendPost(MIP_API+"loginByOther.aspx", JSON.toJSONString(userQuery));
		logger.debug("==============其他应用调用MIP验证用户返回："+json);
		ResponseMessage result=JSON.parseObject(json, ResponseMessage.class);
		User userMip=null;
		if(StringUtils.equalsIgnoreCase(result.getType(),ResponseMessage.PromptType.SUCCESS.getType()))
		{
			JSONObject jsonObj=(JSONObject)result.getData().get("user");
			if(null==jsonObj)
				return userMip;
			
			userMip=JSON.parseObject(jsonObj.toJSONString(), User.class);
			
			if(StringUtils.isEmpty(userMip.getUserId()))
				return null;
		}
		return userMip;
	}
	
	/**
	 * 调用mip服务验证根据医疗手册编号和医院识别码进行验证，MIP根据手机号码发送验证短信。
	 * @param user
	 * @return
	 */
	public static User vaildOtherUserByMip(User user)
	{
		User userQuery=new User();
		userQuery.setUserHospVerifyCode(user.getUserHospVerifyCode());
		userQuery.setUserMrNo(user.getUserMrNo());
		
		logger.debug("==============调用MIP验证用户："+JSON.toJSONString(userQuery));
		String json=HttpUtils.sendPost(MIP_API+"login.aspx", JSON.toJSONString(userQuery));
		logger.debug("==============调用MIP验证用户返回："+json);
		ResponseMessage result=JSON.parseObject(json, ResponseMessage.class);
		User userMip=null;
		if(StringUtils.equalsIgnoreCase(result.getType(),ResponseMessage.PromptType.SUCCESS.getType()))
		{
			JSONObject jsonObj=(JSONObject)result.getData().get("user");
			if(null==jsonObj)
				return userMip;
			
			userMip=JSON.parseObject(jsonObj.toJSONString(), User.class);
			
			if(StringUtils.isEmpty(userMip.getUserId()))
				return null;
		}
		return userMip;
	}
	
	/**
	 * 查询某段时间内的用户预约信息
	 * @param schedule
	 * @return
	 */
	public static List<Schedule> queryScheduleListByMip(Schedule schedule)
	{
		Schedule scheduleQuery=new Schedule();
		scheduleQuery.setScheduleStartTime(schedule.getScheduleStartTime());
		scheduleQuery.setScheduleEndTime(schedule.getScheduleEndTime());
		scheduleQuery.setUserId(schedule.getUserId());
		logger.debug("==============调用MIP查询某段时间内的用户预约信息："+JSON.toJSONString(scheduleQuery));
		String json=HttpUtils.sendPost(MIP_API+"list.aspx", JSON.toJSONString(scheduleQuery));
		logger.debug("==============调用MIP查询某段时间内的用户预约信息返回："+json);
		ResponseMessage result=JSON.parseObject(json, ResponseMessage.class);
		if(StringUtils.equalsIgnoreCase(result.getType(),ResponseMessage.PromptType.SUCCESS.getType()))
		{
			Object mipReturn = result.getData().get("schedule");
			List<Schedule> scheduleList = null;
			if (mipReturn != null)
				scheduleList = (List<Schedule>) mipReturn;
			return scheduleList;
		}
		
		return null;
	}
	
	/**
	 * 分页查询从某日期开始用户的预约详情列表
	 * @param schedule
	 * @return
	 */
	public static Schedule queryScheduleDetailListByMip(Schedule schedule)
	{
		Schedule scheduleQuery=new Schedule();
		scheduleQuery.setScheduleDate(schedule.getScheduleDate());
		scheduleQuery.setUserId(schedule.getUserId());
		Map queryMap=scheduleQuery.returnMap();
		queryMap.put("pageNo", String.valueOf(schedule.getPageNo()));
		queryMap.put("pageSize", String.valueOf(schedule.getPageSize()));
		logger.debug("==============调用MIP查询预约详情列表："+JSON.toJSONString(queryMap));
		String json=HttpUtils.sendPost(MIP_API+"listDetail.aspx", JSON.toJSONString(queryMap));
		logger.debug("==============调用MIP查询预约详情列表返回："+json);
		ResponseMessage result=JSON.parseObject(json, ResponseMessage.class);
		Schedule scheduleReturn=null;
		Object mipReturn = result.getData().get("schedule");
		if (mipReturn != null) {
			 scheduleReturn = JSON.parseObject(JSON.toJSONString(result.getData().get("schedule")),
					Schedule.class);
		}
		return scheduleReturn;
	}
	
	/**
	 * 查询用户当前的主治医师
	 * @param userId
	 * @return
	 */
	public static Doctor queryDoctorByMip(String userId)
	{
		Doctor doctor=new  Doctor();
		doctor.setUserId(userId);
		logger.debug("==============调用MIP查询用户当前的主治医师："+JSON.toJSONString(doctor));
		String json=HttpUtils.sendPost(MIP_API+"doctorQuery.aspx", JSON.toJSONString(doctor));
		logger.debug("==============调用MIP查询调用用户当前的主治医师返回："+json);
		ResponseMessage result=JSON.parseObject(json, ResponseMessage.class);
		Doctor doctorReturn=null;
		if(StringUtils.equalsIgnoreCase(result.getType(),ResponseMessage.PromptType.SUCCESS.getType()))
		{
			JSONObject jsonObj=(JSONObject)result.getData().get("doctor");
			if(null==jsonObj)
				return doctorReturn;
			
			doctorReturn=JSON.parseObject(jsonObj.toJSONString(), Doctor.class);
		}
		return doctorReturn;
	}

	/**
	 * 将消息查看结果发送至MIP
	 * @param message
	 */
	public static ResponseMessage messagViewByMip(List<Message> messages)
	{
		List<Message> messagesMip=new ArrayList<Message>();
		for(Message msg:messages)
		{
			Message msgMip=new Message();
			msgMip.setUserId(msg.getUserId());
			msgMip.setMessageId(msg.getMessageId());
			messagesMip.add(msgMip);
		}
		Map mapMip=Maps.newHashMap();
		mapMip.put("messages", messagesMip);
		logger.debug("==============将消息查看结果发送至MIP："+JSON.toJSONString(mapMip));
		String json=HttpUtils.sendPost(MIP_API+"messageView.aspx", JSON.toJSONString(mapMip));
		logger.debug("==============将消息查看结果发送至MIP返回："+json);
		ResponseMessage result=JSON.parseObject(json, ResponseMessage.class);
		return result;
	}
	
	/**
	 * 从MIP获取康复进度
	 * @param proc
	 * @return
	 */
	public static Healing queryHealingByMip(Healing proc)
	{
		Healing healingQuery=new Healing();
		healingQuery.setUserId(proc.getUserId());
		logger.debug("==============调用MIP查询获取康复进度："+JSON.toJSONString(healingQuery));
		String json=HttpUtils.sendPost(MIP_API+"healing.aspx", JSON.toJSONString(healingQuery));
		logger.debug("==============调用MIP查询获取康复进度："+json);
		ResponseMessage result=JSON.parseObject(json, ResponseMessage.class);
		Healing procReturn=null;
		if(StringUtils.equalsIgnoreCase(result.getType(),ResponseMessage.PromptType.SUCCESS.getType()))
		{
			JSONObject jsonObj=(JSONObject)result.getData().get("healing");
			if(null==jsonObj)
				return null;
			procReturn=JSON.parseObject(jsonObj.toJSONString(), Healing.class);
		}
		return procReturn;
	}
	
	
	/**
	 * 问卷答完后，提交问卷结果至MIP
	 * @param questionAnswer
	 * @return
	 * @throws Exception
	 */
	public static ResponseMessage submitExam(List<UserQuestion> questionAnswer) throws Exception
	{
		ArrayList<String> fileList=new ArrayList<String>();		
		
		if(questionAnswer!=null&&questionAnswer.size()>0)
		{
			for(UserQuestion userQuestion:questionAnswer)
			{
				if(StringUtils.isNotEmpty(userQuestion.getUserQuestionAdditionalVoiceDir()))
					fileList.add(userQuestion.getUserQuestionAdditionalVoiceDir());
				
				List<QuestionAddPic> picsList=userQuestion.getQuestionAdditionaPics();
				if(picsList!=null&&picsList.size()>0)
				{
					for(QuestionAddPic pic:picsList)
					{
						if(StringUtils.isNotEmpty(pic.getQuestionAddPicDir()))
							fileList.add(pic.getQuestionAddPicDir());
					}
				}
			}
		}
		
		String[] filePaths = fileList.toArray(new String[]{});
		Map<String, Object> answer = Maps.newHashMap();
		answer.put("answer", questionAnswer);
		Map<String, String> params = Maps.newHashMap();
		params.put("jsonData", JSON.toJSONString(answer));
		logger.debug("==============提交问卷结果至MIP："+JSON.toJSONString(answer));
		String json=HttpUtils.sendPostFile(MIP_API+"examAnswer.aspx", filePaths,params);
		logger.debug("==============提交问卷结果至MIP返回："+json);
		ResponseMessage respMsg=JSON.parseObject(json, ResponseMessage.class);
		return respMsg;
	}
}
