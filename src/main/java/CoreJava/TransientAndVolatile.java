package CoreJava;

public class TransientAndVolatile {
    volatile String string = "sample volatile string";// always read values from main memory and not from cache
    transient String string1 = "sample transient string"; //we dont want this to be serialized
    public static void main(String[] args) {

        TransientAndVolatile transientAndVolatile  = new TransientAndVolatile();
        System.out.println(transientAndVolatile.string);
        System.out.println(transientAndVolatile.string1);
    }
}
