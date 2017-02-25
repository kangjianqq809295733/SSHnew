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
import bbs.vo.EditVo;
import bbs.vo.MessageVo;
import bbs.vo.UserVo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("edit")
@Scope("prototype")
public class EditAction extends ActionSupport implements ModelDriven<EditVo> {

	private Map request;
	private Map session;
	private Map application;
	private UserManager userManager;
	private MessageManager messageManager;
	private EditVo editvo = new EditVo();

	public EditAction() {
		request = (Map) ActionContext.getContext().get("request");
		session = ActionContext.getContext().getSession();
		application = ActionContext.getContext().getApplication();
	}

	public EditVo getModel() {
		return editvo;
	}

	@Override
	public String execute() throws Exception {
		Message message = new Message();
		message.setMessageTitle(editvo.getTitle());
		message.setMessageContent(editvo.getEditorValue());
		message.setMessageId(Integer.parseInt(editvo.getMessageid()));
		User user = (User) session.get("user");
		message.setUser(user);
		messageManager.updateMessage(message);
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
