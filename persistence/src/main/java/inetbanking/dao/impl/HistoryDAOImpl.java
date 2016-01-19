package inetbanking.dao.impl;

import java.util.List;

import inetbanking.dao.HistoryDAO;
import inetbanking.model.History;

public class HistoryDAOImpl extends BaseDAO<History,Long> implements HistoryDAO {

	public HistoryDAOImpl() {
		super(History.class);
	}

	@Override
	public List<History> getByUserId(Long id) {
		return entityManager.createQuery("SELECT h from History h WHERE h.account.user.id=:id").setParameter("id", id).getResultList();
		
	}

}
