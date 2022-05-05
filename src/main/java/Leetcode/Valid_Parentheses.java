package Leetcode;

import java.util.Stack;

public class Valid_Parentheses {
    public static void main(String[] args) {
        Valid_Parentheses validParentheses = new Valid_Parentheses();
        System.out.println(validParentheses.isValid("()[]{}"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
