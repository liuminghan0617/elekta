package com.makervt.elekta.dao;

import com.makervt.elekta.entity.Attention;
import com.makervt.core.dao.MyBatisDao;

import java.util.List;
@MyBatisDao
public interface AttentionDao {
	public List<Attention> selectPage(Attention attention);
	public List<Attention> select(Attention attention);
	public Integer count(Attention attention);
	public Attention selectByPK(String attentionId);
	public Integer deleteByPK(String attentionId);
	public Integer updateByPK(Attention attention);
	public Integer insert(Attention attention);
	public Integer delete(Attention attention);
	public Integer deleteBatch(String[] array);
}
