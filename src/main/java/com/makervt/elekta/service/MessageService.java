package com.makervt.elekta.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makervt.core.domain.Page;
import com.makervt.core.service.BaseService;
import com.makervt.core.util.StringUtils;
import com.makervt.elekta.dao.AppVersionDao;
import com.makervt.elekta.dao.MessageDao;
import com.makervt.elekta.entity.AppVersion;
import com.makervt.elekta.entity.Message;

@Service("messageService")
public class MessageService extends BaseService<Message> {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private MessageDao messageDao;
	
	@Autowired
	private AppVersionDao appVersionDao;

	public Page<Message> queryMessageList(Message message) {
		Page<Message> messages = this.queryPage(message);
		List<Message> msgList = messages.getResult();
		if (msgList != null && msgList.size() > 0) {
			List<Message> updateList = new ArrayList<Message>();
			for (Message msg : msgList) {
				if (StringUtils.equalsIgnoreCase("0", msg.getMessageStatus()))
				updateList.add(msg);
			}
			if (updateList != null && updateList.size() > 0) {
				messageDao.updateViewStatus(updateList);
				MipProviderService.messagViewByMip(updateList);
			}
		}
		return messages;
	}
	
	public AppVersion getAppVersion(AppVersion appVersion) {
		logger.info("getAppVersion params:<{}>", appVersion);
		List<AppVersion> list = appVersionDao.select(appVersion);
		logger.info("getAppVersion result:<{}>", list);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			
		}
		return null;
	}
	
	public void addAppVersion(AppVersion appVersion) {
		logger.info("getAppVersion params:<{}>", appVersion);
		appVersionDao.insert(appVersion);
	}

	public String countMessage(Message message) {
		Integer count = this.count(message);
		return String.valueOf(count);
	}

	public Integer create(Message message) {
		return messageDao.insert(message);
	}

	public Integer modify(Message message) {
		return messageDao.updateByPK(message);
	}

	public Integer remove(Message message) {
		return messageDao.delete(message);
	}

	public Integer removeBatch(String[] array) {
		return messageDao.deleteBatch(array);
	}

	@Override
	public Integer count(Message entity) {
		return messageDao.count(entity);
	}

	public List<Message> select(Message entity) {
		return messageDao.select(entity);
	}

	@Override
	public List<Message> selectPage(Message entity) {
		return messageDao.selectPage(entity);
	}
}
