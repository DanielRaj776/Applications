package repository;

import java.util.LinkedList;

import model.Plane;

public class Flights {
    private static Flights instence = null;
    private LinkedList<Plane> flightList = null;
    
    public static Flights getInstence () {
	if(instence == null) {
	    instence = new Flights();
	    instence.flightList = new LinkedList<>();
	    Plane flight1 = new Plane(2345, "Kolkatta Airways", 60, 660, 10, 430, 10, Routes.getInstene().getRouteList().get(0));
	    Plane flight2 = new Plane(2346, "Delhi Airways", 1380, 300, 6, 530, 10, Routes.getInstene().getRouteList().get(1));
	    Plane flight3 = new Plane(2347, "Kovai Express", 1380, 300, 6, 530, 10, Routes.getInstene().getRouteList().get(2));
	    instence.flightList.add(flight1);
	    instence.flightList.add(flight2);
	    instence.flightList.add(flight3);
	}
	return instence;
    }
    
    public LinkedList<Plane> getFlightList (){
	return flightList;
    }
}
