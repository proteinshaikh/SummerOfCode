package Winter2022.comparable3;

import org.jetbrains.annotations.NotNull;

public class Player implements Comparable<Player>{

    private String name;
    private int age;

    public Player(String name, int age) {
        this.name = name;
        this.age = age;
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



    @Override
    public int compareTo(Player o1) {
       if(age > o1.getAge()) return 1;
       if (age < o1.getAge()) return -1;
       else return name.compareTo(o1.getName());
    }
}
