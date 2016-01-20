package inetbanking.services.impl;

import inetbanking.dao.AccountDAO;
import inetbanking.exceptions.BusinessException;
import inetbanking.model.Account;
import inetbanking.model.User;
import inetbanking.model.UserType;
import inetbanking.services.AccountService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

public class AccountServiceImpl extends BaseService<Account,Long> implements AccountService {

	@Autowired
	private AccountDAO accountDAO;

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
		this.dao = accountDAO;
	}

	@Override
	public List<Account> getByUserId(Long id) {
		return accountDAO.getByUserId(id);
	}
	@Override
	public List<Account> getAll(){
		//TODO: find a better way to do this!
		User u = new User();
		if(u!=null) {
			if(u.getType()!=null && u.getType()!=UserType.CLIENT)
				return dao.getAll();
			else 
				return accountDAO.getByUserId(u.getId());
		} 
		throw new BusinessException("User not logged!");
		
	}
	@Override
	public Account save(Account newAccount){
		newAccount.setStatus("AWAITING_APPROVAL");
		return accountDAO.save(newAccount);
	}
}
