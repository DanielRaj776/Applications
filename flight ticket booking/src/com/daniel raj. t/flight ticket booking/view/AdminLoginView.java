package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import controller.AdminLoginController;
import utilities.InputCheck;

public class AdminLoginView {
    private AdminLoginController adminLoginController = null;
    private Display display = null;
    
    public AdminLoginView() {
	adminLoginController = new AdminLoginController(this);
	display = new Display();
    }

    public void login() {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Admin Login");
	String name = "";
	do {
	    System.out.println("Enter Name");
	    System.out.print("->");
	    try {
		name = reader.readLine();
	    } catch (IOException e) {
		System.out.println("Error Occered Try Again");
	    }
	    if (!InputCheck.isEnglishCharOrSpace(name)) {
		    System.out.println("Invalid input");
	    }
	} while (!InputCheck.isEnglishCharOrSpace(name));
	System.out.println("Enter Password");
	System.out.print("->");
	String password = "";
	try {
	    password = reader.readLine();
	} catch (IOException e) {
	    System.out.println("Error Occered Try Again");
	}
	adminLoginController.loginCheck(name, password);
    }
    public void adminOptions () {
	List<String> menuOptions = new ArrayList<>(Arrays.asList("Create Flight Route", "List Filght Routes", "Search", "Booked Tickets", "Cancel Flight", "Exit"));
	int selectedOption = 0;
	do {
	    selectedOption = display.displayMenu(menuOptions);
	    if(!(selectedOption > 0 && selectedOption <= menuOptions.size())) {
		System.out.println("invalid input");
	    }
	} while (!(selectedOption > 0 && selectedOption <= menuOptions.size()));
	switch (selectedOption) {
	case 1:{
	    new CreateRouteView().createRoute();
	    adminOptions();
	    break;
	}
	case 2:{
	    new DisplayRoutesView().displayRoutes();
	    adminOptions();
	    break;
	}
	case 3:{
	    search();
	    adminOptions();
	    break;
	}
	case 4:{
	    new ViewBookedTickets().displayBookedTickets();
	    adminOptions();
	    break;
	}
	case 5:{
	    new CancelFlightView().cancelFlight();
	    adminOptions();
	    break;
	}
	case 6:
	    return;
	}
    }
    private void search () {
	List<String> optionsList = Arrays.asList("Search Flight", "Search Passanger", "Exit");
	int selectedOption = 0;
	do {
	    selectedOption = display.displayMenu(optionsList);
	    if(!(selectedOption > 0 && selectedOption <= optionsList.size())) {
		System.out.println("invalid input");
	    }
	} while (!(selectedOption > 0 && selectedOption <= optionsList.size()));
	switch (selectedOption) {
	case 1:{
	    new FlightSearchView().search();
	    search();
	    break;
	}
	case 2:{
	    new PassangerSearchView().search();
	    search();
	    break;
	}
	case 3:
	    return;
	}
    }
}
