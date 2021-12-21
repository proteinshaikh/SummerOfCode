package CoreJava;

public class DoubleTest {
    public static void main(String[] args) {
        System.out.println(1.0 / 0.0);
        try {
            System.out.println(1 / 0);
        } catch (ArithmeticException ax) {
            System.out.println(ax);
        }
    }
}
