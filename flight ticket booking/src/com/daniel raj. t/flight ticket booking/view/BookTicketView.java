package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import controller.BookTicketController;
import model.Gender;
import model.Passanger;
import utilities.InputCheck;

public class BookTicketView {
    private BookTicketController bookTicketController;
    private FlightSearchView flightSearchView;
    private Display display;
    public BookTicketView () {
	bookTicketController = new BookTicketController(this);
	flightSearchView = new FlightSearchView();
	display = new Display();
    }
    
    public void bookTicket () {
	flightSearchView.search();
	List<String> optionList = Arrays.asList("Search", "Book", "Exit");
	int selectedOption = 0;
	do {
	    selectedOption = display.displayMenu(optionList);
	    if(!(selectedOption > 0 && selectedOption <= optionList.size()))
		System.out.println("invalid input");
	} while (!(selectedOption > 0 && selectedOption <= optionList.size()));
	switch (selectedOption) {
	case 1:{
	    bookTicket();
	    break;
	}
	case 2:{
	    booking();
	    break;
	}
	case 3:
	    return;
	}
    }
    
    private void booking () {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter Flight id");
	System.out.print("->");
	String flightIdString = "";
	boolean isThereAFlight = false; 
	do {
	    try {
		flightIdString = reader.readLine();
	    } catch (IOException e) {
	    }
	    if(!InputCheck.isNumber(flightIdString)) {
		System.out.println("invalid input");
		System.out.print("->");
	    }else if(bookTicketController.checkFlight(Integer.parseInt(flightIdString))) {
		isThereAFlight = true;
	    }else {
		System.out.println("Invalid flight id");
		System.out.println("->");
	    }
	} while (!isThereAFlight);
	System.out.println("Enter number Of Passangers");
	System.out.print("->");
	String numStirng = "";
	do {
	    try {
		numStirng = reader.readLine();
	    } catch (IOException e) {
	    }
	    if(!InputCheck.isNumber(flightIdString))
		System.out.println("invalid input");
	} while (!InputCheck.isNumber(flightIdString));
	List<Passanger> passangers = new LinkedList<>();
	for(int i = 0; i < Integer.parseInt(numStirng); i++) {
	    System.out.println("bofore add");
	    passangers.add(getPassangerDetails());
	    System.out.println("after add");
	}
    }
    
    private Passanger getPassangerDetails () {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter Name");
	System.out.print("->");
	String name = "";
	do {
	    try {
		name = reader.readLine();
	    } catch (IOException e) {
	    }
	    if(!InputCheck.isEnglishCharOrSpace(name))
		System.out.println("Invalid input");
	} while (!InputCheck.isEnglishCharOrSpace(name));
	System.out.println("Enter Age");
	System.out.print("->");
	String ageString = "";
	do {
	    try {
		ageString = reader.readLine();
	    } catch (IOException e) {
	    }
	    if(!InputCheck.isNumber(ageString)){
		System.out.println("invalid input");
	    }
	}while (!InputCheck.isNumber(ageString));
	System.out.println("Select Gender");
	List<String> genders = Arrays.asList("MALE", "FEMALE", "TRANCE");
	int genderId = display.displayMenu(genders);
	Gender gender = Gender.getGender(genderId);
	System.out.println("Enter id");
	System.out.print("->");
	String idString = "";
	do {
	    try {
		idString = reader.readLine();
	    } catch (IOException e) {
	    }
	    if(!InputCheck.isNumber(idString))
		System.out.println("invalid input");
	} while (!InputCheck.isNumber(idString));
	Passanger passanger = new Passanger();
	passanger.setName(name);
	System.out.println("name");
	passanger.setAge(Integer.parseInt(ageString));
	System.out.println("age");
	passanger.setGender(gender);
	System.out.println("gender");
	passanger.setID(Integer.parseInt(idString));
	System.out.println("id");
//	    try {
//		reader.close();
//	    } catch (IOException e) {
//	    }
	return passanger;
    }
}
