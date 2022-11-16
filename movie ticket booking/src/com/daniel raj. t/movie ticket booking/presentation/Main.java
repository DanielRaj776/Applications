package presentation;

import java.util.Arrays;
import java.util.List;

public class Main {
    Display display = new Display();
    
    private void start () {
	List<String> startOptions = Arrays.asList("Manage Theatre", "Book Ticket", "Exit");
	String prompt = "->";
	System.out.println("Main Menu");
	int selectedOption = display.getSelectedOption(startOptions, prompt);  
	switch (selectedOption) {
	case 1:
	    theatreManagement();
	    start();
	    break;
	case 2:
	    bookingTicket();
	    start();
	    break;
	case 3:
	    return;
	}
    }
    private void theatreManagement () {
	List<String> theatreManagementOptions = Arrays.asList("User Sign in", "User Sign up", "Exit");
	String prompt = "->";
	int selectedOption = display.getSelectedOption(theatreManagementOptions, prompt);
	switch (selectedOption) {
	case 1:
	    display.userSignIn(prompt);
	    break;
	case 2:
	    display.userSignUp(prompt);
	    break;
	case 3:
	    return;
	}
    }
    private void bookingTicket () {
	List<String> bookingTicketOptions = Arrays.asList("Booking", "Cancel Booking", "Exit");
	String prompt = "->";
	int selectedOption = display.getSelectedOption(bookingTicketOptions, prompt);
	switch (selectedOption) {
	case 1:
	    display.search(prompt);
	    bookingTicket();
	    break;
	case 2:
	    display.cancelBooking(prompt);
	    bookingTicket();
	    break;
	case 3:
	    return;
	}
    }
    public static void main(String[] args) {
	Main main = new Main();
	main.start();
    }

}
