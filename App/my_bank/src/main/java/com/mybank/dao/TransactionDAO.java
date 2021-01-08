package com.mybank.dao;

import java.util.Date;
import java.util.List;

import com.mybank.exception.BusinessException;
import com.mybank.model.Transactions;

public interface TransactionDAO {
	
	// Creates a new transaction log when customer performs a valid transaction
	public int transactionLog(Transactions transaction);
	
	// Retrieves all transaction logs for a customer account
	public List<Transactions> getAllAccountTransactions(int accountId) throws BusinessException;
	
	// Customer gets all transaction logs for a specific account and date
	public List<Transactions> searchTransactions(int accountId, String date) throws BusinessException;
	
	// Retrieves every transaction log
	public List<Transactions> getAllTransactions() throws BusinessException;
}
