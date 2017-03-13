package api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.makervt.core.util.EncrypCoder;
import com.makervt.core.util.HttpUtils;
import com.makervt.elekta.entity.Doctor;
import com.makervt.elekta.entity.DoctorPraise;
import com.makervt.elekta.entity.User;
import com.thoughtworks.xstream.XStream;

import junit.framework.TestCase;


public class TestDoctorApi  extends TestCase{
	//private static String context="http://localhost:8080/elekta/";
	//private static String context="http://123.56.17.32:18080/elekta/";
	private static String context="http://106.120.211.34:8080/elekta/";
	protected Logger logger = LoggerFactory.getLogger(getClass());
	private XStream xs=new XStream();
	
	public void testQueryDocotor(){ 
	
        Doctor doctor=new Doctor(); 
        doctor.setUserId("19334");
        HttpUtils http=new HttpUtils();
        String result= http.sendPostJson(context+"doctor/query.do", JSON.toJSONString(doctor));
       logger.debug(result);
        assertNotNull(result); 
    } 
	
	public void testPraiseDoctor(){ 
		DoctorPraise doctorPraise=new DoctorPraise(); 
		doctorPraise.setUserId("abc1234");
		doctorPraise.setDoctorId("1");
       // user.setUserIp("125.34.128.242");
        HttpUtils http=new HttpUtils();
       String result= http.sendPostJson(context+"doctor/praise.do", JSON.toJSONString(doctorPraise));
       logger.debug(result);
        assertNotNull(result); 
    } 
	
	public void testIsPraiseDoctor(){ 
		DoctorPraise doctorPraise=new DoctorPraise(); 
		doctorPraise.setUserId("abc1234");
		doctorPraise.setDoctorId("1");
       // user.setUserIp("125.34.128.242");
        HttpUtils http=new HttpUtils();
       String result= http.sendPostJson(context+"doctor/isPraise.do", JSON.toJSONString(doctorPraise));
       logger.debug(result);
        assertNotNull(result); 
    } 
	
	
}
