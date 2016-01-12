package inetbanking.controllers;

import inetbanking.model.User;
import inetbanking.model.UserType;
import inetbanking.services.UserService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

@Path("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public String helloWorld(){
		userService.save(new User("antoniu","antoniu","antoniu","antoniu","Ienciu",UserType.ADMIN));
		return "Heeey";
	}
}
