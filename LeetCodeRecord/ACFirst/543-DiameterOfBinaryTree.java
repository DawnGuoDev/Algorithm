package ACFirst;

class DiameterOfBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);

        return ans;
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        int temp = left + right;
        if (temp > ans) {
            ans = temp;
        }

        return Math.max(left, right) + 1;
    }
}
