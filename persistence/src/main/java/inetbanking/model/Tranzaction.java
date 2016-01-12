package inetbanking.model;

import java.security.Timestamp;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
public class Tranzaction extends BaseEntity{

	@OneToMany(fetch=FetchType.LAZY)
	Account source;
	@OneToMany(fetch=FetchType.LAZY)
	Account destination;
	Long amount;
	Timestamp creationDate;
	@Enumerated(EnumType.STRING)
	TranzactionStatus status;
}
