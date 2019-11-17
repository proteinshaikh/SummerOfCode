public class TryCatchTest {
    public static void main(String[] args) {
        TryCatchTest rt = new TryCatchTest();
        System.out.println(rt.returnTest());
    }


    private String returnTest() {
        try {
            //System.out.println("Try block is executed");
            return "try";

        }
        //System.out.println("Try block is executed");
        catch (Exception e) {
            return "catch";
        } finally {
            //System.out.println("finally block is executed");
            //return "finally";
            try {
                //System.out.println("Try block is executed");
                return "try2";

            }
            //System.out.println("Try block is executed");
            catch (Exception e) {
                return "catch2";
            } finally {
                //System.out.println("finally block is executed");
                return "finally2";

            }
        }
    }
}
