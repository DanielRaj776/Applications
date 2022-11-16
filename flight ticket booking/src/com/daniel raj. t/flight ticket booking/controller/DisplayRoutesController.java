package controller;

import java.util.LinkedList;
import java.util.List;

import repository.Routes;

public class DisplayRoutesController {
    private Routes routes;
    public DisplayRoutesController() {
	this.routes = Routes.getInstene();
    }
    
    public LinkedList<List<String>> getRoutes () {
	return routes.getRouteList();
    }
}