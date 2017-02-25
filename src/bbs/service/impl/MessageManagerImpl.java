package bbs.service.impl;



import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import bbs.dao.MessageDao;
import bbs.dao.UserDao;
import bbs.model.Message;
import bbs.model.User;
import bbs.service.MessageManager;
import bbs.service.UserManager;



@Component("messageManager")
public class MessageManagerImpl implements MessageManager {
	
	private UserDao userDao;
	private MessageDao messageDao;
	
	public UserDao getUserDao() {
		return userDao;
	}
	
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	

	public MessageDao getMessageDao() {
		return messageDao;
	}
	
	@Resource
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	//获取首页数据
	public List<Message> getAllMessages() {
		List<Message> messages = messageDao.getAllMessages();
		return messages;
	}

	public Message getMessageById(String messageid) {
		List<Message> message = messageDao.getMessageById(messageid);
		return message.get(0);
	}

	public List<Message> getMessagesByUser(User user) {
		//根据用户查询自己的公告，若管理员查询所有
		List<Message> messages = null;
		if(user.getUserAccess() == true) {
			messages = messageDao.getAllMessages();
		}else {
			messages = messageDao.getMessagesByUserId(user.getUserId());
		}
		return messages;
	}

	public Message publishMessage(Message message) {
		Message _message = messageDao.saveMessage(message);
		return message;
	}

	public void deleteMessage(String messageid) {
		Message message = new Message();
		message.setMessageId(new Integer(messageid));
		messageDao.deleteMessage(message);
	}

	public void updateMessage(Message message) {
		messageDao.updateMessage(message);
	}

	
}


