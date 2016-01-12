package inetbanking.config;

import inetbanking.controllers.UserController;

import javax.ws.rs.ext.ExceptionMapper;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class InjectionConfiguration extends ResourceConfig  {

	public InjectionConfiguration() {
		super();
	     register(RequestContextFilter.class);
	     register(ExceptionMapper.class);
	     register(UserController.class);
	}
	

}
