package com.mybank.dao;

import java.util.List;

import com.mybank.model.Accounts;
import com.mybank.model.Customer;
import com.mybank.model.Transactions;

public interface EmployeeDAO {

	// Employee accepts or rejects new bank account requests
	public void accountApproval(String answer);
	// Retrieves every transaction log
	public List<Transactions> getAllTransactions();
	// Gets transaction logs of a specific account
	public List<Transactions> getTransactionLog(int accountId);
	// Gets a list of customers
	public List<Customer> getAllCustomers();
	// Gets a list of all bank accounts
	public List<Accounts> getAllAccounts();
	// Gets a customer's bank account info
	public Accounts getCustomerAccount(int accountId);
	// Employee updates customer info
	public Customer employeeUpdateCustomer(int accountId);
	
}
