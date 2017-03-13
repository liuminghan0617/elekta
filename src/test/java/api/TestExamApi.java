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
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Maps;
import com.makervt.core.util.HttpUtils;
import com.makervt.elekta.entity.UserExam;
import com.makervt.elekta.entity.UserQuestion;
import com.thoughtworks.xstream.XStream;

import junit.framework.TestCase;

public class TestExamApi extends TestCase {
	//private static String context = "http://localhost:8080/elekta/";
	// private static String context="http://123.56.17.32:18080/elekta/";
	private static String context="http://106.120.211.34:8080/elekta/";
	protected Logger logger = LoggerFactory.getLogger(getClass());
	private XStream xs = new XStream();

	public void testlist() {
		UserExam userExam = new UserExam();
		userExam.setUserId("test13810034139abc1234");
		//userExam.setUserExamProgress("0");
		//userExam.setUserExamStatus("0");
		Map queryMap = userExam.returnMap();
		queryMap.put("pageNo", "1");
		queryMap.put("pageSize", "10");
		HttpUtils http = new HttpUtils();
		String result = http.sendPostJson(context + "exam/list.do", JSON.toJSONString(queryMap));
		logger.debug(result);
		assertNotNull(result);
	}

	public void testCount() {
		UserExam userExam = new UserExam();
		userExam.setUserId("test13810034139abc1234");
		userExam.setUserExamStatus("0");
		HttpUtils http = new HttpUtils();
		String result = http.sendPostJson(context + "exam/count.do", JSON.toJSONString(userExam));
		logger.debug(result);
		assertNotNull(result);
	}

	public void testListQuestion() {
		UserQuestion question = new UserQuestion();
		question.setUserExamId("1284");
		// question.setExamId("e1");
		question.setUserId("21649");
		HttpUtils http = new HttpUtils();
		String result = http.sendPostJson(context + "exam/listQuestion.do", JSON.toJSONString(question));
		logger.debug(result);
		assertNotNull(result);
	}

	public void testAnswer() {
		UserQuestion question = new UserQuestion();
		question.setUserQuestionId("2853");
		question.setUserId("29109");
		question.setUserQuestionAnswer("1");

		question.setUserQuestionAdditionalText("精神状态也不好");
	

		HashMap<String, String> params = Maps.newHashMap();
		params.put("jsonData", JSON.toJSONString(question, SerializerFeature.SortField));
		HttpUtils http = new HttpUtils();
		String[] filePaths = null;
		filePaths=StringUtils.addStringToArray(filePaths,
		"E:\\usr\\elekta\\shebude.mid");
		filePaths=StringUtils.addStringToArray(filePaths,
		"E:\\usr\\elekta\\a.jpg");
		filePaths=StringUtils.addStringToArray(filePaths,
		"E:\\usr\\elekta\\b.jpg");
		filePaths = StringUtils.addStringToArray(filePaths, "E:\\usr\\elekta\\c.jpg");

		String result = "";
		try {
			result = http.sendPostFile(context + "exam/answer.do", filePaths, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug(result);
		assertNotNull(result);
	}

	public void testSubmitExam() {
		UserExam userExam = new UserExam();
		userExam.setUserExamId("4");
		HttpUtils http = new HttpUtils();
		String result = "";
		try {
			result = http.sendPostJson(context + "exam/submitExam.do", JSON.toJSONString(userExam));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug(result);
		assertNotNull(result);
	}
}
