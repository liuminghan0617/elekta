package com.makervt.elekta.dao;

import com.makervt.elekta.entity.Doctor;
import com.makervt.core.dao.MyBatisDao;

import java.util.List;
@MyBatisDao
public interface DoctorDao {
	public List<Doctor> selectPage(Doctor doctor);
	public List<Doctor> select(Doctor doctor);
	public Integer count(Doctor doctor);
	public Doctor selectByPK(String doctorId);
	public Integer deleteByPK(String doctorId);
	public Integer updateByPK(Doctor doctor);
	public Integer insert(Doctor doctor);
	public Integer delete(Doctor doctor);
	public Integer deleteBatch(String[] array);
}
