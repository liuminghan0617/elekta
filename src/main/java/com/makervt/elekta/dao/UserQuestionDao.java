package com.makervt.elekta.dao;

import com.makervt.elekta.entity.UserQuestion;
import com.makervt.core.dao.MyBatisDao;

import java.util.List;
@MyBatisDao
public interface UserQuestionDao {
	public List<UserQuestion> selectPage(UserQuestion userQuestion);
	public List<UserQuestion> select(UserQuestion userQuestion);
	public List<UserQuestion> selectAllQuestion(UserQuestion userQuestion);
	public Integer count(UserQuestion userQuestion);
	public UserQuestion selectByPK(String userQuestionId);
	public Integer deleteByPK(String userQuestionId);
	public Integer updateByPK(UserQuestion userQuestion);
	public Integer insert(UserQuestion userQuestion);
	public Integer delete(UserQuestion userQuestion);
	public Integer deleteBatch(String[] array);
	
}
