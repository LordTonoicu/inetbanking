package inetbanking.config;

import inetbanking.controllers.AccountController;
import inetbanking.controllers.CreditController;
import inetbanking.controllers.HistoryController;
import inetbanking.controllers.TranzactionController;
import inetbanking.controllers.UserController;
import inetbanking.util.GenericExceptionMapper;

import javax.ws.rs.ext.ExceptionMapper;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class InjectionConfiguration extends ResourceConfig  {

	public InjectionConfiguration() {
		super();
	     register(RequestContextFilter.class);
	     register(ExceptionMapper.class);
	     register(GenericExceptionMapper.class);
	     register(UserController.class);
	     register(AccountController.class);
	     register(CreditController.class);
	     register(HistoryController.class);
	     register(TranzactionController.class);
	}
	

}
