package com.makervt.elekta.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makervt.core.cache.AppCache;
import com.makervt.core.domain.ResponseMessage;
import com.makervt.core.service.BaseService;
import com.makervt.core.util.FileOperateUtil;
import com.makervt.elekta.dao.AttentionDao;
import com.makervt.elekta.dao.AttentionPicDao;
import com.makervt.elekta.entity.Attention;
import com.makervt.elekta.entity.AttentionPic;
import com.makervt.elekta.entity.Doctor;

@Service("attentionService")
public class AttentionService extends BaseService<Attention> {

	private static Logger logger = LoggerFactory.getLogger(AttentionService.class);


	@Autowired
	private AttentionDao attentionDao;

	@Autowired
	private AttentionPicDao attentionPicDao;

	/**
	 * 根据日程事项查询注意事项
	 * 
	 * @param itemId
	 * @return
	 */
	public Attention queryAttention( Attention attention) {
		List<Attention> attentionList=this.select(attention);
		if(attentionList!=null&&attentionList.size()>0)
		{
			return attentionList.get(0);
		}
		return new Attention();
	}

	public Attention selectByPK(Attention attention) {
		return attentionDao.selectByPK(attention.getAttentionId());
	}

	public Integer create(Attention attention) {
		return attentionDao.insert(attention);
	}

	public Integer modify(Attention attention) {
		return attentionDao.updateByPK(attention);
	}

	public Integer remove(Attention attention) {
		return attentionDao.delete(attention);
	}

	public Integer removeBatch(String[] array) {
		return attentionDao.deleteBatch(array);
	}

	@Override
	public Integer count(Attention entity) {
		return attentionDao.count(entity);
	}

	public List<Attention> select(Attention entity) {
		return attentionDao.select(entity);
	}

	@Override
	public List<Attention> selectPage(Attention entity) {
		return attentionDao.selectPage(entity);
	}
}
