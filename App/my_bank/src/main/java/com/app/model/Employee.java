package com.app.model;

public class Employee {

	private int employeeId;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Employee(int employeeId) {
		super();
		this.employeeId = employeeId;
	}


	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + "]";
	}
	
	
}
