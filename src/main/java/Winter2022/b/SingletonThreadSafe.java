package Winter2022.b;

public class SingletonThreadSafe {

    private static SingletonThreadSafe instance;
    private static Object object = new Object(); // create new Object Object

    private SingletonThreadSafe() {

    }

    public static SingletonThreadSafe getInstance() {
        if (instance == null) { // 1 more if condition
            synchronized (object) { // synchronized block
                if (instance == null) {
                    instance = new SingletonThreadSafe();
                }
            }
        }
        return instance;
    }
}
