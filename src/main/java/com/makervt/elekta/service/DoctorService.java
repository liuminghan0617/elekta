package com.makervt.elekta.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.makervt.core.cache.AppCache;
import com.makervt.core.domain.ResponseMessage;
import com.makervt.core.service.BaseService;
import com.makervt.core.util.FileOperateUtil;
import com.makervt.elekta.dao.DoctorDao;
import com.makervt.elekta.entity.Doctor;


@Service("doctorService")
public class DoctorService extends BaseService<Doctor> {
	@Autowired
	private DoctorDao doctorDao;

	private static Logger logger = LoggerFactory.getLogger(DoctorService.class);

	private static String DOCTOR_PHOTO_VIEW= "doctor/image.do?filePath=";
	
	/**
	 * 根据用户标识获取主治医师信息
	 * @param doctor
	 * @return
	 */
	public Doctor queryDoctor(Doctor doctor) {
		Doctor doctorMip=MipProviderService.queryDoctorByMip(doctor.getUserId());
		doctor.setDoctorId(doctorMip.getDoctorId());
		return selectByPK(doctor);
	}
	
	public Doctor selectByPK(Doctor doctor) {
		return doctorDao.selectByPK(doctor.getDoctorId());
	}

	public Integer create(Doctor doctor) {
		return doctorDao.insert(doctor);
	}

	public Integer modify(Doctor doctor) {
		return doctorDao.updateByPK(doctor);
	}

	public Integer remove(Doctor doctor) {
		return doctorDao.delete(doctor);
	}

	public Integer removeBatch(String[] array) {
		return doctorDao.deleteBatch(array);
	}

	@Override
	public Integer count(Doctor entity) {
		return doctorDao.count(entity);
	}

	public List<Doctor> select(Doctor entity) {
		return doctorDao.select(entity);
	}

	@Override
	public List<Doctor> selectPage(Doctor entity) {
		return doctorDao.selectPage(entity);
	}
}
