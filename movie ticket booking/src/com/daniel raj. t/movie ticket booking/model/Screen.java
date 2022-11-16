package model;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private int screenID;
    private int screenNumber;
    private int row;
    private int column;
    private int frontRows;
    private int backRows;
    private int bolconyRows;
    private List<Show> shows;
    private Theatre theatre;
    
    public Screen() {
	screenID = -1;
	screenNumber = -1;
	row = -1;
	column = -1;
	frontRows = -1;
	backRows = -1;
	bolconyRows = -1;
	shows = new ArrayList<Show>();
	theatre = null;
    }
    
    public int getScreenID() {
	return screenID;
    }
    public void setScreenID(int screenID) {
	this.screenID = screenID;
    }
    public int getScreanNumber() {
	return screenNumber;
    }
    public void setScreanNumber(int screanNumber) {
	this.screenNumber = screanNumber;
    }
    public int getRow() {
	return row;
    }
    public void setRow(int row) {
	this.row = row;
    }
    public int getColumn() {
	return column;
    }
    public void setColumn(int column) {
	this.column = column;
    }
    public int getFrontRows() {
	return frontRows;
    }
    public void setFrontRows(int frontRows) {
	this.frontRows = frontRows;
    }
    public int getBackRows() {
	return backRows;
    }
    public void setBackRows(int backRows) {
	this.backRows = backRows;
    }
    public int getBolconyRows() {
	return bolconyRows;
    }
    public void setBolconyRows(int bolconyRows) {
	this.bolconyRows = bolconyRows;
    }
    public List<Show> getShows() {
	return shows;
    }
    public void setShows(List<Show> shows) {
	this.shows = shows;
    }
    public Theatre getTheatre() {
	return theatre;
    }
    public void setTheatre(Theatre theatre) {
	this.theatre = theatre;
    }
    
}
