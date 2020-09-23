package MethodFirst;

class KthLargest {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }
   
    public int k = 0;
    public int res = 0;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        recur(root);

        return res;
    }

    public void recur(TreeNode root) {
        if (root  == null) {
            return;
        }

        recur(root.right);

        if (this.k == 0) {
            return;
        }

        if (--this.k == 0) {
            this.res = root.val;
        }

        recur(root.left);
    } 
}
 