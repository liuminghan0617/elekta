package com.makervt.elekta.dao;

import com.makervt.elekta.entity.QuestionExamplePic;
import com.makervt.core.dao.MyBatisDao;

import java.util.List;
@MyBatisDao
public interface QuestionExamplePicDao {
	public List<QuestionExamplePic> selectPage(QuestionExamplePic questionExamplePic);
	public List<QuestionExamplePic> select(QuestionExamplePic questionExamplePic);
	public Integer count(QuestionExamplePic questionExamplePic);
	public QuestionExamplePic selectByPK(String questionExamplePicId);
	public Integer deleteByPK(String questionExamplePicId);
	public Integer updateByPK(QuestionExamplePic questionExamplePic);
	public Integer insert(QuestionExamplePic questionExamplePic);
	public Integer delete(QuestionExamplePic questionExamplePic);
	public Integer deleteBatch(String[] array);
}
