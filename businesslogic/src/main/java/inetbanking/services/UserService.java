package inetbanking.services;

import inetbanking.model.User;

import org.springframework.stereotype.Service;

@Service
public interface UserService extends CRUDService<User,Long>{

	User getByUsername(String username);

}
