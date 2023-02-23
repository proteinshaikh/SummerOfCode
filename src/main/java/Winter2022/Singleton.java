package Winter2022;

public class Singleton {
    private static Singleton singleton; //1. private instance

    private Singleton() {
        //2. private constructor to prevent external instantiation
    }

    public static Singleton getInstance() { //3. getInstance static method. getInstance is a static method that returns an instance of a class in Java
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public String getname(String name) {
        return "name got " + name;
    }

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance(); //4. test using getinstance and comparing 2 instances
        Singleton singleton2 = Singleton.getInstance();
        if (singleton1 == singleton2) {
            System.out.println(true);
        }
    }
}