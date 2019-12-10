public class CatchExceptions {

    public static void main(String[] args) {
        CatchExceptions ce=new CatchExceptions();
        ce.arithmaticException();
        ce.exceptionArithmatic();
    }

    void arithmaticException() {
        try {
            int a = 10;
            int b = 0;
            int div = a / b;
            System.out.println(div);
        } catch (ArithmeticException ae) {
            System.out.println("Arithimitic exception : " + ae);
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
    }

    void exceptionArithmatic() {
        try {
            int a = 10;
            int b = 0;
            int div = a / b;
            System.out.println(div);
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
    }
}
