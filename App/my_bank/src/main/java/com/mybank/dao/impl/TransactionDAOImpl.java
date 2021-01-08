package com.mybank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.mybank.dao.TransactionDAO;
import com.mybank.dao.dbutil.PostgresqlConnection;
import com.mybank.exception.BusinessException;
import com.mybank.model.Transactions;

public class TransactionDAOImpl implements TransactionDAO {

	@Override
	public int transactionLog(Transactions transaction) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Transactions> getAllAccountTransactions(int accountId) throws BusinessException {
		List<Transactions> accountTransactionList = new ArrayList<>();
		
		try(Connection connection = PostgresqlConnection.getConnection()){
			
			String sql = "SELECT * FROM bank.transactions WHERE account_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, accountId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Transactions transaction = new Transactions();
				transaction.setTransactionId(resultSet.getInt("transaction_id"));
				transaction.setAccountId(resultSet.getInt("account_id"));
				transaction.setCustomerId(resultSet.getInt("customer_id"));
				transaction.setTransaction(resultSet.getString("transaction"));
				transaction.setAmount(resultSet.getDouble("amount"));
				transaction.setBalance(resultSet.getDouble("balance"));
				transaction.setDate(resultSet.getDate("date"));
				accountTransactionList.add(transaction);
			}
			if (accountTransactionList.size() == 0) {
				throw new BusinessException("No transactions have occured for this bank account yet.");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		
		return accountTransactionList;
	}

	@Override
	public List<Transactions> searchTransactions(int accountId, String date) throws BusinessException {
		List<Transactions> dateTransactionList = new ArrayList<>();
		
		try(Connection connection = PostgresqlConnection.getConnection()){
			// Convert string to sql date type
			Date dateConvert = Date.valueOf(date);
			
			// Query the DB
			String sql = "SELECT * FROM bank.transactions WHERE account_id = ? AND date = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, accountId);
			preparedStatement.setDate(1, dateConvert);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Transactions transaction = new Transactions();
				transaction.setTransactionId(resultSet.getInt("transaction_id"));
				transaction.setAccountId(resultSet.getInt("account_id"));
				transaction.setCustomerId(resultSet.getInt("customer_id"));
				transaction.setTransaction(resultSet.getString("transaction"));
				transaction.setAmount(resultSet.getDouble("amount"));
				transaction.setBalance(resultSet.getDouble("balance"));
				transaction.setDate(resultSet.getDate("date"));
				dateTransactionList.add(transaction);
			}
			if (dateTransactionList.size() == 0) {
				throw new BusinessException("There are no transactions for account # " + accountId + " on " + dateConvert);
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		
		return dateTransactionList;
	}

	@Override
	public List<Transactions> getAllTransactions() throws BusinessException {
		List<Transactions> allTransactionList = new ArrayList<>();
		
		try(Connection connection = PostgresqlConnection.getConnection()){
			
			String sql = "SELECT * FROM bank.transactions";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Transactions transaction = new Transactions();
				transaction.setTransactionId(resultSet.getInt("transaction_id"));
				transaction.setAccountId(resultSet.getInt("account_id"));
				transaction.setCustomerId(resultSet.getInt("customer_id"));
				transaction.setTransaction(resultSet.getString("transaction"));
				transaction.setAmount(resultSet.getDouble("amount"));
				transaction.setBalance(resultSet.getDouble("balance"));
				transaction.setDate(resultSet.getDate("date"));
				allTransactionList.add(transaction);
			}
			if (allTransactionList.size() == 0) {
				throw new BusinessException("No transactions have occured and been logged yet.");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		
		return allTransactionList;
	}

}
