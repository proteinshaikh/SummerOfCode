package Winter2022.lambdaexp;

public class TestLambdaExp {
    public static void main(String[] args) {
        Car car = (int x) -> System.out.println(2*x);
        car.toyota(5);

        Train train = y -> y;
        System.out.println(train.metro("this is metro"));
    }
}
