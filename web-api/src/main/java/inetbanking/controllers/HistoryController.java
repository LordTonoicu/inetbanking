package inetbanking.controllers;

import inetbanking.services.HistoryService;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

@Path("/history")
public class HistoryController {

	@Autowired
	private HistoryService historyService;

	public void setHistoryService(HistoryService historyService) {
		this.historyService = historyService;
	}
	
	
}
