package Top200;

class IsBalanced {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    public boolean isBalanced2(TreeNode root) {
        if (recur(root) == -1) {
            return false;
        }

        return true;
    }

    public int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = recur(root.left);
        if (left == -1) {
            return -1;
        }
        
        int right = recur(root.right);
        if (right == -1) {
            return -1;
        }
        
        return Math.abs(left - right) >= 2 ? -1 : Math.max(left, right) + 1;
    } 
}
