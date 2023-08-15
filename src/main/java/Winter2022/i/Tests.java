package Winter2022.i;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tests {

    @Test
    public void testSingleton() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.submit(() -> {
                ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance();
                singleton.doSomething();
                Assert.assertSame(singleton, ThreadSafeSingleton.getInstance());
            });

            executorService.shutdown();
            while (!(executorService.isTerminated())) {
                Thread.sleep(100);
            }
        }
    }
}
