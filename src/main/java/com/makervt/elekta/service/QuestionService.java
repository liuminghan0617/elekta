package com.makervt.elekta.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.makervt.core.cache.AppCache;
import com.makervt.core.domain.ResponseMessage;
import com.makervt.core.service.BaseService;
import com.makervt.core.util.FileOperateUtil;
import com.makervt.elekta.dao.QuestionDao;
import com.makervt.elekta.entity.Question;
import com.makervt.elekta.entity.QuestionAddPic;
import com.makervt.elekta.entity.QuestionChoice;

@Service("questionService")
public class QuestionService extends BaseService<Question> {
	@Autowired
	private QuestionDao questionDao;

	protected Logger logger = LoggerFactory.getLogger(getClass());

	public Integer create(Question question) {
		return questionDao.insert(question);
	}

	public Integer modify(Question question) {
		return questionDao.updateByPK(question);
	}

	public Integer remove(Question question) {
		return questionDao.delete(question);
	}
	
	public Integer removeBatch(String[] array){
		return questionDao.deleteBatch(array);
	}

	@Override
	public Integer count(Question entity) {
		return questionDao.count(entity);
	}

	public List<Question> select(Question entity) {
		return questionDao.select(entity);
	}
	
	@Override
	public List<Question> selectPage(Question entity) {
		return questionDao.selectPage(entity);
	}
}
