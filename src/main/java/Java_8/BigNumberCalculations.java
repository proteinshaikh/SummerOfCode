package Java_8;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class BigNumberCalculations {
    public static void main(String[] args) {

        System.out.println(Long.MAX_VALUE);

        System.out.println(LongStream.rangeClosed(1, 10).reduce(1, (x, y) -> x * y));

        System.out.println(LongStream.rangeClosed(1, 50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply));
    }
}
