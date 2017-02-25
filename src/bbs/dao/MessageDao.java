package bbs.dao;



import java.util.ArrayList;
import java.util.List;

import bbs.model.Message;
import bbs.model.User;


public interface MessageDao {
	
	public List<Message> getAllMessages();
	public List<Message> getMessageById(String messageid);
	public List<Message> getMessagesByUserId(Integer userId);
	public Message saveMessage(Message message);
	public void deleteMessage(Message message);
	public void updateMessage(Message message);
	
}
