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
		
		// Print Welcome message
		log.info("Welcome to MyBank application V1.00");
		log.info("------------------------------------------------");
		
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
				log.info("This option is still under developement");
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

}
