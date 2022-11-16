package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import controller.CancelTicketController;
import utilities.InputCheck;

public class CancelTicketView {
    private CancelTicketController cancelTicketController;
    
    public CancelTicketView() {
	cancelTicketController = new CancelTicketController(this);
    }
    
    public void cancelTicket () {
	System.out.println("Enter Booking id");
	System.out.print("->");
	String bookingIDString = null;
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	do {
	    try {
		bookingIDString = reader.readLine();
	    } catch (IOException e) {
	    }
	    if(!InputCheck.isNumber(bookingIDString)) {
		System.out.println("invalid input");
		System.out.print("->");
	    }
	} while (!InputCheck.isNumber(bookingIDString));
	cancelTicketController.cancelTicket(Integer.parseInt(bookingIDString));
    }
    public void refund (int price) {
	System.out.printf("Refunded %d\n", price);
    }
}
