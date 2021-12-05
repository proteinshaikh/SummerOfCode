package Java8.FutureswithRunnableAndCallables;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class FutureWIthCallable implements Callable<String> {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<String>> futureList = new ArrayList<>();

        Callable callable = new FutureWIthCallable();
        for (int i = 10; i < 100; i++) {
            Future<String> future = executor.submit(callable);
            futureList.add(future);
        }

        for (Future<String> fu : futureList) {
            try {
                System.out.println(new Date() + ":: " + fu.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(3000);

        return Thread.currentThread().getName();
    }
}
