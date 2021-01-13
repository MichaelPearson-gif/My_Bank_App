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
				
				// Checking to see if the user id is an employee or customer
				if (userId.equals("employee1")) {
					
					// Verify the password
					if(bankService.loginVerify(userId, password) == true) {
						
						// Send them to the employee menu
//						log.info("This menu is still under construction");
						employeMenu(userId);
					}else {
						log.info("The password you entered was incorrect. Please try again.");
					}
					
				}else {
					// Verify the password
					if(bankService.loginVerify(userId, password) == true) {
						
						// Send them to the customer menu
						log.info("This menu is still under construction");
//						customerMenu(userId);
					}else {
						log.info("The password you entered was incorrect. Please try again.");
					}
					
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
	public static void customerMenu(String userId) throws BusinessException{
		
	}
	
	// Employee Menu
	public static void employeMenu(String userId) throws BusinessException {
		
		// Switch variable
		int employeeCH = 0;
		
		// Do While loop for the switch cases of the employee menu
		do {
			
			// Employee Options
			log.info("Welcome back " + userId + ". What would you like to do?");
			log.info("");
			log.info("1) Approve or deny new bank account requests.");
			log.info("2) View all bank accounts for a customer");
			log.info("3) View all transaction logs");
			log.info("4) Logout");
			
			// Parse through the switch variable
			try {
				employeeCH = Integer.parseInt(sc.nextLine());
			}catch (NumberFormatException e) {
				
			}
			
			switch(employeeCH) {
			
			case 1:
				employeeRequests();
				break;
				
			case 2:
				log.info("Please enter in the customer user id");
				String customerId = sc.nextLine();
				bankService.getAllCustomers(customerId);
				break;
				
			case 3:
				log.info("Retrieving transaction logs...");
				bankService.getAllTransactions();
				break;
				
			case 4:
				log.info("Thank you we hope to see you again soon.");
				break;
				
			// Default switch case for invalid options
			default: log.info("Invalid menu option. Please retry selecting one of the mentioned options");
			break;
			
			}
			
		}while (employeeCH != 4);
		
	}
	
	// Mini menu in the employee menu that pulls a list of pending new account requests and decide to approve or deny
	public static void employeeRequests() throws BusinessException {
		
		// Switch case variable
		int requestCH = 0;
		
		// Prints out the pending requests
		log.info("Retrieving all pending new bank account requests");
//		bankService.employeePendingTransactions();
		
		// Do While loop for employee choices
		do {
			
			log.info("");
			log.info("What would you like to do?");
			log.info("1) Approve / Deny requests");
			log.info("2) Go back to the employee menu");
			
			// Parse through the switch variable
			try {
				requestCH = Integer.parseInt(sc.nextLine());
			}catch (NumberFormatException e) {
							
			}
			
			switch(requestCH) {
			
			case 1:
				// Get employee input on which transaction status to modify
				log.info("Please input the transaction id");
				int transactionId = Integer.parseInt(sc.nextLine());
				log.info("");
				log.info("Approve or Deny");
				String answer = sc.nextLine();
				
				// Update the DB
				bankService.statusUpdate(transactionId, answer);
				
				// Create an if statement for approved new account requests to automatically create the new bank account
				
				break;
				
			case 2:
				log.info("Going back to employee menu");
				break;
				
			// Default switch case for invalid options
			default: log.info("Invalid menu option. Please retry selecting one of the mentioned options");
				break;
			}
			
		}while(requestCH != 2);
		
	}

}
