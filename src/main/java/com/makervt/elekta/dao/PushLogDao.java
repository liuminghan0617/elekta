package com.makervt.elekta.dao;

import com.makervt.core.dao.MyBatisDao;
import com.makervt.elekta.entity.PushLog;

import java.util.List;
@MyBatisDao
public interface PushLogDao {
	public List<PushLog> selectPage(PushLog pushLog);
	public List<PushLog> select(PushLog pushLog);
	public Integer count(PushLog pushLog);
	public PushLog selectByPK(String pushLogId);
	public Integer deleteByPK(String pushLogId);
	public Integer updateByPK(PushLog pushLog);
	public Integer insert(PushLog pushLog);
	public Integer delete(PushLog pushLog);
	public Integer deleteBatch(String[] array);
}
