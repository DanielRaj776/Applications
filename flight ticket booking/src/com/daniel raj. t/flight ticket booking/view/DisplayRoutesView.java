package view;

import java.util.List;

import controller.DisplayRoutesController;

public class DisplayRoutesView {
    private DisplayRoutesController displayRoutesController;
    public DisplayRoutesView() {
	displayRoutesController = new DisplayRoutesController();
    }
    
    public void displayRoutes () {
	int i = 1;
	for(List<String> route : displayRoutesController.getRoutes()) {
	    System.out.print(i + " . ");
	    for(String station : route) {
		System.out.print(station + " || ");
	    }
	    i++;
	    System.out.println();
	}
    }
}