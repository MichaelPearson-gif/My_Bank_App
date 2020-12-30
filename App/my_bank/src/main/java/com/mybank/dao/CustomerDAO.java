package com.mybank.dao;

import java.util.Date;
import java.util.List;

import com.mybank.model.Accounts;
import com.mybank.model.Customer;
import com.mybank.model.Login;
import com.mybank.model.Transactions;

public interface CustomerDAO {

	// Creates a new customer
	public int createCustomer(Customer customer);
	// Updates customer info
	public Customer updateCustomer(int customerId);
	// Customer creates a new account with initial deposit. (Waits for employee approval)
	public int createAccount(Accounts account);
	// Updates customer's account balance based on transaction (May create a Functional Interface for the multi-purpose function)
	public double customerTransaction(double balance);
	// Customer views all accounts they have
	public List<Accounts> getCustomerAccounts(int customerId);
	// Creates a new transaction log when customer performs a valid transaction
	public int transactionLog(Transactions transaction);
	// Retrieves all transaction logs for a customer account
	public List<Transactions> getAllAccountTransactions(int accountId);
	// Customer can accept or reject money transfers
	public void transferApproval(String answer);
	// Customer creates creates a login method
	public int createLogin(Login login);
	// Customer can update their username or password
	public Login updateLogin(int customerId);
	// Alerts the customer when their balance is below a specified amount
	public void lowBalanceAlert();
	// Alerts the customer of a withdrawal transaction that is equal to or higher than their set limit
	public void highExpenseAlert();
	// Customer searches for bank account info
	public Accounts searchAccount(int accountId);
	// Customer searches for the current balance of their account
	public double searchBalance(int accountId);
	// Customer gets all transaction logs for a specific account and date
	public Transactions searchTransactions(int accoutId, Date date);
}
