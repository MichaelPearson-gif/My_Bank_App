package com.mybank.dao;

public interface EmployeeDAO {

	// Employee accepts or rejects new bank account requests
	public void accountApproval(String answer);

	// Employee updates customer info
	public int employeeUpdateCustomer(int accountId);
	
}
