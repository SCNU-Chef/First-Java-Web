package easymall.service;

import easymall.po.User;

public interface UserService {
	public User login(User user);
	public boolean checkUsername(String username);
	public int regist(User user);
	public int activation(String username);
}
