package Top200;

class KthLargest {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int res = 0;
    public int k = 0;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }    

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        // 先遍历右子树
        dfs(root.right);

        // 遍历完右子树之后，判断 k 是否等于 0
        if (this.k == 0) {
            return;
        }

        // 相当于访问该节点
        if (--this.k == 0) {
            this.res = root.val;
            return;
        }        

        dfs(root.left);
    }
}
