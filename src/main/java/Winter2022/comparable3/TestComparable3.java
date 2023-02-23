package Winter2022.comparable3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestComparable3 {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Player("zee", 1));
        players.add(new Player("sha", 2));
        players.add(new Player("akr", 3));

        Collections.sort(players);
        for (Player player : players) {
            System.out.println("name: " + player.getName() + " age: " + player.getAge());
        }
    }
}
