package Algorithms.problems;

//0 1 1 2 3 5 8 13

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
 * input: 8
 * output: 0 1 1 2 3 5 8 13
 *
 * */
public class Fibnacci {

    public static void main(String[] args) {

        System.out.println("Fibonacci list is : " + getFibonacciList(9));

    }

    private static List<Integer> getFibonacciList(int numOfFibonacciNumbers) {
        List<Integer> numList = new ArrayList<>();
        numList.add(0);
        numList.add(1);

        if (numOfFibonacciNumbers == 0) {
            return numList.subList(0, 1);
        }

        if (numOfFibonacciNumbers == 1) {
            return numList.subList(0, 2);
        }

        if (numOfFibonacciNumbers > 1) {
            int i;
            for (i = 2; i <= numOfFibonacciNumbers; i++) {
                int temp = numList.get(i - 2) + numList.get(i - 1);
                numList.add(i, temp);
            }
            return numList;
        } else {
            System.out.println("Index cannot be less than 0 ");
        }
        return null;
    }
}
