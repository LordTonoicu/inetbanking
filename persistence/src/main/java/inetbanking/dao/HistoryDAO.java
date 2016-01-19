package inetbanking.dao;

import java.util.List;

import inetbanking.model.History;

public interface HistoryDAO extends CRUDDAO<History, Long> {

	List<History> getByUserId(Long id);
	

}
