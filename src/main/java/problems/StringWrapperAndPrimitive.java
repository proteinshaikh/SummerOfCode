package problems;

public class StringWrapperAndPrimitive {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = new String(s1);
        String s3 = "HELLO";
        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s3));
        System.out.println(s1==s2);
    }
}
