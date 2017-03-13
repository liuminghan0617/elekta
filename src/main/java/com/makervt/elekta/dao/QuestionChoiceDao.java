package com.makervt.elekta.dao;

import com.makervt.elekta.entity.QuestionChoice;
import com.makervt.core.dao.MyBatisDao;

import java.util.List;
@MyBatisDao
public interface QuestionChoiceDao {
	public List<QuestionChoice> selectPage(QuestionChoice questionChoice);
	public List<QuestionChoice> select(QuestionChoice questionChoice);
	public Integer count(QuestionChoice questionChoice);
	public QuestionChoice selectByPK(String questionChoiceId);
	public Integer deleteByPK(String questionChoiceId);
	public Integer updateByPK(QuestionChoice questionChoice);
	public Integer insert(QuestionChoice questionChoice);
	public Integer delete(QuestionChoice questionChoice);
	public Integer deleteBatch(String[] array);
}
