package inetbanking.services;

import inetbanking.model.Account;
import inetbanking.model.User;

import java.util.List;

public interface AccountService extends CRUDService<Account, Long> {

	List<Account> getByUserId(Long id);
}
