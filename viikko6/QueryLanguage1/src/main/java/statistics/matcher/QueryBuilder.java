
package statistics.matcher;

public class QueryBuilder {
    
    private Matcher matcher;
    
    public Matcher build() {
        return matcher;
    }
    
    public QueryBuilder playsIn(String team) {
        this.matcher = new PlaysIn(team);
        return this;
    }
    
    public QueryBuilder hasAtLeast(int number, String what) {
        this.matcher = new HasAtLeast(number, what);
        return this;
    }
    
    public QueryBuilder hasFewerThan(int number, String what) {
        this.matcher = new HasFewerThan(number, what);
        return this;
    }
    
    public QueryBuilder oneOf(Matcher... matchers) {
        this.matcher = new Or(matchers);
        return this;
    }
    
    
}
