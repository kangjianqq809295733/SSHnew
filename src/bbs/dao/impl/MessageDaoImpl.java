package bbs.dao.impl;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;



import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;


import bbs.dao.MessageDao;
import bbs.dao.UserDao;
import bbs.model.Message;
import bbs.model.User;




@Component("messageDao")
public class MessageDaoImpl implements MessageDao {
	
	private HibernateTemplate hibernateTemplate; 

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public List<Message> getAllMessages() {
		List<Message> messages = this.hibernateTemplate.find("from Message m order by m.messageDate desc");
		return messages;
	}

	public List<Message> getMessageById(String messageid) {
		Integer id = new Integer(messageid);
		List<Message> messages = this.hibernateTemplate.find("from Message message " +
				"where message.messageId=?",id);
		return messages;
	}

	public List<Message> getMessagesByUserId(Integer userId) {
		List<Message> messages = this.hibernateTemplate.find("from Message message " +
				"where message.user.userId=? order by message.messageDate desc",userId);
		return messages;
	}

	public Message saveMessage(Message message) {
		this.hibernateTemplate.save(message);
		return message;
	}

	public void deleteMessage(Message message) {
		this.hibernateTemplate.delete(message);
	}

	public void updateMessage(Message message) {
		this.hibernateTemplate.update(message);
		this.hibernateTemplate.flush();
		this.hibernateTemplate.clear();
	}
	
}
