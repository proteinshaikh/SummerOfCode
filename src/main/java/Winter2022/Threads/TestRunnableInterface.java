package Winter2022.Threads;

class Machine implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread ID: " + Thread.currentThread().getId());
    }
}

public class TestRunnableInterface {
    public static void main(String[] args) {
        int i = 5;

        while (i >= 1) {
            Thread thread = new Thread(new Machine());
            thread.start();
            i--;
        }
    }
}
