package Winter2022.Comparable4;

import java.util.HashMap;
import java.util.Map;

public class Minister implements Comparable<Minister> {

    private String name;
    private int id;

    public Minister(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        if (!(o instanceof Minister)) return false;
        Minister m = (Minister) o;
        return m.getName().equals(this.getName()) || m.getId() == this.getId();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Map<Minister, Integer> map = new HashMap<>();

        Minister m1 = new Minister(1, "zee");
        Minister m2 = new Minister(1, "zee");

        map.put(m1, 1);
        map.put(m2, 2);

        if (m1.hashCode() == m2.hashCode()) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

    }

    @Override
    public int compareTo(Minister o) {
        if (this.getId() > o.getId()) return 1;
        if (this.getId() < o.getId()) return -1;
        else return this.getName().compareTo(o.getName());
    }
}
