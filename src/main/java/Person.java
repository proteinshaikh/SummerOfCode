import java.util.List;

public class Person {


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public Person(String name, int age, List<Company> companies) {
        this.name = name;
        this.age = age;
        this.companies = companies;
    }

    private String name;
    private int age;
    private List<Company> companies;
}
