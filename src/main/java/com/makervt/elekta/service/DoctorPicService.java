package com.makervt.elekta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makervt.core.service.BaseService;
import com.makervt.elekta.dao.DoctorPicDao;
import com.makervt.elekta.entity.DoctorPic;

@Service("doctorPicService")
public class DoctorPicService extends BaseService<DoctorPic> {
	@Autowired
	private DoctorPicDao doctorPicDao;

	public Integer create(DoctorPic doctorPic) {
		return doctorPicDao.insert(doctorPic);
	}

	public Integer modify(DoctorPic doctorPic) {
		return doctorPicDao.updateByPK(doctorPic);
	}

	public Integer remove(DoctorPic doctorPic) {
		return doctorPicDao.delete(doctorPic);
	}
	
	public Integer removeBatch(String[] array){
		return doctorPicDao.deleteBatch(array);
	}

	@Override
	public Integer count(DoctorPic entity) {
		return doctorPicDao.count(entity);
	}

	public List<DoctorPic> select(DoctorPic entity) {
		return doctorPicDao.select(entity);
	}
	
	@Override
	public List<DoctorPic> selectPage(DoctorPic entity) {
		return doctorPicDao.selectPage(entity);
	}
}
