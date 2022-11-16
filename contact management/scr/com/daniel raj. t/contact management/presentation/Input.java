package presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import utilities.InputCheck;

public class Input {
    private BufferedReader input;
    
    public Input() {
	input = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public int integerInput () {
	String  integerInputString = "";
	try {
	    integerInputString = input.readLine();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	if(!(InputCheck.isNumber(integerInputString))) {
	    System.out.println("           Enter A Number");
	    System.out.println("__________________________________________________");
	    integerInputString = String.valueOf(integerInput());
	}
	return Integer.parseInt(integerInputString);
    }
    public String nameInput () {
	System.out.print("Enter Contact Name : ");
	String name = "";
	try {
	    name = input.readLine();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	if(!(InputCheck.isEnglishCharacter(name))) {
	    System.out.println("           Only English Characters And Space Are Allowed");
	    System.out.println("__________________________________________________");
	    name = nameInput();
	}
	return name;
    }
    public String phoneNumberInput () {
	System.out.print("Enter Contact Phone Number : ");
	String phoneNumber = "";
	try {
	    phoneNumber = input.readLine();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	if(!(InputCheck.isNumber(phoneNumber))){
	    System.out.println("           Only Digit Are Allowed");
	    System.out.println("__________________________________________________");
	    phoneNumber = phoneNumberInput();
	}
	if(!(phoneNumber.length() == 10)) {
	    System.out.println("           Enter Ten Digits");
	    System.out.println("__________________________________________________");
	    phoneNumber = phoneNumberInput();
	}
	return phoneNumber;
    }
    public void closeInput () {
	try {
	    input.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}
