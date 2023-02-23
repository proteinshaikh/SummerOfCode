package Winter2022.a;

public class RunThread implements Runnable {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new RunThread()).start();
        }
    }

    @Override
    public void run() {
        System.out.println(" I am Runnable Thread : " + Thread.currentThread().getId());
    }
}



