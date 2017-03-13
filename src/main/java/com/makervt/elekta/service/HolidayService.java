package com.makervt.elekta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makervt.core.service.BaseService;
import com.makervt.elekta.dao.HolidayDao;
import com.makervt.elekta.entity.Holiday;


@Service("holidayService")
public class HolidayService extends BaseService<Holiday> {
	@Autowired
	private HolidayDao holidayDao;

	public Integer create(Holiday holiday) {
		return holidayDao.insert(holiday);
	}

	public Integer modify(Holiday holiday) {
		return holidayDao.updateByPK(holiday);
	}

	public Integer remove(Holiday holiday) {
		return holidayDao.delete(holiday);
	}
	
	public Integer removeBatch(String[] array){
		return holidayDao.deleteBatch(array);
	}

	@Override
	public Integer count(Holiday entity) {
		return holidayDao.count(entity);
	}

	public List<Holiday> selectByScope(Holiday entity) {
		return holidayDao.selectByScope(entity);
	}
	
	public List<Holiday> select(Holiday entity) {
		return holidayDao.select(entity);
	}
	
	@Override
	public List<Holiday> selectPage(Holiday entity) {
		return holidayDao.selectPage(entity);
	}
}
