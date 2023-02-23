package Winter2022;

public class Singleton2 {

    private static Singleton2 singleton2;

    private Singleton2() {

    }

    public static Singleton2 getInstance() {
        if (singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }

    public static void main(String[] args) {
        Singleton2 singleton21 = Singleton2.getInstance();
        Singleton2 singleton22 = Singleton2.getInstance();
        if (singleton21 == singleton22) {
            System.out.println("hashcode same");
        } else {
            System.out.println("hashcode not same");
        }
    }
}
