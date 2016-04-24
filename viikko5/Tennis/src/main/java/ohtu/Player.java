
package ohtu;

public class Player {
    
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void wonPoint() {
        score++;
    }
    
    public void lostPoint() {
        score--;
    }
    
    public int getPoints() {
        return score;
    }
}
