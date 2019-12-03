package repositories;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.GenericEntity;



public abstract class EntityRepository <T extends GenericEntity> {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	public T createEntity(T entity) {	
		
		
		return entityManager.merge(entity);
	}
	
	public T getEntity(Long id) {
		return entityManager.find(getEntityClass(),id);
	}
	
	public Collection<T> getAllEntities(){
		return entityManager.createNamedQuery(getAllEntityQueryName(), getEntityClass()).getResultList();
	}
	
	public Collection<Long> getAllIds(){
		return entityManager.createNamedQuery(getAllEntityIdsQueryName(), long.class).getResultList();
	}
	

	public T editEntity(T editedEntity) {
		
		return entityManager.merge(editedEntity);
	}
	
	public void removeEntity(Long id) {
		T entity = entityManager.find(getEntityClass(), id);
		entityManager.remove(entity);
	}
	
	protected abstract Class<T> getEntityClass();
	
	protected abstract String getAllEntityQueryName();
	
	protected abstract String getAllEntityIdsQueryName();
	
	
}