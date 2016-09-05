package com.niit.shoppingcart.dao;



import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Product;



@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	@Transactional
	public void saveOrUpdate(Product product) {
		
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			

	}

	@Transactional
	public void delete(Product product) {
		
		sessionFactory.getCurrentSession().delete(product);
		
	
	}

	@Transactional
	public Product get(String id) {

		String hql = " from Product where id = " + " ' " + id + " ' ";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Product> list = query.list();

		if (list == null) {
			return null;
		}

		else {

			return list.get(0);
		}

	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Product> list() {
		
		String hql = "from Product";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();

	}


		
}
