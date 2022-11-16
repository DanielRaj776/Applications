package controller;

import java.util.LinkedList;
import java.util.Queue;

import model.Bater;
import model.Bowller;
import model.Team;
import repository.MatchInformation;
import view.Display;

public class Match {
    MatchInformation matchInformation = null;
    
    public Match() {
	matchInformation = MatchInformation.getInstence();
    }
    
    private Queue<String> innings (Queue<String> input, Team battingTeam, Team bowllingTeam) {
	int wicket = 0;
	int overs = 0;
	Bater[] baters = {battingTeam.getBaters().get(0), battingTeam.getBaters().get(1)};
	Bowller bowller;
	int bowlerIndex = 0;
	int baterIndex = 0;
	for(String over : input) {
	    String[] balls = over.split(",");
	    overs++;
	    bowller = bowllingTeam.getBowllers().get(bowlerIndex);
	    for(String ball : balls) {
		ball = ball.trim();
		if(ball.length() == 1) {
		    if(ball.equalsIgnoreCase("w")) {
			wicket++;
			bowller.setWicket(bowller.getWicket() + 1);
			baters[baterIndex].setOut(true);
			baters[baterIndex].setBall(baters[baterIndex].getBall() + 1);
			battingTeam.setWicket(battingTeam.getWicket() + 1);
			if(wicket == 2) {
			    break;
			}else {
			    baters[baterIndex] = battingTeam.getBaters().get(2);
			}
		    }else {
			int run = Integer.parseInt(ball);
			baters[baterIndex].setRun(baters[baterIndex].getRun() + run);
			baters[baterIndex].setBall(baters[baterIndex].getBall() + 1);
			bowller.setRun(bowller.getRun() + run);
			battingTeam.setTotalRun(battingTeam.getTotalRun() + run);
			if(run % 2 != 0) {
			    baterIndex = switchPositions(baterIndex);
			}
		    }
		    bowller.setBall(bowller.getBall() + 1);
		}else {
		    String runString = "" + ball.charAt(0);
		    int run = Integer.parseInt(runString);
		    baters[baterIndex].setBall(baters[baterIndex].getBall()+ 1);
		    bowller.setRun(bowller.getRun() + run + 1);
		    battingTeam.setTotalRun(battingTeam.getTotalRun() + run + 1);
		    battingTeam.setExtras(battingTeam.getExtras() + run + 1);
		    if(run % 2 == 1) {
			baterIndex = switchPositions(baterIndex);
		    }
		}
	    }
	    bowlerIndex = switchPositions(bowlerIndex);
	    baterIndex = switchPositions(baterIndex);
	    if(wicket == 2 || overs == 5) {
		break;
	    }
	}
	Queue<String> temp = new LinkedList<>(input);
	for(int i = 0; i < overs; i++) {
	    temp.poll();
	}
	return temp;
    }
    
    private int switchPositions (int position) {
    	if(position == 1) {
    	    return 0;
    	}else {
    	    return 1;
    	}
    }
    
    private void start (Queue<String> input) {
	input = innings(input,matchInformation.getTeam1(), matchInformation.getTeam2());
	innings(input, matchInformation.getTeam2(), matchInformation.getTeam1());
	new Display().displayMatchInformations();
    }
    
    public void setTeams (Queue<String> input){
	String[] teamNames = input.poll().split(",");
	Team team1 = new Team(teamNames[0].trim());
	Team team2 = new Team(teamNames[1].trim());
	String[] teamPlayers = input.poll().split(",");
	setPlayers(team1, teamPlayers);
	teamPlayers = input.poll().split(",");
	setPlayers(team2, teamPlayers);
	matchInformation.setTeam1(team1);
	matchInformation.setTeam2(team2);
	start(input);
    }
    
    private void setPlayers (Team team, String[] teamPlayers) {
	LinkedList<Bater> baters = new LinkedList<>();
	LinkedList<Bowller> bowllers = new LinkedList<>();
	for(int i = 0, j = teamPlayers.length - 1; i < 3; i++, j--) {
	    if(i == 2) {
		baters.add(new Bater(teamPlayers[i].trim()));
	    }else {
		baters.add(new Bater(teamPlayers[i].trim()));
		bowllers.add(new Bowller(teamPlayers[j].trim()));
	    }
	}
	team.setBaters(baters);
	team.setBowllers(bowllers);
    }
}
