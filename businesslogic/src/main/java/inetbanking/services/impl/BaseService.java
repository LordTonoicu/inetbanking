package inetbanking.services.impl;

import inetbanking.dao.CRUDDAO;
import inetbanking.model.BaseEntity;
import inetbanking.model.User;
import inetbanking.services.CRUDService;

public class BaseService<Entity extends BaseEntity, I> implements CRUDService<Entity, I>{

	protected CRUDDAO<Entity,I> dao;
	
	public void setDao(CRUDDAO<Entity,I> dao) {
		this.dao = dao;
	}
	
	public Entity save(Entity e) {
		return dao.save(e);
	}

	public Entity update(Entity e) {
		return dao.update(e);
	}

	public void delete(Entity e) {
		dao.delete(e);
	}

	public Entity getById(I id) {
		return dao.getById(id);
	}


}
