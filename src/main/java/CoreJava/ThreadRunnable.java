package CoreJava;

class ThreadRunnableSample implements Runnable {
    @Override
    public void run() {
        System.out.println("this is the current thread running : " + Thread.currentThread().getId());
    }
}

public class ThreadRunnable {
    public static void main(String[] args) {
        int i = 0;

        while (i < 7) {
            Thread thread = new Thread(new ThreadRunnableSample());
            thread.start();
            i++;
        }
    }
}
