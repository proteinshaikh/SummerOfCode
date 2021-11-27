package CoreJava.customException;

public class MyCustomCompileTimeException extends Exception{

    public MyCustomCompileTimeException(String message, Throwable cause){
        super(message, cause);
    }
}
