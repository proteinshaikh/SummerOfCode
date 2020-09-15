package CoreJava;

public class ParentChild {

    public static void main(String[] args) {
        A a = new A();
        a.a();
        A b = new B();
        b.a();
        B b1=new B();
        b1.b();
        b1.a();
    }
}

class A {
    A(){

    }
    void a() {
        System.out.println("A's method");
    }

}

class B extends A {


    void b() {
        super.a();
        System.out.println("B's method");
    }

}
