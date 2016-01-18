package inetbanking.controllers;

import inetbanking.model.User;
import inetbanking.model.UserType;
import inetbanking.services.UserService;
import inetbanking.util.TokenUtils;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@Path("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authManager;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public String helloWorld(){
		userService.save(new User("antoniu","antoniu","antoniu","antoniu","Ienciu",UserType.ADMIN));
		return "Heeey";
	}
	@POST
	@Path("/authenticate")
	public String authenticate(User u) {
		UsernamePasswordAuthenticationToken authenticationToken =
				new UsernamePasswordAuthenticationToken(u.getUsername(), u.getPassword());
		Authentication authentication = this.authManager.authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		UserDetails userDetails = this.userService.getByUsername(u.getUsername());

		return TokenUtils.createToken(userDetails);
	
	}
	@POST
	public void createAccount(User u) {
		userService.save(u);
	}
}
