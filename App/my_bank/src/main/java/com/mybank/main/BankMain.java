package com.mybank.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.mybank.service.BankService;
import com.mybank.service.impl.BankServiceImpl;

public class BankMain {

	// Create a logger variable
	private static Logger log = Logger.getLogger(BankMain.class);
	
	public static void main(String[] args) {
		// Create an instance of the service layer
		BankService bankService = new BankServiceImpl();
		
		// Scanner is used to take in user inputs
		Scanner sc = new Scanner(System.in);
		
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
			log.info("1) Login");
			log.info("2) Create a new account");
			log.info("3) Exit");
		
			// Add a try catch block to parse through the switch case variable
			try {
				ch = Integer.parseInt(sc.nextLine());
			}catch (NumberFormatException e) {
				
			}
		
			// Create switch cases
			switch(ch) {
			
			case 1:
				log.info("This option is still under developement");
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

}
