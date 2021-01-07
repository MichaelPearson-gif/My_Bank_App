package com.mybank.dao;

import java.util.List;

import com.mybank.exception.BusinessException;
import com.mybank.model.Accounts;

public interface AccountsDAO {
	
	// Customer creates a new account with initial deposit. (Waits for employee approval)
	public int createAccount(Accounts account) throws BusinessException;
	
	// Updates customer's account balance based on transaction (May create a Functional Interface for the multi-purpose function)
	public double customerTransaction(double balance);
	
	// Customer views all accounts they have
	public List<Accounts> getCustomerAccounts(int customerId);
	
	// Customer can accept or reject money transfers
	public void transferApproval(String answer);
	
	// Alerts the customer when their balance is below a specified amount
	public void lowBalanceAlert();
	
	// Alerts the customer of a withdrawal transaction that is equal to or higher than their set limit
	public void highExpenseAlert();
	
	// Customer searches for bank account info
	public Accounts searchAccount(int accountId);
	
	// Customer searches for the current balance of their account
	public double searchBalance(int accountId) throws BusinessException;
	
	// Gets a list of all bank accounts
	public List<Accounts> getAllAccounts() throws BusinessException;
}
