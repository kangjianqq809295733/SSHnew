package bbs.service;



import java.util.List;

import bbs.model.Message;
import bbs.model.User;



public interface MessageManager {

	
	public List<Message> getAllMessages();
	public Message getMessageById(String messageid);
	public List<Message> getMessagesByUser(User user);
	public Message publishMessage(Message message);
	public void deleteMessage(String messageid);
	public void updateMessage(Message message);
	
}