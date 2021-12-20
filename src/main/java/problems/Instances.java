package problems;

public class Instances {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        System.out.println(b instanceof B);
        System.out.println((b instanceof B) && (!(b instanceof A)));
        System.out.println((b instanceof B) && (!(b instanceof C)));
        System.out.println(c instanceof B);
        System.out.println(c instanceof B);


    }
}

class A{

}

class B extends A{

}

class C extends B{

}
