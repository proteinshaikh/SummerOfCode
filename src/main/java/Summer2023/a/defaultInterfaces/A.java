package Summer2023.a.defaultInterfaces;

public interface A {

    void hi();

    default void hello() {
        System.out.println("hello from A");
    }
}
