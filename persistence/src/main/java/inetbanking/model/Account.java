package inetbanking.model;

import java.security.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Account extends BaseEntity {

	@Enumerated(EnumType.STRING)
	private CurrencyType currency;
	Long balance;
	Timestamp creationDate;
	@ManyToOne(fetch=FetchType.LAZY)
	User user;
	public CurrencyType getCurrency() {
		return currency;
	}
	public void setCurrency(CurrencyType currency) {
		this.currency = currency;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
