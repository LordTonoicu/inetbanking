package inetbanking.dao;

import inetbanking.model.BaseEntity;

public interface CRUDDAO <Entity extends BaseEntity, I> {
	public Entity save(Entity e);
	public Entity update(Entity e);
	public void delete(Entity e);
	public Entity getById(I id);
}
