package com.makervt.elekta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makervt.core.service.BaseService;
import com.makervt.elekta.dao.QuestionExamplePicDao;
import com.makervt.elekta.entity.QuestionExamplePic;

@Service("questionExamplePicService")
public class QuestionExamplePicService extends BaseService<QuestionExamplePic> {
	@Autowired
	private QuestionExamplePicDao questionExamplePicDao;

	public Integer create(QuestionExamplePic questionExamplePic) {
		return questionExamplePicDao.insert(questionExamplePic);
	}

	public Integer modify(QuestionExamplePic questionExamplePic) {
		return questionExamplePicDao.updateByPK(questionExamplePic);
	}

	public Integer remove(QuestionExamplePic questionExamplePic) {
		return questionExamplePicDao.delete(questionExamplePic);
	}
	
	public Integer removeBatch(String[] array){
		return questionExamplePicDao.deleteBatch(array);
	}

	@Override
	public Integer count(QuestionExamplePic entity) {
		return questionExamplePicDao.count(entity);
	}

	public List<QuestionExamplePic> select(QuestionExamplePic entity) {
		return questionExamplePicDao.select(entity);
	}
	
	@Override
	public List<QuestionExamplePic> selectPage(QuestionExamplePic entity) {
		return questionExamplePicDao.selectPage(entity);
	}
	
}
