package com.makervt.elekta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makervt.core.service.BaseService;
import com.makervt.elekta.dao.QuestionAddPicDao;
import com.makervt.elekta.entity.QuestionAddPic;

@Service("questionAddPicService")
public class QuestionAddPicService extends BaseService<QuestionAddPic> {
	@Autowired
	private QuestionAddPicDao questionAddPicDao;

	public Integer create(QuestionAddPic questionAddPic) {
		return questionAddPicDao.insert(questionAddPic);
	}

	public Integer modify(QuestionAddPic questionAddPic) {
		return questionAddPicDao.updateByPK(questionAddPic);
	}

	public Integer remove(QuestionAddPic questionAddPic) {
		return questionAddPicDao.delete(questionAddPic);
	}
	
	public Integer removeBatch(String[] array){
		return questionAddPicDao.deleteBatch(array);
	}

	@Override
	public Integer count(QuestionAddPic entity) {
		return questionAddPicDao.count(entity);
	}

	public List<QuestionAddPic> select(QuestionAddPic entity) {
		return questionAddPicDao.select(entity);
	}
	
	@Override
	public List<QuestionAddPic> selectPage(QuestionAddPic entity) {
		return questionAddPicDao.selectPage(entity);
	}
}
