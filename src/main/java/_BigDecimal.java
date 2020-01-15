import java.math.BigDecimal;

public class _BigDecimal {
    public static void main(String[] args) {
        //Normal operation
        double a = 0.04;
        double b = 0.05;
        double c = b - a;
        System.out.println("double value = " + c);

        //Operation using Big Decimal Class
        BigDecimal p = new BigDecimal("0.04");
        BigDecimal q = new BigDecimal("0.05");
        BigDecimal r = q.subtract(p);
        System.out.println("BigDecimal value = " + r);

    }
}
