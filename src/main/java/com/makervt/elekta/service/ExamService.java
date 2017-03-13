package com.makervt.elekta.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.makervt.core.cache.AppCache;
import com.makervt.core.domain.Page;
import com.makervt.core.domain.ResponseMessage;
import com.makervt.core.service.BaseService;
import com.makervt.core.util.FileOperateUtil;
import com.makervt.elekta.dao.ExamDao;
import com.makervt.elekta.dao.QuestionChoiceDao;
import com.makervt.elekta.dao.QuestionDao;
import com.makervt.elekta.dao.QuestionExamplePicDao;
import com.makervt.elekta.dao.UserExamDao;
import com.makervt.elekta.dao.UserQuestionDao;
import com.makervt.elekta.entity.Exam;
import com.makervt.elekta.entity.Info;
import com.makervt.elekta.entity.InfoPic;
import com.makervt.elekta.entity.Question;
import com.makervt.elekta.entity.QuestionChoice;
import com.makervt.elekta.entity.QuestionExamplePic;
import com.makervt.elekta.entity.UserExam;
import com.makervt.elekta.entity.UserQuestion;

@Service("examService")
public class ExamService extends BaseService<Exam> {
	private static Logger logger = LoggerFactory.getLogger(DoctorService.class);
	@Autowired
	private ExamDao examDao;
	
	@Autowired
	private QuestionDao questionDao;
	
	@Autowired
	private QuestionExamplePicDao questionExamplePicDao;
	
	@Autowired
	private QuestionChoiceDao questionChoiceDao;
	
	@Autowired
	private UserExamDao userExamDao;
	
	@Autowired
	private UserQuestionDao  userQuestionDao;

	
	
	public Exam selectByPK(Exam exam) {
		return examDao.selectByPK(exam.getExamId());
	}
	
	public Integer create(Exam exam) {
		return examDao.insert(exam);
	}

	public Integer modify(Exam exam) {
		return examDao.updateByPK(exam);
	}

	public Integer remove(Exam exam) {
		return examDao.delete(exam);
	}
	
	public Integer removeBatch(String[] array){
		return examDao.deleteBatch(array);
	}

	@Override
	public Integer count(Exam entity) {
		return examDao.count(entity);
	}

	public List<Exam> select(Exam entity) {
		return examDao.select(entity);
	}
	
	@Override
	public List<Exam> selectPage(Exam entity) {
		return examDao.selectPage(entity);
	}
}
