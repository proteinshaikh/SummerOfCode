package problems;

import java.util.TreeSet;

public class Treesets {
    public static void main(String[] args) {
        Drink drink = new Drink();
        Drink drink1 = new Drink();
        drink.name = "tea";
        drink1.name = "coffee";
        TreeSet treeSet = new TreeSet();
        treeSet.add(drink);
        treeSet.add(drink1);

    }
}

class Drink implements Comparable {

    public String name;

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
