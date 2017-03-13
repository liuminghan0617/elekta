package com.makervt.elekta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makervt.core.service.BaseService;
import com.makervt.elekta.dao.QuestionChoiceDao;
import com.makervt.elekta.entity.QuestionChoice;

@Service("questionChoiceService")
public class QuestionChoiceService extends BaseService<QuestionChoice> {
	@Autowired
	private QuestionChoiceDao questionChoiceDao;

	public Integer create(QuestionChoice questionChoice) {
		return questionChoiceDao.insert(questionChoice);
	}

	public Integer modify(QuestionChoice questionChoice) {
		return questionChoiceDao.updateByPK(questionChoice);
	}

	public Integer remove(QuestionChoice questionChoice) {
		return questionChoiceDao.delete(questionChoice);
	}
	
	public Integer removeBatch(String[] array){
		return questionChoiceDao.deleteBatch(array);
	}

	@Override
	public Integer count(QuestionChoice entity) {
		return questionChoiceDao.count(entity);
	}

	public List<QuestionChoice> select(QuestionChoice entity) {
		return questionChoiceDao.select(entity);
	}
	
	@Override
	public List<QuestionChoice> selectPage(QuestionChoice entity) {
		return questionChoiceDao.selectPage(entity);
	}
}
