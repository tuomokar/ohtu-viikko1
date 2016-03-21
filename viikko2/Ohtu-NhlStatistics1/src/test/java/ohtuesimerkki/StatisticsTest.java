
package ohtuesimerkki;

import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {
    
    @Before
    public void setUp() {
        this.stats = new Statistics(readerStub);
    }
    
    Statistics stats;
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };
    
    @Test
    public void searchReturnsCorrectPlayer() {
        Player player = stats.search("Semenko");
        assertEquals("Semenko", player.getName());
    }
    
    @Test
    public void searchReturnsNullWhenNameIsNotFound() {
        Player player = stats.search("notFound");
        assertNull(player);
    }
    
    @Test
    public void searchReturnsCorrectPlayerWhenOnlyPartOfTheNameIsGiven() {
        Player player = stats.search("tzk");
        assertEquals("Gretzky", player.getName());
    }
    
    @Test
    public void teamReturnsCorrectTeamMembers() {
        List<Player> team = stats.team("EDM");
        assertTrue(team.size() == 3);
        assertEquals("Semenko", team.get(0).getName());
        assertEquals("Kurri", team.get(1).getName());
        assertEquals("Gretzky", team.get(2).getName());
    }
    
    @Test
    public void noTeamMembersReturnedWithNonExistingTeamName() {
        List<Player> team = stats.team("NotFound");
        assertTrue(team.isEmpty());
    }
    
    @Test
    public void playersAreReturnedInCorrectOrderWhenGettingTopScorers() {
        List<Player> players = stats.topScorers(4);
        
        assertTrue(players.size() == 5);
        assertEquals("Gretzky", players.get(0).getName());
        assertEquals("Lemieux", players.get(1).getName());
        assertEquals("Yzerman", players.get(2).getName());
        assertEquals("Kurri", players.get(3).getName());
        assertEquals("Semenko", players.get(4).getName());
    }
    
    @Test
    public void onePlayerIsReturnedWhenZeroIsGiven() {
        List<Player> players = stats.topScorers(0);
        
        assertTrue(players.size() == 1);
        assertEquals("Gretzky", players.get(0).getName());
    }
}
