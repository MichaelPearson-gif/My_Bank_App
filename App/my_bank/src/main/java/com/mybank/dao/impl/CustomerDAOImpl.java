package com.mybank.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mybank.dao.CustomerDAO;
import com.mybank.dao.dbutil.PostgresqlConnection;
import com.mybank.exception.BusinessException;
import com.mybank.model.Customer;

public class CustomerDAOImpl implements CustomerDAO{

	@Override
	public int createCustomer(Customer customer) throws BusinessException {
		int c = 0;
		try (Connection connection = PostgresqlConnection.getConnection()){
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			String dob = sdf.format(customer.getDob());
			Date dobFormat = Date.valueOf(dob);
			
			String sql = "INSERT INTO bank.customer(nextval(customer_sequence), first_name, last_name, drivers_license, ssn, email, physical_address, mailing_address, dob, gender) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getLastName());
			preparedStatement.setString(3, customer.getDriversLicense());
			preparedStatement.setString(4, customer.getSsn());
			preparedStatement.setString(5, customer.getEmail());
			preparedStatement.setString(6, customer.getPhysicalAddress());
			preparedStatement.setString(7, customer.getMailAddress());
			preparedStatement.setDate(8, dobFormat);
			preparedStatement.setString(9, customer.getGender());
			
			c = preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact System Admin");
		}

		return c;
	}

	@Override
	public Customer updateCustomer(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() throws BusinessException {
		
		List<Customer> customerList = new ArrayList<>();
		
		try (Connection connection = PostgresqlConnection.getConnection()){
			
			String sql = "SELECT * FROM bank.customer";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(resultSet.getInt("customer_id"));
				customer.setFirstName(resultSet.getString("first_name"));
				customer.setLastName(resultSet.getString("last_name"));
				customer.setDriversLicense(resultSet.getString("drivers_license"));
				customer.setSsn(resultSet.getString("ssn"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPhysicalAddress(resultSet.getString("physical_address"));
				customer.setMailAddress(resultSet.getString("mailing_address"));
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

}
