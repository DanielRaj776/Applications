package model;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;

public class MovieShow {
    private String theatreName;
    private int showID;
    private String movieName;
    private long startTime;
    private long endTime;
    
    private static final DateTimeFormatter formater = new DateTimeFormatterBuilder().appendLocalized(FormatStyle.MEDIUM, FormatStyle.SHORT).toFormatter();
    
    public MovieShow(String theatreName, int showID, String movieName, long startTime, long endTime) {
	this.theatreName = theatreName;
	this.showID = showID;
	this.movieName = movieName;
	this.startTime = startTime;
	this.endTime = endTime;
    }
    
    public String getTheatreName() {
        return theatreName;
    }
    public int getShowID() {
        return showID;
    }
    public String getMovieName() {
        return movieName;
    }
    public long getStartTime() {
        return startTime;
    }
    public long getEndTime() {
        return endTime;
    }
    
    public String getStartDateTime() {
	return Instant.ofEpochMilli(startTime).atZone(ZoneId.of("Asia/Kolkata")).format(formater);
    }
    public String getEndDateTime() {
	return Instant.ofEpochMilli(endTime).atZone(ZoneId.of("Asia/Kolkata")).format(formater);
    }
}
