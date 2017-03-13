package com.makervt.elekta.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.makervt.core.cache.AppCache;
import com.makervt.core.domain.Page;
import com.makervt.core.domain.ResponseMessage;
import com.makervt.core.util.FileOperateUtil;
import com.makervt.core.web.BaseController;
import com.makervt.elekta.entity.Attention;
import com.makervt.elekta.entity.Holiday;
import com.makervt.elekta.domain.Schedule;
import com.makervt.elekta.service.AttentionService;
import com.makervt.elekta.service.HolidayService;
import com.makervt.elekta.service.ScheduleService;

@Controller
@RequestMapping(value = "schedule")
public class ScheduleApi extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(ScheduleApi.class);

	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private HolidayService holidayService;

	@Autowired
	private AttentionService attentionService;

	@RequestMapping(value = "list.do")
	public @ResponseBody ResponseMessage scheduleList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Schedule schedule = this.getJsonJavaByInterceptor(request, Schedule.class);

		if (StringUtils.isEmpty(schedule.getUserId()))
			return ResponseMessage.createErrorResponse("1101");

		if (!this.isVerfityUser(request, schedule.getUserId()))
			return ResponseMessage.createErrorResponse("1106");

		ResponseMessage msg = ResponseMessage.createSuccessResponse("0000");
		List<Schedule> scheduleList = scheduleService.queryScheduleList(schedule);
		msg.setData("schedule", scheduleList);
		return msg;
	}

	@RequestMapping(value = "listDetail.do")
	public @ResponseBody ResponseMessage scheduleDetailList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Schedule schedule = this.getJsonJavaByInterceptor(request, Schedule.class);

		if (StringUtils.isEmpty(schedule.getUserId()))
			return ResponseMessage.createErrorResponse("1101");
		if (!this.isVerfityUser(request, schedule.getUserId()))
			return ResponseMessage.createErrorResponse("1106");

		ResponseMessage msg = ResponseMessage.createSuccessResponse("0000");
		Page<Schedule> scheduleList = scheduleService.queryScheduleDetailList(schedule);
		msg.setData("schedule", scheduleList);
		return msg;
	}

	@RequestMapping(value = "listHoliday.do")
	public @ResponseBody ResponseMessage holidayList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Holiday holiday = this.getJsonJavaByInterceptor(request, Holiday.class);
		ResponseMessage msg = ResponseMessage.createSuccessResponse("0000");
		List<Holiday> holidayList = holidayService.selectByScope(holiday);
		msg.setData("holiday", holidayList);
		return msg;
	}

	@RequestMapping(value = "attention.do")
	public @ResponseBody ResponseMessage attention(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Attention attention = this.getJsonJavaByInterceptor(request, Attention.class);
		ResponseMessage msg = ResponseMessage.createSuccessResponse("0000");

		if (StringUtils.isEmpty(attention.getAttentionType()))
			return ResponseMessage.createErrorResponse("1112");
		if (StringUtils.isEmpty(attention.getScheduleTreatType()))
			return ResponseMessage.createErrorResponse("1113");
		
		if(!"4".equalsIgnoreCase(attention.getScheduleTreatType()))
		{
			if (StringUtils.isEmpty(attention.getScheduleTreatPart()))
				return ResponseMessage.createErrorResponse("1127");
		}
		attention = attentionService.queryAttention(attention);
		msg.setData("attention", attention);
		return msg;
	}

	/**
	 * 显示图片
	 * 
	 * @param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "attentionImage.do")
	public ModelAndView showImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String filePath = request.getParameter("filePath");
		// 返回图片显示
		FileOperateUtil.view(request, response, AppCache.serviceConfig.get("attention.photo.dir") + filePath);

		return null;
	}
}
