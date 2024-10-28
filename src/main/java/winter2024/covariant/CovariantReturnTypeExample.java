package winter2024.covariant;

// Base class (Superclass)
class Animal {
    public Animal getAnimal() {
        System.out.println("Returning an Animal");
        return new Animal();
    }
}

// Subclass (Dog)
class Dog extends Animal {
    @Override
    public Dog getAnimal() {
        System.out.println("Returning a Dog");
        return new Dog(); // Covariant return type: Returning a subtype of Animal (Dog)
    }
}

public class CovariantReturnTypeExample {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.getAnimal();  // Returns an Animal

        Dog dog = new Dog();
        dog.getAnimal();  // Returns a Dog (subtype of Animal) due to covariant return type

        // You can also assign the result to the superclass reference
        Animal anotherDog = dog.getAnimal();  // Still returns Dog, but reference is of type Animal
    }
}

