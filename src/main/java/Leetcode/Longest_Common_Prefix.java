package Leetcode;



// url: https://leetcode.com/problems/longest-common-prefix/
public class Longest_Common_Prefix {
    public static void main(String[] args) {
        Longest_Common_Prefix longestCommonPrefix = new Longest_Common_Prefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public String longestCommonPrefix(String [] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
}
