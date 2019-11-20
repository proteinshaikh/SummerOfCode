import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FinallyBlock {
    public static void main(String a[]){
        try{
            System.out.println("try");
            System.exit(0); //JVM will exit in this case or when JVM runs out of memory
        }
        catch(Exception e){
            System.out.println("catched" +e);
        }
        finally {
            System.out.println("finally");
        }


    }
}
