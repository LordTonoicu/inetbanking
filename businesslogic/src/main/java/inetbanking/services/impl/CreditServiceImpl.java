package inetbanking.services.impl;

import inetbanking.dao.CreditDAO;
import inetbanking.model.Credit;
import inetbanking.services.CreditService;

import org.springframework.beans.factory.annotation.Autowired;

public class CreditServiceImpl extends BaseService<Credit,Long> implements CreditService {

	@Autowired
	private CreditDAO creditDAO;

	public void setCreditDAO(CreditDAO creditDAO) {
		this.creditDAO = creditDAO;
		this.dao = creditDAO;
	}
	
}
