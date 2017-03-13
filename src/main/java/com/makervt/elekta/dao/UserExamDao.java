package com.makervt.elekta.dao;

import com.makervt.elekta.entity.UserExam;
import com.makervt.core.dao.MyBatisDao;

import java.util.List;
@MyBatisDao
public interface UserExamDao {
	public List<UserExam> selectPage(UserExam userExam);
	public List<UserExam> select(UserExam userExam);
	public List<UserExam> selectExpire(UserExam userExam);
	public Integer count(UserExam userExam);
	public UserExam selectByPK(String userExamId);
	public Integer deleteByPK(String userExamId);
	public Integer updateByPK(UserExam userExam);
	public Integer insert(UserExam userExam);
	public Integer delete(UserExam userExam);
	public Integer deleteBatch(String[] array);
}
