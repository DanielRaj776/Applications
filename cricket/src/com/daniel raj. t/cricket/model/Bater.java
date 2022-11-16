package model;

public class Bater {
    private int run;
    private int ball;
    private boolean isOut;
    private String name;
    public Bater(String name) {
	setName(name);
	this.run = 0;
	this.ball = 0;
	this.isOut = false;
    }
    
    public int getRun() {
        return run;
    }
    public void setRun(int run) {
        this.run = run;
    }
    public int getBall() {
        return ball;
    }
    public void setBall(int ball) {
        this.ball = ball;
    }
    public boolean isOut() {
        return isOut;
    }
    public void setOut(boolean isOut) {
        this.isOut = isOut;
    }
    public String getName() {
	return name;
    }
    public void setName(String name) {
	this.name = name;
    }
}
