package CoreJava.customException;

public class CustomExceptionTestClass {

    public static void main(String[] args) throws Exception {
        // testCompileTimeMethod("zee");
        System.out.println(testRuntimeMethod(20, 20));

    }

    static String testCompileTimeMethod(String name) throws Exception {
        try {
            if (!name.equals("zeeshan")) {
                throw new MyCustomCompileTimeException("name is not equal to zeeshan", null);
            }
        } catch (MyCustomCompileTimeException mx) {
            System.out.println("MyCustomCompileTimeException caught!: " + mx);
        } catch (Exception ex) {
            throw new Exception("Exception caught");
        }
        return name;
    }

    static int testRuntimeMethod(int dividend, int divisor) throws CustomRuntimeException {
        int quotient = 0;
        try {
            quotient = dividend / divisor;
            if (quotient == 1) {
                throw new CustomRuntimeException(" quotient is 1", null);
            }
            return quotient;
        } catch (CustomRuntimeException cx) {
            System.out.println("CustomRuntimeException is thrown" + cx);
        } catch (ArithmeticException ax) {
            System.out.println("Arithmatic exception thrown " + ax);
        }
        return quotient;
    }
}
