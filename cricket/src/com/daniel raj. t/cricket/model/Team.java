package model;

import java.util.List;

public class Team {
    private String name;
    private int totalRun;
    private int wicket;
    private int extras;
    private List<Bater> baters;
    private List<Bowller> bowllers;
    
    public Team(String name) {
	this.totalRun = 0;
	this.wicket = 0;
	this.extras = 0;
	this.baters = null;
	this.bowllers = null;
	this.name = name;
    }
    
    public String getName() {
	return name;
    }
    public void setName(String name) {
	this.name = name;
    }
    public int getTotalRun() {
        return totalRun;
    }
    public void setTotalRun(int totalRun) {
        this.totalRun = totalRun;
    }
    public int getWicket() {
        return wicket;
    }
    public void setWicket(int wicket) {
        this.wicket = wicket;
    }
    public int getExtras() {
        return extras;
    }
    public void setExtras(int extras) {
        this.extras = extras;
    }
    public List<Bater> getBaters() {
        return baters;
    }
    public void setBaters(List<Bater> baters) {
        this.baters = baters;
    }
    public List<Bowller> getBowllers() {
        return bowllers;
    }
    public void setBowllers(List<Bowller> bowllers) {
        this.bowllers = bowllers;
    }
}
