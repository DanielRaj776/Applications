package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import utilities.InputCheck;

public class Display {
    BufferedReader reader;
    
    public Display() {
	reader = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public int displayMenu (List<String> list) {
	for(int i = 0; i < list.size(); i++) {
	    System.out.println((i + 1) + " ." + list.get(i));
	}
	System.out.print("->");
	String input = "";
	try {
	     input = reader.readLine();
	} catch (IOException e) {
	    System.out.println("Error Occered Try Again");
	}
	if(!InputCheck.isNumber(input)) {
	    System.out.println("Enter a Number");
	    input = "" + displayMenu(list);
	}
	return Integer.parseInt(input);
    }
}
