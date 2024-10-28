package winter2024;

public class DefaultInterfaces {

    public static void main(String[] args) {
        // Example usage of Sedan class implementing a default method from Car interface
        System.out.println("// 1. Demonstrate default methods in an interface");
        Sedan sedan = new Sedan();
        sedan.start();  // Output: Sedan starting!
        sedan.honk();   // Output: Car honking!

        // Example usage of FlyingCar class resolving conflicting default methods
        System.out.println("\n// 2. Resolve conflict when implementing two interfaces with the same default method");
        FlyingCar flyingCar = new FlyingCar();
        flyingCar.move(); // Output: Flying \n Flying car moves in its own way.
    }

    // 1. Interface with a default method
    interface Vehicle {
        void start();

        default void honk() {
            System.out.println("Vehicle honking!");
        }
    }

    // 2. Interface extending another interface with its own default method
    interface Car extends Vehicle {
        default void honk() {
            System.out.println("Car honking!");
        }
    }

    // 3. Class implementing the interface without overriding the default method
    static class Sedan implements Car {
        @Override
        public void start() {
            System.out.println("Sedan starting!");
        }

        // The honk() method is inherited from the Car interface
    }

    // 4. Interface with a default method (for conflict example)
    interface Flyable {
        default void move() {
            System.out.println("Flying");
        }
    }

    // 5. Another interface with the same default method name (for conflict example)
    interface Drivable {
        default void move() {
            System.out.println("Driving");
        }
    }

    // 6. Class implementing both interfaces with conflicting default methods
    static class FlyingCar implements Flyable, Drivable {
        @Override
        public void move() {
            // To resolve the conflict, explicitly call the method from one of the interfaces
            Flyable.super.move(); // Calls move() from Flyable
            System.out.println("Flying car moves in its own way.");
        }
    }
}

