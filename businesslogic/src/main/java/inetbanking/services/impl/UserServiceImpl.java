package inetbanking.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import inetbanking.dao.UserDAO;
import inetbanking.model.User;
import inetbanking.services.UserService;

public class UserServiceImpl extends BaseService<User, Long> implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		dao = userDAO;
		this.userDAO = userDAO;
	}
}
