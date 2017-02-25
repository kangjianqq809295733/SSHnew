package bbs.dao.impl;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;



import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;


import bbs.dao.UserDao;
import bbs.model.User;
import bbs.vo.UserVo;




@Component("userDao")
public class UserDaoImpl implements UserDao {
	
	private HibernateTemplate hibernateTemplate; 

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public List<User> findUserByInstance(UserVo vo) {
		List<User> users = this.hibernateTemplate.find("from User user where user.userName=? " +
				"and user.userPassword=?",new Object[]{vo.getUsername(),vo.getPassword()});
		return users;
	}

	public List<User> findUserByName(UserVo uservo) {
		Object value[] = {uservo.getUsername()};
		List<User> users = (List<User>) hibernateTemplate.find("from bbs.model.User u where u.userName = ?",value);
		return users;
	}

	public void saveUser(User user) {
		hibernateTemplate.save(user);
	}
	
}
