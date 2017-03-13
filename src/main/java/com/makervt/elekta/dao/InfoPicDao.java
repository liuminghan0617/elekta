package com.makervt.elekta.dao;


import com.makervt.core.dao.MyBatisDao;
import com.makervt.elekta.entity.InfoPic;

import java.util.List;
@MyBatisDao
public interface InfoPicDao {
	public List<InfoPic> selectPage(InfoPic infoPic);
	public List<InfoPic> select(InfoPic infoPic);
	public Integer count(InfoPic infoPic);
	public InfoPic selectByPK(String infoPicId);
	public Integer deleteByPK(String infoPicId);
	public Integer updateByPK(InfoPic infoPic);
	public Integer insert(InfoPic infoPic);
	public Integer delete(InfoPic infoPic);
	public Integer deleteBatch(String[] array);
}
