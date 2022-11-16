package controller;

import model.Passanger;
import repository.BookingList;
import view.PassangerSearchView;

public class PassangerSearchController {
    private PassangerSearchView passangerSearchView;
    private BookingList bookingList;
    
    public PassangerSearchController(PassangerSearchView passangerSearchView) {
	this.passangerSearchView = passangerSearchView;
	this.bookingList = BookingList.getInstence();
    }
    
    public void search (int id) {
	Passanger result = null;
	for(Passanger passanger : bookingList.getPassangers()) {
	    if(passanger.getID() == id) {
		result = passanger;
		break;
	    }
	}
	if(result == null) {
	    passangerSearchView.noResult();
	}else {
	    passangerSearchView.displayResult(result);
	}
    }
}