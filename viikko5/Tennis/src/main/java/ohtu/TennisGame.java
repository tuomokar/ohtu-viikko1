package ohtu;

public class TennisGame {

    private Player player1;
    private Player player2;
    private Statistics statistics;

    public TennisGame(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
        this.statistics = new Statistics(player1Name, player2Name);
    }

    public void wonPoint(String playerName) {
        statistics.addPoint(playerName);
    }

    public String getScore() {
        if (statistics.tie()) {
            return statistics.getTieResults();           
        } else if (statistics.pointsMoreThanThree()) {
            return statistics.getResultsWhenPlayerHasMoreThan3Points();
        }
        
        return statistics.getResults();
    }
}
