package inetbanking.controllers;

import inetbanking.model.History;
import inetbanking.services.HistoryService;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

@Path("/history")
public class HistoryController {

	@Autowired
	private HistoryService historyService;

	public void setHistoryService(HistoryService historyService) {
		this.historyService = historyService;
	}
	@GET
	@Path("/user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<History> getByUserId(@PathParam("id") Long id) {
		return historyService.getByUserId(id);
	}
	
}
