package Winter2022.g;

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
                TSingleton singleton = TSingleton.getInstance();
                singleton.doSomething();
                Assert.assertSame(singleton, TSingleton.getInstance());
            });
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            Thread.sleep(100);
        }
    }


    @Test
    public void testBuilder() {
        User user = new User.Builder(1, "zee")
                .salary(1000)
                .build();
        System.out.println(user.getId() + " " + user.getSalary());
    }
}
