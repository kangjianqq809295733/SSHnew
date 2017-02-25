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

@Component("index")
@Scope("prototype")
public class IndexAction extends ActionSupport {

	private Map request;
	private Map session;
	private Map application;
	private MessageManager messageManager;

	public IndexAction() {
		request = (Map) ActionContext.getContext().get("request");
		session = ActionContext.getContext().getSession();
		application = ActionContext.getContext().getApplication();
	}


	@Override
	public String execute() throws Exception {
		List<Message> messages = messageManager.getAllMessages();
		request.put("messages", messages);
		return "success";
	}

	public MessageManager getMessageManager() {
		return messageManager;
	}

	@Resource
	public void setMessageManager(MessageManager messageManager) {
		this.messageManager = messageManager;
	}

}
