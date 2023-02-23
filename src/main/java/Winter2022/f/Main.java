package Winter2022.f;

class A {
    {
        System.out.println("a");
    }
}

class B extends A{

    {
        System.out.println("b");
    }
}

class C extends B{

    {
        System.out.println("c");
    }
}

public class Main{
    public static void main(String[] args) {
        B b= new C();
    }
}


