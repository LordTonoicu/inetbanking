package inetbanking.dao;

import java.util.List;

import inetbanking.model.Account;

public interface AccountDAO extends CRUDDAO<Account, Long> {

	List<Account> getByUserId(Long id);

}
