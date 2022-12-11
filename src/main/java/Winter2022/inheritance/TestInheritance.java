package Winter2022.inheritance;

public class TestInheritance {
    public static void main(String[] args) {

        Parent p = new Child();//upcasting
        Child c = (Child) p;//downcasting
        System.out.println(p.getmethod());
        System.out.println(c.getmethod());
    }
}

class Parent {
    public String getmethod() {
        return "I am Parent";
    }
}

class Child extends Parent {
    public String getmethod() {
        return "I am Child";
    }
}
