package com.mybank.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mybank.dao.UserDAO;
import com.mybank.dao.dbutil.PostgresqlConnection;
import com.mybank.exception.BusinessException;
import com.mybank.model.User;

public class UserDAOImpl implements UserDAO{

	@Override
	public int createUser(User user) throws BusinessException {
		int c = 0;
		try (Connection connection = PostgresqlConnection.getConnection()){
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			String dob = sdf.format(user.getDob());
			Date dobFormat = Date.valueOf(dob);
			
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
			throw new BusinessException("Internal error occured contact System Admin");
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
				customer.setDob(resultSet.getDate("dob"));
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
	public String loginVerify(String userId, String password) throws BusinessException {
		
		String id = null;
	
		String inputPassword = password;
		try (Connection connection = PostgresqlConnection.getConnection()){
			
			String sql = "SELECT password FROM bank.user WHERE user_id = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				id = resultSet.getString("user_id");
				
				if (inputPassword.equals(resultSet.getString("password"))) {
					
					return id;
				}
				
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact System Admin");
		}
		
		return id;
	}

}
