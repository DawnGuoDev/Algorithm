package ACSecond;

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
        return dfs(root, null, null);
    }

    public boolean dfs(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min) {
            return false;
        }

        if (max != null && root.val >= max) {
            return false;
        }

        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }
    

    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        TreeNode prev = null;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = stack.pop();
                
                if (prev != null && prev.val >= temp.val) {
                    return false;
                }

                prev = temp;
                curr = temp.right;
            }
        }

        return true;
    }
}
