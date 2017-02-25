package bbs.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import bbs.model.Message;
import bbs.model.User;
import bbs.service.MessageManager;
import bbs.service.UserManager;
import bbs.vo.MessageVo;
import bbs.vo.UserVo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("publish")
@Scope("prototype")
public class PublishAction extends ActionSupport implements ModelDriven<MessageVo> {

	private Map request;
	private Map session;
	private Map application;
	private UserManager userManager;
	private MessageManager messageManager;
	private MessageVo messagevo = new MessageVo();

	public PublishAction() {
		request = (Map) ActionContext.getContext().get("request");
		session = ActionContext.getContext().getSession();
		application = ActionContext.getContext().getApplication();
	}

	public MessageVo getModel() {
		return messagevo;
	}

	@Override
	public String execute() throws Exception {
		User user = (User) session.get("user");
		Message message = new Message();
		message.setUser(user);
		message.setMessageTitle(messagevo.getTitle());
		message.setMessageContent(messagevo.getEditorValue());
		java.util.Date nowDate = new java.util.Date();// 取当前时间  
		SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 转换时间格式  
		String Stringdate = dateFormat.format(nowDate);   
		//Timestamp date = new Timestamp(System.currentTimeMillis());
		message.setMessageDate(Timestamp.valueOf(Stringdate));
		messageManager.publishMessage(message);
		return "success";
	}
	
	
	public UserManager getUserManager() {
		return userManager;
	}

	@Resource
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public MessageManager getMessageManager() {
		return messageManager;
	}
	
	@Resource
	public void setMessageManager(MessageManager messageManager) {
		this.messageManager = messageManager;
	}
	
}
