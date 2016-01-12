package inetbanking.model;

import java.security.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Account extends BaseEntity {

	@Enumerated(EnumType.STRING)
	private CurrencyType currency;
	Long balance;
	Timestamp creationDate;
	@OneToMany(fetch=FetchType.LAZY)
	User user;
}
