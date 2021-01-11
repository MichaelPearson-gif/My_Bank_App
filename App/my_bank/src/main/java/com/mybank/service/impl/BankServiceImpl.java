package com.mybank.service.impl;

import java.util.ArrayList;
import java.util.List;

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

	// Need to test method
	@Override
	public int createUser(User user) throws BusinessException {
		int c = 0;
		
		// Gets a list of user id's in the DB
		List<User> userList = new ArrayList<>();
		userList = userDAO.getAllUserIds();
		
		// Create a variable to store the user's input id
		String inputId = user.getUserId();
		
		// Iterate through the list to check if the user input id is exists in the DB
		for (User u : userList) {
			if(inputId.equals(u) == false) {
				
				c = userDAO.createUser(user);
				
			}else {
				throw new BusinessException("Sorry the user id " + inputId + " already exists. Please try a different user id.");
			}
		}
		
		return c;
	}

	@Override
	public List<User> getAllCustomers(String userId) throws BusinessException {
		
		List<User> customerList = null;
		customerList = userDAO.getAllCustomers(userId);
		return customerList;
	}

	@Override
	public String loginVerify(String userId, String password) throws BusinessException {
		// Verify that the userId is in the DB. Similar checking system to the createUser method
		String id = null;
		User user = new User();
		
		// Gets a list of user id's in the DB
		List<User> userList = new ArrayList<>();
		userList = userDAO.getAllUserIds();
		
		// Create a variable to store the user's input id
		String inputId = user.getUserId();
		
		// Iterate through the list to check if the user input id is exists in the DB
		for (User u : userList) {
			if(inputId.equals(u) == true) {
				
				id = userDAO.loginVerify(userId, password);
				
			}else {
				throw new BusinessException("Sorry the user id " + inputId + " does not exists. Please try a different user id.");
			}
		}
		
		return id;
	}

	// Don't need to verify anything since accounts won't be created until an employee approves it
	@Override
	public int createAccount(Accounts account) throws BusinessException {
		
		int c = 0;
		c = accountsDAO.createAccount(account);
		return c;
	}

	@Override
	public double customerTransaction(int accountId, double balance) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
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
		
		// Get a list of all account id's
		List<Accounts> accountIdList = new ArrayList<>();
		accountIdList = accountsDAO.getAllAccountIds();
		
		Integer userInput = accountId;
		
		// Iterate the list to find a matching account id
		for (Accounts a : accountIdList) {
			if(userInput.equals(a) == true) {
				
				account = accountsDAO.searchAccount(accountId);
			}else {
				throw new BusinessException("Could not find an account with the id " + accountId + ". Double check that you are inputting the correct account id.");
			}
		}
		
		return account;
	}

	@Override
	public double searchBalance(int accountId) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Accounts> getAllAccounts() throws BusinessException {
		
		List<Accounts> accountList = null;
		accountList = accountsDAO.getAllAccounts();
		return accountList;
	}

	@Override
	public int transactionLog(Transactions transaction) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int statusUpdate(int transactionId, String answer) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Transactions> getAllAccountTransactions(int accountId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transactions> searchTransactions(int accountId, String date) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transactions> getAllTransactions() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transactions> employeePendingTransactions() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transactions> pendingTransferTransactions(int accountId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
