package com.mybank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mybank.dao.EmployeeDAO;
import com.mybank.dao.dbutil.PostgresqlConnection;
import com.mybank.exception.BusinessException;
import com.mybank.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public int createEmployee(Employee employee) throws BusinessException {
		int c = 0;
		
		try (Connection connection = PostgresqlConnection.getConnection()){
			
			String sql = "INSERT INTO bank.employee(employee_id, account_id) VALUES(?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, employee.getEmployeeId());
			preparedStatement.setInt(2, employee.getAccountId());
			
			c = preparedStatement.executeUpdate();
			
		}catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact System Admin");
		}
		
		return c;
	}

}
