package inetbanking.services;

import java.util.List;

import inetbanking.model.Account;

public interface AccountService extends CRUDService<Account, Long> {

	List<Account> getByUserId(Long id);

}
