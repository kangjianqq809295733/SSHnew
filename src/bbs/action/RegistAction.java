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

@Component("regist")
@Scope("prototype")
public class RegistAction extends ActionSupport implements ModelDriven<UserVo> {

	private Map request;
	private Map session;
	private Map application;
	private UserManager userManager;
	private UserVo uservo = new UserVo();

	public RegistAction() {
		request = (Map) ActionContext.getContext().get("request");
		session = ActionContext.getContext().getSession();
		application = ActionContext.getContext().getApplication();
	}

	public UserVo getModel() {
		return uservo;

	}

	@Override
	public String execute() throws Exception {
		User user = userManager.registUser(uservo);
		//用户名已经存在
		if(user == null) {
			this.addFieldError("fail", "用户名已存在");
			request.put("data", user);
			return "error";
		}else {
			request.put("user", user);
			return "success";
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
