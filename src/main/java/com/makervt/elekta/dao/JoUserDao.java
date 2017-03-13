package com.makervt.elekta.dao;


import com.makervt.core.dao.MyBatisDao;
import com.makervt.elekta.entity.JoUser;

import java.util.List;
@MyBatisDao
public interface JoUserDao {
	public List<JoUser> selectPage(JoUser joUser);
	public List<JoUser> select(JoUser joUser);
	public Integer count(JoUser joUser);
	public JoUser selectByPK(String userId);
	public Integer deleteByPK(String userId);
	public Integer updateByPK(JoUser joUser);
	public Integer insert(JoUser joUser);
	public Integer delete(JoUser joUser);
	public Integer deleteBatch(String[] array);
}
