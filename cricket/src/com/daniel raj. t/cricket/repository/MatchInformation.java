package repository;

import model.Team;

public class MatchInformation {
    private static MatchInformation matchInformation = null;
    private Team team1= null;
    private Team team2 = null;
    
    private MatchInformation() {    }
    
    public static MatchInformation getInstence () {
	if(matchInformation == null) {
	    matchInformation = new MatchInformation();
	}
	return matchInformation;
    }

    public Team getTeam1() {
        return team1;
    }
    public void setTeam1(Team team1) {
        this.team1 = team1;
    }
    public Team getTeam2() {
        return team2;
    }
    public void setTeam2(Team team2) {
        this.team2 = team2;
    }
}
