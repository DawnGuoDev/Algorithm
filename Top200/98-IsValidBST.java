package Top200;

import java.util.Stack;

class IsValidBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }    

    public boolean isValidBST(TreeNode root) {
        return recur(root, null, null);
    }

    // 这边改为 Integer 是因为测试例子中有 Integer.MAX_VALUE 的一个示例在
    public boolean recur(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
    
        int val = root.val;

        /*
        if (min == null && max != null && val >= max) {
            return false;
        }

        if (max == null && min != null && val <= min) {
            return false;
        }

        if (max != null && min != null && (val <= min || val >= max)) {
            return false;
        }
        */
        if (min != null && val <= min) {
            return false;
        }

        if (max != null && val >= max) {
            return false;
        }

        return recur(root.left, min, root.val) && recur(root.right, root.val, max);
    }

    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode curr = root;
        Integer pre = null;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();

                if (pre != null && pre >= curr.val) {
                    return false;
                }
                
                pre = curr.val;

                curr = curr.right;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
