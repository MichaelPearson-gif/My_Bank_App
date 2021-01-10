package com.mybank.dao;

import java.util.List;

import com.mybank.exception.BusinessException;
import com.mybank.model.User;

public interface UserDAO {

	// Creates a new user
	public int createUser(User user) throws BusinessException;
	
	// Gets a list of customers
	public List<User> getAllCustomers(String userId) throws BusinessException;
	
	// Customer can login to their account
	public String loginVerify(String username, String password) throws BusinessException;
}
