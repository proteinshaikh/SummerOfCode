package Winter2022.f;


//threadsafeSingleton
public final class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {

    }

    public ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        ThreadSafeSingleton t1 = ThreadSafeSingleton.instance;
        ThreadSafeSingleton t2 = ThreadSafeSingleton.instance;
        if (t1 == t2) System.out.println("true");
    }
}
