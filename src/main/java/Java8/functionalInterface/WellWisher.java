package Java8.functionalInterface;

public class WellWisher {
    public static void main(String[] args) {
        wish(() -> System.out.println("laal salam comrade!"));

    }

    public static void wish(Greetings greetings) {
        greetings.greet();
    }
}
