package ACFirst;

import java.util.Stack;

class IsValid {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else if (ch == '(') {
                stack.push(')');
            } else if (stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }

        return stack.isEmpty();
    }    

    public static void main(String[] args) {
        IsValid iv = new IsValid();
        System.out.println(iv.isValid("()"));
        System.out.println(iv.isValid("(]"));
        System.out.println(iv.isValid("([)])"));
        System.out.println(iv.isValid(""));
    }
}
