package Winter2022.threads2;

public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        System.out.println("runnable thread : " + Thread.currentThread().getId());
    }

    public static void testrunnable() {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new RunnableImpl());
            thread.start();
        }
    }

    public static void main(String[] args) {
        testrunnable();
    }
}
