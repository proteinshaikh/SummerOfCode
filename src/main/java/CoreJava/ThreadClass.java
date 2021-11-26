package CoreJava;

class ThreadSampleClass extends Thread {

    public void run() {
        System.out.println("test" + Thread.currentThread().getId());

    }

}

public class ThreadClass {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            ThreadSampleClass threadSampleClass = new ThreadSampleClass();
            threadSampleClass.start();
        }
    }
}

