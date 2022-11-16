package model;

public class Bowller {
    private int ball;
    private int run;
    private int wicket;
    private String name;
    
    public Bowller(String name) {
	this.ball = 0;
	this.run = 0;
	this.wicket = 0;
	setName(name);
    }
    
    public int getBall() {
        return ball;
    }
    public void setBall(int ball) {
        this.ball = ball;
    }
    public int getRun() {
        return run;
    }
    public void setRun(int run) {
        this.run = run;
    }
    public int getWicket() {
        return wicket;
    }
    public void setWicket(int wicket) {
        this.wicket = wicket;
    }
    public String getName() {
	return name;
    }
    public void setName(String name) {
	this.name = name;
    }
}
