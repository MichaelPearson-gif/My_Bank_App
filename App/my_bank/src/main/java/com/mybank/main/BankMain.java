package com.mybank.main;



import java.util.Scanner;

import org.apache.log4j.Logger;

import com.mybank.exception.BusinessException;
import com.mybank.model.User;
import com.mybank.service.BankService;
import com.mybank.service.impl.BankServiceImpl;

public class BankMain {

	// Create a logger variable
	private static Logger log = Logger.getLogger(BankMain.class);
	
	// Create an instance of the service layer
	private static BankService bankService = new BankServiceImpl();
	
	// Create an instance of the User class
	User user = new User();
	
	// Scanner is used to take in user inputs
	// Scanner is static so I can reference it in my static methods
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws BusinessException {
		
		// Create a variable for the switch cases
		int ch = 0;
		
		// Do While  for the switch cases
		do {
			// Under the do:
			// Print Welcome message
			log.info("Welcome to MyBank application V1.00");
			log.info("------------------------------------------------");
			log.info("PLease select one of the following options:");
			log.info("1) Create a new account");
			log.info("2) Login");
			log.info("3) Exit");
		
			// Add a try catch block to parse through the switch case variable
			try {
				ch = Integer.parseInt(sc.nextLine());
			}catch (NumberFormatException e) {
				
			}
		
			// Create switch cases
			switch(ch) {
			
			case 1:
				Register();
				break;
				
			case 2:
				loginMenu();
				break;
				
			case 3:
				log.info("Thank you for using MyBank application. Have a good day!");
				break;
			
			// Last switch case is the default case
			default: log.info("Invalid menu option. Please retry selecting one of the mentioned options");
				break;
			}
			
		}while(ch != 3);
		
	}
	
	// Method that allows a new customer to register for a new user account
	public static void Register() throws BusinessException {
		User user = new User();
		
		// Getting User info
		log.info("Please fill out the info below");
		log.info("");
		log.info("User Id");
		user.setUserId(sc.nextLine());
		log.info("");
		log.info("First Name");
		user.setFirstName(sc.nextLine());
		log.info("");
		log.info("Last Name");
		user.setLastName(sc.nextLine());
		log.info("");
		log.info("Driver's License");
		user.setDriversLicense(sc.nextLine());
		log.info("");
		log.info("Social Security Number");
		user.setSsn(Integer.parseInt(sc.nextLine()));
		log.info("");
		log.info("Email");
		user.setEmail(sc.nextLine());
		log.info("");
		log.info("Billing Address");
		user.setBillingAddress(sc.nextLine());
		log.info("");
		log.info("Date of Birth (yyyy-mm-dd)");
		user.setDob(sc.nextLine());
		log.info("");
		log.info("Gender (M or F)");
		user.setGender(sc.nextLine());
		log.info("");
		log.info("password");
		user.setPassword(sc.nextLine());
		
		bankService.createUser(user);
		
	}
	// Method that takes user to the login menu and allows them to log in
	public static void loginMenu() throws BusinessException {
		
		// Variable to use for switch cases
		int loginCH = 0;
		// Do While loop for switch cases so users could login or go back to the main menu
		do {
			
			// Tell the user what choices they can select
			log.info("Please select one of the following choices");
			log.info("");
			log.info("1) Input login credentials");
			log.info("2) Go back to the Main Menu");
			
			// Parse through the switch case variable
			try {
				loginCH = Integer.parseInt(sc.nextLine());
			}catch (NumberFormatException e) {
				
			}
			
			// Switch cases
			switch(loginCH) {
			
			case 1:
				// Getting user inputs for their user id and password
				log.info("Please enter in your user id");
				String userId = sc.nextLine();
				log.info("");
				log.info("Please enter in your password");
				String password = sc.nextLine();
				
				// Checking to see if the userid is an employee or customer
				if (userId == "employee1") {
					
					// Verify the password
					bankService.loginVerify(userId, password);
					
					// Send them to the employee menu
					log.info("This menu is still under construction");
//					employeMenu(userId);
				}else {
					// Verify the password
					bankService.loginVerify(userId, password);
					
					// Send them to the customer menu
					log.info("This menu is still under construction");
//					customerMenu(userId);
				}
				
				break;
				
			case 2:
				log.info("Going back to the Main Menu");
				break;
				
			// Default case to handle invalid options	
			default: log.info("Invalid menu option. Please retry selecting one of the mentioned options");
				break;
			}
			
		}while(loginCH != 2);
	}
	
	// Customer Menu
	public static void customerMenu(String userId) {
		
	}
	
	// Employee Menu
	public static void employeMenu(String userId) {
		
	}

}
