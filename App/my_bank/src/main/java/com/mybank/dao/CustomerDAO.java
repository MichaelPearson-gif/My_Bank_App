package com.mybank.dao;

import java.util.List;

import com.mybank.model.Customer;

public interface CustomerDAO {

	// Creates a new customer
	public int createCustomer(Customer customer);
	
	// Updates customer info
	public Customer updateCustomer(int customerId);
	
	// Gets a list of customers
	public List<Customer> getAllCustomers();
}
