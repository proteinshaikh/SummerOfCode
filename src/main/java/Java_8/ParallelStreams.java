package Java_8;

import java.util.stream.LongStream;

public class ParallelStreams {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        System.out.println(LongStream.range(1, 1000000000).parallel().sum());
        System.out.println("With Parallel : " + (System.currentTimeMillis() - time));

        long time2 = System.currentTimeMillis();
        System.out.println(LongStream.range(1, 1000000000).sum());
        System.out.println("Without parallel : " + (System.currentTimeMillis() - time2));
    }
}
