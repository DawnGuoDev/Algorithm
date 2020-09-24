package MethodFirst;

import java.util.Stack;

class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    public boolean recur(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }

        int rootVal = postorder[right];
        int begin;
        int temp ;
        for (begin = left; begin < right; begin++) {
            if (postorder[begin] > rootVal) {
                break;
            }
        }

        temp = begin;
        for (; temp < right; temp++) {
            if (postorder[temp] < rootVal) {
                return false;
            }
        }

        return recur(postorder, left, begin - 1) && recur(postorder, begin, right - 1);
    }
   
    public boolean verifyPostorder2(int[] postorder) {
        if (postorder.length == 0) {
            return true;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int max = Integer.MAX_VALUE;

        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > max) {
                return false;
            }    

            while (!stack.isEmpty() && stack.peek() >= postorder[i]) {
                max = stack.pop();
            }

            stack.push(postorder[i]);
        }

        return true;
    }
}
