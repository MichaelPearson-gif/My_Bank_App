package com.mybank.dao.impl;

import java.util.List;

import com.mybank.dao.AccountsDAO;
import com.mybank.model.Accounts;

public class AccountsDAOImpl implements AccountsDAO {

	@Override
	public int createAccount(Accounts account) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double customerTransaction(double balance) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Accounts> getCustomerAccounts(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void transferApproval(String answer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void lowBalanceAlert() {
		// TODO Auto-generated method stub

	}

	@Override
	public void highExpenseAlert() {
		// TODO Auto-generated method stub

	}

	@Override
	public Accounts searchAccount(int accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double searchBalance(int accountId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Accounts> getAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

}
