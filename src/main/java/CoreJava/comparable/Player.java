package CoreJava.comparable;


public class Player {

    private String name;
    private int age;
    private int rank;


    public Player(String name, int age, int rank) {
        this.name = name;
        this.age = age;
        this.rank = rank;
    }

    public Player() {

    }

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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PlayerComparator{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", rank=").append(rank);
        sb.append('}');
        return sb.toString();
    }

}
