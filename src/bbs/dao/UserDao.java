package bbs.dao;



import java.util.ArrayList;
import java.util.List;

import bbs.model.User;
import bbs.vo.UserVo;




public interface UserDao {
	
	public List<User> findUserByInstance(UserVo uservo);
	public List<User> findUserByName(UserVo uservo);
	public void saveUser(User user);
	
}
