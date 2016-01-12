package inetbanking.controllers;

import inetbanking.services.AccountService;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;


@Path("/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	
}
