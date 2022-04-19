package com.advance.jdbc.service;

import java.sql.SQLException;
import java.util.List;

import com.advance.jdbc.dao.DatabaseDao;
import com.advance.jdbc.model.Actor;
import com.advance.jdbc.model.Movie;

public class DatabaseService {
	
	//it will contain only methods and returns.
	DatabaseDao dDao = new DatabaseDao();
	
	//1. List all the movies done by a particular actor.
	public List<Movie> getCase1(int actorId) throws SQLException{
		return dDao.getCase1(actorId);
	}
	
	//2. List all the actors in a particular movie.
	public List<Actor> getCase2(int movieId) throws SQLException{
		return dDao.getCase2(movieId);
	}
	
	
	//3. List all the movies having budget greater than 1,00,000.
	public List<Movie> getCase3() throws SQLException{
		return dDao.getCase3();
	}
	
	
	//4. Count the actors who have done only one movie.
	public int getCase4() throws SQLException{
		return dDao.getCase4();
	}
	
	
	//5. List all the actors whose name length is more than 6 characters and have done a movie having budget greater then"
	public List<Actor> getCase5(int budget) throws SQLException{
		return dDao.getCase5(budget);
	}

}
