package DesignPatterns;

public class Singleton {

    private static Singleton singleInstance = null;
    public String string;

    private Singleton() {
        string = "This is singleton Constructor";
    }

    public static Singleton getSingleInstance() {
        if (singleInstance == null) {
            return new Singleton();
        } else return null;
    }

    public static void main(String[] args) {
        Singleton x = Singleton.getSingleInstance();
        Singleton y = Singleton.getSingleInstance();

        if (x.getClass().hashCode() == y.getClass().hashCode()) {
            System.out.println("hashcode is same");
        } else {
            System.out.println("hashcode is not same");
        }
    }
}

/*
 *
 *
 * */
