package inetbanking.model;

import java.security.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@SuppressWarnings("serial")
public class Credit extends BaseEntity{

	Integer period;
	Long amount;
	Long leftToPay;
	@ManyToOne(fetch=FetchType.LAZY)
	Account account;
	@Enumerated(EnumType.STRING)
	CreditStatus status;
	Timestamp dateCreated;
	
	public Integer getPeriod() {
		return period;
	}
	public void setPeriod(Integer period) {
		this.period = period;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Long getLeftToPay() {
		return leftToPay;
	}
	public void setLeftToPay(Long leftToPay) {
		this.leftToPay = leftToPay;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public CreditStatus getStatus() {
		return status;
	}
	public void setStatus(CreditStatus status) {
		this.status = status;
	}
	public Timestamp getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}
	
}
