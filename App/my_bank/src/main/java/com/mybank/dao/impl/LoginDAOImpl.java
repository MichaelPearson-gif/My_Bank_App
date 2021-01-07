package com.mybank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mybank.dao.LoginDAO;
import com.mybank.dao.dbutil.PostgresqlConnection;
import com.mybank.exception.BusinessException;
import com.mybank.model.Login;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public int createLogin(Login login) throws BusinessException {
		int c = 0;
		
		try (Connection connection = PostgresqlConnection.getConnection()){
			
			String sql = "INSERT INTO bank.login(username, password, customer_id) VALUES(?, ?, ?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, login.getUsername());
			preparedStatement.setString(2, login.getPassword());
			preparedStatement.setInt(3, login.getCustomerId());
			
			c = preparedStatement.executeUpdate();
			
		}catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact System Admin");
		}
		
		return c;
	}

	@Override
	public int loginVerify(String username, String password) throws BusinessException {
		
		int customerId = 0;
		
		String inputUsername = username;
		String inputPassword = password;
		try (Connection connection = PostgresqlConnection.getConnection()){
			
			String sql = "SELECT customer_id, password FROM bank.login WHERE username = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, inputUsername);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				customerId = resultSet.getInt("customer_id");
				
				if (inputPassword.equals(resultSet.getString("password"))) {
					
					return customerId;
				}
				
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact System Admin");
		}
		
		return customerId;
	}

}
