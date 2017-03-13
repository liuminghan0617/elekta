package com.makervt.elekta.dao;

import com.makervt.core.dao.MyBatisDao;
import com.makervt.elekta.entity.User;

import java.util.List;
@MyBatisDao
public interface UserDao {
	public List<User> selectPage(User user);
	public List<User> select(User user);
	public Integer count(User user);
	public User selectByPK(String userId);
	public Integer deleteByPK(String userId);
	public Integer updateByPK(User user);
	public Integer insert(User user);
	public Integer delete(User user);
	public Integer deleteBatch(String[] array);
}
