package com.makervt.elekta.dao;

import com.makervt.elekta.entity.QuestionAddPic;
import com.makervt.core.dao.MyBatisDao;

import java.util.List;
@MyBatisDao
public interface QuestionAddPicDao {
	public List<QuestionAddPic> selectPage(QuestionAddPic questionAddPic);
	public List<QuestionAddPic> select(QuestionAddPic questionAddPic);
	public Integer count(QuestionAddPic questionAddPic);
	public QuestionAddPic selectByPK(String questionAddPicId);
	public Integer deleteByPK(String questionAddPicId);
	public Integer updateByPK(QuestionAddPic questionAddPic);
	public Integer insert(QuestionAddPic questionAddPic);
	public Integer delete(QuestionAddPic questionAddPic);
	public Integer deleteBatch(String[] array);
}
