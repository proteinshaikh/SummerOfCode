import java.math.BigDecimal;

public class Test2 {
    public static void main(String[] args) {
        BigDecimal bd = new BigDecimal("30000.1");
        long l = bd.setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
        System.out.println(l);
    }
}
