package com.makervt.elekta.dao;

import com.makervt.elekta.entity.Info;
import com.makervt.core.dao.MyBatisDao;

import java.util.List;
@MyBatisDao
public interface InfoDao {
	public List<Info> selectPage(Info info);
	public List<Info> select(Info info);
	public Integer count(Info info);
	public Info selectByPK(String infoId);
	public Integer deleteByPK(String infoId);
	public Integer updateByPK(Info info);
	public Integer insert(Info info);
	public Integer delete(Info info);
	public Integer deleteBatch(String[] array);
}
