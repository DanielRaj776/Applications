package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import controller.CreateRouteController;
import utilities.InputCheck;

public class CreateRouteView {
    private CreateRouteController createRouteController;
    public CreateRouteView() {
	createRouteController = new CreateRouteController(this);
    }
    public void createRoute() {
	System.out.println("Enter number of stations in the route");
	System.out.print("->");
	String numberOfStationsString = "";
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	do {
	    try {
		numberOfStationsString = reader.readLine();
	    } catch (IOException e) {
	    }
	    if (!InputCheck.isNumber(numberOfStationsString)) {
		System.out.println("invalid input");
		System.out.print("->");
	    }
	} while (!InputCheck.isNumber(numberOfStationsString));
	int numberOfStations = Integer.parseInt(numberOfStationsString);
	List<String> route = new ArrayList<>(numberOfStations);
	for(int i = 0; i < numberOfStations; i++) {
	    System.out.printf("Enter %d'th station\n", i + 1);
	    String temp = null;
	    try {
		temp = reader.readLine();
	    } catch (IOException e) {
	    }
	    route.add(temp);
	}
	createRouteController.createNewRoute(route);
    }
}
