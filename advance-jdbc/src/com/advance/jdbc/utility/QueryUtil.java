package com.advance.jdbc.utility;

public class QueryUtil {
	
	//1. List all the movies done by a particular actor.
	public static String getQuery1() {
		return "select * from movie where movie_id in (select movie_id from mov_actor where actor_id = ? )";
	}
	
	
	//2. List all the actors in a particular movie.
	public static String getQuery2() {
		return "select * from actor where actor_id in (select actor_id from mov_actor where movie_id = ? )";
	}
	
	
	//3. List all the movies having budget greater than 1,00,000.
	public static String getQuery3() {
		return "select * from movie where budget > 100000";
	}
	
	
	//4. Count the actors who have done only one movie.
	public static String getQuery4() {
		return "select * from actor where actor_id in (select actor_id from mov_actor group by actor_id having count(actor_id) = 1 )";
	}//incomplete
	
	
	//5. List all the actors whose name length is more than 6 characters and have done a movie having budget greater then"
	public static String getQuery5() {
		return "select * from actor where actor_name like '_______%' and actor_id in (select actor_id from mov_actor where movie_id in ( select movie_id from movie where budget > ? ) )";
	}

}
