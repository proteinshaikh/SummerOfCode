package CoreJava.Inheritance;

interface M {

    String demo();

}

interface N {
    String demo();
}

public class InterfaceTest implements M, N {
    public static void main(String[] args) {
        InterfaceTest interfaceTest = new InterfaceTest();
        System.out.println(interfaceTest.demo());
    }


    @Override
    public String demo() {
        return "This is String";
    }


}
