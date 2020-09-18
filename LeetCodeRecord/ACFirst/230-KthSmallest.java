package ACFirst;

class KthSmallest {
        
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int res = 0;
    public int k = 0;

    // 中序遍历的框架
    public int kthSmallest(TreeNode root, int k) {
        
        this.k = k;
        dfs(root);

        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);

        if (k == 0) {
            return;
        }

        if (--k == 0) {
            res = root.val;
            return;
        }

        dfs(root.right);
    }
}
