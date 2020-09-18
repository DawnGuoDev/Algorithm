package ACFirst;

class ConvertBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }

        convertBST(root.right);
        
        this.sum += root.val;
        root.val = this.sum;
        
        convertBST(root.left);

        return root;
    }
}
