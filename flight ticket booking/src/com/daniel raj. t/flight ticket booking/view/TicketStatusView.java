package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import controller.TicketStatusController;
import model.BookingDetails;
import utilities.InputCheck;

public class TicketStatusView {
    private TicketStatusController ticketStatusController;
    
    public TicketStatusView() {
	ticketStatusController = new TicketStatusController(this);
    }
    
    public void states () {
	System.out.println("Enter Booking id");
	System.out.print("->");
	String bookingIDString = null;
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	do {
	    try {
		bookingIDString = reader.readLine();
	    } catch (IOException e) {
	    }
	    if(!InputCheck.isNumber(bookingIDString)) {
		System.out.println("invalid input");
		System.out.print("->");
	    }
	} while (!InputCheck.isNumber(bookingIDString));
	ticketStatusController.getStates(Integer.parseInt(bookingIDString));
    }
    public void displayStates (List<BookingDetails> list) {
	for(BookingDetails bookingDetails : list) {
	    System.out.println(bookingDetails.getBookingID() + " || " + bookingDetails.getFlightNumber() + "||" + bookingDetails.getPassanger().getName() + "||" + bookingDetails.getBookingState());
	}
    }
}
