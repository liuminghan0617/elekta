package com.makervt.elekta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makervt.core.service.BaseService;
import com.makervt.elekta.dao.JoUserDao;
import com.makervt.elekta.entity.JoUser;

@Service("joUserService")
public class JoUserService extends BaseService<JoUser> {
	@Autowired
	private JoUserDao joUserDao;

	public Integer create(JoUser joUser) {
		return joUserDao.insert(joUser);
	}

	public Integer modify(JoUser joUser) {
		return joUserDao.updateByPK(joUser);
	}

	public Integer remove(JoUser joUser) {
		return joUserDao.delete(joUser);
	}
	
	public Integer removeBatch(String[] array){
		return joUserDao.deleteBatch(array);
	}

	@Override
	public Integer count(JoUser entity) {
		return joUserDao.count(entity);
	}

	public List<JoUser> select(JoUser entity) {
		return joUserDao.select(entity);
	}
	
	@Override
	public List<JoUser> selectPage(JoUser entity) {
		return joUserDao.selectPage(entity);
	}
}
