package com.makervt.elekta.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.annotation.JSONType;
import com.makervt.core.domain.Page;

/**
 * mapping for Schedule
 * meaning 日程表
 * @author CodeGenerator
 */
 @JSONType(ignores = {"pageNo", "pageSize", "pageTotal","totalCount","start"})
public class Schedule extends Page<Schedule>{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 醫院標識
	 */
	private String scheduleHospId;
	
	/**
	 * 醫院名稱
	 */
	private String scheduleHospName;
	
	/**
	 * mapping for Schedule.Schedule_id
	 * meaning 
	 */
	private String scheduleId;

	/**
	 * mapping for Schedule.User_id
	 * meaning 
	 */
	private String userId;
	
	/**
	 * 预约类型(0 预约 ，1复诊)
	 */
	private String scheduleType;
	
	/**
	 * 预约治疗类型(0：CT，1：体位固定，2：复位  3：放疗)
	 */
	private String scheduleTreatType;
	
	/**
	 * mapping for Schedule.Schedule_item
	 * meaning 预约治疗类型中文名称
	 */
	private String scheduleTreatItem;
	
	/**
	 * 预约治疗部位标识
	 */
	private String scheduleTreatPart;

	/**
	 * 预约治疗部位名称
	 */
	private String scheduleTreatPartName;
	
	/**
	 * mapping for Schedule.Schedule_time
	 * meaning 预约时间(2015.12.31 15.00)
	 */
	private String scheduleTime;
	
	/**
	 * 预计等待时间
	 */
	private String scheduleWaitTime;
	
	/**
	 * 上一次治疗时间
	 */
	private String scheduleLastTime;
	
	/**
	 * 下一次治疗时间
	 */
	private String scheduleNextTime;
	
	/**
	 * 首次治疗时间
	 */
	private String scheduleFirstTime;
	
	private String scheduleStartTime;
	
	
	private String scheduleEndTime;

	private String scheduleDate;
	
	/**
	 * 标识日期为上午 下午
	 */
	private String scheduleDatePart;

	/**
	 * mapping for Schedule.Schedule_status
	 * meaning 报到状态（1已报到 0未报到）
	 */
	private String scheduleStatus;

	/**
	 * mapping for Schedule.Schedule_addr
	 * meaning 门诊地点（21室）
	 */
	private String scheduleAddr;

	/**
	 * mapping for Schedule.Schedule_queue
	 * meaning 排队情况
	 */
	private List scheduleQueue;

	/**
	 * get Schedule.Schedule_id
	 * @return 
	 */
	public String getScheduleId() {
		return this.scheduleId;
	}

	/**
	 * set Schedule.Schedule_id
	 * @param 
	 */
	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

	/**
	 * get Schedule.User_id
	 * @return 
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * set Schedule.User_id
	 * @param 
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * get Schedule.Schedule_time
	 * @return 预约时间(2015.12.31 15.00)
	 */
	public String getScheduleTime() {
		return this.scheduleTime;
	}

	/**
	 * set Schedule.Schedule_time
	 * @param 预约时间(2015.12.31 15.00)
	 */
	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}


	/**
	 * get Schedule.Schedule_status
	 * @return 报到状态（1已报到 0未报到）
	 */
	public String getScheduleStatus() {
		return this.scheduleStatus;
	}

	/**
	 * set Schedule.Schedule_status
	 * @param 报到状态（1已报到 0未报到）
	 */
	public void setScheduleStatus(String scheduleStatus) {
		this.scheduleStatus = scheduleStatus;
	}

	/**
	 * get Schedule.Schedule_addr
	 * @return 门诊地点（21室）
	 */
	public String getScheduleAddr() {
		return this.scheduleAddr;
	}

	/**
	 * set Schedule.Schedule_addr
	 * @param 门诊地点（21室）
	 */
	public void setScheduleAddr(String scheduleAddr) {
		this.scheduleAddr = scheduleAddr;
	}
	
	public String getScheduleStartTime() {
		return scheduleStartTime;
	}

	public void setScheduleStartTime(String scheduleStartTime) {
		this.scheduleStartTime = scheduleStartTime;
	}

	public String getScheduleEndTime() {
		return scheduleEndTime;
	}

	public void setScheduleEndTime(String scheduleEndTime) {
		this.scheduleEndTime = scheduleEndTime;
	}

	/**
	 * get Schedule.Schedule_queue
	 * @return 排队情况
	 */
	public List getScheduleQueue() {
		return this.scheduleQueue;
	}

	/**
	 * set Schedule.Schedule_queue
	 * @param 排队情况
	 */
	public void setScheduleQueue(List scheduleQueue) {
		this.scheduleQueue = scheduleQueue;
	}
	
	public String getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	
	public String getScheduleType() {
		return scheduleType;
	}

	public void setScheduleType(String scheduleType) {
		this.scheduleType = scheduleType;
	}

	public String getScheduleTreatType() {
		return scheduleTreatType;
	}

	public void setScheduleTreatType(String scheduleTreatType) {
		this.scheduleTreatType = scheduleTreatType;
	}

	public String getScheduleWaitTime() {
		return scheduleWaitTime;
	}

	public void setScheduleWaitTime(String scheduleWaitTime) {
		this.scheduleWaitTime = scheduleWaitTime;
	}

	public String getScheduleLastTime() {
		return scheduleLastTime;
	}

	public void setScheduleLastTime(String scheduleLastTime) {
		this.scheduleLastTime = scheduleLastTime;
	}

	public String getScheduleNextTime() {
		return scheduleNextTime;
	}

	public void setScheduleNextTime(String scheduleNextTime) {
		this.scheduleNextTime = scheduleNextTime;
	}
	
	public String getScheduleFirstTime() {
		return scheduleFirstTime;
	}

	public void setScheduleFirstTime(String scheduleFirstTime) {
		this.scheduleFirstTime = scheduleFirstTime;
	}

	public String getScheduleTreatItem() {
		return scheduleTreatItem;
	}

	public void setScheduleTreatItem(String scheduleTreatItem) {
		this.scheduleTreatItem = scheduleTreatItem;
	}
	
	public String getScheduleHospId() {
		return scheduleHospId;
	}

	public void setScheduleHospId(String scheduleHospId) {
		this.scheduleHospId = scheduleHospId;
	}

	public String getScheduleHospName() {
		return scheduleHospName;
	}

	public void setScheduleHospName(String scheduleHospName) {
		this.scheduleHospName = scheduleHospName;
	}

	public String getScheduleTreatPart() {
		return scheduleTreatPart;
	}

	public void setScheduleTreatPart(String scheduleTreatPart) {
		this.scheduleTreatPart = scheduleTreatPart;
	}

	public String getScheduleTreatPartName() {
		return scheduleTreatPartName;
	}

	public void setScheduleTreatPartName(String scheduleTreatPartName) {
		this.scheduleTreatPartName = scheduleTreatPartName;
	}
	
	public String getScheduleDatePart() {
		return scheduleDatePart;
	}

	public void setScheduleDatePart(String scheduleDatePart) {
		this.scheduleDatePart = scheduleDatePart;
	}

	public  Map<String,Object> returnMap()
	{
		 Map<String,Object> returnMap =new HashMap<String,Object>();
		 	returnMap.put("scheduleId",this.scheduleId);
		 	returnMap.put("userId",this.userId);
		 	returnMap.put("scheduleTime",this.scheduleTime);
		 	returnMap.put("scheduleTreatItem",this.scheduleTreatItem);
		 	returnMap.put("scheduleStatus",this.scheduleStatus);
		 	returnMap.put("scheduleAddr",this.scheduleAddr);
		 	returnMap.put("scheduleQueue",this.scheduleQueue);
		 	returnMap.put("scheduleDate",this.scheduleDate);
		 	returnMap.put("scheduleDatePart",this.scheduleDatePart);
		 	returnMap.put("scheduleHospId",this.scheduleHospId);
		 	returnMap.put("scheduleHospName",this.scheduleHospName);
		 return returnMap;
	}
}
