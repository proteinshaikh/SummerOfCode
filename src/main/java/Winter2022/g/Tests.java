package Winter2022.g;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tests {

    @Test
    void testSingleton() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.submit(() -> {
                TSingleton singleton = TSingleton.getInstance();
                singleton.doSomething();
                Assertions.assertSame(singleton, TSingleton.getInstance());
            });
        }
        executorService.shutdown();
        if (!executorService.awaitTermination(1, java.util.concurrent.TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        }
    }

    @Test
    void testBuilder() {
        User user = new User.Builder(1, "zee")
                .salary(1000)
                .build();
        Assertions.assertEquals(1, user.getId());
        Assertions.assertEquals(1000, user.getSalary());
    }
}
