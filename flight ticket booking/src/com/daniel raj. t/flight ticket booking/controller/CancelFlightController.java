package controller;

import java.util.ArrayList;
import java.util.List;

import model.BookingDetails;
import model.BookingState;
import model.Passanger;
import model.Plane;
import repository.BookingList;
import repository.Flights;
import view.CancelFlightView;

public class CancelFlightController {
    private CancelFlightView cancelFlightView;
    private BookingList bookingList;
    private Flights flights;
    public CancelFlightController(CancelFlightView cancelFlightView) {
	this.cancelFlightView = cancelFlightView;
	bookingList = BookingList.getInstence();
	flights = Flights.getInstence();
    }
    
    public void cancelFlight (int flightNo) {
	List<BookingDetails> canceledBooking = new ArrayList<>();
	for(BookingDetails bookingDetails : bookingList.getBookingList()) {
	    if(bookingDetails.getFlightNumber() == flightNo) {
		canceledBooking.add(bookingDetails);
	    }
	}
	Plane plane = null;
	for(int i = 0; i < flights.getFlightList().size(); i++) {
	    plane = flights.getFlightList().get(i); 
	    if(plane.getFlightNo() == flightNo) {
		break;
	    }
	}
	cancelFlightView.showRefund(canceledBooking, plane);
	flights.getFlightList().remove(plane);
	List<Passanger> passangerList = bookingList.getPassangers();
	for(BookingDetails bookingDetails : canceledBooking) {
	    bookingDetails.setBookingState(BookingState.CANCELD);
	    passangerList.remove(bookingDetails.getPassanger());
	}
    }
}
