package inetbanking.dao.impl;

import inetbanking.dao.UserDAO;
import inetbanking.model.User;

public class UserDAOImpl extends BaseDAO<User,Long> implements UserDAO {

	public UserDAOImpl() {
		super(User.class);
	}

}
