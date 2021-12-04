package CoreJava;

class JoinThreads implements Runnable {
    @Override
    public void run() {
        System.out.println("Running thread number: " + Thread.currentThread().getId() + " from " + this.getClass().toString().replace("CoreJava.", ""));
        System.out.println("Running thread number: " + Thread.currentThread().getId() + " from " + this.getClass().toString().replace("CoreJava.", ""));
        System.out.println("Running thread number: " + Thread.currentThread().getId() + " from " + this.getClass().toString().replace("CoreJava.", ""));
        System.out.println("Running thread number: " + Thread.currentThread().getId() + " from " + this.getClass().toString().replace("CoreJava.", ""));
        System.out.println("Running thread number: " + Thread.currentThread().getId() + " from " + this.getClass().toString().replace("CoreJava.", ""));
    }
}

class JoinThreads2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Running thread number: " + Thread.currentThread().getId() + " from " + this.getClass().toString().replace("CoreJava.", ""));
    }
}

public class ThreadJoins {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new JoinThreads());
        thread.start();
        thread.join();
        Thread thread2 = new Thread(new JoinThreads2());
        thread2.start();
        // thread2.join();

    }
}
