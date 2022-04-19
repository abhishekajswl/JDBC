package com.advance.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.advance.jdbc.model.Actor;
import com.advance.jdbc.model.Movie;
import com.advance.jdbc.utility.DatabaseUtil;
import com.advance.jdbc.utility.QueryUtil;

public class DatabaseDao {
	
	//database accessing logic should be here like preparedstatement
	
	DatabaseUtil databaseUtil = new DatabaseUtil();
	
	//1. List all the movies done by a particular actor.
	public List<Movie> getCase1(int actorId) throws SQLException{
		
		List<Movie> movieList = new ArrayList<>();
		
		try(Connection connection = databaseUtil.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getQuery1());){
			
			pstmt.setInt(1, actorId);
			ResultSet resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				movieList.add(new Movie(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)));
				
			}
			
		}
		
		return movieList;
		
	}
	
	
	//2. List all the actors in a particular movie.
	public List<Actor> getCase2(int movieId) throws SQLException{
		
		List<Actor> actorList = new ArrayList<>();
		
		try(Connection connection = databaseUtil.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getQuery2());){
			
			pstmt.setInt(1, movieId);
			ResultSet resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				actorList.add(new Actor(resultSet.getInt(1), resultSet.getString(2)));
				
			}
			
		}
		
		return actorList;
		
	}
	
	
	//3. List all the movies having budget greater than 1,00,000.
	public List<Movie> getCase3() throws SQLException{
		
		List<Movie> movieList = new ArrayList<>();
		
		try(Connection connection = databaseUtil.getConnection();
			Statement stmt = connection.createStatement();){
			
			ResultSet resultSet = stmt.executeQuery(QueryUtil.getQuery3());
			
			while(resultSet.next()) {
				movieList.add(new Movie(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)));
				
			}
			
		}
		
		return movieList;
		
	}
	
	
	//4. Count the actors who have done only one movie.
	public int getCase4() throws SQLException{
		
		int count =0;
		
		try(Connection connection = databaseUtil.getConnection();
			Statement stmt = connection.createStatement();){
			
			ResultSet resultSet = stmt.executeQuery(QueryUtil.getQuery4());
			
			while(resultSet.next()) {
				count++;
				
			}
			
		}
		
		return count;
		
	}
	
	
	
	//5. List all the actors whose name length is more than 6 characters and have done a movie having budget greater then"
	public List<Actor> getCase5(int budget) throws SQLException{
		
		List<Actor> actorList = new ArrayList<>();
		
		try(Connection connection = databaseUtil.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getQuery5());){
			
			pstmt.setInt(1, budget);
			ResultSet resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				actorList.add(new Actor(resultSet.getInt(1), resultSet.getString(2)));
				
			}
			
		}
		
		return actorList;
		
	}

	

}

