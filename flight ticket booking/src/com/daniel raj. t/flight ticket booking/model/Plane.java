package model;

import java.util.List;

public class Plane {
    private int flightNo;
    private String name;
    private int dapatureTime;
    private int arrivalTime;
    private int travelTime;
    private int fare;
    private int seats;
    private int bookedSeats;
    private List<String> route;

    public Plane(int flightNo, String name, int dapatureTime, int arrvalTime, int travelTime, int fare, int seats, List<String> route) {
	this.flightNo = flightNo;
	this.name = name;
	this.dapatureTime = dapatureTime;
	this.arrivalTime = arrvalTime;
	this.travelTime = travelTime;
	this.fare = fare;
	this.seats = seats;
	this.bookedSeats = 0;
	this.route = route;
    }
    
    public Plane() {
	flightNo = -1;
	name = "";
	dapatureTime = -1;
	arrivalTime = -1;
	travelTime = -1;
	fare = -1;
	seats = 0;
	bookedSeats = 0;
	route = null;
    }
    
    public int getFlightNo() {
        return flightNo;
    }
    public void setFlightNo(int flightNo) {
        this.flightNo = flightNo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getDapatureTime() {
        return dapatureTime;
    }
    public void setDapatureTime(int dapatureTime) {
        this.dapatureTime = dapatureTime;
    }
    public int getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public int getTravelTime() {
        return travelTime;
    }
    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }
    public int getFare() {
        return fare;
    }
    public void setFare(int fare) {
        this.fare = fare;
    }
    public int getSeats() {
        return seats;
    }
    public void setSeats(int seats) {
        this.seats = seats;
    }
    public int getBookedSeats() {
        return bookedSeats;
    }
    public void setBookedSeats(int bookedSeats) {
        this.bookedSeats = bookedSeats;
    }
    public List<String> getRoute() {
        return route;
    }
    public void setRoute(List<String> route) {
        this.route = route;
    }
}
