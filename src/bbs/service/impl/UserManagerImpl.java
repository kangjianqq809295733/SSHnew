package bbs.service.impl;



import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import bbs.dao.UserDao;
import bbs.model.User;
import bbs.service.UserManager;
import bbs.vo.UserVo;



@Component("userManager")
public class UserManagerImpl implements UserManager {
	
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}
	
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User findUserByInstance(UserVo uservo) {
		List<User> users = userDao.findUserByInstance(uservo);
		if(users.size() == 1) {
			return users.get(0);
		}else {
			return null;
		}
	}

	public User registUser(UserVo uservo) {
		List<User> users = userDao.findUserByName(uservo);
		if(users.size() != 0) {
			return null;
		}else {
			System.out.println("save pro");
			User user = new User();
			user.setUserName(uservo.getUsername());
			user.setUserPassword(uservo.getPassword());
			user.setUserAccess(false);
			userDao.saveUser(user);
			return user;
		}
	}

	
}


