package model;

public class Seat {
    private int seatNumber;
    private float price;
    private int bookingStates;
    private Show show; 
    
    public Seat() {
	seatNumber = -1;
	price = -1;
	bookingStates = -1;
	show = null;
    }
    
    public int getSeatNumber() {
	return seatNumber;
    }
    public void setSeatNumber(int seatNumber) {
	this.seatNumber = seatNumber;
    }
    public float getPrice() {
	return price;
    }
    public void setPrice(float price) {
	this.price = price;
    }
    public int getBookingStates() {
	return bookingStates;
    }
    public void setBookingStates(int bookingStates) {
	this.bookingStates = bookingStates;
    }
    public Show getShow() {
	return show;
    }
    public void setShow(Show show) {
	this.show = show;
    }
}
