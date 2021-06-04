package easymall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import easymall.dao.UserDao;
import easymall.po.User;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;
	
	public User login(User user) {
		return userDao.login(user);
	}
	
	public boolean checkUsername(String username) {
		User us=userDao.checkUsername(username);
		if(us!=null)
			return true;
		else
			return false;
	}

	public int regist(User user) {
		int n=userDao.regist(user);
		return n;
	}

	public int activation(String username) {
		return userDao.activation(username);
	}
}
