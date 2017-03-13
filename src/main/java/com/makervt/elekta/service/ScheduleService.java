package com.makervt.elekta.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.makervt.core.domain.Page;
import com.makervt.core.domain.ResponseMessage;
import com.makervt.elekta.dao.HolidayDao;
import com.makervt.elekta.domain.Schedule;
import com.makervt.elekta.entity.Holiday;

@Service("scheduleService")
public class ScheduleService {

	public List<Schedule> queryScheduleList(Schedule schedule) throws Exception {
		
		return MipProviderService.queryScheduleListByMip(schedule);
	}

	/**
	 * 查询指定日期的预约明细
	 * 
	 * @param schedule
	 * @return
	 * @throws ParseException
	 */
	public Page<Schedule> queryScheduleDetailList(Schedule schedule) throws ParseException {
		return MipProviderService.queryScheduleDetailListByMip(schedule);
	}
}
