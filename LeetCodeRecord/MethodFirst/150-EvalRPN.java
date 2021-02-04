package MethodFirst;

import java.util.Stack;

class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();

        for (String tokenString : tokens) {
            if (isNumber(tokenString)) {
                stack.push(Integer.valueOf(tokenString));
                continue;
            }

            int num2 = stack.pop();
            int num1 = stack.pop();

            int res = 0;
            
            switch (tokenString) {
                case "+":
                    res = num1 + num2;
                    break;
                case "-":
                    res = num1 - num2;
                    break;
                case "/":
                    res = num1 / num2;
                    break;
                case "*":
                    res = num1 * num2;
                    break;
            }

            stack.push(res);
        }

        return stack.pop();
    }    

    public boolean isNumber(String token) {
        return !token.equals("+") && !token.equals("-") && !token.equals("/") && !token.equals("*");
    }
}
