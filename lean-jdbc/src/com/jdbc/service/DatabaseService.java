package com.jdbc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.model.Employee;
import com.jdbc.util.DatabaseUtil;
import com.jdbc.util.QueryUtil;

public class DatabaseService {

	DatabaseUtil databaseUtil = new DatabaseUtil();

	public void insertEmployee(Employee employee) throws SQLException {

		try (Connection connection = databaseUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.insertEmployeeQuery());) {
			preparedStatement.setString(1, employee.getEmployeeName()); // takes parameter at runtime
			preparedStatement.setString(2, employee.getEmployeeAddress());
			preparedStatement.setDouble(3, employee.getEmployeeSalary());
			int row = preparedStatement.executeUpdate();

			if (row > 0) {
				System.out.println(row + " Record Inserted Successfully");
			} else {
				System.out.println("Record Insertion failed.....");
			}
		}

	}// End of insertEmployee()

	public void getAllEmployee() throws SQLException {

		try (Connection connection = databaseUtil.getConnection();
				Statement statement = connection.createStatement(); // Doesn't take parameter at runtime
				ResultSet resultSet = statement.executeQuery(QueryUtil.getAllEmployeeQuery());) {

			while (resultSet.next()) {

				printEmployee(new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getDouble(4)));
				// 1,2,3,4 are column number

			} // It checks is any data is there or not on next line. If Yes, then it will move
				// cursor to next line

		}

	}// End of getAllEmployee()

	private void printEmployee(Employee employee) {
		System.out.println("Employee Id : " + employee.getEmployeeId());
		System.out.println("Employee Name : " + employee.getEmployeeName());
		System.out.println("Employee Address : " + employee.getEmployeeAddress());
		System.out.println("Employee Salary : " + employee.getEmployeeSalary());
		System.out.println("--------------------------");
	}

	public boolean getEmployeeById(int employeeId) throws SQLException {

		boolean isFound = false;

		try (Connection connection = databaseUtil.getConnection();
				Statement statement = connection.createStatement(); // Doesn't take parameter at runtime
				ResultSet resultSet = statement.executeQuery(QueryUtil.getEmployeeByIdQuery(employeeId));) {

			if (resultSet.next()) {
				isFound = true;
				printEmployee(new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getDouble(4)));
			} else {
				System.out.println("Record Not Found for ID : " + employeeId);
			}

		}

		return isFound;

	}// End of getEmployeeBy Id()

	public void deleteEmployeeById(int employeeId) throws SQLException {
		try (Connection connection = databaseUtil.getConnection();
				Statement statement = connection.createStatement();) {

			int row = statement.executeUpdate(QueryUtil.deleteEmployeeByIdQuery(employeeId));

			if (row > 0) {
				System.out.println("Record Deleted Successfully");
			} else {
				System.out.println("Something Went wrong");
			}
		}
	}

	public Employee getEmployeeObjectById(int employeeId) throws SQLException {

		try (Connection connection = databaseUtil.getConnection();
				Statement statement = connection.createStatement(); // Doesn't take parameter at runtime
				ResultSet resultSet = statement.executeQuery(QueryUtil.getEmployeeByIdQuery(employeeId));) {

			resultSet.next();

			return new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getDouble(4));

		}
	} // End of getEmployeeObjectById()

	public void updateEmployee(Employee updateEmployee) throws SQLException {

		try (Connection connection = databaseUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.updateEmployeeQuery(updateEmployee.getEmployeeId()));) {
			preparedStatement.setString(1, updateEmployee.getEmployeeName()); // takes parameter at runtime
			preparedStatement.setString(2, updateEmployee.getEmployeeAddress());
			preparedStatement.setDouble(3, updateEmployee.getEmployeeSalary());
			int row = preparedStatement.executeUpdate();

			if (row > 0) {
				System.out.println(row + " Record Updated Successfully");
			} else {
				System.out.println("Failed to Update Records.....");
			}
		}

	}

}
