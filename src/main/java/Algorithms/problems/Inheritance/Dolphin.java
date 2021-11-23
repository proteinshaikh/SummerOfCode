package Algorithms.problems.Inheritance;

public class Dolphin extends Animal{

    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.setAge(2);
        animal.setName("Dolphin");
        System.out.println(animal.getName()+ " " +animal.getAge());
    }
}
