package model;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

public class Show {
    private static final DateTimeFormatter formater = new DateTimeFormatterBuilder().appendLocalized(FormatStyle.MEDIUM, FormatStyle.SHORT).toFormatter();
    
    private String movieName;
    private long startTime;
    private long endTime;
    private int showID;
    private List<Seat> seats;
    private Screen screen;
    
    public Show() {
	movieName = null;
	startTime = -1;
	endTime = -1;
	showID = -1;
	seats = new ArrayList<>();
	screen = null;
    }
    
    public String getMovieName() {
	return movieName;
    }
    public void setMovieName(String movieName) {
	this.movieName = movieName;
    }
    public long getStartTime() {
	return startTime;
    }
    public void setStartTime(long startTime) {
	this.startTime = startTime;
    }
    public long getEndTime() {
	return endTime;
    }
    public void setEndTime(long endTime) {
	this.endTime = endTime;
    }
    public int getShowID() {
	return showID;
    }
    public void setShowID(int showID) {
	this.showID = showID;
    }
    public List<Seat> getSeats() {
	return seats;
    }
    public void setSeats(List<Seat> seats) {
	this.seats = seats;
    }
    public Screen getScreen() {
	return screen;
    }
    public void setScreen(Screen screen) {
	this.screen = screen;
    }
    public String getStartDateTime() {
	return Instant.ofEpochMilli(startTime).atZone(ZoneId.of("Asia/Kolkata")).format(formater);
    }
    public String getEndDateTime() {
	return Instant.ofEpochMilli(endTime).atZone(ZoneId.of("Asia/Kolkata")).format(formater);
    }
}
