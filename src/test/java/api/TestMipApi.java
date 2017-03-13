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
import com.google.common.collect.Maps;
import com.makervt.core.component.push.model.UmengPush;
import com.makervt.core.domain.ResponseMessage;
import com.makervt.core.util.DateUtils;
import com.makervt.core.util.HttpUtils;
import com.makervt.core.util.MapUtils;
import com.makervt.elekta.entity.Attention;
import com.makervt.elekta.entity.Doctor;
import com.makervt.elekta.entity.Exam;
import com.makervt.elekta.entity.Holiday;
import com.makervt.elekta.entity.Info;
import com.makervt.elekta.entity.Message;
import com.makervt.elekta.entity.Question;
import com.makervt.elekta.entity.QuestionChoice;
import com.makervt.elekta.entity.QuestionExamplePic;
import com.makervt.elekta.entity.UserExam;
import com.thoughtworks.xstream.XStream;

import junit.framework.TestCase;

public class TestMipApi extends TestCase {
	//private static String context = "http://localhost:8080/elekta/";
	//private static String context="http://123.56.17.32:8080/elekta/";
	private static String context="http://106.120.211.34:8080/elekta/";
	protected Logger logger = LoggerFactory.getLogger(getClass());
	private XStream xs = new XStream();

	public void testAddDocotor() {

		Doctor doctor = new Doctor();
		//doctor.setUserId("56");
		doctor.setDoctorId("346");
		doctor.setDoctorHospId("H0001");
		doctor.setDoctorHospName("广州中山大学附属肿瘤医院");
		doctor.setDoctorName("刘慧（小）");
		doctor.setDoctorPhotoUrl("liuhui1.jpg");
		doctor.setDoctorSummary("主任医师、硕士生导师、放疗科副主任，擅长胸部肿瘤（肺癌、食道癌、纵膈肿瘤）的放射治疗");
		doctor.setDoctorContent("<html><body><p style='margin: 5px 0px; color: rgb(0, 0, 0); font-family: sans-serif; font-size: 16px; font-style: normal; font-variant: normal; font-weight: normal; letter-spacing: normal; line-height: normal; orphans: auto; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; widows: 1; word-spacing: 0px; -webkit-text-stroke-width: 0px;'>一、基本情况</p><p style='margin: 5px 0px; color: rgb(0, 0, 0); font-family: sans-serif; font-size: 16px; font-style: normal; font-variant: normal; font-weight: normal; letter-spacing: normal; line-height: normal; orphans: auto; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; widows: 1; word-spacing: 0px; -webkit-text-stroke-width: 0px;'>职称：主任医师、硕士生导师<br/></p><p style='margin: 5px 0px; color: rgb(0, 0, 0); font-family: sans-serif; font-size: 16px; font-style: normal; font-variant: normal; font-weight: normal; letter-spacing: normal; line-height: normal; orphans: auto; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; widows: 1; word-spacing: 0px; -webkit-text-stroke-width: 0px;'>职务：放疗科副主任<br/></p><p style='margin: 5px 0px; color: rgb(0, 0, 0); font-family: sans-serif; font-size: 16px; font-style: normal; font-variant: normal; font-weight: normal; letter-spacing: normal; line-height: normal; orphans: auto; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; widows: 1; word-spacing: 0px; -webkit-text-stroke-width: 0px;'>专家门诊时间：周四上午<br/></p><p style='margin: 5px 0px; color: rgb(0, 0, 0); font-family: sans-serif; font-size: 16px; font-style: normal; font-variant: normal; font-weight: normal; letter-spacing: normal; line-height: normal; orphans: auto; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; widows: 1; word-spacing: 0px; -webkit-text-stroke-width: 0px;'>专业特长：肿瘤放射治疗。特别擅长胸部肿瘤（肺癌、食道癌、纵膈肿瘤）的放射治疗及研究。<br/></p><p style='margin: 5px 0px; color: rgb(0, 0, 0); font-family: sans-serif; font-size: 16px; font-style: normal; font-variant: normal; font-weight: normal; letter-spacing: normal; line-height: normal; orphans: auto; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; widows: 1; word-spacing: 0px; -webkit-text-stroke-width: 0px;'>二、学习及工作经历：<br/></p><ul class=' list-paddingleft-2' style='margin: 0px; width: 801.796875px; padding-left: 30px; color: rgb(0, 0, 0); font-family: sans-serif; font-size: 16px; font-style: normal; font-variant: normal; font-weight: normal; letter-spacing: normal; line-height: normal; orphans: auto; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; widows: 1; word-spacing: 0px; -webkit-text-stroke-width: 0px;'><li><p style='margin: 5px 0px;'>1994年—1999年：中山医科大学临床医疗系就读<br/></p></li><li><p style='margin: 5px 0px;'>1999年—2001年：中山医科大学附属肿瘤医院放疗科硕士研究生<br/></p></li><li><p style='margin: 5px 0px;'>2004年—2007年：中山医科大学附属肿瘤医院放疗科博士研究生<br/></p></li><li><p style='margin: 5px 0px;'>2001年—至今：中山大学附属肿瘤医院工作<br/></p></li><li><p style='margin: 5px 0px;'>2010年—2011年：美国MD Anderson癌症中心工作<br/></p></li></ul><p style='margin: 5px 0px; color: rgb(0, 0, 0); font-family: sans-serif; font-size: 16px; font-style: normal; font-variant: normal; font-weight: normal; letter-spacing: normal; line-height: normal; orphans: auto; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; widows: 1; word-spacing: 0px; -webkit-text-stroke-width: 0px;'>三、学术兼职：<br/></p><ol class=' list-paddingleft-2' style='margin: 0px; width: 801.797px; padding-left: 30px; color: rgb(0, 0, 0); font-family: sans-serif; font-size: 16px; font-style: normal; font-variant: normal; font-weight: normal; letter-spacing: normal; line-height: normal; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; widows: 1; word-spacing: 0px;'><li><p style='margin: 5px 0px;'>中山大学附属肿瘤医院肺癌研究所委员<br/></p></li><li><p style='margin: 5px 0px;'>广东省放射治疗质控中心秘书</p></li></ol></body></html>");
		HttpUtils http = new HttpUtils();
		Map<String, String> params = Maps.newConcurrentMap();
		params.put("jsonData", JSON.toJSONString(doctor));
		String[] filePaths = null;
		filePaths = StringUtils.addStringToArray(filePaths, "E:\\usr\\elekta\\liuhui1.jpg");
		//filePaths = StringUtils.addStringToArray(filePaths, "E:\\usr\\elekta\\huatuo2.jpg");
		
		String result = "";
		try {
			result = http.sendPostFile(context + "mip/docotor.do", filePaths, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(JSON.toJSONString(doctor));
		logger.debug(result);
		assertNotNull(result);
	}

	public void testAttention() {
		String content="<div style='width:85%;margin:0 auto'>    <p>        <span style='font-size:24px;font-family:宋体, SimSun'>注意事项：</span>    </p>    <p style='line-height:150%'>        <span style='font-family:宋体, SimSun'><span style='line-height: 150%;'></span></span>    </p>    <hr/>    <p>        <span style='font-size:18px;font-family:宋体, SimSun'>为了保证放疗计划实施的准确性，我们需要病人配合做相应部位的体位固定，使得每次治疗时体位保持一致。</span>    </p>    <p>        <span style='font-size:18px;font-family:宋体, SimSun'>1.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 如果您的治疗部位在头颈部，请剪齐耳短发，穿棉质低领上衣，除去头部、颈部的所有饰品。</span>    </p>    <p style='text-align: center;'>        <span style='font-size:18px;font-family:宋体, SimSun'>配图一：头颈肩面罩（固定头颈部）：</span>    </p>    <p style='text-align: center; line-height: 150%;'>        <span style='font-size:18pxfont-family:宋体, SimSun'>&nbsp;<img src='http://ueditor.baidu.com/server/umeditor/upload/pic1.png' _src='http://ueditor.baidu.com/server/umeditor/upload/pic1.png'/></span>    </p>    <p>        <span style='font-size:18px;font-family:宋体, SimSun'>2.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 如果您的治疗部位在胸部、腹部或是盆腔部位，请在治疗部位以及周围保持皮肤干爽。</span>    </p>    <p style='text-align: center;'>        <span style='font-size:18px;font-family:宋体, SimSun'>配图二：体部真空袋（固定胸腹部、盆腔）</span>    </p>    <p style='text-align: center; line-height: 150%;'>        <span style='undefinedfont-size:18pxfont-family:宋体, SimSun'>&nbsp;<img src='http://ueditor.baidu.com/server/umeditor/upload/pic2.png' _src='http://ueditor.baidu.com/server/umeditor/upload/pic2.png'/></span>    </p>    <p>        <span style='font-size:18px;font-family:宋体, SimSun'>3.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 每次治疗使用前请您留心皮肤、固定器上所有的标示：</span>    </p>    <p style='text-align: center; '>        <span style='font-size:18px;font-family:宋体, SimSun'>配图三：面罩表面标记线</span>    </p>    <p style='text-align: left; line-height: 150%;'>        <span style='font-family:宋体font-size:18pxfont-family:宋体, SimSun'><br/></span>    </p>    <p style='text-align: center; line-height: 150%;'>        <span style='font-family:宋体font-size:18pxfont-family:宋体, SimSun'><img src='http://ueditor.baidu.com/server/umeditor/upload/pic3.png' _src='http://ueditor.baidu.com/server/umeditor/upload/pic3.png'/></span>    </p>    <p style='line-height:150%'></p>    <p>        <span style='font-size:18px;font-family:宋体, SimSun'>4.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 如有脱落、模糊，请联系您的放射治疗师或主管医生帮您解</span>    </p>    <p>        <span style='font-size:18px;font-family:宋体, SimSun'>5.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 体部真空袋每次使用时注意是否出现变软情况，如果出现请及时在负二层13号房抽真空，防止因漏气而严重变形，影响治疗精确度。</span>    </p>    <p>        <br/>    </p></div>";
		for(int i=0;i<1;i++)
		{
		Attention attention = new Attention();
		attention.setAttentionId(String.valueOf(1+i));
		attention.setScheduleTreatType(String.valueOf(i));
		attention.setAttentionHospId("ID001");
		attention.setAttentionHospName("北京肿瘤医院");
		attention.setAttentionType("0");
		attention.setScheduleTreatItem("CT");
		attention.setScheduleTreatPart("0");
		attention.setScheduleTreatPartName("头颈部");
		attention.setAttentionTitle("体位固定");
		attention.setAttentionContent(content);
		HttpUtils http = new HttpUtils();
		Map<String, String> params = Maps.newConcurrentMap();
		params.put("jsonData", JSON.toJSONString(attention));

		String[] filePaths = null;
		filePaths = StringUtils.addStringToArray(filePaths, "E:\\usr\\elekta\\pic1.png");
		filePaths = StringUtils.addStringToArray(filePaths, "E:\\usr\\elekta\\pic2.png");
	    filePaths = StringUtils.addStringToArray(filePaths, "E:\\usr\\elekta\\pic3.png");
		String result = "";
		try {
			result = http.sendPostFile(context + "mip/attention.do", filePaths, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(JSON.toJSONString(attention));
		logger.debug(result);
		assertNotNull(result);
		}
	}
	public void testAttentionBL() {
		String content="<div style='width:85%;margin:0 auto'>    <p>        <strong><span style='font-size:24px;font-family:宋体, SimSun'><strong style='white-space: normal;'><span style='font-size:24px;font-family:宋体, SimSun'>24号字 宋体 加粗&nbsp;</span></strong>流程介绍：</span></strong>    </p>    <p class='MsoListParagraph'>        <span style='font-size:18px;font-family:宋体, SimSun'><span>1.<span style='line-height: normal;'>&nbsp;&nbsp;<span style='white-space: normal;'>18号字 宋体正常</span> </span></span>携带预约信息表在预约时间前往医院&nbsp;</span>    </p>    <p class='MsoListParagraph'>        <span style='font-family:宋体, SimSun;font-size:18px'><span>2.<span style='line-height: normal;'>&nbsp;&nbsp;</span></span>在负二层的自助排队机前进行报到。</span>    </p>    <p class='MsoListParagraph'>        <span style='font-family:宋体, SimSun;font-size:18px'><span>3.<span style='line-height: normal;'>&nbsp;&nbsp;</span></span>听到大屏幕显示名字并且呼叫您的姓名后进入固定室进行固定。</span>    </p>    <p class='MsoListParagraph'>        <span style='font-family:宋体, SimSun;font-size:18px'><span>4.<span style='line-height: normal;'>&nbsp;&nbsp;</span></span>固定完毕后，携带预约信息表将做好的体位固定器存放在放疗中心负二层<span>13</span>号房间。</span>    </p>    <p class='MsoListParagraph'>        <span style='font-family:宋体, SimSun;font-size:18px'><br/></span>    </p>    <p class='MsoListParagraph'>        <span style='font-family:宋体, SimSun;font-size:18px'></span>    </p>    <p class='MsoListParagraph' style='white-space: normal'>        <span style='font-family:宋体, SimSun;font-size:20px'>1.<span style='line-height: normal;'>&nbsp; 20号字 宋体正常&nbsp;</span>携带预约信息表在预约时间前往医院&nbsp;</span>    </p>    <p class='MsoListParagraph' style='white-space: normal'>        <span style='font-family:宋体, SimSun;font-size:20px'>2.<span style='line-height: normal'>&nbsp;&nbsp;</span>在负二层的自助排队机前进行报到。</span>    </p>    <p class='MsoListParagraph' style='white-space: normal'>        <span style='font-family:宋体, SimSun;font-size:20px'>3.<span style='line-height: normal'>&nbsp;&nbsp;</span>听到大屏幕显示名字并且呼叫您的姓名后进入固定室进行固定。</span>    </p>    <p class='MsoListParagraph' style='white-space: normal'>        <span style='font-family:宋体, SimSun;font-size:20px'>4.<span style='line-height: normal;'>&nbsp;&nbsp;</span>固定完毕后，携带预约信息表将做好的体位固定器存放在放疗中心负二层13号房间。</span>    </p>    <p class='MsoListParagraph' style='white-space: normal'>        <span style='font-family:宋体, SimSun;font-size:20px'><br/></span>    </p>    <p class='MsoListParagraph' style='white-space: normal'>        <span style='font-size: 20px;'><strong style='white-space: normal;'><span style='font-size: 24px;font-family:黑体, SimHei'><strong>24号字 黑体 加粗&nbsp;</strong>流程介绍</span></strong></span>    </p>    <p class='MsoListParagraph' style='white-space: normal'>        <span style='font-family:黑体, SimHei'><span style='font-size: 20px;'></span></span>    </p>    <p class='MsoListParagraph' style='white-space: normal'>        <span style='font-size:18px;font-family:黑体, SimHei'>1.<span style='line-height: normal;'>&nbsp;&nbsp;18号字 黑体正常&nbsp;</span>携带预约信息表在预约时间前往医院&nbsp;</span>    </p>    <p class='MsoListParagraph' style='white-space: normal'>        <span style='font-size:18px;font-family:黑体, SimHei'>2.<span style='line-height: normal'>&nbsp;&nbsp;</span>在负二层的自助排队机前进行报到。</span>    </p>    <p class='MsoListParagraph' style='white-space: normal'>        <span style='font-size:18px;font-family:黑体, SimHei'>3.<span style='line-height: normal'>&nbsp;&nbsp;</span>听到大屏幕显示名字并且呼叫您的姓名后进入固定室进行固定。</span>    </p>    <p class='MsoListParagraph' style='white-space: normal'>        <span style='font-size:18px;font-family:黑体, SimHei'>4.<span style='line-height: normal'>&nbsp;&nbsp;</span>固定完毕后，携带预约信息表将做好的体位固定器存放在放疗中心负二层13号房间。</span>    </p>    <p class='MsoListParagraph' style='white-space: normal'>        <span style='font-size:18px;font-family:黑体, SimHei'><br/></span>    </p>    <p class='MsoListParagraph' style='white-space: normal'></p>    <p class='MsoListParagraph' style='white-space: normal'>        <span style='font-size:20px;font-family:黑体, SimHei'>1.<span style='line-height: normal'>&nbsp; 20号字 黑体正常&nbsp;</span>携带预约信息表在预约时间前往医院&nbsp;</span>    </p>    <p class='MsoListParagraph' style='white-space: normal'>        <span style='font-size:20px;font-family:黑体, SimHei'>2.<span style='line-height: normal'>&nbsp;&nbsp;</span>在负二层的自助排队机前进行报到。</span>    </p>    <p class='MsoListParagraph' style='white-space: normal'>        <span style='font-size:20px;font-family:黑体, SimHei'>3.<span style='line-height: normal'>&nbsp;&nbsp;</span>听到大屏幕显示名字并且呼叫您的姓名后进入固定室进行固定。</span>    </p>    <p class='MsoListParagraph' style='white-space: normal'>        <span style='font-size:20px;font-family:黑体, SimHei'>4.<span style='line-height: normal;'>&nbsp;&nbsp;</span>固定完毕后，携带预约信息表将做好的体位固定器存放在放疗中心负二层13号房间。</span>    </p>    <p class='MsoListParagraph' style='white-space: normal'>        <span style='font-family:宋体, SimSun;font-size:20px'><br/></span><br/>    </p>    <p class='MsoListParagraph'>        <span style='font-family:宋体, SimSun;font-size:10px'><br/></span><br/>    </p>    <p>        <br/>    </p></div>";
		for(int i=0;i<4;i++)
		{
			Attention attention = new Attention();
			attention.setAttentionId(String.valueOf(5+i));
			attention.setScheduleTreatType(String.valueOf(i));
			attention.setAttentionHospId("ID001");
			attention.setAttentionHospName("北京肿瘤医院");
			attention.setAttentionType("1");
			attention.setAttentionTitle("办理流程");
			attention.setAttentionContent(content);
			HttpUtils http = new HttpUtils();
			Map<String, String> params = Maps.newConcurrentMap();
			params.put("jsonData", JSON.toJSONString(attention));
	
			String[] filePaths = null;
			//filePaths = StringUtils.addStringToArray(filePaths, "E:\\usr\\elekta\\pic1.png");
			//filePaths = StringUtils.addStringToArray(filePaths, "E:\\usr\\elekta\\pic2.png");
		   // filePaths = StringUtils.addStringToArray(filePaths, "E:\\usr\\elekta\\pic3.png");
			String result = "";
			try {
				result = http.sendPostFile(context + "mip/attention.do", filePaths, params);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(JSON.toJSONString(attention));
			logger.debug(result);
			assertNotNull(result);
		}
	}

	public void testAddExam() {
		Exam exam = new Exam();
		exam.setExamId("2");
		exam.setExamDoctorWord("该表格会帮助我更好的了解您康复的进展，以便协助判断下一步治疗计划如何进行调整，请您认真并及时作答。");
		exam.setExamTitle("生存质量第一周调查表");
		exam.setExamSummary("第一部分该表格会帮助我更好的了解您康复的进展");
		exam.setExamTotal("3");

		List<Question> questionList = new ArrayList<Question>();
		Question question = new Question();
		question.setQuestionId("1");
		question.setQuestionNo("1");
		question.setQuestionTitle("你的XX部位疼痛么");
		question.setQuestionType("word");
		question.setQuestionMultiChoice("0");
		// 选择题
		List<QuestionChoice> wordList = new ArrayList<QuestionChoice>();
		wordList.add(new QuestionChoice("1","A", "没有", ""));
		wordList.add(new QuestionChoice("2","B", "有点", ""));
		wordList.add(new QuestionChoice("3","C", "相当", ""));
		wordList.add(new QuestionChoice("4","D", "非常", ""));
		
		question.setChoiceItems(wordList);
		questionList.add(question);

		// 图片选择题
		Question quesPic = new Question();
		quesPic.setQuestionNo("2");
		quesPic.setQuestionId("2");
		quesPic.setQuestionMultiChoice("1");
		quesPic.setQuestionTitle("你那姿势睡眠好");
		quesPic.setQuestionType("pic");
		List<QuestionChoice> picList = new ArrayList<QuestionChoice>();
		picList.add(
				new QuestionChoice("5","A", "没有", "http://im.zhongxin588.com/forum/201403/20/a.jpg"));
		picList.add(
				new QuestionChoice("6","B", "有点", "http://im.zhongxin588.com/forum/201403/20/b.jpg"));
		picList.add(
				new QuestionChoice("7","C", "相当", "http://im.zhongxin588.com/forum/201403/20/c.jpg"));
		picList.add(
				new QuestionChoice("8","D", "非常", "http://im.zhongxin588.com/forum/201403/20/d.jpg"));
		quesPic.setChoiceItems(picList);
		questionList.add(quesPic);

		Question quesDesc = new Question();
		List<QuestionExamplePic> pics = new ArrayList<QuestionExamplePic>();
		QuestionExamplePic pic = new QuestionExamplePic();
		quesDesc.setQuestionExampleContent("<html><body><p>XXXXX说明</p><p><img src='http://example.jpg'></p></body></html>");
		pic.setQuestionExamplePicUrl("example.jpg");
		pics.add(pic);
		quesDesc.setQuestionId("3");
		quesDesc.setQuestionNo("3");
		quesDesc.setQuestionType("desc");
		quesDesc.setQuestionTitle("你对治疗有哪些意见？");
		quesDesc.setExamplePic(pics);
		questionList.add(quesDesc);

		exam.setQuestions(questionList);

		HttpUtils http = new HttpUtils();
		Map<String, String> params = Maps.newConcurrentMap();
		//String text="{\"examDoctorWord\":\"问卷说明\",\"examSummary\":\"问卷描述\",\"examTitle\":\"问卷调查测试\",\"examTotal\":\"2\",\"examId\":\"H0001-33\",\"questions\":[{\"examId\":\"H0001-33\",\"questionId\":\"H0001-163\",\"questionNo\":1,\"questionTitle\":\"第1道题目\",\"questionType\":\"pic\",\"questionMultiChoice\":\"0\",\"questionExampleContent\":\"\",\"examplePic\":[{\"questionId\":\"H0001-163\",\"questionExamplePicUrl\":\"\"}],\"choiceItems\":[{\"questionId\":\"H0001-163\",\"questionChoiceId\":\"H0001-56\",\"questionChoiceItem\":\"4\",\"questionChoiceItemName\":\"444444444\",\"questionChoicePicUrl\":\"MIPAPP\\2016-01-19\\201601191652163231.JPG\"}]},{\"examId\":\"H0001-33\",\"questionId\":\"H0001-164\",\"questionNo\":2,\"questionTitle\":\"第2道题目sss\",\"questionType\":\"pic\",\"questionMultiChoice\":\"0\",\"questionExampleContent\":\"< img src='MIPAPP\\2016-01-28\\201601281141181271.JPG'\\/>\",\"examplePic\":[{\"questionId\":\"H0001-164\",\"questionExamplePicUrl\":\"MIPAPP\\2016-01-28\\201601281141181271.JPG\"}],\"choiceItems\":[{\"questionId\":\"H0001-164\",\"questionChoiceId\":\"H0001-57\",\"questionChoiceItem\":\"3\",\"questionChoiceItemName\":\"333333333\",\"questionChoicePicUrl\":\"MIPAPP\\2016-01-19\\201601191652162131.JPG\"}]}]}";
		params.put("jsonData", JSON.toJSONString(exam));
		//params.put("jsonData", text);
		String[] filePaths = null;
		filePaths = StringUtils.addStringToArray(filePaths, "E:\\usr\\elekta\\a.jpg");
		filePaths = StringUtils.addStringToArray(filePaths, "E:\\usr\\elekta\\b.jpg");
		filePaths = StringUtils.addStringToArray(filePaths, "E:\\usr\\elekta\\c.jpg");
		filePaths = StringUtils.addStringToArray(filePaths, "E:\\usr\\elekta\\d.jpg");
		filePaths = StringUtils.addStringToArray(filePaths, "E:\\usr\\elekta\\example.jpg");
		System.out.println(JSON.toJSONString(exam));
		String result = "";
		try {
			result = http.sendPostFile(context + "mip/exam.do", filePaths, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(JSON.toJSONString(exam));
		logger.debug(result);
		assertNotNull(result);
	}

	public void testSendExam() {
		UserExam userExam = new UserExam();
		userExam.setExamId("H0001-49");
		userExam.setUserExamId("1");
		userExam.setUserId("29109");
		userExam.setUserExamStartDate("2016-03-01");
		userExam.setUserExamExpireDate("2016-03-31");
		userExam.setUserExamDoctorId("346");
		userExam.setUserExamDoctorName("刘慧");
		
		UserExam userExam2 = new UserExam();
		userExam2.setExamId("001");
		userExam2.setUserExamId("65");
		userExam2.setUserId("19251");
		userExam2.setUserExamStartDate("2016-03-01");
		userExam2.setUserExamExpireDate("2016-03-31");
		userExam2.setUserExamDoctorId("346");
		userExam2.setUserExamDoctorName("刘慧");
		Map map=Maps.newHashMap();
		map.put("sendExam", Arrays.asList(userExam));
		// user.setUserIp("125.34.128.242");
		HttpUtils http = new HttpUtils();
		String result = http.sendPostJson(context + "mip/sendExam.do", JSON.toJSONString(map));
		logger.debug(result);
		assertNotNull(result);
	}
	
	public void testSendExamFeedBack() {
		UserExam userExam = new UserExam();
		userExam.setUserExamId("11");
		userExam.setUserExamFeedback("<p>	您好！<br />根据您的反馈，得出以下参考评定结果：<br /><br />在此治疗周期，您在躯体功能，角色功能，情绪功能功能方面是非常正常的：<br />在认知功能和社会功能方面，给您带来了一些影响，您不必担心，通过多多参与社交活动可以逐渐改善。<br />总体说来，您的总健康状况是在正常的范围里的。<br /><br />您的症状型得分来看，最近您有气促和失眠的症状，可以通过早晚通风，多做户外运动以及吃一些安神补脑的食物来进行调节。在您下次复诊时，医生会给予更详细的建议！<br /><br />感谢！</p>");
		Map map=Maps.newHashMap();
		map.put("sendExam", Arrays.asList(userExam));
		// user.setUserIp("125.34.128.242");
		HttpUtils http = new HttpUtils();
		String result = http.sendPostJson(context + "mip/sendFeedBack.do", JSON.toJSONString(map));
		logger.debug(result);
		assertNotNull(result);
	}
	
	public void testHolidays() {
		List<Holiday> holiday=new ArrayList<Holiday>();
		for(int i=0;i<10;i++)
		{
			Holiday ho=new Holiday();
			ho.setHolidayDate("2016-01-03");
			ho.setHolidayHospId("D111");
			ho.setHolidayType("0");
			ho.setHolidayHospName("北京XXX醫院");
			holiday.add(ho);
		}
		HashMap map=Maps.newHashMap();
		map.put("holiday", holiday);
		
		String json="{\"holiday\":[	{		\"holidayDate\":\"2016-02-08\",\"holidayHospId\":\"H001\",\"holidayHospName\":\"北京肿瘤医院\",\"holidayType\":\"0\"	},	{		\"holidayDate\":\"2016-02-09\",\"holidayHospId\":\"H001\",\"holidayHospName\":\"北京肿瘤医院\",\"holidayType\":\"0\"	},	{		\"holidayDate\":\"2016-02-10\",\"holidayHospId\":\"H001\",\"holidayHospName\":\"北京肿瘤医院\",\"holidayType\":\"0\"	},	{		\"holidayDate\":\"2016-02-11\",\"holidayHospId\":\"H001\",\"holidayHospName\":\"北京肿瘤医院\",\"holidayType\":\"0\"	},	{		\"holidayDate\":\"2016-02-12\",\"holidayHospId\":\"H001\",\"holidayHospName\":\"北京肿瘤医院\",\"holidayType\":\"0\"	},	{		\"holidayDate\":\"2016-02-06\",\"holidayHospId\":\"H001\",\"holidayHospName\":\"北京肿瘤医院\",\"holidayType\":\"1\"	},	{		\"holidayDate\":\"2016-02-14\",\"holidayHospId\":\"H001\",\"holidayHospName\":\"北京肿瘤医院\",\"holidayType\":\"1\"	},	{		\"holidayDate\":\"2016-06-12\",\"holidayHospId\":\"H001\",\"holidayHospName\":\"北京肿瘤医院\",\"holidayType\":\"1\"	},	{		\"holidayDate\":\"2016-10-08\",\"holidayHospId\":\"H001\",\"holidayHospName\":\"北京肿瘤医院\",\"holidayType\":\"1\"	},	{		\"holidayDate\":\"2016-10-09\",\"holidayHospId\":\"H001\",\"holidayHospName\":\"北京肿瘤医院\",\"holidayType\":\"1\"	}    ]}";
		// user.setUserIp("125.34.128.242");
		HttpUtils http = new HttpUtils();
		String result = http.sendPostJson(context + "mip/holiday.do", JSON.toJSONString(map));
		logger.debug(result);
		assertNotNull(result);
	}

	public void testAddInfo() {
		String content="<html><body><h1 style='font-size: 32px; font-weight: bold; border-bottom: 2px solid rgb(204, 204, 204); padding: 0px 4px 0px 0px; text-align: left; margin: 0px 0px 10px;' label='标题居左'>医科达中国</h1><p>医科达公司由伽玛刀创始人，瑞典卡罗林斯卡研究所已故的神经外科教授Lars Leksell于1972年创建成立，总部设在瑞典斯德哥尔摩。现已发展成为一家跨国的医疗技术集团，在癌症和脑部病变治疗领域以及肿瘤治疗信息管理方面提供最为先进的临床治疗方案。针对放射治疗和放射外科，医科达致力于开发尖端水平的医疗设备和治疗计划系统，同时为整个癌症治疗领域开发优化工作流程的软件系统。医科达在肿瘤学、神经外科以及肿瘤信息管理软件方面的解决方案已应用于全球6,000多家医院，每天为超过10万名患者提供诊断和治疗服务。<br/><br/>医科达中国秉承关爱人类生命的使命，不断将具有最高国际标准的临床解决方案和专业服务引入中国，并投入大量研发力量，研制出让更多中国患者负担得起的放疗设备，和让医务人员操作更加简便的中文软件界面，以期更好地满足国内医疗市场的需求。<br/><br/>医科达中国在北京、上海、广州设立了分支机构，共有500多名员工。其中研发人员约150人，生产人员近100人，并有超过100名员工向客户提供销售、培训、安装、维修等直接服务，以确保为客户提供高品质的支持与服务。<br/></p></body></html>";
		Info info = new Info();
		info.setInfoHospId("ID005");
		info.setInfoHospName("北京肿瘤医院");
		info.setInfoId("I0009");
		info.setInfoContent(content);
		info.setInfoSummary("医科达神经科学作为医科达集团的一部分，致力于开创神经外科和立体定向医学的未来领域");
		//info.setInfoPicUrl("huatuo1.jpg");
		info.setInfoTime("2016-01-07 22:06:55");
		info.setInfoTitle("医科达神经科学");

		HttpUtils http = new HttpUtils();
		Map<String, String> params = Maps.newConcurrentMap();
		params.put("jsonData", JSON.toJSONString(info));

		String[] filePaths = null;
		//filePaths = StringUtils.addStringToArray(filePaths, "E:\\usr\\elekta\\1.png");
		//filePaths = StringUtils.addStringToArray(filePaths, "E:\\usr\\huatuo2.jpg");
		//filePaths = StringUtils.addStringToArray(filePaths, "E:\\usr\\huatuo3.jpg");
		String result = "";
		try {
			result = http.sendPostFile(context + "mip/info.do", filePaths, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(JSON.toJSONString(info));
		logger.debug(result);
		assertNotNull(result);
}
	
	public void testDelInfo() {
		
		
		Info info = new Info();
		
		info.setInfoId("41");
		info.setInfoDisplay("0");

		HttpUtils http = new HttpUtils();
		Map<String, String> params = Maps.newConcurrentMap();
		params.put("jsonData", JSON.toJSONString(info));

		String[] filePaths = null;
		String result = "";
		try {
			result = http.sendPostFile(context + "mip/info.do", filePaths, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(JSON.toJSONString(info));
		logger.debug(result);
		assertNotNull(result);
}

	public void testPush()
	{
		UmengPush umengPush=new UmengPush();
		HashMap map=Maps.newHashMap();
		map.put("type", "3");
		umengPush.setTitle("广播测试");
		umengPush.setExtraFields(map);
		umengPush.setText("广播广播广播广播");
		umengPush.setPushType(UmengPush.PushType.BROAD.getType());
		umengPush.setTicker("广播测试");
		//umengPush.setUsers(Arrays.asList("19334","19248"));
		
        HttpUtils http=new HttpUtils();
        logger.debug(JSON.toJSONString(umengPush));
        String result= http.sendPostJson(context+"mip/push.do", JSON.toJSONString(umengPush));
       logger.debug(result);
        assertNotNull(result); 
	}
	
	public void testJson()
	{
		ResponseMessage response=ResponseMessage.createSuccessResponse("0000", "sadasd");
		response.setData("userExamFeed", "<html><body><p>xxxxxxxx</p></body></html>");
		logger.debug(JSON.toJSONString(response));
	}
	
	public void testMessage()
	{
		String userid="19334";
		List<Message> messageList=new ArrayList<Message>();
		Message message1=new Message();
		message1.setMessageId("058");
		message1.setMessageContent("还是没收到?");
		message1.setMessageTime(DateUtils.getDate(DateUtils.getCurrentDate()));
		message1.setMessageTitle("预约提醒");
		message1.setMessageType("1");
		message1.setMessageStatus("0");
		message1.setMessageSenderName("刘慧");
		message1.setMessageSender("346");
		message1.setMessageStatus("0");
		message1.setUserId(userid);
		messageList.add(message1);
		
		/*Message message2=new Message();
		message2.setMessageId("038");
		message2.setMessageContent("10号机机器故障已解除，请病友们按照预约时间治疗。");
		message2.setMessageTime("2016-03-01 15:00");
		message2.setMessageTitle("系统问题");
		message2.setMessageType("1");
		message2.setMessageStatus("0");
		message2.setMessageSenderName("系统管理员");
		message2.setMessageSender("1");
		message2.setMessageStatus("0");
		message2.setUserId(userid);
		messageList.add(message2);
		
		Message message3=new Message();
		message3.setMessageId("039");
		message3.setMessageContent("您好，您预约明天的后装治疗，请明早7:20前准时报到，今晚口服造影剂20ML+980ML温开水，于今晚7:00及9:00各喝500ML,今天务必验血常规，有疑问请致电020-87343025（周一至周五2:30之前）");
		message3.setMessageTime("2016-03-01 15:00");
		message3.setMessageTitle("报到提醒");
		message3.setMessageType("0");
		message3.setMessageStatus("0");
		message3.setMessageSenderName("刘慧");
		message3.setMessageSender("346");
		message3.setMessageStatus("0");
		message3.setUserId(userid);
		messageList.add(message3);
		
		Message message4=new Message();
		message4.setMessageId("040");
		message4.setMessageContent("您好，您已预约在我院放疗中心负一楼22号房CT模拟定位，请提前 1个半小时以上先到放疗中心负一楼28室做体位固定（需剪短头发，穿无领、棉质、薄衫），然后到注射室负一楼22号房找护士报到。超过预约时间需要重新预约，如有疑问或无法按时到达，请拨020-87343039--中山大学附属肿瘤医院！");
		message4.setMessageTime("2016-03-02 15:00");
		message4.setMessageTitle("预约提醒");
		message4.setMessageType("0");
		message4.setMessageStatus("0");
		message4.setMessageSenderName("刘慧");
		message4.setMessageSender("346");
		message4.setMessageStatus("0");
		message4.setUserId(userid);
		messageList.add(message4);*/
			
	
		Map map=Maps.newHashMap();
		map.put("messages", messageList);
        HttpUtils http=new HttpUtils();
        String result= http.sendPostJson(context+"mip/message.do", JSON.toJSONString(map));
       logger.debug(result);
        assertNotNull(result); 
	}
}
