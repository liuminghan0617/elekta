package com.makervt.elekta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makervt.core.service.BaseService;
import com.makervt.elekta.dao.PushLogDao;
import com.makervt.elekta.entity.PushLog;

@Service("pushLogService")
public class PushLogService extends BaseService<PushLog> {
	@Autowired
	private PushLogDao pushLogDao;

	public Integer create(PushLog pushLog) {
		return pushLogDao.insert(pushLog);
	}

	public Integer modify(PushLog pushLog) {
		return pushLogDao.updateByPK(pushLog);
	}

	public Integer remove(PushLog pushLog) {
		return pushLogDao.delete(pushLog);
	}
	
	public Integer removeBatch(String[] array){
		return pushLogDao.deleteBatch(array);
	}

	@Override
	public Integer count(PushLog entity) {
		return pushLogDao.count(entity);
	}

	public List<PushLog> select(PushLog entity) {
		return pushLogDao.select(entity);
	}
	
	@Override
	public List<PushLog> selectPage(PushLog entity) {
		return pushLogDao.selectPage(entity);
	}
}
