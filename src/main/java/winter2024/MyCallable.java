package winter2024;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "callable finished execution";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Creating a fixed thread pool with one thread
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        // Submitting the Callable task to the ExecutorService
        Future<String> future = executorService.submit(new MyCallable());

        // Retrieving the result of the Callable's execution using Future.get()
        String result = future.get();
        System.out.println(result);

        // Shutting down the ExecutorService
        executorService.shutdown();
    }
}

