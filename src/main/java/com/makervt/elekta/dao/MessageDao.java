package com.makervt.elekta.dao;

import com.makervt.core.dao.MyBatisDao;
import com.makervt.elekta.entity.Message;


import java.util.List;
@MyBatisDao
public interface MessageDao {
	public List<Message> selectPage(Message message);
	public List<Message> select(Message message);
	public List<Message> selectMessageBatch(List<Message> messages);
	public Integer count(Message message);
	public Message selectByPK(String messageId);
	public Integer deleteByPK(String messageId);
	public Integer updateByPK(Message message);
	public Integer updateViewStatus(List<Message> messages);
	public Integer insert(Message message);
	public Integer insertBatch(List<Message> messages);
	public Integer delete(Message message);
	public Integer deleteBatch(String[] array);
}
