package Winter2022.comparator;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Team> {
    @Override
    public int compare(Team o1, Team o2) {
        return o1.getScore() - o2.getScore();
    }
}
