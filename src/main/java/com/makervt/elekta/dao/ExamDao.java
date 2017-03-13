package com.makervt.elekta.dao;

import com.makervt.elekta.entity.Exam;
import com.makervt.core.dao.MyBatisDao;

import java.util.List;
@MyBatisDao
public interface ExamDao {
	public List<Exam> selectPage(Exam exam);
	public List<Exam> select(Exam exam);
	public Integer count(Exam exam);
	public Exam selectByPK(String examId);
	public Integer deleteByPK(String examId);
	public Integer updateByPK(Exam exam);
	public Integer insert(Exam exam);
	public Integer delete(Exam exam);
	public Integer deleteBatch(String[] array);
}
