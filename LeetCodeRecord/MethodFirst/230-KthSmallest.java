package MethodFirst;

class KthSmallest {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            val = x;
        }
    }    

    public int k;
    public int res = 0;

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

        if (this.k == 0) {
            return;
        }

        if (--this.k == 0) {
            this.res = root.val;
        }

        dfs(root.right);
    } 
}
