package inetbanking.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;

import inetbanking.dao.CRUDDAO;
import inetbanking.model.BaseEntity;

public class BaseDAO<Entity extends BaseEntity,I> implements CRUDDAO<Entity, I> {
	@PersistenceUnit(unitName="hibernateProvider")
	private EntityManager entityManager;
	private Class<Entity> thiz;
	
	public BaseDAO(Class<Entity> thiz) {
		super();
		this.thiz = thiz;
	}

	public Entity save(Entity e) {
		return entityManager.merge(e);
	}

	public Entity update(Entity e) {
		return entityManager.merge(e);
	}

	public void delete(Entity e) {
		entityManager.remove(e);
	}

	public Entity getById(I id) {
		return entityManager.find(thiz, id);
	}

	
	
}
