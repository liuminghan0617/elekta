package com.makervt.elekta.dao;

import java.util.List;

import com.makervt.core.dao.MyBatisDao;
import com.makervt.elekta.entity.AppVersion;

@MyBatisDao
public interface AppVersionDao {
	public List<AppVersion> select(AppVersion appVersion);
	public Integer insert(AppVersion appVersion);
}
