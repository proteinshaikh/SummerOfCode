package CoreJava;

public class RuntimeTest {
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(" "+Runtime.getRuntime().freeMemory());
        System.out.println(" "+Runtime.getRuntime().totalMemory());
        System.out.println(" "+Runtime.getRuntime().availableProcessors());
        System.out.println(" "+Runtime.getRuntime().getClass());


    }
}
