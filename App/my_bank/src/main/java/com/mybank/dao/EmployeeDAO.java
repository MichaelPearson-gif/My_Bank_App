package com.mybank.dao;

import com.mybank.exception.BusinessException;
import com.mybank.model.Employee;

public interface EmployeeDAO {

	// Create a record of new accounts
	public int createEmployee(Employee emplyee) throws BusinessException;
	
}
