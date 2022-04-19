package com.advance.jdbc.main;

import java.util.List;
import java.util.Scanner;

import com.advance.jdbc.model.Actor;
import com.advance.jdbc.model.Movie;
import com.advance.jdbc.service.DatabaseService;

public class MainApp {

	public static void main(String[] args) {
		
		DatabaseService databaseService = new DatabaseService();
		
		boolean isRunning = true;
		try (Scanner scanner = new Scanner(System.in);) {
			
			do {
				
				System.out.println("Choice anyone from below : ");
				System.out.println("1. List all the movies done by a particular actor.");
				System.out.println("2. List all the actors in a particular movie.");
				System.out.println("3. List all the movies having budget greater than 1,00,000.");
				System.out.println("4. Count the actors who have done only one movie.");
				System.out.println("5. List all the actors whose name length is more than 6 characters and have done a movie having \n"
						+ "	   budget greater then");
				System.out.println("6. Exit.");
				System.out.println("------------------------------------------------------------------------------------");
				int choice=Integer.parseInt(scanner.nextLine());
				
				switch (choice) {
				case 1:{
					System.out.println("Enter the actor Id : ");
					MainApp.printMovie(databaseService.getCase1(Integer.parseInt(scanner.nextLine())));
					break;
				}
				case 2:{
					System.out.println("Enter the movie Id : ");
					MainApp.printActor(databaseService.getCase2(Integer.parseInt(scanner.nextLine())));
					break;
				}
				case 3:{
					MainApp.printMovie(databaseService.getCase3());
					break;
				}
				case 4:{
					int count = databaseService.getCase4();
					if (count > 0) {
						System.out.println("Number of Actors who have done only one movie are : " + count);
						System.out.println("---------------------------------------------------------------");
					} else {
						System.out.println("Sorry! No result found");
					}
					
					break;
				}
				case 5:{
					System.out.println("Enter the Budget : ");
					MainApp.printActor(databaseService.getCase5(Integer.parseInt(scanner.nextLine())));
					break;
				}
				case 6:{
					System.out.println("Thank you ! bye.....");
					isRunning = false;
					break;
				}
				default:
					System.out.println("Please Enter the correct choice");
					break;
				}
				
				
			}while(isRunning); 
			

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void printMovie(List<Movie> movieList) {
		if (movieList.size() > 0) {
			System.out.println("Below are the Movie List :\n");
			for(Movie m : movieList) {
				System.out.println(m);
				System.out.println("----------------------------------------------------------");
			}
		} else {
			System.out.println("Sorry! No result found....");
		}
	}
	
	public static void printActor(List<Actor> actorList) {
		if (actorList.size() > 0) {
			System.out.println("Below are the Actor List :\n");
			for(Actor a : actorList) {
				System.out.println(a);
				System.out.println("----------------------------------------------------------");
			}
		} else {
			System.out.println("Sorry! No result found....");
		}
	}

}
