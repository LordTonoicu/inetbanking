package inetbanking.model;

import java.security.Timestamp;

@SuppressWarnings("serial")
public class History extends BaseEntity{

	Timestamp operationTimestamp;
	String operation;
	Account account;
}
