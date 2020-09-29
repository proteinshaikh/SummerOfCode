package problems;
//sort by name and price

import java.util.*;

public class FruitsComparator {
    public static void main(String[] args) {
        List<Fruits> fruits=new ArrayList<>();
        fruits.add(new Fruits(4,"Banana", 45.5,"India"));
        fruits.add(new Fruits(2,"avocado", 100.10,"usa"));
        fruits.add(new Fruits(3,"pineaple", 13.65163,"canada"));
        fruits.add(new Fruits(4,"Apple", 44,"India"));
        fruits.add(new Fruits(5,"Sugarcane", 13.65165,"england"));
        fruits.add(new Fruits(6,"Papaya", 44,"Russia"));

        //using java 7
        /*Collections.sort(fruits, new SortByName());
        System.out.println(fruits);
        Collections.sort(fruits, new SortByPrice().reversed());
        System.out.println(fruits);*/

        //using java 8
        fruits.sort(Comparator.comparing(Fruits::getPrice).thenComparing(Fruits::getId).thenComparing(Fruits::getName));
        System.out.println(fruits);

    }
}

class Fruits {
    private int id;
    private String name;
    private double price;
    private String season;

    public Fruits(int id, String name, double price, String season) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.season = season;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    @Override
    public boolean equals(Object o) {
        if (this == null) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruits fruits = (Fruits) o;
        return id == fruits.id && Objects.equals(name, fruits.name) && price == fruits.price && Objects.equals(season, season == fruits.season);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, season);
    }

    @Override
    public String toString() {
        return "id = " + id + "   name = " + name + "   price = " + price + "   season = " + season + "\n";
    }
}

class SortByName implements Comparator<Fruits> {
    @Override
    public int compare(Fruits f, Fruits f1) {
        return f.getName().compareTo(f1.getName());

    }
}


class SortByPrice implements Comparator<Fruits> {
    @Override
    public int compare(Fruits f, Fruits f1) {
        return Double.compare(f.getPrice(), f1.getPrice());
    }
}