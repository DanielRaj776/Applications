package controller;

import java.util.LinkedList;
import java.util.List;

import model.BookingDetails;
import model.BookingState;
import model.Passanger;
import model.Plane;
import repository.BookingList;
import repository.Flights;
import view.BookTicketView;

public class BookTicketController {
    private BookTicketView bookTicketView;
    private Flights flights;
    private BookingList bookingList;
    public BookTicketController(BookTicketView bookTicketView) {
	this.bookTicketView = bookTicketView;
	this.bookingList = BookingList.getInstence();
	this.flights = Flights.getInstence();
    }
    public boolean checkFlight (int fligtId) {
	boolean result = false;
	for(Plane plane : flights.getFlightList()) {
	    if(plane.getFlightNo() == fligtId) {
		result = true;
		break;
	    }
	}
	return result;
    }
    public void booking (List<Passanger> list, int flightId) {
	Plane flight = null;
	for(Plane plane : flights.getFlightList()) {
	    if(plane.getFlightNo() == flightId) {
		flight = plane;
		break;
	    }
	}
	bookingList.getPassangers().addAll(list);
	int vacantSets = flight.getSeats() - flight.getBookedSeats();
	int preBookingId = bookingList.getBookingList().peekLast() == null ? 1 : bookingList.getBookingList().peekLast().getBookingID();
	if(vacantSets > list.size()) {
	    addAsBooked(list, preBookingId + 1, flightId, list.size());
	    flight.setBookedSeats(flight.getBookedSeats() + list.size());
	}else {
	    addAsBooked(list, preBookingId + 1, flightId, vacantSets);
	    flight.setBookedSeats(flight.getSeats());
	    addAsWaiting(list, vacantSets,  preBookingId + 1, flightId);
	}
    }
    private void addAsBooked (List<Passanger> list,  int bookingId, int flightNo, int numberOfPassengers) {
	LinkedList<BookingDetails> bookingDetails = bookingList.getBookingList();
	for(int i = 0; i < numberOfPassengers; i++) {
	    bookingDetails.add(new BookingDetails(bookingId, flightNo, BookingState.BOOKED , list.get(i)));
	}
    }
    private void addAsWaiting (List<Passanger> list, int index, int bookingId, int flightNo) {
	LinkedList<BookingDetails> bookingDetails = bookingList.getBookingList();
	for(int i = index; index < list.size(); i++) {
	    bookingDetails.add(new BookingDetails(bookingId, flightNo, BookingState.WAITING_LIST, list.get(i)));
	}
    }
}
