package com.mybank.dao.impl;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mybank.dao.UserDAO;
import com.mybank.dao.dbutil.PostgresqlConnection;
import com.mybank.exception.BusinessException;
import com.mybank.model.User;

public class UserDAOImpl implements UserDAO{
	
	// import Logger to print out messages
	Logger log = Logger.getLogger(UserDAOImpl.class);

	@Override
	public int createUser(User user) throws BusinessException {
		int c = 0;
		try (Connection connection = PostgresqlConnection.getConnection()){
			
			Date dobFormat = Date.valueOf(user.getDob());
			
			String sql = "INSERT INTO bank.user(user_id, first_name, last_name, drivers_license, ssn, email, billing_address, dob, gender, password) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUserId());
			preparedStatement.setString(2, user.getFirstName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.getDriversLicense());
			preparedStatement.setInt(5, user.getSsn());
			preparedStatement.setString(6, user.getEmail());
			preparedStatement.setString(7, user.getBillingAddress());
			preparedStatement.setDate(8, dobFormat);
			preparedStatement.setString(9, user.getGender());
			preparedStatement.setString(10, user.getPassword());
			
			
			c = preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("An Internal error has occured. Double check your input for your date of birth or try another user id. If error persists, contact the system admin.");
		}

		return c;
	}

	@Override
	public List<User> getAllCustomers(String userId) throws BusinessException {
		
		List<User> customerList = new ArrayList<>();
		
		try (Connection connection = PostgresqlConnection.getConnection()){
			
			// Can't use SELECT * because I do not want to grab user's passwords
			// Do not want employee info, so use a where clause to filter it out
			String sql = "SELECT user_id, first_name, last_name, drivers_license, ssn, email, billing_address, dob, gender FROM bank.user "
					+ "WHERE user_name != ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				User customer = new User();
				customer.setUserId(resultSet.getString("user_id"));
				customer.setFirstName(resultSet.getString("first_name"));
				customer.setLastName(resultSet.getString("last_name"));
				customer.setDriversLicense(resultSet.getString("drivers_license"));
				customer.setSsn(resultSet.getInt("ssn"));
				customer.setEmail(resultSet.getString("email"));
				customer.setBillingAddress(resultSet.getString("billing_address"));
				customer.setDob(resultSet.getString("dob"));
				customer.setGender(resultSet.getString("gender"));
				customerList.add(customer);
			}
			if (customerList.size() == 0) {
				throw new BusinessException("No customers in the DB so far");
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact System Admin");
		}
		
		return customerList;
	}

	@Override
	public String loginVerify(String userId) throws BusinessException {
	
		String password = null;
		try (Connection connection = PostgresqlConnection.getConnection()){
			
			String sql = "SELECT password FROM bank.user WHERE user_id = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				
				password = resultSet.getString("password");
				
			}
			
			return password;
			
		}catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact System Admin");
		}
	}

	@Override
	public List<User> getAllUserIds() throws BusinessException {
		List<User> userList = new ArrayList<>();
		
		try (Connection connection = PostgresqlConnection.getConnection()){
			
			String sql = "SELECT user_id FROM bank.user";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setUserId(resultSet.getString("user_id"));
				userList.add(user);
			}
		}catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact System Admin");
		}
		
		return userList;
	}

}
