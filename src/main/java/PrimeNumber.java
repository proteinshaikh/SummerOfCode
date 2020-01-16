import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> listPrime = new ArrayList<>();
        List<Integer> listNonPrime = new ArrayList<>();
        int i, j;
        for (i = 0; i <= 100; i++) {
            list.add(i);
        }
        for (int num : list) {
            boolean flag = false;
            for (j = 2; j <= num / 2; ++j) {
                if (num % j == 0) {
                    listNonPrime.add(num);
                    flag = true;
                    break;
                }
            }
            if (!flag)
                listPrime.add(num);
        }
        System.out.println("Numbers in ArrayList : " + list);
        System.out.println("List of Prime numbers" + listPrime);
        System.out.println("List of Non Prime numbers" + listNonPrime);

    }
}

