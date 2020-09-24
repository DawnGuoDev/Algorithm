package MethodFirst;

import java.util.Stack;

class IsValidBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            val = x;
        }
    }    

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        Integer preVal = null;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;                
            } else {
                TreeNode temp = stack.pop();
                
                if (preVal != null && temp.val <= preVal) {
                    return false;
                }

                preVal = temp.val;
                curr = temp.right;
            }
        }

        return true;
    }

    public boolean isValidBST2(TreeNode root) {
        return recur(root, null, null);
    }

    public boolean recur(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min) {
            return false;
        }

        if (max != null && root.val >= max) {
            return false;
        }

        return recur(root.left, min, root.val) && recur(root.right, root.val, max);
    }
}
