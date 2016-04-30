package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        QueryBuilder query = new QueryBuilder();

        Matcher m = query.playsIn("NYR")
                .hasAtLeast(10, "goals")
                .hasFewerThan(25, "assists").build();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

        System.out.println("------------------------------------------------------------------------");
        System.out.println(".........................................................................");
        System.out.println("------------------------------------------------------------------------");

        Matcher m1 = query.playsIn("PHI").build();

        Matcher m2 = query.playsIn("EDM")
                .hasAtLeast(50, "points").build();

        m = query.oneOf(m1, m2).build();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

        /*
        Matcher m = new And(new HasAtLeast(10, "goals"),
                new HasAtLeast(10, "assists"),
                new PlaysIn("PHI")
        );

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

        System.out.println("------------------------------------------------------------------------");
        System.out.println(".........................................................................");
        System.out.println("------------------------------------------------------------------------");

        m = new Not(new PlaysIn("PHI"));

        // everyone who is not in PHI team
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

        System.out.println("------------------------------------------------------------------------");
        System.out.println(".........................................................................");
        System.out.println("------------------------------------------------------------------------");

        // everyone either in PHI or CBJ
        m = new Or(new PlaysIn("PHI"),
                new PlaysIn("CBJ"));

        // everyone who is not in PHI team
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
         */
    }
}
