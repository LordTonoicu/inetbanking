package inetbanking.services;

import inetbanking.model.BaseEntity;

import java.util.List;

public interface CRUDService<Entity extends BaseEntity, I> {

	public Entity save(Entity e);
	public Entity update(Entity e);
	public void delete(Entity e);
	public Entity getById(I id);
	public List<Entity> getAll();
}
