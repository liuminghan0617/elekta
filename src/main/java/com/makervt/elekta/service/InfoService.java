package com.makervt.elekta.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makervt.core.cache.AppCache;
import com.makervt.core.domain.Page;
import com.makervt.core.domain.ResponseMessage;
import com.makervt.core.service.BaseService;
import com.makervt.core.util.FileOperateUtil;
import com.makervt.elekta.dao.InfoDao;
import com.makervt.elekta.dao.InfoPicDao;
import com.makervt.elekta.entity.Attention;
import com.makervt.elekta.entity.AttentionPic;
import com.makervt.elekta.entity.Info;
import com.makervt.elekta.entity.InfoPic;

@Service("infoService")
public class InfoService extends BaseService<Info> {
	@Autowired
	private InfoDao infoDao;
	
	private static Logger logger = LoggerFactory.getLogger(InfoService.class);
	
	@Autowired
	private InfoPicDao infoPicDao;
	
	
	public Integer create(Info info) {
		return infoDao.insert(info);
	}
	
	public Info selectByPK(Info info) {
		return infoDao.selectByPK(info.getInfoId());
	}

	public Integer modify(Info info) {
		return infoDao.updateByPK(info);
	}

	public Integer remove(Info info) {
		return infoDao.delete(info);
	}
	
	public Integer removeBatch(String[] array){
		return infoDao.deleteBatch(array);
	}

	@Override
	public Integer count(Info entity) {
		return infoDao.count(entity);
	}

	public List<Info> select(Info entity) {
		return infoDao.select(entity);
	}
	
	@Override
	public List<Info> selectPage(Info entity) {
		return infoDao.selectPage(entity);
	}
}
