package inetbanking.services.impl;

import inetbanking.dao.UserDAO;
import inetbanking.model.User;
import inetbanking.model.UserType;
import inetbanking.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class UserServiceImpl extends BaseService<User, Long> implements UserService, UserDetailsService {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private StandardPasswordEncoder passwordEncoder;
	
	public void setPasswordEncoder(StandardPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	public void setUserDAO(UserDAO userDAO) {
		dao = userDAO;
		this.userDAO = userDAO;
	}

	@Override
	public User getByUsername(String username) {
		User u = userDAO.getByUsername(username);
		if(u!=null)
			u.setPassword("");
		return u;
	}
	@Override
	public User save(User e) {
		e.setPassword(passwordEncoder.encode(e.getPassword()));
		return super.save(e);
	}
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User u = userDAO.getByUsername(username);
		if(u == null) {
			throw new UsernameNotFoundException("User with specified username does not exist!");
		}
		return u;
	}
}
