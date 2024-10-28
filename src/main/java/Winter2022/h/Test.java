package Winter2022.h;


import org.junit.jupiter.api.Assertions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    @org.junit.jupiter.api.Test
    public void testSingleton() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0; i< 100; i++){
            executorService.submit(() -> {
                TSingleton tSingleton = TSingleton.getInstance();
                tSingleton.doSomething();
                Assertions.assertSame(tSingleton, TSingleton.getInstance());
            });
        }
        executorService.shutdown();
        while(!(executorService.isTerminated())){
            Thread.sleep(100);
        }
    }
}
