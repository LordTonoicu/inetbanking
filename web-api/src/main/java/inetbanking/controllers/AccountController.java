package inetbanking.controllers;

import inetbanking.model.Account;
import inetbanking.services.AccountService;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;


@Path("/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	@GET
	@Path("/user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Account> getByUserId(@PathParam("id") Long id) {
		return accountService.getByUserId(id);
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Account> getAll() {
		return accountService.getAll();
	}
}
