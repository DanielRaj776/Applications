package view;

import java.util.List;

import controller.Compute;
import model.Bater;
import model.Bowller;
import model.Team;
import repository.MatchInformation;

public class Display {
    MatchInformation matchInformation = null;
    
    public Display() {
	matchInformation = MatchInformation.getInstence();
    }
    
    public void displayMatchInformations () {
	String winner = matchInformation.getTeam1().getTotalRun() > matchInformation.getTeam2().getTotalRun() ? matchInformation.getTeam1().getName() : matchInformation.getTeam2().getName();
	System.out.println(winner + " is won the match");
	System.out.println("First team score");
	displayTeamScore(matchInformation.getTeam1());
	System.out.println("Second team score");
	displayTeamScore(matchInformation.getTeam2());
    }
    private void displayTeamScore (Team team) {
	System.out.println(team.getName() + " - " + team.getTotalRun() + "/" + team.getWicket());
	List<Bater> baters = team.getBaters();
	System.out.println("Batting");
	System.out.println("-------");
	for(Bater bater : baters) {
	    String temp = bater.getName();
	    if(!bater.isOut())
		temp += "*";
	    System.out.println(temp + " - " + bater.getRun() + " runs (" + bater.getBall() + " balls)");
	}
	System.out.println("Innings Extras " + team.getExtras());
	List<Bowller	> bowllers = team.getBowllers();
	System.out.println("Bowling");
	System.out.println("-------");
	for(Bowller bowller : bowllers) {
	    System.out.println(bowller.getName() + " - " + bowller.getBall() / 6 + "." + bowller.getBall()%6 + "overs - " + bowller.getRun() + "/" + bowller.getWicket());
	}
	System.out.println("Player state");
	System.out.println("------------");
	Compute compute = new Compute();
	for(Bater bater : baters) {
	    System.out.println(bater.getName() + " - " + bater.getRun() + "(" + bater.getBall() + ") " + " SR " + compute.strikeRate(bater.getRun(), bater.getBall()) + " - C " + compute.baterContribution(bater.getRun(), team.getTotalRun()));;
	}
	for(Bowller bowller : bowllers) {
	    System.out.println(bowller.getName() + " - " + bowller.getRun() + "/" + bowller.getWicket() + "(" + bowller.getBall()/6 + "." + bowller.getBall()%6 + ") - W " + bowller.getWicket() + " - C " + compute.bowlerContribution(bowller.getWicket()));
	}
	System.out.println("---------------------------------------------");
    }
}
