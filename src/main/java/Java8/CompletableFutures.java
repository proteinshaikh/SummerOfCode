package Java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutures {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(10);
        ExecutorService service1 = Executors.newCachedThreadPool();
        int n = 0;

        while (n < 10) {
            CompletableFuture.supplyAsync(() -> product(1), service1)
                    .thenApplyAsync(a -> order(a), service1)
                    .thenApplyAsync(a -> pay(a), service1)
                    .thenApplyAsync(a -> sendMail(a), service1);
            n++;
        }

    }

    static int product(Integer a) {
        System.out.println(a + " current thread name: " + Thread.currentThread().getName() + " method name: " + new Object() {
        }.getClass().getEnclosingMethod().getName());
        return 1;
    }

    static int order(Integer a) {
        System.out.println(a + " current thread name: " + Thread.currentThread().getName() + " method name: " + new Object() {
        }.getClass().getEnclosingMethod().getName());
        return 2;
    }

    static int pay(Integer a) {
        System.out.println(a + " current thread name: " + Thread.currentThread().getName() + " method name: " + new Object() {
        }.getClass().getEnclosingMethod().getName());
        return 3;
    }

    static int sendMail(Integer a) {
        System.out.println(a + " current thread name: " + Thread.currentThread().getName() + " method name: " + new Object() {
        }.getClass().getEnclosingMethod().getName());
        return 4;
    }

}
