package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import model.MovieShow;
import model.Screen;
import model.Seat;
import model.Show;
import model.Theatre;
import model.TheatreScreen;
import model.User;

public class TheatreCRUD {
    private Connection connection;
    
    public TheatreCRUD() {
	connection = ConnectionPool.getConnection();
    }
    
    public void registerTheatre (Theatre Input) throws SQLException {
	String insertStatement = "INSERT INTO THEATRE (OWNER_ID, THEATRE_NAME, ADDRESS) VALUES (?, ?, ?)";
	try(PreparedStatement statement = connection.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS)){
	    statement.setInt(1, Input.getUserID());
	    statement.setString(2, Input.getTheatreName());
	    statement.setString(3, Input.getAddress());
	    statement.executeUpdate();
	    ResultSet generatedValues = statement.getGeneratedKeys();
	    if(generatedValues.next()) {
		int theatreID = generatedValues.getInt(1);
		Input.setTheatreID(theatreID);
	    }
	    for(Screen screen : Input.getScreens()) {
		registerScreen(Input.getTheatreID(), screen);
	    }
	}
    }
    public void registerScreen (int theatreID, Screen screen) throws SQLException {
	String insertStatement = "INSERT INTO SCREEN (THEATRE_ID, SCREEN_NUMBER, ROW_COUNT, COLUMN_COUNT, FRONT_ROW_COUNT, BACK_ROW_COUNT, BALCONY_ROW_COUNT) VALUES (?, ?, ?, ?, ?, ?, ?)";
	try(PreparedStatement statement = connection.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS)){
	    statement.setInt(1, theatreID);
	    statement.setInt(2, screen.getScreanNumber());
	    statement.setInt(3, screen.getRow());
	    statement.setInt(4, screen.getColumn());
	    statement.setInt(5, screen.getFrontRows());
	    statement.setInt(6, screen.getBackRows());
	    statement.setInt(7, screen.getBolconyRows());
	    statement.executeUpdate();
	    ResultSet generatedValues = statement.getGeneratedKeys();
	    if(generatedValues.next()) {
		int screenID = generatedValues.getInt(1);
		screen.setScreenID(screenID);
	    }
	}
    }
    public void selectTheatre (User input) throws SQLException {
	String selectStatement = "SELECT A.THEATRE_ID, A.THEATRE_NAME, A.ADDRESS, B.SCREEN_ID, B.SCREEN_NUMBER, B.ROW_COUNT, B.COLUMN_COUNT, B.FRONT_ROW_COUNT, B.BACK_ROW_COUNT, B.BALCONY_ROW_COUNT FROM THEATRE A LEFT JOIN SCREEN B ON A.THEATRE_ID = B.THEATRE_ID WHERE A.OWNER_ID = ?";
	try(PreparedStatement statement = connection.prepareStatement(selectStatement)){
	    statement.setInt(1, input.getUserID());
	    ResultSet result = statement.executeQuery();
	    Map<Integer, Theatre> theatreIds = new HashMap<>(); 
	    while(result.next()) {
		Screen screen = new Screen();
		screen.setScreenID(result.getInt(4));
		screen.setScreanNumber(result.getInt(5));
		screen.setRow(result.getInt(6));
		screen.setColumn(result.getInt(7));
		screen.setFrontRows(result.getInt(8));
		screen.setBackRows(result.getInt(9));
		screen.setBolconyRows(result.getInt(10));
		int theatreId = result.getInt(1);
		Theatre theatre;
		if(theatreIds.containsKey(theatreId)) {
		    theatre = theatreIds.get(theatreId);
		}else {
		    theatre = new Theatre();
		    theatre.setTheatreID(theatreId);
		    theatre.setTheatreName(result.getString(2));
		    theatre.setAddress(result.getString(3));
		    theatre.setUserID(input.getUserID());
		    input.getTheatres().add(theatre);
		    theatreIds.put(theatreId, theatre);
		}
		screen.setTheatre(theatre);
		theatre.getScreens().add(screen);
	    }
	}
    }
    public void removeTheatre (int theatreID) throws SQLException {
	String deleteStatement = "DELETE FROM THEATRE WHERE THEATRE_ID = ?";
	try(PreparedStatement statement = connection.prepareStatement(deleteStatement)){
	    statement.setInt(1, theatreID);
	    statement.executeUpdate();
	}
    }
    public void addShow (int screenID, Show show) throws SQLException {
	String insertStatement = "INSERT INTO SHOWS (SCREEN_ID, MOVIE_NAME, START_TIME, END_TIME) VALUES (?, ?, ?, ?)";
	try(PreparedStatement statement = connection.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS)){
	    statement.setInt(1, screenID);
	    statement.setString(2, show.getMovieName());
	    statement.setLong(3, show.getStartTime());
	    statement.setLong(4, show.getEndTime());
	    statement.executeUpdate();
	    ResultSet generetedValues = statement.getGeneratedKeys();
	    if(generetedValues.next()) {
		show.setShowID(generetedValues.getInt(1));
	    }
	}
    }
    public void insertSeat (int showID, Seat seat) throws SQLException {
	String insertStatement = "INSERT INTO SEAT (SHOW_ID, SEAT_NUMBER, PRICE, BOOKING_STATE) VALUES (?, ?, ?, 0)";
	try(PreparedStatement statement = connection.prepareStatement(insertStatement)){
	    statement.setInt(1, showID);
	    statement.setInt(2, seat.getSeatNumber());
	    statement.setFloat(3, seat.getPrice());
	    statement.executeUpdate();
	}
    }
    public void cancelShow (int showID) throws SQLException {
	String deleteStatement = "DELETE FROM SHOWS WHERE SHOW_ID = ?";
	try(PreparedStatement statement = connection.prepareStatement(deleteStatement)){
	    statement.setInt(1, showID);
	    statement.executeUpdate();
	}
    }
    public List<Show> showShows (int screenID) throws SQLException {
	String selectStatement = "SELECT MOVIE_NAME, START_TIME, END_TIME, SHOW_ID FROM SHOWS WHERE SCREEN_ID = ?";
	List<Show> shows = new LinkedList<>();
	try(PreparedStatement statement = connection.prepareStatement(selectStatement)){
	    statement.setInt(1, screenID);
	    ResultSet result = statement.executeQuery();
	    while (result.next()) {
		Show show = new Show();
		show.setMovieName(result.getString(1));
		show.setStartTime(result.getLong(2));
		show.setEndTime(result.getLong(3));
		show.setShowID(result.getInt(4));
		shows.add(show);
	    }
	}
	return shows;
    }
    public List<TheatreScreen> selectTheatreScreen (User user) throws SQLException {
	String selectStatement = "SELECT A.THEATRE_NAME , B.SCREEN_ID, B.SCREEN_NUMBER FROM THEATRE A INNER JOIN SCREEN B WHERE A.OWNER_ID = ?";
	try(PreparedStatement statement = connection.prepareStatement(selectStatement)){
	    statement.setInt(1, user.getUserID());
	    ResultSet result = statement.executeQuery();
	    List<TheatreScreen> screenList = new LinkedList<>();
	    while (result.next()) {
		TheatreScreen temp = new TheatreScreen(result.getString(1), result.getInt(2), result.getInt(3));
		screenList.add(temp);
	    }
	    return screenList;
	}
    }
    
    public List<MovieShow> searchByMovie (String movieName) throws SQLException{
	String selectStatement = "SELECT THEATRE_NAME, SHOW_ID, MOVIE_NAME, START_TIME, END_TIME FROM THEATRE "
		+ "INNER JOIN SCREEN ON THEATRE.THEATRE_ID = SCREEN.THEATRE_ID "
		+ "INNER JOIN SHOWS ON SCREEN.SCREEN_ID = SHOWS.SCREEN_ID "
		+ "WHERE SHOWS.MOVIE_NAME = ?";
	PreparedStatement statement = connection.prepareStatement(selectStatement);
	statement.setString(1, movieName);
	return search(statement);
    }
    public List<MovieShow> searchByTheatre (String theatreName) throws SQLException{
	String selectStatement = "SELECT THEATRE_NAME, SHOW_ID, MOVIE_NAME, START_TIME, END_TIME FROM THEATRE "
		+ "INNER JOIN SCREEN ON THEATRE.THEATRE_ID = SCREEN.THEATRE_ID "
		+ "INNER JOIN SHOWS ON SCREEN.SCREEN_ID = SHOWS.SCREEN_ID "
		+ "WHERE THEATRE.THEATRE_NAME = ?";
	PreparedStatement statement = connection.prepareStatement(selectStatement);
	statement.setString(1, theatreName);
	return search(statement);
    }
    private List<MovieShow> search (PreparedStatement statement) throws SQLException{
	ResultSet result = statement.executeQuery();
	List<MovieShow> movieList = new LinkedList<>();
	while(result.next()) {
	    MovieShow movieShow = new MovieShow(result.getString(1), result.getInt(2), result.getString(3), result.getLong(4), result.getLong(5));
	    movieList.add(movieShow);
	}
	statement.close();
	return movieList;
    }
    
    public Screen getSeats (int showID) throws SQLException{
	String selectScreenStatement = "SELECT ROW_COUNT, COLUMN_COUNT, FRONT_ROW_COUNT, BACK_ROW_COUNT, BALCONY_ROW_COUNT FROM SCREEN "
		+ "INNER JOIN SHOWS ON SCREEN.SCREEN_ID = SHOWS.SCREEN_ID "
		+ "WHERE SHOWS.SHOW_ID = ?";
	Screen screen = new Screen();
	try(PreparedStatement statement = connection.prepareStatement(selectScreenStatement)){
	    statement.setInt(1, showID);
	    ResultSet result = statement.executeQuery();
	    while (result.next()) {
		screen.setRow(result.getInt(1));
		screen.setColumn(result.getInt(2));
		screen.setFrontRows(result.getInt(3));
		screen.setBackRows(result.getInt(4));
		screen.setBolconyRows(5);
	    }
	}
	Show show = new Show();
	show.setShowID(showID);
	screen.getShows().add(show);
	String selectSeatStatement = "SELECT SEAT_NUMBER, BOOKING_STATE, PRICE FROM SEAT WHERE SHOW_ID = ? ORDER BY SEAT_NUMBER";
	try(PreparedStatement statement = connection.prepareStatement(selectSeatStatement)){
	    statement.setInt(1, showID);
	    ResultSet result = statement.executeQuery();
	    while (result.next()) {
		Seat seat = new Seat();
		seat.setSeatNumber(result.getInt(1));
		seat.setBookingStates(result.getInt(2));
		seat.setPrice(result.getInt(3));
		show.getSeats().add(seat);
	    }
	}
	return screen;
    }
    public void bookSeat (int showID, int seatNumber,int bookingID) throws SQLException {
	String updateStatement = "UPDATE SEAT SET BOOKING_STATE = 1 WHERE SHOW_ID = ? AND SEAT_NUMBER = ?";
	String insertStatement = "INSERT INTO BOOKING_DETAILS (SHOW_ID, BOOKING_ID, SEAT_NUMBER) VALUES (?, ?, ?)";
	try(PreparedStatement statement = connection.prepareStatement(updateStatement)){
	    statement.setInt(1, showID);
	    statement.setInt(2, seatNumber);
	    statement.executeUpdate();
	}
	try(PreparedStatement statement = connection.prepareStatement(insertStatement)){
	    statement.setInt(1, showID);
	    statement.setInt(2, bookingID);
	    statement.setInt(3, seatNumber);
	    statement.executeUpdate();
	}
    }
    public int getBooingID () throws SQLException {
	String selectStatement = "SELECT ID FROM ID_GENARATOR";
	String updateStatement = "UPDATE ID_GENARATOR SET ID = ?";
	String insertStatement = "INSERT INTO ID_GENARATOR (ID) VALUES (2)";
	int id = 0;
	try(PreparedStatement statement = connection.prepareStatement(selectStatement)){
	    ResultSet result = statement.executeQuery();
	    if(result.next()) {
		id = result.getInt(1);
		try(PreparedStatement statement1 = connection.prepareStatement(updateStatement)){
		    statement1.setInt(1, id + 1);
		    statement1.executeUpdate();
		}
	    }else {
		id = 1;
		try(PreparedStatement statement1 = connection.prepareStatement(insertStatement)){
		    statement1.executeUpdate();
		}
	    }
	}
	return id;
    }
    public void cancelBooking (int bookingID) throws SQLException {
	String selectStatement = "SELECT SHOW_ID, SEAT_NUMBER FROM BOOKING_DETAILS WHERE BOOKING_ID = ?";
	String updateStatement = "UPDATE SEAT SET BOOKING_STATE = 0 WHERE SHOW_ID = ? AND SEAT_NUMBER = ?";
	try(PreparedStatement statement = connection.prepareStatement(selectStatement)){
	    statement.setInt(1, bookingID);
	    ResultSet result = statement.executeQuery();
	    int showID;
	    int seatNumber;
	    try(PreparedStatement statement1 = connection.prepareStatement(updateStatement)){
		while(result.next()) {
		    showID = result.getInt(1);
		    seatNumber = result.getInt(2);
		    statement1.setInt(1, showID);
		    statement1.setInt(2, seatNumber);
		    statement1.executeUpdate();
		}
	    }
	}
    }
}
