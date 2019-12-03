package repositories;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import model.Shelf;

@ApplicationScoped

public class ShelfRepository extends EntityRepository <Shelf> {

	
	
	/*public Long getAvailableShelf() {
		Collection<Shelf> t = getAllEntities(); // list of shelves (Shelf)
		Iterator<Shelf> i = t.iterator(); 	// i[a] - i[a++]
		while(i.hasNext()) {
			Shelf s = i.next();
			if (s instanceof Shelf) 
				if (s.getCapacity() > s.getNumberOfProds())
					return s.getId();
		}
		;
		return null;
	}*/

	@Override
	protected Class<Shelf> getEntityClass() {
		
		return Shelf.class;
	}

	@Override
	protected String getAllEntityQueryName() {
		
		return Shelf.GET_ALL_SHELVES_QUERY_NAME;
	}
	
	public List<Shelf> findByProductId(long id){
		return entityManager
				.createNamedQuery(Shelf.GET_SHELVES_BY_PRODUCT_ID_QUERY_NAME, Shelf.class)
				.setParameter("productId", id)
				.getResultList();
	}

	@Override
	protected String getAllEntityIdsQueryName() {

		return Shelf.GET_ALL_SHELVES_IDS;
	}
	
}

