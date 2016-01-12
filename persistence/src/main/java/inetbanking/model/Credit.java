package inetbanking.model;

import java.security.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@SuppressWarnings("serial")
public class Credit extends BaseEntity{

	Integer period;
	Long amount;
	Long leftToPay;
	@OneToMany(fetch=FetchType.LAZY)
	Account account;
	@Enumerated(EnumType.STRING)
	CreditStatus status;
	Timestamp dateCreated;
}
