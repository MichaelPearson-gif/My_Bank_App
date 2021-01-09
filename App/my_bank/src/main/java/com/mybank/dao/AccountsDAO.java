package com.mybank.dao;

import java.util.List;

import com.mybank.exception.BusinessException;
import com.mybank.model.Accounts;

public interface AccountsDAO {
	
	// Customer creates a new account with initial deposit. (Waiting for employee approval)
	public int createAccount(Accounts account) throws BusinessException;
	
	// Updates customer's account balance based on transaction (May create a Functional Interface for the multi-purpose function)
	public double customerTransaction(double balance);
	
	// Customer views all accounts they have
	public List<Accounts> getCustomerAccounts(int customerId) throws BusinessException;
	
	// Alerts the customer when their balance is below a specified amount
	public String lowBalanceAlert(int accountId) throws BusinessException;
	
	// Alerts the customer of a withdrawal transaction that is equal to or higher than their set limit
	public void highExpenseAlert();
	
	// Customer searches for bank account info
	public Accounts searchAccount(int accountId) throws BusinessException;
	
	// Customer searches for the current balance of their account
	public double searchBalance(int accountId) throws BusinessException;
	
	// Gets a list of all bank accounts
	public List<Accounts> getAllAccounts() throws BusinessException;
}
