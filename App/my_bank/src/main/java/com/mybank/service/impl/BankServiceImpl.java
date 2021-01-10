package com.mybank.service.impl;

import java.util.List;

import com.mybank.exception.BusinessException;
import com.mybank.model.Accounts;
import com.mybank.model.Transactions;
import com.mybank.model.User;
import com.mybank.service.BankService;

public class BankServiceImpl implements BankService {

	@Override
	public int createUser(User user) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> getAllCustomers(String userId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String loginVerify(String username, String password) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createAccount(Accounts account) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double customerTransaction(int accountId, double balance) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Accounts> getCustomerAccounts(String userId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String lowBalanceAlert(int accountId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int highExpenseAlert(int accountId) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Accounts searchAccount(int accountId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double searchBalance(int accountId) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Accounts> getAllAccounts() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
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
