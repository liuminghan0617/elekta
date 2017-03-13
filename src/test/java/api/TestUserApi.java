package api;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.makervt.core.util.EncrypCoder;
import com.makervt.core.util.HttpUtils;
import com.makervt.elekta.entity.User;
import com.thoughtworks.xstream.XStream;

import junit.framework.TestCase;


public class TestUserApi  extends TestCase{
	//private static String context="http://localhost:8080/elekta/";
	//private static String context="http://123.56.17.32:18080/elekta/";
	private static String context="http://106.120.211.34:8080/elekta/";
	protected Logger logger = LoggerFactory.getLogger(getClass());
	private XStream xs=new XStream();
	
	public void testLogin(){ 
	
        User user=new User(); 
        user.setUserMobile("13967431219");
        user.setUserMrNo("0000308963");
        user.setUserDeviceToken("jhjkhjkhjkhj");
        user.setUserDeviceType("ANDROID");
        HttpUtils http=new HttpUtils();
       String result= http.sendPostJson(context+"login.do", JSON.toJSONString(user));
       logger.debug(result);
        assertNotNull(result); 
    } 
	
	public void testLoginBbs(){ 
		
        HashMap user=Maps.newHashMap();
        user.put("username", "13810034139");
        user.put("password", "abc123");
        user.put("rememberMe", false);
        user.put("returnUrl", "/");
		
        StringBuffer loginBbs=new StringBuffer();
        loginBbs.append("username="+"13810034139");
        loginBbs.append("&password="+"abc123");
        loginBbs.append("&rememberMe=false");
        loginBbs.append("&returnUrl=/");
        HttpUtils http=new HttpUtils();
       String result= http.sendPost(context+"login.do",loginBbs.toString() );
       logger.debug(result);
        assertNotNull(result); 
    } 
	
	
	public void testValidSms(){ 
        User user=new User(); 
        user.setUserId("21649");
        user.setUserMobileSmsCode("746856");
        HttpUtils http=new HttpUtils();
       String result= http.sendPostJson(context+"user/validSms.do", JSON.toJSONString(user));
       logger.debug(result);
        assertNotNull(result); 
    } 
	
	public void testSendCode(){ 
        User user=new User(); 
        user.setUserId("test13800138000abc1234");
        HttpUtils http=new HttpUtils();
       String result= http.sendPostJson(context+"user/sendVerifyCode.do", JSON.toJSONString(user));
       logger.debug(result);
        assertNotNull(result); 
    } 
	
	public void testJson()
	{
		HashMap map=Maps.newHashMap();
		HashMap map1=Maps.newHashMap();
		String [] users={"1","2","3"};
		map1.put("type", "1");
		map1.put("content", "推送消息");
		map.put("pushType", "unicast");
		map.put("text", map1);
		map.put("ticker", "新问卷通知");
		map.put("title", "新问卷通知");
		map.put("users", users);
		System.out.println(JSON.toJSONString(map));
		
	}
	
	
}
