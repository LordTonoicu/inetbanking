package inetbanking.services.impl;

import inetbanking.dao.CRUDDAO;
import inetbanking.model.BaseEntity;
import inetbanking.services.CRUDService;

public class BaseService<Entity extends BaseEntity, I> implements CRUDService<Entity, I>{

	protected CRUDDAO<Entity,I> dao;
	
	public void setDao(CRUDDAO<Entity,I> dao) {
		this.dao = dao;
	}

	@Override
	public Entity save(Entity e) {
		return dao.save(e);
	}

	@Override
	public Entity update(Entity e) {
		return dao.update(e);
	}

	@Override
	public void delete(Entity e) {
		dao.delete(e);
	}

	@Override
	public Entity getById(I id) {
		return dao.getById(id);
	}

}
