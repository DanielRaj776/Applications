package controller;

import java.util.LinkedList;
import java.util.List;

import model.Plane;
import repository.Flights;
import view.FlightSearchView;

public class FlightSearchController {
    private FlightSearchView flightSearchView;
    private Flights flights;
    
    public FlightSearchController(FlightSearchView flightSearchView) {
	this.flightSearchView = flightSearchView;
	this.flights = Flights.getInstence();
    }
    
    public void Search (String[] stations){
	List<Plane> list = new LinkedList<>();
	for(Plane plane : flights.getFlightList()) {
	    int index = 0;
	    for(String station :  plane.getRoute()) {
		if(station.equals(stations[index])) {
		    index++;
		}
		if(index == 2) {
		    list.add(plane);
		    break;
		}
	    }
	}
	if(list.size() == 0) {
	    flightSearchView.displayNoResult(stations);
	}else {
	    flightSearchView.displayResult(list);
	}
    }
}