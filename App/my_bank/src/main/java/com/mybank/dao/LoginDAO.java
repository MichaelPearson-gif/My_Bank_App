package com.mybank.dao;

import com.mybank.exception.BusinessException;
import com.mybank.model.Login;

public interface LoginDAO {
	
	// Customer creates creates a login method
	public int createLogin(Login login) throws BusinessException;
	
	// Customer can update their username or password
	public Login updateLogin(int customerId);
}
