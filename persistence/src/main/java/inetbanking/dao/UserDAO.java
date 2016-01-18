package inetbanking.dao;

import inetbanking.model.User;

public interface UserDAO extends CRUDDAO<User, Long>{

	User getByUsername(String username);

}
