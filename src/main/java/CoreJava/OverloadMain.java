package CoreJava;

public class OverloadMain {

    public static void main(String[] args) {
        System.out.println("test");
        main("zee", 25);
        OverloadMain ov = new OverloadMain();
        ov.main(2, "te");
    }

    public static void main(String b, int a) {
        System.out.println(b + a + "over");

    }

    public void main(int a, String b) {
        System.out.println(b + a + "over");
    }
}
