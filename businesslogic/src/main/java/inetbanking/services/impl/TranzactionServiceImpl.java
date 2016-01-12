package inetbanking.services.impl;

import inetbanking.dao.TranzactionDAO;
import inetbanking.model.Tranzaction;
import inetbanking.services.TranzactionService;

import org.springframework.beans.factory.annotation.Autowired;

public class TranzactionServiceImpl extends BaseService<Tranzaction, Long> implements TranzactionService{

	@Autowired
	private TranzactionDAO tranzactionDAO;

	public void setTranzactionDAO(TranzactionDAO tranzactionDAO) {
		this.tranzactionDAO = tranzactionDAO;
		this.dao = tranzactionDAO;
	}
	
	
}
