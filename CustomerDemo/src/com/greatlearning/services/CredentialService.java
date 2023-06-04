package com.greatlearning.services;
import java.util.Random;
import com.greatlearning.interfaces.ICredentials;
import com.greatlearning.model.Employee;

public class CredentialService implements ICredentials {

	@Override
	public String generatePassword() {
		String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String smallLetters = "abcdefghijklmnopqrstuvwxy";
		String numbers = "0123456789";
		String specialChars = "!@#$%^&*<>?|_-~";
		String values = capitalLetters+ smallLetters+ numbers+ specialChars;
		Random random = new Random();
		String password = "";
		

		for (int i=0;i<=8;i++) {
			password+= String.valueOf(values.charAt(random.nextInt(values.length())));
		}
		return password;
	}

	@Override
	public String generateEmailAddress(Employee employee, String department) {
		String firstName = employee.getFirstName();
		String lastName = employee.getLastName();		
		return firstName+lastName+"@"+department+"abc.com";
	}

	@Override
	public void showCredentials(Employee employee) {
		System.out.println("Hi "+employee.getFirstName());
		System.out.println("Your Email is "+employee.getEmail());
		System.out.println("Your Password is "+employee.getPassword());

	}

}
