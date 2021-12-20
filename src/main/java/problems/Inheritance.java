package problems;

public class Inheritance {
    public static void main(String[] args) {
        Base base = new Base();
        Base base1 = new Derived();
        Derived derived = new Derived();
        doPrint(base);
        doPrint(base1);
        doPrint(derived);

    }

    public static void doPrint(Base base) {
        base.print();
    }
}

class Base {
    public void print() {
        System.out.println("Base");
    }
}

class Derived extends Base {
    public void print() {
        System.out.println("Derived");
    }
}
