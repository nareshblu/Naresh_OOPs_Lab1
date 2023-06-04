package com.greatlearning.main;
import java.util.Scanner;

import com.greatlearning.model.Employee;
import com.greatlearning.services.CredentialService;
public class Driver {

	public void displayUserInput() {
		System.out.println("Please enter the department from the following");
		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. Human Resource");
		System.out.println("4. Legal");
	}
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		Employee employee = new Employee("Naresh", "Kumar");
		String [] departments = {"technical", "admin", "humanresource", "legal"};
		Driver driver = new Driver();
		driver.displayUserInput();
		
		int userInput = scanner.nextInt();
		System.out.println("You have chosen:"+userInput);
		
		CredentialService credentialservice = new CredentialService();
		String emailAddress = credentialservice.generateEmailAddress(employee,departments[userInput]);
//		System.out.println("Your email address: "+emailAddress);
		
		String randomPassword = credentialservice.generatePassword();
//		System.out.println("The Random Password: "+randomPassword);
		employee.setEmail(emailAddress);
		employee.setPassword(randomPassword);
		credentialservice.showCredentials(employee);
	}

}
