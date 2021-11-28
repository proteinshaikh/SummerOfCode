package CoreJava.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestComparator {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Zeeshan", 25, 1));
        players.add(new Player("Zeeshan", 30, 2));
        players.add(new Player("Zeeshan", 15, 6));
        players.add(new Player("Zeeshan", 20, 5));
        players.add(new Player("Zeeshan", 40, 4));
        players.add(new Player("Zeeshan", 35, 3));


        PlayerRankComparator playerRankComparator = new PlayerRankComparator();
        PlayerAgeComparator playerAgeComparator = new PlayerAgeComparator();

        Collections.sort(players, playerRankComparator);
        System.out.println("Comparison based on Rank: " + players);

        Collections.sort(players, playerAgeComparator);
        System.out.println("Comparison based on Age: " + players);


    }
}
