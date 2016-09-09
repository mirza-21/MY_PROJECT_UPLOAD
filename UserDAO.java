package com.niit.shoppingcart.dao;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.User;

@Repository
public interface UserDAO  {

	
	public void saveOrUpdate(User user);
	
	public void delete(String id);
	
	public User get(String id);
		
	public boolean isValidUser(String id, String name);
	
	public String getUsername (String id);
	
	public List<User> list();

	
	
	
	
	
	
	
}
