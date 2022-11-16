package presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import utilities.InputCheck;

public class Input {
    BufferedReader bufferedReader;
    
    public Input() {
	bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public long numberInput (String prompt) {
	String inputString = "";
	try {
	    inputString = bufferedReader.readLine();
	} catch (IOException e) {
	    System.out.println("Error, Please Renter");
	}
	if(!(InputCheck.isNumber(inputString))) {
	    System.out.println("Enter A Number");
	    System.out.print(prompt);
	    inputString = String.valueOf(numberInput(prompt));
	}
	return Long.parseLong(inputString);
    }
    public String nameInput (String prompt) {
	String inputString = "";
	try {
	    inputString = bufferedReader.readLine();
	} catch (IOException e) {
	    System.out.println("Error, Please Renter");
	}
	if((!InputCheck.isEnglishCharacter(inputString))) {
	    System.out.println("Only English Character And Space Are Allowed");
	    System.out.print(prompt);
	    inputString = nameInput(prompt);
	}
	return inputString;
    }
    public String stringInput (String prompt) {
	String inputString = "";
	try {
	    inputString = bufferedReader.readLine();
	} catch (IOException e) {
	    System.out.println("Error, Please Renter");
	}
	if(inputString.length() == 0) {
	    System.out.println("Invalid Input Please Enter Again");
	    System.out.print(prompt);
	    inputString = stringInput(prompt);
	}
	return inputString;
    }
    public String dateInput (String prompt) {
	String inputString = "";
	try {
	    inputString = bufferedReader.readLine();
	} catch (IOException e) {
	    System.out.println("Error, Please Renter");
	}
	if(!(InputCheck.isDate(inputString))) {
	    System.out.println("Invalid Input");
	    System.out.print(prompt);
	    inputString = dateInput(prompt);
	}
	return inputString;
    }
    public String timeInput (String prompt) {
	String inputString = "";
	try {
	    inputString = bufferedReader.readLine();
	} catch (IOException e) {
	    System.out.println("Error, Please Renter");
	}
	if(!(InputCheck.isTime(inputString))) {
	    System.out.println("Invalid Input");
	    System.out.println(prompt);
	    inputString = timeInput(prompt);
	}
	return inputString;
    }
}
