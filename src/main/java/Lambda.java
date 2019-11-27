
interface InterLambda {
    void mthdLambda();
    default void mthdLambda2(){
        System.out.println("default method inside interface");
    }
    default void mthdLambda3(){
        System.out.println("default method inside interface 3");
    }

}

interface Two {
    void anothermethod();
}

interface Add {
    int add(int a, int b);

}

interface Sub {
    int sub(int c, int d);
}


public class Lambda {

    public static void main(String[] args) {

        InterLambda intr = () -> System.out.println("this is lambda expression");
        intr.mthdLambda();
        intr.mthdLambda2();
        intr.mthdLambda3();

        Two two = () -> System.out.println("Method in interface Two");
        two.anothermethod();

        Add add = (a, b) -> a + b;
        System.out.println(add.add(2, 3));

        Sub sub = (a, b) -> (a - b);
        System.out.println(sub.sub(3, 2));


    }


}

