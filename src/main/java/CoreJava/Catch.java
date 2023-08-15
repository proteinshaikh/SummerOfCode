package CoreJava;

import java.math.BigDecimal;

public class Catch {
    public static void main(String[] args) throws Exception {
        double x = Math.pow(2, 256);
        System.out.println(Integer.valueOf((int) x));
        System.out.println(BigDecimal.valueOf(0));
    }
}
