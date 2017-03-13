package com.makervt.elekta.dao;



import java.util.List;

import com.makervt.core.dao.MyBatisDao;
import com.makervt.elekta.entity.DoctorPic;
@MyBatisDao
public interface DoctorPicDao {
	public List<DoctorPic> selectPage(DoctorPic doctorPic);
	public List<DoctorPic> select(DoctorPic doctorPic);
	public Integer count(DoctorPic doctorPic);
	public DoctorPic selectByPK(String doctorPicId);
	public Integer deleteByPK(String doctorPicId);
	public Integer updateByPK(DoctorPic doctorPic);
	public Integer insert(DoctorPic doctorPic);
	public Integer delete(DoctorPic doctorPic);
	public Integer deleteBatch(String[] array);
}
