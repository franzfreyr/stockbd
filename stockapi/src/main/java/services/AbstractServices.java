package services;

import java.util.Collection;
import java.util.Objects;
import javax.inject.Inject;
import javax.transaction.Transactional;

import model.GenericEntity;
import repositories.EntityRepository;

public abstract class AbstractServices<T extends EntityRepository<E>, E extends GenericEntity> {

	@Inject
	protected T repository;
	@Transactional
	public Collection<E> getAll() {

		return repository.getAllEntities();
	}
	@Transactional
	public E create(E Entity) {

		return repository.createEntity(Entity);

	}
	@Transactional
	public E getId(Long id) {

		return repository.getEntity(id);
	}
	@Transactional
	public void remove(Long id) {
		repository.removeEntity(id);
	}
	@Transactional
	public E update(int id, E Entity) throws Exception {
		if (Objects.isNull(Entity)) {
			throw new Exception("The entity should not be null.");

		}
		if (Entity.getId() != id) {
			throw new Exception("The ids do not match");
		}
		return repository.editEntity(Entity);
	}

}
