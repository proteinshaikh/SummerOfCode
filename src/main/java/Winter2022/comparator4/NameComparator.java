package Winter2022.comparator4;

import java.util.Comparator;

public class NameComparator implements Comparator<Minister> {
    @Override
    public int compare(Minister o1, Minister o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
