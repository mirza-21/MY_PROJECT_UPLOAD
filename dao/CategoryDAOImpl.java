package com.niit.shoppingcart.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Category;


@Repository(value = "categoryDAO")
public class CategoryDAOImpl implements CategoryDAO  {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CategoryDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
					
	}
	
	@Transactional
	public void saveOrUpdate(Category category){
		System.out.println("dat");
		System.out.println(category.getId());
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		System.out.println("dat2");
		
	
	}
	
	@Transactional
	public void delete(Category category){
		
		
		sessionFactory.getCurrentSession().delete(category);
		
	}
	
	@Transactional
	public Category get(String id){
		String hql = " from Category where id = " + " ' " + id + " ' ";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) query.list();

		if (listCategory != null && !listCategory.isEmpty()) {
			return listCategory.get(0);
		}

		return null;
	}
	
	
	@Transactional
	public List<Category> list(){
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) sessionFactory.getCurrentSession().createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listCategory;
		
	}
}

