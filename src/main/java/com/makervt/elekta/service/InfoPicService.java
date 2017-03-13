package com.makervt.elekta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makervt.core.service.BaseService;
import com.makervt.elekta.dao.InfoPicDao;
import com.makervt.elekta.entity.InfoPic;

@Service("infoPicService")
public class InfoPicService extends BaseService<InfoPic> {
	@Autowired
	private InfoPicDao infoPicDao;

	public Integer create(InfoPic infoPic) {
		return infoPicDao.insert(infoPic);
	}

	public Integer modify(InfoPic infoPic) {
		return infoPicDao.updateByPK(infoPic);
	}

	public Integer remove(InfoPic infoPic) {
		return infoPicDao.delete(infoPic);
	}
	
	public Integer removeBatch(String[] array){
		return infoPicDao.deleteBatch(array);
	}

	@Override
	public Integer count(InfoPic entity) {
		return infoPicDao.count(entity);
	}

	public List<InfoPic> select(InfoPic entity) {
		return infoPicDao.select(entity);
	}
	
	@Override
	public List<InfoPic> selectPage(InfoPic entity) {
		return infoPicDao.selectPage(entity);
	}
}
