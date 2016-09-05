package com.niit.shoppingcart.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.User;

@Repository(value = "userdetailsDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	@Transactional
	public void saveOrUpdate(User user) {

		sessionFactory.getCurrentSession().saveOrUpdate(user);

	}

	@Transactional
	public void delete(User user) {
		
		sessionFactory.getCurrentSession().delete(user);

	}

	@Transactional
	public User get(String id) {

		String hql = " from User where id = " + " ' " + id + " ' ";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<User> list = query.list();

		if (list == null) {
			return null;
		}

		else {

			return list.get(0);
		}

	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<User> list() {

		String hql = "from User";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		return query.list();

	}

}
