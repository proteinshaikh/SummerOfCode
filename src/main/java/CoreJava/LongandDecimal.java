package CoreJava;

import java.math.BigDecimal;

public class LongandDecimal {
    public static void main(String[] args) {
        BigDecimal bigDecimal = BigDecimal.valueOf(-85.05);
        System.out.println(bigDecimal.abs());
        System.out.println(Math.abs(bigDecimal.doubleValue()));

    }
}
