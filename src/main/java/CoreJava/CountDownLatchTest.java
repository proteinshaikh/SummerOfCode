package CoreJava;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch=new CountDownLatch(4);

        Worker worker1=new Worker(1000, latch, "worker -1");
        Worker worker2=new Worker(2000, latch, "worker -2");
        Worker worker3=new Worker(3000, latch, "worker -3");
        Worker worker4=new Worker(4000, latch, "worker -4");

        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

        latch.await();
        System.out.println(Thread.currentThread().getName()+" has finished!");
    }
}

class Worker extends Thread{
    private int delay;
    private CountDownLatch latch;
    
    public Worker(int delay, CountDownLatch latch, String name){
        super(name);
        this.delay=delay;
        this.latch=latch;
        
    }

    public void run(){
        try{
            Thread.sleep(delay);
            latch.countDown();
            System.out.println(Thread.currentThread().getName()+" finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
