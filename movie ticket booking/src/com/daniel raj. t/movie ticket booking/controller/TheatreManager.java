package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.MovieShow;
import model.Screen;
import model.Seat;
import model.Show;
import model.Theatre;
import model.TheatreScreen;
import model.User;
import persistence.TheatreCRUD;

public class TheatreManager {
    private TheatreCRUD crud = new TheatreCRUD();
    
    public void registerTheatre (Theatre input) {
	for(Screen screen : input.getScreens()) {
	    screen.setRow(screen.getFrontRows() + screen.getBackRows() + screen.getBolconyRows());
	}
	try {
	    crud.registerTheatre(input);
	} catch (SQLException e) {
	    System.out.println("A Problem Has Occurred Please Try Again");
	}
    }
    public void viewTheatres (User input) {
	try {
	    crud.selectTheatre(input);
	} catch (SQLException e) {
	    System.out.println("A Problem Has Occurred Please Try Again");
	}
    }
    public List<String> getTheatreNames (User input) {
	List<String> theatreNames = new ArrayList<>();
	try {
	    crud.selectTheatre(input);
	} catch (SQLException e) {
	    System.out.println("A Problem Has Occurred Please Try Again");
	}
	for(Theatre theatre : input.getTheatres()) {
	    theatreNames.add(theatre.getTheatreName());
	}
	return theatreNames;
    }
    public void removeTheatre (int theatreID) {
	try {
	    crud.removeTheatre(theatreID);
	} catch (SQLException e) {
	    System.out.println("A Problem Has Occurred Please Try Again");
	}
    }
    public void addShow (int screenID, Show show) {
	try {
	    crud.addShow(screenID, show);
	} catch (SQLException e) {
	    System.out.println("A Problem Has Occurred Please Try Again");
	}
    }
    public void addSeat (int showID, Screen screen, float frontRowPrice, float backRowPrice, float bolcanyRowPrice) {
	Seat seat = new Seat();
	int seatNumber = 1;
	int lastFrontSeatNumber = screen.getColumn() * screen.getFrontRows();
	int lastBackSeatNumber = lastFrontSeatNumber + (screen.getBackRows() * screen.getColumn());
	int lastBolconySeatNumber = lastBackSeatNumber + (screen.getBolconyRows() * screen.getColumn());
	float price = frontRowPrice;
	while(seatNumber <= lastBolconySeatNumber) {
	    seat.setSeatNumber(seatNumber);
	    seat.setPrice(price);
	    try {
		crud.insertSeat(showID, seat);
	    } catch (SQLException e) {
		System.out.println("A Problem Has Occurred Please Try Again");
	    }
	    seatNumber++;
	    if(seatNumber > lastBackSeatNumber) {
		price = bolcanyRowPrice;
	    }else if(seatNumber > lastFrontSeatNumber) {
		price = backRowPrice;
	    }
	}
    }
    public void cancelShow (int showID) {
	try {
	    crud.cancelShow(showID);
	} catch (SQLException e) {
	    System.out.println("A Problem Has Occurred Please Try Again");
	}
    }
    public List<MovieShow> searchByMovie (String movieName){
	List<MovieShow> result = null;
	try {
	    result = crud.searchByMovie(movieName);
	} catch (SQLException e) {
	    System.out.println("A Problem Has Occurred Please Try Again");
	}
	return result;
    }
    public List<MovieShow> searchByTheatre (String TheatreName){
	List<MovieShow> result = null;
	try {
	    result = crud.searchByTheatre(TheatreName);
	} catch (SQLException e) {
	    System.out.println("A Problem Has Occurred Please Try Again");
	}
	return result;
    }
    public Screen getSeats (int showID) {
	Screen screen = null;
	try {
	    screen = crud.getSeats(showID);
	} catch (SQLException e) {
	    System.out.println("A Problem Has Occurred Please Try Again");
	}
	return screen;
    }
    public int[] bookSeats (Show show, List<Integer> seatNumbers) {
	int price = 0;
	int showID = show.getShowID();
	int bookingID = 0;
	try {
	    bookingID = crud.getBooingID();
	} catch (SQLException e1) {
	}
	List<Seat> seats = show.getSeats();
	for(int x : seatNumbers) {
	    try {
		crud.bookSeat(showID, x, bookingID);
	    } catch (SQLException e) {
		System.out.println("A Problem Has Occurred Please Try Again");
	    }
	    price += seats.get(x - 1).getPrice();
	}
	return new int[] {price, bookingID};
    }
    public void cancelBooking (int bookingID) {
	try {
	    crud.cancelBooking(bookingID);
	} catch (SQLException e) {
	    System.out.println("A Problem Has Occurred Please Try Again");
	}
    }
    public List<TheatreScreen> viewTheatreScreen (User user){
	List<TheatreScreen> result = null;
	try {
	    result = crud.selectTheatreScreen(user);
	} catch (SQLException e) {
	    System.out.println("A Problem Has Occurred Please Try Again");
	}
	return result;
    }
    public List<Show> viewShow(int ScreenID) {
	List<Show> result = null;
	try {
	    result = crud.showShows(ScreenID);
	} catch (SQLException e) {
	    System.out.println("A Problem Has Occurred Please Try Again");
	}
	return result;
    }
}
