package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int userID;
    private String name;
    private String password;
    private String contactNumber;
    private List<Theatre> theatres;
    
    public User() {
	setUserID(-1);
	setName(null);
	setPassword(null);
	setContactNumber(null);
	theatres = new ArrayList<>();
    }

    public int getUserID() {
	return userID;
    }
    public void setUserID(int userID) {
	this.userID = userID;
    }
    public String getName() {
	return name;
    }
    public void setName(String name) {
	this.name = name;
    }
    public String getPassword() {
	return password;
    }
    public void setPassword(String password) {
	this.password = password;
    }
    public String getContactNumber() {
	return contactNumber;
    }
    public void setContactNumber(String contactNumber) {
	this.contactNumber = contactNumber;
    }
    public List<Theatre> getTheatres() {
	return theatres;
    }
    public void setTheatres(List<Theatre> theatres) {
	this.theatres = theatres;
    }
    
}
