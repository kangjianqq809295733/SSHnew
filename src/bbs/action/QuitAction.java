package bbs.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import bbs.model.User;
import bbs.service.UserManager;
import bbs.vo.UserVo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("quit")
@Scope("prototype")
public class QuitAction extends ActionSupport implements ModelDriven<UserVo>,ServletRequestAware {

	private Map request;
	private Map session;
	private Map application;
	private UserManager userManager;
	private UserVo uservo = new UserVo();
	private HttpServletRequest req;

	public QuitAction() {
		request = (Map) ActionContext.getContext().get("request");
		session = ActionContext.getContext().getSession();
		application = ActionContext.getContext().getApplication();
	}

	public UserVo getModel() {
		return uservo;

	}

	@Override
	public String execute() throws Exception {
		//req.getSession().invalidate();
		//HttpSession session = req.getSession(true);
		//清空session
		ActionContext.getContext().getSession().clear();
		//使HttpSession失效
		//ServletActionContext.getRequest().getSession().invalidate();
		return "success";
	}

	public UserManager getUserManager() {
		return userManager;
	}

	@Resource
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public void setServletRequest(HttpServletRequest req) {
		this.req = req;
	}

}
