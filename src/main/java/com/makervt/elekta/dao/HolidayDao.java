package com.makervt.elekta.dao;


import java.util.List;

import com.makervt.core.dao.MyBatisDao;
import com.makervt.elekta.entity.Holiday;
@MyBatisDao
public interface HolidayDao {
	public List<Holiday> selectPage(Holiday holiday);
	public List<Holiday> select(Holiday holiday);
	public List<Holiday> selectByScope(Holiday holiday);
	public Integer count(Holiday holiday);
	public Holiday selectByPK(String holidayId);
	public Integer deleteByPK(String holidayId);
	public Integer updateByPK(Holiday holiday);
	public Integer insert(Holiday holiday);
	public Integer delete(Holiday holiday);
	public Integer deleteBatch(String[] array);
	public Integer insertBatch(List<Holiday> holidayList);
}
