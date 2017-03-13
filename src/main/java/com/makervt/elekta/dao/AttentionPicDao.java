package com.makervt.elekta.dao;


import com.makervt.core.dao.MyBatisDao;
import com.makervt.elekta.entity.AttentionPic;

import java.util.List;
@MyBatisDao
public interface AttentionPicDao {
	public List<AttentionPic> selectPage(AttentionPic attentionPic);
	public List<AttentionPic> select(AttentionPic attentionPic);
	public Integer count(AttentionPic attentionPic);
	public AttentionPic selectByPK(String attentionPicId);
	public Integer deleteByPK(String attentionPicId);
	public Integer updateByPK(AttentionPic attentionPic);
	public Integer insert(AttentionPic attentionPic);
	public Integer delete(AttentionPic attentionPic);
	public Integer deleteBatch(String[] array);
}
