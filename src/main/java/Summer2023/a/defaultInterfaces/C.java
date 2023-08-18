package Summer2023.a.defaultInterfaces;

public class C implements A, B {
    @Override
    public void hi() {
        System.out.println("hi");
    }

    @Override
    public void hello() {
        A.super.hello();
        B.super.hello();
        System.out.println("nothing");
    }

    public static void main(String[] args) {
        C c = new C();
        c.hello();
    }
}
