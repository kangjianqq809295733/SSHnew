package bbs.service;



import java.util.List;

import bbs.model.User;
import bbs.vo.UserVo;



public interface UserManager {
	
	public User findUserByInstance(UserVo uservo);
	public User registUser(UserVo uservo);
	
}