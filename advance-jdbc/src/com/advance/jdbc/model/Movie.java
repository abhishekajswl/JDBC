package com.advance.jdbc.model;

public class Movie {
	private int movieId;
	private String movieName;
	private int budget;
	
	public Movie(int movieId, String movieName, int budget) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.budget = budget;
	}
	
	public int getMovieId() {
		return movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public int getBudget() {
		return budget;
	}
	
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", budget=" + budget + "]";
	}
	
	

}
