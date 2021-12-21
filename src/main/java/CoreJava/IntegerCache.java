package CoreJava;

public class IntegerCache {
    public static void main(String[] args) {
        Integer int1 = 1000, int2 = 1000;
        Integer int3 = 20, int4 = 20;
        System.out.println(int1 == int2);
        System.out.println(int3 == int4); //since 20 lies between -128 to 127 it will return true due to IntegerCache
    }

}
