package com.mybank.dao;

import com.mybank.model.Login;

public interface LoginDAO {
	
	// Customer creates creates a login method
	public int createLogin(Login login);
	
	// Customer can update their username or password
	public Login updateLogin(int customerId);
}
