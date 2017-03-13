package api;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.makervt.core.util.HttpUtils;
import com.makervt.elekta.entity.Attention;
import com.makervt.elekta.entity.Holiday;
import com.makervt.elekta.domain.Schedule;
import com.thoughtworks.xstream.XStream;

import junit.framework.TestCase;

public class TestScheduleApi  extends TestCase{
	//private static String context="http://localhost:8080/elekta/";
	//private static String context="http://123.56.17.32:18080/elekta/";
	private static String context="http://106.120.211.34:8080/elekta/";
	protected Logger logger = LoggerFactory.getLogger(getClass());
	private XStream xs=new XStream();
	public void testSchedulelist(){ 
		Schedule schedule=new Schedule();
		schedule.setUserId("19251");
		schedule.setScheduleStartTime("2016-02-01");
		schedule.setScheduleEndTime("2016-12-31");
        HttpUtils http=new HttpUtils();
       String result= http.sendPostJson(context+"schedule/list.do", JSON.toJSONString(schedule));
       logger.debug(result);
        assertNotNull(result); 
    } 
	
	public void testScheduleDetailList(){ 
		Schedule schedule=new Schedule();
		schedule.setUserId("19243");
		schedule.setScheduleDate("2016-03-03");
		Map map=schedule.returnMap();
		map.put("pageNo", 1);
		map.put("pageSize", 10);
        HttpUtils http=new HttpUtils();
       String result= http.sendPostJson(context+"schedule/listDetail.do",JSON.toJSONString(map));
       logger.debug(result);
        assertNotNull(result); 
    } 
	
	public void testHolidayList(){ 
        HttpUtils http=new HttpUtils();
        Holiday holiday=new Holiday();
        holiday.setHolidayId("D111");
        holiday.setHolidayStartDate("2016-01-05");
        holiday.setHolidayEndDate("2016-01-08");
       String result= http.sendPostJson(context+"schedule/listHoliday.do", JSON.toJSONString(holiday));
       logger.debug(result);
        assertNotNull(result); 
    } 
	
	public void testAttention(){ 
		Attention att=new Attention();
		att.setScheduleTreatType("0");
		att.setScheduleTreatPart("13");
		att.setAttentionType("0");
        HttpUtils http=new HttpUtils();
        logger.debug(JSON.toJSONString(att));
        String result= http.sendPostJson(context+"schedule/attention.do", JSON.toJSONString(att));
       logger.debug(result);
        assertNotNull(result); 
    } 
}
