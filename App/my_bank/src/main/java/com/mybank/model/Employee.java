package com.mybank.model;

public class Employee {

	// Because this is the first version of the app, there is only 1 employee
	// Thus in the DB the employee id is not the primary key
	// Henceforth each record in the employee table will have the same value
	// So employee id will be set to a default value
	private int employeeId = 1;
	private int accountId;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int employeeId, int accountId) {
		super();
		this.employeeId = employeeId;
		this.accountId = accountId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", accountId=" + accountId + "]";
	}
	
}
