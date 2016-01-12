package inetbanking.model;

import java.security.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class History extends BaseEntity{

	Timestamp operationTimestamp;
	String operation;
	@ManyToOne(fetch=FetchType.LAZY)
	Account account;
	public Timestamp getOperationTimestamp() {
		return operationTimestamp;
	}
	public void setOperationTimestamp(Timestamp operationTimestamp) {
		this.operationTimestamp = operationTimestamp;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
}
