package model;

public class TheatreScreen {
    String theatreName;
    int screenID;
    int screenNumber;
    
    public TheatreScreen(String theatreName, int screenID, int screenNumber) {
	this.theatreName = theatreName;
	this.screenID = screenID;
	this.screenNumber = screenNumber;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public int getScreenID() {
        return screenID;
    }

    public int getScreenNumber() {
        return screenNumber;
    }
    
    
}
