package Summer2023.c;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentExecution {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(ConcurrentExecution::methodOne);
        executorService.submit(ConcurrentExecution::methodTwo);

        executorService.shutdown();

    }

    static void methodOne() {
        System.out.println("This is method 1");
    }

    static void methodTwo() {
        System.out.println("This is method 2");
    }
}
