package com.niit.shoppingcart.dao;


import java.util.List;


import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Supplier;

@Repository
public interface SupplierDAO {
	

		
		public void saveOrUpdate(Supplier supplier);
						
		public String delete( String id);
		
		public Supplier get(String id);
		
		public List<Supplier> list();
		
		public Supplier getByName(String name);

}
