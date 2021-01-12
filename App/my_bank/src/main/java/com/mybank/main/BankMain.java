package com.mybank.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		
		// Create the simple date format to help convert a string type to a date type
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		sdf.setLenient(false);
		Date date = null;
		
		// Getting User info
		log.info("Please fill out the info below");
		log.info("");
		log.info("User Id");
		String userId = sc.nextLine();
		log.info("");
		log.info("First Name");
		String firstName = sc.nextLine();
		log.info("");
		log.info("Last Name");
		String lastName = sc.nextLine();
		log.info("");
		log.info("Driver's License");
		String driversLicense = sc.nextLine();
		log.info("");
		log.info("Social Security Number");
		Integer ssn = sc.nextInt();
		log.info("");
		log.info("Email");
		String email = sc.nextLine();
		log.info("");
		log.info("Billing Address");
		String billingAddress = sc.nextLine();
		log.info("");
		log.info("Date of Birth (yyyy-mm-dd)");
		String dob = sc.nextLine();
		log.info("");
		log.info("Gender (M or F)");
		String gender = sc.nextLine();
		log.info("");
		log.info("password");
		String password = sc.nextLine();
		
		// Convert the dob from a String to a Date format and create the new user
		try {
			date = sdf.parse(dob);
			
			user.setUserId(userId);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setDriversLicense(driversLicense);
			user.setSsn(ssn);
			user.setEmail(email);
			user.setBillingAddress(billingAddress);
			user.setDob(date);
			user.setGender(gender);
			user.setPassword(password);
			bankService.createUser(user);
		}catch(ParseException e) {
			log.info("Invalid Date");
		}
		
	}

}
