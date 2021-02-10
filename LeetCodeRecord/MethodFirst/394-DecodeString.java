package MethodFirst;

import java.util.Stack;

class DecodeString {
    public String decodeString(String s) {
        String res = "";
        Stack<String[]> stack = new Stack<String[]>();
        int currMulti = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                currMulti = ch - '0';
            } else if (ch == '[') {
                stack.push(new String[]{currMulti+"", res});
                res = "";
            } else if (ch == ']') {
                String[] top = stack.pop();
                String temp = res;
                res += top[1];

                for (int j = 0; j < Integer.parseInt(top[0]); j++) {
                    res += temp; 
                }
            } else {
                res += ch;
            }
        }

        return res;
    }    
}
