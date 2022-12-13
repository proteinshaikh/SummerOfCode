package Winter2022.Threads;

class Mumbai extends Thread {
    public void run() {
        System.out.println("Thread ID: " + Thread.currentThread().getId());
    }
}

public class TestExtentThreadClass {
    public static void main(String[] args) {
        Mumbai mumbai = new Mumbai();
        int i = 5;
        while (i >= 1) {
            mumbai.run();
            i--;
        }
    }
}
