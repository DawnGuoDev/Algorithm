package Top200;

import java.util.Stack;

class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        return verifyRe(postorder, 0, postorder.length - 1);
    }

    public boolean verifyRe(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        } 

        int index = left;
        while (index < right) {
            if (postorder[index] > postorder[right]) {
                break;
            }
            index ++;
        }

        int mid = index;
        
        while (index < right) {
            if (postorder[index] < postorder[right]) {
                return false;
            }
            index ++;
        }

        return verifyRe(postorder, left, mid - 1) && verifyRe(postorder, mid, right-1);
    }

    // 单调栈的方法
    public boolean verifyPostorder2(int[] postorder) {
        Stack<Integer> stack = new Stack<Integer>();
        int pre = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (pre < postorder[i]) {
                return false;
            }

            while (!stack.isEmpty() && postorder[i] < stack.peek()) {
                pre = stack.pop();
            }

            stack.push(postorder[i]);
        }

        return true;
    }

    public static void main(String[] args) {
        VerifyPostorder vp = new VerifyPostorder();
        System.out.println(vp.verifyPostorder(new int[]{1, 6, 3, 2, 5}));
    }
}
