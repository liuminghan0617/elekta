package com.makervt.elekta.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.httpclient.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makervt.core.domain.ResponseMessage;
import com.makervt.core.service.BaseService;
import com.makervt.core.util.DateUtils;
import com.makervt.elekta.dao.DoctorPraiseDao;
import com.makervt.elekta.entity.DoctorPraise;

@Service("doctorPraiseService")
public class DoctorPraiseService extends BaseService<DoctorPraise> {
	@Autowired
	private DoctorPraiseDao doctorPraiseDao;

	public ResponseMessage createPraise(DoctorPraise doctorPraise) {
		ResponseMessage msg = ResponseMessage.createSuccessResponse("0000");
		String now=DateUtils.getDate(new Date(), "yyyy-MM-dd");
		doctorPraise.setDoctorPraiseDate(now);
		Integer check =doctorPraiseDao.count(doctorPraise);
		if(check>0)
			return  ResponseMessage.createErrorResponse("1114");
		else
			doctorPraiseDao.insert(doctorPraise);
		return msg;
	}
	

	public ResponseMessage isPraise(DoctorPraise doctorPraise) {
		ResponseMessage msg = ResponseMessage.createSuccessResponse("0000");
		String now=DateUtils.getDate(new Date(), "yyyy-MM-dd");
		doctorPraise.setDoctorPraiseDate(now);
		Integer check =doctorPraiseDao.count(doctorPraise);
		if(check>0)
			return  ResponseMessage.createErrorResponse("1114");
		return msg;
	} 
	
	
	public Integer create(DoctorPraise doctorPraise) {
		return doctorPraiseDao.insert(doctorPraise);
	}

	public Integer modify(DoctorPraise doctorPraise) {
		return doctorPraiseDao.updateByPK(doctorPraise);
	}

	public Integer remove(DoctorPraise doctorPraise) {
		return doctorPraiseDao.delete(doctorPraise);
	}
	
	public Integer removeBatch(String[] array){
		return doctorPraiseDao.deleteBatch(array);
	}

	@Override
	public Integer count(DoctorPraise entity) {
		return doctorPraiseDao.count(entity);
	}

	public List<DoctorPraise> select(DoctorPraise entity) {
		return doctorPraiseDao.select(entity);
	}
	
	@Override
	public List<DoctorPraise> selectPage(DoctorPraise entity) {
		return doctorPraiseDao.selectPage(entity);
	}
}
