package Summer2023.a.defaultInterfaces;

import CoreJava.StringTest;

public interface B {

    void hi();

    default void hello() {
        System.out.println("hello from B");
    }
}
