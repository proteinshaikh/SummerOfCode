package CoreJava;

public class ParentChildConstructor {
    public static void main(String[] args) {
        Child c = new Child();
    }

}

class Parent {
    Parent() {
        System.out.println("I am Parent constructor");
    }
}

class Child extends Parent {
    Child() {
        super();
        System.out.println("I am Child constructor");
    }
}
