package model;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private int userID;
    private int theatreID;
    private String theatreName;
    private String address;
    private List<Screen> screens;
    
    public Theatre() {
	userID = -1;
	theatreID = -1;
	theatreName = null;
	address = null;
	screens = new ArrayList<>();
    }
    
    public int getUserID() {
	return userID;
    }

    public void setUserID(int userID) {
	this.userID = userID;
    }

    public int getTheatreID() {
	return theatreID;
    }
    public void setTheatreID(int theatreID) {
	this.theatreID = theatreID;
    }
    public String getTheatreName() {
	return theatreName;
    }
    public void setTheatreName(String theatreName) {
	this.theatreName = theatreName;
    }
    public String getAddress() {
	return address;
    }
    public void setAddress(String address) {
	this.address = address;
    }
    public List<Screen> getScreens() {
	return screens;
    }
    public void setScreens(List<Screen> screens) {
	this.screens = screens;
    }
}
