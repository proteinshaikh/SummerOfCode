package Java8;

public class LambdaAndFunctionalInterface {
    public static void main(String[] args) {
        Shape shape = (a, b) -> a * b;
        System.out.println(shape.getArea(2, 3));
    }
}

interface Shape {
    int getArea(int base, int height);
}
