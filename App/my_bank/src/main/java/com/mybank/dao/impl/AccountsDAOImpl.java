package com.mybank.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mybank.dao.AccountsDAO;
import com.mybank.dao.dbutil.PostgresqlConnection;
import com.mybank.exception.BusinessException;
import com.mybank.model.Accounts;

public class AccountsDAOImpl implements AccountsDAO {

	@Override
	public int createAccount(Accounts account) throws BusinessException {
		int c = 0;
		try (Connection connection = PostgresqlConnection.getConnection()){
			
			String sql = "INSERT INTO bank.accounts "
					+ "VALUES(nextval(account_sequence), ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, account.getAccountType());
			preparedStatement.setDouble(2, account.getBalance());
			preparedStatement.setInt(3, account.getLowBalanceAlert());
			preparedStatement.setInt(4, account.getExpenseAlert());
			preparedStatement.setString(5, account.getUserId());
			
			c = preparedStatement.executeUpdate();
			
		}catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact System Admin");
		}
		return c;
	}

	@Override
	public int customerTransaction(int accountId, double balance) throws BusinessException {
		int c = 0;
		
		try (Connection connection = PostgresqlConnection.getConnection()){
			
			String sql = "UPDATE bank.accounts SET balance = ? WHERE account_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1, balance);
			preparedStatement.setInt(2, accountId);
			
			c = preparedStatement.executeUpdate();
			
		}catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact System Admin");
		}
		
		return c;
	}

	@Override
	public List<Accounts> getCustomerAccounts(String userId) throws BusinessException {
		List<Accounts> customerAccountList = new ArrayList<>();
		
		try (Connection connection = PostgresqlConnection.getConnection()){
			
			String sql = "SELECT * FROM bank.accounts WHERE user_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Accounts account = new Accounts();
				account.setAccountId(resultSet.getInt("account_id"));
				account.setAccountType(resultSet.getString("account_type"));
				account.setBalance(resultSet.getDouble("balance"));
				account.setLowBalanceAlert(resultSet.getInt("low_balance_alert"));
				account.setExpenseAlert(resultSet.getInt("expense_alert"));
				account.setUserId(userId);
				customerAccountList.add(account);
			}
			if (customerAccountList.size() == 0) {
				System.out.println("There are no bank accounts associated with the customer of id " + userId);
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact System Admin");
		}
		
		return customerAccountList;
	}

	@Override
	public String lowBalanceAlert(int accountId) throws BusinessException {
		String message = null;
		
		try (Connection connection = PostgresqlConnection.getConnection()){
			
			String sql = "SELECT balance, low_balance_alert FROM bank.accounts WHERE account_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, accountId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				
				// Variables to store the results of the query
				double balance = resultSet.getDouble("balance");
				int alert = resultSet.getInt("low_balance_alert");
				
				// Check to see if the account balance is below the set amount for the alert
				if (balance < alert) {
					message = "Your account balance is below your set amount of $" + alert;
				}
				
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact System Admin");
		}
		
		return message;
	}

	@Override
	public int highExpenseAlert(int accountId) throws BusinessException {
		int c = 0;
		
		try (Connection connection = PostgresqlConnection.getConnection()){
			
			String sql = "SELECT expense_alert FROM bank.accounts WHERE account_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, accountId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			c = resultSet.getInt("expense_alert");
			
		}catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact System Admin");
		}
		
		return c;
		}

	@Override
	public Accounts searchAccount(int accountId) throws BusinessException {
		Accounts account = null;
		
		try (Connection connection = PostgresqlConnection.getConnection()){
			String sql = "SELECT * FROM bank.accounts WHERE account_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, accountId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				account = new Accounts();
				account.setAccountId(accountId);
				account.setAccountType(resultSet.getString("account_type"));
				account.setBalance(resultSet.getDouble("balance"));
				account.setLowBalanceAlert(resultSet.getInt("low_balance_alert"));
				account.setExpenseAlert(resultSet.getInt("expense_alert"));
				account.setUserId(resultSet.getString("user_id"));
				
			}else {
				throw new BusinessException("No bank account with account id: " + accountId);
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact System Admin");
		}
		
		return account;
	}

	@Override
	public double searchBalance(int accountId) throws BusinessException {
		double balance = 0;
		
		try (Connection connection = PostgresqlConnection.getConnection()){
			String sql = "SELECT balance FROM bank.accounts WHERE account_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, accountId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				balance = resultSet.getDouble("balance");
			}else {
				throw new BusinessException("No bank account balance with account id: " + accountId);
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact System Admin");
		}
		
		return balance;
	}

	@Override
	public List<Accounts> getAllAccounts() throws BusinessException {
		
		List<Accounts> accountList = new ArrayList<>();
		
		try (Connection connection = PostgresqlConnection.getConnection()){
			
			String sql = "SELECT * FROM bank.accounts";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Accounts account = new Accounts();
				account.setAccountId(resultSet.getInt("account_id"));
				account.setAccountType(resultSet.getString("account_type"));
				account.setBalance(resultSet.getDouble("balance"));
				account.setLowBalanceAlert(resultSet.getInt("low_balance_alert"));
				account.setExpenseAlert(resultSet.getInt("expense_alert"));
				account.setUserId(resultSet.getString("user_id"));
			}
			if (accountList.size() == 0) {
				throw new BusinessException("No bank accounts in the DB so far");
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact System Admin");
		}
		
		return accountList;
	}

	@Override
	public List<Accounts> getAllAccountIds() throws BusinessException {
		List<Accounts> accountIdList = new ArrayList<>();
		
		try (Connection connection = PostgresqlConnection.getConnection()){
			
			String sql = "SELECT account_id FROM bank.accounts";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Accounts account = new Accounts();
				account.setUserId(resultSet.getString("account_id"));
				accountIdList.add(account);
			}
			if (accountIdList.size() == 0) {
				throw new BusinessException("No bank accounts in the DB so far");
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact System Admin");
		}
		
		
		return accountIdList;
	}


}
