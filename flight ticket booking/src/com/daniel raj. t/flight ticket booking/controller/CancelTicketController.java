package controller;

import java.util.LinkedList;

import model.BookingDetails;
import model.BookingState;
import model.Plane;
import repository.BookingList;
import repository.Flights;
import view.CancelTicketView;

public class CancelTicketController {

    private CancelTicketView cancelTicketView;
    private BookingList bookingList;
    private Flights flights;
    public CancelTicketController(CancelTicketView cancelTicketView) {
	this.cancelTicketView = cancelTicketView;
	bookingList = BookingList.getInstence();
	flights = Flights.getInstence();
    }
    
    public void cancelTicket (int BookingID) {
	LinkedList<BookingDetails> list = new LinkedList<>();
	for(BookingDetails bookingDetails : bookingList.getBookingList()) {
	    if(bookingDetails.getBookingID() == BookingID) {
		list.add(bookingDetails);
	    }
	}
	int price = 0;
	for(Plane plane : flights.getFlightList()) {
	    if(plane.getFlightNo() == list.get(0).getFlightNumber()) {
		price = plane.getFare();
		plane.setBookedSeats(plane.getBookedSeats() - list.size());
	    }
	}
	cancelTicketView.refund(price * list.size());
	for(BookingDetails bookingDetails : list) {
	    bookingDetails.setBookingState(BookingState.CANCELD);
	    bookingList.getPassangers().remove(bookingDetails.getPassanger());
	}
	int count = 0;
	for(BookingDetails bookingDetails : bookingList.getBookingList()) {
	    if(bookingDetails.getFlightNumber() == list.get(0).getFlightNumber() && bookingDetails.getBookingState() == BookingState.WAITING_LIST) {
		bookingDetails.setBookingState(BookingState.BOOKED);
		count += 1;
		if(count == list.size())
		    break;
	    }
	}
    }
}
