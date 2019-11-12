public class TryCatchTest {
    public static void main(String[] args) {
        TryCatchTest rt = new TryCatchTest();
        System.out.println(rt.returnTest());
    }


    String returnTest() {
        try {
            //System.out.println("Try block is executed");
            return "try";

        }
        //System.out.println("Try block is executed");
        catch (Exception e) {
            return "catch";
        } finally {
            //System.out.println("finally block is executed");
            return "finally";
        }
    }
}
