package repositories;

import javax.enterprise.context.ApplicationScoped;
import model.Product;

@ApplicationScoped
public class ProductRepository extends EntityRepository <Product> {
	
	
	
	/************************************************
	@Override
	protected Class<Product> getEntityClass(){
		
		return Product.class;
	}

	@Override
	protected String getAllEntityQueryName() {
		return Product.GET_ALL_PRODUCTS_QUERY_NAME;
	}
	*************************************************/
	
	
	
	
	/*public ArrayList<Product> getProductsInShlefID(int shelfId){
		Collection<Product> t = getAllEntities(); // list of shelves (Shelf)
		Iterator<Product> i = t.iterator(); 	// i[a] - i[a++]
		ArrayList<Product> prods = new ArrayList<Product>();
		while(i.hasNext()) {
			Product p = i.next();
			if (p.getListOfShelves().contains(shelfId))
				prods.add(p);
		}
		return prods;
	}
*/
	@Override
	protected Class<Product> getEntityClass() {
		// TODO Auto-generated method stub
		return Product.class;
	}

	@Override
	protected String getAllEntityQueryName() {
		return Product.GET_ALL_PRODUCTS_QUERY_NAME;
	}

	@Override
	protected String getAllEntityIdsQueryName() {
		// TODO Auto-generated method stub
		return Product.GET_ALL_PRODUCTS_IDS;
	}
}
