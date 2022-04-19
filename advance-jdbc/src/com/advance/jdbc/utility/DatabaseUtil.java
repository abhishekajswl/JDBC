package com.advance.jdbc.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	
	private static final String DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/abhidb";
	private static final String USER = "springuser";
	private static final String PASSWORD = "ThePassword";
	
	public DatabaseUtil(){
		
		try {
			//load and register the Driver path.
			Class.forName(DRIVER_PATH);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Something went wrong while load/Registering the Driver " + e);
		}
		
	}
	
	public Connection getConnection() throws SQLException{
		// get the connection
		return DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
		
	}

}
