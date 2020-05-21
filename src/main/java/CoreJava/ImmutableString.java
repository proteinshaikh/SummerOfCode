package CoreJava;

public class ImmutableString {
    public static void main(String[] args) {
        String str1 = "Zeeshan";
        String str2 = "Shaikh";
        System.out.println("hashcode for str1 before equalling : " + str1.hashCode());
        System.out.println("hashcode for str2 before equalling : " + str2.hashCode());
        System.out.println(str1);
        System.out.println(str2);
        System.out.println("uppercase surname : " +str2.toUpperCase());
        System.out.println(str2 = str1);
        System.out.println(str1 = str2);

        System.out.println("hashcode for str1 after equalling : " + str1.hashCode());
        System.out.println("hashcode for str2 after equalling : " + str2.hashCode());
        System.out.println(str1);
        System.out.println(str2);

        System.out.println("uppercase name : " +str1.toUpperCase());



    }
}
