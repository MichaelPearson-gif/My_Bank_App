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
	public int transactionLog(Transactions transaction) throws BusinessException {
		int c = 0;
		// Set the status as pending as a default
		transaction.setStatus("Pending");
		
		try(Connection connection = PostgresqlConnection.getConnection()){
			
			String sql = "INSERT INTO bank.transactions(nextval(transaction_sequence), account_id, transaction, amount, date, status)"
					+ "VALUES(?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, transaction.getAccountId());
			preparedStatement.setString(2, transaction.getTransaction());
			preparedStatement.setDouble(3, transaction.getAmount());
			preparedStatement.setDate(4, new java.sql.Date(transaction.getDate().getTime()));
			preparedStatement.setString(5, transaction.getStatus());
			
			c = preparedStatement.executeUpdate();
			
		}catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		
		return c;
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
				transaction.setTransaction(resultSet.getString("transaction"));
				transaction.setAmount(resultSet.getDouble("amount"));
				transaction.setDate(resultSet.getDate("date"));
				transaction.setStatus(resultSet.getString("status"));
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
				transaction.setTransaction(resultSet.getString("transaction"));
				transaction.setAmount(resultSet.getDouble("amount"));
				transaction.setDate(resultSet.getDate("date"));
				transaction.setStatus(resultSet.getString("status"));
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
				transaction.setTransaction(resultSet.getString("transaction"));
				transaction.setAmount(resultSet.getDouble("amount"));
				transaction.setDate(resultSet.getDate("date"));
				transaction.setStatus(resultSet.getString("status"));
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

	@Override
	public int statusUpdate(int transactionId, String answer) throws BusinessException {
		int c = 0;
		
		try(Connection connection = PostgresqlConnection.getConnection()){
			
			String sql = "UPDATE bank.transactions SET status = ? WHERE transaction_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, answer);
			preparedStatement.setInt(2, transactionId);
			
			c = preparedStatement.executeUpdate();
			
		}catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		
		return c;
	}

	@Override
	public List<Transactions> employeePendingTransactions() throws BusinessException {
		List<Transactions> pendingTransactionList = new ArrayList<>();
		
		try(Connection connection = PostgresqlConnection.getConnection()){
			
			String sql = "SELECT * FROM bank.transactions WHERE transaction = New Account AND status = Pending";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Transactions transaction = new Transactions();
				transaction.setTransactionId(resultSet.getInt("transaction_id"));
				transaction.setAccountId(resultSet.getInt("account_id"));
				transaction.setTransaction(resultSet.getString("transaction"));
				transaction.setAmount(resultSet.getDouble("amount"));
				transaction.setDate(resultSet.getDate("date"));
				transaction.setStatus(resultSet.getString("status"));
				pendingTransactionList.add(transaction);
			}
			if (pendingTransactionList.size() == 0) {
				throw new BusinessException("There are no pending transactions.");
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		
		return pendingTransactionList;
	}

	@Override
	public List<Transactions> pendingTransferTransactions(int accountId) throws BusinessException {
		List<Transactions> pendingTransferList = new ArrayList<>();
		
		try(Connection connection = PostgresqlConnection.getConnection()){
			
			String sql = "SELECT * FROM bank.transactions WHERE account_id = ? AND transaction = Transfer AND status = Pending";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, accountId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Transactions transaction = new Transactions();
				transaction.setTransactionId(resultSet.getInt("transaction_id"));
				transaction.setAccountId(resultSet.getInt("account_id"));
				transaction.setTransaction(resultSet.getString("transaction"));
				transaction.setAmount(resultSet.getDouble("amount"));
				transaction.setDate(resultSet.getDate("date"));
				transaction.setStatus(resultSet.getString("status"));
				pendingTransferList.add(transaction);
			}
			if (pendingTransferList.size() == 0) {
				throw new BusinessException("There are no pending transactions.");
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		
		return pendingTransferList;
	}

}
