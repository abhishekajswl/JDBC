package com.jdbc.main;

import java.util.Scanner;

import com.jdbc.model.Employee;
import com.jdbc.service.DatabaseService;

public class MainClass {

	public static void main(String[] args) {

		DatabaseService databaseService = new DatabaseService();

		try (Scanner scanner = new Scanner(System.in);) {

			boolean isRunning = true;

			do {
				System.out.println("------------------------");
				System.out.println("Enter the Choice:");
				System.out.println("1. Insert");
				System.out.println("2. Select All");
				System.out.println("3. Select Employee by Id");
				System.out.println("4. Delete the Employee");
				System.out.println("5. Update the Employee");
				System.out.println("6. Exit");
				System.out.println("------------------------");

				int choice = Integer.parseInt(scanner.nextLine());

				switch (choice) {
				case 1: {
					System.out.println("Enter Name, Address, Salary");
					Employee newEmployee = new Employee(scanner.nextLine(), scanner.nextLine(),
							Double.parseDouble(scanner.nextLine()));
					databaseService.insertEmployee(newEmployee);
					break;
				}
				case 2: {
					databaseService.getAllEmployee();
					break;
				}
				case 3: {
					System.out.println("Enter Id of Employee");
					databaseService.getEmployeeById(Integer.parseInt(scanner.nextLine()));
					break;
				}
				case 4: {
					System.out.println("Enter Id of Employee to be deleted");
					databaseService.deleteEmployeeById(Integer.parseInt(scanner.nextLine()));
					break;
				}
				case 5: {
					System.out.println("Enter Id of Employee to be updated");
					int employeeId = Integer.parseInt(scanner.nextLine());
					boolean isFound = databaseService.getEmployeeById(employeeId);
					Employee updateEmployee = databaseService.getEmployeeObjectById(employeeId);

					if (isFound) {
						System.out.println("Choose Detail to be updated");
						System.out.println("1. Name.");
						System.out.println("2. Address.");
						System.out.println("3. Salary.");
						int column = Integer.parseInt(scanner.nextLine());

						if (column == 1) {
							System.out.println("Enter New Name ");
							updateEmployee.setEmployeeName(scanner.nextLine());
						} else if (column == 2) {
							System.out.println("Enter New Address");
							updateEmployee.setEmployeeAddress(scanner.nextLine());
						} else if (column == 3) {
							System.out.println("Enter New Salary");
							updateEmployee.setEmployeeSalary(Double.parseDouble(scanner.nextLine()));
						} else {
							System.out.println("Invalid option");
						}

						databaseService.updateEmployee(updateEmployee);

					} else {
						System.out.println("Record not found!");
					}

					break;
				}
				case 6: {
					System.out.println("Thankyou! Bye.....");
					isRunning = false;
					break;
				}

				default:
					System.out.println("Invalid choive " + choice);
					throw new IllegalArgumentException("Unexpected value: " + choice);
				}

			} while (isRunning);

		} catch (Exception e) {
			throw new RuntimeException("Something Went Wrong!!");
		}

	}

}
