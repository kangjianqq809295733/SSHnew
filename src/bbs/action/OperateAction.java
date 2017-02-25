package bbs.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import bbs.model.Message;
import bbs.model.User;
import bbs.service.MessageManager;
import bbs.service.UserManager;
import bbs.vo.UserVo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("operate")
@Scope("prototype")
public class OperateAction extends ActionSupport {

	private Map request;
	private Map session;
	private Map application;
	private UserManager userManager;
	private MessageManager messageManager;

	public OperateAction() {
		request = (Map) ActionContext.getContext().get("request");
		session = ActionContext.getContext().getSession();
		application = ActionContext.getContext().getApplication();
	}

	@Override
	public String execute() throws Exception {
		//根据用户查询自己的公告，若管理员查询所有
		User user = (User) session.get("user");
		List<Message> messages = messageManager.getMessagesByUser(user);
		request.put("messages", messages);
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

	public void setMessageManager(MessageManager messageManager) {
		this.messageManager = messageManager;
	}
	
	

}
