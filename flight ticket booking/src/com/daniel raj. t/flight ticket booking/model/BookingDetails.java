package model;

public class BookingDetails {
    private int bookingID;
    private BookingState bookingState;
    private int flightNumber;
    private Passanger passanger;
    public BookingDetails() {
	bookingID = -1;
	flightNumber = -1;
	bookingState = null;
	passanger = null;
    }
    
    public BookingDetails(int bookingID, int flightNumber, BookingState bookingState, Passanger passanger) {
	this.bookingID = bookingID;
	this.flightNumber = flightNumber;
	this.bookingState = bookingState;
	this.passanger = passanger;
    }

    public int getBookingID() {
        return bookingID;
    }
    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }
    public BookingState getBookingState() {
        return bookingState;
    }
    public void setBookingState(BookingState bookingState) {
        this.bookingState = bookingState;
    }
    public int getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Passanger getPassanger() {
	return passanger;
    }

    public void setPassanger(Passanger passanger) {
	this.passanger = passanger;
    }
}	