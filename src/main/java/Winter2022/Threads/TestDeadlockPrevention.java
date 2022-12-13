package Winter2022.Threads;

class A {

    public synchronized void last() {
        System.out.println("inside A, last() method");
    }

    public synchronized void d1(B b) {
        System.out.println("Thread 1 start execution of d1 method");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Thread 1 trying to call B's last() method");

        b.last();
    }
}

class B {
    public void last() {
        System.out.println("inside B, last() method");
    }

    public void d2(A a) {
        System.out.println("Thread 2 start execution of d1 method");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Thread 2 trying to call A's last() method");

        a.last();
    }
}

public class TestDeadlockPrevention extends Thread {
    A a = new A();
    B b = new B();

    public void m1() {
        this.start();
        a.d1(b);
    }

    public void run() {
        b.d2(a);
    }

    public static void main(String[] args) {
        TestDeadlockPrevention testDeadlockPrevention = new TestDeadlockPrevention();
        testDeadlockPrevention.m1();
    }
}
