package Winter2022.h.lambda;

public class TestLambdas {
    public static void main(String[] args) {
        Vehicle vehicle = (String str, int carNum) -> "This car is " + str + " " + carNum;
        System.out.println(vehicle.car("tata", 123));
    }
}
