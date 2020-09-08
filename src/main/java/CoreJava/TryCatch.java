package CoreJava;

public class TryCatch {
    public static void main(String[] args) {
        //try and finally
        try {
            System.out.println("Try 1");
        } finally {
            System.out.println("This is finally 1 block");
        }

        //try and catch
        try {
            System.out.println("This is Try 2");
        } catch (Exception e) {
            System.out.println("This is Catch 2");
        } finally {
            try {
                System.out.println("This is Try 3");
            } finally {
                System.out.println("This is Finally 3");
            }

        }
    }
}
