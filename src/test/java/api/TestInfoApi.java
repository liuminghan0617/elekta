package api;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.makervt.core.util.HttpUtils;
import com.makervt.elekta.domain.Schedule;
import com.makervt.elekta.entity.Info;
import com.thoughtworks.xstream.XStream;

import junit.framework.TestCase;

public class TestInfoApi  extends TestCase{
	private static String context="http://localhost:8080/elekta/";
	//private static String context="http://123.56.17.32:18080/elekta/";
	//private static String context="http://106.120.211.34:8080/elekta/";
	protected Logger logger = LoggerFactory.getLogger(getClass());
	private XStream xs=new XStream();
	public void testInfolist(){ 
		Info info=new Info();
		Map queryMap=info.returnMap();
		queryMap.put("pageNo", "1");
		//queryMap.put("userId", "59");
		queryMap.put("pageSize", "10");
        HttpUtils http=new HttpUtils();
       String result= http.sendPostJson(context+"info/list.do", JSON.toJSONString(queryMap));
       logger.debug(result);
        assertNotNull(result); 
    } 
}
