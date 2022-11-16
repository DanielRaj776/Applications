package repository;

import java.util.LinkedList;

import model.BookingDetails;
import model.Passanger;

public class BookingList {
    private static BookingList instence = null;
    private static LinkedList<BookingDetails> bookingList;
    private static LinkedList<Passanger> passangers;
    private BookingList() {    }
    
    public static BookingList getInstence () {
	if(instence == null) {
	    bookingList = new LinkedList<>();
	    passangers = new LinkedList<>();
	    instence = new BookingList();
	}
	return instence;
    }
    
    public LinkedList<BookingDetails> getBookingList (){
	return bookingList;
    }
    public void addBookingDetails (BookingDetails bookingDetails) {
	bookingList.add(bookingDetails);
    }
    public void addPassanger (Passanger passanger) {
	passangers.add(passanger);
    }
    public LinkedList<Passanger> getPassangers (){
	return passangers;
    }
}
