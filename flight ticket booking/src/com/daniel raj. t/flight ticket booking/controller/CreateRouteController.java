package controller;

import java.util.List;

import repository.Routes;
import view.CreateRouteView;

public class CreateRouteController {
    CreateRouteView createRouteView;
    Routes routes;
    
    public CreateRouteController(CreateRouteView createRouteView) {
	this.createRouteView = createRouteView;
	routes = Routes.getInstene();
    }
    
    public void createNewRoute (List<String> route) {
	routes.addRoute(route);
    }
}
