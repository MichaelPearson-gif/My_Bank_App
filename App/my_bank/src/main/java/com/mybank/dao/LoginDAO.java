package com.mybank.dao;

import com.mybank.exception.BusinessException;
import com.mybank.model.Login;

public interface LoginDAO {
	
	// Customer creates creates a login method
	public int createLogin(Login login) throws BusinessException;
	
	// Customer can login to their account
	public int loginVerify(String username, String password) throws BusinessException;
}
