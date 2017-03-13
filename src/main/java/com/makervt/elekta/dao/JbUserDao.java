package com.makervt.elekta.dao;

import com.makervt.core.dao.MyBatisDao;
import com.makervt.elekta.entity.JbUser;

import java.util.List;
@MyBatisDao
public interface JbUserDao {
	public List<JbUser> selectPage(JbUser jbUser);
	public List<JbUser> select(JbUser jbUser);
	public Integer count(JbUser jbUser);
	public JbUser selectByPK(String userId);
	public Integer deleteByPK(String userId);
	public Integer updateByPK(JbUser jbUser);
	public Integer insert(JbUser jbUser);
	public Integer delete(JbUser jbUser);
	public Integer deleteBatch(String[] array);
}
