package com.makervt.elekta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makervt.core.service.BaseService;
import com.makervt.elekta.dao.UserExamDao;
import com.makervt.elekta.entity.UserExam;

@Service("userExamService")
public class UserExamService extends BaseService<UserExam> {
	@Autowired
	private UserExamDao userExamDao;

	public Integer create(UserExam userExam) {
		return userExamDao.insert(userExam);
	}

	public Integer modify(UserExam userExam) {
		return userExamDao.updateByPK(userExam);
	}

	public Integer remove(UserExam userExam) {
		return userExamDao.delete(userExam);
	}
	
	public Integer removeBatch(String[] array){
		return userExamDao.deleteBatch(array);
	}

	@Override
	public Integer count(UserExam entity) {
		return userExamDao.count(entity);
	}

	public List<UserExam> select(UserExam entity) {
		return userExamDao.select(entity);
	}
	
	public List<UserExam> selectExpire(UserExam entity) {
		return userExamDao.selectExpire(entity);
	}
	
	@Override
	public List<UserExam> selectPage(UserExam entity) {
		return userExamDao.selectPage(entity);
	}
}
