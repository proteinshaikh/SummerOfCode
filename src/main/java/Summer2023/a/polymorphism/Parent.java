package Summer2023.a.polymorphism;

import java.io.IOException;

public class Parent {

    public String method() throws IOException {
        return "hello from parent!";
    }

    public static void main(String[] args) throws IOException {
        Parent p = new Child();

        System.out.println(p.method());
    }
}

class Child extends Parent {
    @Override
    public String method() throws IOException {
        return "string";
    }
}


//for method override, return type and method signature should be same
