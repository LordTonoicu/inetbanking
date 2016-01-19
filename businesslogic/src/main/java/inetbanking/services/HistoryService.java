package inetbanking.services;

import java.util.List;

import inetbanking.model.History;

public interface HistoryService extends CRUDService<History, Long>{

	List<History> getByUserId(Long id);

}
