package com.mybank.dao.impl;

import java.util.Date;
import java.util.List;

import com.mybank.dao.TransactionDAO;
import com.mybank.model.Transactions;

public class TransactionDAOImpl implements TransactionDAO {

	@Override
	public int transactionLog(Transactions transaction) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Transactions> getAllAccountTransactions(int accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transactions searchTransactions(int accoutId, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transactions> getAllTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

}
