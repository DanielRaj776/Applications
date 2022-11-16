package repository;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Routes {
    private static Routes instence = null; 
    
    private LinkedList<List<String>> flightRoutes = null;
    
    private Routes() { };
    
    public static Routes getInstene () {
	if(instence == null) {
	    instence = new Routes();
	    instence.flightRoutes = new LinkedList<>();
	    instence.flightRoutes.add(Arrays.asList("Chennai", "Bengalure", "Hydrabad", "Kolkatta"));
	    instence.flightRoutes.add(Arrays.asList("Chennai", "Bengalure" ,"Hydrabad" ,"Kolkatta", "Delhi"));
	    instence.flightRoutes.add(Arrays.asList("Chennai" ,"Bengalure" ,"Hydrabad" ,"Mumbai" ,"Ahamadabath"));
	}
	return instence;
    }
    
    public LinkedList<List<String>> getRouteList () { 
	return flightRoutes;
    }
    public void addRoute (List<String> rotue) {
	flightRoutes.add(rotue);
    }
}
