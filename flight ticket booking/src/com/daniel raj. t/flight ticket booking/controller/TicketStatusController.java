package controller;

import java.util.LinkedList;

import model.BookingDetails;
import repository.BookingList;
import view.TicketStatusView;

public class TicketStatusController {
    private TicketStatusView ticketStatusView;
    private BookingList bookingList;
    public TicketStatusController(TicketStatusView ticketStatusView) {
	this.ticketStatusView = ticketStatusView;
	bookingList = BookingList.getInstence();
    }
    
    public void getStates (int bookingID) {
	LinkedList<BookingDetails> list = new LinkedList<>();
	for(BookingDetails bookingDetails : bookingList.getBookingList()) {
	    if(bookingDetails.getBookingID() == bookingID) {
		list.add(bookingDetails);
	    }
	}
	ticketStatusView.displayStates(list);
    }
}
