package com.mybank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
			
			String sql = "INSERT INTO bank.customer(first_name, last_name, drivers_license, ssn, email, physical_address, mailing_address, dob, gender, credit_score) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
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
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

}
