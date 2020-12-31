package com.mybank.dao;

import java.util.Date;
import java.util.List;

import com.mybank.model.Transactions;

public interface TransactionDAO {
	
	// Creates a new transaction log when customer performs a valid transaction
	public int transactionLog(Transactions transaction);
	
	// Retrieves all transaction logs for a customer account
	public List<Transactions> getAllAccountTransactions(int accountId);
	
	// Customer gets all transaction logs for a specific account and date
	public Transactions searchTransactions(int accoutId, Date date);
	
	// Retrieves every transaction log
	public List<Transactions> getAllTransactions();
}
