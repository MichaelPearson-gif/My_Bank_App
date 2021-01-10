package com.mybank.service;

import java.util.List;

import com.mybank.exception.BusinessException;
import com.mybank.model.Accounts;
import com.mybank.model.Transactions;
import com.mybank.model.User;

public interface BankService {

	// Creates a new user
	public int createUser(User user) throws BusinessException;
	
	// Gets a list of customers
	public List<User> getAllCustomers(String userId) throws BusinessException;
	
	// Customer can login to their account
	public String loginVerify(String username, String password) throws BusinessException;
	
	// Customer creates a new account with initial deposit. (Waiting for employee approval)
	public int createAccount(Accounts account) throws BusinessException;
	
	// Updates customer's account balance based on transaction (May create a Functional Interface for the multi-purpose function)
	public double customerTransaction(int accountId, double balance) throws BusinessException;
	
	// Customer views all accounts they have
	public List<Accounts> getCustomerAccounts(String userId) throws BusinessException;
	
	// Alerts the customer when their balance is below a specified amount
	public String lowBalanceAlert(int accountId) throws BusinessException;
	
	// Alerts the customer of a withdrawal transaction that is equal to or higher than their set limit
	public int highExpenseAlert(int accountId) throws BusinessException;
	
	// Customer searches for bank account info
	public Accounts searchAccount(int accountId) throws BusinessException;
	
	// Customer searches for the current balance of their account
	public double searchBalance(int accountId) throws BusinessException;
	
	// Gets a list of all bank accounts
	public List<Accounts> getAllAccounts() throws BusinessException;
	
	// Creates a new transaction log
	public int transactionLog(Transactions transaction) throws BusinessException;
	
	// Update the status of an account
	public int statusUpdate(int transactionId, String answer) throws BusinessException;
	
	// Retrieves all transaction logs for a customer account
	public List<Transactions> getAllAccountTransactions(int accountId) throws BusinessException;
	
	// Customer gets all transaction logs for a specific account and date
	public List<Transactions> searchTransactions(int accountId, String date) throws BusinessException;
	
	// Retrieves every transaction log
	public List<Transactions> getAllTransactions() throws BusinessException;
	
	// Retrieves all pending transaction logs for employee
	public List<Transactions> employeePendingTransactions() throws BusinessException;
	
	// Retrieves all pending transfer transaction logs for an account
	public List<Transactions> pendingTransferTransactions(int accountId) throws BusinessException;
	
}
