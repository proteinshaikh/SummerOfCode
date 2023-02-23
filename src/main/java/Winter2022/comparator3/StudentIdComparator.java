package Winter2022.comparator3;

import java.util.Comparator;

public class StudentIdComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o2.getId() - o1.getId();
    }
}
