package inetbanking.model;

import java.security.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Tranzaction extends BaseEntity{

	@ManyToOne(fetch=FetchType.LAZY)
	Account source;
	@ManyToOne(fetch=FetchType.LAZY)
	Account destination;
	Long amount;
	Timestamp creationDate;
	@Enumerated(EnumType.STRING)
	TranzactionStatus status;
	
	public Account getSource() {
		return source;
	}
	public void setSource(Account source) {
		this.source = source;
	}
	public Account getDestination() {
		return destination;
	}
	public void setDestination(Account destination) {
		this.destination = destination;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	public TranzactionStatus getStatus() {
		return status;
	}
	public void setStatus(TranzactionStatus status) {
		this.status = status;
	}
	
}
