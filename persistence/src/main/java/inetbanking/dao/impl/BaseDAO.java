package inetbanking.dao.impl;

import java.util.List;

import inetbanking.dao.CRUDDAO;
import inetbanking.model.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

public class BaseDAO<Entity extends BaseEntity,I> implements CRUDDAO<Entity, I> {
	@PersistenceContext
	protected EntityManager entityManager;
	private Class<Entity> thiz;
	
	public BaseDAO(Class<Entity> thiz) {
		super();
		this.thiz = thiz;
	}

	@Transactional
	public Entity save(Entity e) {
		return entityManager.merge(e);
	}
	@Transactional
	public Entity update(Entity e) {
		return entityManager.merge(e);
	}
	@Transactional
	public void delete(Entity e) {
		entityManager.remove(e);
	}
	@Transactional
	public Entity getById(I id) {
		return entityManager.find(thiz, id);
	}

	@Transactional
	public List<Entity> getAll() {
		return  entityManager.createQuery("Select t from " + thiz.getSimpleName() + " t").getResultList();
	}

	
	
}
