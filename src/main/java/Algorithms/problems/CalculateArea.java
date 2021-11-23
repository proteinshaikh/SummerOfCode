package Algorithms.problems;

public class CalculateArea {
    public static void main(String[] args) {
        System.out.println("Area of square  = " + getArea(5));
        System.out.println("Area of Rectangle  = " + getArea(5, 2));

    }

    static double getArea(double length, double breadth) {

        return length * breadth;

    }

    static double getArea(double length) {
        return length * length;
    }
}
