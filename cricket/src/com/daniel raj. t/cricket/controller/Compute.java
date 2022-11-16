package controller;

public class Compute {
    public float strikeRate (int run, int balls) {
	return (run  * 100f) / balls;
    }
    public float baterContribution (int playerRun, int totalRun) {
	return (playerRun * 100f) / totalRun;
    }
    public float bowlerContribution (int wicket) {
	return wicket * 100 / 2f;
    }
}
