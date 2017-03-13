package api;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.makervt.core.util.HttpUtils;
import com.makervt.elekta.domain.Healing;
import com.makervt.elekta.domain.Schedule;
import com.makervt.elekta.entity.Message;
import com.thoughtworks.xstream.XStream;

import junit.framework.TestCase;

public class TestMessageApi  extends TestCase{
	private static String context="http://localhost:8080/elekta/";
	//private static String context="http://123.56.17.32:18080/elekta/";
	//private static String context="http://106.120.211.34:8080/elekta/";
	protected Logger logger = LoggerFactory.getLogger(getClass());
	private XStream xs=new XStream();
	public void testMessagelist(){ 
		for(int  i=0;i<=5;i++)
		{
			Message message=new Message();
			message.setUserId("test13810034139abc1234");
			//message.setMessageType("0");
			Map map=message.returnMap();
			map.put("pageNo", "1");
			map.put("pageSize", 5);
	        HttpUtils http=new HttpUtils();
	       String result= http.sendPostJson(context+"message/list.do", JSON.toJSONString(map));
	       logger.debug(result);
	        assertNotNull(result);
		}
    } 
	public void testCountMessage(){ 
		Message message=new Message();
		message.setUserId("test13800138000abc1234");
        HttpUtils http=new HttpUtils();
       String result= http.sendPostJson(context+"message/count.do", JSON.toJSONString(message));
       logger.debug(result);
        assertNotNull(result); 
    } 
	
	public void testViewMessage(){ 
		Message message=new Message();
		message.setUserId("6");
		message.setMessageId("1");
        HttpUtils http=new HttpUtils();
       String result= http.sendPostJson(context+"message/view.do", JSON.toJSONString(message));
       logger.debug(result);
        assertNotNull(result); 
    } 
	
	public void testHealing(){ 
		Healing att=new Healing();
		att.setUserId("1");
        HttpUtils http=new HttpUtils();
       String result= http.sendPostJson(context+"message/healing.do", JSON.toJSONString(att));
       logger.debug(result);
        assertNotNull(result); 
    } 
}
