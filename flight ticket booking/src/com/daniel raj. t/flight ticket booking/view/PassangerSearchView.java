package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import controller.PassangerSearchController;
import model.Passanger;
import utilities.InputCheck;

public class PassangerSearchView {
    private PassangerSearchController passangerSearchController;

    public PassangerSearchView() {
	passangerSearchController = new PassangerSearchController(this);
    }

    public void search() {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter Passanger id");
	System.out.print("->");
	String idString = "";
	do {
	    try {
		idString = reader.readLine();
	    } catch (IOException e) {
	    }
	    if(!InputCheck.isNumber(idString)) {
		System.out.println("invalid input");
		System.out.println("->");
	    }
	} while (!InputCheck.isNumber(idString));
	passangerSearchController.search(Integer.parseInt(idString));
    }

    public void noResult() {
	System.out.println("No Results Found");
    }

    public void displayResult(Passanger passanger) {
	System.out.println(passanger.getID() + "||" + passanger.getName() + "||" + passanger.getAge() + "||"
		+ passanger.getGender() + "||");
    }
}