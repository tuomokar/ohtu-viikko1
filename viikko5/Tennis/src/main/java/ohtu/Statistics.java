
package ohtu;

import java.util.HashMap;
import java.util.Map;

public class Statistics {
    
    private Player player1;
    private Player player2;
    private Map<Integer, String> possibleResults;

    public Statistics(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);;
        
        possibleResults = new HashMap<>();
        putPossibleResultsInMap();
    }
    
    private void putPossibleResultsInMap() {
        possibleResults.put(0, "Love");
        possibleResults.put(1, "Fifteen");
        possibleResults.put(2, "Thirty");
        possibleResults.put(3, "Forty");
        possibleResults.put(4, "Deuce");
    }
    
    private int getDifference() {
        return player1.getPoints() - player2.getPoints();
    }
    
    public boolean tie() {
        return getDifference() == 0;
    }
    
    public String getTieResults() {
        String result = possibleResults.get(player1.getPoints());        
        if (!result.equals("Deuce")) {
           result += "-All";
        }     
        return result;
    }
    
    public String getResults() {
        
        String player1Result = possibleResults.get(player1.getPoints());
        String player2Result = possibleResults.get(player2.getPoints());
        
        return player1Result + "-" + player2Result;
    }
    
    public boolean pointsMoreThanThree() {
        return player1.getPoints() >= 4 || player2.getPoints() >= 4;
    }
    
    public String getResultsWhenPlayerHasMoreThan3Points() {
        
        int difference = getDifference();      
        
        if (isAdvantage(difference)) {
            return advantageMessage(getPlayerWithMorePoints());
        }
        return won(getPlayerWithMorePoints());
    }
    
    private Player getPlayerWithMorePoints() {
        if (player1.getPoints() > player2.getPoints()) {
            return player1;
        }
        return player2;
    }
    
    private boolean isAdvantage(int difference) {
        return Math.abs(difference) == 1;
    }
    
    private String advantageMessage(Player player) {
        return "Advantage " + player.getName();
    }
    
    public String won(Player player) {
        return "Win for " + player.getName();
    }
    
    public void addPoint(String playerName) {
        getPlayer(playerName).wonPoint();
    }
    
    private Player getPlayer(String name) {
        if (name.equals("player1")) {
            return player1;
        } else {
            return player2;
        }
    }       
    
}
