package Winter2022.h.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestLambda2 {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("mc", "visa", "rupay");
        List<String> res = new ArrayList<>();


        Payment payment = (int id, String type) -> {
            for (int i = 0; i < list.size(); i++) {
                res.add(list.get(i) + " " + type + " " + id);
            }
            return res;
        };
        payment.getcards(1, "mastercard");
        for(String s: res) {
            System.out.println(s.toUpperCase());
        }
    }
}