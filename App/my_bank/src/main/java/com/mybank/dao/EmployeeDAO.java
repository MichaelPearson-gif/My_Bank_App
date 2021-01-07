package com.mybank.dao;

import com.mybank.model.Employee;

public interface EmployeeDAO {

	// Employee accepts or rejects new bank account requests
	public int accountApproval(String answer);

	// Create a record of new accounts
	public int createEmployee(Employee emplyee);
	
}
