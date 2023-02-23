package Winter2022.equalsandhashcode3;

import Winter2022.EqualsandHashcode.Employee;

public class Members {
    private String name;
    private int id;

    public Members(String name, int id) {
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
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        if (!(o instanceof Members)) return false;
        Employee e = (Employee) o;
        return e.getName().equals(this.getName()) && e.getId() == this.getId();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
