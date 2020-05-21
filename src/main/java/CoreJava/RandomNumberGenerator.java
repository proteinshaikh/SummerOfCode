package CoreJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        List<Integer> listR = new ArrayList<>();
        Random rand=new Random();
        int range;
        for(range=0;range<=10;range++) {
            int r = rand.nextInt(10000000);
            listR.add(r);
        }
        System.out.println("Random Numbers List" + listR);
    }
}
