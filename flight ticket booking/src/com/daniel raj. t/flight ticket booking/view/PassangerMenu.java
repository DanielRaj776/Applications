package view;

import java.util.Arrays;
import java.util.List;

public class PassangerMenu {
    private Display display;
    
    public PassangerMenu() {
	display = new Display();
    }
    public void select (){
	List<String> options = Arrays.asList("Book Ticket", "Ticket Status", "Cancel Ticket", "List Routes", "Exit");
	int selectedOption = 0;
	do {
	    selectedOption = display.displayMenu(options);
	    if(!(selectedOption > 0 && selectedOption <= options.size()))
		System.out.println("invalid input");
	} while (!(selectedOption > 0 && selectedOption <= options.size()));
	switch(selectedOption) {
	case 1:{
	    new BookTicketView().bookTicket();
	    select();
	    break;
	}
	case 2:{
	    new TicketStatusView().states();
	    select();
	    break;
	}
	case 3:{
	    new CancelTicketView().cancelTicket();
	    select();
	    break;
	}
	case 4:{
	    new DisplayRoutesView().displayRoutes();
	    select();
	    break;
	}
	case 5:
	    return;
	}
    }
}
