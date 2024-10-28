package winter2024;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Question:
 * Demonstrate how to use Java's ExecutorService to execute two methods concurrently using a fixed thread pool.
 *
 * Solution:
 * The following program uses ExecutorService with a fixed thread pool of size 2 to concurrently execute
 * two methods (`methodOne` and `methodTwo`). The `shutdown` method is called to terminate the ExecutorService
 * once the tasks are submitted.
 */
public class ConcurrentExecution {

    public static void main(String[] args) {
        // Create a fixed thread pool with 2 threads
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Submit tasks (method references) to be executed by the executor service
        executorService.submit(ConcurrentExecution::methodOne);
        executorService.submit(ConcurrentExecution::methodTwo);

        // Shutdown the executor service after tasks submission
        executorService.shutdown();
    }

    static void methodOne() {
        System.out.println("This is method 1");
    }

    static void methodTwo() {
        System.out.println("This is method 2");
    }
}

