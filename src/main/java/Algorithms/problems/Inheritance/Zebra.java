package Algorithms.problems.Inheritance;

public class Zebra extends Animal{
    public static void main(String[] args) {
        Animal animal = new Animal("Zebra", 2);
        System.out.println(animal.getName()+ " " +animal.getAge());
    }
}
