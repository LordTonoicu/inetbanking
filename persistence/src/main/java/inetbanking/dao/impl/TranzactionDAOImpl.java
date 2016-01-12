package inetbanking.dao.impl;

import inetbanking.dao.TranzactionDAO;
import inetbanking.model.Tranzaction;

public class TranzactionDAOImpl extends BaseDAO<Tranzaction, Long> implements TranzactionDAO {

	public TranzactionDAOImpl() {
		super(Tranzaction.class);
	}

}
