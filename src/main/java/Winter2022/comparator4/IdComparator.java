package Winter2022.comparator4;

import java.util.Comparator;

public class IdComparator implements Comparator<Minister> {

    public int compare(Minister o1, Minister o2) {
        return o1.getId() - o2.getId();
    }
}
