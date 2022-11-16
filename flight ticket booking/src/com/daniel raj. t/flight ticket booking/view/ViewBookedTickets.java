package view;

import java.util.LinkedList;

import controller.ViewBookedTicketsController;
import model.BookingDetails;

public class ViewBookedTickets {
    ViewBookedTicketsController viewBookedTicketsController;
    
    public ViewBookedTickets() {
	viewBookedTicketsController = new ViewBookedTicketsController();
    }
    
    public void displayBookedTickets () {
	LinkedList<BookingDetails> list = viewBookedTicketsController.getBookedTickets();
	for(int i = 1; i <= list.size(); i++) {
	    BookingDetails bookingDetails = list.get(i);
	    System.out.println(bookingDetails.getBookingID() + "||" + bookingDetails.getPassanger().getName() + "||" + bookingDetails.getFlightNumber() + "||" + bookingDetails.getBookingState());
	}
    }
}
