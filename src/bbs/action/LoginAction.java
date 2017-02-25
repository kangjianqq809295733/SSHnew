package bbs.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import bbs.model.User;
import bbs.service.UserManager;
import bbs.vo.UserVo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("login")
@Scope("prototype")
public class LoginAction extends ActionSupport implements ModelDriven<UserVo> {

	private Map request;
	private Map session;
	private Map application;
	private UserManager userManager;
	private UserVo uservo = new UserVo();

	public LoginAction() {
		request = (Map) ActionContext.getContext().get("request");
		session = ActionContext.getContext().getSession();
		application = ActionContext.getContext().getApplication();
	}

	public UserVo getModel() {
		return uservo;

	}

	@Override
	public String execute() throws Exception {
		User user = userManager.findUserByInstance(uservo);
		if(user != null) {
			session.put("user", user);
			return "success";
		}else {
			this.addFieldError("fail", "用户名或密码错误");
			request.put("data", user);
			return "error";
		}
	}

	public UserManager getUserManager() {
		return userManager;
	}

	@Resource
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

}
