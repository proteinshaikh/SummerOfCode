package Winter2022.a;

class ExThread extends Thread {
    @Override
    public void run() {
        System.out.println(" I am Extended Thread class Thread : " + Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            ExThread exThread = new ExThread();
            exThread.start();
        }
    }
}
