package inetbanking.services.impl;

import inetbanking.dao.AccountDAO;
import inetbanking.model.Account;
import inetbanking.services.AccountService;

import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceImpl extends BaseService<Account,Long> implements AccountService {

	@Autowired
	private AccountDAO accountDAO;

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
		this.dao = accountDAO;
	}
	
}
