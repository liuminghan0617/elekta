package com.makervt.elekta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makervt.core.service.BaseService;
import com.makervt.elekta.dao.AttentionPicDao;
import com.makervt.elekta.entity.AttentionPic;

@Service("attentionPicService")
public class AttentionPicService extends BaseService<AttentionPic> {
	@Autowired
	private AttentionPicDao attentionPicDao;

	public Integer create(AttentionPic attentionPic) {
		return attentionPicDao.insert(attentionPic);
	}

	public Integer modify(AttentionPic attentionPic) {
		return attentionPicDao.updateByPK(attentionPic);
	}

	public Integer remove(AttentionPic attentionPic) {
		return attentionPicDao.delete(attentionPic);
	}
	
	public Integer removeBatch(String[] array){
		return attentionPicDao.deleteBatch(array);
	}

	@Override
	public Integer count(AttentionPic entity) {
		return attentionPicDao.count(entity);
	}

	public List<AttentionPic> select(AttentionPic entity) {
		return attentionPicDao.select(entity);
	}
	
	@Override
	public List<AttentionPic> selectPage(AttentionPic entity) {
		return attentionPicDao.selectPage(entity);
	}
}
