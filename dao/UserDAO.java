package com.niit.shoppingcart.dao;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.User;

@Repository
public interface UserDAO  {

	
	public void saveOrUpdate(User user);
	
	public void delete(User user);
	
	public User get(String id);
	
	public List<User> list();
	
	
	
	
	
	
}
