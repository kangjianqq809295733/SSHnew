package bbs.interceptor;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import bbs.model.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckUserInterceptor extends AbstractInterceptor {

    public String intercept(ActionInvocation invocation) throws Exception {
        // 获取信息
        User user = (User) ActionContext.getContext().getSession().get("user"); // 当前登录用户
        String namespace = invocation.getProxy().getNamespace();
        String actionName = invocation.getProxy().getActionName();
        String privUrl = namespace + actionName; // 对应的权限URL，用户要访问的URL
        System.out.println("--------------------"+privUrl);
        // 如果未登录
        if (user == null) {
            if (privUrl.startsWith("/login") || privUrl.startsWith("/index") ||privUrl.startsWith("/show")) { //login index show
                // 如果是去登录，就放行
                return invocation.invoke();
            } else {
                // 如果不是去登录，就转到登录页面
                return Action.LOGIN;
            }
        }
        // 如果已登录就判断权限
        else {
        	return invocation.invoke();
        }
    }
}