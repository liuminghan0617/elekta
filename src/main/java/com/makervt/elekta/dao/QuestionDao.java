package com.makervt.elekta.dao;

import com.makervt.elekta.entity.Question;
import com.makervt.core.dao.MyBatisDao;

import java.util.List;
@MyBatisDao
public interface QuestionDao {
	public List<Question> selectPage(Question question);
	public List<Question> select(Question question);
	public Integer count(Question question);
	public Question selectByPK(String questionId);
	public Integer deleteByPK(String questionId);
	public Integer updateByPK(Question question);
	public Integer insert(Question question);
	public Integer delete(Question question);
	public Integer deleteBatch(String[] array);
}
