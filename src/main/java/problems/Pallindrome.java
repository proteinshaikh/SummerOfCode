package problems;

//Question: check if the string is pallindrome or not
public class Pallindrome {
    public static void main(String[] args) {
        String string = "zee";
        char[] chars = new char[string.length()];
        
        int len = string.length()-1;
        char temp;
        for (int i = 0; i <=len; i++) {
           temp = string.charAt(i);
           chars[len-i] = temp;
        }
        String str = String.valueOf(chars);
        System.out.println(str);

        if(string.equals(str)){
            System.out.println("String" + string + " is pallindrome.");
        }else {
            System.out.println("String "  + string + " is not pallindrome.");
        }
    }
}
