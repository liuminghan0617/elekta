package com.makervt.elekta.dao;

import com.makervt.elekta.entity.DoctorPraise;
import com.makervt.core.dao.MyBatisDao;

import java.util.List;
@MyBatisDao
public interface DoctorPraiseDao {
	public List<DoctorPraise> selectPage(DoctorPraise doctorPraise);
	public List<DoctorPraise> select(DoctorPraise doctorPraise);
	public Integer count(DoctorPraise doctorPraise);
	public DoctorPraise selectByPK(String doctorPraiseId);
	public Integer deleteByPK(String doctorPraiseId);
	public Integer updateByPK(DoctorPraise doctorPraise);
	public Integer insert(DoctorPraise doctorPraise);
	public Integer delete(DoctorPraise doctorPraise);
	public Integer deleteBatch(String[] array);
}
