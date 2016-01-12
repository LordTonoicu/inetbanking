package inetbanking.dao.impl;

import inetbanking.dao.HistoryDAO;
import inetbanking.model.History;

public class HistoryDAOImpl extends BaseDAO<History,Long> implements HistoryDAO {

	public HistoryDAOImpl() {
		super(History.class);
	}

}
