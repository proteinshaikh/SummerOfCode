package Winter2022.d;

public class ExThread extends Thread {

    @Override
    public void run() {
        System.out.println("ExThread " + Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            ExThread exThread = new ExThread();
            exThread.start();
        }
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new RunThread());
            thread.start();
        }

    }
}

class RunThread implements Runnable {

    @Override
    public void run() {
        System.out.println("RunThread " + Thread.currentThread().getId());
    }
}
