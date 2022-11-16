package presentation;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import controller.TheatreManager;
import controller.UserManager;
import model.MovieShow;
import model.Screen;
import model.Seat;
import model.Show;
import model.Theatre;
import model.TheatreScreen;
import model.User;

public class Display {
    private Input input = new Input();
    private UserManager userManager = new UserManager();
    private TheatreManager theatreManager = new TheatreManager(); 
	    
    public int getSelectedOption(List<String> options, String prompt) {
	int count = 1;
	for(String option: options) {
	    System.out.println(count + "."  + option);
	    count++;
	}
	System.out.print(prompt);
	int selectedOption;
	do {
	    selectedOption = (int)input.numberInput(prompt);
	    if(!(selectedOption > 0 && selectedOption <= options.size())) {
		System.out.println("invalid input");
		System.out.print(prompt);
	    }
	} while (!(selectedOption > 0 && selectedOption <= options.size()));
	return selectedOption;
    }
    
    public void userSignIn (String prompt) {
	System.out.println("Sign In");
	System.out.println("Enter Name");
	System.out.print(prompt);
	String name = input.nameInput(prompt);
	System.out.println("Enter Password");
	System.out.print(prompt);
	String password = input.stringInput(prompt);
	User user = new User();
	user.setName(name);
	user.setPassword(password);
	if(userManager.signIn(user)) {
	    theatreManagementOption(prompt, user);
	}else {
	    System.out.println("Worng User Name Or Password");
	    userSignIn(prompt);
	}
    }
    public void userSignUp (String prompt) {
	System.out.println("Sign Up");
	System.out.println("Enter Name");
	System.out.print(prompt);
	String name;
	do {
	    name = input.nameInput(prompt);
	    if(name.length() > 30)
		System.out.println("Only 30 Characters Are Allowed \n Try Again");
	} while (name.length() > 30);
	System.out.println("Enter Contact Number");
	System.out.print(prompt);
	String contactNumber;
	do {
	    contactNumber = "" + input.numberInput(prompt);
	    if(contactNumber.length() > 15)
		System.out.println("Only 15 Digits Are Allowed \n Try Again");
	}while(contactNumber.length() > 15);
	System.out.println("Enter Password");
	System.out.print(prompt);
	String password;
	do {
	    password = input.stringInput(prompt);
	    if(password.length() > 20)
		System.out.println("Only 20 Character Are Allowed \n Try Again");
	} while (password.length() > 20);
	User owner = new User();
	owner.setName(name);
	owner.setContactNumber(contactNumber);
	owner.setPassword(password);
	owner =  userManager.signUp(owner);
	theatreManagementOption(prompt, owner);
    }
    private void theatreManagementOption (String prompt, User user) {
	List<String> managementOption = Arrays.asList("View Theatres", "Register Theatre", "Remove Theatre", "View Shows", "Add Show", "Cancel Show", "Exit");
	System.out.println("Manage Theatre");
	int selectedOption = getSelectedOption(managementOption, prompt);
	switch (selectedOption) {
	case 1:
	    viewTheatre(user);
	    user.getTheatres().clear();
	    theatreManagementOption(prompt, user);
	    break;
	case 2:
	    registerTheatre(user, prompt);
	    user.getTheatres().clear();
	    theatreManagementOption(prompt, user);
	    break;
	case 3:
	    removeTheatre(prompt);
	    theatreManagementOption(prompt, user);
	    break;
	case 4:
	    viewShow(user, prompt);
	    theatreManagementOption(prompt, user);
	    break;
	case 5:
	    System.out.println("Select Theatre");
	    theatreManager.viewTheatres(user);
	    List<String> theatreNamelist = new LinkedList<>();
	    for(Theatre theatre : user.getTheatres()) {
		theatreNamelist.add(theatre.getTheatreName());
	    }
	    selectedOption = getSelectedOption(theatreNamelist, prompt);
	    addShow(user.getTheatres().get(selectedOption - 1), prompt);
	    theatreManagementOption(prompt, user);
	    break;
	case 6:
	    cancelShow(prompt);
	    theatreManagementOption(prompt, user);
	    break;
	case 7:
	    return;
	}
    }
    
    private void registerTheatre (User user, String prompt) {
	    System.out.println("Register Theatre");
	    System.out.println("Enter Theatre Name");
	    System.out.print(prompt);
	    String name = "";
	    do {
		name = input.stringInput(prompt);
		if(name.length() > 30)
			System.out.println("Only 30 Character Are Allowed \n Try Again");
	    } while (name.length() > 30);
	    System.out.println("Enter Theatre Address");
	    System.out.print(prompt);
	    String address = "";
	    do {
		address = input.stringInput(prompt);
		if(address.length() > 255)
		    System.out.println("Only 255 Character Are Allowed \n Try Again");
	    } while (address.length() > 255);
	    Theatre theatre = new Theatre();
	    theatre.setTheatreName(name);
	    theatre.setAddress(address);
	    theatre.setUserID(user.getUserID());
	    System.out.println("Enter Number Of Screens In Theatre");
	    System.out.print(prompt);
	    int noOfScreens = (int)input.numberInput(prompt);
	    for(int i = 0; i < noOfScreens; i++) {
		addScreen(theatre, prompt);
	    }
	    theatreManager.registerTheatre(theatre);
    }
    private void removeTheatre (String prompt) {
	System.out.println("Enter Theatre ID");
	System.out.print(prompt);
	theatreManager.removeTheatre((int)input.numberInput(prompt));
    }
    private void addScreen (Theatre theatre, String prompt) {
	Screen screen = new Screen();
	System.out.println("Enter Screen Number");
	System.out.print(prompt	);
	int screenNumber;
	do {
	    screenNumber = (int)input.numberInput(prompt);
	    if(screenNumber > 255)
		System.out.println("Max Is 255");
	} while (screenNumber > 255);
	System.out.println("Enter Number Of Seats In A Row");
	System.out.print(prompt);
	int column;
	do {
	    column = (int)input.numberInput(prompt);
	    if(column > 255)
		System.out.println("Max Is 255");
	} while (column > 255);
	System.out.println("Enter Number Of Fornt Rows");
	System.out.print(prompt);
	int forntRow;
	do {
	    forntRow = (int)input.numberInput(prompt);
	    if(forntRow > 255)
		System.out.println("Max Is 255");
	} while (forntRow > 255);
	System.out.println("Enter Number Of Back Rows");
	System.out.print(prompt);
	int backRow;
	do {
	    backRow = (int)input.numberInput(prompt);
	    if(backRow > 255)
		System.out.println("Max Is 255");
	} while (backRow > 255);
	System.out.println("Enter Number Of Bolcony Rows");
	System.out.print(prompt);
	int balconyRow;
	do {
	    balconyRow = (int)input.numberInput(prompt);
	    if(balconyRow > 255)
		System.out.println("Max Is 255");
	}while (balconyRow > 255);
	screen.setScreanNumber(screenNumber);
	screen.setColumn(column);
	screen.setFrontRows(forntRow);
	screen.setBackRows(backRow);
	screen.setBolconyRows(balconyRow);
	screen.setTheatre(theatre);
	theatre.getScreens().add(screen);
    }
    private void viewTheatre (User user) {
	theatreManager.viewTheatres(user);
	for(Theatre theatre : user.getTheatres()) {
	    System.out.println("Theatre");
	    System.out.printf("%-12s %-30s %-100s\n", "Theatre ID", "Name", "Address");
	    System.out.printf("%-12d %-30s %-100s\n", theatre.getTheatreID(), theatre.getTheatreName(), theatre.getAddress());
	    System.out.printf("%-13s | %-4s | %-7s | %-10s | %-9s | %-12s |\n", "Screen Number", "Rows", "Columns", "Front Rows", "Back Rows", "Bolcony Rows");
	    for(Screen screen : theatre.getScreens()) {
		System.out.printf("%-13d | %-4d | %-7d | %-10d | %-9d | %-12d |\n", screen.getScreanNumber(), screen.getRow(), screen.getColumn(), screen.getFrontRows(), screen.getBackRows(), screen.getBolconyRows());
	    }
	    System.out.println();
	}
    }
    private void addShow (Theatre theatre, String prompt) {	
	System.out.println("Select screen");
	List<String> screenNumberList = new LinkedList<>();
	for(Screen screen : theatre.getScreens()) {
	    screenNumberList.add("" + screen.getScreanNumber());
	}
	int selectedOption = getSelectedOption(screenNumberList, prompt);
	Screen screen = theatre.getScreens().get(selectedOption - 1);
	Show show = new Show();
	System.out.println("Enter the movie Name");
	System.out.print(prompt);
	String movieName = input.stringInput(prompt);
	String date = "";
	String startTime = "";
	String endTime = "";
	long startTimeMilli = 0;
	long endTimeMilli = 0;
	ZonedDateTime zonedDateTime;
	do {
	    System.out.println("Enter Show Date (YYYY-MM-DD)");
	    System.out.print(prompt);
	    date = input.dateInput(prompt);
	    System.out.println("Enter Show Start Time (HH:MM:SS)");
	    System.out.print(prompt);
	    String time = input.timeInput(prompt);
	    startTime += date + "T" + time + ".000+05:30";
	    zonedDateTime = ZonedDateTime.parse(startTime);
	    startTimeMilli = zonedDateTime.toInstant().toEpochMilli();
	    if(startTimeMilli < Instant.now().toEpochMilli())
		System.out.println("The Date And Time Is Already Pased, Try Agine");
	}while(startTimeMilli < Instant.now().toEpochMilli());
	do {
	    System.out.println("Enter Show End Time (HH:MM:SS)");
	    System.out.print(prompt);
	    String time = input.timeInput(prompt);
	    endTime += date + "T" + time + ".000+05:30";
	    zonedDateTime = ZonedDateTime.parse(endTime);
	    endTimeMilli = zonedDateTime.toInstant().toEpochMilli();
	    if(startTimeMilli > endTimeMilli)
		System.out.println("Enter A Value Bigger Than The Start Time");
	}while (startTimeMilli > endTimeMilli);
	show.setMovieName(movieName);
	show.setStartTime(startTimeMilli);
	show.setEndTime(endTimeMilli);
	theatreManager.addShow(screen.getScreenID(), show);
	float frontRowPrice = 0;
	float backRowPrice = 0;
	float bolconyRowPrice = 0;
	System.out.println("Enter Front Row Seat Price");
	do {
	    System.out.print(prompt);
	    frontRowPrice = input.numberInput(prompt);
	    if(frontRowPrice > 99999)
		System.out.println("Enter A Value smaller then 99999");
	} while (frontRowPrice > 99999);
	System.out.println("Enter Back Row Seat Price");
	do {
	    System.out.print(prompt);
	    backRowPrice = input.numberInput(prompt);
	    if(backRowPrice > 99999)
		System.out.println("Enter A Value smaller then 99999");
	} while (backRowPrice > 99999);
	System.out.println("Enter Bolcony Row Seat Price");
	do {
	    System.out.print(prompt);
	    bolconyRowPrice = input.numberInput(prompt);
	    if(bolconyRowPrice > 99999)
		System.out.println("Enter A Value smaller then 99999");
	} while (bolconyRowPrice > 99999);
	theatreManager.addSeat(show.getShowID(), screen, frontRowPrice, backRowPrice, bolconyRowPrice);
    }
    private void cancelShow (String prompt) {
	System.out.println("Enter Show ID");
	System.out.print(prompt);
	theatreManager.cancelShow((int)input.numberInput(prompt));
    }
    private void viewShow (User user, String prompt) {
	List<TheatreScreen> theatreScreens = theatreManager.viewTheatreScreen(user);
	List<String> options = new LinkedList<>();
	for(TheatreScreen theatreScreen : theatreScreens) {
	    options.add(String.format("%-30s  %-6d" , theatreScreen.getTheatreName(), theatreScreen.getScreenNumber()));
	}
	options.add("Exit");
	int selectedOption = getSelectedOption(options, prompt);
	if(selectedOption == options.size()) {
	    return;
	}else {
	    int screenID = theatreScreens.get(selectedOption - 1).getScreenID();
	    List<Show> searchResult = theatreManager.viewShow(screenID);
	    System.out.printf("%-7s %-30s %-24s %-24s\n", "show ID", "Movie Name", "Start Time", "End Time");
	    for(Show show : searchResult) {
		System.out.printf("%-7d %-30s %-24s %-24s\n", show.getShowID(), show.getMovieName(), show.getStartDateTime(), show.getEndDateTime());
	    }
	}
    }
    
    public void search (String prompt) {
	System.out.println("Search");
	List<String> searchOptions = Arrays.asList("By Theatre", "By Movie");
	int selectedOption = getSelectedOption(searchOptions, prompt);
	switch (selectedOption) {
	case 1:{
	    System.out.println("Enter Theatre Name");
	    System.out.print(prompt);
	    List<MovieShow> searchResult = theatreManager.searchByTheatre(input.stringInput(prompt));
	    List<String> stringSearchResult = new LinkedList<>();
	    for (MovieShow movieShow : searchResult) {
		stringSearchResult.add(String.format("%-30s %-30s %-24s to %-24s", movieShow.getTheatreName(), movieShow.getMovieName(), movieShow.getStartDateTime(), movieShow.getEndDateTime()));
	    }
	    stringSearchResult.add("Exit");
	    int selectedMovieOption = getSelectedOption(stringSearchResult, prompt);
	    if(selectedMovieOption == stringSearchResult.size()) {
		return;
	    }else {
		bookingShow(searchResult.get(selectedMovieOption - 1).getShowID(), prompt);
	    }
	    break;
	}
	case 2:{
	    System.out.println("Enter Movie Name");
	    System.out.print(prompt);
	    List<MovieShow> searchResult = theatreManager.searchByMovie(input.stringInput(prompt));
	    List<String> stringSearchResult = new LinkedList<>();
	    for (MovieShow movieShow : searchResult) {
		stringSearchResult.add(String.format("%-30s %-30s %-24s to %-24s", movieShow.getMovieName(), movieShow.getTheatreName(), movieShow.getStartDateTime(), movieShow.getEndDateTime()));
	    }
	    stringSearchResult.add("Exit");
	    int selectedMovieOption = getSelectedOption(stringSearchResult, prompt);
	    if(selectedMovieOption == stringSearchResult.size()) {
		return;
	    }else {
		bookingShow(searchResult.get(selectedMovieOption - 1).getShowID(), prompt);
	    }
	}
	break;
	}
    }
    private void bookingShow (int Show_id,String prompt) {
	Screen screen = theatreManager.getSeats(Show_id);
	int row = screen.getRow();
	int column = screen.getColumn();
	int frontRow = screen.getFrontRows();
	int backRow = screen.getBackRows();
	int bolconyRow = screen.getBolconyRows();
	float frontRowPrice = 0;
	float backRowPrice = 0;
	float bolconyRowPrice = 0;
	List<Seat> seats = screen.getShows().get(0).getSeats();
	Seat seat = null;
	int index = 0;
	for(int i = 1; i <= row; i++) {
	    System.out.print(i + "\t");
	    for(int j = 1; j <= column; j++) {
		seat = seats.get(index++);
		if(i < frontRow) {
		    frontRowPrice = seat.getPrice();
		}else if(i < frontRow + backRow) {
		    backRowPrice = seat.getPrice();
		}else if(i < frontRow + backRow + bolconyRow) {
		    bolconyRowPrice = seat.getPrice();
		}
		if(seat.getBookingStates() == 1) {
		    System.out.printf("%-5s ", 'B');
		}else {
		    System.out.printf("%-5d ", seat.getSeatNumber());
		}
	    }
	    System.out.println();
	}
	System.out.println();
	System.out.printf("front %d to %d \t back %d to %d \t bolcony %d to %d\n", 1, frontRow, frontRow + 1, frontRow + backRow, frontRow + backRow + 1, frontRow + backRow + bolconyRow);
	System.out.printf("front %7.2f \t back %7.2f \t bolcony %7.2f", frontRowPrice, backRowPrice, bolconyRowPrice);
	System.out.println();
	System.out.println("Enter The Number Of Seats You Want To Book");
	System.out.print(prompt);
	int numberOfSeats = (int)input.numberInput(prompt);
	List<Integer> seatNumbers = new LinkedList<>();
	int seatNumber = 0;
	for(int i = 0; i < numberOfSeats; i++) {
	    System.out.println("Seat Number " + (i + 1));
	    System.out.print(prompt);
	    do {
		seatNumber = (int)input.numberInput(prompt);
		if(!(seatNumber > 0 && seatNumber <= row * column)) {
		    System.out.println("Enter A Valid Seat Number");
		}
		seatNumbers.add(seatNumber);
	    }while (!(seatNumber > 0 && seatNumber <= row * column));
	}
	int[] result =theatreManager.bookSeats( screen.getShows().get(0),seatNumbers);
	System.out.printf("RS : %d\n", result[0]);
	System.out.printf("Your Booking id : %d\n", result[1]);
    }
    public void cancelBooking (String prompt) {
	System.out.println("Enter Booking ID");
	System.out.print(prompt);
	int bookingID = (int)input.numberInput(prompt);
	theatreManager.cancelBooking(bookingID);
    }
    
}
