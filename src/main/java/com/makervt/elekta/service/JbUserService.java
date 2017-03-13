package com.makervt.elekta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makervt.core.service.BaseService;
import com.makervt.elekta.dao.JbUserDao;
import com.makervt.elekta.entity.JbUser;

@Service("jbUserService")
public class JbUserService extends BaseService<JbUser> {
	@Autowired
	private JbUserDao jbUserDao;

	public Integer create(JbUser jbUser) {
		return jbUserDao.insert(jbUser);
	}

	public Integer modify(JbUser jbUser) {
		return jbUserDao.updateByPK(jbUser);
	}

	public Integer remove(JbUser jbUser) {
		return jbUserDao.delete(jbUser);
	}
	
	public Integer removeBatch(String[] array){
		return jbUserDao.deleteBatch(array);
	}

	@Override
	public Integer count(JbUser entity) {
		return jbUserDao.count(entity);
	}

	public List<JbUser> select(JbUser entity) {
		return jbUserDao.select(entity);
	}
	
	@Override
	public List<JbUser> selectPage(JbUser entity) {
		return jbUserDao.selectPage(entity);
	}
}
