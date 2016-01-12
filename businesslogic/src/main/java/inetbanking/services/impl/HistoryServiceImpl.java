package inetbanking.services.impl;

import inetbanking.dao.HistoryDAO;
import inetbanking.model.History;
import inetbanking.services.HistoryService;

import org.springframework.beans.factory.annotation.Autowired;

public class HistoryServiceImpl extends BaseService<History,Long> implements HistoryService{
	
	@Autowired
	private HistoryDAO historyDAO;

	public void setHistoryDAO(HistoryDAO historyDAO) {
		this.historyDAO = historyDAO;
		this.dao = historyDAO;
	}
	
}
