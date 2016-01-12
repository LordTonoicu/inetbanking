package inetbanking.controllers;

import inetbanking.services.CreditService;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

@Path("/credits")
public class CreditController {

	@Autowired
	private CreditService creditService;

	public void setCreditService(CreditService creditService) {
		this.creditService = creditService;
	}
	
}
