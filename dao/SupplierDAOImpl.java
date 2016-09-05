package com.niit.shoppingcart.dao;


import java.util.List;

import javax.transaction.Transactional;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Supplier;


@Repository
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	@Transactional
	public void  saveOrUpdate(Supplier supplier) {
		System.out.println("s1");
		System.out.println(supplier.getId());
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		System.out.println("s2");
		

	}

	@Transactional
	public void delete(Supplier supplier) {
		
			sessionFactory.getCurrentSession().delete(supplier);
		
		

	}

	@Transactional
	public Supplier get(String id) {

		String hql = " from Supplier where id = " + " ' " + id + " ' ";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Supplier> list = (List<Supplier>) query.list();

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		
		return null;

	}
	
	@Transactional
	public List<Supplier> list() {

		String hql = "from Supplier";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Supplier> listSupplier = (List<Supplier>) query.list();

		return listSupplier;

	}

		

}
