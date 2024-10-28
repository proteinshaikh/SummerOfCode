package Winter2022.comparable2;


import lombok.NonNull;

public class Employee implements Comparable<Employee> {

    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
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
    public int compareTo(@NonNull Employee o) {
        if (id > o.getId()) return 1;
        if (id < o.getId()) return -1;
        return name.compareTo(o.getName());
    }
}
