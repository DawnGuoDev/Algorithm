package MethodFirst;

class DiameterOfBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            val = x;
        }
    }

    public int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        getDepth(root);

        return res;
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        if (this.res < left + right) {
            this.res = left + right;
        }

        return Math.max(left, right) + 1;
    }
}

