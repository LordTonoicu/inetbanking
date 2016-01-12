package inetbanking.services;

import org.springframework.stereotype.Service;

import inetbanking.model.User;

@Service
public interface UserService extends CRUDService<User,Long>{

}
