package Java8;

import java.util.function.Function;

public class CurryingFunction {
    public static void main(String[] args) {
        Function<Integer, Function<Integer, Integer>> varadd = u -> v -> u + v;
        System.out.println(varadd.apply(2).apply(3));

        Function<Integer, Function<Integer, Function<Integer, Integer>>> var = u -> v -> w -> (u + v) * w;
        System.out.println(var.apply(2).apply(3).apply(5));
    }
}
