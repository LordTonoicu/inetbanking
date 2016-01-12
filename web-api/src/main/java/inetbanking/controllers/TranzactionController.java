package inetbanking.controllers;

import inetbanking.services.TranzactionService;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

@Path("/tranzactions")
public class TranzactionController {

	@Autowired
	private TranzactionService tranzactionService;

	public void setTranzactionService(TranzactionService tranzactionService) {
		this.tranzactionService = tranzactionService;
	}
	
	
}
