package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import controller.CancelFlightController;
import model.BookingDetails;
import model.Plane;
import utilities.InputCheck;

public class CancelFlightView {
    private CancelFlightController cancelFlightController;

    public CancelFlightView() {
	cancelFlightController = new CancelFlightController(this);
    }

    public void cancelFlight () {
	System.out.println("Enter Flight Number");
	String flightNumberString = null;
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	do {
	    try {
		    flightNumberString = bufferedReader.readLine();
	    } catch (IOException e) {
	    }
	    if(!InputCheck.isNumber(flightNumberString))
		System.out.println("invalid input");
	} while (!InputCheck.isNumber(flightNumberString));
	int flightNumber = Integer.parseInt(flightNumberString);
	cancelFlightController.cancelFlight(flightNumber);
    }
    
    public void showRefund (List<BookingDetails> list, Plane plane) {
	for(BookingDetails bookingDetails : list) {
	    System.out.println("Refund " + plane.getFare() + " to " + bookingDetails.getBookingID() + " || " + bookingDetails.getPassanger().getName());
	}
    }
}
