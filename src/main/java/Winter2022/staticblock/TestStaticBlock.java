package Winter2022.staticblock;

public class TestStaticBlock {
    public static void main(String[] args) {
        System.out.println("This is main block");
    }

    static {
        System.out.println("This is static block");
    }
}