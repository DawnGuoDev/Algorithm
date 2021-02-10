package MethodFirst;

import java.util.Stack;

class Calculate {
    public int calculate(String s) {
        Stack<Integer> numStack = new Stack<Integer>();
        Stack<Character> charStack = new Stack<Character>();
    
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                continue;
            }

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
                continue;
            }
            
            numStack.push(num);
            num = 0;

            while (!charStack.isEmpty() && !prCompare(charStack.peek(), ch)) {
                char temp = charStack.pop();
                int num2 = numStack.pop();
                int num1 = numStack.pop();

                int ans = calc(num1, num2, temp);

                numStack.push(ans);
            }

            charStack.push(ch);
        }
        numStack.push(num);

        while (!charStack.isEmpty()) {
            char temp = charStack.pop();
            int num2 = numStack.pop();
            int num1 = numStack.pop();
            
            int ans = calc(num1, num2, temp);

            numStack.push(ans);
        }

        return numStack.pop();
    }
    
    public int calc(int num1, int num2, char ch) {
        int ans = 0;

        switch (ch) {
            case '+':
                ans = num1 + num2;
                break;
            case '-':
                ans = num1 - num2;
                break;
            case '*':
                ans = num1 * num2;
                break;
            case '/':
                ans = num1 / num2;
                break;
            default:
                break;
        }

        return ans;
    }

    public boolean prCompare(char ch1, char ch2) {
        if ((ch1 == '+' || ch1 == '-') && (ch2 == '*' || ch2 == '/')) {
            return true;
        }      

        return false;
    }
}
