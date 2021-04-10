package Algorithms;

public class RotatedisSubstring_1_9 {
    public static void main(String[] args) {
        int res= isRotation("waterbottle", "erbottlewat");
        if(res >= 0){
            System.out.println("Rotated Substring found");
        }else{
            System.out.println("Rotated Substring not found");
        }


    }

    static int isRotation(String s1, String s2) {
        int len = s1.length();
        if (len == s2.length() && len > 0) {
            String s1s1 = s1 + s1;
            return isSubstring(s2, s1s1);
        }
        return -1;
    }

    private static int isSubstring(String z1, String z2) {
        int len1 = z1.length();
        int len2 = z2.length();

        for (int i = 0; i <= len2 - len1; i++) {
            int j;
            for (j = 0; j < len1; j++)
                if (z2.charAt(i + j) != z1.charAt(j))
                    break;
            if (j == len1)
                return i;

        }
        return -1;

    }
}
