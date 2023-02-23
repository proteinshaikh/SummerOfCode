package Winter2022;

public class Singleton3 {
    private static Singleton3 instance;

    private Singleton3() {

    }

    public static Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton3 s1 = Singleton3.getInstance();
        Singleton3 s2 = Singleton3.getInstance();
        if (s1 == s2) {
            System.out.println("instances are equal");
        } else {
            System.out.println("instances are not equal");
        }
    }

}
