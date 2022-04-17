package com.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	
	private static final String DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
	
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/abhidb";
	private static final String USERNAME = "springuser";
	private static final String PASSWORD = "ThePassword";
	
	public DatabaseUtil() {
		try {
			//Load and register the Driver
			Class.forName(DRIVER_PATH);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Something went wrong while connecting to MySQL" + e);
		}
	}//End of Constructor
	
	public Connection getConnection() throws SQLException {
		
		//get the connection
		return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	}
	
	

}
