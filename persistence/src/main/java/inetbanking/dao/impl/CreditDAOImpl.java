package inetbanking.dao.impl;

import inetbanking.dao.CreditDAO;
import inetbanking.model.Credit;

public class CreditDAOImpl extends BaseDAO<Credit, Long> implements CreditDAO {

	public CreditDAOImpl() {
		super(Credit.class);
	}

}
