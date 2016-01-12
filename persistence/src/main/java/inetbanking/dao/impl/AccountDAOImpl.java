package inetbanking.dao.impl;

import inetbanking.dao.AccountDAO;
import inetbanking.model.Account;

public class AccountDAOImpl extends BaseDAO<Account, Long> implements AccountDAO{

	public AccountDAOImpl() {
		super(Account.class);
	}

}
