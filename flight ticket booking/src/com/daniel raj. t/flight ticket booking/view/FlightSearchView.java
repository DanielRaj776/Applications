package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import controller.FlightSearchController;
import model.Plane;

public class FlightSearchView {
    private FlightSearchController flightSearchController;
    
    public FlightSearchView () {
	this.flightSearchController = new FlightSearchController(this);
    }
    
    public void search () {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter Departure Place");
	String departurePlace = null;
	try {
	    departurePlace = reader.readLine();
	} catch (IOException e) {
	}
	System.out.println("Enter Arrival Place");
	String arrivalPlace = null;
	try {
	    arrivalPlace = reader.readLine();
	} catch (IOException e) {
	}
	flightSearchController.Search(new String[] {departurePlace, arrivalPlace});
    }
    
    public void displayResult (List<Plane> planes) {
	if(planes.size() != 0) {
	    for(Plane plane : planes) {
		int depatureTime = plane.getDapatureTime();
		int arrivalTime = plane.getArrivalTime();
		System.out.println(plane.getFlightNo() + "||" + plane.getName() + "||" + depatureTime / 60 + ":" + depatureTime%60 + "||" + arrivalTime/60 + ":" + arrivalTime%60 + "||" + plane.getTravelTime() + "||" + plane.getFare() + "||" + (plane.getSeats() - plane.getBookedSeats()) + "\n" + plane.getRoute() + "\n");
	    }
	}
    }
    
    public void displayNoResult(String[] stations) {
	System.out.printf("There Are No Flightes Available For %s to %s\n", stations[0], stations[1]);
    }
}