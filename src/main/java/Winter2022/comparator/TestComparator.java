package Winter2022.comparator;

import java.util.ArrayList;
import java.util.List;

public class TestComparator {

    public static void main(String[] args) {
        List<Team> list = new ArrayList<>();
        list.add(new Team("zeeshan", 2));
        list.add(new Team("shaikh", 10));
        list.add(new Team("akram", 1));
        list.add(new Team("protein", 5));

        list.sort(new NameComparator());

        for (Team team : list) {
            System.out.println("name: " + team.getName() + " " + "score: " + team.getScore());
        }

        System.out.println("--------------------------------------------------------------------------");
        list.sort(new ScoreComparator());

        for (Team team : list) {
            System.out.println("name: " + team.getName() + " " + "score: " + team.getScore());
        }

    }
}
