package com.mybank.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mybank.dao.AccountsDAO;
import com.mybank.dao.TransactionDAO;
import com.mybank.dao.UserDAO;
import com.mybank.dao.impl.AccountsDAOImpl;
import com.mybank.dao.impl.TransactionDAOImpl;
import com.mybank.dao.impl.UserDAOImpl;
import com.mybank.exception.BusinessException;
import com.mybank.model.Accounts;
import com.mybank.model.Transactions;
import com.mybank.model.User;
import com.mybank.service.BankService;

public class BankServiceImpl implements BankService {
	
	// Most methods won't need validating conditions, as they will already be validated by successfully logged into an account
	// Transaction methods will most likely need to verify that the user inputs are valid arguments
	
	// Creating an instance of each DAO layer
	private UserDAO userDAO = new UserDAOImpl();
	private AccountsDAO accountsDAO = new AccountsDAOImpl();
	private TransactionDAO transactionDAO = new TransactionDAOImpl();
	
	// Import Logger
	Logger log = Logger.getLogger(BankServiceImpl.class);

	// Need to test method
	@Override
	public int createUser(User user) throws BusinessException {
		int c = 0;
		
		 c = userDAO.createUser(user);
		
		return c;
	}

	@Override
	public List<User> getAllCustomers(String userId) throws BusinessException {
		
		List<User> customerList = null;
		customerList = userDAO.getAllCustomers(userId);
		return customerList;
	}

	@Override
	public boolean loginVerify(String userId, String password) throws BusinessException {
		boolean b = false;
		
		// Verify the password
		String storedPassword = userDAO.loginVerify(userId);
		
		if(password.equals(storedPassword)) {
			b = true;
		}

		return b;
	}

	// Make sure that user inputs a balance value greater than 0
	@Override
	public int createAccount(Accounts account) throws BusinessException {
		
		int c = 0;
		if (account.getBalance() > 0) {
			c = accountsDAO.createAccount(account);
		}else {
			throw new BusinessException("Initial deposits can not be 0 or negative");
		}
		return c;
	}

	@Override
	public int customerTransaction(int accountId, double balance) throws BusinessException {
		int c = 0;
		c = accountsDAO.customerTransaction(accountId, balance);
		return c;
	}

	@Override
	public List<Accounts> getCustomerAccounts(String userId) throws BusinessException {
		
		List<Accounts> customerAccountList = null;
		customerAccountList = accountsDAO.getCustomerAccounts(userId);
		return customerAccountList;
	}

	@Override
	public String lowBalanceAlert(int accountId) throws BusinessException {
		
		String message = null;
		message = accountsDAO.lowBalanceAlert(accountId);
		return message;
	}

	@Override
	public int highExpenseAlert(int accountId) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Accounts searchAccount(int accountId) throws BusinessException {
		
		Accounts account = null;
		account = accountsDAO.searchAccount(accountId);
		return account;
	}

	@Override
	public double searchBalance(int accountId) throws BusinessException {
		
		double balance = 0;
		balance = accountsDAO.searchBalance(accountId);
		return balance;
	}

	@Override
	public List<Accounts> getAllAccounts() throws BusinessException {
		
		List<Accounts> accountList = null;
		accountList = accountsDAO.getAllAccounts();
		return accountList;
	}

	@Override
	public int transactionLog(Transactions transaction) throws BusinessException {
		
		int c = 0;
		c = transactionDAO.transactionLog(transaction);
		return c;
	}

	@Override
	public int statusUpdate(int transactionId, String answer) throws BusinessException {
		int c = 0;
		c = transactionDAO.statusUpdate(transactionId, answer);
		return c;
	}

	@Override
	public List<Transactions> getAllAccountTransactions(int accountId) throws BusinessException {
		
		List<Transactions> accountTransactionList = null;
		accountTransactionList = transactionDAO.getAllAccountTransactions(accountId);
		return accountTransactionList;
	}

	@Override
	public List<Transactions> searchTransactions(int accountId, String date) throws BusinessException {
		
		List<Transactions> dateTransactionList = null;
		dateTransactionList = transactionDAO.searchTransactions(accountId, date);
		return dateTransactionList;
	}

	@Override
	public List<Transactions> getAllTransactions() throws BusinessException {
		
		List<Transactions> allTransactionList = null;
		allTransactionList = transactionDAO.getAllTransactions();
		return allTransactionList;
	}

	@Override
	public List<Transactions> employeePendingTransactions() throws BusinessException {
		
		List<Transactions> pendingTransactionList = null;
		pendingTransactionList = transactionDAO.employeePendingTransactions();
		return pendingTransactionList;
	}

	@Override
	public List<Transactions> pendingTransferTransactions(int accountId) throws BusinessException {
		
		List<Transactions> pendingTransferList = null;
		pendingTransferList = transactionDAO.pendingTransferTransactions(accountId);
		return pendingTransferList;
	}

	@Override
	public double accountWithdraw(int accountId, double amount) throws BusinessException {
		// Retrieve the current balance of the account and set it as a variable
		double balance = accountsDAO.searchBalance(accountId);
		
		// Check to see if the user's inputed amount is a positive number
		if (amount > 0) {
			
			// Now check to see if the balance - amount is negative
			if (balance - amount >= 0) {
				
				// Set balance equal to the new balance 
				balance = balance - amount;
				
			}else {
				// If the condition balance - amount failed, throw a new BusinessException
				throw new BusinessException("Your balance can not be negative after withdrawing from it");
			}
			
		}else {
			// If the amount > 0 failed, throw a new BusinessException
			throw new BusinessException("The withdraw amount can not be negative");
		}
		
		return balance;
	}

	@Override
	public double accountDeposit(int accountId, double amount) throws BusinessException {
		// Retrieve the current balance of the account and set it as a variable
		double balance = accountsDAO.searchBalance(accountId);
		
		// Check to see if user's inputed amount is a positive number
		if (amount > 0) {
			
			// Set balance equal to the new balance
			balance = balance + amount;
			
		}else {
			// If user inputed amount was a negative number throw a BusinessException 
			throw new BusinessException("The deposit amount can not be negative");
		}
		
		return balance;
	}

	@Override
	public String getTransactionStatus(int transactionId) throws BusinessException {
		String status = null;
		status = transactionDAO.getTransactionStatus(transactionId);
		return status;
	}

}
