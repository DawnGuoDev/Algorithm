package MethodFirst;

import java.util.Stack;

class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<Integer>();
        int indexPop = 0;

        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[indexPop]) {
                stack.pop();
                indexPop++;
            }
        }

        return stack.isEmpty();
    }
}
