package controller;

import java.util.LinkedList;

import model.BookingDetails;
import repository.BookingList;

public class ViewBookedTicketsController {
    private BookingList bookingList;
    
    public ViewBookedTicketsController() {
	bookingList = BookingList.getInstence();
    }
    
    public LinkedList<BookingDetails> getBookedTickets (){
	return bookingList.getBookingList();
    }
}
