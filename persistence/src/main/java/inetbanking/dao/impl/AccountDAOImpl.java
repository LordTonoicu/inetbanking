package inetbanking.dao.impl;

import inetbanking.dao.AccountDAO;
import inetbanking.model.Account;

import java.util.List;

public class AccountDAOImpl extends BaseDAO<Account, Long> implements AccountDAO{

	public AccountDAOImpl() {
		super(Account.class);
	}

	@Override
	public List<Account> getByUserId(Long id) {
		return entityManager.createQuery("SELECT a from Account a WHERE a.user.id=:id").setParameter("id", id).getResultList();
	}

}
