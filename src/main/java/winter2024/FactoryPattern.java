package winter2024;

public class FactoryPattern {

    public static void main(String[] args) {
        // Example usage of the VehicleFactory
        System.out.println("// 1. Create a Car using the Factory Pattern");
        Vehicle car = VehicleFactory.getVehicle("Car", "Toyota", "Sedan");
        System.out.println("Car: " + car.getDetails());

        System.out.println("\n// 2. Create a Bike using the Factory Pattern");
        Vehicle bike = VehicleFactory.getVehicle("Bike", "Yamaha", "Sports");
        System.out.println("Bike: " + bike.getDetails());

        System.out.println("\n// 3. create a Truck using the Factory Pattern");
        Vehicle truck = VehicleFactory.getVehicle("Truck", "Ford", "Heavy-Duty");
        System.out.println("Truck: " + truck.getDetails());
    }

    // 1. Define the Vehicle interface
    interface Vehicle {
        String getDetails();
    }

    // 2. Implement the Vehicle interface with the Car class
    static class Car implements Vehicle {
        private final String brand;
        private final String type;

        public Car(String brand, String type) {
            this.brand = brand;
            this.type = type;
        }

        @Override
        public String getDetails() {
            return "Car Brand: " + brand + ", Type: " + type;
        }
    }

    // 3. Implement the Vehicle interface with the Bike class
    static class Bike implements Vehicle {
        private final String brand;
        private final String type;

        public Bike(String brand, String type) {
            this.brand = brand;
            this.type = type;
        }

        @Override
        public String getDetails() {
            return "Bike Brand: " + brand + ", Type: " + type;
        }
    }

    // 4. Implement the Vehicle interface with the Truck class
    static class Truck implements Vehicle {
        private final String brand;
        private final String type;

        public Truck(String brand, String type) {
            this.brand = brand;
            this.type = type;
        }

        @Override
        public String getDetails() {
            return "Truck Brand: " + brand + ", Type: " + type;
        }
    }

    // 5. Factory class to create different types of vehicles
    static class VehicleFactory {
        public static Vehicle getVehicle(String vehicleType, String brand, String type) {
            return switch (vehicleType) {
                case "Car" -> new Car(brand, type);
                case "Bike" -> new Bike(brand, type);
                case "Truck" -> new Truck(brand, type);
                default -> throw new IllegalArgumentException("Unknown vehicle type: " + vehicleType);
            };
        }
    }
}

