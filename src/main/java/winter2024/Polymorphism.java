package winter2024;

public class Polymorphism {

    public static void main(String[] args) {
        // Example usage of polymorphism with Animal reference types
        System.out.println("// 1. Demonstrate runtime polymorphism");
        Animal animal1 = new Dog();
        Animal animal2 = new Cat();
        Animal animal3 = new Bird();

        animal1.makeSound(); // Output: Dog barks
        animal2.makeSound(); // Output: Cat meows
        animal3.makeSound(); // Output: Bird chirps

        // Demonstrate compile-time polymorphism
        System.out.println("\n// 2. Demonstrate compile-time polymorphism");
        Calculator calculator = new Calculator();
        System.out.println("Sum (int, int): " + calculator.add(5, 10));
        System.out.println("Sum (double, double): " + calculator.add(5.5, 10.2));
        System.out.println("Sum (int, int, int): " + calculator.add(1, 2, 3));
    }

    // 1. Parent class Animal with polymorphic method
    static class Animal {
        void makeSound() {
            System.out.println("Animal makes sound");
        }
    }

    // 2. Dog class extending Animal
    static class Dog extends Animal {
        @Override
        void makeSound() {
            System.out.println("Dog barks");
        }
    }

    // 3. Cat class extending Animal
    static class Cat extends Animal {
        @Override
        void makeSound() {
            System.out.println("Cat meows");
        }
    }

    // 4. Bird class extending Animal
    static class Bird extends Animal {
        @Override
        void makeSound() {
            System.out.println("Bird chirps");
        }
    }

    // 5. Demonstrating compile-time polymorphism (method overloading)
    static class Calculator {
        int add(int a, int b) {
            return a + b;
        }

        double add(double a, double b) {
            return a + b;
        }

        int add(int a, int b, int c) {
            return a + b + c;
        }
    }
}

