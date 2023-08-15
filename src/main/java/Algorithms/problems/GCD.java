package Algorithms.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GCD {
    public static void main(String[] args) {
        System.out.println(getGcd(54, 36));
    }

    static List<Integer> getDivisorList(int number) {

        List<Integer> listOfDivisors = new ArrayList<>();

        for (int i = 1; i <= number; i++) {
            int remainder = number % i;

            if (remainder == 0) {
                listOfDivisors.add(i);
            }
        }
        return listOfDivisors;
    }

    static int getGcd(int m, int n) {
        List<Integer> mList = getDivisorList(m);
        List<Integer> nList = getDivisorList(n);

        List<Integer> list = mList.stream().filter(nList::contains).collect(Collectors.toList());
        return Collections.max(list);
    }
}
