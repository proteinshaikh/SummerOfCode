package Winter2022.c;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;
    private static Object object = new Object();

    private ThreadSafeSingleton() {

    }

    public ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (object) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
